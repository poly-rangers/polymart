package seller;

import javax.swing.*;
import java.awt.*;
import misc.OrderListPanel;
import misc.UserBaseTemplate;

public class SellerOrderPanel extends UserBaseTemplate{
	private JButton btnActiveOrders, btnCompleteOrders;
	private JPanel contentPane;
	private static final long serialVersionUID = 1L;

	public SellerOrderPanel(JPanel contentPane, String strUserRole) {
		super(contentPane, "seller");
		contentPanel.setBounds(0, 141, 416, 468);
		headerPanel.setBounds(0, 74, 416, 73);
        setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        setLayout(null);
	}
	
	 protected void setPanelHeader() {
		 headerPanel.setLayout(null);
		 	btnCompleteOrders = new JButton("Completed Orders");
		 	btnCompleteOrders.setBounds(298, 38, 108, 21);
	        headerPanel.add(btnCompleteOrders);
	        btnCompleteOrders.setBackground(new Color(240, 240, 240));
	        btnCompleteOrders.setForeground(Color.BLACK);
	        btnCompleteOrders.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
	        btnCompleteOrders.setFocusable(false);
	        btnCompleteOrders.setOpaque(false);
	        btnCompleteOrders.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, new Color(0x730C0C)));
	                
	        btnActiveOrders = new JButton("Active Orders");
	        btnActiveOrders.setBounds(208, 38, 95, 21);
	        headerPanel.add(btnActiveOrders);
	        btnActiveOrders.setBackground(Color.WHITE);
	        btnActiveOrders.setForeground(Color.BLACK);
	        btnActiveOrders.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
	        btnActiveOrders.setFocusable(false);
	        btnActiveOrders.setOpaque(false);
	        btnActiveOrders.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(0x730C0C)));
	                
	        JLabel lblMeetups = new JLabel("Meet Ups");
	        lblMeetups.setHorizontalAlignment(SwingConstants.TRAILING);
	        lblMeetups.setAlignmentX(Component.RIGHT_ALIGNMENT);
	        lblMeetups.setBounds(226, 0, 180, 37);
	        lblMeetups.setFont(new Font("Montserrat", Font.BOLD, 25));
	        headerPanel.add(lblMeetups);

	 }
	
	public void customizeContentPanel() {
        // Create JLayeredPane to switch between Active Orders and Completed Orders
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(2, 0, 414, 469);
        contentPanel.add(layeredPane);
            
        // Create objects for the order list panel
        OrderListPanel activeMeetUpsPanel = new SellerActiveOrders();
        activeMeetUpsPanel.ordersPanel.setBounds(0, 127, 434, 447);
        activeMeetUpsPanel.setBounds(0, 0, 414, 469);
        
        OrderListPanel completedMeetUpsPanel = new SellerCompletedOrders();
        completedMeetUpsPanel.setBounds(0, 0, 414, 469);
        
        // Add the panels to the layered pane
        layeredPane.add(activeMeetUpsPanel);
        layeredPane.add(completedMeetUpsPanel);

        // Set initial visibility for the panels
        completedMeetUpsPanel.setVisible(false); 
        activeMeetUpsPanel.setVisible(true); 
        btnActiveOrders.setForeground(new Color(0x730C0C)); 
        
        // Button action for switching between the panels
        btnActiveOrders.addActionListener(e -> {
            btnCompleteOrders.setForeground(Color.BLACK);
            btnActiveOrders.setForeground(new Color(0x730C0C));
            completedMeetUpsPanel.setVisible(false); 
            activeMeetUpsPanel.setVisible(true); 
            layeredPane.revalidate();  
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
}
