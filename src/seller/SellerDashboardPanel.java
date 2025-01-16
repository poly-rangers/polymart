package seller;
import misc.RoundButton;
//import misc.AddProduct;
import misc.SearchBar;

import java.awt.*;
//import java.awt.event.FocusAdapter;
//import java.awt.event.FocusEvent;

import javax.swing.*;


public class SellerDashboardPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public SellerDashboardPanel(JPanel contentPane) {

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
        
        JPanel pnlHeader = new JPanel();
        pnlHeader.setOpaque(true);
        pnlHeader.setBackground(Color.WHITE);
        pnlHeader.setLayout(new BorderLayout());
        panelLayout.putConstraint(SpringLayout.WEST, pnlHeader, 20, SpringLayout.WEST, this);
        
        JLabel lblMyProduct = new JLabel("My Products");
        panelLayout.putConstraint(SpringLayout.WEST, lblMyProduct, 43, SpringLayout.WEST, this);
        lblMyProduct.setFont(new Font("Montserrat", Font.BOLD, 19));
        
        RoundButton lblAddProduct = new RoundButton("Add a product", 10);
        lblAddProduct.setFont(new Font("Montserrat", Font.BOLD | Font.ITALIC, 11));
        lblAddProduct.setBackground(new Color(102, 0, 0));
        lblAddProduct.setForeground(Color.WHITE);
        lblAddProduct.setFocusable(false);
        
        pnlHeader.add(lblMyProduct, BorderLayout.WEST);
        pnlHeader.add(lblAddProduct, BorderLayout.EAST);
        
        
        
        // Search Bar
        SearchBar searchBar = new SearchBar();
        searchBar.setupSearchPlaceholder("ang tamad tamad mo mag-scroll talaga naman...");
        panelLayout.putConstraint(SpringLayout.NORTH, searchBar, 15, SpringLayout.SOUTH, startupImage);
        panelLayout.putConstraint(SpringLayout.WEST, searchBar, 61, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, searchBar, 39, SpringLayout.SOUTH, startupImage);
        panelLayout.putConstraint(SpringLayout.EAST, searchBar, -62, SpringLayout.EAST, this);
        add(searchBar);
        searchBar.setLayout(new BoxLayout(searchBar, BoxLayout.X_AXIS));
        
        JScrollPane scrollPane = new JScrollPane();
        panelLayout.putConstraint(SpringLayout.SOUTH, pnlHeader, -6, SpringLayout.NORTH, scrollPane);
        panelLayout.putConstraint(SpringLayout.EAST, pnlHeader, 0, SpringLayout.EAST, scrollPane);

        panelLayout.putConstraint(SpringLayout.NORTH, scrollPane, 162, SpringLayout.NORTH, this);
        scrollPane.setOpaque(false);
        panelLayout.putConstraint(SpringLayout.WEST, scrollPane, 22, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, this);
        
        JPanel scrollContentPanel = new JPanel();
        
        JPanel lblTitleBar = new JPanel();
        
        JLabel lblItemName = new JLabel("Item Name");
        JLabel lblPrice = new JLabel("Price");
        JLabel lblRating = new JLabel("Rating");
        JLabel lblReview = new JLabel("Review");
        
        lblTitleBar.add(lblItemName);
        lblTitleBar.add(lblPrice);
        lblTitleBar.add(lblRating);
        lblTitleBar.add(lblReview);
        
        scrollContentPanel.add(lblTitleBar);
        
        
        
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
