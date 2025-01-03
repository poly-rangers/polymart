import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

public class TermsConditionsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public TermsConditionsPanel() {
		setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        SpringLayout layout = new SpringLayout();
        setLayout(layout);
        
        JLabel lblNewLabel = new JLabel("New label");
        layout.putConstraint(SpringLayout.NORTH, lblNewLabel, 265, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, lblNewLabel, 163, SpringLayout.WEST, this);
        add(lblNewLabel);
	}
}
