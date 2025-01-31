package seller;
import frames.CustomDialog;
import misc.RoundedButton;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.*;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

import databases.UserSignIn;

public class SellerSignInPanel extends JPanel implements ActionListener{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheckBox;
    private JButton signUpButton;
    private JButton logInButton;
    
    public SellerSignInPanel(JPanel contentPane) {
        this.contentPane = contentPane;
        
        setBackground(new Color(255, 255, 255));
        setBounds(100, 100, 414, 660);
        setLayout(null); 

        // Icon next to header title
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_seller.icon.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        startupImage.setBounds(16, 24, 150, 47); 
        add(startupImage);

        // Sign-in label
        JLabel signInLabel = new JLabel("Welcome back,");
        signInLabel.setForeground(Color.BLACK);
        signInLabel.setFont(new Font("Montserrat", Font.BOLD, 22));
//        signInLabel.setHorizontalAlignment(SwingConstants.WEST);
        signInLabel.setBounds(89, 99, 212, 30); 
        add(signInLabel);
        
        JLabel signInUser = new JLabel("payaman!");
        signInUser.setForeground(new Color(115, 12, 12));
        signInUser.setFont(new Font("Montserrat", Font.ITALIC, 20));
        signInUser.setBounds(89, 120, 166, 30); 
        add(signInUser);
        

        // Username Field
        usernameField = new JTextField("Username");
        setupTextFieldPlaceholder(usernameField, "Username");
        usernameField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        usernameField.setForeground(new Color(192, 192, 192));
        usernameField.setFont(new Font("Montserrat", Font.PLAIN, 12));
        usernameField.setBounds(89, 170, 235, 20); 
        add(usernameField);

        // Password Field
        passwordField = new JPasswordField("Password");
        passwordField.setColumns(10);
        passwordField.setFont(new Font("Montserrat", Font.PLAIN, 12));
        setupPasswordFieldPlaceholder(passwordField);
        passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        passwordField.setBounds(89, 199, 235, 20); 
        add(passwordField);

        // Add "Show Password" checkbox
        showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setBackground(Color.WHITE);
        showPasswordCheckBox.setFont(new Font("Montserrat", Font.PLAIN, 12));
        showPasswordCheckBox.setFocusable(false);
        showPasswordCheckBox.setFocusPainted(false);
        showPasswordCheckBox.addActionListener(this);
        showPasswordCheckBox.setBounds(89, 230, 235, 20); 
        add(showPasswordCheckBox);

        // Log In Button
        logInButton = new RoundedButton("Log In", 45);
        logInButton.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 16));
        logInButton.setBorderPainted(false);
        logInButton.setBorder(new LineBorder(new Color(0, 0, 0)));
        logInButton.setBackground(new Color(115, 12, 12));
        logInButton.setForeground(new Color(255, 255, 255));
        logInButton.addActionListener(this);
        logInButton.setBounds(89, 275, 235, 45);
        add(logInButton);

        // "New to Polymart?" Label
        JLabel newToPolymartLabel = new JLabel("New to Polymart?");
        newToPolymartLabel.setFont(new Font("Montserrat SemiBold", Font.BOLD | Font.ITALIC, 12));
        newToPolymartLabel.setHorizontalAlignment(SwingConstants.CENTER);
        newToPolymartLabel.setBounds(99, 331, 225, 20); 
        add(newToPolymartLabel);

        // Sign up here button
        signUpButton = new JButton("<html><u>Sign up here</u></html>");
        signUpButton.setOpaque(false);
        signUpButton.setFocusable(false);
        signUpButton.setFocusPainted(false);
        signUpButton.setBorderPainted(false);
        signUpButton.setContentAreaFilled(false);
        signUpButton.setForeground(new Color(128, 0, 0));
        signUpButton.setFont(new Font("Montserrat SemiBold", Font.BOLD, 11));
        signUpButton.addActionListener(this);
        signUpButton.setBounds(89, 348, 235, 20); 
        add(signUpButton);
    }
    
    //Checks if the field is empty
    private boolean checkIfEmpty() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        if (username.isEmpty() || username.equals("Username")) {
        	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        	new CustomDialog(frame, "Username field empty", "nhak okay ka lang ba... di mo kasi nalagyan ng username... di gagana ean bhe", "sorry po..");
            return false;
        }

        if (password.isEmpty() || password.equals("Password")) {
        	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        	new CustomDialog(frame, "Password field empty", "nhak okay ka lang ba... di mo kasi nalagyan ng password... di gagana ean bhe", "sorry po..");
            return false;
        }

        return true; // All fields are valid
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == showPasswordCheckBox) {
            if (showPasswordCheckBox.isSelected()) {
                passwordField.setEchoChar((char) 0); // Show password
            } else {
                passwordField.setEchoChar('*'); // Hide password
            }
        } else if (source == signUpButton) {
        	clearTextFields();
            CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "SellerSignupPanel");
        } else if (source == logInButton) {
        	// Check for empty fields before proceeding
            if (checkIfEmpty()) {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();

                //Call method to validate login info
                validateLogin(username, password);
            }
        }
    }
    
    private void validateLogin(String username, String password) {
        String userType = "seller";  // Assuming it's for buyer, you can change this dynamically for sellers if needed
        UserSignIn userSignIn = new UserSignIn();

        // Debugging: Print the username and password being passed
        System.out.println("Attempting login for username: " + username);
        System.out.println("Attempting login with password: " + password);

        // Call the validateLogin method from UserSignIn class
        boolean isValid = userSignIn.validateLogin(username, password, userType);

        if (isValid) {
            // Show success message
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            new CustomDialog(frame, "Login success!", "Welcome to the fam, baks! We're glad to have you here on Polymart <3 Feel free to scroll and explore our dashboard ^__^", "Thank you!");
            clearTextFields();
            // Switch to DashboardPanel
            CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "SellerDashboardPanel");
        } else {
            // Show failure message
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            new CustomDialog(frame, "You're WRONG!", "mali username mo or password mo - ewan ko sau te ulitin mo yan", "Try Again");
        }

        userSignIn.close();  // Don't forget to close the connection
    }

    private void setupTextFieldPlaceholder(JTextField textField, String placeholder) {
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(placeholder);
                }
            }
        });
        textField.setForeground(Color.GRAY);
    }

    private void setupPasswordFieldPlaceholder(JPasswordField passwordField) {
        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals("Password")) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.BLACK);
                    passwordField.setEchoChar('*');
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).isEmpty()) {
                    passwordField.setForeground(Color.GRAY);
                    passwordField.setText("Password");
                    passwordField.setEchoChar((char) 0);
                }
            }
        });
        passwordField.setForeground(new Color(192, 192, 192));
        passwordField.setEchoChar((char) 0);
    }
    
    private void clearTextFields() {
        // Reset text fields to their placeholder values
        usernameField.setText("Username");
        usernameField.setForeground(Color.GRAY);

        passwordField.setText("Password");
        passwordField.setForeground(Color.GRAY);
        passwordField.setEchoChar((char) 0);  // Reset password echo char for the placeholder
    }
}