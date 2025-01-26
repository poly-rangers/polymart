package buyer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BuyerDB {
    public static void addBuyer(String username, String firstName, String lastName, String email, String password) {
        String sql = "INSERT INTO buyerdb (username, first_name, last_name, email, password) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseManager.connect(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, email);
            pstmt.setString(5, password);
            pstmt.executeUpdate();
            System.out.println("Buyer added successfully!");
        } catch (SQLException e) {
            System.out.println("Error inserting data: " + e.getMessage());
        }
    }
}
