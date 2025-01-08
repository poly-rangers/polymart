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
        
        // Icon next to header title
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_icon.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        panelLayout.putConstraint(SpringLayout.NORTH, startupImage, 24, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, startupImage, 16, SpringLayout.WEST, this);
        add(startupImage);

        // Terms & Conditions label
        JLabel signUpLabel = new JLabel("Terms & Conditions");
        panelLayout.putConstraint(SpringLayout.WEST, signUpLabel, 0, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, signUpLabel, 414, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.NORTH, signUpLabel, 119, SpringLayout.NORTH, this);
        signUpLabel.setForeground(Color.BLACK);
        signUpLabel.setFont(new Font("Montserrat Medium", Font.PLAIN, 24));
        signUpLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(signUpLabel);
        
        // Load text content from a file
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("resources/terms_and_conditions.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel contentLabel = new JLabel("<html><div style='width:260px; text-align: justify; line-height: 2;'>"
                + contentBuilder.toString() + "</div></html>");
        
        contentLabel.setFont(new Font("Montserrat", Font.PLAIN, 16));
        contentLabel.setVerticalAlignment(SwingConstants.TOP);
        contentLabel.setOpaque(true);
        contentLabel.setBackground(Color.WHITE);
        contentLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));

        // Wrap the JLabel in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(contentLabel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(true);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        // Set constraints for the scroll pane
        panelLayout.putConstraint(SpringLayout.NORTH, scrollPane, 16, SpringLayout.SOUTH, signUpLabel);
        panelLayout.putConstraint(SpringLayout.WEST, scrollPane, 19, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -100, SpringLayout.SOUTH, this); // Adjusted for button
        panelLayout.putConstraint(SpringLayout.EAST, scrollPane, -22, SpringLayout.EAST, this);
        add(scrollPane);

        // Create the "I Agree" button
        JButton agreeButton = new RoundButton("I Agree", 30);
        agreeButton.setFont(new Font("Montserrat", Font.BOLD, 16));
        agreeButton.setBackground(new Color(128, 0, 0));
        agreeButton.setForeground(Color.WHITE);
        agreeButton.setFocusPainted(false);
        agreeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panelLayout.putConstraint(SpringLayout.NORTH, agreeButton, 10, SpringLayout.SOUTH, scrollPane);
        panelLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, agreeButton, 0, SpringLayout.HORIZONTAL_CENTER, this);
        agreeButton.addActionListener(this);
        add(agreeButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        CardLayout clLayout = (CardLayout) contentPane.getLayout();

        if ("Buyer".equalsIgnoreCase(userRole)) {
            clLayout.show(contentPane, "BuyerSignupPanel");
        } else if ("Seller".equalsIgnoreCase(userRole)) {
            clLayout.show(contentPane, "SellerSignupPanel");
        }
	}
}
