package misc;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

public class AccountDeleted extends JPanel{

	private static final long serialVersionUID = -470327302015029270L;
	private JLabel startupImage;

    public AccountDeleted() {

        setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        setLayout(null);

        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/sadpolypupicon.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(170, 140, Image.SCALE_SMOOTH);
        startupImage = new JLabel(new ImageIcon(scaledImage));
        startupImage.setBounds(124, 189, 154, 204);
        add(startupImage);

       JLabel Deleted = new JLabel("Account Deleted!");
        Deleted.setFont(new Font("Montserrat", Font.BOLD, 20));
        Deleted.setForeground(new Color(128, 0, 0));
        Deleted.setBounds(101, 362, 191, 56);
            add(Deleted);

            JLabel TagalogMessage = new JLabel("Sobrang sakit mo na, baks...");
            TagalogMessage.setFont(new Font("Montserrat Medium", Font.ITALIC, 14));
            TagalogMessage.setBounds(95, 404, 220, 31);
                add(TagalogMessage);

    }

}