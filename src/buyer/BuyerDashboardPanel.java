package buyer;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import frames.SetMeetUpFrame;
import misc.AddProduct;
import misc.SearchBar;

import frames.CustomDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyerDashboardPanel extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

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

        
        
        scrollContentPanel.setLayout(new GridLayout(0, 2, 10, 10));
        try(BufferedReader reader = new BufferedReader(new FileReader("databases/product_database.txt"))){
			String line;
			while((line = reader.readLine()) != null) {
				String[] productDetails = line.split(",");
				if(productDetails.length == 4) {
					String strProductName = productDetails[1];
					String strProductPrice = "P" + productDetails[2];
					String strImagePath = productDetails[3];
					
					AddProduct newProduct = new AddProduct(strProductName, strProductPrice, strImagePath);
					scrollContentPanel.add(newProduct);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       

//        scrollContentPanel.setLayout(new GridLayout(3, 2, 10, 10));
//        scrollContentPanel.add(new AddProduct("Pastil wow", "P150", name));
//        scrollContentPanel.add(new JPanel());
//        scrollContentPanel.add(new JPanel());
//        scrollContentPanel.add(new JPanel());

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

        
        
	}


//        JButton btnNewButton = new JButton("test");
//        panelLayout.putConstraint(SpringLayout.WEST, btnNewButton, 77, SpringLayout.EAST, startupImage);
//        panelLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, startupImage);
//        btnNewButton.addActionListener(this);
//        add(btnNewButton);
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Open the meet-up frame
        SetMeetUpFrame meetUpFrame = new SetMeetUpFrame();
        meetUpFrame.setVisible(true);
    }

}
