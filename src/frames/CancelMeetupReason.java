package frames;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import misc.RoundedButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CancelMeetupReason extends JFrame {

    private static final long serialVersionUID = 6410724970529248217L;
    private int cornerRadius = 30;
    
    public CancelMeetupReason() {
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));  // Transparent background for smooth corners
        setSize(370, 202);
        getContentPane().setLayout(null);

        JPanel pnlMain = new JPanel();
        pnlMain.setLayout(null);
        pnlMain.setBackground(new Color(115, 12, 12));
        pnlMain.setBounds(0, 0, getWidth(), getHeight());
        getContentPane().add(pnlMain);


        JLabel lblHeader1 = new JLabel("Are you sure you want to cancel meet-up?");
        lblHeader1.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeader1.setForeground(Color.WHITE);
        lblHeader1.setFont(new Font("Montserrat", Font.BOLD, 12));
        lblHeader1.setBounds(35, 24, 298, 20);
        pnlMain.add(lblHeader1);
        
        JLabel lblHeader2 = new JLabel("final na yan te? promise?");
        lblHeader2.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeader2.setForeground(Color.WHITE);
        lblHeader2.setFont(new Font("Montserrat", Font.ITALIC, 12));
        lblHeader2.setBounds(35, 41, 298, 20);
        pnlMain.add(lblHeader2);
        
        JLabel lblReason = new JLabel("Reason:");
        lblReason.setForeground(Color.WHITE);
        lblReason.setFont(new Font("Montserrat", Font.BOLD, 12));
        lblReason.setBounds(35, 67, 298, 20);
        pnlMain.add(lblReason);

        RoundedButton btnConfirm = new RoundedButton("<html><u><i>Confirm</i></u></html>", 10);
        btnConfirm.setBounds(35, 142, 135, 32);
        btnConfirm.setForeground(new Color(115, 12, 12));
        btnConfirm.setBackground(Color.WHITE);
        btnConfirm.setFont(new Font("Montserrat", Font.BOLD, 12));
        btnConfirm.addActionListener(e -> {
            dispose();
            CancelMeetupDone cancelMeetupDone = new CancelMeetupDone();
            cancelMeetupDone.setVisible(true);
        });
        pnlMain.add(btnConfirm);

        RoundedButton btnGoBack = new RoundedButton("<html><u><i>Go Back</i></u></html>", 10);
        btnGoBack.setBounds(198, 142, 135, 32);
        btnGoBack.setForeground(new Color(115, 12, 12));
        btnGoBack.setBackground(Color.WHITE);
        btnGoBack.setFont(new Font("Montserrat", Font.BOLD, 12));
        btnGoBack.addActionListener(e -> {
            dispose();
            MeetupConfirmation meetupConfirmation = new MeetupConfirmation();
            meetupConfirmation.setVisible(true);
        });
        pnlMain.add(btnGoBack);
        
        JTextArea textArea = new JTextArea();
        textArea.setBounds(35, 91, 298, 37);
        pnlMain.add(textArea);

        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Float(0, 0, getBounds().width, getBounds().height, cornerRadius, cornerRadius));
        setVisible(true);
    }
}
