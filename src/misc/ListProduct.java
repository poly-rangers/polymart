package misc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ListProduct {

    public JPanel createRow(String itemName, String ratingValue, ActionListener viewAction) {
        JPanel row = new JPanel();
        row.setBackground(Color.WHITE);
        row.setMaximumSize(new Dimension(388, 20)); // Set fixed height for each row
        row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));

        // Item Label
        JLabel itemLabel = new JLabel(itemName);
        itemLabel.setFont(new Font("Montserrat Medium", Font.PLAIN, 10));
        itemLabel.setMaximumSize(new Dimension(95, 20));
        row.add(itemLabel);

        // Horizontal Strut for Spacing
        row.add(Box.createHorizontalStrut(30));

        // Rating Label
        JLabel ratingLabel = new JLabel(ratingValue);
        ratingLabel.setFont(new Font("Montserrat Medium", Font.PLAIN, 10));
        ratingLabel.setMaximumSize(new Dimension(20, 20));
        row.add(ratingLabel);

        // Another Strut for Spacing
        row.add(Box.createHorizontalStrut(55));

        // "View" Button
        RoundedButton btnView = new RoundedButton("View", 20);
        btnView.setFont(new Font("Montserrat", Font.BOLD, 8));
        btnView.setForeground(Color.WHITE);
        btnView.setBackground(new Color(115, 12, 12));
        btnView.setPreferredSize(new Dimension(30, 10));
        btnView.setFocusable(false);
        btnView.setFocusPainted(false);
        btnView.setBorderPainted(false);
        btnView.addActionListener(viewAction); // Attach action listener
        row.add(btnView);

        // Another Strut for Spacing
        row.add(Box.createHorizontalStrut(37));

        // "Status" Button
        StatusButton status = new StatusButton("Status");
        status.setMaximumSize(new Dimension(75, 17));
        row.add(status);

        return row;
    }
}