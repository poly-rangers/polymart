import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import buyer.BuyerDashboardPanel;
import buyer.BuyerSignInPanel;
import buyer.BuyerSignupPanel;

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
        StartupPanel startupPanel = new StartupPanel(contentPane);
        BuyerSignupPanel buyerSignupPanel = new BuyerSignupPanel(contentPane);
        TermsConditionsPanel termsConditionsPanel = new TermsConditionsPanel(contentPane);
        BuyerSignInPanel signInPanel = new BuyerSignInPanel(contentPane);
        BuyerDashboardPanel dashboardPanel = new BuyerDashboardPanel(contentPane);

        contentPane.add(startupPanel, "StartupPanel");
        contentPane.add(buyerSignupPanel, "SignupPanel");
        contentPane.add(termsConditionsPanel, "TermsConditionsPanel");
        contentPane.add(signInPanel, "SignInPanel");
        contentPane.add(dashboardPanel, "DashboardPanel");

        // Show StartupPanel initially
        CardLayout clLayout = (CardLayout) contentPane.getLayout();
        clLayout.show(contentPane, "StartupPanel");
    }
}