package databases;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;

public class ProductDatabase {
    private static final String DB_URL = "jdbc:sqlite:databases/polyProducts.db";
    private static final String sellersDbUrl = "jdbc:sqlite:databases/polyUsers.db";
    private Connection connection, sellersConnection;
    private int imageCounter=1;
    private String userName = "";
    
    // Constructor to initialize the database connection
    public ProductDatabase() {
        try {
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("Connected to the products database.");
            createProductsTable();
            try {
            	sellersConnection = DriverManager.getConnection(sellersDbUrl);
                System.out.println("Connected to the sellers database.");
            } catch (SQLException e) {
                System.out.println("Error accessing the sellers database: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the products database: " + e.getMessage());
        }
    }
    

    // Method to create the products table
    public void createProductsTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS products (" +
                "product_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "folder_path TEXT, " +
                "product_name TEXT NOT NULL, " +
                "product_description TEXT, " +
                "price REAL NOT NULL, " +
                "product_status TEXT NOT NULL"+
                ");";

        try (PreparedStatement stmt = connection.prepareStatement(createTableSQL)) {
            stmt.execute();
            System.out.println("Products table is ready.");
        } catch (SQLException e) {
            System.out.println("Error creating products table: " + e.getMessage());
        }
    }

    // Method to add a product to the database
    public void addProduct(String folderPath, String productName, String productDescription, double price, String productStatus) {
    	// First, check if the folder_path exists in the sellers database
        if (!isValidSeller(folderPath)) {
            System.out.println("Error: Seller with folder path " + folderPath + " not found.");
            return;  // Exit early if seller is invalid
        }
    	
        String insertSQL = "INSERT INTO products (folder_path, product_name, product_description, price, product_status) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            pstmt.setString(1, folderPath);
            pstmt.setString(2, productName);
            pstmt.setString(3, productDescription);
            pstmt.setDouble(4, price);
            pstmt.setString(5, productStatus);

            pstmt.executeUpdate();
            System.out.println("Product added successfully for seller ID: " + folderPath);
        } catch (SQLException e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    // Method to close the database connection
    public void close() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection to products database closed.");
            } catch (SQLException e) {
                System.out.println("Error closing products database connection: " + e.getMessage());
            }
        }
    }
    
    public String getSellerHashByUsername(String sellerUsername) {
        String query = "SELECT folder_path FROM sellers WHERE username = ?";
        try (PreparedStatement stmt = sellersConnection.prepareStatement(query)) {
            stmt.setString(1, sellerUsername);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("folder_path");  // Return the seller's folder path (which is the hash)
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Return null if no match is found
    }

    public void saveUploadedImageForSeller(String sellerUsername, File uploadedImage) {
     // Use the correct connection here (sellersConnection)
        String query = "SELECT folder_path FROM sellers WHERE username = ?";
        try (PreparedStatement pstmt = sellersConnection.prepareStatement(query)) {
            pstmt.setString(1, sellerUsername);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String folderPath = rs.getString("folder_path");

                    // Create a folder path for storing the uploaded image
                    File sellerFolder = new File("usersFolders/" + folderPath);
                    if (!sellerFolder.exists()) {
                        if (!sellerFolder.mkdirs()) {
                            System.out.println("Failed to create directory: " + sellerFolder.getAbsolutePath());
                            return;
                        }
                    }

                    // Generate the new image name based on the seller folder path and image extension
                    String fileExtension = getFileExtension(uploadedImage);
                    userName = UserSession.getLoggedInUsername();
                    
                    String newImageName = "image_"+imageCounter+"_"+userName;
                    if (!fileExtension.isEmpty()) {
                        newImageName += "." + fileExtension;
                    }
                    
                    imageCounter++;
                    
                    // Create a destination file object
                    File destinationImage = new File(sellerFolder, newImageName);

                    // If the file already exists, append "_int" to the name
                    if (destinationImage.exists()) {
                        newImageName = "image_"+imageCounter;
                        destinationImage = new File(sellerFolder, newImageName + "." + fileExtension);
                    }

                    // Check write permissions for the destination folder
                    if (!destinationImage.getParentFile().canWrite()) {
                        System.out.println("No write permission for directory: " + destinationImage.getParentFile().getAbsolutePath());
                        return;
                    }

                    // Copy the uploaded image to the destination folder
                    try {
                        Files.copy(uploadedImage.toPath(), destinationImage.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Image uploaded successfully to: " + destinationImage.getAbsolutePath());
                    } catch (IOException e) {
                        System.out.println("Error saving uploaded image: " + e.getMessage());
                    }
                } else {
                    System.out.println("Error: Seller not found in the database.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving folder path: " + e.getMessage());
        }

    }

    // Helper to get file extension
    private String getFileExtension(File file) {
        String fileName = file.getName();
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex > 0 && lastDotIndex < fileName.length() - 1) {
            return fileName.substring(lastDotIndex + 1);
        }
        return "";
    }
    
 // Helper method to check if the seller exists
    private boolean isValidSeller(String folderPath) {
        String query = "SELECT folder_path FROM sellers WHERE folder_path = ?";
        try (PreparedStatement stmt = sellersConnection.prepareStatement(query)) {
            stmt.setString(1, folderPath);
            ResultSet rs = stmt.executeQuery();

            return rs.next();  // If any row is returned, the seller exists
        } catch (SQLException e) {
            System.out.println("Error checking seller: " + e.getMessage());
        }
        return false;  // Seller does not exist
    }
}
