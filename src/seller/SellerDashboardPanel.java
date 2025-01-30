package seller;
import misc.RoundedButton;
import misc.SearchBar;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SellerDashboardPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAddProduct;
	private String[] arrLabels = {"Item Name", "Pricing", "Rating", "Review"};

	public SellerDashboardPanel(JPanel contentPane) {
		this.contentPane = contentPane;

		setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        
        // Icon + title
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_seller.icon.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
        setLayout(null);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        startupImage.setBounds(16, 24, 150, 47);
        add(startupImage);
        
        JPanel pnlHeader = new JPanel();
        pnlHeader.setBounds(20, 132, 384, 24);
        pnlHeader.setOpaque(true);
        pnlHeader.setBackground(Color.WHITE);
        pnlHeader.setLayout(new BorderLayout());
        
        JLabel lblMyProduct = new JLabel("My Products");
        lblMyProduct.setFont(new Font("Montserrat", Font.BOLD, 19));
        
        btnAddProduct = new RoundedButton("Add a product", 10);
        btnAddProduct.addActionListener(this);
        btnAddProduct.setFocusPainted(false);
        btnAddProduct.setFont(new Font("Montserrat", Font.BOLD | Font.ITALIC, 11));
        btnAddProduct.setBackground(new Color(102, 0, 0));
        btnAddProduct.setForeground(Color.WHITE);
        btnAddProduct.setFocusable(true);
        
        pnlHeader.add(lblMyProduct, BorderLayout.WEST);
        pnlHeader.add(btnAddProduct, BorderLayout.EAST);
        
        // Search Bar
        SearchBar searchBar = new SearchBar();
        searchBar.setBounds(61, 86, 291, 24);
        searchBar.setupSearchPlaceholder("ang tamad tamad mo mag-scroll talaga naman...");
        add(searchBar);
        searchBar.setLayout(new BoxLayout(searchBar, BoxLayout.X_AXIS));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(22, 162, 382, 418);
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
       
        add(scrollPane);
        add(pnlHeader);
        
     // Create NavigationBar and position it at the bottom
        SellerNavigationBar navBar = new SellerNavigationBar(scrollContentPanel);
        navBar.setBounds(0, 611, 416, 52);
        add(navBar);
        
        navBar.btnHome.addActionListener(e -> System.out.println("Already on Dashboard Panel"));
        navBar.btnMap.addActionListener(e -> switchPanel("SellerMap"));
        navBar.btnOrders.addActionListener(e -> switchPanel("SellerOrderPanel"));
        navBar.btnProfile.addActionListener(e -> switchPanel("SellerProfile"));
        
	}
	
	private void switchPanel(String panelName) {
        if (contentPane.getLayout() instanceof CardLayout) {
            ((CardLayout) contentPane.getLayout()).show(contentPane, panelName);
        } else {
            System.err.println("Error: contentPane is not using CardLayout!");
        }
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