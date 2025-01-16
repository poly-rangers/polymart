package misc;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
//		setAlignmentX(Component.CENTER_ALIGNMENT);
		
		searchBar = new JTextField();
		searchBar.setText("ang tamad tamad mo mag-scroll talaga naman...");
//		searchBar.setBorder(null);
		searchBar.setBorder(new EmptyBorder(0, 5, 0, 0));
		
		ImageIcon searchImage = new ImageIcon(this.getClass().getResource("/searchicon.png"));
	
		JLabel searchIcon = new JLabel(searchImage);
		searchIcon.setBorder(new EmptyBorder(0, 10, 0, 0));
		add(searchIcon);
		
		add(searchBar);
		searchBar.setColumns(10);
	}
	
	public JTextField getSearchBar() {
        return searchBar;
    }
	
	//Placeholder Text for Search Bar
	public void setupSearchPlaceholder(String placeholder) {
        searchBar.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchBar.getText().equals(placeholder)) {
                    searchBar.setText("");
                    searchBar.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchBar.getText().isEmpty()) {
                    searchBar.setForeground(Color.GRAY);
                    searchBar.setText(placeholder);
                }
            }
        });
        searchBar.setForeground(Color.GRAY);
    }
}