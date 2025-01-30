package seller;
import misc.RoundedButton;
import misc.SearchBar;
import misc.UserBaseTemplate;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SellerDashboardPanel extends UserBaseTemplate implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAddProduct;

	public SellerDashboardPanel(JPanel contentPane, String strUserRole) {
		super(contentPane, "seller");
	}

	public void setPanelHeader() {  
		contentPanel.removeAll();
		headerPanel.setLayout(null);
        JLabel lblMyProduct = new JLabel("My Products");
        lblMyProduct.setBounds(40, 50, 147, 50);
        lblMyProduct.setFont(new Font("Montserrat", Font.BOLD, 19));
        
        btnAddProduct = new RoundedButton("Add a product", 10);
        btnAddProduct.addActionListener(this);
        btnAddProduct.setFocusPainted(false);
        btnAddProduct.setFont(new Font("Montserrat", Font.BOLD | Font.ITALIC, 11));
        btnAddProduct.setBackground(new Color(102, 0, 0));
        btnAddProduct.setForeground(Color.WHITE);
        btnAddProduct.setFocusable(true);
        
        headerPanel.add(lblMyProduct, BorderLayout.WEST);
        headerPanel.add(btnAddProduct, BorderLayout.EAST);
        
        // Search Bar
        SearchBar searchBar = new SearchBar();
        searchBar.setBounds(61, 20, 291, 24);
        searchBar.setupSearchPlaceholder("ang tamad tamad mo mag-scroll talaga naman...");
        headerPanel.add(searchBar);
        searchBar.setLayout(new BoxLayout(searchBar, BoxLayout.X_AXIS));
        revalidate();
        repaint();
	}
	
	public void customizeContentPanel() {
		this.contentPane = contentPane;
		String[] arrLabels = new String[]{"Item Name", "Pricing", "Rating", "Review"};
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(22, 0, 382, 418);
        scrollPane.setOpaque(false);
        
        JPanel scrollContentPanel = new JPanel();
        scrollContentPanel.setOpaque(true);
        scrollContentPanel.setBackground(Color.WHITE);
        scrollContentPanel.setFocusable(false);
        scrollContentPanel.setBorder(null);
        
        
        JPanel lblTitleBar = new JPanel();
        lblTitleBar.setLayout(new GridLayout(1,4,10,0));
        
        for (String tempLabel : arrLabels) {
            JLabel lblNames = new JLabel(tempLabel, SwingConstants.CENTER); // Center-align the text
            lblNames.setFont(new Font("Montserrat", Font.BOLD, 14)); // Optional: Set font for the labels
            lblTitleBar.add(lblNames);
        }
         
        scrollContentPanel.add(lblTitleBar);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setViewportView(scrollContentPanel);
        contentPanel.add(scrollPane);

	}
	
	@Override
    public void actionPerformed(ActionEvent actEvent) {
    	Object objSourceEvent = actEvent.getSource();
    	
    	if (objSourceEvent == btnAddProduct) {
    		// Switch to Product Listing
            CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "SellerProductListing");
    	} 
    	
    	
    }
}