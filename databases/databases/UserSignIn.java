package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSignIn {
    private static final String DB_URL = "jdbc:sqlite:databases/polyUsers.db";
    private Connection connection;

    // Constructor to initialize the database connection
    public UserSignIn() {
        try {
            // Establish the connection to the database
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("Connected to the polyUsers database.");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    // Method to validate the user login credentials
    public boolean validateLogin(String username, String password, String userType) {
        String sql = "";
        
        // Log inputs
        System.out.println("Validating login for: " + username + ", " + password);

        // Conditional to check which table to query (buyer or seller)
        if ("buyer".equalsIgnoreCase(userType)) {
            sql = "SELECT * FROM buyers WHERE username = ? AND password = ?";
        } else if ("seller".equalsIgnoreCase(userType)) {
            sql = "SELECT * FROM sellers WHERE username = ? AND password = ?";
        } else {
            System.out.println("Invalid user type.");
            return false;
        }

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, username.trim());
            pstmt.setString(2, password.trim());

            // Log query before executing
            System.out.println("Executing query: " + sql);
            System.out.println("With parameters: username = '" + username.trim() + "', password = '" + password.trim() + "'");

            // Execute the query and check if a record exists
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // User found, valid login
                System.out.println("Login successful!");
                return true;
            } else {
                // Invalid login (incorrect username or password)
                System.out.println("Login failed: Invalid credentials.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error during authentication: " + e.getMessage());
            return false;
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

