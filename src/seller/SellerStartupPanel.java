package seller;
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

import misc.RoundButton;

public class SellerStartupPanel extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton startupStartButton;
    private JButton goBackLink;

    public SellerStartupPanel(JPanel contentPane) {
        this.contentPane = contentPane;

        setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        SpringLayout panelLayout = new SpringLayout();
        setLayout(panelLayout);

        JLabel startupHeader1 = new JLabel("WELCOME TO");
        panelLayout.putConstraint(SpringLayout.WEST, startupHeader1, 10, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, startupHeader1, -328, SpringLayout.SOUTH, this);
        panelLayout.putConstraint(SpringLayout.EAST, startupHeader1, -5, SpringLayout.EAST, this);
        startupHeader1.setHorizontalAlignment(SwingConstants.CENTER);
        startupHeader1.setForeground(new Color(153, 0, 0));
        startupHeader1.setFont(new Font("Montserrat", Font.PLAIN, 24));
        add(startupHeader1);

        JLabel startupHeader2 = new JLabel("POLYMART,");
        panelLayout.putConstraint(SpringLayout.WEST, startupHeader2, 10, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, startupHeader2, -5, SpringLayout.EAST, this);
        startupHeader2.setForeground(new Color(153, 0, 0));
        startupHeader2.setFont(new Font("Montserrat", Font.BOLD, 48));
        startupHeader2.setHorizontalAlignment(SwingConstants.CENTER);
        add(startupHeader2);

        JLabel startupHeader3 = new JLabel("baks!");
        panelLayout.putConstraint(SpringLayout.NORTH, startupHeader3, 382, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, startupHeader3, 20, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, startupHeader3, -5, SpringLayout.EAST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, startupHeader2, 0, SpringLayout.NORTH, startupHeader3);
        startupHeader3.setHorizontalAlignment(SwingConstants.CENTER);
        startupHeader3.setForeground(new Color(153, 0, 0));
        startupHeader3.setFont(new Font("Montserrat", Font.ITALIC, 32));
        add(startupHeader3);

        JLabel startupSubheader1 = new JLabel("ready ka na ba yumaman, te?");
        panelLayout.putConstraint(SpringLayout.WEST, startupSubheader1, 10, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, startupSubheader1, -189, SpringLayout.SOUTH, this);
        panelLayout.putConstraint(SpringLayout.EAST, startupSubheader1, -5, SpringLayout.EAST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, startupHeader3, -32, SpringLayout.NORTH, startupSubheader1);
        startupSubheader1.setHorizontalAlignment(SwingConstants.CENTER);
        startupSubheader1.setForeground(Color.BLACK);
        startupSubheader1.setFont(new Font("Montserrat", Font.BOLD, 18));
        add(startupSubheader1);

        JLabel startupSubheader2 = new JLabel("mag-sign up ka muna hahah");
        panelLayout.putConstraint(SpringLayout.NORTH, startupSubheader2, 0, SpringLayout.SOUTH, startupSubheader1);
        panelLayout.putConstraint(SpringLayout.WEST, startupSubheader2, 10, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, startupSubheader2, -5, SpringLayout.EAST, this);
        startupSubheader2.setHorizontalAlignment(SwingConstants.CENTER);
        startupSubheader2.setForeground(Color.BLACK);
        startupSubheader2.setFont(new Font("Montserrat", Font.BOLD, 18));
        add(startupSubheader2);

        startupStartButton = new RoundButton("gewwww, deserve ko 'to!", 30);
        panelLayout.putConstraint(SpringLayout.NORTH, startupStartButton, 33, SpringLayout.SOUTH, startupSubheader2);
        panelLayout.putConstraint(SpringLayout.WEST, startupStartButton, 69, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, startupStartButton, -66, SpringLayout.EAST, this);
        startupStartButton.setForeground(Color.WHITE);
        startupStartButton.setBackground(new Color(102, 0, 0));
        startupStartButton.setFont(new Font("Montserrat", Font.BOLD, 16));
        startupStartButton.setBorderPainted(false);
        startupStartButton.setFocusPainted(false);
        startupStartButton.addActionListener(this);
        add(startupStartButton);

        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_front.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        panelLayout.putConstraint(SpringLayout.NORTH, startupImage, 69, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, startupImage, 73, SpringLayout.WEST, this);
        add(startupImage);
        
        // Mali napindot mo? label
        JLabel maliKa = new JLabel("oh mali napindot mo? hays");
        panelLayout.putConstraint(SpringLayout.NORTH, maliKa, 6, SpringLayout.SOUTH, startupStartButton);
        panelLayout.putConstraint(SpringLayout.EAST, maliKa, -133, SpringLayout.EAST, this);
        maliKa.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 10));
        add(maliKa);
    	
    	// Sign in here button
        goBackLink = new JButton("Go Back");
        panelLayout.putConstraint(SpringLayout.NORTH, goBackLink, 2, SpringLayout.SOUTH, maliKa);
        panelLayout.putConstraint(SpringLayout.EAST, goBackLink, -183, SpringLayout.EAST, this);
        goBackLink.setBackground(Color.WHITE);
    	goBackLink.setForeground(new Color(0x730C0C));
    	goBackLink.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
    	goBackLink.setFocusable(false);
    	goBackLink.setOpaque(false);
    	goBackLink.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0x730C0C)));
    	goBackLink.addActionListener(this);
    	add(goBackLink);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	Object source = e.getSource();
    	
    	if (source == startupStartButton) {
    		// Switch to SignupPanel
            CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "SellerSignupPanel");
    	} else if (source == goBackLink) {
    		CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "BuyerOrSeller");
    	}    
    }
}