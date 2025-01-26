package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:polymart.db";

    // Method to establish the database connection
    public static Connection connect() {
        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");
            // Establish the connection
            Connection conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");
            return conn;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error connecting to SQLite: " + e.getMessage());
        }
        return null;
    }

    // Method to create all the tables
    public static void createTables() {
        // SQL for creating the buyerdb table
        String createBuyerTableSQL = "CREATE TABLE IF NOT EXISTS buyerdb (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT NOT NULL," +
                "first_name TEXT NOT NULL," +
                "last_name TEXT NOT NULL," +
                "email TEXT NOT NULL," +
                "password TEXT NOT NULL" +
                ");";

        // SQL for creating the sellerdb table
        String createSellerTableSQL = "CREATE TABLE IF NOT EXISTS sellerdb (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "shop_name TEXT NOT NULL," +
                "first_name TEXT NOT NULL," +
                "last_name TEXT NOT NULL," +
                "email TEXT NOT NULL," +
                "password TEXT NOT NULL" +
                ");";

        // SQL for creating the productdb table
        String createProductTableSQL = "CREATE TABLE IF NOT EXISTS productdb (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "product_id TEXT NOT NULL," +
                "product_name TEXT NOT NULL," +
                "price REAL NOT NULL," +
                "ratings REAL," +
                "description TEXT," +
                "shop_name TEXT NOT NULL," +
                "variations TEXT," +
                "mode_of_payment TEXT," +
                "meetup_place TEXT," +
                "meetup_time DATETIME" +
                ");";

        // SQL for creating the meetupdb table
        String createMeetupTableSQL = "CREATE TABLE IF NOT EXISTS meetupdb (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "order_details TEXT," +
                "product_name TEXT," +
                "total_price REAL," +
                "buyer_username TEXT NOT NULL," +
                "seller_shop_name TEXT NOT NULL," +
                "time_and_date DATETIME," +
                "place TEXT," +
                "status TEXT" +
                ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            // Execute all the table creation SQL statements
            stmt.execute(createBuyerTableSQL);
            stmt.execute(createSellerTableSQL);
            stmt.execute(createProductTableSQL);
            stmt.execute(createMeetupTableSQL);
            System.out.println("All tables created or already exist.");
        } catch (SQLException e) {
            System.out.println("Error creating tables: " + e.getMessage());
        }
    }

	
}
