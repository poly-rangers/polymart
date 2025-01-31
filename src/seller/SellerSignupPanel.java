package seller;

import frames.CustomDialog;
import misc.RoundedButton;
import misc.FieldIsEmpty;
import databases.UserSignup;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.File;

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
    private JButton btnQuestionLink;
    private JButton btnTermsConditions;
    private JButton btnPrivacyPolicy;
    private JButton btnSignUp;
    private JButton btnSignIn;
    private JCheckBox chckbxTermsConditions;
    
    private UserSignup userSignup;
    private File selectedFile;
    
    public SellerSignupPanel(JPanel contentPane) {
    	this.panelContent = contentPane;
    	
        setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        setLayout(null);
        
        userSignup = new UserSignup();
        userSignup.createTables(); // Create the tables if they don't exist

        // Icon next to header title
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_seller.icon.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        startupImage.setBounds(16, 24, 150, 47); 
        add(startupImage);
        
        startupImage.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
            	CardLayout clLayout = (CardLayout) panelContent.getLayout();
                clLayout.show(panelContent, "BuyerOrSeller");
            }
        });
        
        add(startupImage);
        
     // Sign-up label
    	JLabel labelSignUp = new JLabel("Hey, future polyUser!");
    	labelSignUp.setBounds(48, 112, 318, 29);
    	labelSignUp.setForeground(Color.BLACK);
    	labelSignUp.setFont(new Font("Montserrat", Font.BOLD, 22));
    	labelSignUp.setHorizontalAlignment(SwingConstants.CENTER);
    	add(labelSignUp);
    	
    	JLabel lblSignUpDesc = new JLabel("READY TO BE A POLYSELLER? SIGN UP NOW!");
    	lblSignUpDesc.setForeground(new Color(115, 12, 12));
    	lblSignUpDesc.setFont(new Font("Montserrat", Font.BOLD, 9));
    	lblSignUpDesc.setBounds(89, 140, 241, 12);
    	lblSignUpDesc.setHorizontalAlignment(SwingConstants.CENTER);
    	add(lblSignUpDesc);

    	// Username field
    	txtFieldUsername = new JTextField("Username");
    	setupTextFieldPlaceholder(txtFieldUsername, "Username");
    	txtFieldUsername.setBounds(89, 170, 235, 20);
    	txtFieldUsername.setForeground(new Color(192, 192, 192));
    	txtFieldUsername.setFont(new Font("Montserrat", Font.PLAIN, 12));
    	txtFieldUsername.setColumns(10);
    	txtFieldUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
    	add(txtFieldUsername);

    	// First name field
    	txtFieldFirstName = new JTextField("First Name");
    	setupTextFieldPlaceholder(txtFieldFirstName, "First Name");
    	txtFieldFirstName.setBounds(89, 199, 235, 20);
    	txtFieldFirstName.setForeground(new Color(192, 192, 192));
    	txtFieldFirstName.setFont(new Font("Montserrat", Font.PLAIN, 12));
    	txtFieldFirstName.setColumns(10);
    	txtFieldFirstName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
    	add(txtFieldFirstName);

    	// Last name field
    	txtFieldLastName = new JTextField("Last Name");
    	setupTextFieldPlaceholder(txtFieldLastName, "Last Name");
    	txtFieldLastName.setBounds(89, 230, 235, 20);
    	txtFieldLastName.setForeground(new Color(192, 192, 192));
    	txtFieldLastName.setFont(new Font("Montserrat", Font.PLAIN, 12));
    	txtFieldLastName.setColumns(10);
    	txtFieldLastName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
    	add(txtFieldLastName);

    	// Email or phone field
    	txtFieldEmailOrPhone = new JTextField("Email");
    	setupTextFieldPlaceholder(txtFieldEmailOrPhone, "Email");
    	txtFieldEmailOrPhone.setBounds(89, 261, 235, 20);
    	txtFieldEmailOrPhone.setForeground(new Color(192, 192, 192));
    	txtFieldEmailOrPhone.setFont(new Font("Montserrat", Font.PLAIN, 12));
    	txtFieldEmailOrPhone.setColumns(10);
    	txtFieldEmailOrPhone.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
    	add(txtFieldEmailOrPhone);

    	// Password field
    	pwdFieldPassword = new JPasswordField("Password");
    	setupPasswordFieldPlaceholder(pwdFieldPassword);
    	pwdFieldPassword.setBounds(89, 292, 235, 20);
    	pwdFieldPassword.setFont(new Font("Montserrat", Font.PLAIN, 12));
    	pwdFieldPassword.setColumns(10);
    	pwdFieldPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
    	add(pwdFieldPassword);

    	// Upload COR label
    	JLabel labelUploadCOR = new JLabel("Upload your Certificate of Registration (COR)");
    	labelUploadCOR.setBounds(86, 331, 241, 20);
    	labelUploadCOR.setForeground(new Color(0x730C0C));
    	labelUploadCOR.setFont(new Font("Montserrat Medium", Font.ITALIC, 10));
    	labelUploadCOR.setHorizontalAlignment(SwingConstants.CENTER);
    	add(labelUploadCOR);

    	// Choose file label
    	labelChooseFile = new JLabel("Choose file");
    	labelChooseFile.setBounds(89, 349, 235, 64);
    	labelChooseFile.setForeground(UIManager.getColor("Button.darkShadow"));
    	labelChooseFile.setHorizontalAlignment(SwingConstants.CENTER);
    	labelChooseFile.setFont(new Font("Montserrat", Font.ITALIC, 14));
    	labelChooseFile.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.LIGHT_GRAY));

        // Add MouseListener for interaction
        labelChooseFile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Highlight effect when the mouse enters the label
                labelChooseFile.setForeground(new Color(0x730C0C)); // Change text color
                labelChooseFile.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(0x730C0C))); // Change border color
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Revert to original appearance when the mouse exits
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
        btnQuestionLink.setFont(new Font("Montserrat Medium", Font.ITALIC, 10));
        btnQuestionLink.setFocusPainted(false);
        btnQuestionLink.setFocusable(false);
        btnQuestionLink.setBorderPainted(false);
        btnQuestionLink.setOpaque(false);
        btnQuestionLink.setBackground(Color.WHITE);
        btnQuestionLink.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.LIGHT_GRAY));
        btnQuestionLink.addActionListener(this);
        btnQuestionLink.setBounds(153, 416, 108, 20); 
        add(btnQuestionLink);
        
        JPanel termsConditionPanel = new JPanel();
        termsConditionPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0,0));
        termsConditionPanel.setBounds(89,448,241,40);
        termsConditionPanel.setBackground(Color.WHITE);
        
        // Checkbox for terms & conditions
        chckbxTermsConditions = new JCheckBox("By signing up you agree to our");
        chckbxTermsConditions.setBackground(Color.WHITE);
        chckbxTermsConditions.setFocusable(false);
        chckbxTermsConditions.setFocusPainted(false);
        chckbxTermsConditions.setHorizontalAlignment(SwingConstants.LEFT);
        chckbxTermsConditions.setFont(new Font("Montserrat Medium", Font.PLAIN, 10));
        termsConditionPanel.add(chckbxTermsConditions);
        add(termsConditionPanel);

        // Terms and Conditions button
        btnTermsConditions = new JButton("<html><u>Terms & Conditions</u></html>");
        btnTermsConditions.setBackground(Color.WHITE);
        btnTermsConditions.setForeground(new Color(115, 12, 12));
        btnTermsConditions.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
        btnTermsConditions.setFocusable(false);
        btnTermsConditions.setOpaque(false);
        btnTermsConditions.setBorderPainted(false);
        btnTermsConditions.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0x730C0C)));
        btnTermsConditions.addActionListener(this);
        termsConditionPanel.add(btnTermsConditions);

        // "and" label
        labelAnd = new JLabel(" and  ");
        labelAnd.setFont(new Font("Montserrat Medium", Font.PLAIN, 10));
        termsConditionPanel.add(labelAnd);

        // Privacy Policy button
        btnPrivacyPolicy = new JButton("<html><u>Privacy Policy</u></html>");
        btnPrivacyPolicy.setBackground(Color.WHITE);
        btnPrivacyPolicy.setForeground(new Color(0x730C0C));
        btnPrivacyPolicy.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
        btnPrivacyPolicy.setFocusable(false);
        btnPrivacyPolicy.setOpaque(false);
        btnPrivacyPolicy.setBorderPainted(false);
        btnPrivacyPolicy.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0x730C0C)));
        btnPrivacyPolicy.addActionListener(this);
        termsConditionPanel.add(btnPrivacyPolicy);
 

        // Sign up button
        btnSignUp = new RoundedButton("Sign Up", 45);
        btnSignUp.setBackground(new Color(115, 12, 12));
        btnSignUp.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 16));
        btnSignUp.setForeground(Color.WHITE);
        btnSignUp.setBorderPainted(false);
        btnSignUp.setFocusPainted(false);
        btnSignUp.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        btnSignUp.addActionListener(this);
        btnSignUp.setBounds(89, 499, 241, 45); // Adjusted for null layout
        add(btnSignUp);

        // Already have account? label
        JLabel labelHaveAccount = new JLabel("Already have an account?");
        labelHaveAccount.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
        labelHaveAccount.setHorizontalAlignment(SwingConstants.CENTER);
        labelHaveAccount.setBounds(132, 559, 150, 16); // Adjusted for null layout
        add(labelHaveAccount);

        // Sign in here button
        btnSignIn = new JButton("<html><u>Sign in here</u></html>");
        btnSignIn.setBackground(Color.WHITE);
        btnSignIn.setForeground(new Color(0x730C0C));
        btnSignIn.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
        btnSignIn.setFocusable(false);
        btnSignIn.setBorderPainted(false);
        btnSignIn.setOpaque(false);
        btnSignIn.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0x730C0C)));
        btnSignIn.addActionListener(this);
        btnSignIn.setBounds(142, 574, 140, 14); // Adjusted for null layout
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
            clLayout.show(panelContent, "SellerTermsConditionsPanel");
        } else if (source == btnSignUp) {
            // Create instances of the ErrorHandler interface for each required field
            FieldIsEmpty usernameValidation = new FieldIsEmpty(txtFieldUsername, "Username");
            FieldIsEmpty firstNameValidation = new FieldIsEmpty(txtFieldFirstName, "First Name");
            FieldIsEmpty lastNameValidation = new FieldIsEmpty(txtFieldLastName, "Last Name");
            FieldIsEmpty emailOrPhoneValidation = new FieldIsEmpty(txtFieldEmailOrPhone, "Email");
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

            if (!emailOrPhoneValidation.validateField()) {
            	JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                emailOrPhoneValidation.showAlert(parentFrame);
                return;
            }

            if (!passwordValidation.validateField()) {
            	JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                passwordValidation.showAlert(parentFrame);
                return;
            }

            //Validation for email format
            String email = txtFieldEmailOrPhone.getText().trim();
            if (!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z0-9]{2,7}$") && !email.matches("^\\d{10}$")) {
            	JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            	new CustomDialog(parentFrame, "nagmamadali? naghahabol?", "pacheck mabuti baks, pero mali yung format ng username or email mo jusko PO", "sorry po..."); 
                return;
            }

            // Check if the terms and conditions checkbox is selected
            if (!chckbxTermsConditions.isSelected()) {
            	 JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                 new CustomDialog(parentFrame, "check the label ateh!", "ano nhak?! aus ausin mo naman pagdedesisyon mo! i-check mo muna ang Terms and Conditions!", "sorry po...");
                 
                CardLayout clLayout = (CardLayout) panelContent.getLayout();
                clLayout.show(panelContent, "TermsConditionsPanel");
            } else {
            	saveSellerDetails(txtFieldUsername.getText().trim(), txtFieldFirstName.getText().trim(), txtFieldLastName.getText().trim(),
                        txtFieldEmailOrPhone.getText().trim(), new String(pwdFieldPassword.getPassword()));
            }
        } else if (source == btnSignIn) {
            clearTextFields();
            CardLayout clLayout = (CardLayout) panelContent.getLayout();
            clLayout.show(panelContent, "SellerSignInPanel");
        }
    }
   
    public void saveSellerDetails(String username, String firstName, String lastName, String email, String password) {

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
            	userSignup.saveUser(username, firstName, lastName, email, password, "seller");
            	userSignup.saveUploadedFile(username, "seller", selectedFile);
            	
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                new CustomDialog(parentFrame, "Sign Up success", "ayarn! pasok ka na sa banga sis, pwede ka na mag log-in at mag-access sa dashboard", "Proceed");
                clearTextFields();
                CardLayout clLayout = (CardLayout) panelContent.getLayout();
                clLayout.show(panelContent, "SellerSignInPanel");
            }
           
    	} else {
    		JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            new CustomDialog(parentFrame, "may iba na shea teh", "hahahahahaha bat umeepal ka pa.... may iba na sha mhie!", "sorry po...");
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