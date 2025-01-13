package misc;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NavigationBar extends JPanel {
	
	private static final long serialVersionUID = 2021409567929036389L;

	public NavigationBar() {
		
		setSize(430, 72);
		setBackground(new Color(102, 0, 0));
		setBorder(new EmptyBorder(0, 5, 0, 5));
		
		JButton btnHome = new JButton("Home");
		
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		// HOME BUTTON APPEARANCE
		btnHome.setForeground(Color.WHITE);
		btnHome.setBackground(new Color(102, 0, 0));
		btnHome.setFocusPainted(false);
		btnHome.setBorderPainted(false);
		btnHome.setFont(new Font("Montserrat", Font.PLAIN, 10));
		btnHome.setHorizontalAlignment(SwingConstants.CENTER);
		
		// HOME ICON 
		ImageIcon homeIcon = new ImageIcon(this.getClass().getResource("/homeicon.png"));
		btnHome.setIcon(homeIcon); 
		btnHome.setIconTextGap(0);
        btnHome.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnHome.setHorizontalTextPosition(SwingConstants.CENTER);
		
		
		JButton btnMap = new JButton("Map");
		btnMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		// MAP BUTTON APPEARANCE
		btnMap.setForeground(Color.WHITE);
		btnMap.setBackground(new Color(102, 0, 0));
		btnMap.setFocusPainted(false);
		btnMap.setBorderPainted(false);
		btnMap.setFont(new Font("Montserrat", Font.PLAIN, 10));
		btnMap.setHorizontalAlignment(JLabel.CENTER);
		
		// MAP ICON
		ImageIcon mapIcon = new ImageIcon(this.getClass().getResource("/mapicon.png"));
		btnMap.setIcon(mapIcon); 
		btnMap.setIconTextGap(0);
		btnMap.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMap.setHorizontalTextPosition(SwingConstants.CENTER);
		
		
		JButton btnReceipt = new JButton("Receipt");
		btnReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		// RECEIPT BUTTON APPEARANCE
		btnReceipt.setForeground(Color.WHITE);
		btnReceipt.setBackground(new Color(102, 0, 0));
		btnReceipt.setFocusPainted(false);
		btnReceipt.setBorderPainted(false);
		btnReceipt.setFont(new Font("Montserrat", Font.PLAIN, 10));
		btnReceipt.setHorizontalAlignment(JLabel.CENTER);
		
		// RECEIPT ICON
		ImageIcon receiptIcon = new ImageIcon(this.getClass().getResource("/receipticon.png"));
		btnReceipt.setIcon(receiptIcon); 
		btnReceipt.setIconTextGap(0);
		btnReceipt.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnReceipt.setHorizontalTextPosition(SwingConstants.CENTER);
		
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		// PROFILE BUTTON APPEARANCE
		btnProfile.setForeground(Color.WHITE);
		btnProfile.setBackground(new Color(102, 0, 0));
		btnProfile.setFocusPainted(false);
		btnProfile.setBorderPainted(false);
		btnProfile.setFont(new Font("Montserrat", Font.PLAIN, 10));
		btnProfile.setHorizontalAlignment(JLabel.CENTER);
		
		// PROFILE ICON
		ImageIcon profileIcon = new ImageIcon(this.getClass().getResource("/profileicon.png"));
		btnProfile.setIcon(profileIcon); 
		btnProfile.setIconTextGap(0);
		btnProfile.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnProfile.setHorizontalTextPosition(SwingConstants.CENTER);
		
		
		setLayout(new GridLayout(0, 4, 0, 0));

       
		
		
		add(btnHome);
		add(btnMap);
		add(btnReceipt);
		add(btnProfile);
		
	}
}