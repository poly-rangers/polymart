package misc;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.MatteBorder;

public class AddActiveOrder extends JPanel {
    public AddActiveOrder(String strDate, String strShop, String strLocation, String strTime, double dbPrice) {
        setLayout(new GridLayout(1, 6)); 
        setBackground(Color.WHITE);
        setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(219, 219, 219))); 

        JLabel lblDate = new JLabel(strDate, SwingConstants.CENTER);
        lblDate.setFont(new Font("Montserrat Medium", Font.PLAIN, 10));
        lblDate.setForeground(Color.BLACK);
        add(lblDate);

        JLabel lblShopName = new JLabel(strShop, SwingConstants.CENTER);
        lblShopName.setFont(new Font("Montserrat Medium", Font.PLAIN, 10));
        lblShopName.setForeground(Color.BLACK);
        add(lblShopName);

        JLabel lblLocation = new JLabel(strLocation, SwingConstants.CENTER);
        lblLocation.setFont(new Font("Montserrat Medium", Font.PLAIN, 10));
        lblLocation.setForeground(Color.BLACK);
        add(lblLocation);

        JLabel lblTime = new JLabel(strTime, SwingConstants.CENTER);
        lblTime.setFont(new Font("Montserrat Medium", Font.PLAIN, 10));
        lblTime.setForeground(Color.BLACK);
        add(lblTime);
        
        String strPrice = String.format("%.2f", dbPrice);

        JLabel lblTotal = new JLabel(strPrice, SwingConstants.CENTER);
        lblTotal.setFont(new Font("Montserrat Medium", Font.PLAIN, 10));
        lblTotal.setForeground(Color.BLACK);
        add(lblTotal);

        JButton btnDetails = new JButton("Details");
        btnDetails.setFont(new Font("Montserrat Medium", Font.PLAIN, 10));
        btnDetails.setBackground(new Color(0x730C0C));
        btnDetails.setForeground(Color.WHITE);
        btnDetails.setFocusPainted(false);
        add(btnDetails);
    }
}
