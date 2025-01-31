package misc;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.*;

public class TCandPP extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JButton btnGoBack;
    private JPanel contentPane;
    private JScrollPane scrollPane;
    
    public TCandPP(JPanel contentPane) {
        this.contentPane = contentPane;

        setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        setLayout(null);

        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_buyer.icon.png"));
        Image scaledImage = originalImage.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
        JLabel startupImage = new JLabel(new ImageIcon(scaledImage));
        startupImage.setBounds(16, 24, 150, 47);
        add(startupImage);

        JPanel pnlHeader = new JPanel();
        pnlHeader.setLayout(new BoxLayout(pnlHeader, BoxLayout.X_AXIS));
        pnlHeader.setOpaque(true);
        pnlHeader.setBounds(20, 91, 56, 32);
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

        add(pnlHeader);

        // Terms & Conditions Label
        JLabel lblTermsHeader = new JLabel("<html><div style='text-align:center;'><b>Terms & Conditions<br>" +  "and Privacy Policy</b></html>");
        lblTermsHeader.setBounds(16, 88, 380, 60);
        lblTermsHeader.setForeground(Color.BLACK);
        lblTermsHeader.setFont(new Font("Montserrat", Font.BOLD, 22));
        lblTermsHeader.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblTermsHeader);

        // Load text content from a file
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader readFile = new BufferedReader(new FileReader("resources/terms_and_conditions.txt"))) {
            String strLine;
            while ((strLine = readFile.readLine()) != null) {
                contentBuilder.append(strLine).append(System.lineSeparator());
            }
        } catch (IOException ioException) {
        	ioException.printStackTrace();
        }
        JLabel lblImportContent = new JLabel("<html><div style='width:260px; text-align: justify; strLine-height: 2;'>"
                + contentBuilder.toString() + "</div></html>");

        lblImportContent.setFont(new Font("Montserrat", Font.PLAIN, 14));
        lblImportContent.setOpaque(true);
        lblImportContent.setBackground(Color.WHITE);
        lblImportContent.setBorder(new EmptyBorder(0, 0, 0, 10)); // Proper padding

        // Panel to hold the content
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Flow layout to fix spacing
        contentPanel.setBorder(null);
        contentPanel.add(lblImportContent);

        // Ensure content panel has the right size
        contentPanel.setPreferredSize(new Dimension(350, lblImportContent.getPreferredSize().height + 30));

        // ScrollPane to allow scrolling
        scrollPane = new JScrollPane(contentPanel);
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBar());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(20, 172, 376, 462);
        scrollPane.setBorder(null); // Border around scrollPane
        add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent actEvent) {
        Object objSourceEvent = actEvent.getSource();

        if (objSourceEvent == btnGoBack) {
            // Switch to BuyerProfile
            CardLayout clLayout = (CardLayout) contentPane.getLayout();
            clLayout.show(contentPane, "BuyerProfile");
        }
    }
}