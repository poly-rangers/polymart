package seller;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import misc.RoundButton;
import misc.SearchBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ProductListing extends JPanel implements ActionListener {
	
	private JPanel contentPane;
	private JButton btnGoBack;

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
        btnGoBack = new JButton();
        btnGoBack.addActionListener(this);
        
        ImageIcon ogGoBackIcon = new ImageIcon(this.getClass().getResource("/backicon.png"));
        Image scaledGoBackIcon = ogGoBackIcon.getImage().getScaledInstance(30, 24, Image.SCALE_SMOOTH);
        btnGoBack.setIcon(new ImageIcon(scaledGoBackIcon));
        btnGoBack.setBackground(Color.WHITE);
        btnGoBack.setFocusPainted(false);
        btnGoBack.setBorderPainted(false);
        
        JLabel lblMyProduct = new JLabel("List a product");
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
        scrollContentPanel.setLayout(new BoxLayout(scrollContentPanel, BoxLayout.X_AXIS));
        
        JPanel pnlProductContent = new JPanel();
        pnlProductContent.setLayout(new BoxLayout(pnlProductContent, BoxLayout.Y_AXIS));
        pnlProductContent.setAlignmentX(Component.LEFT_ALIGNMENT);
       
        RoundButton btnAddImage = new RoundButton("+", 10);
        btnAddImage.setFont(new Font("Montserrat", Font.BOLD, 14));
        btnAddImage.setForeground(Color.WHITE);
        btnAddImage.setBackground(new Color(102, 0, 0));
        
        btnAddImage.setPreferredSize(new Dimension(78, 69));
        
        JLabel lblProductImages = new JLabel("Product Images");
        lblProductImages.setFont(new Font("Montserrat", Font.BOLD, 14));
        
        JLabel lblProductName = new JLabel("Product Details");
        lblProductName.setFont(new Font("Montserrat", Font.BOLD, 14));
        
        JTextField txtfldProductName = new JTextField();
        txtfldProductName.setText("Product Name here");
//        txtfldProductName.setPreferredSize(new Dimension(100,50));
        
        JTextField txtfldProductDesc = new JTextField();
        txtfldProductDesc.setText("Product Description here");
        
        JLabel lblVariation = new JLabel("Variation");
        lblVariation.setFont(new Font("Montserrat", Font.BOLD, 14));
        
        String[] strVariation = {"Add Variation"};
        JComboBox<String> toggleDownVariation = new JComboBox<>(strVariation);
        
        JLabel lblPlaceAndAvailability = new JLabel("Place & Availability");
        lblPlaceAndAvailability.setFont(new Font("Montserrat", Font.BOLD, 14));
        
        String[] strPlace = {"Pin Variation"};
        JComboBox<String> toggleDownPlace = new JComboBox<>(strPlace);
        
        String[] strTime = {"Add Time"};
        JComboBox<String> toggleDownTime = new JComboBox<>(strTime);
        
        String[] strDate = {"Add Date"};
        JComboBox<String> toggleDownDate = new JComboBox<>(strDate);
       
        
        JLabel lblModeOfPayment = new JLabel("Mode of Payment");
        lblModeOfPayment.setFont(new Font("Montserrat", Font.BOLD, 14));
        
        String[] strModeOfPayment = {"Choose"};
        JComboBox<String> toggleDownModeOfPayment = new JComboBox<>(strModeOfPayment);
        
        JLabel lblSocials = new JLabel("Socials");
        lblSocials.setFont(new Font("Montserrat", Font.BOLD, 14));
        
        String[] strSocials = {"Add here"};
        JComboBox<String> toggleDownSocials = new JComboBox<>(strSocials);
        
        
        
        
        
        pnlProductContent.add(lblProductImages);
        pnlProductContent.add(btnAddImage);
        pnlProductContent.add(lblProductName);
        pnlProductContent.add(txtfldProductName);
        pnlProductContent.add(txtfldProductDesc);
        
        
        pnlProductContent.add(lblVariation);
        pnlProductContent.add(toggleDownVariation);
        
        pnlProductContent.add(lblPlaceAndAvailability);
        pnlProductContent.add(toggleDownPlace);
        pnlProductContent.add(toggleDownTime);
        pnlProductContent.add(toggleDownDate);
        
        pnlProductContent.add(lblModeOfPayment);
        pnlProductContent.add(toggleDownModeOfPayment);
        
        pnlProductContent.add(lblSocials);
        pnlProductContent.add(toggleDownSocials);
        
        
        scrollContentPanel.add(pnlProductContent);
        
        
        
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
	
	@Override
    public void actionPerformed(ActionEvent actEvent) {
    	Object objSourceEvent = actEvent.getSource();
    	
    	if (objSourceEvent == btnGoBack) {
    		// Switch to Product Listing
            CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "SellerDashboardPanel");
    	} 
    }

}
