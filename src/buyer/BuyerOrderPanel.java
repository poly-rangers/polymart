package buyer;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

import buyer.BuyerDashboardPanel.CustomScrollBarUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class BuyerOrderPanel extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    public BuyerOrderPanel(JPanel contentPane) {
        setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Your Orders");
        lblNewLabel.setBounds(31, 26, 171, 50);
        lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 25));
        add(lblNewLabel);

        BuyerNavigationBar navBar = new BuyerNavigationBar();
        navBar.setBounds(0, 610, 414, 50);
        add(navBar);

        JButton btnActiveOrders = new JButton("Active Orders");
        btnActiveOrders.setBounds(198, 86, 95, 21);
        btnActiveOrders.setBackground(Color.WHITE);
        btnActiveOrders.setForeground(Color.BLACK);
        btnActiveOrders.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
        btnActiveOrders.setFocusable(false);
        btnActiveOrders.setOpaque(false);
        btnActiveOrders.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(0x730C0C)));
        add(btnActiveOrders);

        JButton btnReceipts = new JButton("Receipts");
        btnReceipts.setBackground(new Color(240, 240, 240));
        btnReceipts.setBounds(289, 86, 85, 21);
        btnReceipts.setForeground(Color.BLACK);
        btnReceipts.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
        btnReceipts.setFocusable(false);
        btnReceipts.setOpaque(false);
        btnReceipts.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, new Color(0x730C0C)));
        add(btnReceipts);
        
//        BuyerNavigationBar navBar1 = new BuyerNavigationBar();
//        navBar1.setBounds(400,  86,  300, 100);
//        add(navBar1);

    

        // Create JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 130, 414, 481);
        add(layeredPane);

        // Create Receipt Panel
        JPanel receiptPanel = new JPanel();
        receiptPanel.setLayout(null);
        receiptPanel.setBackground(Color.WHITE);
        receiptPanel.setBounds(0, -19, 414, 500);
        
        JTextArea textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setBorder(null);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setBackground(Color.WHITE);
        textArea.setForeground(Color.BLACK);
        textArea.setEditable(false);
        textArea.setBounds(22, 20, 371, 315);
       textArea.setText(generateReceiptText(mockDatabase()));
       
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        scrollPane.setViewportView(textArea);
        scrollPane.setBounds(32, 20, 359, 470);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setBorder(null);
        receiptPanel.add(scrollPane);
        

        // Create Active Orders Panel
        JPanel activeOrdersPanel = new JPanel();
        activeOrdersPanel.setBackground(new Color(255, 255, 255));
        activeOrdersPanel.setBounds(0, 0, 414, 481);
        
        

        layeredPane.add(receiptPanel, "ReceiptPanel");
        activeOrdersPanel.setLayout(null);

        JLabel placeholderLabel = new JLabel("No Active Orders", SwingConstants.CENTER);
        placeholderLabel.setBounds(0, 0, 414, 481);
        placeholderLabel.setFont(new Font("Montserrat", Font.PLAIN, 16));
        activeOrdersPanel.add(placeholderLabel);

        layeredPane.add(activeOrdersPanel, "ActiveOrdersPanel");

        
        btnActiveOrders.setForeground(new Color(0x730C0C));
        receiptPanel.setVisible(false);
        activeOrdersPanel.setVisible(true);

        btnActiveOrders.addActionListener(e -> {
        	btnReceipts.setForeground(Color.BLACK);
        	btnActiveOrders.setForeground(new Color(0x730C0C));
            receiptPanel.setVisible(false);
            activeOrdersPanel.setVisible(true);
        });

        btnReceipts.addActionListener(e -> {
        	btnActiveOrders.setForeground(Color.BLACK);
        	btnReceipts.setForeground(new Color(0x730C0C));
            receiptPanel.setVisible(true);
            activeOrdersPanel.setVisible(false);
        });
    }
    
    class OrderItem {
        String itemName;
        int quantity;
        double price;

        public OrderItem(String itemName, int quantity, int price) {
            this.itemName = itemName;
            this.quantity = quantity;
            this.price = price;
        }
    }

    private String generateReceiptText(List<OrderItem> items) {
        StringBuilder receipt = new StringBuilder();
        receipt.append("--------------------------------------------------------------------------------------\n");
        receipt.append("Order ID                             \t\tDate Placed\n");
        receipt.append("--------------------------------------------------------------------------------------\n");
        receipt.append(String.format("%-10s %38s %35s\n", "Qty", "Item", "Price"));
        receipt.append("--------------------------------------------------------------------------------------\n");

        int total = 0;

        // Loop through order items to add them to the receipt
        for (OrderItem item : items) {
            receipt.append(String.format("%-10d %40s %35.2f\n",
                    item.quantity, item.itemName, item.price));
            total += item.price;
        }

        receipt.append("---------------------------------------------------------------------------------------\n");
        receipt.append(String.format("%-10s %-10.2f\n", "Total", (double) total));
        receipt.append("---------------------------------------------------------------------------------------\n");
        receipt.append("Seller/Shop Name\n");

        return receipt.toString();
    }

    private List<OrderItem> mockDatabase() {
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem("Item 1", 1, 21));
        items.add(new OrderItem("Item 2", 2, 52));
        items.add(new OrderItem("Item 3", 3, 65));
        items.add(new OrderItem("Item 4", 4, 105));
        items.add(new OrderItem("Item 5", 5, 35));
        items.add(new OrderItem("Item 6", 6, 21));
        items.add(new OrderItem("Item 7", 7, 52));
        items.add(new OrderItem("Item 8", 8, 65));
        items.add(new OrderItem("Item 9", 9, 105));
        items.add(new OrderItem("Item 10", 10, 35));
        items.add(new OrderItem("Item 11", 11, 21));
        items.add(new OrderItem("Item 12", 12, 52));
        items.add(new OrderItem("Item 13", 13, 65));
        items.add(new OrderItem("Item 14", 14, 105));
        items.add(new OrderItem("Item 15", 15, 35));
        items.add(new OrderItem("Item 16", 16, 21));
        items.add(new OrderItem("Item 17", 17, 52));
        items.add(new OrderItem("Item 18", 18, 65));
        items.add(new OrderItem("Item 19", 19, 105));
        items.add(new OrderItem("Item 20", 20, 35));
        return items;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
    class CustomScrollBarUI extends BasicScrollBarUI {
        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.GRAY);
            g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 10, 10);
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
        }
        
        @Override
		public Dimension getPreferredSize(JComponent c) {
            if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
                return new Dimension(5, super.getPreferredSize(c).height); // Make it 8 pixels wide
            } else {
                return new Dimension(super.getPreferredSize(c).width, 8); // Adjust for horizontal bar if needed
            }
        }
    }
}
