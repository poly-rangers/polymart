package seller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;

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
        
        //Navigation Bar
        SellerNavigationBar navBar = new SellerNavigationBar(contentPane);
        navBar.setBounds(0, 611, 416, 52);
        add(navBar);
        
        //Functionalities for Navigation Bar
        navBar.btnHome.addActionListener(e -> switchPanel("SellerDashboardPanel"));
        navBar.btnMap.addActionListener(e -> switchPanel("SellerDashboardMap"));
        navBar.btnOrders.addActionListener(e -> System.out.println("Already on Orders Panel"));
        navBar.btnProfile.addActionListener(e -> switchPanel("SellerProfile"));
        
        JButton btnCompleteOrders = new JButton("Completed Orders");
        btnCompleteOrders.setBounds(296, 101, 108, 21);
        add(btnCompleteOrders);
        btnCompleteOrders.setBackground(new Color(240, 240, 240));
        btnCompleteOrders.setForeground(Color.BLACK);
        btnCompleteOrders.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
        btnCompleteOrders.setFocusable(false);
        btnCompleteOrders.setOpaque(false);
        btnCompleteOrders.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, new Color(0x730C0C)));
                
        JButton btnActiveOrders = new JButton("Active Orders");
        btnActiveOrders.setBounds(193, 101, 108, 21);
        add(btnActiveOrders);
        btnActiveOrders.setBackground(Color.WHITE);
        btnActiveOrders.setForeground(Color.BLACK);
        btnActiveOrders.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
        btnActiveOrders.setFocusable(false);
        btnActiveOrders.setOpaque(false);
        btnActiveOrders.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(0x730C0C)));
                
        JLabel lblMeetups = new JLabel("Meet Ups");
        lblMeetups.setBounds(36, 81, 193, 50);
        add(lblMeetups);
        lblMeetups.setFont(new Font("Montserrat", Font.BOLD, 25));


        // Create JLayeredPane to switch between Active Orders and Completed Orders
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(2, 132, 414, 469);
        add(layeredPane);
            
        
        // Create objects of the panels (polymorphism)
        MeetUpsPanel activeMeetUpsPanel = new ActiveMeetUpPolymorphism();
        activeMeetUpsPanel.ordersPanel.setBounds(0, 127, 434, 447);
        activeMeetUpsPanel.setBounds(0, 0, 414, 469);
        
        MeetUpsPanel completedMeetUpsPanel = new CompletedMeetUpPolymorphism();
        completedMeetUpsPanel.setBounds(0, 0, 414, 469);
        
        // Add the panels to the layered pane
        layeredPane.add(activeMeetUpsPanel);
        layeredPane.add(completedMeetUpsPanel);

        // Set initial visibility for the panels
        completedMeetUpsPanel.setVisible(false); 
        activeMeetUpsPanel.setVisible(true); 
        btnActiveOrders.setForeground(new Color(0x730C0C)); //The active orders panel is the first shown
        
        // Button action for switching between the panels
        btnActiveOrders.addActionListener(e -> {
            btnCompleteOrders.setForeground(Color.BLACK);
            btnActiveOrders.setForeground(new Color(0x730C0C));
            completedMeetUpsPanel.setVisible(false); // Hide completed meet-ups panel
            activeMeetUpsPanel.setVisible(true); // Show active meet-ups panel
            layeredPane.revalidate();  // Refresh the layout
            layeredPane.repaint();
        });

        btnCompleteOrders.addActionListener(e -> {
            btnActiveOrders.setForeground(Color.BLACK);
            btnCompleteOrders.setForeground(new Color(0x730C0C));
            completedMeetUpsPanel.setVisible(true);
            activeMeetUpsPanel.setVisible(false); 
            layeredPane.revalidate(); 
            layeredPane.repaint();
        });
 
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
