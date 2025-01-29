package misc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;;

public class StatusButton extends RoundedButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8803877173922409867L;
	
	private boolean isClicked = false;
	
	public StatusButton(String state) {
		super(state, 20);
		setFont(new Font("Montserrat", Font.BOLD, 8));
		setForeground(new Color(192, 192, 192));
		setBackground(new Color(232, 232, 232));
		setPreferredSize(new Dimension(30,10));
		setFocusable(false);
		setFocusPainted(false);
		setBorderPainted(false);
		
		addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				isClicked = !isClicked;
				
				setBackground(isClicked ? new Color(124, 163, 95) : new Color(115,112,112));
				setText(isClicked ? "In Stock" : "No Stock");
				setForeground(isClicked ? Color.WHITE : Color.WHITE);
			}
			
		});
	}

}
