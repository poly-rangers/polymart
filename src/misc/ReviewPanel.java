package misc;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;


public class ReviewPanel extends RoundedPanel {
	private static final long serialVersionUID = 3336119340908215674L;
	private JLabel lblUsername;
	public ReviewPanel(int cornerRadius, Color backgroundColor, String userName) {
		super(cornerRadius, backgroundColor); 
		
		setLayout(null);
		
		ImageIcon profileImage = new ImageIcon(this.getClass().getResource("/profileiconGRAY.png"));
	    JLabel profileIcon = new JLabel(profileImage);
	    profileIcon.setBounds(10, 12, 24, 24);
		
	    add(profileIcon);
	    
	    lblUsername = new JLabel("@"+ userName);
	    lblUsername.setFont(new Font("Montserrat", Font.ITALIC, 11));
	    lblUsername.setBounds(44,8, 261, 15);
	    add(lblUsername);
	    
	    
	       
	    add(profileIcon);
		
	}

}