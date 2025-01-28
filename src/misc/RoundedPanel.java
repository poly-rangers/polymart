package misc;

import javax.swing.*;
import java.awt.*;

public class RoundedPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private int cornerRadius; // Corner radius for rounded edges

    // Constructor to set the corner radius and background color
    public RoundedPanel(int cornerRadius, Color backgroundColor) {
        this.cornerRadius = cornerRadius;
        setBackground(backgroundColor); // Set the panel's background color
        setOpaque(false); // Ensure transparency for rounded corners
    }

    // Constructor with default background color
    public RoundedPanel(int cornerRadius) {
        this(cornerRadius, Color.WHITE);
    }

    // Getter and setter for cornerRadius
    public int getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        repaint(); // Trigger repaint for the new corner radius
    }

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