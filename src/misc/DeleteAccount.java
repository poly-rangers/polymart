package misc;

import javax.swing.*;

import buyer.BuyerNavigationBar;
import seller.SellerNavigationBar;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;


public class DeleteAccount extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private RoundedButton btnDeleteAccount, btnCancel;
    private JButton btnGoBack;

    public DeleteAccount(JPanel contentPane, String userType) {
    	this.contentPane = contentPane;
    	
        setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        setLayout(null);

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
            
        } else {
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
        
        JPanel pnlHeader = new JPanel();
        pnlHeader.setLayout(new BoxLayout(pnlHeader, BoxLayout.X_AXIS));
        pnlHeader.setOpaque(true);
        pnlHeader.setBounds(20, 91, 56, 32);
        pnlHeader.setBackground(Color.WHITE);

        ImageIcon ogGoBackIcon = new ImageIcon(this.getClass().getResource("/arrowbackicon.png"));
        Image scaledGoBackIcon = ogGoBackIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
    
        btnGoBack = new JButton();
        btnGoBack.setIcon(new ImageIcon(scaledGoBackIcon));
        btnGoBack.setBackground(Color.WHITE);
        btnGoBack.setFocusPainted(false);
        btnGoBack.setBorderPainted(false);
        btnGoBack.addActionListener(e -> {
            if (userType.equals("buyer")) {
                switchPanel("BuyerProfile");
            } else {
                switchPanel("SellerProfile");
            }
        });
        pnlHeader.add(btnGoBack);

        add(pnlHeader);
        
        JLabel lblTitle = new JLabel("Delete Account");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setAlignmentX(Component.RIGHT_ALIGNMENT);
        lblTitle.setBounds(0, 91, 416, 32);
        lblTitle.setFont(new Font("Montserrat", Font.BOLD, 22));
        add(lblTitle);
        
        JLabel lblHeader = new JLabel("<html>Are you sure you want to delete your Polymart account?</html>");
        lblHeader.setHorizontalAlignment(SwingConstants.LEFT);
        lblHeader.setFont(new Font("Montserrat", Font.BOLD, 20));
        lblHeader.setAlignmentX(1.0f);
        lblHeader.setBounds(40, 163, 337, 52);
        add(lblHeader);
        
        JLabel lblSubheader = new JLabel("Sure k n ba jn, baks? Baka mamiss mo kami...");
        lblSubheader.setForeground(Color.GRAY);
        lblSubheader.setHorizontalAlignment(SwingConstants.LEFT);
        lblSubheader.setFont(new Font("Montserrat", Font.ITALIC, 14));
        lblSubheader.setAlignmentX(1.0f);
        lblSubheader.setBounds(40, 215, 337, 24);
        add(lblSubheader);
        
        JLabel lblDetails = new JLabel("<html>Once you delete your account, it cannot be undone. "
        		+ "All of your content will be permanently erased—including your entire profile, "
        		+ "ratings & reviews, and all of your receipts.<br><br>Deleting your PolyMart account "
        		+ "will cancel all of your pending and active orders. If you’re not sure, you can "
        		+ "always cancel below.</html>");
        lblDetails.setHorizontalAlignment(SwingConstants.LEFT);
        lblDetails.setFont(new Font("Montserrat", Font.PLAIN, 14));
        lblDetails.setAlignmentX(1.0f);
        lblDetails.setBounds(40, 243, 334, 228);
        add(lblDetails);
        
        btnDeleteAccount = new RoundedButton("Delete Account", 45);
        btnDeleteAccount.setForeground(Color.WHITE);
        btnDeleteAccount.setFont(new Font("Montserrat", Font.BOLD, 12));
        btnDeleteAccount.setFocusable(false);
        btnDeleteAccount.setFocusPainted(false);
        btnDeleteAccount.setBackground(new Color(102, 0, 0));
        btnDeleteAccount.setBounds(103, 482, 195, 38);
        btnDeleteAccount.addActionListener(e -> switchPanel("DeleteAccountPanel"));
        add(btnDeleteAccount);
        
        btnCancel = new RoundedButton("Cancel", 45);
        btnCancel.setForeground(new Color(128, 128, 128));
        btnCancel.setFont(new Font("Montserrat", Font.BOLD, 12));
        btnCancel.setFocusable(false);
        btnCancel.setFocusPainted(false);
        btnCancel.setBackground(new Color(192, 192, 192));
        btnCancel.setBounds(103, 531, 195, 32);
        btnCancel.addActionListener(e -> {
            if (userType.equals("buyer")) {
                switchPanel("BuyerProfile");
            } else {
                switchPanel("SellerProfile");
            }
        });
        add(btnCancel);
       
    }
    
    private void switchPanel(String panelName) {
        if (contentPane.getLayout() instanceof CardLayout) {
            ((CardLayout) contentPane.getLayout()).show(contentPane, panelName);
        } else {
            System.err.println("Error: contentPane is not using CardLayout!");
        }
    }
}