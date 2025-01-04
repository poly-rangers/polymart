import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TermsConditionsPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public TermsConditionsPanel(JPanel contentPane) {
		this.contentPane = contentPane;
		
		setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        SpringLayout panelLayout = new SpringLayout();
        setLayout(panelLayout);
        
        // Header title
        JLabel headerTitle = new JLabel("POLYMART");
        panelLayout.putConstraint(SpringLayout.NORTH, headerTitle, 49, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, headerTitle, 10, SpringLayout.NORTH, this);
        headerTitle.setForeground(new Color(0x730C0C));
        headerTitle.setFont(new Font("Montserrat ExtraBold", Font.PLAIN, 15));
        add(headerTitle);

        // Icon next to header title
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_icon.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        panelLayout.putConstraint(SpringLayout.WEST, headerTitle, 2, SpringLayout.EAST, startupImage);
        panelLayout.putConstraint(SpringLayout.NORTH, startupImage, 38, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.EAST, startupImage, -355, SpringLayout.EAST, this);
        add(startupImage);

        // Terms & Conditions label
        JLabel signUpLabel = new JLabel("Terms & Conditions");
        panelLayout.putConstraint(SpringLayout.WEST, signUpLabel, 0, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, signUpLabel, 414, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, headerTitle, -49, SpringLayout.NORTH, signUpLabel);
        panelLayout.putConstraint(SpringLayout.NORTH, signUpLabel, 119, SpringLayout.NORTH, this);
        signUpLabel.setForeground(Color.BLACK);
        signUpLabel.setFont(new Font("Montserrat Medium", Font.PLAIN, 24));
        signUpLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(signUpLabel);
        
        // Create a JLabel for the text content with HTML formatting
        JLabel contentLabel = new JLabel("<html><div style='width:260px; text-align: justify; line-height: 2;'>"
                + "<b>Polymart: Terms</b><br><br>"
                + "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium "
                + "doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore "
                + "veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam "
                + "voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur "
                + "magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, "
                + "qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non "
                + "numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat "
                + "voluptatem. <br><br>Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis "
                + "suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum "
                + "iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, "
                + "vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?\""
                + "</div></html>");
        
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
        JButton agreeButton = new JButton("I Agree");
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
        clLayout.show(contentPane, "SignupPanel");
	}
}
