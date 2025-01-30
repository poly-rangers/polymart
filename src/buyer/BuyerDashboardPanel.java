package buyer;

import java.awt.*;
import javax.swing.*;
import misc.*;
import java.awt.event.*;

public class BuyerDashboardPanel extends UserBaseTemplate {
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public BuyerDashboardPanel(JPanel contentPane) {
		super(contentPane, "buyer");
	}
    
    public void setPanelHeader() {
    	contentPanel.removeAll();
		headerPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Products");
        lblNewLabel.setBounds(43, 50, 91, 24);
        lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 19));
        headerPanel.add(lblNewLabel);
        
        SearchBar searchBar = new SearchBar();
        searchBar.setBounds(61, 10, 291, 24);
        searchBar.setupSearchPlaceholder("ang tamad tamad mo mag-scroll talaga naman...");
        headerPanel.add(searchBar);
        searchBar.setLayout(new BoxLayout(searchBar, BoxLayout.X_AXIS));
        
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