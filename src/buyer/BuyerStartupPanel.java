package buyer;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class BuyerStartupPanel extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public BuyerStartupPanel(JPanel contentPane) {
        this.contentPane = contentPane;

        setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        SpringLayout layout = new SpringLayout();
        setLayout(layout);

        JLabel startupHeader1 = new JLabel("WELCOME TO");
        layout.putConstraint(SpringLayout.WEST, startupHeader1, 10, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, startupHeader1, -328, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.EAST, startupHeader1, -5, SpringLayout.EAST, this);
        startupHeader1.setHorizontalAlignment(SwingConstants.CENTER);
        startupHeader1.setForeground(new Color(153, 0, 0));
        startupHeader1.setFont(new Font("Montserrat", Font.PLAIN, 24));
        add(startupHeader1);

        JLabel startupHeader2 = new JLabel("POLYMART,");
        layout.putConstraint(SpringLayout.WEST, startupHeader2, 10, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, startupHeader2, -5, SpringLayout.EAST, this);
        startupHeader2.setForeground(new Color(153, 0, 0));
        startupHeader2.setFont(new Font("Montserrat", Font.BOLD, 48));
        startupHeader2.setHorizontalAlignment(SwingConstants.CENTER);
        add(startupHeader2);

        JLabel startupHeader3 = new JLabel("baks!");
        layout.putConstraint(SpringLayout.NORTH, startupHeader3, 382, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, startupHeader3, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, startupHeader3, -5, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.SOUTH, startupHeader2, 0, SpringLayout.NORTH, startupHeader3);
        startupHeader3.setHorizontalAlignment(SwingConstants.CENTER);
        startupHeader3.setForeground(new Color(153, 0, 0));
        startupHeader3.setFont(new Font("Montserrat", Font.ITALIC, 32));
        add(startupHeader3);

        JLabel startupSubheader1 = new JLabel("ready ka na ba magwaldas, te?");
        layout.putConstraint(SpringLayout.WEST, startupSubheader1, 10, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, startupSubheader1, -189, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.EAST, startupSubheader1, -5, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.SOUTH, startupHeader3, -32, SpringLayout.NORTH, startupSubheader1);
        startupSubheader1.setHorizontalAlignment(SwingConstants.CENTER);
        startupSubheader1.setForeground(Color.BLACK);
        startupSubheader1.setFont(new Font("Montserrat", Font.BOLD, 18));
        add(startupSubheader1);

        JLabel startupSubheader2 = new JLabel("mag-sign up ka muna hahah");
        layout.putConstraint(SpringLayout.NORTH, startupSubheader2, 0, SpringLayout.SOUTH, startupSubheader1);
        layout.putConstraint(SpringLayout.WEST, startupSubheader2, 10, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, startupSubheader2, -5, SpringLayout.EAST, this);
        startupSubheader2.setHorizontalAlignment(SwingConstants.CENTER);
        startupSubheader2.setForeground(Color.BLACK);
        startupSubheader2.setFont(new Font("Montserrat", Font.BOLD, 18));
        add(startupSubheader2);

        JButton startupStartButton = new JButton("gewwww, deserve ko 'to!");
        layout.putConstraint(SpringLayout.NORTH, startupStartButton, 33, SpringLayout.SOUTH, startupSubheader2);
        layout.putConstraint(SpringLayout.WEST, startupStartButton, 69, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, startupStartButton, -66, SpringLayout.EAST, this);
        startupStartButton.setForeground(Color.WHITE);
        startupStartButton.setBackground(new Color(102, 0, 0));
        startupStartButton.setFont(new Font("Montserrat", Font.BOLD, 16));
        startupStartButton.setBorderPainted(false);
        startupStartButton.setFocusPainted(false);
        startupStartButton.addActionListener(this);
        add(startupStartButton);

        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_front.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        layout.putConstraint(SpringLayout.NORTH, startupImage, 69, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, startupImage, 73, SpringLayout.WEST, this);
        add(startupImage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Switch to SignupPanel
        CardLayout clLayout = (CardLayout) contentPane.getLayout();
        clLayout.show(contentPane, "BuyerSignupPanel");
    }
}