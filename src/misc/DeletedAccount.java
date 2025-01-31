package misc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

import misc.RoundedButton;
import seller.SellerNavigationBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeletedAccount extends JPanel implements ActionListener{
    
    private static final long serialVersionUID = 1L;

    private JLabel startupImage, confirmationMessage, tagalogMessage;
    private JTextArea description;
    private RoundedButton deleteButton, cancelButton;
    private JButton btnGoBack;

    public DeletedAccount() {
        
        setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        setLayout(null);

        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_seller.icon.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
        startupImage = new JLabel(new ImageIcon(scaledImage));
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
        
        JLabel lblMyProduct = new JLabel("Delete Account");
        lblMyProduct.setFont(new Font("Montserrat", Font.BOLD, 19));
        pnlHeader.add(lblMyProduct);
        
        add(pnlHeader);
        
        confirmationMessage = new JLabel(
            "<html>Are you sure you want to<br> delete your PolyMart account?</html>"
        );
        confirmationMessage.setFont(new Font("Montserrat", Font.BOLD, 20));
        confirmationMessage.setBounds(36, 145, 335, 56);
        add(confirmationMessage);

      
        tagalogMessage = new JLabel("Sure k n ba jn, baks? Baka mamiss mo kami...");
        tagalogMessage.setFont(new Font("Montserrat", Font.ITALIC, 12));
        tagalogMessage.setForeground(Color.GRAY);
        tagalogMessage.setBounds(36, 199, 299, 20);
        add(tagalogMessage);

       
        description = new JTextArea(
            "Once you delete your account, it cannot be "
            + "undone. All of your content will be "
            + "permanently erased—including your entire "
            + "profile, ratings & reviews, and all of your "
            + "receipts.\n\n" +
                    "Deleting your PolyMart account will cancel all "
                    + "of your pending and active orders. If you're not "
                    + "sure, you can always cancel below."
        );
        description.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
        description.setWrapStyleWord(true);
        description.setLineWrap(true);
        description.setEditable(false);
        description.setOpaque(false);
        description.setBounds(36, 253, 360, 174);
        add(description);
  
        deleteButton = new RoundedButton("Delete Account", 45);
        deleteButton.setBackground(new Color(115, 12, 12));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFont(new Font("Montserrat", Font.BOLD, 13));
        deleteButton.setBounds(25, 480, 350, 42);
        add(deleteButton);
        
        cancelButton = new RoundedButton("Cancel", 45);
        cancelButton.setBackground(Color.LIGHT_GRAY); 
        cancelButton.setForeground(new Color(128, 128, 128)); 
        cancelButton.setBorderPainted(false);
        cancelButton.setFocusPainted(false);
        cancelButton.setFont(new Font("Montserrat", Font.BOLD, 13));
        cancelButton.setBounds(25, 533, 350, 42);
        add(cancelButton);


    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}