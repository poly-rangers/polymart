package databases;

import java.sql.*;

public class UserSignIn {
    private static final String DB_URL = "jdbc:sqlite:databases/polyUsers.db";
    private Connection connection;

    public UserSignIn() {
        try {
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("Connected to the polyUsers database.");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    public boolean validateLogin(String username, String password, String userType) {
        String sql = "";

        userType = userType.trim().toLowerCase();

        if ("buyer".equals(userType)) {
            sql = "SELECT * FROM buyers WHERE username = ? AND password = ?";
        } else if ("seller".equals(userType)) {
            sql = "SELECT * FROM sellers WHERE username = ? AND password = ?";
        } else {
            System.out.println("Invalid user type: " + userType);
            return false;
        }

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, username.trim());
            pstmt.setString(2, password.trim());

            System.out.println("Executing query: " + sql);
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
            	UserSession.setLoggedInUsername(username);
                System.out.println(userType + " login successful for: " + username);
                return true;
            } else {
                System.out.println(userType + " login failed: Invalid credentials.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error during authentication: " + e.getMessage());
            return false;
        }
    }

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
    
    public String getSellerFolderPathByUsername(String username) {
        String query = "SELECT folder_path FROM sellers WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("folder_path");  // Return the seller's folder path (hash)
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if no match is found
    }

}