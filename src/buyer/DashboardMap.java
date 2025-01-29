package buyer;

import java.awt.*;
import javax.swing.*;
import frames.SetMeetUpFrame;
import misc.AddProduct;
import misc.RoundedPanel;
import misc.SearchBar;

import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;

public class DashboardMap extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private int cornerRadius = 30;
	
	public DashboardMap(JPanel contentPane) {
		this.contentPane = contentPane;
		
		setSize(414, 660);
		setBackground(Color.WHITE);
		setLayout(null);
		
		ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_buyer.icon.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        startupImage.setBounds(16, 24, 150, 47);
        add(startupImage);

        ImageIcon legendIcon = new ImageIcon(this.getClass().getResource("/map_legend_icon.png"));
        Image scaledLegend = legendIcon.getImage().getScaledInstance(24, 25, Image.SCALE_SMOOTH);
        
        ImageIcon legendImgList = new ImageIcon(this.getClass().getResource("/pup_legend.png"));
        Image scaledLegendList = legendImgList.getImage().getScaledInstance(351, 330, Image.SCALE_SMOOTH);
        
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

        JLabel lblLocation1 = new JLabel("1. Lagoon");
        lblLocation1.setBounds(39, 364, 69, 20);
        pnlMain.add(lblLocation1);
        lblLocation1.setForeground(Color.BLACK);
        lblLocation1.setFont(new Font("Dialog", Font.BOLD, 12));
        
        RoundedPanel legendPanel1 = new RoundedPanel(5, Color.WHITE);
        legendPanel1.setBounds(29, 364, 100, 21);
        pnlMain.add(legendPanel1);
        
        JLabel lblLocation2 = new JLabel("2. West Wing");
        lblLocation2.setBounds(39, 389, 90, 20);
        pnlMain.add(lblLocation2);
        lblLocation2.setForeground(Color.BLACK);
        lblLocation2.setFont(new Font("Dialog", Font.BOLD, 12));
        
        RoundedPanel legendPanel2 = new RoundedPanel(5, Color.WHITE);
        legendPanel2.setBounds(29, 389, 100, 21);
        pnlMain.add(legendPanel2);
        
        JLabel lblLocation3 = new JLabel("3. Dome");
        lblLocation3.setBounds(39, 414, 90, 20);
        pnlMain.add(lblLocation3);
        lblLocation3.setForeground(Color.BLACK);
        lblLocation3.setFont(new Font("Dialog", Font.BOLD, 12));
        
        RoundedPanel legendPanel3 = new RoundedPanel(5, Color.WHITE);
        legendPanel3.setBounds(29, 414, 100, 21);
        pnlMain.add(legendPanel3);
        
        JLabel lblLocation4 = new JLabel("4. East Wing");
        lblLocation4.setBounds(39, 439, 90, 20);
        pnlMain.add(lblLocation4);
        lblLocation4.setForeground(Color.BLACK);
        lblLocation4.setFont(new Font("Dialog", Font.BOLD, 12));
        
        RoundedPanel legendPanel4 = new RoundedPanel(5, Color.WHITE);
        legendPanel4.setBounds(29, 439, 100, 21);
        pnlMain.add(legendPanel4);
        
        JLabel lblLocation5 = new JLabel("5. South Wing");
        lblLocation5.setBounds(39, 464, 90, 20);
        pnlMain.add(lblLocation5);
        lblLocation5.setForeground(Color.BLACK);
        lblLocation5.setFont(new Font("Dialog", Font.BOLD, 12));
        
        RoundedPanel legendPanel5 = new RoundedPanel(5, Color.WHITE);
        legendPanel5.setBounds(29, 464, 100, 21);
        pnlMain.add(legendPanel5);
        
        JLabel lblLocation6 = new JLabel("6. Linear Park");
        lblLocation6.setBounds(145, 364, 100, 20);
        pnlMain.add(lblLocation6);
        lblLocation6.setForeground(Color.BLACK);
        lblLocation6.setFont(new Font("Dialog", Font.BOLD, 12));
        
        RoundedPanel legendPanel6 = new RoundedPanel(5, Color.WHITE);
        legendPanel6.setBounds(135, 364, 127, 21);
        pnlMain.add(legendPanel6);
        
        JLabel lblLocation7 = new JLabel("7. Charlie Building");
        lblLocation7.setBounds(145, 389, 138, 20);
        pnlMain.add(lblLocation7);
        lblLocation7.setForeground(Color.BLACK);
        lblLocation7.setFont(new Font("Dialog", Font.BOLD, 12));
        
        RoundedPanel legendPanel7 = new RoundedPanel(5, Color.WHITE);
        legendPanel7.setBounds(135, 389, 127, 21);
        pnlMain.add(legendPanel7);
        
        JLabel lblLocation8 = new JLabel("8. Grandstand");
        lblLocation8.setBounds(145, 414, 90, 20);
        pnlMain.add(lblLocation8);
        lblLocation8.setForeground(Color.BLACK);
        lblLocation8.setFont(new Font("Dialog", Font.BOLD, 12));
        
        RoundedPanel legendPanel8 = new RoundedPanel(5, Color.WHITE);
        legendPanel8.setBounds(135, 414, 127, 21);
        pnlMain.add(legendPanel8);
        
        JLabel lblLocation9 = new JLabel("9. Tennis Courtside");
        lblLocation9.setBounds(145, 439, 121, 20);
        pnlMain.add(lblLocation9);
        lblLocation9.setForeground(Color.BLACK);
        lblLocation9.setFont(new Font("Dialog", Font.BOLD, 12));
        
        RoundedPanel legendPanel9 = new RoundedPanel(5, Color.WHITE);
        legendPanel9.setBounds(135, 439, 127, 21);
        pnlMain.add(legendPanel9);
        
        JLabel lblLocation10 = new JLabel("10. Souvenir Shop");
        lblLocation10.setBounds(145, 464, 121, 20);
        pnlMain.add(lblLocation10);
        lblLocation10.setForeground(Color.BLACK);
        lblLocation10.setFont(new Font("Dialog", Font.BOLD, 12));
        
        RoundedPanel legendPanel10 = new RoundedPanel(5, Color.WHITE);
        legendPanel10.setBounds(135, 464, 127, 21);
        pnlMain.add(legendPanel10);
        
        JLabel lblLocation11 = new JLabel("11. Gate Exit");
        pnlMain.add(lblLocation11);
        lblLocation11.setBounds(272, 390, 70, 16);
        lblLocation11.setForeground(Color.BLACK);
        lblLocation11.setFont(new Font("Dialog", Font.BOLD, 12));
        
        RoundedPanel legendPanel11 = new RoundedPanel(5, Color.WHITE);
        legendPanel11.setBounds(267, 389, 83, 21);
        pnlMain.add(legendPanel11);
        
        JLabel lblLocation12 = new JLabel("12. Gate");
        lblLocation12.setBounds(273, 417, 121, 20);
        pnlMain.add(lblLocation12);
        lblLocation12.setForeground(Color.BLACK);
        lblLocation12.setFont(new Font("Dialog", Font.BOLD, 12));
        
        JLabel lblLocation12B = new JLabel("Entrance");
        lblLocation12B.setBounds(292, 434, 121, 20);
        pnlMain.add(lblLocation12B);
        lblLocation12B.setForeground(Color.BLACK);
        lblLocation12B.setFont(new Font("Dialog", Font.BOLD, 12));

        RoundedPanel legendPanel12 = new RoundedPanel(5, Color.WHITE);
        legendPanel12.setBounds(267, 414, 83, 48);
        pnlMain.add(legendPanel12);
        
        BuyerNavigationBar navBar = new BuyerNavigationBar(contentPane);
        navBar.setBounds(0, 611, 416, 52);
        add(navBar);
    }
}