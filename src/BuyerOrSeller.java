import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class BuyerOrSeller extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
	private JButton buyerRoleButton;
	private JButton sellerRoleButton;
	private JButton signInButton;
	public static String userRole ="";
	
    public BuyerOrSeller(JPanel contentPane) {
        this.contentPane = contentPane;

        setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        SpringLayout layout = new SpringLayout();
        setLayout(layout);

        JLabel startupHeader1 = new JLabel("WELCOME TO");
        layout.putConstraint(SpringLayout.NORTH, startupHeader1, 270, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, startupHeader1, -5, SpringLayout.EAST, this);
        startupHeader1.setHorizontalAlignment(SwingConstants.CENTER);
        startupHeader1.setForeground(new Color(153, 0, 0));
        startupHeader1.setFont(new Font("Montserrat", Font.PLAIN, 24));
        add(startupHeader1);

        JLabel startupHeader2 = new JLabel("POLYMART,");
        layout.putConstraint(SpringLayout.NORTH, startupHeader2, 8, SpringLayout.SOUTH, startupHeader1);
        layout.putConstraint(SpringLayout.SOUTH, startupHeader2, -310, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.EAST, startupHeader2, 0, SpringLayout.EAST, startupHeader1);
        startupHeader2.setForeground(new Color(153, 0, 0));
        startupHeader2.setFont(new Font("Montserrat", Font.BOLD, 48));
        startupHeader2.setHorizontalAlignment(SwingConstants.CENTER);
        add(startupHeader2);


        JLabel startupSubheader1 = new JLabel("o bago ang lahat, ano ka jan?");
        //startupSubheader1.setBackground(new Color(255, 255, 255));
        layout.putConstraint(SpringLayout.NORTH, startupSubheader1, 400, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.SOUTH, startupSubheader1, -200, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.WEST, startupHeader2, 0, SpringLayout.WEST, startupSubheader1);
        layout.putConstraint(SpringLayout.WEST, startupHeader1, 0, SpringLayout.WEST, startupSubheader1);
        layout.putConstraint(SpringLayout.WEST, startupSubheader1, 10, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, startupSubheader1, -5, SpringLayout.EAST, this);
        startupSubheader1.setHorizontalAlignment(SwingConstants.CENTER);
        startupSubheader1.setForeground(Color.BLACK);
        startupSubheader1.setFont(new Font("Montserrat", Font.ITALIC, 18));
        add(startupSubheader1);
        
        JLabel startupHeader3 = new JLabel("baks!");
        layout.putConstraint(SpringLayout.NORTH, startupHeader3, 350, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, startupHeader3, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, startupHeader3, -5, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.SOUTH, startupHeader2, 0, SpringLayout.NORTH, startupHeader3);
        startupHeader3.setHorizontalAlignment(SwingConstants.CENTER);
        startupHeader3.setForeground(new Color(153, 0, 0));
        startupHeader3.setFont(new Font("Montserrat", Font.ITALIC, 32));
        add(startupHeader3);

        buyerRoleButton = new JButton("BUYER");
        layout.putConstraint(SpringLayout.NORTH, buyerRoleButton, -13, SpringLayout.SOUTH, startupSubheader1);
        layout.putConstraint(SpringLayout.WEST, buyerRoleButton, 90, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, buyerRoleButton, 30, SpringLayout.SOUTH, startupSubheader1);
        layout.putConstraint(SpringLayout.EAST, buyerRoleButton, -90, SpringLayout.EAST, this);
        buyerRoleButton.setForeground(Color.WHITE);
        buyerRoleButton.setBackground(new Color(102, 0, 0));
        buyerRoleButton.setFont(new Font("Montserrat", Font.BOLD, 16));
        buyerRoleButton.setBorderPainted(false);
        buyerRoleButton.setFocusPainted(false);
        buyerRoleButton.addActionListener(this);
        add(buyerRoleButton);
        
        sellerRoleButton = new JButton("SELLER");
        layout.putConstraint(SpringLayout.NORTH, sellerRoleButton, 16, SpringLayout.SOUTH, buyerRoleButton);
        layout.putConstraint(SpringLayout.WEST, sellerRoleButton, 90, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, sellerRoleButton, -112, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.EAST, sellerRoleButton, 0, SpringLayout.EAST, buyerRoleButton);
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
        layout.putConstraint(SpringLayout.NORTH, startupImage, 30, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, startupImage, 0, SpringLayout.WEST, startupSubheader1);
        layout.putConstraint(SpringLayout.EAST, startupImage, -24, SpringLayout.EAST, this);
        add(startupImage);
        
        JLabel accountAvailLabel = new JLabel("Already have an account??");
        layout.putConstraint(SpringLayout.NORTH, accountAvailLabel, 6, SpringLayout.SOUTH, sellerRoleButton);
        layout.putConstraint(SpringLayout.EAST, accountAvailLabel, -117, SpringLayout.EAST, this);
        accountAvailLabel.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 13));
        add(accountAvailLabel);
        
        signInButton = new JButton("Sign in here");
        layout.putConstraint(SpringLayout.NORTH, signInButton, 3, SpringLayout.SOUTH, accountAvailLabel);
        layout.putConstraint(SpringLayout.WEST, signInButton, 172, SpringLayout.WEST, this);
        signInButton.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 13));
        signInButton.setForeground(new Color(0x730C0C));
    	signInButton.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
    	signInButton.setFocusable(false);
    	signInButton.setOpaque(false);
    	signInButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0x730C0C)));
    	signInButton.addActionListener(this);
        add(signInButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Switch to SignupPanel
    	Object source = e.getSource();
    	
    	if(source == buyerRoleButton) {
    		userRole = "Buyer";
    		CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "SignupPanel");
    	} else if(source == sellerRoleButton) {
    		userRole = "Seller";
    		CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "SignupPanel");
    	} else if(source == signInButton) {
    		CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "SignInPanel");
    	}
    	
        
        
    }
}