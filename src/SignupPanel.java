import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SignupPanel extends JPanel implements ActionListener {

	private JPanel contentPane;
    private static final long serialVersionUID = 1L;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField txtEmailOrPhone;
    private JPasswordField password;
    private JLabel chooseFile;
    private JButton questionLink;
    private JButton signUpButton;
    private JButton signInButton;
    private JTextField txtUsername;
    private JCheckBox chckbxTermsConditions;
    
    public SignupPanel(JPanel contentPane) {
    	this.contentPane = contentPane;
    	
        setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        SpringLayout panelLayout = new SpringLayout();
        setLayout(panelLayout);

        // Header title
        JLabel headerTitle = new JLabel("POLYMART");
        panelLayout.putConstraint(SpringLayout.NORTH, headerTitle, 49, SpringLayout.NORTH, this); // Positioned at the top
        panelLayout.putConstraint(SpringLayout.SOUTH, headerTitle, 10, SpringLayout.NORTH, this);
        headerTitle.setForeground(new Color(0x730C0C));
        headerTitle.setFont(new Font("Montserrat ExtraBold", Font.PLAIN, 15));
        add(headerTitle);

        // Icon next to header title
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_icon.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        panelLayout.putConstraint(SpringLayout.NORTH, startupImage, 38, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.EAST, startupImage, -355, SpringLayout.EAST, this);
        add(startupImage);

        // Sign-up label
        JLabel signUpLabel = new JLabel("Sign Up");
        panelLayout.putConstraint(SpringLayout.EAST, headerTitle, 26, SpringLayout.EAST, signUpLabel);
        panelLayout.putConstraint(SpringLayout.SOUTH, headerTitle, -49, SpringLayout.NORTH, signUpLabel);
        panelLayout.putConstraint(SpringLayout.NORTH, signUpLabel, 119, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, signUpLabel, 35, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, signUpLabel, 166, SpringLayout.WEST, this);
        signUpLabel.setForeground(Color.BLACK);
        signUpLabel.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 24));
        signUpLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(signUpLabel);

        // User name
    	txtUsername = new JTextField("Username");
    	setupTextFieldPlaceholder(txtUsername, "Username");
    	txtUsername.setForeground(Color.GRAY);
    	txtUsername.setFont(new Font("Montserrat", Font.PLAIN, 12));
    	txtUsername.setColumns(10);
    	txtUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
    	add(txtUsername);
        
        // First name
        firstName = new JTextField("First Name");
        panelLayout.putConstraint(SpringLayout.WEST, txtUsername, 0, SpringLayout.WEST, firstName);
        panelLayout.putConstraint(SpringLayout.SOUTH, txtUsername, -12, SpringLayout.NORTH, firstName);
        panelLayout.putConstraint(SpringLayout.EAST, txtUsername, 0, SpringLayout.EAST, firstName);
        setupTextFieldPlaceholder(firstName, "First Name");
        panelLayout.putConstraint(SpringLayout.NORTH, firstName, 207, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, firstName, 85, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, firstName, -94, SpringLayout.EAST, this);
        firstName.setFont(new Font("Montserrat", Font.PLAIN, 12));
        firstName.setColumns(10);
        firstName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        add(firstName);

        // Last name
        lastName = new JTextField("Last Name");
        setupTextFieldPlaceholder(lastName, "Last Name");
        panelLayout.putConstraint(SpringLayout.SOUTH, firstName, -16, SpringLayout.NORTH, lastName);
        panelLayout.putConstraint(SpringLayout.NORTH, lastName, 242, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, lastName, 85, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, lastName, -94, SpringLayout.EAST, this);
        lastName.setFont(new Font("Montserrat", Font.PLAIN, 12));
        lastName.setColumns(10);
        lastName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        add(lastName);

        // Email or phone
        txtEmailOrPhone = new JTextField("Email or Phone");
        setupTextFieldPlaceholder(txtEmailOrPhone, "Email or Phone");
        panelLayout.putConstraint(SpringLayout.NORTH, txtEmailOrPhone, 275, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, txtEmailOrPhone, -366, SpringLayout.SOUTH, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, lastName, -14, SpringLayout.NORTH, txtEmailOrPhone);
        panelLayout.putConstraint(SpringLayout.WEST, txtEmailOrPhone, 85, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, txtEmailOrPhone, -94, SpringLayout.EAST, this);
        txtEmailOrPhone.setFont(new Font("Montserrat", Font.PLAIN, 12));
        txtEmailOrPhone.setColumns(10);
        txtEmailOrPhone.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        add(txtEmailOrPhone);

        // Password
        password = new JPasswordField("Password");
        password.setFont(new Font("Montserrat", Font.PLAIN, 12));
        setupPasswordFieldPlaceholder(password);
        panelLayout.putConstraint(SpringLayout.NORTH, password, 13, SpringLayout.SOUTH, txtEmailOrPhone);
        panelLayout.putConstraint(SpringLayout.WEST, password, 0, SpringLayout.WEST, firstName);
        panelLayout.putConstraint(SpringLayout.SOUTH, password, -334, SpringLayout.SOUTH, this);
        panelLayout.putConstraint(SpringLayout.EAST, password, -94, SpringLayout.EAST, this);
        password.setColumns(10);
        password.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        add(password);

        // Upload COR
        JLabel uplCOR = new JLabel("Upload your Certificate of Registration (COR)");
        panelLayout.putConstraint(SpringLayout.WEST, headerTitle, 0, SpringLayout.WEST, uplCOR);
        panelLayout.putConstraint(SpringLayout.NORTH, uplCOR, 22, SpringLayout.SOUTH, password);
        panelLayout.putConstraint(SpringLayout.WEST, uplCOR, 61, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, uplCOR, -64, SpringLayout.EAST, this);
        uplCOR.setForeground(new Color(0x730C0C));
        uplCOR.setFont(new Font("Montserrat Medium", Font.ITALIC, 12));
        uplCOR.setHorizontalAlignment(SwingConstants.CENTER);
        add(uplCOR);

        // Choose file label
        chooseFile = new JLabel("Choose file or drop here");
        panelLayout.putConstraint(SpringLayout.NORTH, chooseFile, 6, SpringLayout.SOUTH, uplCOR);
        panelLayout.putConstraint(SpringLayout.WEST, chooseFile, 82, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, chooseFile, -209, SpringLayout.SOUTH, this);
        panelLayout.putConstraint(SpringLayout.EAST, chooseFile, -75, SpringLayout.EAST, this);
        chooseFile.setForeground(UIManager.getColor("Button.darkShadow"));
        chooseFile.setHorizontalAlignment(SwingConstants.CENTER);
        chooseFile.setFont(new Font("Montserrat Medium", Font.ITALIC, 14));
        chooseFile.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.LIGHT_GRAY));
        add(chooseFile);

        // Question link
        questionLink = new JButton("Why do I need this?");
        panelLayout.putConstraint(SpringLayout.NORTH, questionLink, 6, SpringLayout.SOUTH, chooseFile);
        panelLayout.putConstraint(SpringLayout.WEST, questionLink, 151, SpringLayout.WEST, this);
        questionLink.setForeground(UIManager.getColor("Button.darkShadow"));
        questionLink.setFont(new Font("Montserrat Medium", Font.ITALIC, 10));
        questionLink.setFocusPainted(false);
        questionLink.setFocusable(false);
        questionLink.setOpaque(false);
        questionLink.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        questionLink.addActionListener(this);
        add(questionLink);

        // Checkbox for terms & conditions
        chckbxTermsConditions = new JCheckBox("Agree to our Terms & Conditions and Privacy Policy");
        panelLayout.putConstraint(SpringLayout.NORTH, chckbxTermsConditions, 16, SpringLayout.SOUTH, questionLink);
        panelLayout.putConstraint(SpringLayout.WEST, chckbxTermsConditions, 0, SpringLayout.WEST, uplCOR);
        panelLayout.putConstraint(SpringLayout.EAST, chckbxTermsConditions, -55, SpringLayout.EAST, this);
        chckbxTermsConditions.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxTermsConditions.setFont(new Font("Montserrat Medium", Font.PLAIN, 10));
        add(chckbxTermsConditions);

        // Sign up button
        signUpButton = new JButton("Sign Up");
        panelLayout.putConstraint(SpringLayout.NORTH, signUpButton, 21, SpringLayout.SOUTH, chckbxTermsConditions);
        panelLayout.putConstraint(SpringLayout.WEST, signUpButton, 10, SpringLayout.WEST, uplCOR);
        panelLayout.putConstraint(SpringLayout.SOUTH, signUpButton, 65, SpringLayout.SOUTH, chckbxTermsConditions);
        panelLayout.putConstraint(SpringLayout.EAST, signUpButton, 0, SpringLayout.EAST, uplCOR);
        signUpButton.setBackground(new Color(128, 0, 0));
        signUpButton.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 16));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBorderPainted(false);
        signUpButton.setFocusPainted(false);
        signUpButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        signUpButton.addActionListener(this);
        add(signUpButton);

        // Already have account? label
        JLabel haveAccount = new JLabel("Already have an account?");
        panelLayout.putConstraint(SpringLayout.NORTH, haveAccount, 6, SpringLayout.SOUTH, signUpButton);
        panelLayout.putConstraint(SpringLayout.WEST, haveAccount, 135, SpringLayout.WEST, this);
        haveAccount.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
        add(haveAccount);
    	
    	// Sign in here button
    	signInButton = new JButton("Sign in here");
    	panelLayout.putConstraint(SpringLayout.NORTH, signInButton, 6, SpringLayout.SOUTH, haveAccount);
    	panelLayout.putConstraint(SpringLayout.WEST, signInButton, 174, SpringLayout.WEST, this);
    	signInButton.setForeground(new Color(0x730C0C));
    	signInButton.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
    	signInButton.setFocusable(false);
    	signInButton.setOpaque(false);
    	signInButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0x730C0C)));
    	signInButton.addActionListener(this);
    	add(signInButton);

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
        passwordField.setForeground(Color.GRAY);
        passwordField.setEchoChar((char) 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == questionLink) {
            CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "TermsConditionsPanel");
        } else if (source == signUpButton) {
            // Check if the terms and conditions checkbox is selected
            if (!chckbxTermsConditions.isSelected()) {
                // Show warning dialog
                JOptionPane.showMessageDialog(this, "You must agree to the Terms & Conditions.", "Warning", JOptionPane.WARNING_MESSAGE);
                // Navigate back to Terms & Conditions panel
                CardLayout clLayout = (CardLayout) contentPane.getLayout();
                clLayout.show(contentPane, "TermsConditionsPanel");
            } else {
            	saveUserInfo(
                        txtUsername.getText(),
                        firstName.getText(),
                        lastName.getText(),
                        txtEmailOrPhone.getText(),
                        new String(password.getPassword())
                    );
            	JOptionPane.showMessageDialog(this, "Information Saved.", "Sign Up Success", JOptionPane.INFORMATION_MESSAGE);
            	/* Other Scenarios: Missing input info, Account already exists, restrict characters with special characters 
            	 * (except _), invalid Phone or email */	 
            }
        } else if (source == signInButton) {
        	CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "SignInPanel");
        }
    }
    
    private void saveUserInfo(String username, String firstName, String lastName, String email, String pwd) {
        String folderPath = "databases";
        
        // Ensure the directory exists
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdir();  // Create the folder if it doesn't exist
        }

        String filePath = folderPath + File.separator + "user_info.txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(username + ", " + firstName + ", " + lastName + ", " + email + ", " + pwd + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}   