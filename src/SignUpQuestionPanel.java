import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpQuestionPanel extends JDialog {
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 3165285528614856510L;

	public SignUpQuestionPanel(JFrame parent){
    	super(parent, "Why do I need this?", true); // value set to true so user can't interact with main frame.
      	setUndecorated(true);
        setSize(318, 282);
        setLocationRelativeTo(parent);
      
        getContentPane().setBackground(new Color(115, 12, 12));
        getContentPane().setLayout(new BorderLayout(0, 0)); // Set horizontal and vertical gaps to 0
        
        // First panel for the header and content
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(115, 12, 12));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // No border (padding) around the panel

        String headerText = "<html><div style='width: 216px; text-align: center;'>ganyan po ba ang tono ng mga nagtatanong maem?</div></html>";
        JLabel header = new JLabel(headerText, SwingConstants.CENTER);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Montserrat", Font.BOLD, 19));
        header.setBorder(BorderFactory.createEmptyBorder(25, 19, 0, 19));

        String contentText = "<html><div style='width: 216px; text-align: center;'>This app is exclusive to PUPians only! By uploading your Certificate of Registration, you are  <u>confirming and verifying</u> that you are an <u> official PUP student.</u> <br> <br> oh edi special ka niyan ngayon? gets na ba baks? end call ko na to.</div></html>";
        JLabel content = new JLabel(contentText, SwingConstants.CENTER);
        content.setForeground(Color.WHITE);
        content.setFont(new Font("Montserrat", Font.PLAIN, 14));
        content.setBorder(BorderFactory.createEmptyBorder(13, 19, 10, 19));

        // Add header and content to the first panel
        panel.add(header);
        panel.add(content);
        
        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.HORIZONTAL); // Set to horizontal divider
        separator.setBackground(Color.WHITE); // Divider color (white)
        separator.setPreferredSize(new Dimension(getWidth(), 2)); // Set divider thickness
        
        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center the button within the panel
        buttonPanel.setBackground(new Color(115, 12, 12)); // Set the buttonPanel's background to match the frame color
//        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // No border (padding) around the panel

        // Transparent button
        JButton button = new JButton("okay, gets!");
        button.setBackground(new Color(115, 12, 12));
        button.setFont(new Font("Montserrat", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);

        // Add ActionListener to the button to close the frame
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the frame when button is pressed
            }
        });

        // Add the button to the button panel
        buttonPanel.add(button);

        // Add both panels and the separator to the frame
        getContentPane().add(panel, BorderLayout.NORTH); // First panel at the top
        getContentPane().add(separator, BorderLayout.CENTER); // Add the separator divider
        getContentPane().add(buttonPanel, BorderLayout.SOUTH); // Button panel at the bottom

        setVisible(true);

       
    }
}
