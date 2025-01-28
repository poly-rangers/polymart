package buyer;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import frames.SetMeetUpFrame;
import misc.AddProduct;
import misc.SearchBar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyerDashboardPanel extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    JButton btnNewButton, btnReceiptTest;
    private JPanel contentPane;

    public BuyerDashboardPanel(JPanel contentPane) {
    	setBorder(null);
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
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        panelLayout.putConstraint(SpringLayout.NORTH, scrollPane, 162, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -6, SpringLayout.NORTH, scrollPane);
        scrollPane.setOpaque(false);
        panelLayout.putConstraint(SpringLayout.WEST, scrollPane, 22, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, this);

        JPanel scrollContentPanel = new JPanel();
        scrollContentPanel.setBorder(null);
        scrollContentPanel.setBackground(new Color(255, 255, 255));
        scrollContentPanel.setLayout(new GridLayout(3, 2, 10, 10));
        scrollContentPanel.add(new AddProduct("Pastil wow", "P150"));
        scrollContentPanel.add(new JPanel());
        scrollContentPanel.add(new JPanel());
        scrollContentPanel.add(new JPanel());

        scrollPane.getViewport().setOpaque(false);
        scrollPane.setViewportView(scrollContentPanel);

        add(scrollPane);

        // Create NavigationBar and position it at the bottom
        BuyerNavigationBar navBar = new BuyerNavigationBar();
        panelLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -30, SpringLayout.NORTH, navBar);
        panelLayout.putConstraint(SpringLayout.NORTH, navBar, -50, SpringLayout.SOUTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, navBar, 0, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, navBar, 0, SpringLayout.SOUTH, this);
        panelLayout.putConstraint(SpringLayout.EAST, navBar, 414, SpringLayout.WEST, this);
        add(navBar);

        btnNewButton = new JButton("test");
        panelLayout.putConstraint(SpringLayout.WEST, btnNewButton, 58, SpringLayout.EAST, startupImage);
        panelLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -27, SpringLayout.NORTH, searchBar);
        btnNewButton.addActionListener(this);
        add(btnNewButton);
        
        
        btnReceiptTest = new JButton("Receipt");
        panelLayout.putConstraint(SpringLayout.NORTH, btnReceiptTest, 0, SpringLayout.NORTH, startupImage);
        panelLayout.putConstraint(SpringLayout.WEST, btnReceiptTest, 0, SpringLayout.WEST, btnNewButton);
        panelLayout.putConstraint(SpringLayout.WEST, btnNewButton, 90, SpringLayout.EAST, startupImage);
        panelLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, startupImage);
        btnReceiptTest.addActionListener(this);
        add(btnReceiptTest);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Open the meet-up frame
        if(e.getSource() == btnNewButton) {
        	SetMeetUpFrame meetUpFrame = new SetMeetUpFrame();
        	meetUpFrame.setVisible(true);
        	System.out.println("Button Clicked");
        
        } else if(e.getSource() == btnReceiptTest) {
			CardLayout clLayout = (CardLayout) contentPane.getLayout();
        	clLayout.show(contentPane, "BuyerOrderPanel"); // Should display the receipt panel initially
        	contentPane.revalidate();
        	contentPane.repaint();
        }
    }
    
    class CustomScrollBarUI extends BasicScrollBarUI {
        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.GRAY);
            g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 10, 10);
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
        }
        
        @Override
		public Dimension getPreferredSize(JComponent c) {
            if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
                return new Dimension(5, super.getPreferredSize(c).height); // Make it 8 pixels wide
            } else {
                return new Dimension(super.getPreferredSize(c).width, 8); // Adjust for horizontal bar if needed
            }
        }
    }
}
