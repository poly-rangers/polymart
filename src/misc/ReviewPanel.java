package misc;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class ReviewPanel extends RoundedPanel {
    private static final long serialVersionUID = 3336119340908215674L;
    private JLabel lblUsername;
    private JTextArea reviewText;

    public ReviewPanel(int cornerRadius, Color backgroundColor, String userName, String reviewContent) {
        super(cornerRadius, backgroundColor);

        setLayout(null); // Layout set to null for manual positioning

        // Profile icon
        ImageIcon profileImage = new ImageIcon(this.getClass().getResource("/profileiconGRAY.png"));
        JLabel profileIcon = new JLabel(profileImage);
        profileIcon.setBounds(10, 12, 24, 24);
        add(profileIcon);
        
        // Username label
        lblUsername = new JLabel("@" + userName + " says:");
        lblUsername.setFont(new Font("Montserrat", Font.ITALIC, 11));
        lblUsername.setBounds(44, 12, 261, 15);
        add(lblUsername);
        
        // Review content
        reviewText = new JTextArea(reviewContent);
        reviewText.setFont(new Font("Montserrat", Font.PLAIN, 10));
        reviewText.setLineWrap(true);
        reviewText.setWrapStyleWord(true);
        reviewText.setEditable(false);
        reviewText.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        reviewText.setOpaque(false);
        reviewText.setBorder(null);
        reviewText.setBounds(44, 28, 261, 50); // Adjust the bounds for the text area
        add(reviewText);
    }
}
