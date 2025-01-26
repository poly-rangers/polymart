package seller;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import misc.RoundedButton;

public class SellerMainPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public SellerMainPanel(JPanel contentPane) {
	
		setBackground(Color.WHITE);
		setSize(414, 600);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setAlignmentX(CENTER_ALIGNMENT);
		
		add(Box.createVerticalStrut(20)); // Adds padding on top of image
		
		ImageIcon imgIconOriginalImage = new ImageIcon(this.getClass().getResource("/polypup_front.png"));
        Image imgScaled = imgIconOriginalImage.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        JLabel imgStartup = new JLabel(new ImageIcon(imgScaled));
        imgStartup.setAlignmentX(CENTER_ALIGNMENT);
        
        add(imgStartup);
        
        JLabel lblHeaderText1 = new JLabel("WELCOME TO");
        lblHeaderText1.setFont(new Font("Montserrat", Font.PLAIN, 24));  
        lblHeaderText1.setForeground(new Color(102, 0, 0));  
        lblHeaderText1.setAlignmentX(CENTER_ALIGNMENT);
        
        JLabel lblHeaderText2 = new JLabel("POLYMART,");
        lblHeaderText2.setFont(new Font("Montserrat", Font.BOLD, 48)); 
        lblHeaderText2.setForeground(new Color(102, 0, 0));  
        lblHeaderText2.setAlignmentX(CENTER_ALIGNMENT);
        
        JLabel lblHeaderText3 = new JLabel("baks!");
        lblHeaderText3.setFont(new Font("Montserrat", Font.ITALIC, 32)); 
        lblHeaderText3.setForeground(new Color(102, 0, 0));  
        lblHeaderText3.setAlignmentX(CENTER_ALIGNMENT);
        
        add(lblHeaderText1);
        add(lblHeaderText2);
        add(lblHeaderText3);
        add(Box.createVerticalStrut(20));
        
        JLabel lblContentText = new JLabel("ready ka na ba magwaldas te?");
        lblContentText.setBackground(new Color(255, 255, 255));
        lblContentText.setFont(new Font("Montserrat", Font.PLAIN, 16)); 
        lblContentText.setAlignmentX(Component.CENTER_ALIGNMENT);
      
        JLabel lblContentText1 = new JLabel("mag-sign up ka muna hahah");
        lblContentText1.setBackground(new Color(255, 255, 255));
        lblContentText1.setFont(new Font("Montserrat", Font.PLAIN, 16)); 
        lblContentText1.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        add(lblContentText);
        add(lblContentText1);
        
        RoundedButton btnStart = new RoundedButton("gewwww, deserve ko 'to!", 45);
        btnStart.setForeground(Color.WHITE);
        btnStart.setBackground(new Color(102, 0, 0));
        btnStart.setFont(new Font("Montserrat", Font.BOLD, 16));
        btnStart.setMargin(new Insets(12, 25, 12, 25));
        btnStart.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        add(Box.createVerticalStrut(15));
        add(btnStart);
        
        // Mali napindot mo? label
        JLabel lblStartupSubheader3 = new JLabel("oh mali napindot mo? hays");
        lblStartupSubheader3.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 10));
        lblStartupSubheader3.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton btnGoBack = new JButton("Go Back");
        btnGoBack.setBackground(Color.WHITE);
    	btnGoBack.setForeground(new Color(0x730C0C));
    	btnGoBack.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
    	btnGoBack.setFocusable(false);
    	btnGoBack.setOpaque(false);
    	btnGoBack.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0x730C0C)));
    	btnGoBack.setAlignmentX(Component.CENTER_ALIGNMENT);
      
        add(Box.createVerticalStrut(15));
        add(lblStartupSubheader3);
    	add(btnGoBack);
       
	}
}