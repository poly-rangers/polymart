package misc;
import javax.swing.*;

import java.awt.*;

public class OrderListPanel extends JPanel {
    public JPanel ordersPanel = new JPanel();
    protected JPanel contentPanel;
    protected  JScrollPane scrollPane;
    protected String[] arrHeaders = {"Date", "Shop", "Location", "Time", "Total", "Details"};
	private Container headerPanel;
	private JLabel lblNoOrders;

    public OrderListPanel() {
        setBackground(Color.WHITE);
        setBounds(0, -19, 414, 500);
        setLayout(null);
        
        //ordersPanel = new JPanel();
        ordersPanel.setLayout(new BoxLayout(ordersPanel, BoxLayout.Y_AXIS));
        ordersPanel.setBackground(Color.WHITE);
        
        lblNoOrders = new JLabel("No Orders");
        lblNoOrders.setBounds(100, 90, 100, 50);
        lblNoOrders.setForeground(new Color(128, 128, 128));
        lblNoOrders.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 20));
        lblNoOrders.setHorizontalAlignment(SwingConstants.CENTER); 
        lblNoOrders.setVisible(false);
        add(lblNoOrders);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 394, 463);
        scrollPane.setFont(new Font("Montserrat Light", Font.PLAIN, 10));
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBar());
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);
        
        // Header Panel
        headerPanel = new JPanel(new GridLayout(1, 6));
        headerPanel.setMaximumSize(new Dimension(32767, 30));
        headerPanel.setPreferredSize(new Dimension(414, 30));
        headerPanel.setBackground(Color.WHITE);
        
        createHeaderPanel(arrHeaders);
        ((JComponent) headerPanel).setBorder(BorderFactory.createMatteBorder(0,  0,  1,  0,  Color.LIGHT_GRAY));
        
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);

        contentPanel.add(headerPanel);
        contentPanel.add(ordersPanel);
        
        scrollPane.setViewportView(contentPanel);

        createOrdersPanel();
        checkNoOrders();
        fixTableFormat(ordersPanel.getComponentCount());
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBar());
        scrollPane.getHorizontalScrollBar().setUI(new CustomScrollBar());
    }
    
    //Create panel for the header
    protected void createHeaderPanel(String[] headerTitles){
    	 for (String header : arrHeaders) {
             JLabel lblHeaderTitle = new JLabel(header);
             lblHeaderTitle.setForeground(new Color(0x730C0C));
             lblHeaderTitle.setHorizontalAlignment(SwingConstants.CENTER);
             lblHeaderTitle.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 10));
             headerPanel.add(lblHeaderTitle);
         }
    }
    
    //Create panel for the list of orders
    protected void createOrdersPanel() {
        ordersPanel.removeAll();
        ordersPanel.setLayout(new GridLayout(0, 1, 0, 5));
        ordersPanel.setBackground(Color.WHITE);
    
        revalidate();
        repaint();
    }
    
    //Makes sure that the rows are vertically aligned properly
    protected void fixTableFormat(int componentCount) {
    	componentCount = ordersPanel.getComponentCount();
        for (int i = componentCount; i < 15; i++) {
            ordersPanel.add(new JLabel(""));
        }
        revalidate();
        repaint();
    }
    
    //Display the lblNoOrders if there are no orders added 
    protected void checkNoOrders() {
    	if (ordersPanel.getComponentCount() == 0) {
    		lblNoOrders.setVisible(true);
            scrollPane.setViewportView(lblNoOrders);  
        } else {
            scrollPane.setViewportView(contentPanel); 
        }
        revalidate();
        repaint();
    }


}

