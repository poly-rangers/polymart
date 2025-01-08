import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class BuyerOrSeller extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public BuyerOrSeller(JPanel contentPane) {
		
		setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        SpringLayout layout = new SpringLayout();
        setLayout(layout);
	}

}
