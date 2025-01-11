package buyer;
import frames.CustomDialog;
import misc.RoundButton;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class BuyerSignInPanel extends JPanel implements ActionListener{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usernameField;
    private JPasswordField pwdField;
    private JCheckBox showPasswordCheckBox;
    private JButton signUpButton;
    private JButton loginButton;

    public BuyerSignInPanel(JPanel contentPane) {
        this.contentPane = contentPane;
        
        setBackground(new Color(255, 255, 255));
        setBounds(100, 100, 414, 660);
        SpringLayout panelLayout = new SpringLayout();
        setLayout(panelLayout);
        
        // Icon next to header title
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_buyer.icon.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        panelLayout.putConstraint(SpringLayout.NORTH, startupImage, 24, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, startupImage, 16, SpringLayout.WEST, this);
        add(startupImage);

        // Sign-up label
        JLabel signInLabel = new JLabel("Sign In");
        panelLayout.putConstraint(SpringLayout.NORTH, signInLabel, 119, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, signInLabel, 35, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, signInLabel, 166, SpringLayout.WEST, this);
        signInLabel.setForeground(Color.BLACK);
        signInLabel.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 24));
        signInLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(signInLabel);
        
        //Username Field
        usernameField = new JTextField("Username");
        setupTextFieldPlaceholder(usernameField, "Username");
        usernameField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        usernameField.setForeground(new Color(192, 192, 192));
        usernameField.setFont(new Font("Montserrat", Font.PLAIN, 12));
        panelLayout.putConstraint(SpringLayout.NORTH, usernameField, 25, SpringLayout.SOUTH, signInLabel);
        panelLayout.putConstraint(SpringLayout.WEST, usernameField, 62, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, usernameField, -80, SpringLayout.EAST, this);
        add(usernameField);
        usernameField.setColumns(10);
        
        //Password Field
        pwdField = new JPasswordField("Password");
        pwdField.setColumns(10);
        pwdField.setFont(new Font("Montserrat", Font.PLAIN, 12));
        setupPasswordFieldPlaceholder(pwdField);
        panelLayout.putConstraint(SpringLayout.NORTH, pwdField, 20, SpringLayout.SOUTH, usernameField);
        panelLayout.putConstraint(SpringLayout.WEST, pwdField, 0, SpringLayout.WEST, usernameField);
        panelLayout.putConstraint(SpringLayout.EAST, pwdField, 0, SpringLayout.EAST, usernameField);
        pwdField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        add(pwdField);
        
        // Add "Show Password" checkbox
        showPasswordCheckBox = new JCheckBox("Show Password");
        panelLayout.putConstraint(SpringLayout.NORTH, showPasswordCheckBox, 6, SpringLayout.SOUTH, pwdField);
        panelLayout.putConstraint(SpringLayout.WEST, showPasswordCheckBox, 58, SpringLayout.WEST, this);
        showPasswordCheckBox.setBackground(Color.WHITE);
        showPasswordCheckBox.setFont(new Font("Montserrat", Font.BOLD, 12));
        showPasswordCheckBox.addActionListener(this);
        add(showPasswordCheckBox);
        
        loginButton = new RoundButton("Log In", 30);
        
        //Log In Button
        loginButton = new JButton("Log In");
        panelLayout.putConstraint(SpringLayout.NORTH, loginButton, 34, SpringLayout.SOUTH, showPasswordCheckBox);
        panelLayout.putConstraint(SpringLayout.WEST, loginButton, 71, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, loginButton, 76, SpringLayout.SOUTH, showPasswordCheckBox);
        panelLayout.putConstraint(SpringLayout.EAST, loginButton, -8, SpringLayout.EAST, usernameField);
        loginButton.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 16));
        loginButton.setBorderPainted(false);
        loginButton.setBorder(new LineBorder(new Color(0, 0, 0)));
        loginButton.setBackground(new Color(128, 0, 0));
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.addActionListener(this);
        add(loginButton);
        
        //"New to Polymart?" Button
        JLabel newToPolymart = new JLabel("New to Polymart?");
        panelLayout.putConstraint(SpringLayout.NORTH, newToPolymart, 6, SpringLayout.SOUTH, loginButton);
        panelLayout.putConstraint(SpringLayout.WEST, newToPolymart, 94, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, newToPolymart, -202, SpringLayout.EAST, this);
        newToPolymart.setFont(new Font("Montserrat SemiBold", Font.BOLD, 12));
        add(newToPolymart);
        
        //Sign up here button
        signUpButton = new JButton("Sign up here");
        signUpButton.setOpaque(false);
        signUpButton.setFocusable(false);
        panelLayout.putConstraint(SpringLayout.NORTH, signUpButton, -1, SpringLayout.NORTH, newToPolymart);
        panelLayout.putConstraint(SpringLayout.WEST, signUpButton, 6, SpringLayout.EAST, newToPolymart);
        signUpButton.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(128, 0, 0)));
        signUpButton.setForeground(new Color(128, 0, 0));
        signUpButton.setFont(new Font("Montserrat SemiBold", Font.BOLD, 12));
        signUpButton.addActionListener(this);
        add(signUpButton);
    }
 
    //Checks if the field is empty
    private boolean checkIfEmpty() {
        String username = usernameField.getText().trim();
        String password = new String(pwdField.getPassword()).trim();

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
                pwdField.setEchoChar((char) 0); // Show password
            } else {
                pwdField.setEchoChar('*'); // Hide password
            }
        } else if (source == signUpButton) {
        	clearTextFields();
            CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "BuyerSignupPanel");
        } else if (source == loginButton) {
        	// Check for empty fields before proceeding
            if (checkIfEmpty()) {
                String username = usernameField.getText().trim();
                String password = new String(pwdField.getPassword()).trim();

                //Call method to validate login info
                validateLogin(username, password);
            }
        }
    }
    
    private void validateLogin(String username, String password) {
    // Specify the path to the user_info.txt file inside the databases folder
      String filePath = "databases/buyer_userinfo.txt"; 
      boolean usernameFound = false;
      
      try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
          String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 5) {
                    if(userData[0].equals(username)) {
                    	usernameFound = true;
                    	if(userData[4].equals(password)) {
                    		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                            new CustomDialog(frame, "Login success!", "Welcome to the fam, baks! We're glad to have you here on Polymart <3 Feel free to scroll and explore our dashboard ^__^", "Thank you!");
                            //Switching to DashboardPanel
                    		CardLayout clLayout = (CardLayout) contentPane.getLayout();
                            clLayout.show(contentPane, "BuyerDashboardPanel");
                    		break;
                    	} else {
                    		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                            new CustomDialog(frame, "You're WRONG!", "mali username mo or password mo - ewan ko sau te ulitin mo yan", "Try Again");
                      		break;
                    	}
                    } 
                } 
            }
            if(!usernameFound) {
            	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                new CustomDialog(frame, "pauso SPOTTED!", "hindi ka pa nags-sign up baks, wag kang una una jan! mag sign up ka muna gew", "Create Account");
                //Switch to sign up panel
                clearTextFields();
                CardLayout clLayout = (CardLayout) contentPane.getLayout();
                clLayout.show(contentPane, "BuyerSignupPanel");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
    
    //Password Field Label Placeholder
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
    
    private void clearTextFields() {
        // Reset text fields to their placeholder values
        usernameField.setText("Username");
        usernameField.setForeground(Color.GRAY);

        pwdField.setText("Password");
        pwdField.setForeground(Color.GRAY);
        pwdField.setEchoChar((char) 0);  // Reset password echo char for the placeholder
    }
} 
