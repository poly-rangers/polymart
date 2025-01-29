import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import misc.RoundedButton;

public class TermsConditionsPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String userRole;
	
	public TermsConditionsPanel(JPanel contentPane, String userRole) {
		this.contentPane = contentPane;
		this.userRole = userRole;
		
		setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        SpringLayout pnlTermsConditions = new SpringLayout();
        setLayout(pnlTermsConditions);
        
        // Choose image based on userRole
        String strImagePath = userRole.equalsIgnoreCase("Buyer")
                ? "/polypup_buyer.icon.png"
                : "/polypup_seller.icon.png";
        
        
        
        // Icon next to header title
        ImageIcon imgIconOriginalImage = new ImageIcon(this.getClass().getResource(strImagePath));
        Image imgScaled = imgIconOriginalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
        JLabel lblStartupImage = new JLabel(new ImageIcon(imgScaled));
        pnlTermsConditions.putConstraint(SpringLayout.NORTH, lblStartupImage, 24, SpringLayout.NORTH, this);
        pnlTermsConditions.putConstraint(SpringLayout.WEST, lblStartupImage, 16, SpringLayout.WEST, this);
        add(lblStartupImage);
        
        

        // Terms & Conditions label
        JLabel lblTermsHeader = new JLabel("Terms & Conditions");
        pnlTermsConditions.putConstraint(SpringLayout.WEST, lblTermsHeader, 0, SpringLayout.WEST, this);
        pnlTermsConditions.putConstraint(SpringLayout.EAST, lblTermsHeader, 414, SpringLayout.WEST, this);
        pnlTermsConditions.putConstraint(SpringLayout.NORTH, lblTermsHeader, 119, SpringLayout.NORTH, this);
        lblTermsHeader.setForeground(Color.BLACK);
        lblTermsHeader.setFont(new Font("Montserrat Medium", Font.PLAIN, 24));
        lblTermsHeader.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblTermsHeader);
        
        // Load text content from a file
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader readFile = new BufferedReader(new FileReader("resources/terms_and_conditions.txt"))) {
            String strLine;
            while ((strLine = readFile.readLine()) != null) {
                contentBuilder.append(strLine).append(System.lineSeparator());
            }
        } catch (IOException ioException) {
        	ioException.printStackTrace();
        }
        JLabel lblImportContent = new JLabel("<html><div style='width:260px; text-align: justify; strLine-height: 2;'>"
                + contentBuilder.toString() + "</div></html>");
        
        lblImportContent.setFont(new Font("Montserrat", Font.PLAIN, 16));
        lblImportContent.setVerticalAlignment(SwingConstants.TOP);
        lblImportContent.setOpaque(true);
        lblImportContent.setBackground(Color.WHITE);
        lblImportContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));

        // Wrap the JLabel in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(lblImportContent);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(true);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        // Set constraints for the scroll pane
        pnlTermsConditions.putConstraint(SpringLayout.NORTH, scrollPane, 16, SpringLayout.SOUTH, lblTermsHeader);
        pnlTermsConditions.putConstraint(SpringLayout.WEST, scrollPane, 19, SpringLayout.WEST, this);
        pnlTermsConditions.putConstraint(SpringLayout.SOUTH, scrollPane, -100, SpringLayout.SOUTH, this); // Adjusted for button
        pnlTermsConditions.putConstraint(SpringLayout.EAST, scrollPane, -22, SpringLayout.EAST, this);
        add(scrollPane);

        // Create the "I Agree" button
        JButton btnAgreeButton = new RoundedButton("I Agree", 30);
        btnAgreeButton.setFont(new Font("Montserrat", Font.BOLD, 16));
        btnAgreeButton.setBackground(new Color(128, 0, 0));
        btnAgreeButton.setForeground(Color.WHITE);
        btnAgreeButton.setFocusPainted(false);
        btnAgreeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        pnlTermsConditions.putConstraint(SpringLayout.NORTH, btnAgreeButton, 10, SpringLayout.SOUTH, scrollPane);
        pnlTermsConditions.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnAgreeButton, 0, SpringLayout.HORIZONTAL_CENTER, this);
        btnAgreeButton.addActionListener(this);
        add(btnAgreeButton);
	}

	@Override
	public void actionPerformed(ActionEvent actEvent) {
        CardLayout clLayout = (CardLayout) contentPane.getLayout();

        if ("Buyer".equalsIgnoreCase(userRole)) {
            clLayout.show(contentPane, "BuyerSignupPanel");
        } else if ("Seller".equalsIgnoreCase(userRole)) {
            clLayout.show(contentPane, "SellerSignupPanel");
        }
	}
}
