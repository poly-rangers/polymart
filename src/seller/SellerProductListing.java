package seller;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import frames.CustomDialog;
import databases.ProductDatabase;
import databases.UserSession;
import misc.CustomScrollBar;
import misc.RoundedButton;
import misc.RoundedPanel;

import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;

public class SellerProductListing extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = -318363178469668105L;
	private JPanel contentPane;
	private JButton btnGoBack, btnAddDate;
	private JLabel lblProductImage, lblProductImageDescription, lblProductDetails, lblProductName, lblProductDesc, lblProductCat,
	lblMeetUpDetails, lblMOP, lblMeetUpTime, lblProductPrice, lblMeetUpDate, lblAddImage1, lblAddImage2, lblAddImage3, lblAddImage4;
	private JTextField productNameField, meetUpField, timeField, priceField; 
	private JTextArea productDescArea;
	private String[] strCategories = {"Food", "Fashion", "Accessories"};
	private JComboBox<String> categoryCombo, timeCombo;
	private JCheckBox[] cbLocations;
	private JCheckBox cbGCash, cbCash;
	private JDateChooser dateChooser;
	private RoundedButton btnPost;
	private ProductDatabase productDatabase;
	private File imgFile1, imgFile2, imgFile3, imgFile4;
	private RoundedPanel panelProdName, panelProdDesc, panelPrice, panelLoc, panelTime;
	
	private String[] arrLocations = {"1. Lagoon", "2. West Wing", "3. Dome", "4. East Wing", 
			"5. South Wing", "6. Linear Park", "7. Charlie Building", "8. Grandstand", "9. Tennis Courtside",
			"10. Souvenir Shop", "11. Gate Exit", "12. Gate Entrance"};
	private String[] timeSlots = {
		    "7:00 AM", "8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM",
		    "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM"
		};
	
	
	public SellerProductListing(JPanel contentPane) {
		this.contentPane = contentPane;
		
		setBackground(Color.WHITE);
        setSize(414, 660);
        setLayout(null);
        
        productDatabase = new ProductDatabase();
        
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_seller.icon.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        startupImage.setBounds(16, 24, 150, 47);
        add(startupImage);
        
        JPanel pnlHeader = new JPanel();
        pnlHeader.setLayout(new BoxLayout(pnlHeader, BoxLayout.X_AXIS));
        pnlHeader.setOpaque(true);
        pnlHeader.setBounds(20,91,376,32);
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
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBar());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(20, 123, 376, 499);
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
        lblProductImageDescription.setBounds(5, 25, 300, 15);
        lblProductImageDescription.setFont(new Font("Montserrat", Font.ITALIC, 12));
        lblProductImageDescription.setForeground(new Color(129, 124, 124));
        scrollContentPanel.add(lblProductImageDescription);
        
        //ADD IMAGE LABELS
        lblAddImage1 = new JLabel("+",10);
        lblAddImage1.setHorizontalAlignment(JLabel.CENTER);  
        lblAddImage1.setVerticalAlignment(JLabel.CENTER);   
        lblAddImage1.setBounds(5,45,80,80);
        lblAddImage1.setFocusable(false);
        lblAddImage1.setFont(new Font("Montserrat", Font.BOLD, 14));
        lblAddImage1.setBackground(new Color(241, 241, 241, 241));
        lblAddImage1.setForeground(new Color(149,145,145,145));
        scrollContentPanel.add(lblAddImage1);
        
        lblAddImage2 = new JLabel("+",10);
        lblAddImage2.setHorizontalAlignment(JLabel.CENTER);  
        lblAddImage2.setVerticalAlignment(JLabel.CENTER);   
        lblAddImage2.setBounds(94,45,80,80);
        lblAddImage2.setFocusable(false);
        lblAddImage2.setFont(new Font("Montserrat", Font.BOLD, 14));
        lblAddImage2.setBackground(new Color(241, 241, 241, 241));
        lblAddImage2.setForeground(new Color(149,145,145,145));
        scrollContentPanel.add(lblAddImage2);
        
        lblAddImage3 = new JLabel("+",10);
        lblAddImage3.setHorizontalAlignment(JLabel.CENTER);  
        lblAddImage3.setVerticalAlignment(JLabel.CENTER);   
        lblAddImage3.setBounds(185,45,80,80);
        lblAddImage3.setFocusable(false);
        lblAddImage3.setFont(new Font("Montserrat", Font.BOLD, 14));
        lblAddImage3.setBackground(new Color(241, 241, 241, 241));
        lblAddImage3.setForeground(new Color(149,145,145,145));
        scrollContentPanel.add(lblAddImage3);
        
        lblAddImage4 = new JLabel("+",10);
        lblAddImage4.setHorizontalAlignment(JLabel.CENTER);  
        lblAddImage4.setVerticalAlignment(JLabel.CENTER);   
        lblAddImage4.setBounds(274,45,80,80);
        lblAddImage4.setFocusable(false);
        lblAddImage4.setFont(new Font("Montserrat", Font.BOLD, 14));
        lblAddImage4.setBackground(new Color(241, 241, 241, 241));
        lblAddImage4.setForeground(new Color(149,145,145,145));
        scrollContentPanel.add(lblAddImage4);
        
        addMouseListenerToLabel(lblAddImage1);
        addMouseListenerToLabel(lblAddImage2);
        addMouseListenerToLabel(lblAddImage3);
        addMouseListenerToLabel(lblAddImage4);
        
        //TEXTFIELD ROUNDED LOOK
        panelProdName = new RoundedPanel(15, new Color(241,241,241));
        panelProdName.setBounds(5, 170, 345, 23);
        
        panelProdDesc = new RoundedPanel(15, new Color(241,241,241));
        panelProdDesc.setBounds(5, 215, 345, 59);
        
        panelPrice = new RoundedPanel(15, new Color(241,241,241));
        panelPrice.setBounds(5, 300, 124, 23);
        
        panelLoc = new RoundedPanel(15, new Color(241,241,241));
        panelLoc.setBounds(5, 530, 345, 23);
        
        panelTime = new RoundedPanel(15, new Color(241,241,241));
        panelTime.setBounds(5, 600, 345, 23);
        
        // PRODUCT DETAILS
        lblProductDetails = new JLabel("Enter Product Details");
        lblProductDetails.setBounds(5, 135, 314, 18);
        lblProductDetails.setFont(new Font("Montserrat", Font.BOLD, 14));
        scrollContentPanel.add(lblProductDetails);
        
        lblProductName = new JLabel("Add a product name");
        lblProductName.setBounds(5, 155, 156, 15);
        lblProductName.setFont(new Font("Montserrat", Font.ITALIC + Font.BOLD, 12));
        lblProductName.setForeground(new Color(129, 124, 124));
        scrollContentPanel.add(lblProductName);
        
        productNameField = new JTextField(25);
        productNameField.setBounds(5, 170, 345, 20);
        productNameField.setText("Product Name");
        setupTextFieldPlaceholder(productNameField, "Product Name");
        productNameField.setFont(new Font("Montserrat", Font.ITALIC, 12));
        productNameField.setForeground(new Color(149, 145, 145));
        productNameField.setBackground(new Color(241, 241, 241));
        productNameField.setBorder(null);
        setupTextPlaceholder(productNameField, "Product Name");
        panelProdName.add(productNameField);
        scrollContentPanel.add(panelProdName);
 
        lblProductDesc = new JLabel("Add a product description");
        lblProductDesc.setBounds(5, 200, 246, 15);
        lblProductDesc.setFont(new Font("Montserrat", Font.ITALIC + Font.BOLD, 12));
        lblProductDesc.setForeground(new Color(129, 124, 124));
        scrollContentPanel.add(lblProductDesc);
        
        productDescArea = new JTextArea(3, 25);
        productDescArea.setBounds(5, 215, 345, 56);
        productDescArea.setText("Product Description");
        setupTextAreaPlaceholder(productDescArea, "Product Description");
        productDescArea.setFont(new Font("Montserrat", Font.ITALIC, 12));
        productDescArea.setForeground(new Color(149, 145, 145));
        productDescArea.setBackground(new Color(241, 241, 241));
        setupTextPlaceholder(productDescArea, "Product Description");
        panelProdDesc.add(productDescArea);
        scrollContentPanel.add(panelProdDesc);
        
        lblProductPrice = new JLabel("Add product price:");
        lblProductPrice.setBounds(5, 282, 143, 13);
        lblProductPrice.setFont(new Font("Montserrat", Font.BOLD | Font.ITALIC, 12));
        lblProductPrice.setForeground(new Color(129, 124, 124));
        scrollContentPanel.add(lblProductPrice);
        
        priceField = new JTextField(9);
        priceField.setBounds(5, 300, 124, 20);
        priceField.setText("ex. P100");
        setupTextFieldPlaceholder(priceField, "ex. P100");
        priceField.setFont(new Font("Montserrat", Font.ITALIC, 12));
        priceField.setForeground(new Color(149, 145, 145));
        priceField.setBackground(new Color(241, 241, 241));
        priceField.setBorder(null);
        setupTextPlaceholder(priceField, "P100");
        panelPrice.add(priceField);
        scrollContentPanel.add(panelPrice);
        
        lblProductCat = new JLabel("Select product category:");
        lblProductCat.setBounds(160, 275, 201, 26);
        lblProductCat.setFont(new Font("Montserrat", Font.BOLD | Font.ITALIC, 12));
        lblProductCat.setForeground(new Color(129, 124, 124));
        scrollContentPanel.add(lblProductCat);
        
        categoryCombo = new JComboBox<String>(strCategories);
        categoryCombo.setSelectedIndex(-1);
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
        
        meetUpField = new JTextField(25);
        meetUpField.setEditable(false);
        meetUpField.setBounds(5, 530, 345, 20);
        meetUpField.setFont(new Font("Montserrat", Font.ITALIC, 12));
        meetUpField.setBackground(new Color(241, 241, 241));
        meetUpField.setBorder(null);
        panelLoc.add(meetUpField);
        scrollContentPanel.add(panelLoc);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(15, 557, 133, 20);
        scrollContentPanel.add(dateChooser);
    
        btnAddDate = new RoundedButton("Add Date", 20);
        btnAddDate.setFont(new Font("Montserrat", Font.PLAIN, 11));
        btnAddDate.setBounds(160,557,91,20);
        btnAddDate.setBackground(new Color(115,12,12));
        btnAddDate.setForeground(Color.WHITE);
        btnAddDate.setFocusPainted(false);
        btnAddDate.setFocusable(false);
        btnAddDate.addActionListener(this);
        scrollContentPanel.add(btnAddDate);
        
        lblMeetUpTime = new JLabel("Select available meet-up time/s:");
        lblMeetUpTime.setBackground(new Color(255, 255, 255));
        lblMeetUpTime.setBounds(5, 585, 246, 15);
        lblMeetUpTime.setFont(new Font("Montserrat", Font.ITALIC, 12));
        lblMeetUpTime.setForeground(new Color(129, 124, 124));
        scrollContentPanel.add(lblMeetUpTime);
        
        timeField = new JTextField(25);
        timeField.setEditable(false);
        timeField.setBounds(5, 600, 345, 20);
        timeField.setFont(new Font("Montserrat", Font.ITALIC, 12));
        timeField.setBackground(new Color(241, 241, 241));
        timeField.setBorder(null);
        panelTime.add(timeField);
        scrollContentPanel.add(panelTime);
        
        timeCombo = new JComboBox<>(timeSlots);
        timeCombo.setBounds(5,626, 89, 20);
        timeCombo.setSelectedIndex(-1);
        timeCombo.addActionListener(this);
        scrollContentPanel.add(timeCombo);


        btnPost = new RoundedButton("Post", 15);
        btnPost.setBounds(130, 670, 100, 30);
        btnPost.setFocusPainted(false);
        btnPost.setFont(new Font("Montserrat", Font.BOLD, 12));
        btnPost.setBackground(new Color(102, 0, 0));
        btnPost.setForeground(Color.WHITE);
        btnPost.setFocusable(true);
        btnPost.addActionListener(this);
        scrollContentPanel.add(btnPost);
        
        scrollPane.setBorder(null);
        scrollContentPanel.setBorder(null);        
        scrollPane.setViewportView(scrollContentPanel);
    }

    @Override
    public void actionPerformed(ActionEvent actEvent) {
        Object objSourceEvent = actEvent.getSource();

        if (objSourceEvent == btnGoBack) {
            // Switch to Product Listing
            clearFields();
            CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "SellerDashboardPanel");
        } else if (objSourceEvent == btnAddDate) {

        	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date selectedDate = dateChooser.getDate();
        	
                if (selectedDate == null) {
                	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    new CustomDialog(frame, "No Date?", "ang eme ni beh, mag-add ka muna?!?! btw same : (", "k fine");
                    return;
                }

                // Get current date without time for proper comparison
                Calendar today = Calendar.getInstance();
                today.set(Calendar.HOUR_OF_DAY, 0);
                today.set(Calendar.MINUTE, 0);
                today.set(Calendar.SECOND, 0);
                today.set(Calendar.MILLISECOND, 0);

                Calendar selectedCal = Calendar.getInstance();
                selectedCal.setTime(selectedDate);
                selectedCal.set(Calendar.HOUR_OF_DAY, 0);
                selectedCal.set(Calendar.MINUTE, 0);
                selectedCal.set(Calendar.SECOND, 0);
                selectedCal.set(Calendar.MILLISECOND, 0);

                // Check if the selected date is in the past
                if (selectedCal.before(today)) {
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    new CustomDialog(frame, "Time Travel??", "alam kong nagrerelapse ka pero you can't turn back the time:(", "awts gege");
                    dateChooser.setDate(null);
                    return;
                }

                String formattedDate = dateFormat.format(selectedDate);
                String existingText = meetUpField.getText();

                // Check for duplicate dates
                if (existingText.contains(formattedDate)) {
                	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    new CustomDialog(frame, "Date is already taken", "buti pa yung date taken, e ikaw?!", "sorry ha");
                    dateChooser.setDate(null);
                    return;
                }

                // Append new date to meetUpField (comma-separated if not empty)
                if (!existingText.isEmpty()) {
                    meetUpField.setText(existingText + ", " + formattedDate);
                } else {
                    meetUpField.setText(formattedDate);
                }

                // Clear the date chooser for the next selection
                dateChooser.setDate(null);
        } else if (objSourceEvent == timeCombo) {
        	String selectedTime = (String) timeCombo.getSelectedItem();

            // Check if timeField already contains the selected time
            String currentText = timeField.getText();
            if (currentText.contains(selectedTime)) {
                // Show error message and prevent duplicate addition
            	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                new CustomDialog(frame, "Opppsiee ", "taken na sha, sakin ka nalang tumesting", "ayaw");
            } else {
                // Append new time, handling formatting properly
                if (!currentText.isEmpty()) {
                    timeField.setText(currentText + ", " + selectedTime);
                } else {
                    timeField.setText(selectedTime);
                }
            }
        } else if (objSourceEvent == btnPost) {
        	if (validatePost()) {
        		JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                new CustomDialog(parentFrame, "PAKIFILLUP LAHAT BEH", "baks! may kulang ka, make sure na may meron ka sa lahat", "ok");
        	} else {
                saveProductToDatabase();
        	}
        }
    }
    
    private void setupTextFieldPlaceholder(JTextField textField, String placeholder) {
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                    textField.setFont(new Font("Monserrat", Font.PLAIN, 12));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setFont(new Font("Montserrat", Font.ITALIC, 12));
                    textField.setForeground(new Color(149, 145, 145));
                }
            }
        });
        textField.setForeground(Color.GRAY);
    }
    
    private void setupTextAreaPlaceholder(JTextArea textArea, String placeholder) {
    	textArea.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textArea.getText().equals(placeholder)) {
                	textArea.setText("");
                	textArea.setForeground(Color.BLACK);
                	textArea.setFont(new Font("Monserrat", Font.PLAIN, 12));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textArea.getText().isEmpty()) {
                	textArea.setText(placeholder);
                	textArea.setFont(new Font("Montserrat", Font.ITALIC, 12));
                    textArea.setForeground(new Color(149, 145, 145));
                }
            }
        });
    	textArea.setForeground(Color.GRAY);
    }
    
    private void addMouseListenerToLabel(JLabel lblImage) {
        lblImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	lblImage.setBackground(new Color(0x730C0C));
            	lblImage.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(0x730C0C)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	lblImage.setBackground(new Color(241,241,241,241));
            	lblImage.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(241,241,241,241)));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("JPEG/PNG files", "jpg","jpeg","png")); // Filter for PDFs
                int result = fileChooser.showOpenDialog(lblImage);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile(); // Store the selected file
                    System.out.println("File selected: " + selectedFile.getAbsolutePath());
                    setLabelImage(lblImage, selectedFile);
                } else {
                    System.out.println("No file selected.");
                }
            }
        });
    }
    
    private void setLabelImage(JLabel label, File file) {
        ImageIcon originalIcon = new ImageIcon(file.getAbsolutePath());
        Image scaledImage = originalIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(scaledImage));

        // Store the selected file in the corresponding variable
        if (label == lblAddImage1) {
            imgFile1 = file;
        } else if (label == lblAddImage2) {
            imgFile2 = file;
        } else if (label == lblAddImage3) {
            imgFile3 = file;
        } else if (label == lblAddImage4) {
            imgFile4 = file;
        }
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
    
    private void saveProductToDatabase() {
        String productName = productNameField.getText();
        String productDesc = productDescArea.getText();
        double dblPrice;

        try {
            dblPrice = Double.parseDouble(priceField.getText().replace("P", ""));
            if (dblPrice < 0) throw new NumberFormatException(); // Prevent negative prices
        } catch (NumberFormatException z) {
            // Show OPX error and STOP execution
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            new CustomDialog(parentFrame, 
                    "OPX wrong number!", 
                    "nhak presyo sha,,, invalid input ean aus ausan mo...", 
                    "sorry nhay...");
            return;
        }

        // If we reach here, dblPrice is valid
        String currentSellerUsername = UserSession.getLoggedInUsername();
        String sellerHash = productDatabase.getSellerHashByUsername(currentSellerUsername);

        // Validate seller hash
        if (sellerHash == null) {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            new CustomDialog(parentFrame, 
                    "di ko mahanap seller baks", 
                    "may maling nangyari OMG!", 
                    "awch");
            return; // Prevent further execution
        }

        // Try to save product to database
        try {
        	productDatabase.saveUploadedImageForSeller(currentSellerUsername, imgFile1);
        	productDatabase.saveUploadedImageForSeller(currentSellerUsername, imgFile2);
        	productDatabase.saveUploadedImageForSeller(currentSellerUsername, imgFile3);
        	productDatabase.saveUploadedImageForSeller(currentSellerUsername, imgFile4);
            productDatabase.addProduct(sellerHash, productName, productDesc, dblPrice, "In Stock");

            // Show success dialog ONLY if addProduct() succeeds
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            new CustomDialog(parentFrame, 
                    "Success!", 
                    "yun oh! pasok sa banga ang sissy koh!?", 
                    "true the fire");
        } catch (Exception e) {
            // Show database error dialog if saving fails
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            new CustomDialog(parentFrame, 
                    "Database Error!", 
                    "Product was not saved due to an error!", 
                    "Retry");
        }
    }


    
    private boolean validatePost() {
        StringBuilder strLocations = new StringBuilder();
    	for (JCheckBox cbLocation : cbLocations) {
            if (cbLocation.isSelected()) {
                if (strLocations.length() > 0) {
                    strLocations.append(", ");
                }
                strLocations.append(cbLocation.getText());
            }
        }
    	
    	StringBuilder paymentMethods = new StringBuilder();
        if (cbGCash.isSelected()) {
            if (paymentMethods.length() > 0) {
                paymentMethods.append(", ");
            }
            paymentMethods.append("GCash");
        }
        if (cbCash.isSelected()) {
            if (paymentMethods.length() > 0) {
                paymentMethods.append(", ");
            }
            paymentMethods.append("Cash");
        }
        
    	boolean isLocationSelected = strLocations.length()>0;
    	boolean isPaymentMethodsSelected = paymentMethods.length()>0;
    	
    	boolean boolResult = productNameField.getText().trim().isEmpty() || productDescArea.getText().trim().isEmpty() || 
    			priceField.getText().trim().isEmpty() || meetUpField.getText().trim().isEmpty() || timeField.getText().trim().isEmpty() ||
    			lblAddImage1.getIcon()==null || lblAddImage2.getIcon()==null || lblAddImage3.getIcon()==null || lblAddImage4.getIcon()==null ||
    			categoryCombo.getSelectedIndex()==-1 || !isPaymentMethodsSelected || !isLocationSelected;
    	
    	return boolResult;
    }
    
    private void clearFields() {
        // Reset text fields to their placeholder values
        productNameField.setText("Product Name");
        productNameField.setForeground(Color.GRAY);
        
        productDescArea.setText("Product Description");
        productDescArea.setForeground(Color.GRAY);
        
        priceField.setText("P100");
        priceField.setForeground(Color.GRAY);
        
        productNameField.setText("Product Name");
        productNameField.setForeground(Color.GRAY);
        
        meetUpField.setText("");
        timeField.setText("");
        
        categoryCombo.setSelectedIndex(-1);
        timeCombo.setSelectedIndex(-1);
        
        for (JCheckBox cbLocation : cbLocations) {
            cbLocation.setSelected(false);
        }
        cbGCash.setSelected(false);
        cbCash.setSelected(false);
    }
}