package buyer;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class BuyerNavigationBar extends JPanel {

    private static final long serialVersionUID = 2021409567929036389L;
    public JButton btnHome, btnMap, btnOrders, btnProfile;
    private JPanel contentPane;

    public BuyerNavigationBar(JPanel contentPane) {
        this.contentPane = contentPane;

        setPreferredSize(new Dimension(430, 72));
        setBackground(new Color(102, 0, 0));
        setBorder(new EmptyBorder(0, 5, 0, 5));

        btnHome = createNavButton("Home", "/homeicon.png");
        btnMap = createNavButton("Map", "/mapicon.png");
        btnOrders = createNavButton("Orders", "/receipticon.png");
        btnProfile = createNavButton("Profile", "/profileicon.png");

        setLayout(new GridLayout(0, 4, 0, 0));

        add(btnHome);
        add(btnMap);
        add(btnOrders);
        add(btnProfile);
    }

    private JButton createNavButton(String text, String iconPath) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(102, 0, 0));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Montserrat", Font.PLAIN, 10));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);

        ImageIcon icon = new ImageIcon(this.getClass().getResource(iconPath));
        button.setIcon(icon);
        button.setIconTextGap(0);

        return button;
    }
}
