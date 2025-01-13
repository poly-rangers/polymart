import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;

import misc.RoundButton;

import java.awt.BorderLayout;

public class SetMeetUpFrame extends JFrame {
	private static final long serialVersionUID = 8247694229122275513L;
	public SetMeetUpFrame() {
		setUndecorated(true);
		
		JPanel pnlMain = new JPanel();
		pnlMain.setBounds(0, 0, 0, 0);
		pnlMain.setLayout(null);
		pnlMain.setBackground(new Color(115, 12, 12));
		
		// Select a meet-up location text
		JLabel lblSetLocation = new JLabel("Select a meet-up location: ");
		lblSetLocation.setBounds(39, 24, 197, 19);
		lblSetLocation.setFont(new Font("Montseratt", Font.BOLD, 14));
		lblSetLocation.setForeground(Color.WHITE);
		pnlMain.add(lblSetLocation);
		
		// Location selection dropdown
		String[] strLocations = {"Select a variation", "Lagoon", "Souvenir Shop", "Linear"};
		JComboBox<String> toggleDownLocation = new JComboBox<>(strLocations);
		toggleDownLocation.setBounds(49, 54, 121, 20);
		toggleDownLocation.setFont(new Font("Montserrat", Font.ITALIC, 10));
		
		pnlMain.add(toggleDownLocation);

		JLabel lblSetTimeAndDay = new JLabel("Select mode of payment: ");
		lblSetTimeAndDay.setBounds(39, 97, 197, 19);
		lblSetTimeAndDay.setFont(new Font("Montseratt", Font.BOLD, 14));
		lblSetTimeAndDay.setForeground(Color.WHITE);
		pnlMain.add(lblSetTimeAndDay);
		
		String[] strTimeAndDay = {"Select a variation", "Cash", "GCash", "Maya"};
		JComboBox<String> toggleDownPayment = new JComboBox<>(strTimeAndDay);
		toggleDownPayment.setBounds(49, 127, 121, 20);
		toggleDownPayment.setFont(new Font("Montserrat", Font.ITALIC, 10));
		
		pnlMain.add(toggleDownPayment);
		
		JLabel lblRemarks = new JLabel("Notes/Remarks: ");
		lblRemarks.setBounds(39, 170, 197, 19);
		lblRemarks.setFont(new Font("Montseratt", Font.BOLD, 14));
		lblRemarks.setForeground(Color.WHITE);
		pnlMain.add(lblRemarks);
		
		JTextField txtFldRemarks = new JTextField();
		txtFldRemarks.setBounds(49, 200, 355, 40);
		pnlMain.add(txtFldRemarks);
		
		getContentPane().add(pnlMain);
		
		RoundButton btnConfirm = new RoundButton("<html><u><i>Confirm</i></u></html>", 10);
		pnlMain.add(btnConfirm);
		btnConfirm.setForeground(new Color(115, 12, 12));
		btnConfirm.setBackground(Color.WHITE);
		btnConfirm.setFont(new Font("Montserrat", Font.BOLD, 12));
		btnConfirm.setBounds(166, 251, 121, 28);
		btnConfirm.setBorderPainted(false);
		btnConfirm.setFocusPainted(false);
		
		setVisible(true);
		
	}
}