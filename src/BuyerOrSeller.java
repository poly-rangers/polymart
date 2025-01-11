import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import misc.RoundButton;

public class BuyerOrSeller extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
	private JButton buyerRoleButton;
	private JButton sellerRoleButton;
	public static String userRole ="";
	
    public BuyerOrSeller(JPanel contentPane) {
        this.contentPane = contentPane;

        setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        SpringLayout panelLayout = new SpringLayout();
        setLayout(panelLayout);

        JLabel startupHeader1 = new JLabel("WELCOME TO");
        panelLayout.putConstraint(SpringLayout.NORTH, startupHeader1, 270, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.EAST, startupHeader1, -5, SpringLayout.EAST, this);
        startupHeader1.setHorizontalAlignment(SwingConstants.CENTER);
        startupHeader1.setForeground(new Color(153, 0, 0));
        startupHeader1.setFont(new Font("Montserrat", Font.PLAIN, 24));
        add(startupHeader1);

        JLabel startupHeader2 = new JLabel("POLYMART,");
        panelLayout.putConstraint(SpringLayout.NORTH, startupHeader2, 8, SpringLayout.SOUTH, startupHeader1);
        panelLayout.putConstraint(SpringLayout.SOUTH, startupHeader2, -310, SpringLayout.SOUTH, this);
        panelLayout.putConstraint(SpringLayout.EAST, startupHeader2, 0, SpringLayout.EAST, startupHeader1);
        startupHeader2.setForeground(new Color(153, 0, 0));
        startupHeader2.setFont(new Font("Montserrat", Font.BOLD, 48));
        startupHeader2.setHorizontalAlignment(SwingConstants.CENTER);
        add(startupHeader2);


        JLabel startupSubheader1 = new JLabel("o bago ang lahat, ano ka jan?");
        //startupSubheader1.setBackground(new Color(255, 255, 255));
        panelLayout.putConstraint(SpringLayout.NORTH, startupSubheader1, 400, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, startupSubheader1, -200, SpringLayout.SOUTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, startupHeader2, 0, SpringLayout.WEST, startupSubheader1);
        panelLayout.putConstraint(SpringLayout.WEST, startupHeader1, 0, SpringLayout.WEST, startupSubheader1);
        panelLayout.putConstraint(SpringLayout.WEST, startupSubheader1, 10, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, startupSubheader1, -5, SpringLayout.EAST, this);
        startupSubheader1.setHorizontalAlignment(SwingConstants.CENTER);
        startupSubheader1.setForeground(Color.BLACK);
        startupSubheader1.setFont(new Font("Montserrat", Font.ITALIC, 18));
        add(startupSubheader1);
        
        JLabel startupHeader3 = new JLabel("baks!");
        panelLayout.putConstraint(SpringLayout.NORTH, startupHeader3, 350, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, startupHeader3, 20, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, startupHeader3, -5, SpringLayout.EAST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, startupHeader2, 0, SpringLayout.NORTH, startupHeader3);
        startupHeader3.setHorizontalAlignment(SwingConstants.CENTER);
        startupHeader3.setForeground(new Color(153, 0, 0));
        startupHeader3.setFont(new Font("Montserrat", Font.ITALIC, 32));
        add(startupHeader3);

        buyerRoleButton = new RoundButton("BUYER", 45);
        panelLayout.putConstraint(SpringLayout.NORTH, buyerRoleButton, -13, SpringLayout.SOUTH, startupSubheader1);
        panelLayout.putConstraint(SpringLayout.WEST, buyerRoleButton, 90, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, buyerRoleButton, 30, SpringLayout.SOUTH, startupSubheader1);
        panelLayout.putConstraint(SpringLayout.EAST, buyerRoleButton, -90, SpringLayout.EAST, this);
        buyerRoleButton.setForeground(Color.WHITE);
        buyerRoleButton.setBackground(new Color(102, 0, 0));
        buyerRoleButton.setFont(new Font("Montserrat", Font.BOLD, 16));
        buyerRoleButton.setFocusPainted(false);
        buyerRoleButton.addActionListener(this);
        add(buyerRoleButton);

        
        sellerRoleButton = new RoundButton("SELLER", 45);
        panelLayout.putConstraint(SpringLayout.NORTH, sellerRoleButton, 16, SpringLayout.SOUTH, buyerRoleButton);
        panelLayout.putConstraint(SpringLayout.WEST, sellerRoleButton, 90, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, sellerRoleButton, -112, SpringLayout.SOUTH, this);
        panelLayout.putConstraint(SpringLayout.EAST, sellerRoleButton, 0, SpringLayout.EAST, buyerRoleButton);
        sellerRoleButton.setForeground(Color.WHITE);
        sellerRoleButton.setBackground(new Color(102, 0, 0));
        sellerRoleButton.setFont(new Font("Montserrat", Font.BOLD, 16));
        sellerRoleButton.setBorderPainted(false);
        sellerRoleButton.setFocusPainted(false);
        sellerRoleButton.addActionListener(this);
        add(sellerRoleButton);

        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_front.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(260, 260, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        panelLayout.putConstraint(SpringLayout.NORTH, startupImage, 30, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, startupImage, 0, SpringLayout.WEST, startupSubheader1);
        panelLayout.putConstraint(SpringLayout.EAST, startupImage, -24, SpringLayout.EAST, this);
        add(startupImage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Switch to SignupPanel
    	Object source = e.getSource();
    	
    	if(source == buyerRoleButton) {
    		userRole = "Buyer";
    		CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "BuyerStartupPanel");
    	} else if(source == sellerRoleButton) {
    		userRole = "Seller";
    		CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "SellerStartupPanel");
    	}     
    }
}