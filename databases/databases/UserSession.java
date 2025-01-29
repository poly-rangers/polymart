package databases;

public class UserSession {
    // Static variable to store logged-in username
    private static String loggedInUsername;

    // Method to set logged-in username (called during login)
    public static void setLoggedInUsername(String username) {
        loggedInUsername = username;
    }

    // Method to get logged-in username
    public static String getLoggedInUsername() {
        if (loggedInUsername == null) {
            System.out.println("No user is logged in.");
            return null;
        }
        return loggedInUsername;
    }
}
