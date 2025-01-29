import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import misc.RoundedButton; // Assuming RoundedButton is in the misc package

public class BuyerOrSeller extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton buyerRoleButton, sellerRoleButton;
    public static String userRole = "";

    public BuyerOrSeller(JPanel contentPane) {
        this.contentPane = contentPane;
        
        setBackground(Color.WHITE);
        setSize(414,660);
        setLayout(null);

        
        JLabel startupHeader1 = new JLabel("WELCOME TO");
        startupHeader1.setBounds(0, 282, 414, 30); 
        startupHeader1.setHorizontalAlignment(SwingConstants.CENTER);
        startupHeader1.setForeground(new Color(153, 0, 0));
        startupHeader1.setFont(new Font("Montserrat", Font.PLAIN, 24));
        add(startupHeader1);

        JLabel startupHeader2 = new JLabel("POLYMART,");
        startupHeader2.setBounds(0, 310, 414, 50);
        startupHeader2.setForeground(new Color(153, 0, 0));
        startupHeader2.setFont(new Font("Montserrat", Font.BOLD, 48));
        startupHeader2.setHorizontalAlignment(SwingConstants.CENTER);
        add(startupHeader2);

        JLabel startupHeader3 = new JLabel("baks!");
        startupHeader3.setBounds(0, 356, 414, 40); 
        startupHeader3.setForeground(new Color(153, 0, 0));
        startupHeader3.setFont(new Font("Montserrat", Font.ITALIC, 32));
        startupHeader3.setHorizontalAlignment(SwingConstants.CENTER);
        add(startupHeader3);

        JLabel startupSubheader1 = new JLabel("o bago ang lahat, ano ka jan?");
        startupSubheader1.setBounds(0, 429, 414, 30); 
        startupSubheader1.setHorizontalAlignment(SwingConstants.CENTER);
        startupSubheader1.setForeground(Color.BLACK);
        startupSubheader1.setFont(new Font("Montserrat", Font.ITALIC, 18));
        add(startupSubheader1);

        // Buyer Button
        buyerRoleButton = new RoundedButton("BUYER", 45);
        buyerRoleButton.setBounds(77, 470, 260, 50); 
        buyerRoleButton.setForeground(Color.WHITE);
        buyerRoleButton.setBackground(new Color(102, 0, 0));
        buyerRoleButton.setFont(new Font("Montserrat", Font.BOLD, 16));
        buyerRoleButton.setFocusPainted(false);
        buyerRoleButton.setBorderPainted(false);
        buyerRoleButton.addActionListener(this);
        add(buyerRoleButton);

        // Seller Button
        sellerRoleButton = new RoundedButton("SELLER", 45);
        sellerRoleButton.setBounds(77, 540, 260, 50);
        sellerRoleButton.setForeground(Color.WHITE);
        sellerRoleButton.setBackground(new Color(102, 0, 0));
        sellerRoleButton.setFont(new Font("Montserrat", Font.BOLD, 16));
        sellerRoleButton.setFocusPainted(false);
        sellerRoleButton.setBorderPainted(false);
        sellerRoleButton.addActionListener(this);
        add(sellerRoleButton);

        // Image
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_front.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(260, 260, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        startupImage.setBounds(77, 30, 260, 260); 
        add(startupImage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == buyerRoleButton) {
            userRole = "Buyer";
            CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "BuyerStartupPanel");
        } else if (source == sellerRoleButton) {
            userRole = "Seller";
            CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "SellerStartupPanel");
        }
    }
}
