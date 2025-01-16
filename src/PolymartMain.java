import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import buyer.BuyerDashboardPanel;
import buyer.BuyerSignInPanel;
import buyer.BuyerSignupPanel;
import buyer.BuyerStartupPanel;
import seller.*;

import java.awt.CardLayout;

public class PolymartMain extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PolymartMain frameMain = new PolymartMain();
					frameMain.setVisible(true);
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

        //Add and initialize common panels
        BuyerOrSeller buyerOrSeller = new BuyerOrSeller(contentPane);
        contentPane.add(buyerOrSeller, "BuyerOrSeller");
   
        //Add and initialize dynamic panel
        TermsConditionsPanel buyerTermsConditionsPanel = new TermsConditionsPanel(contentPane, "Buyer");
        TermsConditionsPanel sellerTermsConditionsPanel = new TermsConditionsPanel(contentPane, "Seller");

        contentPane.add(buyerTermsConditionsPanel, "BuyerTermsConditionsPanel");
        contentPane.add(sellerTermsConditionsPanel, "SellerTermsConditionsPanel");
       
        // Add buyer panels
        BuyerStartupPanel buyerStartupPanel = new BuyerStartupPanel(contentPane);
        BuyerSignupPanel buyerSignupPanel = new BuyerSignupPanel(contentPane);
        BuyerSignInPanel buyerSignInPanel = new BuyerSignInPanel(contentPane);
        BuyerDashboardPanel buyerDashboardPanel = new BuyerDashboardPanel(contentPane);

        contentPane.add(buyerStartupPanel, "BuyerStartupPanel");
        contentPane.add(buyerSignupPanel, "BuyerSignupPanel");
        contentPane.add(buyerSignInPanel, "BuyerSignInPanel");
        contentPane.add(buyerDashboardPanel, "BuyerDashboardPanel");

        // Add seller panels
        SellerStartupPanel sellerStartupPanel = new SellerStartupPanel(contentPane);
        SellerSignupPanel sellerSignupPanel = new SellerSignupPanel(contentPane);
        SellerSignInPanel sellerSignInPanel = new SellerSignInPanel(contentPane);
        SellerDashboardPanel sellerDashboardPanel = new SellerDashboardPanel(contentPane);
        ProductListing productListing = new ProductListing(contentPane);

        contentPane.add(sellerStartupPanel, "SellerStartupPanel");
        contentPane.add(sellerSignupPanel, "SellerSignupPanel");
        contentPane.add(sellerSignInPanel, "SellerSignInPanel");
        contentPane.add(sellerDashboardPanel, "SellerDashboardPanel");
        contentPane.add(productListing, "ProductListing");
        
        // Show StartupPanel initially
        CardLayout clLayout = (CardLayout) contentPane.getLayout();
        clLayout.show(contentPane, "BuyerOrSeller");
    }
}