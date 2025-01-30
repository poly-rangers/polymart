package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class CustomDialog extends JDialog {

    private static final long serialVersionUID = 3165285528614856510L;
    private int cornerRadius = 45;  // Increased corner radius for smoother curves

    public CustomDialog(JFrame parentFrame, String strHeaderText, String strContentText, String strButtonText) {
        super(parentFrame, "Why do I need this?", true); // value set to true so user can't interact with main frame.
        setUndecorated(true); // Remove default dialog decorations

        // Set the content pane layout
        getContentPane().setLayout(new BorderLayout(0, 0));

        // Rounded panel for the header and content
        RoundedPanel pnlMainPanel = new RoundedPanel();
        pnlMainPanel.setLayout(new BoxLayout(pnlMainPanel, BoxLayout.Y_AXIS));
        pnlMainPanel.setBackground(new Color(115, 12, 12)); // Match the background color
        pnlMainPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // No border (padding) around the panel

        JLabel lblHeader = new JLabel("<html><div style='width: 216px; text-align: center;'>" + strHeaderText + "</div></html>", SwingConstants.CENTER);
        lblHeader.setForeground(Color.WHITE);
        lblHeader.setFont(new Font("Montserrat", Font.BOLD, 19));
        lblHeader.setBorder(BorderFactory.createEmptyBorder(25, 19, 0, 19));

        JLabel lblContent = new JLabel("<html><div style='width: 216px; text-align: center;'>" + strContentText + "</div></html>", SwingConstants.CENTER);
        lblContent.setForeground(Color.WHITE);
        lblContent.setFont(new Font("Montserrat", Font.PLAIN, 14));
        lblContent.setBorder(BorderFactory.createEmptyBorder(13, 19, 10, 19));

        // Add header and content to the main panel
        pnlMainPanel.add(lblHeader);
        pnlMainPanel.add(lblContent);

        JSeparator separatorPanelDivider = new JSeparator();
        separatorPanelDivider.setOrientation(SwingConstants.HORIZONTAL); // Set to horizontal divider
        separatorPanelDivider.setBackground(Color.WHITE); // Divider color (white)
        separatorPanelDivider.setPreferredSize(new Dimension(getWidth(), 2)); // Set divider thickness

        // Button panel
        JPanel pnlButton = new JPanel();
        pnlButton.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center the button within the panel
        pnlButton.setBackground(new Color(115, 12, 12)); // Set the button panel's background

        JButton btnContainer = new JButton(strButtonText);
        btnContainer.setBackground(new Color(115, 12, 12));
        btnContainer.setFont(new Font("Montserrat", Font.BOLD, 14));
        btnContainer.setForeground(Color.WHITE);
        btnContainer.setFocusPainted(false);
        btnContainer.setBorderPainted(false);
        btnContainer.setContentAreaFilled(false);

        // Add ActionListener to the button to close the dialog
        btnContainer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current dialog
            }
        });

        // Add the button to the button panel
        pnlButton.add(btnContainer);

        // Add both panels and the separator to the frame
        getContentPane().add(pnlMainPanel, BorderLayout.NORTH); // Main panel at the top
        getContentPane().add(separatorPanelDivider, BorderLayout.CENTER); // Separator
        getContentPane().add(pnlButton, BorderLayout.SOUTH); // Button panel at the bottom

        pack();
        setLocationRelativeTo(parentFrame);
        setShape(new RoundRectangle2D.Float(0, 0, getBounds().width, getBounds().height, cornerRadius, cornerRadius));
        setVisible(true);
    }

    // Custom panel class for rounded corners
    private class RoundedPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		@Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            // Enable antialiasing for smoother curves
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        }
    }
}
