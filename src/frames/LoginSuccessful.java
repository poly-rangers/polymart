package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class LoginSuccessful extends JDialog {

	private static final long serialVersionUID = 1L;

	public LoginSuccessful(JFrame parent) {
		super(parent, "log-in successful!", true); // value set to true so user can't interact with main frame.
        setUndecorated(true);
        setSize(318, 168);
        setLocationRelativeTo(parent); // Center the dialog relative to parent

        getContentPane().setBackground(new Color(115, 12, 12));
        getContentPane().setLayout(new BorderLayout(0, 0));

        // First panel for the header and content
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(115, 12, 12));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        JLabel header = new JLabel("<html><div style='width: 216px; text-align: center;'>log-in successful!</div></html>", SwingConstants.CENTER);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Montserrat", Font.BOLD, 19));
        header.setBorder(BorderFactory.createEmptyBorder(25, 19, 0, 19)); // padding 

        JLabel content = new JLabel("<html><div style='width: 216px; text-align: center;'>welcome to the fam, baks! glad to see you here on Polymart! feel free to scroll and explore our dashboard ^____^</div></html>", SwingConstants.CENTER);
        content.setForeground(Color.WHITE);
        content.setFont(new Font("Montserrat", Font.PLAIN, 14));
        content.setBorder(BorderFactory.createEmptyBorder(13, 19, 10, 19)); // padding

        panel.add(header);
        panel.add(content);

        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.HORIZONTAL);
        separator.setBackground(Color.WHITE);
        separator.setPreferredSize(new Dimension(318, 1));

        // Panel for button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(115, 12, 12));

        // "okay, gets!" Button
        JButton button = new JButton("Proceed");
        button.setBackground(new Color(115, 12, 12));
        button.setFont(new Font("Montserrat", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Closes popup when button is pressed
            }
        });

        buttonPanel.add(button);

        // Add both panels and the separator to the dialog
        getContentPane().add(panel, BorderLayout.NORTH); // First panel at the top
        getContentPane().add(separator, BorderLayout.CENTER); // Add the separator divider
        getContentPane().add(buttonPanel, BorderLayout.SOUTH); // Button panel at the bottom

        setVisible(true);
	}
}
