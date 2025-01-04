import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class SignInPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public SignInPanel(JPanel contentPane) {
		this.contentPane = contentPane;
		
		setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        SpringLayout layout = new SpringLayout();
        setLayout(layout);
        
        JLabel lblNewLabel = new JLabel("New label");
        layout.putConstraint(SpringLayout.NORTH, lblNewLabel, 265, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, lblNewLabel, 163, SpringLayout.WEST, this);
        add(lblNewLabel);
        
        // Create the "I Agree" button
        JButton agreeButton = new JButton("I Agree");
        agreeButton.setFont(new Font("Montserrat", Font.BOLD, 16));
        agreeButton.setBackground(new Color(128, 0, 0));
        agreeButton.setForeground(Color.WHITE);
        agreeButton.setFocusPainted(false);
        agreeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        agreeButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Switch to SignupPanel
        CardLayout clLayout = (CardLayout) contentPane.getLayout();
        clLayout.show(contentPane, "SignupPanel");
	}

}
