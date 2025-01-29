package frames;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import misc.RoundedButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CompleteConfirmation extends JFrame {

    private static final long serialVersionUID = 6410724970529248217L;
    private int cornerRadius = 30;
    
    public CompleteConfirmation() {
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));  // Transparent background for smooth corners
        setSize(370, 100);
        getContentPane().setLayout(null);

        JPanel pnlMain = new JPanel();
        pnlMain.setLayout(null);
        pnlMain.setBackground(new Color(115, 12, 12));
        pnlMain.setBounds(0, 0, getWidth(), getHeight());
        getContentPane().add(pnlMain);
        
        JLabel lblHeader1 = new JLabel("weh? totoo ba? complete na talaga? sure?");
        lblHeader1.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeader1.setForeground(Color.WHITE);
        lblHeader1.setFont(new Font("Montserrat", Font.BOLD, 12));
        lblHeader1.setBounds(35, 11, 298, 41);
        pnlMain.add(lblHeader1);

        RoundedButton btnConfirm = new RoundedButton("<html><u><i>YES MHIE!</i></u></html>", 10);
        btnConfirm.setBounds(101, 50, 170, 32);
        btnConfirm.setForeground(new Color(115, 12, 12));
        btnConfirm.setBackground(Color.WHITE);
        btnConfirm.setFont(new Font("Montserrat", Font.BOLD, 12));
        btnConfirm.addActionListener(e -> {
            dispose();
            CompleteConfirmationDone completeConfirmationDone = new CompleteConfirmationDone();
            completeConfirmationDone.setVisible(true);
        });
        pnlMain.add(btnConfirm);

        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Float(0, 0, getBounds().width, getBounds().height, cornerRadius, cornerRadius));
        setVisible(true);
    }
}
