package seller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import buyer.ActiveOrdersPanel;
import buyer.BuyerNavigationBar;
import buyer.CompletedOrdersPanel;
import misc.SearchBar;

public class SellerOrderPanel extends JPanel {
	private JPanel contentPane;

	private static final long serialVersionUID = 1L;

	public SellerOrderPanel(JPanel contentPane) {
		this.contentPane = contentPane;
    	
        setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        setLayout(null);

        //Header Image
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_seller.icon.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        startupImage.setBounds(16, 24, 150, 47);
        add(startupImage);
        
        SearchBar searchBar = new SearchBar();
        searchBar.setBounds(61, 86, 291, 24);
        searchBar.setupSearchPlaceholder("ang tamad tamad mo mag-scroll talaga naman...");
        add(searchBar);
        searchBar.setLayout(new BoxLayout(searchBar, BoxLayout.X_AXIS));
        
        BuyerNavigationBar navBar = new BuyerNavigationBar(contentPane);
        navBar.setBounds(0, 611, 416, 52);
        add(navBar);
        
        navBar.btnHome.addActionListener(e -> switchPanel("SellerDashboardPanel"));
        navBar.btnMap.addActionListener(e -> switchPanel("SellerMap"));
        navBar.btnOrders.addActionListener(e -> System.out.println("Already on Orders Panel"));
        navBar.btnProfile.addActionListener(e -> switchPanel("SellerProfile"));
 

        // Create JLayeredPane for Active Orders and Completed Orders
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 117, 414, 494);
        add(layeredPane);
        
                JButton btnCompleteOrders = new JButton("Completed Orders");
                btnCompleteOrders.setBounds(296, 30, 108, 21);
                layeredPane.add(btnCompleteOrders);
                btnCompleteOrders.setBackground(new Color(240, 240, 240));
                btnCompleteOrders.setForeground(Color.BLACK);
                btnCompleteOrders.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
                btnCompleteOrders.setFocusable(false);
                btnCompleteOrders.setOpaque(false);
                btnCompleteOrders.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, new Color(0x730C0C)));
                
                JButton btnActiveOrders = new JButton("Active Orders");
                btnActiveOrders.setBounds(196, 30, 108, 21);
                layeredPane.add(btnActiveOrders);
                btnActiveOrders.setBackground(Color.WHITE);
                btnActiveOrders.setForeground(Color.BLACK);
                btnActiveOrders.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
                btnActiveOrders.setFocusable(false);
                btnActiveOrders.setOpaque(false);
                btnActiveOrders.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(0x730C0C)));
                
                JLabel lblMeetups = new JLabel("Meet Ups");
                lblMeetups.setBounds(45, 10, 193, 50);
                layeredPane.add(lblMeetups);
                lblMeetups.setFont(new Font("Montserrat", Font.BOLD, 25));

        
//        ActiveOrdersPanel activeOrdersPanel = new ActiveOrdersPanel();
//        activeOrdersPanel.setBounds(0, -19, 414, 500);
        
//        CompletedOrdersPanel completedOrdersPanel = new CompletedOrdersPanel();
//        layeredPane.add(completedOrdersPanel, "CompletedOrdersPanel");
//        layeredPane.add(activeOrdersPanel, "ActiveOrdersPanel");
//
//        btnActiveOrders.setForeground(new Color(0x730C0C));
//        completedOrdersPanel.setVisible(false);
//        activeOrdersPanel.setVisible(true);
//
//        btnActiveOrders.addActionListener(e -> {
//        	btnCompleteOrders.setForeground(Color.BLACK);
//        	btnActiveOrders.setForeground(new Color(0x730C0C));
//            completedOrdersPanel.setVisible(false);
//            activeOrdersPanel.setVisible(true);
//        });
//
//        btnCompleteOrders.addActionListener(e -> {
//        	btnActiveOrders.setForeground(Color.BLACK);
//        	btnCompleteOrders.setForeground(new Color(0x730C0C));
//        	
//            completedOrdersPanel.setVisible(true);
//            activeOrdersPanel.setVisible(false);
//        });
    }
	 private void switchPanel(String panelName) {
	        if (contentPane.getLayout() instanceof CardLayout) {
	            ((CardLayout) contentPane.getLayout()).show(contentPane, panelName);
	        } else {
	            System.err.println("Error: contentPane is not using CardLayout!");
	        }
	}

}
