package frames;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WrongAccountInfo extends JDialog {

	private static final long serialVersionUID = -4926233187959203108L;

	public WrongAccountInfo(JFrame parent) {
        super(parent, "You're WRONG!", true); // value set to true so user can't interact with main frame.
        setUndecorated(true);
        setSize(318, 148);
        setLocationRelativeTo(parent); // Center the dialog relative to parent

        getContentPane().setBackground(new Color(115, 12, 12));
        getContentPane().setLayout(new BorderLayout(0, 0));

        // First panel for the header and content
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(115, 12, 12));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        // Used HTML formatting for underlined and italicized texts
        String headerText = "<html><div style='width: 216px; text-align: center;'>You're WRONG!</div></html>";
        JLabel header = new JLabel(headerText, SwingConstants.CENTER);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Montserrat", Font.BOLD, 19));
        header.setBorder(BorderFactory.createEmptyBorder(25, 19, 0, 19)); // padding 

        String contentText = "<html><div style='width: 216px; text-align: center;'>mali username mo or password mo - ewan ko sau te ulitin mo yan</div></html>";
        JLabel content = new JLabel(contentText, SwingConstants.CENTER);
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
        JButton button = new JButton("Try Again");
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
