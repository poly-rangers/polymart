package misc;

import seller.SellerNavigationBar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import frames.CustomDialog;
import frames.SetMeetUpFrame;
import misc.RoundedButton;

public class ProductDetails extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JButton btnGoBack, btnSubmit, btnViewAll;
	private JLabel lblProductName, lblShopName, lblDescription, lblCategory, lblMOP, lblMOPDesc, lblSocMed, lblSocials,
	lblPrice, lblImage1, lblImage2, lblImage3, lblImage4, lblReviews, lblUsername;
	private RoundedButton btnRating, btnSetAMeet;
	private StatusButton  btnIn;
	private JTextArea reviewArea;
	private JPanel contentPane;
	RoundedPanel reviewPanel, roundedpanel1, roundedpanel2;
	
	public ProductDetails(JPanel contentPane) {
		this.contentPane = contentPane;
		
		setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        setLayout(null);
		
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_buyer.icon.png"));
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

        add(pnlHeader);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(20, 123, 376, 428);
        add(scrollPane);

        JPanel scrollContentPanel = new JPanel();
        scrollContentPanel.setOpaque(true);
        scrollContentPanel.setBackground(Color.WHITE);
        scrollContentPanel.setBorder(null);
        scrollContentPanel.setLayout(null);
        scrollContentPanel.setPreferredSize(new Dimension(350, 625));
        
        ImageIcon image1 = new ImageIcon(this.getClass().getResource("/imageplaceholder.png"));
        lblImage1 = new JLabel(image1);
        lblImage1.setBounds(10,11,145,145);
        scrollContentPanel.add(lblImage1);

        ImageIcon image2 = new ImageIcon(this.getClass().getResource("/imageplaceholdersmall.png"));
        lblImage2 = new JLabel(image2);
        lblImage2.setBounds(10,167,40,40);
        scrollContentPanel.add(lblImage2);
        
        ImageIcon image3 = new ImageIcon(this.getClass().getResource("/imageplaceholdersmall.png"));
        lblImage3 = new JLabel(image3);
        lblImage3.setBounds(63,167,40,40);
        scrollContentPanel.add(lblImage3);
        
        ImageIcon image4 = new ImageIcon(this.getClass().getResource("/imageplaceholdersmall.png"));
        lblImage4 = new JLabel(image4);
        lblImage4.setBounds(115,167,40,40);
        scrollContentPanel.add(lblImage4);
        
        
       lblProductName = new JLabel("Cookies");
       lblProductName.setFont(new Font("Montserrat", Font.BOLD, 24));
       lblProductName.setBounds(165,11,170,30);
       scrollContentPanel.add(lblProductName);
       
       lblShopName = new JLabel("by Cooie");
       lblShopName.setFont(new Font("Montserrat", Font.ITALIC, 12));
       lblShopName.setBounds(165,39,170,15);
       scrollContentPanel.add(lblShopName);
        
       lblDescription = new JLabel("<html>Welcome to Cooie, where passion<br>meets palate in a<br>celebration of coffee and<br>cookie perfection!</html>");
       lblDescription.setFont(new Font("Montserrat", Font.PLAIN, 12));
       lblDescription.setBounds(165,56,170,80);
       scrollContentPanel.add(lblDescription);
       
       btnIn = new StatusButton("Status");
       btnIn.setBackground(new Color(115,12,12));
       btnIn.setForeground(Color.WHITE);
       btnIn.setBorder(null);
//       btnIn.setEnabled(false);
       btnIn.setBounds(165,141,80,15);
       scrollContentPanel.add(btnIn);
       
       lblCategory = new JLabel("Category: Food");
       lblCategory.setFont(new Font("Montserrat", Font.ITALIC, 11));
       lblCategory.setBounds(165,160,119,15);
       scrollContentPanel.add(lblCategory);
       
       lblMOP = new JLabel("Mode of Payment:");
       lblMOP.setForeground(new Color(115, 12, 12));
       lblMOP.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 13));
       lblMOP.setBounds(164,178,145,15);
       scrollContentPanel.add(lblMOP);
       
       lblMOPDesc = new JLabel("Cash/Gcash");
       lblMOPDesc.setFont(new Font("Montserrat", Font.PLAIN, 12));
       lblMOPDesc.setBounds(165,192,145,15);
       scrollContentPanel.add(lblMOPDesc);
       
       lblPrice = new JLabel("P50");
       lblPrice.setFont(new Font("Montserrat", Font.BOLD, 18));
       lblPrice.setForeground(new Color(115, 12, 12));
       lblPrice.setBounds(263,141,72,15);
       lblPrice.setHorizontalAlignment(SwingConstants.RIGHT); 
       scrollContentPanel.add(lblPrice);
       
       lblSocMed = new JLabel("Follow us on Social Media:");
       lblSocMed.setForeground(new Color(115, 12, 12));
       lblSocMed.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 13));
       lblSocMed.setBounds(10,218,185,15);
       scrollContentPanel.add(lblSocMed);
       
       lblSocials = new JLabel("<html>PolyMart Piamonte<br>@polymartpiamonte</html>");
       lblSocials.setFont(new Font("Montserrat", Font.PLAIN, 12));
       lblSocials.setBounds(10,233,229,30);
       scrollContentPanel.add(lblSocials);
       
       btnRating= new RoundedButton("4.8",10);
       btnRating.setBounds(295,20,52,15);
       btnRating.setBackground(new Color(115,12,12));
       btnRating.setForeground(Color.WHITE);
       btnRating.setBorder(null);
       scrollContentPanel.add(btnRating);
       
       lblReviews = new JLabel("Reviews:");
       lblReviews.setFont(new Font("Montserrat", Font.BOLD | Font.ITALIC, 13));
       lblReviews.setBounds(10,274,80,15);
       scrollContentPanel.add(lblReviews);
       
       RoundedPanel reviewPanel = new RoundedPanel(20, new Color(217,217,217));
       reviewPanel.setBounds(10,292, 337,49);
       reviewPanel.setLayout(null);
       
       ImageIcon profileImage = new ImageIcon(this.getClass().getResource("/profileiconGRAY.png"));
       JLabel profileIcon = new JLabel(profileImage);
       profileIcon.setBounds(10, 12, 24, 24);
       reviewPanel.add(profileIcon);
       
       reviewArea = new JTextArea(25,25);
       reviewArea.setBounds(44,23, 261, 15);
       reviewArea.setText("ge mambash ka na nak.");
       reviewArea.setBackground(new Color(217,217,217));
       reviewArea.setForeground(new Color(149,145,145));
       reviewArea.setFont(new Font("Montserrat", Font.ITALIC, 10));
       reviewPanel.add(reviewArea);
       
       lblUsername = new JLabel("@username");
       lblUsername.setFont(new Font("Montserrat", Font.ITALIC, 11));
       lblUsername.setBounds(44,8, 261, 15);
       reviewPanel.add(lblUsername);
       
       ImageIcon reviewArrow = new ImageIcon(this.getClass().getResource("/arrowreview.png"));
       
       btnSubmit = new JButton();
       btnSubmit.setBackground(new Color(217,217,217));
       btnSubmit.setFocusPainted(false);
       btnSubmit.setFocusable(false);
       btnSubmit.setIcon(reviewArrow);
       btnSubmit.setBorder(null);
       btnSubmit.setOpaque(true);
       btnSubmit.setBounds(303, 12, 24, 24);
       reviewPanel.add(btnSubmit);
       
       ReviewPanel panel1 = new ReviewPanel(20, new Color(217,217,217), "beWhoYouAre", "Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur");
       panel1.setBounds(10,345, 337,80);
       
       ReviewPanel panel2 = new ReviewPanel(20, new Color(217,217,217), "backburnerngbayan","when every bite starts to taste like: hindi ko ‘yon deserve eh...");
       panel2.setBounds(10,429, 337,64);
       
       ReviewPanel panel3 = new ReviewPanel(20, new Color(217,217,217), "SOLNO1DIONELAFAN","Hotshot running in mind nonstop, vertigo \nCurled plot, whiskey in a teapot, ethanol\nBurning like KELT-9b, bright heavenly body\nOnly music can define you, and it sounds like-, uh");
       panel3.setBounds(10,497, 337,89);
              
       btnSetAMeet = new RoundedButton("Set a meet-up", 25);
       btnSetAMeet.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 16));
       btnSetAMeet.setBounds(106,562,192,37);
       btnSetAMeet.setBackground(new Color(115,12,12));
       btnSetAMeet.setForeground(Color.WHITE);
       btnSetAMeet.addActionListener(this);
       
       btnViewAll = new JButton("<html><u>View All</u></html>");
       btnViewAll.setBackground(Color.WHITE);
       btnViewAll.setFont(new Font("Montserrat", Font.ITALIC, 10));
       btnViewAll.setFocusable(false);
       btnViewAll.setFocusPainted(false);
       btnViewAll.setBorderPainted(false);
       btnViewAll.setContentAreaFilled(false);
       
       btnViewAll.setBounds(139,592,85,23);
       
       
       scrollContentPanel.add(reviewPanel);
       scrollContentPanel.add(panel1);
       scrollContentPanel.add(panel2);
       scrollContentPanel.add(panel3);
       scrollContentPanel.add(btnViewAll);
       add(btnSetAMeet);
     
       
        
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
            clLayout.show(contentPane, "BuyerDashboardPanel");
    	} else if(objSourceEvent == btnSetAMeet) {
    		SetMeetUpFrame meetUpFrame = new SetMeetUpFrame();
            meetUpFrame.setVisible(true);
    	}
	}
}