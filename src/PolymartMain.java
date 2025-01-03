import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;

public class PolymartMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel StartupPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PolymartMain frame = new PolymartMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
    public PolymartMain() {
        setTitle("Polymart");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 430, 700);
        setLocationRelativeTo(null);

        // Icon
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/polypup_icon.png"));
        this.setIconImage(icon.getImage());

        JPanel contentPane = new JPanel(new CardLayout());
        setContentPane(contentPane);

        // Add panels
        StartupPanel startupPanel = new StartupPanel(contentPane);
        SignupPanel signupPanel = new SignupPanel(contentPane);

        contentPane.add(startupPanel, "StartupPanel");
        contentPane.add(signupPanel, "SignupPanel");

        // Show StartupPanel initially
        CardLayout cl = (CardLayout) contentPane.getLayout();
        cl.show(contentPane, "StartupPanel");
    }
}