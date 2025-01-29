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
        SpringLayout panelLayout = new SpringLayout();
        setLayout(panelLayout);

        // Icon + title
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_buyer.icon.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        panelLayout.putConstraint(SpringLayout.NORTH, startupImage, 24, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, startupImage, 16, SpringLayout.WEST, this);
        add(startupImage);

        JLabel lblNewLabel = new JLabel("Products");
        panelLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 43, SpringLayout.WEST, this);
        lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 19));
        add(lblNewLabel);

        // Add the search bar
        SearchBar searchBar = new SearchBar();
        searchBar.setupSearchPlaceholder("ang tamad tamad mo mag-scroll talaga naman...");
        panelLayout.putConstraint(SpringLayout.NORTH, searchBar, 15, SpringLayout.SOUTH, startupImage);
        panelLayout.putConstraint(SpringLayout.WEST, searchBar, 61, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, searchBar, 39, SpringLayout.SOUTH, startupImage);
        panelLayout.putConstraint(SpringLayout.EAST, searchBar, -62, SpringLayout.EAST, this);
        add(searchBar);
        searchBar.setLayout(new BoxLayout(searchBar, BoxLayout.X_AXIS));

        // Scrollable panel for products
        JScrollPane scrollPane = new JScrollPane();
        panelLayout.putConstraint(SpringLayout.NORTH, scrollPane, 162, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -6, SpringLayout.NORTH, scrollPane);
        scrollPane.setOpaque(false);
        panelLayout.putConstraint(SpringLayout.WEST, scrollPane, 22, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, this);

        JPanel scrollContentPanel = new JPanel();
        scrollContentPanel.setLayout(new GridLayout(3, 2, 10, 10));
        scrollContentPanel.add(new AddProduct("Pastil wow", "P150"));
        scrollContentPanel.add(new JPanel());
        scrollContentPanel.add(new JPanel());
        scrollContentPanel.add(new JPanel());
        
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
        BuyerNavigationBar navBar = new BuyerNavigationBar(scrollContentPanel);
        panelLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -30, SpringLayout.NORTH, navBar);
        panelLayout.putConstraint(SpringLayout.NORTH, navBar, -50, SpringLayout.SOUTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, navBar, 0, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, navBar, 0, SpringLayout.SOUTH, this);
        panelLayout.putConstraint(SpringLayout.EAST, navBar, 414, SpringLayout.WEST, this);
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