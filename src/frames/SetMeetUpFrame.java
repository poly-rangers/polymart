package frames;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import misc.RoundedButton;

public class SetMeetUpFrame extends JDialog implements ActionListener {
    private static final long serialVersionUID = 8247694229122275513L;
    private int cornerRadius = 30;
    private JTextField textField;
    private RoundedButton btnClear, btnCancel, btnConfirm;
    private JTextArea textArea;
    private String[] strLocations = {"1. Lagoon", "2. West Wing", "3. Dome", "4. East Wing", 
			"5. South Wing", "6. Linear Park", "7. Charlie Building", "8. Grandstand", "9. Tennis Courtside",
			"10. Souvenir Shop", "11. Gate Exit", "12. Gate Entrance"};
    private String[] strTime = {"7:00 AM", "8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM",
		    "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM"};
    private JComboBox<String> toggleDownLocation, toggleDownTime, toggleDownPayment;

    public SetMeetUpFrame() {
        setUndecorated(true);
        setSize(379, 604);
        getContentPane().setLayout(null);
        setBackground(new Color(0, 0, 0, 0));

        JPanel pnlMain = new JPanel();
        pnlMain.setLayout(null);
        pnlMain.setBackground(new Color(115, 12, 12));
        pnlMain.setBounds(0, 0, 379, 604);
        getContentPane().add(pnlMain);
        
        JLabel lblMeetUpLoc = new JLabel("Main Meet-up Locations");
        lblMeetUpLoc.setBounds(64, 23, 197, 19);
        lblMeetUpLoc.setFont(new Font("Montserrat", Font.BOLD, 15));
        lblMeetUpLoc.setForeground(Color.WHITE);
        pnlMain.add(lblMeetUpLoc);
        
        ImageIcon locationIcon = new ImageIcon(this.getClass().getResource("/location_pin_icon.png"));
        Image scaledIcon = locationIcon.getImage().getScaledInstance(24, 25, Image.SCALE_SMOOTH);
        JLabel locationLogo = new JLabel(new ImageIcon(scaledIcon));
        locationLogo.setBounds(28, 11, 31, 42);
        pnlMain.add(locationLogo);

        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/pupmain_map_upscaled.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(325, 275, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        startupImage.setBounds(10, 53, 359, 283);
        pnlMain.add(startupImage);
        
        JLabel lblSetLocation = new JLabel("Select a meet-up location: ");
        lblSetLocation.setBounds(28, 340, 197, 19);
        lblSetLocation.setFont(new Font("Montserrat", Font.BOLD, 12));
        lblSetLocation.setForeground(Color.WHITE);
        pnlMain.add(lblSetLocation);
        
        toggleDownLocation = new JComboBox<>(strLocations);
        toggleDownLocation.setSelectedIndex(-1);
        toggleDownLocation.setBounds(28, 358, 140, 23);
        toggleDownLocation.setFont(new Font("Montserrat", Font.ITALIC, 10));
        pnlMain.add(toggleDownLocation);
        toggleDownLocation.setFocusable(false);
        
        JLabel lblSetTime = new JLabel("Select time: ");
        lblSetTime.setBounds(28, 387, 140, 19);
        lblSetTime.setFont(new Font("Montserrat", Font.BOLD, 12));
        lblSetTime.setForeground(Color.WHITE);
        pnlMain.add(lblSetTime);

        toggleDownTime = new JComboBox<>(strTime);
        toggleDownTime.setSelectedIndex(-1);
        toggleDownTime.setBounds(28, 407, 140, 23);
        toggleDownTime.setFont(new Font("Montserrat", Font.ITALIC, 10));
        pnlMain.add(toggleDownTime);
        toggleDownTime.setFocusable(false);
        
        JLabel lblQty = new JLabel("Quantity: ");
        lblQty.setForeground(Color.WHITE);
        lblQty.setFont(new Font("Montserrat", Font.BOLD, 12));
        lblQty.setBounds(207, 436, 74, 19);
        pnlMain.add(lblQty);

        JLabel lblSetPayment = new JLabel("Select mode of payment: ");
        lblSetPayment.setBounds(28, 436, 197, 19);
        lblSetPayment.setFont(new Font("Montserrat", Font.BOLD, 12));
        lblSetPayment.setForeground(Color.WHITE);
        pnlMain.add(lblSetPayment);

        String[] strPayment = {"Cash", "GCash", "Maya"};
        this.toggleDownPayment = new JComboBox<>(strPayment);
        toggleDownPayment.setBounds(28, 456, 140, 23);
        toggleDownPayment.setSelectedIndex(-1);
        toggleDownPayment.setFont(new Font("Montserrat", Font.ITALIC, 10));
        pnlMain.add(toggleDownPayment);
        toggleDownPayment.setFocusable(false);

        JLabel lblRemarks = new JLabel("Notes/Remarks: ");
        lblRemarks.setBounds(28, 487, 197, 19);
        lblRemarks.setFont(new Font("Montserrat", Font.BOLD, 12));
        lblRemarks.setForeground(Color.WHITE);
        pnlMain.add(lblRemarks);
        
        textField = new JTextField();
        textField.setBounds(207, 456, 142, 23);
        pnlMain.add(textField);
        textField.setColumns(10);
        
        textArea = new JTextArea();
        textArea.setBounds(28, 504, 321, 40);
        pnlMain.add(textArea);
        
        btnClear = new RoundedButton("Clear", 10);
        btnClear.setBackground(Color.LIGHT_GRAY);
        btnClear.setForeground(Color.DARK_GRAY);
        btnClear.setBorder(null);
        btnClear.setFont(new Font("Dialog", Font.BOLD, 12));
        btnClear.setFocusPainted(false);
        btnClear.setContentAreaFilled(false);
        btnClear.setBounds(28, 555, 90, 28);
        btnClear.setFocusable(false);
        btnClear.addActionListener(this);
        pnlMain.add(btnClear);
        
        btnCancel = new RoundedButton("Cancel", 10);
        btnCancel.setForeground(new Color(115, 12, 12));
        btnCancel.setFont(new Font("Montserrat", Font.BOLD, 12));
        btnCancel.setFocusPainted(false);
        btnCancel.setBorderPainted(false);
        btnCancel.setBackground(Color.WHITE);
        btnCancel.setBounds(144, 555, 90, 28);
        btnCancel.addActionListener(this);
        pnlMain.add(btnCancel);
        
        btnConfirm = new RoundedButton("Confirm", 10);
        btnConfirm.setBounds(259, 555, 90, 28);
        btnConfirm.setForeground(new Color(115, 12, 12));
        btnConfirm.setBackground(Color.WHITE);
        btnConfirm.setFont(new Font("Montserrat", Font.BOLD, 12));
        btnConfirm.setBorderPainted(false);
        btnConfirm.setFocusPainted(false);
        btnConfirm.addActionListener(this);
        pnlMain.add(btnConfirm);

        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Float(0, 0, getBounds().width, getBounds().height, cornerRadius, cornerRadius));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object objSource = e.getSource();
        
        if (objSource == btnClear) {
            clearContent();
        } else if (objSource == btnCancel) {
            dispose();
        } else if (objSource == btnConfirm) {
            dispose();
            MeetupConfirmation meetupConfirmation = new MeetupConfirmation();
            meetupConfirmation.setVisible(true);
        }
    }
    
    public void clearContent() {
        textField.setText("");
        textArea.setText("");
        toggleDownLocation.setSelectedIndex(0);
        toggleDownTime.setSelectedIndex(0);
        toggleDownPayment.setSelectedIndex(0);
    }
}