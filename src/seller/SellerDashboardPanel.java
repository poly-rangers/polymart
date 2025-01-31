package seller;
import misc.*;
import misc.RoundedButton;
import misc.SearchBar;
import misc.UserBaseTemplate;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SellerDashboardPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAddProduct;
	private String[] arrLabels = {"Item Name", "Rating", "Review", "Status"};
	private StatusButton state, state1, state2, state3;
	private RoundedButton btnViewReview;
	private JLabel lblItemName, lblRating, lblReview, lblStatus;

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

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(22, 162, 382, 418);
        scrollPane.setOpaque(false);
       
        lblItemName = new JLabel("Item Name");
        lblItemName.setFont(new Font("Montserrat", Font.BOLD, 12));
        lblItemName.setForeground(new Color(0x730C0C));
        lblItemName.setBounds(23,146,88,15);
        add(lblItemName);
        
        lblRating = new JLabel("Rating");
        lblRating.setFont(new Font("Montserrat", Font.BOLD, 12));
        lblRating.setForeground(new Color(0x730C0C));
        lblRating.setBounds(136,146,52,15);
        add(lblRating);
        
        lblReview = new JLabel("Review");
        lblReview.setFont(new Font("Montserrat", Font.BOLD, 12));
        lblReview.setForeground(new Color(0x730C0C));
        lblReview.setBounds(225,146,60,15);
        add(lblReview);
        
        lblStatus = new JLabel("Status");
        lblStatus.setFont(new Font("Montserrat", Font.BOLD, 12));
        lblStatus.setForeground(new Color(0x730C0C));
        lblStatus.setBounds(330,146,60,15);
        add(lblStatus);
 
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
        add(scrollPane);
        
        SellerNavigationBar navBar = new SellerNavigationBar(scrollContentPanel);
        navBar.setBounds(0, 611, 416, 52);
        add(navBar);
        
        navBar.btnHome.addActionListener(e -> System.out.println("Already on Dashboard Panel"));
        navBar.btnMap.addActionListener(e -> switchPanel("SellerDashboardMap"));
        navBar.btnOrders.addActionListener(e -> switchPanel("SellerOrderPanel"));
        navBar.btnProfile.addActionListener(e -> switchPanel("SellerProfile"));
        
        JPanel pnlHeader = new JPanel();
        pnlHeader.setBounds(23, 111, 367, 24);
        add(pnlHeader);
        pnlHeader.setOpaque(true);
        pnlHeader.setBackground(Color.WHITE);
        pnlHeader.setLayout(new BorderLayout());
        
        JLabel lblMyProduct = new JLabel("My Products");
        lblMyProduct.setForeground(new Color(0, 0, 0));
        lblMyProduct.setFont(new Font("Montserrat", Font.BOLD, 19));
        
        btnAddProduct = new RoundedButton("Add a product", 10);
        btnAddProduct.addActionListener(this);
        btnAddProduct.setFocusPainted(false);
        btnAddProduct.setBorderPainted(false);
        btnAddProduct.setFont(new Font("Montserrat", Font.BOLD | Font.ITALIC, 11));
        btnAddProduct.setBackground(new Color(102, 0, 0));
        btnAddProduct.setForeground(Color.WHITE);
        btnAddProduct.setFocusable(true);
        btnAddProduct.setMinimumSize(new Dimension(130,10));
        
        pnlHeader.add(lblMyProduct, BorderLayout.WEST);
        pnlHeader.add(btnAddProduct, BorderLayout.EAST);
        
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
	
	private void showReview() {
        // Logic to show product review
        CardLayout clLayout = (CardLayout) contentPane.getLayout();
        clLayout.show(contentPane, "SellerProductReviews");
    }
	

}