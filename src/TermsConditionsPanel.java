import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import misc.RoundButton;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TermsConditionsPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String userRole;
	
	public TermsConditionsPanel(JPanel contentPane, String userRole) {
		this.contentPane = contentPane;
		this.userRole = userRole;
		
		setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        SpringLayout panelLayout = new SpringLayout();
        setLayout(panelLayout);
        
        // Choose image based on userRole
        String strImagePath = userRole.equalsIgnoreCase("Buyer")
                ? "/polypup_buyer.icon.png"
                : "/polypup_seller.icon.png";
        
        // Icon next to header title
        ImageIcon imgIconOriginalImage = new ImageIcon(this.getClass().getResource(strImagePath));
        Image imgScaled = imgIconOriginalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
        JLabel lblStartupImage = new JLabel(new ImageIcon(imgScaled));
        panelLayout.putConstraint(SpringLayout.NORTH, lblStartupImage, 24, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, lblStartupImage, 16, SpringLayout.WEST, this);
        add(lblStartupImage);

        // Terms & Conditions label
        JLabel lblsignUp = new JLabel("Terms & Conditions");
        panelLayout.putConstraint(SpringLayout.WEST, lblsignUp, 0, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, lblsignUp, 414, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.NORTH, lblsignUp, 119, SpringLayout.NORTH, this);
        lblsignUp.setForeground(Color.BLACK);
        lblsignUp.setFont(new Font("Montserrat Medium", Font.PLAIN, 24));
        lblsignUp.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblsignUp);
        
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
        panelLayout.putConstraint(SpringLayout.NORTH, scrollPane, 16, SpringLayout.SOUTH, lblsignUp);
        panelLayout.putConstraint(SpringLayout.WEST, scrollPane, 19, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -100, SpringLayout.SOUTH, this); // Adjusted for button
        panelLayout.putConstraint(SpringLayout.EAST, scrollPane, -22, SpringLayout.EAST, this);
        add(scrollPane);

        // Create the "I Agree" button
        JButton bttnAgreeButton = new RoundButton("I Agree", 30);
        bttnAgreeButton.setFont(new Font("Montserrat", Font.BOLD, 16));
        bttnAgreeButton.setBackground(new Color(128, 0, 0));
        bttnAgreeButton.setForeground(Color.WHITE);
        bttnAgreeButton.setFocusPainted(false);
        bttnAgreeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panelLayout.putConstraint(SpringLayout.NORTH, bttnAgreeButton, 10, SpringLayout.SOUTH, scrollPane);
        panelLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, bttnAgreeButton, 0, SpringLayout.HORIZONTAL_CENTER, this);
        bttnAgreeButton.addActionListener(this);
        add(bttnAgreeButton);
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
