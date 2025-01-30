package misc;

import java.awt.*;
import javax.swing.*;

import buyer.BuyerNavigationBar;

public class DashboardMap extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private String userRole;
//	private int cornerRadius = 30;
	
	public DashboardMap(JPanel contentPane, String userRole) {
		this.contentPane = contentPane;
		this.userRole = userRole;
		
		setSize(414, 660);
		setBackground(Color.WHITE);
		setLayout(null);
		
		String strImagePath = userRole.equalsIgnoreCase("Buyer")
                ? "/polypup_buyer.icon.png"
                : "/polypup_seller.icon.png";

        ImageIcon originalImage = new ImageIcon(this.getClass().getResource(strImagePath));
        Image scaledImage = originalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        startupImage.setBounds(16, 24, 150, 47);
        add(startupImage);

        ImageIcon legendIcon = new ImageIcon(this.getClass().getResource("/map_legend_icon.png"));
        Image scaledLegend = legendIcon.getImage().getScaledInstance(24, 25, Image.SCALE_SMOOTH);

        ImageIcon locationIcon = new ImageIcon(this.getClass().getResource("/location_pin_icon.png"));
        Image scaledIcon = locationIcon.getImage().getScaledInstance(24, 25, Image.SCALE_SMOOTH);

        ImageIcon mapImage = new ImageIcon(this.getClass().getResource("/pupmain_map_upscaled.png"));
        Image scaledMap = mapImage.getImage().getScaledInstance(325, 275, Image.SCALE_SMOOTH);

        RoundedPanel pnlMain = new RoundedPanel(30, Color.WHITE);
        pnlMain.setBounds(18, 82, 377, 502);
        add(pnlMain);
        pnlMain.setLayout(null);
        pnlMain.setBackground(new Color(115, 12, 12));

        JLabel lblMeetUpLoc = new JLabel("Main Meet-up Locations");
        lblMeetUpLoc.setBounds(64, 22, 197, 19);
        lblMeetUpLoc.setFont(new Font("Montserrat", Font.BOLD, 15));
        lblMeetUpLoc.setForeground(Color.WHITE);
        pnlMain.add(lblMeetUpLoc);

        JLabel legendLogo = new JLabel(new ImageIcon(scaledLegend));
        legendLogo.setBounds(30, 332, 32, 30); // Positioning the image inside the frame
        pnlMain.add(legendLogo);

        JLabel lblMapLegend = new JLabel("Map Legend");
        lblMapLegend.setForeground(Color.WHITE);
        lblMapLegend.setFont(new Font("Dialog", Font.BOLD, 15));
        lblMapLegend.setBounds(64, 332, 197, 30);
        pnlMain.add(lblMapLegend);

        JLabel locationLogo = new JLabel(new ImageIcon(scaledIcon));
        locationLogo.setBounds(30, 11, 31, 42); // Positioning the image inside the frame
        pnlMain.add(locationLogo);

        JLabel mapImageIcon = new JLabel(new ImageIcon(scaledMap));
        mapImageIcon.setBounds(30, 53, 320, 276); // Positioning the image inside the frame
        pnlMain.add(mapImageIcon);
        
        RoundedPanel legendPanel = new RoundedPanel(10, Color.WHITE);
        legendPanel.setBackground(Color.WHITE);
        legendPanel.setBounds(30, 374, 320, 105);
        pnlMain.add(legendPanel);
        legendPanel.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(null);
        scrollPane.setBounds(20, 10, 300, 85);
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBar());
        legendPanel.add(scrollPane);
        
        String[] arrLocations = {"1. Lagoon", "6. Linear Park",
        							"2. West Wing", "7. Charlie Building",
        							"3. Dome", "8. Grandstand",
        							"4. East Wing", "9. Tennis Courtside",
        							"5. South Wing", "10. Souvenir Shop",
        							"11. Gate Exit", "12. Gate Entrance"};
        
        JPanel locationsPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        locationsPanel.setBackground(Color.WHITE);
        //locationsPanel.setBackground(new Color(115, 12, 12));
        locationsPanel.setBorder(null);
        for(int i = 0; i < arrLocations.length; i++) {
        	JLabel lblLocation = new JLabel(arrLocations[i]);
        	lblLocation.setForeground(new Color(115, 12, 12));
        	lblLocation.setFont(new Font("Dialog", Font.BOLD, 12));
        	locationsPanel.add(lblLocation);
        }
        
        scrollPane.setViewportView(locationsPanel);
        
        BuyerNavigationBar navBar = new BuyerNavigationBar(contentPane);
        navBar.setBounds(0, 611, 416, 52);
        add(navBar);
        
//        if (buyer icon)
//            buyer-specific actions
//       else 
//            seller-specific actions
        
//        String strImagePath = userRole.equalsIgnoreCase("Buyer")
//                ? "/polypup_buyer.icon.png"
//                : "/polypup_seller.icon.png";
        
        if(strImagePath == "/polypup_buyer.icon.png") {
        	 navBar.btnHome.addActionListener(e -> switchPanel("BuyerDashboardPanel"));
             navBar.btnMap.addActionListener(e -> System.out.println("Already on Dashboard Map"));
             navBar.btnOrders.addActionListener(e -> switchPanel("BuyerOrderPanel"));
             navBar.btnProfile.addActionListener(e -> switchPanel("BuyerProfile"));
        } else {
        	 navBar.btnHome.addActionListener(e -> switchPanel("SellerDashboardPanel"));
             navBar.btnMap.addActionListener(e -> System.out.println("Already on Dashboard Map"));
             navBar.btnOrders.addActionListener(e -> switchPanel("SellerOrderPanel"));
             navBar.btnProfile.addActionListener(e -> switchPanel("SellerProfile"));
        }
        
       
    }
	
	private void switchPanel(String panelName) {
        if (contentPane.getLayout() instanceof CardLayout) {
            ((CardLayout) contentPane.getLayout()).show(contentPane, panelName);
        } else {
            System.err.println("Error: contentPane is not using CardLayout!");
        }
    }
}