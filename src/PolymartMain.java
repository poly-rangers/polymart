import java.awt.*;
import javax.swing.*;
import buyer.*;
import misc.*;
import seller.*;

public class PolymartMain extends JFrame {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                PolymartMain frameMain = new PolymartMain();
                frameMain.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public PolymartMain() {
        setTitle("Polymart");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 430, 700);
        setLocationRelativeTo(null);

        // Set icon
        ImageIcon iconImg = new ImageIcon(this.getClass().getResource("/polypup_frameicon.png"));
        this.setIconImage(iconImg.getImage());

        // Main content panel with CardLayout
        JPanel contentPane = new JPanel(new CardLayout());
        setContentPane(contentPane);

        // Initialize panels
        BuyerOrSeller buyerOrSeller = new BuyerOrSeller(contentPane);
        contentPane.add(buyerOrSeller, "BuyerOrSeller");
        
        ProfilePanel profilePanel = new ProfilePanel(contentPane);
        contentPane.add(profilePanel, "ProfilePanel");
        
        TCandPP tcAndPP = new TCandPP(contentPane);
        contentPane.add(tcAndPP, "TCandPP");
        
        EditProfile editProfile = new EditProfile(contentPane);
        contentPane.add(editProfile, "EditProfile");

        TermsConditionsPanel buyerTermsConditionsPanel = new TermsConditionsPanel(contentPane, "Buyer");
        TermsConditionsPanel sellerTermsConditionsPanel = new TermsConditionsPanel(contentPane, "Seller");
        contentPane.add(buyerTermsConditionsPanel, "BuyerTermsConditionsPanel");
        contentPane.add(sellerTermsConditionsPanel, "SellerTermsConditionsPanel");

        // Buyer panels
        BuyerStartupPanel buyerStartupPanel = new BuyerStartupPanel(contentPane);
        BuyerSignupPanel buyerSignupPanel = new BuyerSignupPanel(contentPane);
        BuyerSignInPanel buyerSignInPanel = new BuyerSignInPanel(contentPane);
        BuyerDashboardPanel buyerDashboardPanel = new BuyerDashboardPanel(contentPane);
        BuyerOrderPanel	buyerOrderPanel = new BuyerOrderPanel(contentPane);
        BuyerMap buyerMap = new BuyerMap(contentPane);
        BuyerProfile buyerProfile = new BuyerProfile(contentPane);

        contentPane.add(buyerStartupPanel, "BuyerStartupPanel");
        contentPane.add(buyerSignupPanel, "BuyerSignupPanel");
        contentPane.add(buyerSignInPanel, "BuyerSignInPanel");
        contentPane.add(buyerDashboardPanel, "BuyerDashboardPanel");
        contentPane.add(buyerOrderPanel, "BuyerOrderPanel");
        contentPane.add(buyerMap, "BuyerMap");
        contentPane.add(buyerProfile, "BuyerProfile");

        // Seller panels
        SellerStartupPanel sellerStartupPanel = new SellerStartupPanel(contentPane);
        SellerSignupPanel sellerSignupPanel = new SellerSignupPanel(contentPane);
        SellerSignInPanel sellerSignInPanel = new SellerSignInPanel(contentPane);
        SellerDashboardPanel sellerDashboardPanel = new SellerDashboardPanel(contentPane);
        SellerProductListing sellerProductListing = new SellerProductListing(contentPane);
        ProductDetails productDetails = new ProductDetails(contentPane);
        SellerOrderPanel sellerOrderPanel = new SellerOrderPanel(contentPane);
        SellerProductReviews sellerProductReviews = new SellerProductReviews(contentPane);

        contentPane.add(sellerStartupPanel, "SellerStartupPanel");
        contentPane.add(sellerSignupPanel, "SellerSignupPanel");
        contentPane.add(sellerSignInPanel, "SellerSignInPanel");
        contentPane.add(sellerDashboardPanel, "SellerDashboardPanel");
        contentPane.add(sellerProductListing, "SellerProductListing");
        contentPane.add(productDetails, "ProductDetails");
        contentPane.add(sellerOrderPanel, "SellerOrderPanel");
        contentPane.add(sellerProductReviews, "SellerProductReviews");

        // Navigation bar
        BuyerNavigationBar buyerNavigationBar = new BuyerNavigationBar(contentPane);
        add(buyerNavigationBar, java.awt.BorderLayout.SOUTH); // Add navigation bar to bottom

        // Show the initial panel
        CardLayout clLayout = (CardLayout) contentPane.getLayout();
        clLayout.show(contentPane, "BuyerOrSeller");
    }
}
