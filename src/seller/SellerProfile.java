package seller;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import frames.Logout;
import frames.MeetupConfirmation;
import misc.PreferencesPanel;
import misc.ProfilePanel;
import misc.UserBaseTemplate;

import java.awt.*;


public class SellerProfile extends UserBaseTemplate {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public SellerProfile(JPanel contentPane) {
    	super(contentPane, "seller");
    	contentPanel.setBounds(0, 202, 416, 407);
    	headerPanel.setBounds(0, 74, 416, 133);	
    }
    
    protected void setPanelHeader() {
        headerPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("My Profile");
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        lblNewLabel.setBounds(210, 20, 145, 36);
        lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 23));
        headerPanel.add(lblNewLabel);
        
        JLabel lblName = new JLabel("Chris Piamonte");
        lblName.setHorizontalAlignment(SwingConstants.LEFT);
        lblName.setAlignmentX(Component.RIGHT_ALIGNMENT);
        lblName.setBounds(210, 66, 130, 20);
        lblName.setFont(new Font("Montserrat", Font.BOLD, 16));
        headerPanel.add(lblName);
        
        JLabel lblUsername = new JLabel("@chrispiamontex");
        lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
        lblUsername.setFont(new Font("Montserrat", Font.ITALIC, 16));
        lblUsername.setAlignmentX(1.0f);
        lblUsername.setBounds(210, 85, 145, 20);
        headerPanel.add(lblUsername);
        
        ImageIcon productPic = new ImageIcon(this.getClass().getResource("/accountpic_placeholder.png"));
        JLabel pic = new JLabel(productPic);
        pic.setBounds(60, 20, 90, 90);
        headerPanel.add(pic);
        
    }
    
    public void customizeContentPanel() {
        ProfilePanel pnlProfile = new ProfilePanel(contentPane);
        pnlProfile.setSize(358, 176);
        pnlProfile.setLocation(28, 20);
        contentPanel.add(pnlProfile);
        
        pnlProfile.btnChev1.addActionListener(e -> switchPanel("EditProfile"));
        pnlProfile.btnChev2.addActionListener(e -> switchPanel("TCandPP"));
        pnlProfile.btnChev3.addActionListener(e -> switchPanel("TCandPP"));
        
        PreferencesPanel pnlPreferences = new PreferencesPanel();
        pnlPreferences.setSize(358, 137);
        pnlPreferences.setLocation(28, 217);
        contentPanel.add(pnlPreferences);
        
        pnlPreferences.btnPChev1.addActionListener(e -> switchPanel("DeleteAccount"));
        pnlPreferences.btnPChev2.addActionListener(e -> {
            Logout logoutFrame = new Logout();  
            logoutFrame.setVisible(true);
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