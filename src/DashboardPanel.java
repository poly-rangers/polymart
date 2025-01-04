import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

public class DashboardPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public DashboardPanel(JPanel contentPane) {

		setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        SpringLayout panelLayout = new SpringLayout();
        setLayout(panelLayout);
        
        JLabel lblNewLabel = new JLabel("hahaha parusa");
        panelLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 254, SpringLayout.NORTH, this);
        panelLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 151, SpringLayout.WEST, this);
        add(lblNewLabel);
	}
}
