package misc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ProfilePanel extends RoundedPanel {

    private static final long serialVersionUID = -7386027024950427115L;
    public JButton btnChev1, btnChev2, btnChev3;
    private JPanel contentPane;

    public ProfilePanel(JPanel contentPane) {
        super(20, new Color(115, 12, 12));
        this.contentPane = contentPane;
        setSize(370, 176);
        setLayout(null);
        setBackground(new Color(115, 12, 12));

        JLabel lblGeneral = new JLabel("General");
        lblGeneral.setForeground(Color.WHITE);
        lblGeneral.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
        lblGeneral.setBounds(30, 19, 112, 14);
        add(lblGeneral);

        // Profile Picture Icon
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/profilepwicon.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        startupImage.setBounds(30, 51, 26, 26);
        add(startupImage);

        // Edit Profile
        JLabel lblEditProfile = new JLabel("Edit Profile");
        lblEditProfile.setForeground(Color.WHITE);
        lblEditProfile.setFont(new Font("Montserrat", Font.BOLD, 11));
        lblEditProfile.setBounds(62, 51, 89, 14);
        add(lblEditProfile);

        JLabel lblEditProfileDesc = new JLabel("Change profile picture, name, username, e-mail, phone number");
        lblEditProfileDesc.setFont(new Font("Montserrat", Font.ITALIC, 7));
        lblEditProfileDesc.setForeground(Color.WHITE);
        lblEditProfileDesc.setBounds(62, 65, 258, 14);
        add(lblEditProfileDesc);

        // Terms and Conditions
        ImageIcon tc = new ImageIcon(this.getClass().getResource("/t&cicon.png"));
        Image termsCondi = tc.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        JLabel termsCondition = new JLabel(new ImageIcon(termsCondi));
        termsCondition.setBounds(30, 90, 26, 26);
        add(termsCondition);

        JLabel lblTermsCondi = new JLabel("Terms and Conditions");
        lblTermsCondi.setForeground(Color.WHITE);
        lblTermsCondi.setFont(new Font("Montserrat", Font.BOLD, 11));
        lblTermsCondi.setBounds(62, 88, 235, 14);
        add(lblTermsCondi);

        JLabel lblTermsCondiDesc = new JLabel("View the terms and conditions of PolyMart");
        lblTermsCondiDesc.setFont(new Font("Montserrat", Font.ITALIC, 7));
        lblTermsCondiDesc.setForeground(Color.WHITE);
        lblTermsCondiDesc.setBounds(62, 102, 361, 14);
        add(lblTermsCondiDesc);

        // Privacy Policy
        ImageIcon pp = new ImageIcon(this.getClass().getResource("/ppicon.png"));
        Image privPol = pp.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        JLabel privacyPolicy = new JLabel(new ImageIcon(privPol));
        privacyPolicy.setBounds(30, 125, 26, 26);
        add(privacyPolicy);

        JLabel lblPrivacyPolicy = new JLabel("Privacy Policy");
        lblPrivacyPolicy.setForeground(Color.WHITE);
        lblPrivacyPolicy.setFont(new Font("Montserrat", Font.BOLD, 11));
        lblPrivacyPolicy.setBounds(62, 125, 235, 14);
        add(lblPrivacyPolicy);

        JLabel lblPrivacyPolicyDesc = new JLabel("View the privacy policy of PolyMart");
        lblPrivacyPolicyDesc.setFont(new Font("Montserrat", Font.ITALIC, 7));
        lblPrivacyPolicyDesc.setForeground(Color.WHITE);
        lblPrivacyPolicyDesc.setBounds(62, 139, 361, 14);
        add(lblPrivacyPolicyDesc);

        // Navigation Buttons (Chevron icons)
        ImageIcon navigateNext = new ImageIcon(this.getClass().getResource("/navigatenexticon.png"));

        btnChev1 = new JButton();
        btnChev1.setIcon(navigateNext);
        btnChev1.setBounds(321, 53, 24, 24);
        btnChev1.setOpaque(true);
        btnChev1.setBackground(new Color(115, 12, 12));
        btnChev1.setFocusable(false);
        btnChev1.setFocusPainted(false);
        btnChev1.setBorderPainted(false);
        add(btnChev1);

        btnChev2 = new JButton();
        btnChev2.setIcon(navigateNext);
        btnChev2.setBounds(321, 91, 24, 24);
        btnChev2.setOpaque(true);
        btnChev2.setBackground(new Color(115, 12, 12));
        btnChev2.setFocusable(false);
        btnChev2.setFocusPainted(false);
        btnChev2.setBorderPainted(false);
        add(btnChev2);

        btnChev3 = new JButton();
        btnChev3.setIcon(navigateNext);
        btnChev3.setBounds(321, 129, 24, 24);
        btnChev3.setOpaque(true);
        btnChev3.setBackground(new Color(115, 12, 12));
        btnChev3.setFocusable(false);
        btnChev3.setFocusPainted(false);
        btnChev3.setBorderPainted(false);
        add(btnChev3);
    }
}
