package frames;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import misc.RoundedButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Logout extends JFrame {

    private static final long serialVersionUID = 6410724970529248217L;
    private int cornerRadius = 30;
    
    public Logout() {
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));  // Transparent background for smooth corners
        setSize(370, 188);
        getContentPane().setLayout(null);

        JPanel pnlMain = new JPanel();
        pnlMain.setLayout(null);
        pnlMain.setBackground(new Color(115, 12, 12));
        pnlMain.setBounds(0, 0, getWidth(), getHeight());
        getContentPane().add(pnlMain);

        ImageIcon alertPic = new ImageIcon(this.getClass().getResource("/alerttriangle.png"));
        JLabel pic = new JLabel(alertPic);
        pic.setBounds(33, 35, 35, 24);
        pnlMain.add(pic);

        JLabel lblHeader1 = new JLabel("Log-out of Polymart");
        lblHeader1.setHorizontalAlignment(SwingConstants.LEFT);
        lblHeader1.setForeground(Color.WHITE);
        lblHeader1.setFont(new Font("Montserrat", Font.BOLD, 14));
        lblHeader1.setBounds(35, 63, 298, 20);
        pnlMain.add(lblHeader1);
        
        JLabel lblHeader2 = new JLabel("<html>Are you sure you would like to log out of your PolyMart account?</html>");
        lblHeader2.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeader2.setForeground(Color.WHITE);
        lblHeader2.setFont(new Font("Montserrat", Font.ITALIC, 12));
        lblHeader2.setBounds(35, 82, 298, 32);
        pnlMain.add(lblHeader2);

        RoundedButton btnConfirm = new RoundedButton("Cancel", 10);
        btnConfirm.setBounds(36, 130, 135, 32);
        btnConfirm.setForeground(new Color(115, 12, 12));
        btnConfirm.setBackground(Color.WHITE);
        btnConfirm.setFont(new Font("Montserrat", Font.BOLD, 12));
        btnConfirm.addActionListener(e -> {
            dispose();
        });
        pnlMain.add(btnConfirm);

        RoundedButton btnGoBack = new RoundedButton("Confirm", 10);
        btnGoBack.setBounds(198, 130, 135, 32);
        btnGoBack.setForeground(new Color(115, 12, 12));
        btnGoBack.setBackground(Color.WHITE);
        btnGoBack.setFont(new Font("Montserrat", Font.BOLD, 12));
        btnGoBack.addActionListener(e -> {
            dispose();
        });
        pnlMain.add(btnGoBack);

        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Float(0, 0, getBounds().width, getBounds().height, cornerRadius, cornerRadius));
        setVisible(true);
    }
}
