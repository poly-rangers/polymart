package misc;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteAccountPanel extends JPanel {
    
    private static final long serialVersionUID = 1L;

    private JLabel confirmationMessage, description;
    private JPanel contentPane;
    
    public DeleteAccountPanel(JPanel contentPane) {
    	this.contentPane = contentPane;
        
        setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        setLayout(null);
        
        ImageIcon alertPic = new ImageIcon(this.getClass().getResource("/polyacry.png"));
        JLabel pic = new JLabel(alertPic);
        pic.setBounds(107, 194, 189, 174);
        add(pic);
        
        confirmationMessage = new JLabel("Account deleted!");
        confirmationMessage.setForeground(new Color(0x730C0C));
        confirmationMessage.setHorizontalAlignment(SwingConstants.CENTER);
        confirmationMessage.setFont(new Font("Montserrat", Font.BOLD, 20));
        confirmationMessage.setBounds(10, 379, 386, 25);
        add(confirmationMessage);

        description = new JLabel("Sobrang sakit mo na, baks...");
        description.setHorizontalAlignment(SwingConstants.CENTER);
        description.setFont(new Font("Montserrat Medium", Font.ITALIC, 14));
        description.setOpaque(false);
        description.setBounds(10, 403, 386, 25);
        add(description);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CardLayout clLayout = (CardLayout) contentPane.getLayout();
                clLayout.show(contentPane, "BuyerOrSeller");
            }
        });
    }
}
