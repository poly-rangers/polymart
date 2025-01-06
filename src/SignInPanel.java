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

public class SignInPanel extends JPanel implements ActionListener{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usernameField;
    private JPasswordField pwdField;
    private JCheckBox showPasswordCheckBox;
    private JButton signUpButton;
    private JButton loginButton;

    public SignInPanel(JPanel contentPane) {
        this.contentPane = contentPane;
        
        setBackground(new Color(255, 255, 255));
        setBounds(100, 100, 414, 660);
        SpringLayout panelLayout = new SpringLayout();
        setLayout(panelLayout);
        
        // Icon next to header title
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_icon.png"));
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
        
        JLabel newToPolymart = new JLabel("New to Polymart?");
        panelLayout.putConstraint(SpringLayout.NORTH, newToPolymart, 6, SpringLayout.SOUTH, loginButton);
        panelLayout.putConstraint(SpringLayout.WEST, newToPolymart, 94, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, newToPolymart, -202, SpringLayout.EAST, this);
        newToPolymart.setFont(new Font("Montserrat SemiBold", Font.BOLD, 12));
        add(newToPolymart);
        
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
            CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "SignupPanel");
        } else if (source == loginButton) {
            String username = usernameField.getText();
            String password = new String(pwdField.getPassword());
            
            //Call method to validate login info
            validateLogin(username, password);   
      
        }
    }
    
    private void validateLogin(String username, String password) {
    // Specify the path to the user_info.txt file inside the databases folder
      String filePath = "databases/user_info.txt"; 
      boolean usernameFound = false;
      
      try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
          String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 5) {
                    if(userData[0].equals(username)) {
                    	usernameFound = true;
                    	if(userData[4].equals(password)) {
                    		JOptionPane.showMessageDialog(this, "Login Successful", "Login Success", JOptionPane.INFORMATION_MESSAGE);
                            //Switching to DashboardPanel
                    		CardLayout clLayout = (CardLayout) contentPane.getLayout();
                            clLayout.show(contentPane, "DashboardPanel");
                    		break;
                    	} else {
                    		JOptionPane.showMessageDialog(this, "Incorrect Password", "Login Error", JOptionPane.ERROR_MESSAGE);
                    		break;
                    	}
                    } 
                } 
            }
            if(!usernameFound) {
                	JOptionPane.showMessageDialog(this, "Username not found", "Login Error", JOptionPane.ERROR_MESSAGE);
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
}
