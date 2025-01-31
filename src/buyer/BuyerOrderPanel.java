package buyer;

import javax.swing.*;
import misc.OrderListPanel;
import misc.UserBaseTemplate;

import java.awt.*;

public class BuyerOrderPanel extends UserBaseTemplate {
	private JButton btnActiveOrders, btnCompleteOrders;
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    public BuyerOrderPanel(JPanel contentPane) {
		super(contentPane, "buyer");
		contentPanel.setBounds(0, 147, 416, 462);
		headerPanel.setBounds(0, 74, 416, 75);
	}

    protected void setPanelHeader() {
    	contentPanel.removeAll();
		headerPanel.setLayout(null);
		
    	JLabel lblYourOrders = new JLabel("Your Orders");
        lblYourOrders.setHorizontalAlignment(SwingConstants.TRAILING);
        lblYourOrders.setAlignmentX(Component.RIGHT_ALIGNMENT);
        lblYourOrders.setBounds(226, -13, 180, 50);
        lblYourOrders.setFont(new Font("Montserrat", Font.BOLD, 25));
        headerPanel.add(lblYourOrders);

        btnActiveOrders = new JButton("Active Orders");
        btnActiveOrders.setBounds(208, 38, 95, 21);
        btnActiveOrders.setBackground(Color.WHITE);
        btnActiveOrders.setForeground(Color.BLACK);
        btnActiveOrders.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
        btnActiveOrders.setFocusable(false);
        btnActiveOrders.setOpaque(false);
        btnActiveOrders.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(0x730C0C)));
        headerPanel.add(btnActiveOrders);

        btnCompleteOrders = new JButton("Completed Orders");
        btnCompleteOrders.setBackground(new Color(240, 240, 240));
        btnCompleteOrders.setBounds(298, 38, 108, 21);
        btnCompleteOrders.setForeground(Color.BLACK);
        btnCompleteOrders.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
        btnCompleteOrders.setFocusable(false);
        btnCompleteOrders.setOpaque(false);
        btnCompleteOrders.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, new Color(0x730C0C)));
        headerPanel.add(btnCompleteOrders);
        
        revalidate();
        repaint();
    }
    
    public void customizeContentPanel() {
    	this.contentPane = contentPane;
    	contentPanel.removeAll();
       
        // Create JLayeredPane for Active Orders and Completed Orders
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 414, 458);
        contentPanel.add(layeredPane);

        
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
