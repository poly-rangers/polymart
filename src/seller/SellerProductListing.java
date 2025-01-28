package seller;

import misc.SearchBar;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import frames.CustomDialog;
import misc.RoundedButton;

public class SellerProductListing extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = -318363178469668105L;
	private JPanel contentPane;
	private JButton btnGoBack;
	private JLabel lblProductImage, lblProductImageDescription, lblProductDetails, lblProductName, lblProductDesc, lblProductCat,
	lblMeetUpDetails, lblMOP, lblMeetUpTime, lblProductPrice, lblMeetUpDate;
	private JTextField productNameField, meetUpField, timeField, priceField; 
	private JTextArea productDescArea;
	private RoundedButton btnAddImage1, btnAddImage2, btnAddImage3, btnAddImage4;
	private String[] strCategories = {"Food", "Fashion", "Accessories"};
	private JComboBox<String> categoryCombo;
	private JCheckBox[] cbLocations;
	private JCheckBox cbGCash, cbCash;
	private RoundedButton btnPost;
	
	private String[] arrLocations = {"1. Lagoon", "2. West Wing", "3. Dome", "4. East Wing", 
			"5. South Wing", "6. Linear Park", "7. Charlie Building", "8. Grandstand", "9. Tennis Courtside",
			"10. Souvenir Shop", "11. Gate Exit", "12. Gate Entrance"};
	
	public SellerProductListing(JPanel contentPane) {
		this.contentPane = contentPane;
		
		setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        setLayout(null);
		
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_seller.icon.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        startupImage.setBounds(16, 24, 150, 47);
        add(startupImage);
        
        JPanel pnlHeader = new JPanel();
        pnlHeader.setLayout(new BoxLayout(pnlHeader, BoxLayout.X_AXIS));
        pnlHeader.setOpaque(true);
        pnlHeader.setBounds(20,124,376,32);
        pnlHeader.setBackground(Color.WHITE);
        
        ImageIcon ogGoBackIcon = new ImageIcon(this.getClass().getResource("/arrowbackicon.png"));
        Image scaledGoBackIcon = ogGoBackIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        
        btnGoBack = new JButton();
        btnGoBack.addActionListener(this);
        btnGoBack.setIcon(new ImageIcon(scaledGoBackIcon));
        btnGoBack.setBackground(Color.WHITE);
        btnGoBack.setFocusPainted(false);
        btnGoBack.setBorderPainted(false);
        pnlHeader.add(btnGoBack);
        
        JLabel lblMyProduct = new JLabel("List a product");
        lblMyProduct.setFont(new Font("Montserrat", Font.BOLD, 19));
        pnlHeader.add(lblMyProduct);
        
        add(pnlHeader);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(20, 162, 376, 417);
        add(scrollPane);

        JPanel scrollContentPanel = new JPanel();
        scrollContentPanel.setOpaque(true);
        scrollContentPanel.setBackground(Color.WHITE);
        scrollContentPanel.setBorder(null);
        scrollContentPanel.setLayout(null);
        scrollContentPanel.setPreferredSize(new Dimension(350, 700));
  
        
        // ADD IMAGES
        lblProductImage = new JLabel("Add Images");
        lblProductImage.setBounds(5, 5, 100, 18);
        lblProductImage.setFont(new Font("Montserrat", Font.BOLD, 14));
        scrollContentPanel.add(lblProductImage);
        
        lblProductImageDescription = new JLabel("Add up to 4 images to showcase your product");
        lblProductImageDescription.setBounds(5, 25, 279, 15);
        lblProductImageDescription.setFont(new Font("Montserrat", Font.ITALIC, 12));
        lblProductImageDescription.setForeground(new Color(129, 124, 124));
        scrollContentPanel.add(lblProductImageDescription);
        
        // ADD IMAGE BUTTON
        btnAddImage1 = new RoundedButton("+", 10);
        btnAddImage1.setBounds(5,45,80,80);
        btnAddImage1.setFocusable(false);
        btnAddImage1.setFocusPainted(false);
        btnAddImage1.setFont(new Font("Montserrat", Font.BOLD, 14));
        btnAddImage1.setBackground(new Color(241,241,241,241));
        btnAddImage1.setForeground(new Color(149,145,145,145));
        scrollContentPanel.add(btnAddImage1);
        
        btnAddImage2 = new RoundedButton("+", 10);
        btnAddImage2.setBounds(94,45,80,80);
        btnAddImage2.setFocusable(false);
        btnAddImage2.setFocusPainted(false);
        btnAddImage2.setFont(new Font("Montserrat", Font.BOLD, 14));
        btnAddImage2.setBackground(new Color(241,241,241,241));
        btnAddImage2.setForeground(new Color(149,145,145,145));
        scrollContentPanel.add(btnAddImage2);
        
        btnAddImage3 = new RoundedButton("+", 10);
        btnAddImage3.setBounds(185,45,80,80);
        btnAddImage3.setFocusable(false);
        btnAddImage3.setFocusPainted(false);
        btnAddImage3.setFont(new Font("Montserrat", Font.BOLD, 14));
        btnAddImage3.setBackground(new Color(241,241,241,241));
        btnAddImage3.setForeground(new Color(149,145,145,145));
        scrollContentPanel.add(btnAddImage3);
        
        btnAddImage4 = new RoundedButton("+", 10);
        btnAddImage4.setBounds(274,45,80,80);
        btnAddImage4.setFocusable(false);
        btnAddImage4.setFocusPainted(false);
        btnAddImage4.setFont(new Font("Montserrat", Font.BOLD, 14));
        btnAddImage4.setBackground(new Color(241,241,241,241));
        btnAddImage4.setForeground(new Color(149,145,145,145));
        scrollContentPanel.add(btnAddImage4);
        
        addMouseListenerToButton(btnAddImage1);
        addMouseListenerToButton(btnAddImage2);
        addMouseListenerToButton(btnAddImage3);
        addMouseListenerToButton(btnAddImage4);
       
        // PRODUCT DETAILS
        lblProductDetails = new JLabel("Enter Product Details");
        lblProductDetails.setBounds(5, 135, 314, 18);
        lblProductDetails.setFont(new Font("Montserrat", Font.BOLD, 14));
        scrollContentPanel.add(lblProductDetails);
        
        lblProductName = new JLabel("Add a product name");
        lblProductName.setBounds(5, 155, 156, 15);
        lblProductName.setFont(new Font("Montserrat", Font.ITALIC, 12));
        lblProductName.setForeground(new Color(129, 124, 124));
        scrollContentPanel.add(lblProductName);
        
        productNameField = new JTextField(25);
        productNameField.setBounds(5, 170, 345, 20);
        productNameField.setText("Product Name");
        productNameField.setFont(new Font("Montserrat", Font.ITALIC, 12));
        productNameField.setForeground(new Color(149, 145, 145));
        productNameField.setBackground(new Color(241, 241, 241));
        productNameField.setBorder(null);
        setupTextPlaceholder(productNameField, "Product Name");
        scrollContentPanel.add(productNameField);
 
        lblProductDesc = new JLabel("Add a product description");
        lblProductDesc.setBounds(5, 200, 246, 15);
        lblProductDesc.setFont(new Font("Montserrat", Font.ITALIC, 12));
        lblProductDesc.setForeground(new Color(129, 124, 124));
        scrollContentPanel.add(lblProductDesc);
        
        productDescArea = new JTextArea(25, 25);
        productDescArea.setBounds(5, 215, 345, 56);
        productDescArea.setText("Product Description");
        productDescArea.setFont(new Font("Montserrat", Font.ITALIC, 12));
        productDescArea.setForeground(new Color(149, 145, 145));
        productDescArea.setBackground(new Color(241, 241, 241));
        setupTextPlaceholder(productDescArea, "Product Description");
        scrollContentPanel.add(productDescArea);
        
        
        lblProductPrice = new JLabel("Add product price:");
        lblProductPrice.setBounds(5, 282, 143, 13);
        lblProductPrice.setFont(new Font("Montserrat", Font.ITALIC, 12));
        lblProductPrice.setForeground(new Color(129, 124, 124));
        scrollContentPanel.add(lblProductPrice);
        
        priceField = new JTextField(25);
        priceField.setBounds(5, 300, 124, 20);
        priceField.setText("P100");
        priceField.setFont(new Font("Montserrat", Font.ITALIC, 12));
        priceField.setForeground(new Color(149, 145, 145));
        priceField.setBackground(new Color(241, 241, 241));
        priceField.setBorder(null);
        setupTextPlaceholder(priceField, "P100");
        scrollContentPanel.add(priceField);
        
        
        lblProductCat = new JLabel("Select product category:");
        lblProductCat.setBounds(160, 275, 201, 26);
        lblProductCat.setFont(new Font("Montserrat", Font.ITALIC, 12));
        lblProductCat.setForeground(new Color(129, 124, 124));
        scrollContentPanel.add(lblProductCat);
        
        categoryCombo = new JComboBox<String>(strCategories);
        categoryCombo.setBounds(160, 300, 124, 20);
        categoryCombo.setSelectedIndex(-1);
        scrollContentPanel.add(categoryCombo);
        
        lblMeetUpDetails = new JLabel("Set Meet Up Details");
        lblMeetUpDetails.setBounds(5, 335, 314, 18);
        lblMeetUpDetails.setFont(new Font("Montserrat", Font.BOLD, 14));
        scrollContentPanel.add(lblMeetUpDetails);
        
        
        // LOCATION SELECT
        lblProductDesc = new JLabel("Select available locations:");
        lblProductDesc.setBounds(5, 355, 246, 15);
        lblProductDesc.setFont(new Font("Montserrat", Font.ITALIC, 12));
        lblProductDesc.setForeground(new Color(129, 124, 124));
        scrollContentPanel.add(lblProductDesc);
        
        JPanel pnlLocations = new JPanel(new GridLayout(6,2,0,0));
        pnlLocations.setBorder(BorderFactory.createEmptyBorder()); 
        pnlLocations.setBackground(Color.WHITE);
        cbLocations = new JCheckBox[arrLocations.length];
        
        for (int intIndex = 0; intIndex < 6; intIndex++) {
            // Add the item for the left column (1-6)
            cbLocations[intIndex] = new JCheckBox(arrLocations[intIndex]);
            cbLocations[intIndex].setBackground(Color.WHITE);
            cbLocations[intIndex].setFocusable(false);
            pnlLocations.add(cbLocations[intIndex]);
            
            // Add the item for the right column (7-12)
            cbLocations[intIndex + 6] = new JCheckBox(arrLocations[intIndex + 6]);
            cbLocations[intIndex + 6].setBackground(Color.WHITE);
            cbLocations[intIndex+6].setFocusable(false);
            pnlLocations.add(cbLocations[intIndex + 6]);
        }
       
        pnlLocations.setBounds(5,375,345,100);
        scrollContentPanel.add(pnlLocations);
        
        // MDOE OF PAYMENT
        lblMOP = new JLabel("Select available modes of payment:");
        lblMOP.setBounds(5, 477, 246, 15);
        lblMOP.setFont(new Font("Montserrat", Font.ITALIC, 12));
        lblMOP.setForeground(new Color(129, 124, 124));
        scrollContentPanel.add(lblMOP);
        
        cbGCash = new JCheckBox("GCash");
        cbGCash.setBackground(new Color(255, 255, 255));
        cbGCash.setFocusable(false);
        cbGCash.setFocusPainted(false);
        cbGCash.setBounds(160, 495, 108, 15);
        scrollContentPanel.add(cbGCash);
        
        cbCash = new JCheckBox("Cash");
        cbCash.setBackground(new Color(255, 255, 255));
        cbCash.setFocusable(false);
        cbCash.setFocusPainted(false);
        cbCash.setBounds(5, 495, 108, 15);
        scrollContentPanel.add(cbCash);
        
        
        // MEET UPS
        lblMeetUpDate = new JLabel("Select available meet-up date/s:");
        lblMeetUpDate.setBackground(new Color(255, 255, 255));
        lblMeetUpDate.setBounds(5, 515, 246, 15);
        lblMeetUpDate.setFont(new Font("Montserrat", Font.ITALIC, 12));
        lblMeetUpDate.setForeground(new Color(129, 124, 124));
        scrollContentPanel.add(lblMeetUpDate);
        
        timeField = new JTextField(25);
        timeField.setEditable(false);
        timeField.setBounds(5, 530, 345, 20);
        timeField.setFont(new Font("Montserrat", Font.ITALIC, 12));
        timeField.setBackground(new Color(241, 241, 241));
        timeField.setBorder(null);
        scrollContentPanel.add(timeField);
        
        JComboBox<String> tempCom = new JComboBox<>();
        tempCom.setBounds(5,555, 89, 20);
        scrollContentPanel.add(tempCom);
        
        lblMeetUpTime = new JLabel("Select available meet-up date/s:");
        lblMeetUpTime.setBackground(new Color(255, 255, 255));
        lblMeetUpTime.setBounds(5, 580, 246, 15);
        lblMeetUpTime.setFont(new Font("Montserrat", Font.ITALIC, 12));
        lblMeetUpTime.setForeground(new Color(129, 124, 124));
        scrollContentPanel.add(lblMeetUpTime);
        
        meetUpField = new JTextField(25);
        meetUpField.setEditable(false);
        meetUpField.setBounds(5, 595, 345, 20);
        meetUpField.setFont(new Font("Montserrat", Font.ITALIC, 12));
        meetUpField.setBackground(new Color(241, 241, 241));
        meetUpField.setBorder(null);
        scrollContentPanel.add(meetUpField);
        
        JComboBox<String> tempCom1 = new JComboBox<>();
        tempCom1.setBounds(5,620, 89, 20);
        scrollContentPanel.add(tempCom1);
        
        btnPost = new RoundedButton("Post", 25);
        btnPost.setBounds(136,660, 89, 20);
        btnPost.setFocusPainted(false);
        btnPost.setFont(new Font("Montserrat", Font.BOLD, 12));
        btnPost.setBackground(new Color(102, 0, 0));
        btnPost.setForeground(Color.WHITE);
        btnPost.setFocusable(true);
        scrollContentPanel.add(btnPost);
        
        scrollPane.setBorder(null);
        scrollContentPanel.setBorder(null);        
        scrollPane.setViewportView(scrollContentPanel);
    
        SellerNavigationBar navBar = new SellerNavigationBar();
        navBar.setBounds(0,610, 414,50);
        add(navBar);
        
    }

    @Override
    public void actionPerformed(ActionEvent actEvent) {
        Object objSourceEvent = actEvent.getSource();

        if (objSourceEvent == btnGoBack) {
            // Switch to Product Listing
            CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "SellerDashboardPanel");
        }
        
    }
    
    private void addMouseListenerToButton(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(0x730C0C));
                button.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(0x730C0C)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(241,241,241,241));
                button.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(241,241,241,241)));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("JPEG/PNG files", "jpg","jpeg","png")); // Filter for PDFs
                int result = fileChooser.showOpenDialog(button);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile(); // Store the selected file
                    System.out.println("File selected: " + selectedFile.getAbsolutePath());
                } else {
                    System.out.println("No file selected.");
                }
            }
        });
    }
    
    private void setupTextPlaceholder(JTextField textField, String placeholder) {
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(placeholder);
                }
            }
        });
        textField.setForeground(Color.GRAY);
    }
    
    //method overloading
    private void setupTextPlaceholder(JTextArea textArea, String placeholder) {
    	textArea.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textArea.getText().equals(placeholder)) {
                	textArea.setText("");
                	textArea.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textArea.getText().isEmpty()) {
                	textArea.setForeground(Color.GRAY);
                	textArea.setText(placeholder);
                }
            }
        });
    	textArea.setForeground(Color.GRAY);
    }
}