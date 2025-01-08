package buyer;
import java.awt.Color;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyerDashboardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtDitoSearchBar;

	public BuyerDashboardPanel(JPanel contentPane) {

		setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        SpringLayout panelLayout = new SpringLayout();
        setLayout(panelLayout);
        
        // Icon + title
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_icon.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        panelLayout.putConstraint(SpringLayout.NORTH, startupImage, 24, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, startupImage, 16, SpringLayout.WEST, this);
        add(startupImage);
        
        
        JLabel lblNewLabel = new JLabel("Products");
        lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 19));
        add(lblNewLabel);
        
        txtDitoSearchBar = new JTextField();
        panelLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 28, SpringLayout.SOUTH, txtDitoSearchBar);
        panelLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, txtDitoSearchBar);
        panelLayout.putConstraint(SpringLayout.NORTH, txtDitoSearchBar, 28, SpringLayout.SOUTH, startupImage);
        panelLayout.putConstraint(SpringLayout.WEST, txtDitoSearchBar, 63, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, txtDitoSearchBar, -86, SpringLayout.EAST, this);
        txtDitoSearchBar.setText("DASHBOARD NI BUYER");
        add(txtDitoSearchBar);
        txtDitoSearchBar.setColumns(10);
        
        JPanel panel = new JPanel();
        panelLayout.putConstraint(SpringLayout.NORTH, panel, 6, SpringLayout.SOUTH, lblNewLabel);
        panelLayout.putConstraint(SpringLayout.WEST, panel, 59, SpringLayout.WEST, this);
        add(panel);
        
        JPanel panel_1 = new JPanel();
        panelLayout.putConstraint(SpringLayout.WEST, panel_1, 220, SpringLayout.WEST, this);
        panelLayout.putConstraint(SpringLayout.EAST, panel_1, -39, SpringLayout.EAST, this);
        panelLayout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, panel_1);
        panelLayout.putConstraint(SpringLayout.EAST, panel, -6, SpringLayout.WEST, panel_1);
        panelLayout.putConstraint(SpringLayout.NORTH, panel_1, 58, SpringLayout.SOUTH, txtDitoSearchBar);
        panelLayout.putConstraint(SpringLayout.SOUTH, panel_1, 198, SpringLayout.SOUTH, txtDitoSearchBar);
        add(panel_1);
        
        JPanel panel_2 = new JPanel();
        panelLayout.putConstraint(SpringLayout.NORTH, panel_2, 6, SpringLayout.SOUTH, panel);
        panelLayout.putConstraint(SpringLayout.WEST, panel_2, 0, SpringLayout.WEST, panel);
        panelLayout.putConstraint(SpringLayout.SOUTH, panel_2, 146, SpringLayout.SOUTH, panel);
        panelLayout.putConstraint(SpringLayout.EAST, panel_2, 0, SpringLayout.EAST, panel);
        add(panel_2);
        
        JPanel panel_3 = new JPanel();
        panelLayout.putConstraint(SpringLayout.NORTH, panel_3, 6, SpringLayout.SOUTH, panel_1);
        panelLayout.putConstraint(SpringLayout.WEST, panel_3, 0, SpringLayout.WEST, panel_1);
        panelLayout.putConstraint(SpringLayout.SOUTH, panel_3, 0, SpringLayout.SOUTH, panel_2);
        panelLayout.putConstraint(SpringLayout.EAST, panel_3, 0, SpringLayout.EAST, panel_1);
        add(panel_3);
        
        JButton btnNewButton = new JButton("h0Em ni BH0kXZ");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        panelLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 83, SpringLayout.SOUTH, panel_2);
        panelLayout.putConstraint(SpringLayout.WEST, btnNewButton, 32, SpringLayout.WEST, this);
        add(btnNewButton);
        
        JButton btnMphesyam = new JButton("m4P4 #HES0Yam");
        panelLayout.putConstraint(SpringLayout.NORTH, btnMphesyam, 0, SpringLayout.NORTH, btnNewButton);
        panelLayout.putConstraint(SpringLayout.WEST, btnMphesyam, 6, SpringLayout.EAST, btnNewButton);
        add(btnMphesyam);
        
        JButton btnRcibo = new JButton("rcibo...");
        btnRcibo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        panelLayout.putConstraint(SpringLayout.NORTH, btnRcibo, 6, SpringLayout.SOUTH, btnNewButton);
        panelLayout.putConstraint(SpringLayout.WEST, btnRcibo, 0, SpringLayout.WEST, btnNewButton);
        add(btnRcibo);
        
        JButton btnPropayl = new JButton("propayl");
        panelLayout.putConstraint(SpringLayout.NORTH, btnPropayl, 6, SpringLayout.SOUTH, btnNewButton);
        panelLayout.putConstraint(SpringLayout.WEST, btnPropayl, 6, SpringLayout.EAST, btnRcibo);
        add(btnPropayl);
	}
}
