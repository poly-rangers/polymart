package buyer;
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

public class BuyerStartupPanel extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton btnStart;
    private JButton btnGoBack;

    public BuyerStartupPanel(JPanel contentPane) {
        this.contentPane = contentPane;

        setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        SpringLayout pnlBuyerStartup = new SpringLayout();
        setLayout(pnlBuyerStartup);

        JLabel lblStartupHeader1 = new JLabel("WELCOME TO");
        pnlBuyerStartup.putConstraint(SpringLayout.WEST, lblStartupHeader1, 10, SpringLayout.WEST, this);
        pnlBuyerStartup.putConstraint(SpringLayout.SOUTH, lblStartupHeader1, -328, SpringLayout.SOUTH, this);
        pnlBuyerStartup.putConstraint(SpringLayout.EAST, lblStartupHeader1, -5, SpringLayout.EAST, this);
        lblStartupHeader1.setHorizontalAlignment(SwingConstants.CENTER);
        lblStartupHeader1.setForeground(new Color(153, 0, 0));
        lblStartupHeader1.setFont(new Font("Montserrat", Font.PLAIN, 24));
        add(lblStartupHeader1);

        JLabel lblStartupHeader2 = new JLabel("POLYMART,");
        pnlBuyerStartup.putConstraint(SpringLayout.WEST, lblStartupHeader2, 10, SpringLayout.WEST, this);
        pnlBuyerStartup.putConstraint(SpringLayout.EAST, lblStartupHeader2, -5, SpringLayout.EAST, this);
        lblStartupHeader2.setForeground(new Color(153, 0, 0));
        lblStartupHeader2.setFont(new Font("Montserrat", Font.BOLD, 48));
        lblStartupHeader2.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblStartupHeader2);

        JLabel lblStartupHeader3 = new JLabel("baks!");
        pnlBuyerStartup.putConstraint(SpringLayout.NORTH, lblStartupHeader3, 382, SpringLayout.NORTH, this);
        pnlBuyerStartup.putConstraint(SpringLayout.WEST, lblStartupHeader3, 20, SpringLayout.WEST, this);
        pnlBuyerStartup.putConstraint(SpringLayout.EAST, lblStartupHeader3, -5, SpringLayout.EAST, this);
        pnlBuyerStartup.putConstraint(SpringLayout.SOUTH, lblStartupHeader2, 0, SpringLayout.NORTH, lblStartupHeader3);
        lblStartupHeader3.setHorizontalAlignment(SwingConstants.CENTER);
        lblStartupHeader3.setForeground(new Color(153, 0, 0));
        lblStartupHeader3.setFont(new Font("Montserrat", Font.ITALIC, 32));
        add(lblStartupHeader3);

        JLabel lblStartupSubheader1 = new JLabel("ready ka na ba magwaldas, te?");
        pnlBuyerStartup.putConstraint(SpringLayout.WEST, lblStartupSubheader1, 10, SpringLayout.WEST, this);
        pnlBuyerStartup.putConstraint(SpringLayout.SOUTH, lblStartupSubheader1, -189, SpringLayout.SOUTH, this);
        pnlBuyerStartup.putConstraint(SpringLayout.EAST, lblStartupSubheader1, -5, SpringLayout.EAST, this);
        pnlBuyerStartup.putConstraint(SpringLayout.SOUTH, lblStartupHeader3, -32, SpringLayout.NORTH, lblStartupSubheader1);
        lblStartupSubheader1.setHorizontalAlignment(SwingConstants.CENTER);
        lblStartupSubheader1.setForeground(Color.BLACK);
        lblStartupSubheader1.setFont(new Font("Montserrat", Font.BOLD, 18));
        add(lblStartupSubheader1);

        JLabel lblStartupSubheader2 = new JLabel("mag-sign up ka muna hahah");
        pnlBuyerStartup.putConstraint(SpringLayout.NORTH, lblStartupSubheader2, 0, SpringLayout.SOUTH, lblStartupSubheader1);
        pnlBuyerStartup.putConstraint(SpringLayout.WEST, lblStartupSubheader2, 10, SpringLayout.WEST, this);
        pnlBuyerStartup.putConstraint(SpringLayout.EAST, lblStartupSubheader2, -5, SpringLayout.EAST, this);
        lblStartupSubheader2.setHorizontalAlignment(SwingConstants.CENTER);
        lblStartupSubheader2.setForeground(Color.BLACK);
        lblStartupSubheader2.setFont(new Font("Montserrat", Font.BOLD, 18));
        add(lblStartupSubheader2);

        btnStart = new RoundButton("gewwww, deserve ko 'to!", 45);
        pnlBuyerStartup.putConstraint(SpringLayout.NORTH, btnStart, 19, SpringLayout.SOUTH, lblStartupSubheader2);
        pnlBuyerStartup.putConstraint(SpringLayout.WEST, btnStart, 69, SpringLayout.WEST, this);
        pnlBuyerStartup.putConstraint(SpringLayout.SOUTH, btnStart, 61, SpringLayout.SOUTH, lblStartupSubheader2);
        pnlBuyerStartup.putConstraint(SpringLayout.EAST, btnStart, -66, SpringLayout.EAST, this);
        btnStart.setForeground(Color.WHITE);
        btnStart.setBackground(new Color(102, 0, 0));
        btnStart.setFont(new Font("Montserrat", Font.BOLD, 16));
        btnStart.setBorderPainted(false);
        btnStart.setFocusPainted(false);
        btnStart.addActionListener(this);
        add(btnStart);

        ImageIcon imgIconOriginalImage = new ImageIcon(this.getClass().getResource("/polypup_front.png"));
        Image imgScaled = imgIconOriginalImage.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        JLabel lblStartupImage = new JLabel(new ImageIcon(imgScaled));
        pnlBuyerStartup.putConstraint(SpringLayout.NORTH, lblStartupImage, 69, SpringLayout.NORTH, this);
        pnlBuyerStartup.putConstraint(SpringLayout.WEST, lblStartupImage, 73, SpringLayout.WEST, this);
        add(lblStartupImage);
        
        // Mali napindot mo? label

        JLabel lblStartupSubheader3 = new JLabel("oh mali napindot mo? hays");
        pnlBuyerStartup.putConstraint(SpringLayout.EAST, lblStartupSubheader3, -133, SpringLayout.EAST, this);
        lblStartupSubheader3.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 10));
        add(lblStartupSubheader3);
    	
    	// Sign in here button
        btnGoBack = new JButton("Go Back");
        pnlBuyerStartup.putConstraint(SpringLayout.NORTH, btnGoBack, 576, SpringLayout.NORTH, this);
        pnlBuyerStartup.putConstraint(SpringLayout.SOUTH, lblStartupSubheader3, -2, SpringLayout.NORTH, btnGoBack);
        pnlBuyerStartup.putConstraint(SpringLayout.EAST, btnGoBack, -183, SpringLayout.EAST, this);
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
            clLayout.show(contentPane, "BuyerSignupPanel");
    	} else if (objSourceEvent == btnGoBack) {
    		CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "BuyerOrSeller");
    	}    
    }
}