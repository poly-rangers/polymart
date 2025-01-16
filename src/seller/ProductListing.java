package seller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import misc.RoundButton;
import misc.SearchBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ProductListing extends JPanel {
	
	private JPanel contentPane;

	public ProductListing(JPanel contentPane) {
		this.contentPane = contentPane;
		
		setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        
//        // Icon with header
//        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_seller.icon.png"));
//        Image scaledImage = originalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
//        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
//        startupImage.setBorder(new EmptyBorder(24,16,0,0));
//        startupImage.setAlignmentX(Component.LEFT_ALIGNMENT); 
//        
        
        setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        SpringLayout panelLayout = new SpringLayout();
        setLayout(panelLayout);
        
        // Icon + title
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_seller.icon.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        panelLayout.putConstraint(SpringLayout.NORTH, startupImage, 24, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, startupImage, 16, SpringLayout.WEST, this);
        add(startupImage);
            
        // Search Bar
        SearchBar searchBar = new SearchBar();
        searchBar.setupSearchPlaceholder("ang tamad tamad mo mag-scroll talaga naman...");
        panelLayout.putConstraint(SpringLayout.NORTH, searchBar, 15, SpringLayout.SOUTH, startupImage);
        panelLayout.putConstraint(SpringLayout.WEST, searchBar, 61, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, searchBar, 39, SpringLayout.SOUTH, startupImage);
        panelLayout.putConstraint(SpringLayout.EAST, searchBar, -62, SpringLayout.EAST, this);
        add(searchBar);
        searchBar.setLayout(new BoxLayout(searchBar, BoxLayout.X_AXIS));
        
        JPanel pnlHeader = new JPanel();
        pnlHeader.setOpaque(true);
        pnlHeader.setBackground(Color.WHITE);
        pnlHeader.setLayout(new BorderLayout());
        panelLayout.putConstraint(SpringLayout.WEST, pnlHeader, 20, SpringLayout.WEST, this);
        
        // Go Back Button
        JButton btnGoBack = new JButton();
        btnGoBack.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        
        ImageIcon goBackIcon = new ImageIcon("backicon.png");
        btnGoBack.setIcon(goBackIcon);
        btnGoBack.setBackground(Color.WHITE);
        btnGoBack.setFocusPainted(false);
        btnGoBack.setBorderPainted(false);
        
        JLabel lblMyProduct = new JLabel("   List a product");
        panelLayout.putConstraint(SpringLayout.WEST, lblMyProduct, 43, SpringLayout.WEST, this);
        lblMyProduct.setFont(new Font("Montserrat", Font.BOLD, 19));
        
        pnlHeader.add(btnGoBack, BorderLayout.WEST);
        pnlHeader.add(lblMyProduct);
        
        JScrollPane scrollPane = new JScrollPane();
        panelLayout.putConstraint(SpringLayout.SOUTH, pnlHeader, -6, SpringLayout.NORTH, scrollPane);
        panelLayout.putConstraint(SpringLayout.EAST, pnlHeader, 0, SpringLayout.EAST, scrollPane);

        panelLayout.putConstraint(SpringLayout.NORTH, scrollPane, 162, SpringLayout.NORTH, this);
        scrollPane.setOpaque(false);
        panelLayout.putConstraint(SpringLayout.WEST, scrollPane, 22, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, this);
        
        JPanel scrollContentPanel = new JPanel();
        
        
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setViewportView(scrollContentPanel);
       
        add(scrollPane);
        add(pnlHeader);
        
     // Create NavigationBar and position it at the bottom
        SellerNavigationBar navBar = new SellerNavigationBar();
        panelLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -30, SpringLayout.NORTH, navBar);
        panelLayout.putConstraint(SpringLayout.NORTH, navBar, -50, SpringLayout.SOUTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, navBar, 0, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, navBar, 0, SpringLayout.SOUTH, this);
        panelLayout.putConstraint(SpringLayout.EAST, navBar, 414, SpringLayout.WEST, this);
        add(navBar);
	}

}
