package buyer;
import misc.AddProduct;
import misc.NavigationBar;
import java.awt.*;
import javax.swing.*;


public class BuyerDashboardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtDitoSearchBar;

	public BuyerDashboardPanel(JPanel contentPane) {

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
        lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 19));
        add(lblNewLabel);
        
        txtDitoSearchBar = new JTextField();
        panelLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 17, SpringLayout.SOUTH, txtDitoSearchBar);
        panelLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, txtDitoSearchBar);
        panelLayout.putConstraint(SpringLayout.NORTH, txtDitoSearchBar, 28, SpringLayout.SOUTH, startupImage);
        panelLayout.putConstraint(SpringLayout.WEST, txtDitoSearchBar, 63, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, txtDitoSearchBar, -86, SpringLayout.EAST, this);
        txtDitoSearchBar.setText("ang tamad tamad mo mag-scroll talaga naman...");
        add(txtDitoSearchBar);
        txtDitoSearchBar.setColumns(10);
        
        
        JScrollPane scrollPane = new JScrollPane();
        panelLayout.putConstraint(SpringLayout.NORTH, scrollPane, 162, SpringLayout.NORTH, this);
        scrollPane.setOpaque(false);
        panelLayout.putConstraint(SpringLayout.WEST, scrollPane, 22, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, this);
        
        JPanel scrollContentPanel = new JPanel();
        scrollContentPanel.setLayout(new GridLayout(3, 2, 10, 10));
      
        
        scrollContentPanel.add(new AddProduct("Pastil wow", "P150"));
        scrollContentPanel.add(new JPanel());
        scrollContentPanel.add(new JPanel());
        scrollContentPanel.add(new JPanel());
      
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setViewportView(scrollContentPanel);
       
        add(scrollPane);
        
           
     // Create NavigationBar and position it at the bottom
        NavigationBar navBar = new NavigationBar();
        panelLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -30, SpringLayout.NORTH, navBar);
        panelLayout.putConstraint(SpringLayout.NORTH, navBar, -50, SpringLayout.SOUTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, navBar, 0, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, navBar, 0, SpringLayout.SOUTH, this);
        panelLayout.putConstraint(SpringLayout.EAST, navBar, 414, SpringLayout.WEST, this);
        add(navBar);
        
	}
}
