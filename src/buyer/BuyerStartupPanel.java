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
    private JButton bttnStart;
    private JButton bttnGoBack;

    public BuyerStartupPanel(JPanel contentPane) {
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

        JLabel lblStartupSubheader1 = new JLabel("ready ka na ba magwaldas, te?");
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

        bttnStart = new RoundButton("gewwww, deserve ko 'to!", 45);
        panelLayout.putConstraint(SpringLayout.NORTH, bttnStart, 19, SpringLayout.SOUTH, lblStartupSubheader2);
        panelLayout.putConstraint(SpringLayout.WEST, bttnStart, 69, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, bttnStart, 61, SpringLayout.SOUTH, lblStartupSubheader2);
        panelLayout.putConstraint(SpringLayout.EAST, bttnStart, -66, SpringLayout.EAST, this);
        bttnStart.setForeground(Color.WHITE);
        bttnStart.setBackground(new Color(102, 0, 0));
        bttnStart.setFont(new Font("Montserrat", Font.BOLD, 16));
        bttnStart.setBorderPainted(false);
        bttnStart.setFocusPainted(false);
        bttnStart.addActionListener(this);
        add(bttnStart);

        ImageIcon imgIconOriginalImage = new ImageIcon(this.getClass().getResource("/polypup_front.png"));
        Image imgScaled = imgIconOriginalImage.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        JLabel lblStartupImage = new JLabel(new ImageIcon(imgScaled));
        panelLayout.putConstraint(SpringLayout.NORTH, lblStartupImage, 69, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, lblStartupImage, 73, SpringLayout.WEST, this);
        add(lblStartupImage);
        
        // Mali napindot mo? label
        JLabel lblStartupSubheader3 = new JLabel("oh mali napindot mo? hays");
        panelLayout.putConstraint(SpringLayout.EAST, lblStartupSubheader3, -133, SpringLayout.EAST, this);
        lblStartupSubheader3.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 10));
        add(lblStartupSubheader3);
    	
    	// Sign in here button
        bttnGoBack = new JButton("Go Back");
        panelLayout.putConstraint(SpringLayout.NORTH, bttnGoBack, 576, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, lblStartupSubheader3, -2, SpringLayout.NORTH, bttnGoBack);
        panelLayout.putConstraint(SpringLayout.EAST, bttnGoBack, -183, SpringLayout.EAST, this);
        bttnGoBack.setBackground(Color.WHITE);
    	bttnGoBack.setForeground(new Color(0x730C0C));
    	bttnGoBack.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
    	bttnGoBack.setFocusable(false);
    	bttnGoBack.setOpaque(false);
    	bttnGoBack.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0x730C0C)));
    	bttnGoBack.addActionListener(this);
    	add(bttnGoBack);    

    }

    @Override
    public void actionPerformed(ActionEvent actEvent) {
    	Object objSourceEvent = actEvent.getSource();
    	
    	if (objSourceEvent == bttnStart) {
    		// Switch to SignupPanel
            CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "BuyerSignupPanel");
    	} else if (objSourceEvent == bttnGoBack) {
    		CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "BuyerOrSeller");
    	}    
    }
}