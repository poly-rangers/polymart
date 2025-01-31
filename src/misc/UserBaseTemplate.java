package misc;

import java.awt.*;
import javax.swing.*;

import buyer.BuyerNavigationBar;
import seller.SellerNavigationBar;

public class UserBaseTemplate extends JPanel {
	 public JPanel contentPane, contentPanel, headerPanel;
	 private JLabel lblNewLabel;
	 private String userRole;
	 String headerImagePath;
	 
	public UserBaseTemplate(JPanel contentPane, String strUserRole) {
		this.contentPane = contentPane;
		this.userRole = strUserRole;
        setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        
        // Set the header image depending on the user role
        headerImagePath = (userRole.equals("buyer")) ? "/polypup_buyer.icon.png" : "/polypup_seller.icon.png";
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource(headerImagePath));
        Image scaledImage = originalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
        setLayout(null);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        startupImage.setBounds(16, 24, 150, 47);
        add(startupImage);
        
        headerPanel = new JPanel();
        headerPanel.setBackground(new Color(255, 255, 255));
        headerPanel.setBounds(0, 74, 416, 92);
        add(headerPanel);
        
        contentPanel = new JPanel();
        contentPanel.setBackground(new Color(255, 255, 255));
        contentPanel.setBounds(0, 166, 416, 443);
        add(contentPanel);
        contentPanel.setLayout(null);
        
        setPanelHeader();
        customizeContentPanel();       
        
        if (userRole.equals("buyer")) {
            BuyerNavigationBar buyerNavBar = new BuyerNavigationBar(contentPane);
            buyerNavBar.btnHome.addActionListener(e -> switchPanel("BuyerDashboardPanel"));
            buyerNavBar.btnMap.addActionListener(e -> switchPanel("BuyerDashboardMap"));
            buyerNavBar.btnOrders.addActionListener(e -> switchPanel("BuyerOrderPanel"));
            buyerNavBar.btnProfile.addActionListener(e -> switchPanel("BuyerProfile"));
            buyerNavBar.setBounds(0, 611, 416, 52);
            add(buyerNavBar);
        } else {
            SellerNavigationBar sellerNavBar = new SellerNavigationBar(contentPane);
            sellerNavBar.btnHome.addActionListener(e -> switchPanel("SellerDashboardPanel"));
            sellerNavBar.btnMap.addActionListener(e -> switchPanel("SellerDashboardMap"));
            sellerNavBar.btnOrders.addActionListener(e -> switchPanel("SellerOrderPanel"));
            sellerNavBar.btnProfile.addActionListener(e -> switchPanel("SellerProfile"));
            sellerNavBar.setBounds(0, 611, 416, 52);
            add(sellerNavBar);
        }
        
    }
	
	protected void setPanelHeader() {
		revalidate();
		repaint();
	}
	
	
	
	protected void customizeContentPanel() {
		revalidate();
		repaint();
	}
	
	private void switchPanel(String panelName) {
        if (contentPane.getLayout() instanceof CardLayout) {
            ((CardLayout) contentPane.getLayout()).show(contentPane, panelName);
        } else {
            System.err.println("Error: contentPane is not using CardLayout!");
        }
    }
}
