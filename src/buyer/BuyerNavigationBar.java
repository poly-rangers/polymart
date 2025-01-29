package buyer;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class BuyerNavigationBar extends JPanel implements ActionListener {

    private static final long serialVersionUID = 2021409567929036389L;
    private JButton btnHome, btnMap, btnOrders, btnProfile;
    private JPanel contentPane;

    public BuyerNavigationBar(JPanel contentPane) {
        // Assign contentPane to the instance variable
        this.contentPane = contentPane;

        setSize(430, 72);
        setBackground(new Color(102, 0, 0));
        setBorder(new EmptyBorder(0, 5, 0, 5));

        // Initialize and style buttons
        btnHome = createNavButton("Home", "/homeicon.png");
        btnMap = createNavButton("Map", "/mapicon.png");
        btnOrders = createNavButton("Orders", "/receipticon.png");
        btnProfile = createNavButton("Profile", "/profileicon.png");

        setLayout(new GridLayout(0, 4, 0, 0));

        // Add buttons to the panel
        add(btnHome);
        add(btnMap);
        add(btnOrders);
        add(btnProfile);
    }

    private JButton createNavButton(String text, String iconPath) {
        JButton button = new JButton(text);
        button.addActionListener(this);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(102, 0, 0));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Montserrat", Font.PLAIN, 10));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);

        // Set icon
        ImageIcon icon = new ImageIcon(this.getClass().getResource(iconPath));
        button.setIcon(icon);
        button.setIconTextGap(0);

        return button;
    }

    @Override
    public void actionPerformed(ActionEvent actEvent) {
        Object objSourceEvent = actEvent.getSource();

        // Navigate based on which button was clicked
        if (objSourceEvent == btnHome) {
            navigateTo("BuyerDashboardPanel");
        } else if (objSourceEvent == btnMap) {
            navigateTo("Map");
        } else if (objSourceEvent == btnOrders) {
            navigateTo("BuyerOrderPanel");
        } else if (objSourceEvent == btnProfile) {
            navigateTo("Profile");
        }
    }

    private void navigateTo(String cardName) {
        if (contentPane.getLayout() instanceof CardLayout) {
            CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, cardName);
        } else {
            System.err.println("Error: contentPane is not using CardLayout!");
        }
    }
}