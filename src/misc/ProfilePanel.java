package misc;

import java.awt.Color;

import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfilePanel extends RoundedPanel implements ActionListener{

	private static final long serialVersionUID = -7386027024950427115L;
	private JButton btnChev1, btnChev2, btnChev3;

	public ProfilePanel() {
		super(20, new Color(115, 12, 12));
		setSize(370,176);
		setLayout(null);
		
		JLabel lblGeneral = new JLabel("General");
		lblGeneral.setForeground(new Color(255, 255, 255));
		lblGeneral.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblGeneral.setBounds(30, 19, 112, 14);
		add(lblGeneral);
		
		ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/profilepwicon.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        startupImage.setBounds(30, 51, 26, 26);
        add(startupImage);
        
        JLabel lblEditProfile = new JLabel("Edit Profile");
        lblEditProfile.setForeground(new Color(255, 255, 255));
        lblEditProfile.setBackground(new Color(255, 255, 255));
        lblEditProfile.setFont(new Font("Montserrat", Font.BOLD, 11));
        lblEditProfile.setBounds(62, 51, 89, 14);
        add(lblEditProfile);
        
        JLabel lblEditProfileDesc = new JLabel("Change profile picture, name, username, e-mail, phone number");
        lblEditProfileDesc.setFont(new Font("Montserrat", Font.ITALIC, 7));
        lblEditProfileDesc.setForeground(new Color(255, 255, 255));
        lblEditProfileDesc.setBounds(62, 65, 258, 14);
        add(lblEditProfileDesc);
      
        ImageIcon tc = new ImageIcon(this.getClass().getResource("/t&cicon.png"));
        Image termsCondi = tc.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        JLabel termsCondition = new JLabel(new ImageIcon(termsCondi));
        termsCondition.setBounds(30, 90, 26, 26);
        add(termsCondition);
                
        JLabel lblTermsCondi = new JLabel("Terms and Conditions");
        lblTermsCondi.setForeground(new Color(255, 255, 255));
        lblTermsCondi.setBackground(new Color(255, 255, 255));
        lblTermsCondi.setFont(new Font("Montserrat", Font.BOLD, 11));
        lblTermsCondi.setBounds(62, 88, 235, 14);
        add(lblTermsCondi);
        
        JLabel lblTermsCondiDesc = new JLabel("View the terms and conditions of PolyMart");
        lblTermsCondiDesc.setFont(new Font("Montserrat", Font.ITALIC, 7));
        lblTermsCondiDesc.setForeground(new Color(255, 255, 255));
        lblTermsCondiDesc.setBounds(62, 102, 361, 14);
        add(lblTermsCondiDesc);
        
        ImageIcon pp = new ImageIcon(this.getClass().getResource("/ppicon.png"));
        Image privPol = pp.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        JLabel privacyPolicy = new JLabel(new ImageIcon(privPol));
        privacyPolicy.setBounds(30, 125, 26, 26);
        add(privacyPolicy);
        
        JLabel lblPrivacyPolicy = new JLabel("Privacy Policy");
        lblPrivacyPolicy.setForeground(new Color(255, 255, 255));
        lblPrivacyPolicy.setBackground(new Color(255, 255, 255));
        lblPrivacyPolicy.setFont(new Font("Montserrat", Font.BOLD, 11));
        lblPrivacyPolicy.setBounds(62, 125, 235, 14);
        add(lblPrivacyPolicy);
        
        JLabel lblPrivacyPolicyDesc = new JLabel("View the privacy policy of PolyMart");
        lblPrivacyPolicyDesc.setFont(new Font("Montserrat", Font.ITALIC, 7));
        lblPrivacyPolicyDesc.setForeground(new Color(255, 255, 255));
        lblPrivacyPolicyDesc.setBounds(62, 139, 361, 14);
        add(lblPrivacyPolicyDesc);
        
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
        
        btnChev3 = new JButton();
        btnChev3.addActionListener(this);
        btnChev3.setIcon(navigateNext);
        btnChev3.setBounds(321, 129, 24, 24);
        btnChev3.setOpaque(true);
        btnChev3.setBackground(new Color(115, 12, 12));
        btnChev3.setFocusable(false);
        btnChev3.setFocusPainted(false);
        btnChev3.setBorderPainted(false); 
        add(btnChev3);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
