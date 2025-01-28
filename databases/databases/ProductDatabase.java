package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDatabase {
    private static final String DB_URL = "jdbc:sqlite:databases/products.db";
    private Connection connection;

    // Constructor to initialize the database connection
    public ProductDatabase() {
        try {
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("Connected to the products database.");
        } catch (SQLException e) {
            System.out.println("Error connecting to the products database: " + e.getMessage());
        }
    }

    // Method to create the products table
    public void createProductsTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS products (" +
                "product_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "seller_id TEXT NOT NULL, " +
                "product_name TEXT NOT NULL, " +
                "product_description TEXT, " +
                "price REAL NOT NULL, " +
                "quantity INTEGER NOT NULL, " +
                "FOREIGN KEY (seller_id) REFERENCES sellers(folder_path) ON DELETE CASCADE" +
                ");";

        try (PreparedStatement stmt = connection.prepareStatement(createTableSQL)) {
            stmt.execute();
            System.out.println("Products table is ready.");
        } catch (SQLException e) {
            System.out.println("Error creating products table: " + e.getMessage());
        }
    }

    // Method to add a product to the database
    public void addProduct(String sellerId, String productName, String productDescription, double price, int quantity) {
        String insertSQL = "INSERT INTO products (seller_id, product_name, product_description, price, quantity) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            pstmt.setString(1, sellerId);
            pstmt.setString(2, productName);
            pstmt.setString(3, productDescription);
            pstmt.setDouble(4, price);
            pstmt.setInt(5, quantity);

            pstmt.executeUpdate();
            System.out.println("Product added successfully for seller ID: " + sellerId);
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
}
