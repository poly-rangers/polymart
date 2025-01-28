package databases;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSignup {
    private static final String DB_URL = "jdbc:sqlite:databases/polyUsers.db";
    private Connection connection;

    // Constructor to initialize the database connection
    public UserSignup() {
        try {
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("Connected to the polyUsers database.");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    // Method to create tables for buyers and sellers if they don't exist
    public void createTables() {
        String createBuyersTableSQL = "CREATE TABLE IF NOT EXISTS buyers (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT NOT NULL UNIQUE, " +
                "first_name TEXT NOT NULL, " +
                "last_name TEXT NOT NULL, " +
                "email TEXT NOT NULL UNIQUE, " +
                "password TEXT NOT NULL, " +
                "folder_path TEXT" + 
                ");";

        String createSellersTableSQL = "CREATE TABLE IF NOT EXISTS sellers (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT NOT NULL UNIQUE, " +
                "first_name TEXT NOT NULL, " +
                "last_name TEXT NOT NULL, " +
                "email TEXT NOT NULL UNIQUE, " +
                "password TEXT NOT NULL, " +
                "folder_path TEXT" + 
                ");";

        try (PreparedStatement stmt = connection.prepareStatement(createBuyersTableSQL);
             PreparedStatement stmt2 = connection.prepareStatement(createSellersTableSQL)) {
            stmt.execute();
            stmt2.execute();
            System.out.println("Buyers and Sellers tables are ready.");
        } catch (SQLException e) {
            System.out.println("Error creating tables: " + e.getMessage());
        }
    }

    // Method to save user details
    public void saveUser(String username, String firstName, String lastName, String email, String password, String userType) {
        String insertSQL;
        String folderPrefix;

        // Determine the table and folder prefix based on user type
        if ("buyer".equalsIgnoreCase(userType)) {
            insertSQL = "INSERT INTO buyers (username, first_name, last_name, email, password, folder_path) VALUES (?, ?, ?, ?, ?, ?)";
            folderPrefix = "B";
        } else if ("seller".equalsIgnoreCase(userType)) {
            insertSQL = "INSERT INTO sellers (username, first_name, last_name, email, password, folder_path) VALUES (?, ?, ?, ?, ?, ?)";
            folderPrefix = "S";
        } else {
            System.out.println("Invalid user type.");
            return;
        }

        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            // Generate folder name
            String folderName = generateFolderName(folderPrefix, email);

            // Create 'usersFolders' directory if it doesn't exist
            File usersFoldersDir = new File("usersFolders");
            if (!usersFoldersDir.exists()) {
                boolean dirCreated = usersFoldersDir.mkdirs();
                if (!dirCreated) {
                    System.out.println("Failed to create the 'usersFolders' directory.");
                    return;
                }
            }

            // Create the hashed folder inside 'usersFolders'
            File userFolder = new File(usersFoldersDir, folderName);
            if (!userFolder.exists()) {
                boolean folderCreated = userFolder.mkdirs();
                if (!folderCreated) {
                    System.out.println("Failed to create user folder: " + userFolder.getAbsolutePath());
                    return;
                }
            }

            // Store the folder path in the database
            pstmt.setString(1, username);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, email);
            pstmt.setString(5, password);
            pstmt.setString(6, folderName);  // Store relative path to 'usersFolders'

            pstmt.executeUpdate();
            System.out.println(userType + " details saved successfully. Folder path: usersFolders/" + folderName);

        } catch (SQLException e) {
            if (e.getMessage().contains("UNIQUE constraint failed")) {
                System.out.println("Error: The username or email already exists. Please choose a unique value.");
            } else {
                System.out.println("Error saving user details: " + e.getMessage());
            }
        }
    }

    // Method to check if the username and email are unique
    public boolean uniqueCheck(String username, String email) {
        String checkSQL = "SELECT COUNT(*) FROM buyers WHERE username = ? OR email = ? " +
                          "UNION " +
                          "SELECT COUNT(*) FROM sellers WHERE username = ? OR email = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(checkSQL)) {
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setString(3, username);
            pstmt.setString(4, email);

            try (ResultSet rs = pstmt.executeQuery()) {
                int totalCount = 0;
                while (rs.next()) {
                    totalCount += rs.getInt(1);  // Add the count from each table (buyers and sellers)
                }
                return totalCount == 0;  // No duplicates found
            }
        } catch (SQLException e) {
            System.out.println("Error checking uniqueness: " + e.getMessage());
            return false;
        }
    }

    // Method to generate a folder name with a hash
    private String generateFolderName(String prefix, String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            return prefix + hexString.substring(0, 7);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating folder name hash: " + e.getMessage());
        }
    }

    // Method to save uploaded file
    public void saveUploadedFile(String username, String userType, File uploadedFile) {
        String selectSQL;

        if ("buyer".equalsIgnoreCase(userType)) {
            selectSQL = "SELECT folder_path FROM buyers WHERE username = ?";
        } else if ("seller".equalsIgnoreCase(userType)) {
            selectSQL = "SELECT folder_path FROM sellers WHERE username = ?";
        } else {
            System.out.println("Invalid user type.");
            return;
        }

        try (PreparedStatement pstmt = connection.prepareStatement(selectSQL)) {
            pstmt.setString(1, username);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String folderPath = rs.getString("folder_path");

                    File userFolder = new File("usersFolders/" + folderPath);
                    if (!userFolder.exists()) {
                        if (!userFolder.mkdirs()) {
                            System.out.println("Failed to create directory: " + userFolder.getAbsolutePath());
                            return;
                        }
                    }

                    String newFileName = "COR_" + folderPath;
                    String fileExtension = getFileExtension(uploadedFile);
                    if (!fileExtension.isEmpty()) {
                        newFileName += "." + fileExtension;
                    }

                    File destinationFile = new File(userFolder, newFileName);

                    if (destinationFile.exists()) {
                        newFileName = "COR_" + folderPath + "_new";
                        destinationFile = new File(userFolder, newFileName + "." + fileExtension);
                    }

                    if (!destinationFile.getParentFile().canWrite()) {
                        System.out.println("No write permission for directory: " + destinationFile.getParentFile().getAbsolutePath());
                        return;
                    }

                    try {
                        Files.copy(uploadedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("File uploaded successfully to: " + destinationFile.getAbsolutePath());
                    } catch (IOException e) {
                        System.out.println("Error saving uploaded file: " + e.getMessage());
                    }
                } else {
                    System.out.println("Error: User not found in the database.");
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

    // Method to close the database connection
    public void close() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
