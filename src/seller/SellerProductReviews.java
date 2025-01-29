package seller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SellerProductReviews extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1163098932001288578L;
	private JButton btnGoBack;
	private JPanel contentPane;
	
	public SellerProductReviews(JPanel contentPane) {
		this.contentPane = contentPane;
		
		setBackground(Color.WHITE);
        setSize(414, 660);
        setLayout(null);
		
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_seller.icon.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        startupImage.setBounds(16, 24, 150, 47);
        add(startupImage);
        
        JPanel pnlHeader = new JPanel();
        pnlHeader.setLayout(new BoxLayout(pnlHeader, BoxLayout.X_AXIS));
        pnlHeader.setOpaque(true);
        pnlHeader.setBounds(20,91,376,32);
        pnlHeader.setBackground(Color.WHITE);
        
        ImageIcon ogGoBackIcon = new ImageIcon(this.getClass().getResource("/arrowbackicon.png"));
        Image scaledGoBackIcon = ogGoBackIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        
        btnGoBack = new JButton();
        btnGoBack.addActionListener(this);
        btnGoBack.setIcon(new ImageIcon(scaledGoBackIcon));
        btnGoBack.setBackground(Color.WHITE);
        btnGoBack.setFocusPainted(false);
        btnGoBack.setBorderPainted(false);
        pnlHeader.add(btnGoBack);
        
        JLabel lblMyProduct = new JLabel("Item Reviews");
        lblMyProduct.setFont(new Font("Montserrat", Font.BOLD, 19));
        pnlHeader.add(lblMyProduct);
        
        add(pnlHeader);
        
<<<<<<< HEAD
        SellerNavigationBar navBar = new SellerNavigationBar(pnlHeader);
        navBar.setBounds(0, 610, 414,50);
=======
       
		SellerNavigationBar navBar = new SellerNavigationBar(contentPane);
        navBar.setBounds(0,610, 414,50);
>>>>>>> 92007b9ed62166380b725769f0c17b17a61ae661
        add(navBar);
	}

	@Override
	public void actionPerformed(ActionEvent actEvent) {
		  Object objSourceEvent = actEvent.getSource();

	        if (objSourceEvent == btnGoBack) {
	            // Switch to Product Listing
	            CardLayout clLayout = (CardLayout) contentPane.getLayout();
	            clLayout.show(contentPane, "SellerDashboardPanel");
	        }
	}

}
