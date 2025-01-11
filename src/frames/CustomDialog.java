package frames;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomDialog extends JDialog {
   
	private static final long serialVersionUID = 3165285528614856510L;

	public CustomDialog(JFrame parent, String strHeaderText, String strContentText, String strButtonText){
    	super(parent, "Why do I need this?", true); // value set to true so user can't interact with main frame.
      	setUndecorated(true);
             
        getContentPane().setBackground(new Color(115, 12, 12));
        getContentPane().setLayout(new BorderLayout(0, 0)); // Set horizontal and vertical gaps to 0
        
        // First panel for the header and content
        JPanel pnlMainPanel = new JPanel();
        pnlMainPanel.setLayout(new BoxLayout(pnlMainPanel, BoxLayout.Y_AXIS));
        pnlMainPanel.setBackground(new Color(115, 12, 12));
        pnlMainPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // No border (padding) around the panel

        JLabel lblHeader = new JLabel("<html><div style='width: 216px; text-align: center;'>" + strHeaderText + "</div></html>", SwingConstants.CENTER);
        lblHeader.setForeground(Color.WHITE);
        lblHeader.setFont(new Font("Montserrat", Font.BOLD, 19));
        lblHeader.setBorder(BorderFactory.createEmptyBorder(25, 19, 0, 19));

        JLabel lblContent = new JLabel("<html><div style='width: 216px; text-align: center;'>" + strContentText + "</div></html>", SwingConstants.CENTER);
        lblContent.setForeground(Color.WHITE);
        lblContent.setFont(new Font("Montserrat", Font.PLAIN, 14));
        lblContent.setBorder(BorderFactory.createEmptyBorder(13, 19, 10, 19));

        // Add header and content to the first panel
        pnlMainPanel.add(lblHeader);
        pnlMainPanel.add(lblContent);
        
        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.HORIZONTAL); // Set to horizontal divider
        separator.setBackground(Color.WHITE); // Divider color (white)
        separator.setPreferredSize(new Dimension(getWidth(), 2)); // Set divider thickness
        
        // Button panel
        JPanel pnlButton = new JPanel();
        pnlButton.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center the button within the panel
        pnlButton.setBackground(new Color(115, 12, 12)); // Set the buttonPanel's background to match the frame color

        // Transparent button
        JButton button = new JButton(strButtonText);
        button.setBackground(new Color(115, 12, 12));
        button.setFont(new Font("Montserrat", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);

        // Add ActionListener to the button to close the frame
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the popup dialog
            }
        });

        // Add the button to the button panel
        pnlButton.add(button);

        // Add both panels and the separator to the frame
        getContentPane().add(pnlMainPanel, BorderLayout.NORTH); // First panel at the top
        getContentPane().add(separator, BorderLayout.CENTER); // Add the separator divider
        getContentPane().add(pnlButton, BorderLayout.SOUTH); // Button panel at the bottom
        
        pack();
        setLocationRelativeTo(parent);
        setVisible(true);

       
    }
}