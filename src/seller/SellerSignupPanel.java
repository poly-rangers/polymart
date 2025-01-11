package seller;
import frames.InformationSaved;
import frames.SignUpQuestion;
import frames.TermsConditionsWarning;
import frames.FieldsInvalidAlert;
import misc.RoundButton;
import misc.FieldIsEmpty;

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

public class SellerSignupPanel extends JPanel implements ActionListener {

	private JPanel panelContent;
    private static final long serialVersionUID = 1L;
    private JTextField txtFieldUsername;
    private JTextField txtFieldFirstName;
    private JTextField txtFieldLastName;
    private JTextField txtFieldEmailOrPhone;
    private JPasswordField pwdFieldPassword;
    private JLabel labelChooseFile;
    private JLabel labelAnd;
    private JButton bttnQuestionLink;
    private JButton bttnTermsConditions;
    private JButton bttnPrivacyPolicy;
    private JButton bttnSignUp;
    private JButton bttnSignIn;
    private JCheckBox chckbxTermsConditions;
    
    public SellerSignupPanel(JPanel contentPane) {
    	this.panelContent = contentPane;
    	
        setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        SpringLayout panelLayout = new SpringLayout();
        setLayout(panelLayout);

        // Icon next to header title
        ImageIcon imgPolypupIcon = new ImageIcon(this.getClass().getResource("/polypup_seller.icon.png"));
        Image scaledImage = imgPolypupIcon.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        panelLayout.putConstraint(SpringLayout.NORTH, startupImage, 24, SpringLayout.NORTH, this);
        add(startupImage);

        // Sign-up label
        JLabel labelSignUp = new JLabel("Sign Up");
        panelLayout.putConstraint(SpringLayout.EAST, startupImage, 0, SpringLayout.EAST, labelSignUp);
        panelLayout.putConstraint(SpringLayout.NORTH, labelSignUp, 119, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, labelSignUp, 35, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, labelSignUp, 166, SpringLayout.WEST, this);
        labelSignUp.setForeground(Color.BLACK);
        labelSignUp.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 24));
        labelSignUp.setHorizontalAlignment(SwingConstants.CENTER);
        add(labelSignUp);

        // User name
    	txtFieldUsername = new JTextField("Username");
    	setupTextFieldPlaceholder(txtFieldUsername, "Username");
    	txtFieldUsername.setForeground(Color.GRAY);
    	txtFieldUsername.setFont(new Font("Montserrat", Font.PLAIN, 12));
    	txtFieldUsername.setColumns(10);
    	txtFieldUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
    	add(txtFieldUsername);
        
        // First name
        txtFieldFirstName = new JTextField("First Name");
        panelLayout.putConstraint(SpringLayout.WEST, txtFieldUsername, 0, SpringLayout.WEST, txtFieldFirstName);
        panelLayout.putConstraint(SpringLayout.SOUTH, txtFieldUsername, -12, SpringLayout.NORTH, txtFieldFirstName);
        panelLayout.putConstraint(SpringLayout.EAST, txtFieldUsername, 0, SpringLayout.EAST, txtFieldFirstName);
        setupTextFieldPlaceholder(txtFieldFirstName, "First Name");
        panelLayout.putConstraint(SpringLayout.NORTH, txtFieldFirstName, 207, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, txtFieldFirstName, 85, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, txtFieldFirstName, -94, SpringLayout.EAST, this);
        txtFieldFirstName.setFont(new Font("Montserrat", Font.PLAIN, 12));
        txtFieldFirstName.setColumns(10);
        txtFieldFirstName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        add(txtFieldFirstName);

        // Last name
        txtFieldLastName = new JTextField("Last Name");
        setupTextFieldPlaceholder(txtFieldLastName, "Last Name");
        panelLayout.putConstraint(SpringLayout.SOUTH, txtFieldFirstName, -16, SpringLayout.NORTH, txtFieldLastName);
        panelLayout.putConstraint(SpringLayout.NORTH, txtFieldLastName, 242, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, txtFieldLastName, 85, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, txtFieldLastName, -94, SpringLayout.EAST, this);
        txtFieldLastName.setFont(new Font("Montserrat", Font.PLAIN, 12));
        txtFieldLastName.setColumns(10);
        txtFieldLastName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        add(txtFieldLastName);

        // Email or phone
        txtFieldEmailOrPhone = new JTextField("Email");
        setupTextFieldPlaceholder(txtFieldEmailOrPhone, "Email");
        panelLayout.putConstraint(SpringLayout.NORTH, txtFieldEmailOrPhone, 275, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, txtFieldEmailOrPhone, -366, SpringLayout.SOUTH, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, txtFieldLastName, -14, SpringLayout.NORTH, txtFieldEmailOrPhone);
        panelLayout.putConstraint(SpringLayout.WEST, txtFieldEmailOrPhone, 85, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, txtFieldEmailOrPhone, -94, SpringLayout.EAST, this);
        txtFieldEmailOrPhone.setFont(new Font("Montserrat", Font.PLAIN, 12));
        txtFieldEmailOrPhone.setColumns(10);
        txtFieldEmailOrPhone.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        add(txtFieldEmailOrPhone);

        // Password
        pwdFieldPassword = new JPasswordField("Password");
        pwdFieldPassword.setFont(new Font("Montserrat", Font.PLAIN, 12));
        setupPasswordFieldPlaceholder(pwdFieldPassword);
        panelLayout.putConstraint(SpringLayout.NORTH, pwdFieldPassword, 13, SpringLayout.SOUTH, txtFieldEmailOrPhone);
        panelLayout.putConstraint(SpringLayout.WEST, pwdFieldPassword, 0, SpringLayout.WEST, txtFieldFirstName);
        panelLayout.putConstraint(SpringLayout.SOUTH, pwdFieldPassword, -334, SpringLayout.SOUTH, this);
        panelLayout.putConstraint(SpringLayout.EAST, pwdFieldPassword, -94, SpringLayout.EAST, this);
        pwdFieldPassword.setColumns(10);
        pwdFieldPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        add(pwdFieldPassword);

        // Upload COR
        JLabel labelUploadCOR = new JLabel("Upload your Certificate of Registration (COR)");
        panelLayout.putConstraint(SpringLayout.NORTH, labelUploadCOR, 22, SpringLayout.SOUTH, pwdFieldPassword);
        panelLayout.putConstraint(SpringLayout.WEST, labelUploadCOR, 61, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, labelUploadCOR, -64, SpringLayout.EAST, this);
        labelUploadCOR.setForeground(new Color(0x730C0C));
        labelUploadCOR.setFont(new Font("Montserrat Medium", Font.ITALIC, 12));
        labelUploadCOR.setHorizontalAlignment(SwingConstants.CENTER);
        add(labelUploadCOR);

        // Choose file label
        labelChooseFile = new JLabel("Choose file or drop here");
        panelLayout.putConstraint(SpringLayout.NORTH, labelChooseFile, 6, SpringLayout.SOUTH, labelUploadCOR);
        panelLayout.putConstraint(SpringLayout.WEST, labelChooseFile, 82, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, labelChooseFile, -209, SpringLayout.SOUTH, this);
        panelLayout.putConstraint(SpringLayout.EAST, labelChooseFile, -75, SpringLayout.EAST, this);
        labelChooseFile.setForeground(UIManager.getColor("Button.darkShadow"));
        labelChooseFile.setHorizontalAlignment(SwingConstants.CENTER);
        labelChooseFile.setFont(new Font("Montserrat Medium", Font.ITALIC, 14));
        labelChooseFile.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.LIGHT_GRAY));
        add(labelChooseFile);

        // Question link
        bttnQuestionLink = new JButton("Why do I need this?");
        panelLayout.putConstraint(SpringLayout.NORTH, bttnQuestionLink, 6, SpringLayout.SOUTH, labelChooseFile);
        panelLayout.putConstraint(SpringLayout.WEST, bttnQuestionLink, 151, SpringLayout.WEST, this);
        bttnQuestionLink.setForeground(UIManager.getColor("Button.darkShadow"));
        bttnQuestionLink.setFont(new Font("Montserrat Medium", Font.ITALIC, 10));
        bttnQuestionLink.setFocusPainted(false);
        bttnQuestionLink.setFocusable(false);
        bttnQuestionLink.setOpaque(false);
        bttnQuestionLink.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        bttnQuestionLink.addActionListener(this);
        add(bttnQuestionLink);

        // Checkbox for terms & conditions
        chckbxTermsConditions = new JCheckBox("By signing up you agree to our");
        panelLayout.putConstraint(SpringLayout.NORTH, chckbxTermsConditions, 18, SpringLayout.SOUTH, bttnQuestionLink);
        panelLayout.putConstraint(SpringLayout.WEST, chckbxTermsConditions, 21, SpringLayout.WEST, labelUploadCOR);
        panelLayout.putConstraint(SpringLayout.SOUTH, chckbxTermsConditions, -155, SpringLayout.SOUTH, this);
        panelLayout.putConstraint(SpringLayout.EAST, chckbxTermsConditions, 0, SpringLayout.EAST, labelChooseFile);
        chckbxTermsConditions.setBackground(Color.WHITE);
        chckbxTermsConditions.setHorizontalAlignment(SwingConstants.LEFT);
        chckbxTermsConditions.setFont(new Font("Montserrat Medium", Font.PLAIN, 10));
        add(chckbxTermsConditions);
        
        // Terms and Conditions button
    	bttnTermsConditions = new JButton("Terms & Conditions");
    	bttnTermsConditions.setBackground(Color.WHITE);
    	panelLayout.putConstraint(SpringLayout.NORTH, bttnTermsConditions, 1, SpringLayout.SOUTH, chckbxTermsConditions);
    	panelLayout.putConstraint(SpringLayout.WEST, bttnTermsConditions, 103, SpringLayout.WEST, this);
    	bttnTermsConditions.setForeground(new Color(0x730C0C));
    	bttnTermsConditions.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
    	bttnTermsConditions.setFocusable(false);
    	bttnTermsConditions.setOpaque(false);
    	bttnTermsConditions.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0x730C0C)));
    	bttnTermsConditions.addActionListener(this);
    	add(bttnTermsConditions);
        
    	// "and" label
    	labelAnd = new JLabel("and");
    	panelLayout.putConstraint(SpringLayout.NORTH, labelAnd, 1, SpringLayout.NORTH, bttnTermsConditions);
    	panelLayout.putConstraint(SpringLayout.WEST, labelAnd, 6, SpringLayout.EAST, bttnTermsConditions);
    	labelAnd.setFont(new Font("Montserrat Medium", Font.PLAIN, 10));
    	add(labelAnd);
        
        // Terms and Conditions button
    	bttnPrivacyPolicy = new JButton("Privacy Policy");
    	bttnPrivacyPolicy.setBackground(Color.WHITE);
    	panelLayout.putConstraint(SpringLayout.NORTH, bttnPrivacyPolicy, 0, SpringLayout.NORTH, bttnTermsConditions);
    	panelLayout.putConstraint(SpringLayout.WEST, bttnPrivacyPolicy, 6, SpringLayout.EAST, labelAnd);
    	bttnPrivacyPolicy.setForeground(new Color(0x730C0C));
    	bttnPrivacyPolicy.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
    	bttnPrivacyPolicy.setFocusable(false);
    	bttnPrivacyPolicy.setOpaque(false);
    	bttnPrivacyPolicy.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0x730C0C)));
    	bttnPrivacyPolicy.addActionListener(this);
    	add(bttnPrivacyPolicy);

        // Sign up button
        bttnSignUp = new RoundButton("Sign Up", 30);
        panelLayout.putConstraint(SpringLayout.NORTH, bttnSignUp, 22, SpringLayout.SOUTH, bttnTermsConditions);
        panelLayout.putConstraint(SpringLayout.WEST, bttnSignUp, 10, SpringLayout.WEST, labelUploadCOR);
        panelLayout.putConstraint(SpringLayout.EAST, bttnSignUp, 0, SpringLayout.EAST, labelUploadCOR);
        bttnSignUp.setBackground(new Color(128, 0, 0));
        bttnSignUp.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 16));
        bttnSignUp.setForeground(Color.WHITE);
        bttnSignUp.setBorderPainted(false);
        bttnSignUp.setFocusPainted(false);
        bttnSignUp.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        bttnSignUp.addActionListener(this);
        add(bttnSignUp);

        // Already have account? label
        JLabel labelHaveAccount = new JLabel("Already have an account?");
        panelLayout.putConstraint(SpringLayout.NORTH, labelHaveAccount, 593, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, bttnSignUp, -6, SpringLayout.NORTH, labelHaveAccount);
        panelLayout.putConstraint(SpringLayout.WEST, labelHaveAccount, 134, SpringLayout.WEST, this);
        labelHaveAccount.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
        add(labelHaveAccount);
    	
    	// Sign in here button
    	bttnSignIn = new JButton("Sign in here");
    	bttnSignIn.setBackground(Color.WHITE);
    	panelLayout.putConstraint(SpringLayout.NORTH, bttnSignIn, 2, SpringLayout.SOUTH, labelHaveAccount);
    	panelLayout.putConstraint(SpringLayout.WEST, bttnSignIn, 173, SpringLayout.WEST, this);
    	bttnSignIn.setForeground(new Color(0x730C0C));
    	bttnSignIn.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
    	bttnSignIn.setFocusable(false);
    	bttnSignIn.setOpaque(false);
    	bttnSignIn.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0x730C0C)));
    	bttnSignIn.addActionListener(this);
    	add(bttnSignIn);

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

        if (source == bttnQuestionLink) {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            new SignUpQuestion(parentFrame);
        } else if (source == bttnTermsConditions || source == bttnPrivacyPolicy) {
            CardLayout clLayout = (CardLayout) panelContent.getLayout();
            clLayout.show(panelContent, "SellerTermsConditionsPanel");
        } else if (source == bttnSignUp) {
            // Create instances of the ErrorHandler interface for each required field
            FieldIsEmpty usernameValidation = new FieldIsEmpty(txtFieldUsername, "Username");
            FieldIsEmpty firstNameValidation = new FieldIsEmpty(txtFieldFirstName, "First Name");
            FieldIsEmpty lastNameValidation = new FieldIsEmpty(txtFieldLastName, "Last Name");
            FieldIsEmpty emailOrPhoneValidation = new FieldIsEmpty(txtFieldEmailOrPhone, "Email");
            FieldIsEmpty passwordValidation = new FieldIsEmpty(pwdFieldPassword, "Password");

            // Validate each field
            if (!usernameValidation.validate()) {
            	JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                usernameValidation.showAlert(parentFrame); 
                return;
            }
            
            //Handle username field that allows only underscore as a valid special character
            String validUsername = txtFieldUsername.getText().trim();
            if (!isUsernameValid(validUsername)) {
            	JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            	new FieldsInvalidAlert(parentFrame); // Cast to JFrame if needed
            	return;
            }

            if (!firstNameValidation.validate()) {
            	JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                firstNameValidation.showAlert(parentFrame); 
                return;
            }

            if (!lastNameValidation.validate()) {
            	JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                lastNameValidation.showAlert(parentFrame);
                return;
            }

            if (!emailOrPhoneValidation.validate()) {
            	JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                emailOrPhoneValidation.showAlert(parentFrame);
                return;
            }

            if (!passwordValidation.validate()) {
            	JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                passwordValidation.showAlert(parentFrame);
                return;
            }

            //Validation for email format
            String email = txtFieldEmailOrPhone.getText().trim();
            if (!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z0-9]{2,7}$") && !email.matches("^\\d{10}$")) {
            	JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            	new FieldsInvalidAlert(parentFrame); // Cast to JFrame if needed
                return;
            }

            // Check if the terms and conditions checkbox is selected
            if (!chckbxTermsConditions.isSelected()) {
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                new TermsConditionsWarning(parentFrame);
                CardLayout clLayout = (CardLayout) panelContent.getLayout();
                clLayout.show(panelContent, "BuyerTermsConditionsPanel");
            } else {
                saveUserInfo(txtFieldUsername.getText().trim(), txtFieldFirstName.getText().trim(), txtFieldLastName.getText().trim(),
                        txtFieldEmailOrPhone.getText().trim(), new String(pwdFieldPassword.getPassword()));
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                new InformationSaved(parentFrame);
                //Redirect to SignInPanel 
                CardLayout clLayout = (CardLayout) panelContent.getLayout();
                clLayout.show(panelContent, "SellerSignInPanel");
            }
        } else if (source == bttnSignIn) {
            clearTextFields();
            CardLayout clLayout = (CardLayout) panelContent.getLayout();
            clLayout.show(panelContent, "SellerSignInPanel");
        }
    }
   
    private void saveUserInfo(String username, String firstName, String lastName, String email, String pwd) {
        String folderPath = "databases";
        
        // Ensure the directory exists
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdir();  // Create the folder if it doesn't exist
        }

        String filePath = folderPath + File.separator + "seller_userinfo.txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(username + "," + firstName + "," + lastName + "," + email + "," + pwd + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void clearTextFields() {
        // Reset text fields to their placeholder values
        txtFieldUsername.setText("Username");
        txtFieldUsername.setForeground(Color.GRAY);

        txtFieldFirstName.setText("First Name");
        txtFieldFirstName.setForeground(Color.GRAY);

        txtFieldLastName.setText("Last Name");
        txtFieldLastName.setForeground(Color.GRAY);

        txtFieldEmailOrPhone.setText("Email");
        txtFieldEmailOrPhone.setForeground(Color.GRAY);

        pwdFieldPassword.setText("Password");
        pwdFieldPassword.setForeground(Color.GRAY);
        pwdFieldPassword.setEchoChar((char) 0);  // Reset password echo char for the placeholder
    }
    
    private boolean isUsernameValid(String username) {
        String usernameRegex =  "^[a-zA-Z0-9_]+$";
    	return username.matches(usernameRegex);
    }
}   