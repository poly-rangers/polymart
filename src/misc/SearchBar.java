// wala pa pero may balak ako d2,,,, - jianna

package misc;
import java.awt.Color;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class SearchBar extends JPanel {
	
	private static final long serialVersionUID = 5801126585738611444L;
	private JTextField searchBar;
	
	public SearchBar() {
		
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(new LineBorder(Color.GRAY));
		
		searchBar = new JTextField();
		searchBar.setText("ang tamad tamad mo mag-scroll talaga naman...");
		searchBar.setBorder(null);
		searchBar.setBorder(new EmptyBorder(0, 5, 0, 0));
		
		ImageIcon searchImage = new ImageIcon(this.getClass().getResource("/searchicon.png"));
	
		JLabel searchIcon = new JLabel(searchImage);
		searchIcon.setBorder(new EmptyBorder(0, 10, 0, 0));
		add(searchIcon);
		
		add(searchBar);
		searchBar.setColumns(10);
		
		
	}
}