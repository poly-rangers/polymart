package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserSignup {
    private static final String DB_URL = "jdbc:sqlite:databases/polyUsers.db";
    private Connection connection;

    // Constructor to initialize the database connection
    public UserSignup() {
        try {
            // Establish the connection to the database
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
                "username TEXT NOT NULL, " +
                "first_name TEXT NOT NULL, " +
                "last_name TEXT NOT NULL, " +
                "email TEXT NOT NULL, " +
                "password TEXT NOT NULL" +
                ");";

        String createSellersTableSQL = "CREATE TABLE IF NOT EXISTS sellers (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT NOT NULL, " +
                "first_name TEXT NOT NULL, " +
                "last_name TEXT NOT NULL, " +
                "email TEXT NOT NULL, " +
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

    // Method to save buyer or seller details into the appropriate table
    public void saveUser(String firstName, String lastName, String email, String username, String password, String userType) {
        String insertSQL;
        
        // Conditional to determine which table to insert into
        if ("buyer".equalsIgnoreCase(userType)) {
            insertSQL = "INSERT INTO buyers (username, first_name, last_name, email, password) " +
                        "VALUES (?, ?, ?, ?, ?)";
        } else if ("seller".equalsIgnoreCase(userType)) {
            insertSQL = "INSERT INTO sellers (username, first_name, last_name, email, password) " +
                        "VALUES (?, ?, ?, ?, ?)";
        } else {
            System.out.println("Invalid user type.");
            return;
        }

        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, email);
            pstmt.setString(4, username);
            pstmt.setString(5, password);
            
            pstmt.executeUpdate();
            System.out.println(userType + " details saved successfully.");
        } catch (SQLException e) {
            System.out.println("Error saving user details: " + e.getMessage());
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

