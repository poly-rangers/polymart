package seller;
import misc.*;
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
	private String[] arrLabels = {"Item Name", "Rating", "Review", "Status"};
	private StatusButton state, state1, state2, state3;
	private RoundedButton btnViewReview;
	private JLabel lblRating, lblReview, lblStatus;
	
	public SellerDashboardPanel(JPanel contentPane, String strUserRole) {
		super(contentPane, "seller");
		this.contentPane = contentPane; 
	}

	public void setPanelHeader() {
		JLabel lblMyProduct = new JLabel("My Products");
		lblMyProduct.setBounds(25, 29, 197, 59);
        lblMyProduct.setForeground(new Color(0, 0, 0));
        lblMyProduct.setFont(new Font("Montserrat", Font.BOLD, 25));
        
        btnAddProduct = new RoundedButton("Add a product", 10);
        btnAddProduct.setBounds(267, 52, 126, 22);
        btnAddProduct.addActionListener(this);
        btnAddProduct.setFocusPainted(false);
        btnAddProduct.setBorderPainted(false);
        btnAddProduct.setFont(new Font("Montserrat", Font.BOLD | Font.ITALIC, 11));
        btnAddProduct.setBackground(new Color(102, 0, 0));
        btnAddProduct.setForeground(Color.WHITE);
        btnAddProduct.setFocusable(true);
        btnAddProduct.setMinimumSize(new Dimension(130,10));
        headerPanel.setLayout(null);
        headerPanel.add(lblMyProduct);
        headerPanel.add(btnAddProduct);
	}
	
	public void customizeContentPanel() {
		this.contentPane = contentPane;

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(22, 22, 382, 418);
        scrollPane.setOpaque(false);
        
        String[] headerTitles = {"Item Name", "   Rating", "Review", "Status"};
        JPanel tableTitlesPanel = new JPanel(new GridLayout(1, 4));
        tableTitlesPanel.setBackground(new Color(255, 255, 255));
        tableTitlesPanel.setBounds(23,0,406,22);
        for(int i = 0; i < headerTitles.length; i++) {
        	JLabel lblItemName = new JLabel(headerTitles[i]);
	        lblItemName.setFont(new Font("Montserrat", Font.BOLD, 12));
	        lblItemName.setForeground(new Color(0x730C0C));
	        tableTitlesPanel.add(lblItemName);
        }
        
        contentPanel.add(tableTitlesPanel);
 
        JPanel scrollContentPanel = new JPanel();
        scrollContentPanel.setOpaque(true);
        scrollContentPanel.setBorder(null);
        scrollContentPanel.setPreferredSize(new Dimension(350, 625));
        scrollContentPanel.setLayout(new BoxLayout(scrollContentPanel, BoxLayout.Y_AXIS));
        scrollContentPanel.setBackground(Color.WHITE);

        ListProduct listProduct = new ListProduct();
        scrollContentPanel.add(listProduct.createRow("Motivation mabuhay", "3.4", e -> showReview()));
        scrollContentPanel.add(listProduct.createRow("Pagmamahal at aruga", "4.8", e -> showReview()));
        scrollContentPanel.add(listProduct.createRow("relapse sa umaga", "4.2", e -> showReview()));
        scrollContentPanel.add(listProduct.createRow("mahal pa rin kita", "0.3", e -> showReview()));
        scrollContentPanel.add(listProduct.createRow("PLS BUMALIK KA NA", "2.3", e -> showReview()));
        
        scrollPane.setBorder(null);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setColumnHeaderView(scrollContentPanel);
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBar());
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
	
	private void showReview() {
        // Logic to show product review
        CardLayout clLayout = (CardLayout) contentPane.getLayout();
        clLayout.show(contentPane, "SellerProductReviews");
    }
	

}