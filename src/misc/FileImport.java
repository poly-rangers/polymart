package misc;

import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.sql.*;

public class FileImport {

    private static final String DB_URL = "jdbc:sqlite:databases/polyUsers.db";

    // Method to open file chooser and save the selected file to the user's hashed folder
    public void importPdfFile(String username, String userFolderName) {
        // Create a JFileChooser that only accepts .pdf files
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a PDF file");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("PDF Files", "pdf"));

        // Show the file chooser dialog
        int result = fileChooser.showOpenDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            // Check if the selected file is a PDF
            if (selectedFile.getName().endsWith(".pdf")) {
                // Get the destination folder path
                File destinationFolder = new File("userFolders/" + userFolderName);

                // Ensure the folder exists
                if (!destinationFolder.exists()) {
                    destinationFolder.mkdirs();  // Create the folder if it doesn't exist
                }

                // Create the destination file path (same name as original)
                File destinationFile = new File(destinationFolder, selectedFile.getName());

                try {
                    // Copy the file to the hashed folder
                    Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("PDF file has been imported successfully: " + destinationFile.getAbsolutePath());

                    // Update the file path in the database
                    updateFilePathInDatabase(username, destinationFile.getAbsolutePath());

                } catch (IOException e) {
                    System.out.println("Error saving the file: " + e.getMessage());
                }
            } else {
                // Inform the user if they didn't select a PDF
                JOptionPane.showMessageDialog(null, "Please select a valid PDF file!", "Invalid File", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("File selection was cancelled.");
        }
    }

    // Method to update the file path in the database
    private void updateFilePathInDatabase(String username, String filePath) {
        String updateSQL = "UPDATE buyers SET file_path = ? WHERE username = ?;";  // Use 'buyers' table, adjust as needed

        // If the user is a seller, use a different table
        // String updateSQL = "UPDATE sellers SET file_path = ? WHERE username = ?;";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = connection.prepareStatement(updateSQL)) {
            pstmt.setString(1, filePath);
            pstmt.setString(2, username);
            pstmt.executeUpdate();
            System.out.println("Database updated with file path.");
        } catch (SQLException e) {
            System.out.println("Error updating the database: " + e.getMessage());
        }
    }
}

