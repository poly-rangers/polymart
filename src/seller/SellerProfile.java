package seller;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import frames.Logout;
import frames.MeetupConfirmation;
import misc.PreferencesPanel;
import misc.ProfilePanel;

import java.awt.*;


public class SellerProfile extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public SellerProfile(JPanel contentPane) {
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

        JLabel lblNewLabel = new JLabel("My Profile");
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        lblNewLabel.setBounds(177, 92, 193, 24);
        lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 20));
        add(lblNewLabel);
        
        JLabel lblName = new JLabel("Chris Piamonte");
        lblName.setHorizontalAlignment(SwingConstants.LEFT);
        lblName.setAlignmentX(Component.RIGHT_ALIGNMENT);
        lblName.setBounds(177, 127, 193, 24);
        lblName.setFont(new Font("Montserrat", Font.BOLD, 16));
        add(lblName);
        
        JLabel lblUsername = new JLabel("@chrispiamontex");
        lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
        lblUsername.setFont(new Font("Montserrat", Font.ITALIC, 16));
        lblUsername.setAlignmentX(1.0f);
        lblUsername.setBounds(177, 151, 193, 24);
        add(lblUsername);
        
        ProfilePanel pnlProfile = new ProfilePanel(contentPane);
        pnlProfile.setLocation(16, 217);
        add(pnlProfile);
        
        pnlProfile.btnChev1.addActionListener(e -> switchPanel("EditProfile"));
        pnlProfile.btnChev2.addActionListener(e -> switchPanel("TCandPP"));
        pnlProfile.btnChev3.addActionListener(e -> switchPanel("TCandPP"));
        
        PreferencesPanel pnlPreferences = new PreferencesPanel();
        pnlPreferences.setLocation(16, 429);
        add(pnlPreferences);
        
        pnlPreferences.btnPChev1.addActionListener(e -> switchPanel("DeleteAccount"));
        pnlPreferences.btnPChev2.addActionListener(e -> {
            Logout logoutFrame = new Logout();  
            logoutFrame.setVisible(true);
        });
        
        ImageIcon productPic = new ImageIcon(this.getClass().getResource("/accountpic_placeholder.png"));
        JLabel pic = new JLabel(productPic);
        pic.setBounds(53, 82, 100, 100);
        add(pic);
        
        
        SellerNavigationBar navBar = new SellerNavigationBar(contentPane);
        navBar.setBounds(0, 611, 416, 52);

        add(navBar);
        
        navBar.btnHome.addActionListener(e -> switchPanel("SellerDashboardPanel"));
        navBar.btnMap.addActionListener(e -> switchPanel("SellerDashboardMap"));
        navBar.btnOrders.addActionListener(e -> switchPanel("SellerOrderPanel"));
        navBar.btnProfile.addActionListener(e -> System.out.println("Already on Profile Panel"));
       
    }
    
    private void switchPanel(String panelName) {
        if (contentPane.getLayout() instanceof CardLayout) {
            ((CardLayout) contentPane.getLayout()).show(contentPane, panelName);
        } else {
            System.err.println("Error: contentPane is not using CardLayout!");
        }
    }
}