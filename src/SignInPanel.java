import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class SignInPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public SignInPanel() {
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
