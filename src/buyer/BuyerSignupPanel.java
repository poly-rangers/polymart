package buyer;

import frames.CustomDialog;
import misc.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import databases.UserSignup;
import java.awt.event.*;
import java.io.File;

public class BuyerSignupPanel extends JPanel implements ActionListener {

    private JPanel panelContent;
    private static final long serialVersionUID = 1L;
    private JTextField txtFieldFirstName;
    private JTextField txtFieldLastName;
    private JTextField txtFieldEmailOrPhone;
    private JTextField txtFieldUsername;
    private JPasswordField pwdFieldPassword;
    private JButton btnQuestionLink;
    private JButton btnTermsConditions;
    private JButton btnPrivacyPolicy;
    private JButton btnSignUp;
    private JButton btnSignIn;
    private JLabel labelAnd;
    private JLabel labelChooseFile;
    private JCheckBox chckbxTermsConditions;
    
    private UserSignup userSignup;
    private File selectedFile;
    
    public BuyerSignupPanel(JPanel contentPane) {
    	this.panelContent = contentPane;
    	
        setBackground(Color.WHITE);
        setSize(414, 660);
        SpringLayout panelLayout = new SpringLayout();
        setLayout(panelLayout);
        
        userSignup = new UserSignup();
        userSignup.createTables(); // Create the tables if they don't exist

        // Icon next to header title
        ImageIcon imgPolypupIcon = new ImageIcon(this.getClass().getResource("/polypup_buyer.icon.png"));
        Image scaledImage = imgPolypupIcon.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        panelLayout.putConstraint(SpringLayout.NORTH, startupImage, 24, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, startupImage, 16, SpringLayout.WEST, this);
        
        startupImage.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
            	CardLayout clLayout = (CardLayout) panelContent.getLayout();
                clLayout.show(panelContent, "BuyerOrSeller");
            }
        });
        
        add(startupImage);
        

        // Sign-up label
        JLabel labelSignUp = new JLabel("Sign Up");
        panelLayout.putConstraint(SpringLayout.EAST, startupImage, 0, SpringLayout.EAST, labelSignUp);
        panelLayout.putConstraint(SpringLayout.NORTH, labelSignUp, 119, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, labelSignUp, 35, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, labelSignUp, 166, SpringLayout.WEST, this);
        labelSignUp.setForeground(Color.BLACK);
        labelSignUp.setFont(new Font("Montserrat SemiBold", Font.BOLD, 24));
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
        txtFieldFirstName.setForeground(new Color(192, 192, 192));
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
        txtFieldLastName.setForeground(new Color(192, 192, 192));
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
        txtFieldEmailOrPhone.setForeground(new Color(192, 192, 192));
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

        // Add MouseListener for interaction
        labelChooseFile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                labelChooseFile.setForeground(new Color(0x730C0C));
                labelChooseFile.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(0x730C0C)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                labelChooseFile.setForeground(UIManager.getColor("Button.darkShadow"));
                labelChooseFile.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.LIGHT_GRAY));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files", "pdf")); // Filter for PDFs
                int result = fileChooser.showOpenDialog(labelChooseFile);

                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile(); // Store the selected file
                    System.out.println("File selected: " + selectedFile.getAbsolutePath());
                } else {
                    System.out.println("No file selected.");
                }
            }
        });

        // Add the label to the panel
        add(labelChooseFile);


        // Question link
        btnQuestionLink = new JButton("<html><u>Why do I need this?</u></html>");
        btnQuestionLink.setForeground(new Color(128, 128, 128));
        panelLayout.putConstraint(SpringLayout.NORTH, btnQuestionLink, 6, SpringLayout.SOUTH, labelChooseFile);
        panelLayout.putConstraint(SpringLayout.WEST, btnQuestionLink, 153, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, btnQuestionLink, -143, SpringLayout.EAST, this);
//        btnQuestionLink.setForeground(UIManager.getColor("Button.darkShadow"));
        btnQuestionLink.setFont(new Font("Montserrat Medium", Font.ITALIC, 10));
        btnQuestionLink.setFocusPainted(false);
        btnQuestionLink.setFocusable(false);
        btnQuestionLink.setBorderPainted(false);
        btnQuestionLink.setOpaque(false);
        btnQuestionLink.setBackground(Color.WHITE);
        btnQuestionLink.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.LIGHT_GRAY));
        btnQuestionLink.addActionListener(this);
        add(btnQuestionLink);

        // Checkbox for terms & conditions
        chckbxTermsConditions = new JCheckBox("By signing up you agree to our");
        panelLayout.putConstraint(SpringLayout.NORTH, chckbxTermsConditions, 18, SpringLayout.SOUTH, btnQuestionLink);
        panelLayout.putConstraint(SpringLayout.WEST, chckbxTermsConditions, 21, SpringLayout.WEST, labelUploadCOR);
        panelLayout.putConstraint(SpringLayout.EAST, chckbxTermsConditions, 0, SpringLayout.EAST, labelChooseFile);
        chckbxTermsConditions.setBackground(Color.WHITE);
        chckbxTermsConditions.setFocusable(false);
        chckbxTermsConditions.setFocusPainted(false);
        chckbxTermsConditions.setHorizontalAlignment(SwingConstants.LEFT);
        chckbxTermsConditions.setFont(new Font("Montserrat Medium", Font.PLAIN, 10));
        add(chckbxTermsConditions);
        
        // Terms and Conditions button
    	btnTermsConditions = new JButton("<html><u>Terms & Conditions</u></html>");
    	panelLayout.putConstraint(SpringLayout.SOUTH, chckbxTermsConditions, -1, SpringLayout.NORTH, btnTermsConditions);
    	panelLayout.putConstraint(SpringLayout.NORTH, btnTermsConditions, 506, SpringLayout.NORTH, this);
    	btnTermsConditions.setBackground(Color.WHITE);
    	panelLayout.putConstraint(SpringLayout.WEST, btnTermsConditions, 103, SpringLayout.WEST, this);
    	btnTermsConditions.setForeground(new Color(115,12,12));
    	btnTermsConditions.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
    	btnTermsConditions.setFocusable(false);
    	btnTermsConditions.setOpaque(false);
    	btnTermsConditions.setBorderPainted(false);
    	btnTermsConditions.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0x730C0C)));
    	btnTermsConditions.addActionListener(this);
    	add(btnTermsConditions);
        
    	// "and" label
    	labelAnd = new JLabel("and");
    	panelLayout.putConstraint(SpringLayout.NORTH, labelAnd, 1, SpringLayout.NORTH, btnTermsConditions);
    	panelLayout.putConstraint(SpringLayout.WEST, labelAnd, 6, SpringLayout.EAST, btnTermsConditions);
    	labelAnd.setFont(new Font("Montserrat Medium", Font.PLAIN, 10));
    	add(labelAnd);
        
        // Terms and Conditions button
    	btnPrivacyPolicy = new JButton("<html><u>Privacy Policy</u></html>");
    	btnPrivacyPolicy.setBackground(Color.WHITE);
    	panelLayout.putConstraint(SpringLayout.NORTH, btnPrivacyPolicy, 0, SpringLayout.NORTH, btnTermsConditions);
    	panelLayout.putConstraint(SpringLayout.WEST, btnPrivacyPolicy, 6, SpringLayout.EAST, labelAnd);
    	btnPrivacyPolicy.setForeground(new Color(0x730C0C));
    	btnPrivacyPolicy.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
    	btnPrivacyPolicy.setFocusable(false);
    	btnPrivacyPolicy.setOpaque(false);
    	btnPrivacyPolicy.setBorderPainted(false);
    	btnPrivacyPolicy.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0x730C0C)));
    	btnPrivacyPolicy.addActionListener(this);
    	add(btnPrivacyPolicy);

        // Sign up button
        btnSignUp = new RoundedButton("Sign Up", 45);
        panelLayout.putConstraint(SpringLayout.NORTH, btnSignUp, 22, SpringLayout.SOUTH, btnTermsConditions);
        panelLayout.putConstraint(SpringLayout.WEST, btnSignUp, 10, SpringLayout.WEST, labelUploadCOR);
        panelLayout.putConstraint(SpringLayout.SOUTH, btnSignUp, -73, SpringLayout.SOUTH, this);
        panelLayout.putConstraint(SpringLayout.EAST, btnSignUp, 0, SpringLayout.EAST, labelUploadCOR);
        btnSignUp.setBackground(new Color(115, 12, 12));
        btnSignUp.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 16));
        btnSignUp.setForeground(Color.WHITE);
        btnSignUp.setBorderPainted(false);
        btnSignUp.setFocusPainted(false);
        btnSignUp.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        btnSignUp.addActionListener(this);
        add(btnSignUp);

        // Already have account? label
        JLabel labelHaveAccount = new JLabel("Already have an account?");
        panelLayout.putConstraint(SpringLayout.NORTH, labelHaveAccount, 6, SpringLayout.SOUTH, btnSignUp);
        panelLayout.putConstraint(SpringLayout.WEST, labelHaveAccount, 145, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, labelHaveAccount, -119, SpringLayout.EAST, this);
        labelHaveAccount.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
        add(labelHaveAccount);
    	
    	// Sign in here button
    	btnSignIn = new JButton("<html><u>Sign in here</u></html>");
    	panelLayout.putConstraint(SpringLayout.NORTH, btnSignIn, 6, SpringLayout.SOUTH, labelHaveAccount);
    	panelLayout.putConstraint(SpringLayout.WEST, btnSignIn, 169, SpringLayout.WEST, this);
    	panelLayout.putConstraint(SpringLayout.EAST, btnSignIn, -166, SpringLayout.EAST, this);
    	btnSignIn.setBackground(Color.WHITE);
    	btnSignIn.setForeground(new Color(0x730C0C));
    	btnSignIn.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
    	btnSignIn.setFocusable(false);
    	btnSignIn.setBorderPainted(false);
    	btnSignIn.setOpaque(false);
    	btnSignIn.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0x730C0C)));
    	btnSignIn.addActionListener(this);
    	add(btnSignIn);
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
        textField.setForeground(new Color(192, 192, 192));
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == btnQuestionLink) {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            new CustomDialog(parentFrame, "ganyan po ba ang tono ng mga nagtatanong maem?", "This app is exclusive to PUPians only! By uploading your Certificate of Registration, you are  <u>confirming and verifying</u> that you are an <u> official PUP student.</u> <br> <br> oh edi special ka niyan ngayon? gets na ba baks? end call ko na to.", "okay, gets");
        } else if (source == btnTermsConditions || source == btnPrivacyPolicy) {
            CardLayout clLayout = (CardLayout) panelContent.getLayout();
            clLayout.show(panelContent, "BuyerTermsConditionsPanel");
        } else if (source == btnSignUp) {
            // Create instances of the ErrorHandler interface for each required field
            FieldIsEmpty usernameValidation = new FieldIsEmpty(txtFieldUsername, "Username");
            FieldIsEmpty firstNameValidation = new FieldIsEmpty(txtFieldFirstName, "First Name");
            FieldIsEmpty lastNameValidation = new FieldIsEmpty(txtFieldLastName, "Last Name");
            FieldIsEmpty emailValidation = new FieldIsEmpty(txtFieldEmailOrPhone, "Email");
            FieldIsEmpty passwordValidation = new FieldIsEmpty(pwdFieldPassword, "Password");

            // Validate each field
            if (!usernameValidation.validateField()) {
            	JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                usernameValidation.showAlert(parentFrame); 
                return;
            }
            
            //Handle username field that allows only underscore as a valid special character
            String validUsername = txtFieldUsername.getText().trim();
            if (!isUsernameValid(validUsername)) {
            	JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            	new CustomDialog(parentFrame, "kulang teh!", "nagmamadali ka ba baks? lagyan mo muna ng laman jusko PO", "sigi nhay'ed"); 
                return;
            }

            if (!firstNameValidation.validateField()) {
            	JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                firstNameValidation.showAlert(parentFrame); 
                return;
            }

            if (!lastNameValidation.validateField()) {
            	JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                lastNameValidation.showAlert(parentFrame);
                return;
            }

            if (!emailValidation.validateField()) {
            	JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                emailValidation.showAlert(parentFrame);
                return;
            }

            if (!passwordValidation.validateField()) {
            	JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                passwordValidation.showAlert(parentFrame);
                return;
            }

            //Validation for email format
            String currentEmail = txtFieldEmailOrPhone.getText().trim();
            if (!currentEmail.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z0-9]{2,7}$") && !currentEmail.matches("^\\d{10}$")) {
            	JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            	new CustomDialog(parentFrame, "nagmamadali? naghahabol?", "pacheck mabuti baks, pero mali yung format ng username or email mo jusko PO", "sorry po..."); 
                return;
            }

            // Check if the terms and conditions checkbox is selected
            if (!chckbxTermsConditions.isSelected()) {
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                new CustomDialog(parentFrame, "check the label ateh!", "ano nhak?! aus ausin mo naman pagdedesisyon mo! i-check mo muna ang Terms and Conditions!", "sorry po...");
                
                CardLayout clLayout = (CardLayout) panelContent.getLayout();
                clLayout.show(panelContent, "BuyerTermsConditionsPanel");
            } else {
            	saveBuyerDetails(txtFieldUsername.getText().trim(), txtFieldFirstName.getText().trim(), txtFieldLastName.getText().trim(),
                        txtFieldEmailOrPhone.getText().trim(), new String(pwdFieldPassword.getPassword()));
            }
        } else if (source == btnSignIn) {
            clearTextFields();
            CardLayout clLayout = (CardLayout) panelContent.getLayout();
            clLayout.show(panelContent, "BuyerSignInPanel");
        }
    }
   
    public void saveBuyerDetails(String username, String firstName, String lastName, String email, String password) {

    	if (userSignup.uniqueCheck(username, email)) {
            
        	if (selectedFile == null) {
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                new CustomDialog(
                    parentFrame,
                    "File Upload Required",
                    "Please select your Certificate of Registration (COR) to complete the sign-up process.",
                    "Okay, I'll upload"
                );
                return; // Stop the sign-up process if no file is selected
            } else {
            	userSignup.saveUser(username, firstName, lastName, email, password, "buyer");
            	userSignup.saveUploadedFile(username, "buyer", selectedFile);
            	
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                new CustomDialog(parentFrame, "Sign Up success", "ayarn! pasok ka na sa banga sis, pwede ka na mag log-in at mag-access sa dashboard", "Proceed");
                clearTextFields();
                CardLayout clLayout = (CardLayout) panelContent.getLayout();
                clLayout.show(panelContent, "BuyerSignInPanel");
            }
           
    	} else {
    		JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            new CustomDialog(parentFrame, "may iba na shea teh", "hahahahahaha bat umeepal ka pa.... may iba na sha mhie!", "sorry po...");
            }
        }

    public void close() {
        userSignup.close();
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