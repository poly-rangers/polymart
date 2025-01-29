package buyer;

import java.awt.*;
import javax.swing.*;
import misc.AddProduct;
import misc.CustomScrollBar;
import misc.SearchBar;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class BuyerDashboardPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton btnReceiptTest;

    public BuyerDashboardPanel(JPanel contentPane) {
    	this.contentPane = contentPane;
    	
        setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);

        // Icon + title
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_buyer.icon.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
        setLayout(null);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        startupImage.setBounds(16, 24, 150, 47);
        add(startupImage);

        JLabel lblNewLabel = new JLabel("Products");
        lblNewLabel.setBounds(43, 132, 91, 24);
        lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 19));
        add(lblNewLabel);

        // Add the search bar
        SearchBar searchBar = new SearchBar();
        searchBar.setBounds(61, 86, 291, 24);
        searchBar.setupSearchPlaceholder("ang tamad tamad mo mag-scroll talaga naman...");
        add(searchBar);
        searchBar.setLayout(new BoxLayout(searchBar, BoxLayout.X_AXIS));

        // Scrollable panel for products
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(22, 162, 382, 418);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);

        JPanel scrollContentPanel = new JPanel();
        scrollContentPanel.setBorder(null);
        scrollContentPanel.setBackground(new Color(255, 255, 255));
        scrollContentPanel.setLayout(new GridLayout(0, 2, 10, 10));
        scrollContentPanel.add(new AddProduct("Pastil wow", "P150"));
        scrollContentPanel.add(new AddProduct("Pastil wow", "P150"));
        scrollContentPanel.add(new AddProduct("Pastil wow", "P150"));
        scrollContentPanel.add(new AddProduct("Pastil wow", "P150"));
        scrollContentPanel.add(new AddProduct("Pastil wow", "P150"));
        scrollContentPanel.add(new AddProduct("Pastil wow", "P150"));
        
        scrollContentPanel.add(new AddProduct("Pastil wow", "P150"));
        scrollContentPanel.add(new AddProduct("Pastil wow", "P150"));
        scrollContentPanel.add(new AddProduct("Pastil wow", "P150"));
        scrollContentPanel.add(new AddProduct("Pastil wow", "P150"));
        scrollContentPanel.add(new AddProduct("Pastil wow", "P150"));
        scrollContentPanel.add(new AddProduct("Pastil wow", "P150"));

        // AddProduct components mouseListener
        for (Component comp : scrollContentPanel.getComponents()) {
            if (comp instanceof AddProduct) {
                AddProduct product = (AddProduct) comp;
                product.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        product.setBorder(BorderFactory.createLineBorder(new Color(0x730C0C), 2)); // Maroon border
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        product.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1)); // Default black border
                    }
                	
                	@Override
	            	public void mouseClicked(MouseEvent e) {
	            		CardLayout clLayout = (CardLayout) contentPane.getLayout();
	                    clLayout.show(contentPane, "ProductDetails");
	            	}
                });
            }
        }

        scrollContentPanel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		CardLayout clLayout = (CardLayout) contentPane.getLayout();
                clLayout.show(contentPane, "ProductDetails");
        	}
        });
        
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBar());
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setViewportView(scrollContentPanel);

        add(scrollPane);
        
        // Create NavigationBar and position it at the bottom
        BuyerNavigationBar navBar = new BuyerNavigationBar(contentPane);
        navBar.setBounds(0, 611, 416, 52);
        add(navBar);
        
        navBar.btnHome.addActionListener(e -> System.out.println("Already on Dashboard Panel"));
        navBar.btnMap.addActionListener(e -> switchPanel("BuyerMap"));
        navBar.btnOrders.addActionListener(e -> switchPanel("BuyerOrderPanel"));
        navBar.btnProfile.addActionListener(e -> switchPanel("BuyerProfile"));
    }
    
    private void switchPanel(String panelName) {
        if (contentPane.getLayout() instanceof CardLayout) {
            ((CardLayout) contentPane.getLayout()).show(contentPane, panelName);
        } else {
            System.err.println("Error: contentPane is not using CardLayout!");
        }
    }
}