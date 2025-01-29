package frames;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import misc.RoundedButton;

public class MeetupConfirmation extends JFrame {

    private static final long serialVersionUID = 6410724970529248217L;
    private int cornerRadius = 30;
    
    public MeetupConfirmation() {
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));  // Transparent background for smooth corners

        // Sample Data (all of this can be replaced from database)
        String username = "@nintendocicc";
        String firstname = "Julianna Leila";
        String lastname = "Castillo";
        String[] items = {
            "(50) motivation mabuhay", "(10) hope capsules", "(5) inspiration boosts",
            "(1000) kiss", "(5000) hugs", "(12345) time together", "(75) eating together", 
            "(100) studying together", "(555) cuddling", "(750) late night talks"
        };
        String price = "100000";
        String remarks = "grabe naantok na talaga ako kase parang di ko na talaga kaya i resign guys "
                       + "miss ko na talaga siya naiiyak na talaga ako what the fuck... pero alam mo teh "
                       + "crush na crush ko talaga yun... bawat ngiti at galaw tumitibok puso ko, parang humihinto "
                       + "yung oras pag kasama ko siya grabe talaga putangiansahsdkjahsdj";

        int paddingY = 10; // Space between elements
        int labelHeight = 20; // Approx height per label
        int buttonHeight = 40; // Button area

        // Compute required height dynamically
        int extraHeight = (items.length * 18) + (remarks.length() / 40) * 18;
        int totalHeight = 200 + extraHeight + buttonHeight;  // Dynamic frame height

        setSize(370, totalHeight);
        setLayout(null);

        JPanel pnlMain = new JPanel();
        pnlMain.setLayout(null);
        pnlMain.setBackground(new Color(115, 12, 12));
        pnlMain.setBounds(0, 0, getWidth(), getHeight());
        getContentPane().add(pnlMain);

        // Initial Y Position
        int currentY = 20;

        JLabel lblUsername = new JLabel("<html><b>Username:</b> " + username + "</html>");
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setFont(new Font("Montserrat", Font.PLAIN, 12));
        lblUsername.setBounds(35, currentY, 298, labelHeight);
        pnlMain.add(lblUsername);
        currentY += labelHeight + paddingY;

        JLabel lblFirstName = new JLabel("<html><b>First Name:</b> " + firstname + "</html>");
        lblFirstName.setForeground(Color.WHITE);
        lblFirstName.setFont(new Font("Montserrat", Font.PLAIN, 12));
        lblFirstName.setBounds(35, currentY, 298, labelHeight);
        pnlMain.add(lblFirstName);
        currentY += labelHeight + paddingY;

        JLabel lblLastName = new JLabel("<html><b>Last Name:</b> " + lastname + "</html>");
        lblLastName.setForeground(Color.WHITE);
        lblLastName.setFont(new Font("Montserrat", Font.PLAIN, 12));
        lblLastName.setBounds(35, currentY, 298, labelHeight);
        pnlMain.add(lblLastName);
        currentY += labelHeight + paddingY;

        // Items List
        StringBuilder itemList = new StringBuilder("<html><b>Item/s:</b><br>");
        for (String item : items) {
            itemList.append("• ").append(item).append("<br>");
        }
        itemList.append("</html>");

        JLabel lblItems = new JLabel(itemList.toString());
        lblItems.setForeground(Color.WHITE);
        lblItems.setFont(new Font("Montserrat", Font.PLAIN, 12));
        lblItems.setBounds(35, currentY, 298, items.length * 18);
        pnlMain.add(lblItems);
        currentY += (items.length * 18) + paddingY;

        JLabel lblPrice = new JLabel("<html><b>Price:</b> " + price + "</html>");
        lblPrice.setForeground(Color.WHITE);
        lblPrice.setFont(new Font("Montserrat", Font.PLAIN, 12));
        lblPrice.setBounds(35, currentY, 298, labelHeight);
        pnlMain.add(lblPrice);
        currentY += labelHeight + paddingY;

        JLabel lblRemarks = new JLabel("<html><b>Remarks:</b><br>" + remarks + "</html>");
        lblRemarks.setForeground(Color.WHITE);
        lblRemarks.setFont(new Font("Montserrat", Font.PLAIN, 12));
        lblRemarks.setBounds(35, currentY, 298, remarks.length() / 40 * 18);
        pnlMain.add(lblRemarks);
        currentY += (remarks.length() / 40 * 18) + paddingY;

        // 🔹 Buttons at the **bottom**
        int buttonY = getHeight() - buttonHeight - 20;

        RoundedButton btnComplete = new RoundedButton("<html><u><i>Complete</i></u></html>", 10);
        btnComplete.setBounds(24, buttonY, 147, 32);
        btnComplete.setForeground(new Color(115, 12, 12));
        btnComplete.setBackground(Color.WHITE);
        btnComplete.setFont(new Font("Montserrat", Font.BOLD, 12));
        btnComplete.addActionListener(e -> {
            dispose();
            CompleteConfirmation completeConfirmation = new CompleteConfirmation();
            completeConfirmation.setVisible(true);
        });
        pnlMain.add(btnComplete);

        RoundedButton btnCancel = new RoundedButton("<html><u><i>Cancel</i></u></html>", 10);
        btnCancel.setBounds(200, buttonY, 147, 32);
        btnCancel.setForeground(new Color(115, 12, 12));
        btnCancel.setBackground(Color.WHITE);
        btnCancel.setFont(new Font("Montserrat", Font.BOLD, 12));
        btnCancel.addActionListener(e -> {
            dispose();
            CancelMeetupReason cancelMeetupReason = new CancelMeetupReason();
            cancelMeetupReason.setVisible(true);
        });
        
        
        pnlMain.add(btnCancel);
        

        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Float(0, 0, getBounds().width, getBounds().height, cornerRadius, cornerRadius));
        setVisible(true);
    }
}
