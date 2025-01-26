package buyer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:polymart.db"; // Path to your SQLite database

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

    public static void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS buyerdb (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT NOT NULL," +
                "first_name TEXT NOT NULL," +
                "last_name TEXT NOT NULL," +
                "email TEXT NOT NULL," +
                "password TEXT NOT NULL" +
                ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            // Execute the table creation SQL statement
            stmt.execute(createTableSQL);
            System.out.println("buyerdb table created or already exists.");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }
}
