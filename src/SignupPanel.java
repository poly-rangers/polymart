import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class SignupPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public SignupPanel(JPanel contentPane) {
		
		setBackground(Color.WHITE);
		setBounds(100, 100, 414, 660);
        SpringLayout layout = new SpringLayout();
        setLayout(layout);
        
        JLabel startupHeader2 = new JLabel("basta eto yung signup ni hanna");
        layout.putConstraint(SpringLayout.WEST, startupHeader2, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, startupHeader2, -305, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.EAST, startupHeader2, 0, SpringLayout.EAST, this);
        startupHeader2.setForeground(new Color(153, 0, 0));
        startupHeader2.setFont(new Font("Montserrat", Font.BOLD, 16));
        startupHeader2.setHorizontalAlignment(SwingConstants.CENTER);
        add(startupHeader2);
	}
}
