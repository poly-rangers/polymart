package loginPanel1;

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

public class loginPanel extends JPanel {
    private static final long serialVersionUID = 1L;
	private JTextField usernameField;
	private JPasswordField pwdField;

	public loginPanel(JPanel contentPane) {
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 414, 660);
        SpringLayout layout = new SpringLayout();
        setLayout(layout);
        
        JLabel logInLabel = new JLabel("Log In");
        logInLabel.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 24));
        add(logInLabel);
        
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/Group 14.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        JLabel imgIcon = new JLabel(new ImageIcon(scaledImage));
        layout.putConstraint(SpringLayout.NORTH, logInLabel, 87, SpringLayout.SOUTH, imgIcon);
        layout.putConstraint(SpringLayout.NORTH, imgIcon, 34, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, imgIcon, 10, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, imgIcon, -584, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.EAST, imgIcon, -359, SpringLayout.EAST, this);
        add(imgIcon);
        
        JLabel headerTitle = new JLabel("POLYMART");
        layout.putConstraint(SpringLayout.WEST, logInLabel, 0, SpringLayout.WEST, headerTitle);
        layout.putConstraint(SpringLayout.NORTH, headerTitle, 48, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, headerTitle, -2, SpringLayout.EAST, imgIcon);
        headerTitle.setForeground(new Color(115, 12, 12));
        headerTitle.setFont(new Font("Montserrat ExtraBold", Font.PLAIN, 15));
        add(headerTitle);
        
        usernameField = new JTextField("Username");
        setupTextFieldPlaceholder(usernameField, "Username");
        usernameField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        usernameField.setForeground(new Color(192, 192, 192));
        usernameField.setFont(new Font("Montserrat", Font.PLAIN, 12));
        layout.putConstraint(SpringLayout.NORTH, usernameField, 25, SpringLayout.SOUTH, logInLabel);
        layout.putConstraint(SpringLayout.WEST, usernameField, 62, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, usernameField, -80, SpringLayout.EAST, this);
        add(usernameField);
        usernameField.setColumns(10);
        
        pwdField = new JPasswordField("Password");
        pwdField.setColumns(10);
        pwdField.setFont(new Font("Montserrat", Font.PLAIN, 12));
        setupPasswordFieldPlaceholder(pwdField);
        layout.putConstraint(SpringLayout.NORTH, pwdField, 20, SpringLayout.SOUTH, usernameField);
        layout.putConstraint(SpringLayout.WEST, pwdField, 0, SpringLayout.WEST, usernameField);
        layout.putConstraint(SpringLayout.EAST, pwdField, 0, SpringLayout.EAST, usernameField);
        pwdField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        add(pwdField);
        
        // Add "Show Password" checkbox
        JCheckBox showPasswordCheckBox = new JCheckBox("Show Password");
        layout.putConstraint(SpringLayout.NORTH, showPasswordCheckBox, 6, SpringLayout.SOUTH, pwdField);
        layout.putConstraint(SpringLayout.WEST, showPasswordCheckBox, 58, SpringLayout.WEST, this);
        showPasswordCheckBox.setBackground(Color.WHITE);
        showPasswordCheckBox.setFont(new Font("Montserrat", Font.BOLD, 12));
        add(showPasswordCheckBox);
        
        JButton loginButton = new JButton("Log In");
        layout.putConstraint(SpringLayout.NORTH, loginButton, 34, SpringLayout.SOUTH, showPasswordCheckBox);
        layout.putConstraint(SpringLayout.WEST, loginButton, 71, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, loginButton, 76, SpringLayout.SOUTH, showPasswordCheckBox);
        layout.putConstraint(SpringLayout.EAST, loginButton, -8, SpringLayout.EAST, usernameField);
        loginButton.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 16));
        loginButton.setBorderPainted(false);
        loginButton.setBorder(new LineBorder(new Color(0, 0, 0)));
        loginButton.setBackground(new Color(128, 0, 0));
        loginButton.setForeground(new Color(255, 255, 255));
        add(loginButton);
        
        JLabel newToPolymart = new JLabel("New to Polymart?");
        layout.putConstraint(SpringLayout.NORTH, newToPolymart, 6, SpringLayout.SOUTH, loginButton);
        layout.putConstraint(SpringLayout.WEST, newToPolymart, 94, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, newToPolymart, -202, SpringLayout.EAST, this);
        newToPolymart.setFont(new Font("Montserrat SemiBold", Font.BOLD, 12));
        add(newToPolymart);
        
        JButton btnNewButton = new JButton("Sign up here");
        btnNewButton.setOpaque(false);
        btnNewButton.setFocusable(false);
        layout.putConstraint(SpringLayout.NORTH, btnNewButton, -1, SpringLayout.NORTH, newToPolymart);
        layout.putConstraint(SpringLayout.WEST, btnNewButton, 6, SpringLayout.EAST, newToPolymart);
        btnNewButton.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(128, 0, 0)));
        btnNewButton.setForeground(new Color(128, 0, 0));
        btnNewButton.setFont(new Font("Montserrat SemiBold", Font.BOLD, 12));
        add(btnNewButton);

        // Action listener for the checkbox
        showPasswordCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckBox.isSelected()) {
                    pwdField.setEchoChar((char) 0); // Show password
                } else {
                    pwdField.setEchoChar('*'); // Hide password
                }
            }
        });
	}
	
/**	icocomment ko nalang tong main baks KDHASJKHDJAK pinangtest ko kasi yung main method
	public static void main(String[] args) {
        // Create a JFrame to host the loginPanel JPanel
        JFrame frame = new JFrame("Polymart Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(430, 700);
        
        // Add the loginPanel JPanel to the frame
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        loginPanel mainPanel = new loginPanel(contentPane);
        frame.getContentPane().add(mainPanel);
        
        // Make the frame visible
        frame.setVisible(true);
    }
	**/
	
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
