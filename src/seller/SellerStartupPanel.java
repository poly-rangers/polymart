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
    private JButton btnStart;
    private JButton btnGoBack;

    public SellerStartupPanel(JPanel contentPane) {
        this.contentPane = contentPane;

        setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        SpringLayout panelLayout = new SpringLayout();
        setLayout(panelLayout);

        JLabel lblStartupHeader1 = new JLabel("WELCOME TO");
        panelLayout.putConstraint(SpringLayout.WEST, lblStartupHeader1, 10, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, lblStartupHeader1, -328, SpringLayout.SOUTH, this);
        panelLayout.putConstraint(SpringLayout.EAST, lblStartupHeader1, -5, SpringLayout.EAST, this);
        lblStartupHeader1.setHorizontalAlignment(SwingConstants.CENTER);
        lblStartupHeader1.setForeground(new Color(153, 0, 0));
        lblStartupHeader1.setFont(new Font("Montserrat", Font.PLAIN, 24));
        add(lblStartupHeader1);

        JLabel lblStartupHeader2 = new JLabel("POLYMART,");
        panelLayout.putConstraint(SpringLayout.WEST, lblStartupHeader2, 10, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, lblStartupHeader2, -5, SpringLayout.EAST, this);
        lblStartupHeader2.setForeground(new Color(153, 0, 0));
        lblStartupHeader2.setFont(new Font("Montserrat", Font.BOLD, 48));
        lblStartupHeader2.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblStartupHeader2);

        JLabel lblStartupHeader3 = new JLabel("baks!");
        panelLayout.putConstraint(SpringLayout.NORTH, lblStartupHeader3, 382, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, lblStartupHeader3, 20, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, lblStartupHeader3, -5, SpringLayout.EAST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, lblStartupHeader2, 0, SpringLayout.NORTH, lblStartupHeader3);
        lblStartupHeader3.setHorizontalAlignment(SwingConstants.CENTER);
        lblStartupHeader3.setForeground(new Color(153, 0, 0));
        lblStartupHeader3.setFont(new Font("Montserrat", Font.ITALIC, 32));
        add(lblStartupHeader3);

        JLabel lblStartupSubheader1 = new JLabel("ready ka na ba yumaman, te?");
        panelLayout.putConstraint(SpringLayout.WEST, lblStartupSubheader1, 10, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, lblStartupSubheader1, -189, SpringLayout.SOUTH, this);
        panelLayout.putConstraint(SpringLayout.EAST, lblStartupSubheader1, -5, SpringLayout.EAST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, lblStartupHeader3, -32, SpringLayout.NORTH, lblStartupSubheader1);
        lblStartupSubheader1.setHorizontalAlignment(SwingConstants.CENTER);
        lblStartupSubheader1.setForeground(Color.BLACK);
        lblStartupSubheader1.setFont(new Font("Montserrat", Font.BOLD, 18));
        add(lblStartupSubheader1);

        JLabel lblStartupSubheader2 = new JLabel("mag-sign up ka muna hahah");
        panelLayout.putConstraint(SpringLayout.NORTH, lblStartupSubheader2, 0, SpringLayout.SOUTH, lblStartupSubheader1);
        panelLayout.putConstraint(SpringLayout.WEST, lblStartupSubheader2, 10, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, lblStartupSubheader2, -5, SpringLayout.EAST, this);
        lblStartupSubheader2.setHorizontalAlignment(SwingConstants.CENTER);
        lblStartupSubheader2.setForeground(Color.BLACK);
        lblStartupSubheader2.setFont(new Font("Montserrat", Font.BOLD, 18));
        add(lblStartupSubheader2);

        btnStart = new RoundButton("gewwww, deserve ko 'to!", 30);
        panelLayout.putConstraint(SpringLayout.NORTH, btnStart, 33, SpringLayout.SOUTH, lblStartupSubheader2);
        panelLayout.putConstraint(SpringLayout.WEST, btnStart, 69, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, btnStart, -66, SpringLayout.EAST, this);
        btnStart.setForeground(Color.WHITE);
        btnStart.setBackground(new Color(102, 0, 0));
        btnStart.setFont(new Font("Montserrat", Font.BOLD, 16));
        btnStart.setBorderPainted(false);
        btnStart.setFocusPainted(false);
        btnStart.addActionListener(this);
        add(btnStart);

        ImageIcon imgIconOriginalImage = new ImageIcon(this.getClass().getResource("/polypup_front.png"));
        Image imgScaled = imgIconOriginalImage.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        JLabel imgStartup = new JLabel(new ImageIcon(imgScaled));
        panelLayout.putConstraint(SpringLayout.NORTH, imgStartup, 69, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, imgStartup, 73, SpringLayout.WEST, this);
        add(imgStartup);
        
        // Mali napindot mo? label
        JLabel lblStartupSubheader3 = new JLabel("oh mali napindot mo? hays");
        panelLayout.putConstraint(SpringLayout.NORTH, lblStartupSubheader3, 6, SpringLayout.SOUTH, btnStart);
        panelLayout.putConstraint(SpringLayout.EAST, lblStartupSubheader3, -133, SpringLayout.EAST, this);
        lblStartupSubheader3.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 10));
        add(lblStartupSubheader3);
    	
    	// Sign in here button
        btnGoBack = new JButton("Go Back");
        panelLayout.putConstraint(SpringLayout.NORTH, btnGoBack, 2, SpringLayout.SOUTH, lblStartupSubheader3);
        panelLayout.putConstraint(SpringLayout.EAST, btnGoBack, -183, SpringLayout.EAST, this);
        btnGoBack.setBackground(Color.WHITE);
    	btnGoBack.setForeground(new Color(0x730C0C));
    	btnGoBack.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
    	btnGoBack.setFocusable(false);
    	btnGoBack.setOpaque(false);
    	btnGoBack.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0x730C0C)));
    	btnGoBack.addActionListener(this);
    	add(btnGoBack);
    }

    @Override
    public void actionPerformed(ActionEvent actEvent) {
    	Object objSourceEvent = actEvent.getSource();
    	
    	if (objSourceEvent == btnStart) {
    		// Switch to SignupPanel
            CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "SellerSignupPanel");
    	} else if (objSourceEvent == btnGoBack) {
    		CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "BuyerOrSeller");
    	}    
    }
}