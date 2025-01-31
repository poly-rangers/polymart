import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import misc.CustomScrollBar;
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
		setLayout(null);  // Set layout to null

		// Choose image based on userRole
		String strImagePath = userRole.equalsIgnoreCase("Buyer")
		        ? "/polypup_buyer.icon.png"
		        : "/polypup_seller.icon.png";

		// Icon next to header title
		ImageIcon imgIconOriginalImage = new ImageIcon(this.getClass().getResource(strImagePath));
		Image imgScaled = imgIconOriginalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
		JLabel lblStartupImage = new JLabel(new ImageIcon(imgScaled));
		lblStartupImage.setBounds(16, 24, 150, 47);  // Set bounds manually
		add(lblStartupImage);

		// Terms & Conditions label
		JLabel lblTermsHeader = new JLabel("Terms & Conditions");
		lblTermsHeader.setBounds(0, 119, 414, 24);  // Set bounds manually
		lblTermsHeader.setForeground(Color.BLACK);
		lblTermsHeader.setFont(new Font("Montserrat", Font.BOLD, 24));
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
		JLabel lblImportContent = new JLabel("<html><div style='width:260px; text-align: justify; line-height: 2;'>"
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
		scrollPane.getVerticalScrollBar().setUI(new CustomScrollBar());
		scrollPane.setOpaque(true);
		scrollPane.setBorder(null);

		// Set bounds for the scroll pane
		scrollPane.setBounds(19, 159, 375, 407);  // Set bounds manually
		add(scrollPane);

		// Create the "I Agree" button
		JButton btnAgreeButton = new RoundedButton("I agree", 30);
		btnAgreeButton.setBounds(145, 590, 124, 40);  // Set bounds manually
		btnAgreeButton.setFont(new Font("Montserrat", Font.BOLD, 16));
		btnAgreeButton.setBackground(new Color(115, 12, 12));
		btnAgreeButton.setForeground(Color.WHITE);
		btnAgreeButton.setFocusPainted(false);
		btnAgreeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
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
