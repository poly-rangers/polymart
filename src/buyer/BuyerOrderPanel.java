package buyer;

import javax.swing.*;
import misc.OrderListPanel;
import java.awt.*;

public class BuyerOrderPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public BuyerOrderPanel(JPanel contentPane) {
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
        
        JLabel lblNewLabel = new JLabel("Your Orders");
        lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        lblNewLabel.setBounds(211, 51, 180, 50);
        lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 25));
        add(lblNewLabel);
        
        BuyerNavigationBar navBar = new BuyerNavigationBar(contentPane);
        navBar.setBounds(0, 611, 416, 52);
        add(navBar);
        
        navBar.btnHome.addActionListener(e -> switchPanel("BuyerDashboardPanel"));
        navBar.btnMap.addActionListener(e -> switchPanel("BuyerDashboardMap"));
        navBar.btnOrders.addActionListener(e -> System.out.println("Already on Orders Panel"));
        navBar.btnProfile.addActionListener(e -> switchPanel("BuyerProfile"));
        
        JButton btnActiveOrders = new JButton("Active Orders");
        btnActiveOrders.setBounds(186, 101, 95, 21);
        btnActiveOrders.setBackground(Color.WHITE);
        btnActiveOrders.setForeground(Color.BLACK);
        btnActiveOrders.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
        btnActiveOrders.setFocusable(false);
        btnActiveOrders.setOpaque(false);
        btnActiveOrders.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(0x730C0C)));
        add(btnActiveOrders);

        JButton btnCompleteOrders = new JButton("Completed Orders");
        btnCompleteOrders.setBackground(new Color(240, 240, 240));
        btnCompleteOrders.setBounds(283, 101, 108, 21);
        btnCompleteOrders.setForeground(Color.BLACK);
        btnCompleteOrders.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
        btnCompleteOrders.setFocusable(false);
        btnCompleteOrders.setOpaque(false);
        btnCompleteOrders.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, new Color(0x730C0C)));
        add(btnCompleteOrders);

        // Create JLayeredPane for Active Orders and Completed Orders
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 149, 414, 462);
        add(layeredPane);
        
        OrderListPanel activeOrdersPanel = new BuyerActiveOrders();
        activeOrdersPanel.setBounds(0, -19, 414, 500);
        
        OrderListPanel completedOrdersPanel = new BuyerCompletedOrders();
        layeredPane.add(completedOrdersPanel);
        layeredPane.add(activeOrdersPanel);

        btnActiveOrders.setForeground(new Color(0x730C0C));
        completedOrdersPanel.setVisible(false);
        activeOrdersPanel.setVisible(true);

        btnActiveOrders.addActionListener(e -> {
        	btnCompleteOrders.setForeground(Color.BLACK);
        	btnActiveOrders.setForeground(new Color(0x730C0C));
            completedOrdersPanel.setVisible(false);
            activeOrdersPanel.setVisible(true);
        });

        btnCompleteOrders.addActionListener(e -> {
        	btnActiveOrders.setForeground(Color.BLACK);
        	btnCompleteOrders.setForeground(new Color(0x730C0C));
        	
            completedOrdersPanel.setVisible(true);
            activeOrdersPanel.setVisible(false);
        });
    }
    
    private void switchPanel(String panelName) {
        if (contentPane.getLayout() instanceof CardLayout) {
            ((CardLayout) contentPane.getLayout()).show(contentPane, panelName);
        } else {
            System.err.println("Error: contentPane is not using CardLayout!");
        }
    }
}
