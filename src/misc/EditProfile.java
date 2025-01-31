package misc;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import buyer.BuyerNavigationBar;
import misc.PreferencesPanel;
import misc.ProfilePanel;
import seller.SellerNavigationBar;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

public class EditProfile extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtFirstName, txtLastName, txtUsername, txtEmail;
    private JPasswordField pwdPassword;
    private RoundedButton btnSave;
    private JButton btnGoBack;
    private RoundedPanel panelFirst, panelLast, panelUser, panelEmail, panelPassword;
    private String userType;

    
    public EditProfile(JPanel contentPane, String userType) {
    	this.contentPane = contentPane;
    	this.userType = userType;
    	
        setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        setLayout(null);

        // Set header image based on userType
        if (userType.equals("buyer")) {
            ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_buyer.icon.png"));
            Image scaledImage = originalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
            JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
            startupImage.setBounds(16, 24, 150, 47);
            add(startupImage);
            
            BuyerNavigationBar navBar = new BuyerNavigationBar(contentPane);
            navBar.setBounds(0, 611, 416, 52);
            add(navBar);
            
            navBar.btnHome.addActionListener(e -> switchPanel("BuyerDashboardPanel"));
            navBar.btnMap.addActionListener(e -> switchPanel("BuyerDashboardMap"));
            navBar.btnOrders.addActionListener(e -> switchPanel("BuyerOrderPanel"));
            navBar.btnProfile.addActionListener(e -> switchPanel("BuyerProfile"));
            
        } else if (userType.equals("seller")) {
            ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_seller.icon.png"));
            Image scaledImage = originalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
            JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
            startupImage.setBounds(16, 24, 150, 47);
            add(startupImage);
            
            SellerNavigationBar navBar = new SellerNavigationBar(contentPane);
            navBar.setBounds(0, 611, 416, 52);
            add(navBar);
            
            navBar.btnHome.addActionListener(e -> switchPanel("SellerDashboardPanel"));
            navBar.btnMap.addActionListener(e -> switchPanel("SellerDashboardMap"));
            navBar.btnOrders.addActionListener(e -> switchPanel("SellerOrderPanel"));
            navBar.btnProfile.addActionListener(e -> switchPanel("SellerProfile"));
        }

        ImageIcon productPic = new ImageIcon(this.getClass().getResource("/editprofile_placeholder.png"));
        JLabel pic = new JLabel(productPic);
        pic.setBounds(158, 134, 100, 100);
        add(pic);
        
        panelFirst = new RoundedPanel(15, new Color(241,241,241));
        panelFirst.setBounds(43, 267, 318, 24);
        
        
        panelLast = new RoundedPanel(15, new Color(241,241,241));
        panelLast.setBounds(44, 325, 319, 24);
        
        panelUser = new RoundedPanel(15, new Color(241,241,241));
        panelUser.setBounds(43, 379, 319, 24);
        
        
        panelEmail = new RoundedPanel(15, new Color(241,241,241));
        panelEmail.setBounds(43, 433, 319, 24);
        
        panelPassword = new RoundedPanel(15, new Color(241,241,241));
        panelPassword.setBounds(44, 485, 318, 24);
        

        
        JLabel lblFirstName = new JLabel("First Name");
        lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
        lblFirstName.setFont(new Font("Montserrat", Font.BOLD, 14));
        lblFirstName.setAlignmentX(1.0f);
        lblFirstName.setBounds(43, 244, 318, 24);
        add(lblFirstName);
        
        txtFirstName = new JTextField("First Name");
        setupTextFieldPlaceholder(txtFirstName, "First Name");
        txtFirstName.setBackground(new Color(241,241,241));
        txtFirstName.setBorder(null);
        txtFirstName.setFont(new Font("Montserrat", Font.PLAIN, 12));
        txtFirstName.setBounds(42, 280, 319, 20);
        panelFirst.add(txtFirstName);
        txtFirstName.setColumns(22);
        add(panelFirst);
        
        JLabel lblLastName = new JLabel("Last Name");
        lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
        lblLastName.setFont(new Font("Montserrat", Font.BOLD, 14));
        lblLastName.setAlignmentX(1.0f);
        lblLastName.setBounds(44, 302, 318, 24);
        add(lblLastName);
        
        txtLastName = new JTextField("Last Name");
        txtLastName.setForeground(new Color(128, 128, 128));
        setupTextFieldPlaceholder(txtLastName, "Last Name");
        txtLastName.setBackground(new Color(241,241,241));
        txtLastName.setBorder(null);
        txtLastName.setFont(new Font("Montserrat", Font.PLAIN, 12));
        txtLastName.setColumns(22);
        txtLastName.setBounds(44, 325, 319, 20);
        panelLast.add(txtLastName);
        add(panelLast);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
        lblUsername.setFont(new Font("Montserrat", Font.BOLD, 14));
        lblUsername.setAlignmentX(1.0f);
        lblUsername.setBounds(43, 356, 318, 24);
        add(lblUsername);
        
        txtUsername = new JTextField("@username");
        txtUsername.setForeground(new Color(0, 0, 0));
        setupTextFieldPlaceholder(txtUsername, "@username");
        txtUsername.setForeground(new Color(128, 128, 128));
        txtUsername.setFont(new Font("Montserrat", Font.PLAIN, 12));
        txtUsername.setColumns(22);
        txtUsername.setBackground(new Color(241,241,241));
        txtUsername.setBorder(null);
        panelUser.add(txtUsername);
        txtUsername.setBounds(43, 379, 319, 20);
        add(panelUser);
        
        JLabel lblEmail = new JLabel("E-mail");
        lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
        lblEmail.setFont(new Font("Montserrat", Font.BOLD, 14));
        lblEmail.setAlignmentX(1.0f);
        lblEmail.setBounds(43, 410, 318, 24);
        add(lblEmail);
        
        txtEmail = new JTextField("E-mail");
        setupTextFieldPlaceholder(txtEmail, "E-mail");
        txtEmail.setFont(new Font("Montserrat", Font.PLAIN, 12));
        txtEmail.setForeground(new Color(128, 128, 128));
        txtEmail.setColumns(22);
        txtEmail.setBounds(43, 433, 319, 20);
        txtEmail.setBackground(new Color(241,241,241));
        txtEmail.setBorder(null);
        panelEmail.add(txtEmail);
        add(panelEmail);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
        lblPassword.setFont(new Font("Montserrat", Font.BOLD, 14));
        lblPassword.setAlignmentX(1.0f);
        lblPassword.setBounds(43, 462, 318, 24);
        add(lblPassword);
        
        pwdPassword = new JPasswordField("Password");
        setupPasswordFieldPlaceholder(pwdPassword);
        pwdPassword.setFont(new Font("Montserrat", Font.PLAIN, 12));
        pwdPassword.setBounds(44, 485, 318, 20);
        pwdPassword.setBorder(null);
        pwdPassword.setBackground(new Color(241,241,241));
        pwdPassword.setColumns(22);
        pwdPassword.setForeground(new Color(128, 128, 128));
        panelPassword.add(pwdPassword);
        add(panelPassword);
        
        btnSave = new RoundedButton("Save Changes", 15);
        btnSave.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnSave.setForeground(Color.WHITE);
        btnSave.setFont(new Font("Montserrat", Font.BOLD, 12));
        btnSave.setFocusable(true);
        btnSave.setFocusPainted(false);
        btnSave.setBackground(new Color(102, 0, 0));
        btnSave.setBounds(232, 531, 129, 30);
        add(btnSave);
        
        JPanel pnlHeader = new JPanel();
        pnlHeader.setLayout(new BoxLayout(pnlHeader, BoxLayout.X_AXIS));
        pnlHeader.setOpaque(true);
        pnlHeader.setBounds(20, 91, 170, 32);
        pnlHeader.setBackground(Color.WHITE);

        ImageIcon ogGoBackIcon = new ImageIcon(this.getClass().getResource("/arrowbackicon.png"));
        Image scaledGoBackIcon = ogGoBackIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);

        btnGoBack = new JButton();
        btnGoBack.addActionListener(this);
        btnGoBack.setIcon(new ImageIcon(scaledGoBackIcon));
        btnGoBack.setBackground(Color.WHITE);
        btnGoBack.setFocusPainted(false);
        btnGoBack.setBorderPainted(false);
        pnlHeader.add(btnGoBack);

        add(pnlHeader);
        
                JLabel lblNewLabel = new JLabel("My Profile");
                pnlHeader.add(lblNewLabel);
                lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
                lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
                lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 20));
    }
    
    private void switchPanel(String panelName) {
        if (contentPane.getLayout() instanceof CardLayout) {
            ((CardLayout) contentPane.getLayout()).show(contentPane, panelName);
        } else {
            System.err.println("Error: contentPane is not using CardLayout!");
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
        textField.setForeground(new Color(128, 128, 128));
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
    
    private void clearTextField(JTextField textField, String placeholder) {
    	textField.setText(placeholder);
    	textField.setForeground(Color.GRAY);
    }
    
    private void clearPasswordField(JPasswordField pwdField, String placeholder) {
    	pwdField.setText(placeholder);
    	pwdField.setForeground(Color.GRAY);
    	pwdField.setEchoChar((char) 0);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object objSourceEvent = e.getSource();
		
		if (objSourceEvent == btnGoBack) {
	        clearTextField(txtFirstName, "First Name");
	        clearTextField(txtLastName, "Last Name");
	        clearTextField(txtUsername, "@username");
	        clearTextField(txtEmail, "E-mail");
	        clearPasswordField(pwdPassword, "Password");
	        if (userType.equals("buyer")) {
	            CardLayout clLayout = (CardLayout) contentPane.getLayout();
	            clLayout.show(contentPane, "BuyerProfile");
	        } else if (userType.equals("seller")) {
	            CardLayout clLayout = (CardLayout) contentPane.getLayout();
	            clLayout.show(contentPane, "SellerProfile");
	        }
        }
	}
}