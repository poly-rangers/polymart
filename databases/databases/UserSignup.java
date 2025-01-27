package databases;

import java.io.File;
import java.nio.charset.StandardCharsets;
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
                "username TEXT NOT NULL UNIQUE, " + // Ensure username is unique
                "first_name TEXT NOT NULL, " +
                "last_name TEXT NOT NULL, " +
                "email TEXT NOT NULL UNIQUE, " +    // Ensure email is unique
                "password TEXT NOT NULL" +
                ");";

        String createSellersTableSQL = "CREATE TABLE IF NOT EXISTS sellers (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT NOT NULL UNIQUE, " + // Ensure username is unique
                "first_name TEXT NOT NULL, " +
                "last_name TEXT NOT NULL, " +
                "email TEXT NOT NULL UNIQUE, " +    // Ensure email is unique
                "password TEXT NOT NULL" +
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

    // Method to save buyer or seller details into the appropriate table and create a folder
    public void saveUser(String username, String firstName, String lastName, String email, String password, String userType) {
        String insertSQL;
        String folderPrefix;

        // Determine the table and folder prefix based on user type
        if ("buyer".equalsIgnoreCase(userType)) {
            insertSQL = "INSERT INTO buyers (username, first_name, last_name, email, password) VALUES (?, ?, ?, ?, ?)";
            folderPrefix = "B";
        } else if ("seller".equalsIgnoreCase(userType)) {
            insertSQL = "INSERT INTO sellers (username, first_name, last_name, email, password) VALUES (?, ?, ?, ?, ?)";
            folderPrefix = "S";
        } else {
            System.out.println("Invalid user type.");
            return;
        }

        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            // Correct parameter order
            pstmt.setString(1, username);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, email);
            pstmt.setString(5, password);

            pstmt.executeUpdate();
            System.out.println(userType + " details saved successfully.");

            // Generate folder name and create the folder
            String folderName = generateFolderName(folderPrefix, email);
            createFolder(folderName);

        } catch (SQLException e) {
            if (e.getMessage().contains("UNIQUE constraint failed")) {
                System.out.println("Error: The username or email already exists. Please choose a unique value.");
            } else {
                System.out.println("Error saving user details: " + e.getMessage());
            }
        }
    }
    
    public boolean uniqueCheck(String username, String email) {
        // SQL query to check if the username or email already exists in either buyers or sellers table
        String checkSQL = "SELECT COUNT(*) FROM buyers WHERE username = ? OR email = ? " +
                          "UNION " +
                          "SELECT COUNT(*) FROM sellers WHERE username = ? OR email = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(checkSQL)) {
            // Set the parameters for both username and email
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setString(3, username);
            pstmt.setString(4, email);

            try (ResultSet rs = pstmt.executeQuery()) {
                // Check if any count is greater than 0 (indicating duplicate username or email)
                int totalCount = 0;
                while (rs.next()) {
                    totalCount += rs.getInt(1);  // Add the count from each table (buyers and sellers)
                }

                // If either username or email is already taken, return false
                if (totalCount > 0) {
                    return false;  // Either username or email is already in use
                }

                // If no duplicates found, return true indicating both are unique
                return true;

            }
        } catch (SQLException e) {
            System.out.println("Error checking uniqueness: " + e.getMessage());
            return false;  // Return false in case of an error
        }
    }



    // Method to generate a folder name with a hash
    private String generateFolderName(String prefix, String input) {
        try {
            // Create SHA-256 hash of the input
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            // Convert the hash to a hexadecimal string and get the first 7 characters
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            return prefix + hexString.substring(0, 7);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating folder name hash: " + e.getMessage());
        }
    }

    // Method to create a folder
    private void createFolder(String folderName) {
        File folder = new File("userFolders/" + folderName);
        if (folder.mkdirs()) {
            System.out.println("Folder created: " + folder.getAbsolutePath());
        } else {
            System.out.println("Failed to create folder: " + folder.getAbsolutePath());
        }
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
