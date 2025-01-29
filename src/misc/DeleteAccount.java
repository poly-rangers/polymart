package misc;

import javax.swing.*;

import buyer.BuyerNavigationBar;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;


public class DeleteAccount extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtUsername;
    private JTextField txtEmail;
    private JPasswordField pwdPassword;
    private RoundedButton btnSave;
    private JButton btnGoBack;

    public DeleteAccount(JPanel contentPane) {
    	this.contentPane = contentPane;
    	
        setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        setLayout(null);

        //Header Image
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_buyer.icon.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        startupImage.setBounds(16, 24, 150, 47);
        add(startupImage);
    

        JLabel lblNewLabel = new JLabel("My Profile");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        lblNewLabel.setBounds(0, 82, 416, 24);
        lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 20));
        add(lblNewLabel);
        
        ImageIcon productPic = new ImageIcon(this.getClass().getResource("/editprofile_placeholder.png"));
        JLabel pic = new JLabel(productPic);
        pic.setBounds(159, 117, 100, 100);
        add(pic);
        
        
        BuyerNavigationBar navBar = new BuyerNavigationBar(contentPane);
        navBar.setBounds(0, 611, 416, 52);

        add(navBar);
        
        navBar.btnHome.addActionListener(e -> switchPanel("BuyerDashboardPanel"));
        navBar.btnMap.addActionListener(e -> switchPanel("BuyerMap"));
        navBar.btnOrders.addActionListener(e -> switchPanel("BuyerOrderPanel"));
        navBar.btnProfile.addActionListener(e -> System.out.println("Already on Profile Panel"));
        
        JLabel lblFirstName = new JLabel("First Name");
        lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
        lblFirstName.setFont(new Font("Montserrat", Font.BOLD, 14));
        lblFirstName.setAlignmentX(1.0f);
        lblFirstName.setBounds(43, 245, 318, 24);
        add(lblFirstName);
        
        txtFirstName = new JTextField();
        setupTextFieldPlaceholder(txtFirstName, "kenny calvino");
        txtFirstName.setFont(new Font("Montserrat", Font.PLAIN, 12));
        txtFirstName.setBounds(42, 271, 319, 20);
        add(txtFirstName);
        txtFirstName.setColumns(10);
        
        JLabel lblLastName = new JLabel("Last Name");
        lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
        lblLastName.setFont(new Font("Montserrat", Font.BOLD, 14));
        lblLastName.setAlignmentX(1.0f);
        lblLastName.setBounds(44, 302, 318, 24);
        add(lblLastName);
        
        txtLastName = new JTextField();
        setupTextFieldPlaceholder(txtLastName, "satrue");
        txtLastName.setFont(new Font("Montserrat", Font.PLAIN, 12));
        txtLastName.setColumns(10);
        txtLastName.setBounds(44, 325, 319, 20);
        add(txtLastName);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
        lblUsername.setFont(new Font("Montserrat", Font.BOLD, 14));
        lblUsername.setAlignmentX(1.0f);
        lblUsername.setBounds(43, 356, 318, 24);
        add(lblUsername);
        
        txtUsername = new JTextField();
        setupTextFieldPlaceholder(txtUsername, "@kirisuaki");
        txtUsername.setFont(new Font("Montserrat", Font.PLAIN, 12));
        txtUsername.setColumns(10);
        txtUsername.setBounds(43, 379, 319, 20);
        add(txtUsername);
        
        JLabel lblEmail = new JLabel("E-mail");
        lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
        lblEmail.setFont(new Font("Montserrat", Font.BOLD, 14));
        lblEmail.setAlignmentX(1.0f);
        lblEmail.setBounds(43, 410, 318, 24);
        add(lblEmail);
        
        txtEmail = new JTextField();
        setupTextFieldPlaceholder(txtEmail, "kennyrogers@gmail.com");
        txtEmail.setFont(new Font("Montserrat", Font.PLAIN, 12));
        txtEmail.setColumns(10);
        txtEmail.setBounds(43, 433, 319, 20);
        add(txtEmail);
        
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
        add(pwdPassword);
        
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
        pnlHeader.setBounds(20, 91, 56, 32);
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
		Object objSourceEvent = e.getSource();
		
		if (objSourceEvent == btnGoBack) {
            CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "BuyerProfile");
        }
	}
}