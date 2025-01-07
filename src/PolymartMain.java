import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class PolymartMain extends JFrame {

	private static final long serialVersionUID = 1L;
	
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
        ImageIcon iconImg = new ImageIcon(this.getClass().getResource("/polypup_frameicon.png"));
        this.setIconImage(iconImg.getImage());

        JPanel contentPane = new JPanel(new CardLayout());
        setContentPane(contentPane);

        // Add panels
        BuyerOrSeller userRolePanel = new BuyerOrSeller(contentPane);
        StartupPanel startupPanel = new StartupPanel(contentPane);
        SignupPanel signupPanel = new SignupPanel(contentPane);
        TermsConditionsPanel termsConditionsPanel = new TermsConditionsPanel(contentPane);
        SignInPanel signInPanel = new SignInPanel(contentPane);
        DashboardPanel dashboardPanel = new DashboardPanel(contentPane);
        
        contentPane.add(userRolePanel, "UserRolePanel");
        contentPane.add(startupPanel, "StartupPanel");
        contentPane.add(signupPanel, "SignupPanel");
        contentPane.add(termsConditionsPanel, "TermsConditionsPanel");
        contentPane.add(signInPanel, "SignInPanel");
        contentPane.add(dashboardPanel, "DashboardPanel");

        // Show StartupPanel initially
        CardLayout clLayout = (CardLayout) contentPane.getLayout();
        clLayout.show(contentPane, "userRolePanel");
    }
}