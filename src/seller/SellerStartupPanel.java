package seller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import misc.RoundedButton;

public class SellerStartupPanel extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton btnStart;
    private JButton btnGoBack;

    public SellerStartupPanel(JPanel contentPane) {
        this.contentPane = contentPane;

        setBackground(Color.WHITE);
        setSize(414, 660);
        setLayout(null);

        JLabel lblStartupHeader1 = new JLabel("WELCOME TO");
        lblStartupHeader1.setBounds(0, 282, 414, 30);
        lblStartupHeader1.setHorizontalAlignment(SwingConstants.CENTER);
        lblStartupHeader1.setForeground(new Color(115, 12, 12));
        lblStartupHeader1.setFont(new Font("Montserrat", Font.PLAIN, 24));
        add(lblStartupHeader1);

        JLabel lblStartupHeader2 = new JLabel("POLYMART,");
        lblStartupHeader2.setBounds(0, 310, 414, 50);
        lblStartupHeader2.setForeground(new Color(115, 12, 12));
        lblStartupHeader2.setFont(new Font("Montserrat", Font.BOLD, 48));
        lblStartupHeader2.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblStartupHeader2);

        JLabel lblStartupHeader3 = new JLabel("baks!");
        lblStartupHeader3.setBounds(0, 356, 414, 40);
        lblStartupHeader3.setForeground(new Color(115, 12, 12));
        lblStartupHeader3.setFont(new Font("Montserrat", Font.ITALIC, 32));
        lblStartupHeader3.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblStartupHeader3);

        JLabel lblStartupSubheader1 = new JLabel("ready ka na ba yumaman, te?");
        lblStartupSubheader1.setBounds(0, 420, 414, 30);
        lblStartupSubheader1.setHorizontalAlignment(SwingConstants.CENTER);
        lblStartupSubheader1.setForeground(Color.BLACK);
        lblStartupSubheader1.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 18));
        add(lblStartupSubheader1);

        JLabel lblStartupSubheader2 = new JLabel("mag-sign up ka muna hahah");
        lblStartupSubheader2.setBounds(0, 444, 414, 30);
        lblStartupSubheader2.setHorizontalAlignment(SwingConstants.CENTER);
        lblStartupSubheader2.setForeground(Color.BLACK);
        lblStartupSubheader2.setFont(new Font("Montserrat", Font.BOLD, 18));
        add(lblStartupSubheader2);

        // Start button
        btnStart = new RoundedButton("gewwww, deserve ko 'to!", 45);
        btnStart.setBounds(77, 500, 260, 50);
        btnStart.setForeground(Color.WHITE);
        btnStart.setBackground(new Color(115, 12, 12));
        btnStart.setFont(new Font("Montserrat", Font.BOLD, 16));
        btnStart.setBorderPainted(false);
        btnStart.setFocusPainted(false);
        btnStart.addActionListener(this);
        add(btnStart);

        // Image
        ImageIcon imgIconOriginalImage = new ImageIcon(this.getClass().getResource("/polypup_front.png"));
        Image imgScaled = imgIconOriginalImage.getImage().getScaledInstance(260, 260, Image.SCALE_SMOOTH);
        JLabel lblStartupImage = new JLabel(new ImageIcon(imgScaled));
        lblStartupImage.setBounds(77, 30, 260, 260);
        add(lblStartupImage);

        // Go back label and button
        JLabel lblStartupSubheader3 = new JLabel("oh mali napindot mo? hays");
        lblStartupSubheader3.setBounds(130, 561, 150, 20);
        lblStartupSubheader3.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
        lblStartupSubheader3.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblStartupSubheader3);

        btnGoBack = new JButton("<html><u>Go Back</u></html>");
        btnGoBack.setBounds(164, 578, 86, 13);
        btnGoBack.setBackground(Color.WHITE);
        btnGoBack.setForeground(new Color(0x730C0C));
        btnGoBack.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
        btnGoBack.setFocusable(false);
        btnGoBack.setFocusPainted(false);
        btnGoBack.setBorderPainted(false);
        btnGoBack.setOpaque(false);
        btnGoBack.addActionListener(this);
        btnGoBack.setContentAreaFilled(false);
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