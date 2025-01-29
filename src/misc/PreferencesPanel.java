package misc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PreferencesPanel extends RoundedPanel {

	private static final long serialVersionUID = 5160238816315863243L;
	public JButton btnPChev1, btnPChev2;

	public PreferencesPanel() {
		super(20, new Color(115, 12, 12));
		setSize(370,137);
		setLayout(null);
		
		JLabel lblPreferences = new JLabel("Preferences");
		lblPreferences.setForeground(new Color(255, 255, 255));
		lblPreferences.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblPreferences.setBounds(30, 19, 112, 14);
		add(lblPreferences);
		
		ImageIcon deleteImage = new ImageIcon(this.getClass().getResource("/deleteaccicon.png"));
        Image deleteAcc = deleteImage.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        JLabel deleteAccount = new JLabel(new ImageIcon(deleteAcc));
        deleteAccount.setBounds(30, 51, 26, 26);
        add(deleteAccount);
        
        JLabel lblDeleteAccount = new JLabel("Delete Account");
        lblDeleteAccount.setForeground(new Color(255, 255, 255));
        lblDeleteAccount.setBackground(new Color(255, 255, 255));
        lblDeleteAccount.setFont(new Font("Montserrat", Font.BOLD, 11));
        lblDeleteAccount.setBounds(62, 51, 130, 14);
        add(lblDeleteAccount);
        
        JLabel lblDeleteAccountDesc = new JLabel("wag ka mangiwan pls...s");
        lblDeleteAccountDesc.setFont(new Font("Montserrat", Font.ITALIC, 7));
        lblDeleteAccountDesc.setForeground(new Color(255, 255, 255));
        lblDeleteAccountDesc.setBounds(62, 65, 258, 14);
        add(lblDeleteAccountDesc);
      
        ImageIcon logoutImage = new ImageIcon(this.getClass().getResource("/t&cicon.png"));
        Image logOut = logoutImage.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        JLabel logOuticon = new JLabel(new ImageIcon(logOut));
        logOuticon.setBounds(30, 90, 26, 26);
        add(logOuticon);
                
        JLabel lblLogOut = new JLabel("Log Out");
        lblLogOut.setForeground(new Color(255, 255, 255));
        lblLogOut.setBackground(new Color(255, 255, 255));
        lblLogOut.setFont(new Font("Montserrat", Font.BOLD, 11));
        lblLogOut.setBounds(62, 88, 235, 14);
        add(lblLogOut);
        
        JLabel lblLogOutDesc = new JLabel("balik ka ha <3");
        lblLogOutDesc.setFont(new Font("Montserrat", Font.ITALIC, 7));
        lblLogOutDesc.setForeground(new Color(255, 255, 255));
        lblLogOutDesc.setBounds(62, 102, 361, 14);
        add(lblLogOutDesc);
		
        ImageIcon navigateNext = new ImageIcon(this.getClass().getResource("/navigatenexticon.png"));
        
        btnPChev1 = new JButton();
        btnPChev1.setIcon(navigateNext);
        btnPChev1.setBounds(321, 53, 24, 24);
        btnPChev1.setOpaque(true);
        btnPChev1.setBackground(new Color(115, 12, 12));
        btnPChev1.setFocusable(false);
        btnPChev1.setFocusPainted(false);
        btnPChev1.setBorderPainted(false); 
        add(btnPChev1);
        
        btnPChev2 = new JButton();
        btnPChev2.setIcon(navigateNext);
        btnPChev2.setBounds(321, 91, 24, 24);
        btnPChev2.setOpaque(true);
        btnPChev2.setBackground(new Color(115, 12, 12));
        btnPChev2.setFocusable(false);
        btnPChev2.setFocusPainted(false);
        btnPChev2.setBorderPainted(false); 
        add(btnPChev2);
        
	}
}
