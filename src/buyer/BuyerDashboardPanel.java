package buyer;

import java.awt.*;
import javax.swing.*;
import misc.*;
import java.awt.event.*;

public class BuyerDashboardPanel extends UserBaseTemplate {
	private static final long serialVersionUID = 1L;
	private JButton btnActiveOrders, btnCompleteOrders;
	private JPanel contentPane;
	
    public BuyerDashboardPanel(JPanel contentPane) {
		super(contentPane, "buyer");
		this.contentPane = contentPane;
	}
    
    public void setPanelHeader() {
    	contentPanel.removeAll();
		headerPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("All Products");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel.setBounds(226, 0, 180, 37);
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 25));
        headerPanel.add(lblNewLabel);
        
        btnActiveOrders = new JButton("Available");
        btnActiveOrders.setBounds(208, 38, 90, 21);
        btnActiveOrders.setBackground(Color.WHITE);
        btnActiveOrders.setForeground(Color.BLACK);
        btnActiveOrders.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
        btnActiveOrders.setFocusable(false);
        btnActiveOrders.setOpaque(false);
        btnActiveOrders.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(0x730C0C)));
        headerPanel.add(btnActiveOrders);

        btnCompleteOrders = new JButton("Not Available");
        btnCompleteOrders.setBackground(new Color(240, 240, 240));
        btnCompleteOrders.setBounds(298, 38, 108, 21);
        btnCompleteOrders.setForeground(Color.BLACK);
        btnCompleteOrders.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
        btnCompleteOrders.setFocusable(false);
        btnCompleteOrders.setOpaque(false);
        btnCompleteOrders.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, new Color(0x730C0C)));
        headerPanel.add(btnCompleteOrders);
        
        JLabel lblPolyaSays = new JLabel("polya says not to worry because money grows on trees!");
        lblPolyaSays.setForeground(new Color(115, 12, 12));
        lblPolyaSays.setFont(new Font("Montserrat", Font.BOLD | Font.ITALIC, 9));
        lblPolyaSays.setBounds(133, 60, 273, 21);
        headerPanel.add(lblPolyaSays);
        
        revalidate();
        repaint();
	}

    public void customizeContentPanel() {
    	this.contentPane = contentPane;
    	contentPanel.removeAll();
  
        // Scrollable panel for products
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(23, 0, 383, 443);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);

        JPanel scrollContentPanel = new JPanel();
        scrollContentPanel.setBorder(null);
        scrollContentPanel.setBackground(new Color(255, 255, 255));
        scrollContentPanel.setLayout(new GridLayout(0, 2, 10, 10));
        
        scrollContentPanel.add(new AddProduct("Pastil wow", "P150", "/pastil.png", "4.5"));
        scrollContentPanel.add(new AddProduct("Cookies", "P59", "/cookie.png", "4.9"));
        scrollContentPanel.add(new AddProduct("Smorez", "P100", "/smorez.png","3.4"));
        scrollContentPanel.add(new AddProduct("Sandwhat", "P120", "/sandwhich.png","4.8"));
        scrollContentPanel.add(new AddProduct("Pastil wow", "P150", "/pastil.png", "4.5"));
        scrollContentPanel.add(new AddProduct("Cookies", "P59", "/cookie.png", "4.9"));
        scrollContentPanel.add(new AddProduct("Smorez", "P100", "/smorez.png","3.4"));
        scrollContentPanel.add(new AddProduct("Sandwhat", "P120", "/sandwhich.png","4.8"));
        scrollContentPanel.add(new AddProduct("Pastil wow", "P150", "/pastil.png", "4.5"));
        scrollContentPanel.add(new AddProduct("Cookies", "P59", "/cookie.png", "4.9"));
        scrollContentPanel.add(new AddProduct("Smorez", "P100", "/smorez.png","3.4"));
        scrollContentPanel.add(new AddProduct("Sandwhat", "P120", "/sandwhich.png","4.8"));
        scrollContentPanel.addMouseListener(null);

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
                        product.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1)); // Default border
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        switchPanel("ProductDetails"); // Use the helper method
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

        contentPanel.add(scrollPane);
        revalidate();
        repaint();
    }
    
   
    
    private void switchPanel(String panelName) {
        if (contentPane.getLayout() instanceof CardLayout) {
            ((CardLayout) contentPane.getLayout()).show(contentPane, panelName);
        } else {
            System.err.println("Error: contentPane is not using CardLayout!");
        }
    }
}