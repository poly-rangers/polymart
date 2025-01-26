package frames;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;

import misc.RoundedButton;

public class SetMeetUpFrame extends JFrame {
    private static final long serialVersionUID = 8247694229122275513L;
    private int cornerRadius = 30;

    public SetMeetUpFrame() {
        setUndecorated(true);
        setSize(370, 420);
        getContentPane().setLayout(null);  // Using absolute layout
        setBackground(new Color(0, 0, 0, 0));  // Transparent background for smooth corners

        JPanel pnlMain = new JPanel();
        pnlMain.setLayout(null);
        pnlMain.setBackground(new Color(115, 12, 12));
        pnlMain.setBounds(0, 0, getWidth(), getHeight());
        getContentPane().add(pnlMain);

     // Load image with error handling
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/pupmain_map.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(250, 200, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        startupImage.setBounds(49, 11, 266, 184); // Positioning the image inside the frame
        pnlMain.add(startupImage);
        
        
        // Select a meet-up location label
        JLabel lblSetLocation = new JLabel("Select a meet-up location: ");
        lblSetLocation.setBounds(49, 197, 197, 19);
        lblSetLocation.setFont(new Font("Montserrat", Font.BOLD, 12));
        lblSetLocation.setForeground(Color.WHITE);
        pnlMain.add(lblSetLocation);

        // Location dropdown
        String[] strLocations = {"Select a variation", "Lagoon", "Souvenir Shop", "Linear"};
        JComboBox<String> toggleDownLocation = new JComboBox<>(strLocations);
        toggleDownLocation.setBounds(49, 217, 121, 20);
        toggleDownLocation.setFont(new Font("Montserrat", Font.ITALIC, 10));
        pnlMain.add(toggleDownLocation);

        // Payment method label
        JLabel lblSetTimeAndDay = new JLabel("Select mode of payment: ");
        lblSetTimeAndDay.setBounds(49, 248, 197, 19);
        lblSetTimeAndDay.setFont(new Font("Montserrat", Font.BOLD, 12));
        lblSetTimeAndDay.setForeground(Color.WHITE);
        pnlMain.add(lblSetTimeAndDay);

        // Payment method dropdown
        String[] strTimeAndDay = {"Select a variation", "Cash", "GCash", "Maya"};
        JComboBox<String> toggleDownPayment = new JComboBox<>(strTimeAndDay);
        toggleDownPayment.setBounds(49, 266, 121, 20);
        toggleDownPayment.setFont(new Font("Montserrat", Font.ITALIC, 10));
        pnlMain.add(toggleDownPayment);

        // Remarks label
        JLabel lblRemarks = new JLabel("Notes/Remarks: ");
        lblRemarks.setBounds(49, 297, 197, 19);
        lblRemarks.setFont(new Font("Montserrat", Font.BOLD, 12));
        lblRemarks.setForeground(Color.WHITE);
        pnlMain.add(lblRemarks);

        // Remarks text field
        JTextField txtFldRemarks = new JTextField();
        txtFldRemarks.setFont(new Font("Tahoma", Font.PLAIN, 9));
        txtFldRemarks.setBounds(49, 317, 266, 40);
        pnlMain.add(txtFldRemarks);

        // Confirm button
        RoundedButton btnConfirm = new RoundedButton("<html><u><i>Confirm</i></u></html>", 10);
        btnConfirm.setBounds(125, 368, 121, 28);
        btnConfirm.setForeground(new Color(115, 12, 12));
        btnConfirm.setBackground(Color.WHITE);
        btnConfirm.setFont(new Font("Montserrat", Font.BOLD, 12));
        btnConfirm.setBorderPainted(false);
        btnConfirm.setFocusPainted(false);
        pnlMain.add(btnConfirm);

        btnConfirm.addActionListener(e -> dispose());  // Close the frame on confirm

        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Float(0, 0, getBounds().width, getBounds().height, cornerRadius, cornerRadius));
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        // Enable antialiasing for smoother curves
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
    }
}
