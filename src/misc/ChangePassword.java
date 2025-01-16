package misc;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;


public class ChangePassword extends JDialog {
	public ChangePassword() {
		
		setUndecorated(true);
        getContentPane().setBackground(new Color(115, 12, 12));
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); 
		
        JPanel pnlProfile = new JPanel();
        pnlProfile.setLayout(new GridLayout(2, 3, 0 , 0));
        
        JLabel lblEditProfile = new JLabel("Edit Profile");
        JLabel lblEditProfileDesc = new JLabel("Change profile picture, name, username, e-mail, phone number");
       
        pnlProfile.add(lblEditProfile);
        pnlProfile.add(lblEditProfileDesc);
        
        JPanel pnlPassword = new JPanel();
        pnlPassword.setLayout(new GridLayout(2, 3, 0 , 0));
        JLabel lblChangePassword = new JLabel("Change Password");
        JLabel lblChangePasswordDesc = new JLabel("Update password and strengthen account security");
       
        pnlPassword.add(lblChangePassword);
        pnlPassword.add(lblChangePasswordDesc);
        
        JPanel pnlTermsCondition = new JPanel();
        pnlTermsCondition.setLayout(new GridLayout(2, 3, 0 , 0));
        JLabel lblTermsCondition = new JLabel("Terms and Conditions");
        JLabel lblTermsConditionDesc = new JLabel("View the terms and conditions of PolyMart");
       
        pnlTermsCondition.add(lblTermsCondition);
        pnlTermsCondition.add(lblTermsConditionDesc);
        
        JPanel pnlPrivacyPolicy = new JPanel();
        pnlPrivacyPolicy.setLayout(new GridLayout(2, 3, 0 , 0));
        JLabel lblPrivacyPolicy = new JLabel("Privacy Policy");
        JLabel lblPrivacyPolicyDesc = new JLabel("View the privacy policy of PolyMart");
       
        pnlPrivacyPolicy.add(lblPrivacyPolicy);
        pnlPrivacyPolicy.add(lblPrivacyPolicyDesc);
        
        
        add(pnlProfile);
        add(pnlPassword);
        add(pnlTermsCondition);
        add(pnlPrivacyPolicy);
        
        
	}
	
}