package misc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PreferencesPanel extends RoundedPanel implements ActionListener {

	private static final long serialVersionUID = 5160238816315863243L;
	private JButton btnChev1, btnChev2;

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
        
        btnChev1 = new JButton();
        btnChev1.addActionListener(this);
        btnChev1.setIcon(navigateNext);
        btnChev1.setBounds(321, 53, 24, 24);
        btnChev1.setOpaque(true);
        btnChev1.setBackground(new Color(115, 12, 12));
        btnChev1.setFocusable(false);
        btnChev1.setFocusPainted(false);
        btnChev1.setBorderPainted(false); 
        add(btnChev1);
        
        btnChev2 = new JButton();
        btnChev2.addActionListener(this);
        btnChev2.setIcon(navigateNext);
        btnChev2.setBounds(321, 91, 24, 24);
        btnChev2.setOpaque(true);
        btnChev2.setBackground(new Color(115, 12, 12));
        btnChev2.setFocusable(false);
        btnChev2.setFocusPainted(false);
        btnChev2.setBorderPainted(false); 
        add(btnChev2);
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
