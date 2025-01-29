package buyer;

import javax.swing.*;
import java.awt.*;


public class BuyerMap extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public BuyerMap(JPanel contentPane) {
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
        
        JLabel lblNewLabel = new JLabel("Map");
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        lblNewLabel.setBounds(48, 95, 193, 50);
        lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 25));
        add(lblNewLabel);
        
        JLabel lblPlaceholder = new JLabel("(this is a placeholder)");
        lblPlaceholder.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlaceholder.setAlignmentX(Component.RIGHT_ALIGNMENT);
        lblPlaceholder.setBounds(107, 258, 193, 50);
        lblPlaceholder.setFont(new Font("Montserrat", Font.ITALIC, 12));
        add(lblPlaceholder);
        
        BuyerNavigationBar navBar = new BuyerNavigationBar(contentPane);
        navBar.setBounds(0, 611, 416, 52);
        add(navBar);
        
        navBar.btnHome.addActionListener(e -> switchPanel("BuyerDashboardPanel"));
        navBar.btnMap.addActionListener(e -> System.out.println("Already on Map Panel"));
        navBar.btnOrders.addActionListener(e -> switchPanel("BuyerOrderPanel"));
        navBar.btnProfile.addActionListener(e -> switchPanel("BuyerProfile"));
    }
    
    private void switchPanel(String panelName) {
        if (contentPane.getLayout() instanceof CardLayout) {
            ((CardLayout) contentPane.getLayout()).show(contentPane, panelName);
        } else {
            System.err.println("Error: contentPane is not using CardLayout!");
        }
    }
}