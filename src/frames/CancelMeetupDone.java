package frames;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import misc.RoundedButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CancelMeetupDone extends JFrame {

    private static final long serialVersionUID = 6410724970529248217L;
    private int cornerRadius = 30;
    
    public CancelMeetupDone() {
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));  // Transparent background for smooth corners
        setSize(370, 130);
        getContentPane().setLayout(null);

        JPanel pnlMain = new JPanel();
        pnlMain.setLayout(null);
        pnlMain.setBackground(new Color(115, 12, 12));
        pnlMain.setBounds(0, 0, getWidth(), getHeight());
        getContentPane().add(pnlMain);

        String username = "@nintendocicc";
        
        JLabel lblHeader1 = new JLabel("<html><div style='text-align:center;'><b>" 
        					+ username 
        					+ "\'s order has been successfully cancelled.</b> " + "<i>pinapalaya na kita...</i></html>");
        lblHeader1.setForeground(Color.WHITE);
        lblHeader1.setFont(new Font("Montserrat", Font.PLAIN, 12));
        lblHeader1.setBounds(35, 24, 298, 41);
        pnlMain.add(lblHeader1);

        RoundedButton btnConfirm = new RoundedButton("<html><u><i>Confirm</i></u></html>", 10);
        btnConfirm.setText("<html><u><i>okay...</i></u></html>");
        btnConfirm.setBounds(100, 76, 170, 32);
        btnConfirm.setForeground(new Color(115, 12, 12));
        btnConfirm.setBackground(Color.WHITE);
        btnConfirm.setFont(new Font("Montserrat", Font.BOLD, 12));
        pnlMain.add(btnConfirm);
        btnConfirm.addActionListener(e -> dispose());
        //Change this to save into database
        
        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Float(0, 0, getBounds().width, getBounds().height, cornerRadius, cornerRadius));
        setVisible(true);
    }
}
