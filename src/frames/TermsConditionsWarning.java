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

public class TermsConditionsWarning extends JDialog {

	private static final long serialVersionUID = 1L;

	public TermsConditionsWarning(JFrame parent) {
		super(parent, "check the label ateh!", true); // value set to true so user can't interact with main frame.
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

        JLabel header = new JLabel("<html><div style='width: 216px; text-align: center;'>check the label ateh!</div></html>", SwingConstants.CENTER);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Montserrat", Font.BOLD, 19));
        header.setBorder(BorderFactory.createEmptyBorder(25, 19, 0, 19)); // padding 

        JLabel content = new JLabel("<html><div style='width: 216px; text-align: center;'>ano nhak?! aus ausin mo naman pagdedesisyon mo! i-check mo muna ang Terms and Conditions!</div></html>", SwingConstants.CENTER);
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
        JButton btnGoBack = new JButton("Go Back");
        btnGoBack.setBackground(new Color(115, 12, 12));
        btnGoBack.setFont(new Font("Montserrat", Font.BOLD, 14));
        btnGoBack.setForeground(Color.WHITE);
        btnGoBack.setFocusPainted(false);
        btnGoBack.setBorderPainted(false);

        btnGoBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Closes popup when button is pressed
            }
        });

        buttonPanel.add(btnGoBack);

        // Add both panels and the separator to the dialog
        getContentPane().add(panel, BorderLayout.NORTH); // First panel at the top
        getContentPane().add(separator, BorderLayout.CENTER); // Add the separator divider
        getContentPane().add(buttonPanel, BorderLayout.SOUTH); // Button panel at the bottom

        setVisible(true);
	}
}
