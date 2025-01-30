package seller;
import javax.swing.*;

import misc.AddActiveOrder;
import misc.CustomScrollBar;

import java.awt.*;

public class MeetUpsPanel extends JPanel {
    protected JPanel ordersPanel, lblNoOrdersPanel;

    public MeetUpsPanel() {
        setBackground(Color.WHITE);
        setBounds(0, -19, 414, 500);
        setLayout(null);
        
        ordersPanel = new JPanel();
        ordersPanel.setLayout(new BoxLayout(ordersPanel, BoxLayout.Y_AXIS));
        ordersPanel.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 394, 463);
        scrollPane.setFont(new Font("Montserrat Light", Font.PLAIN, 10));
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBar());
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);
        
        // Header Panel
        JPanel headerPanel = new JPanel(new GridLayout(1, 6));
        headerPanel.setMaximumSize(new Dimension(32767, 30));
        headerPanel.setPreferredSize(new Dimension(414, 30));
        headerPanel.setBorder(BorderFactory.createMatteBorder(0,  0,  1,  0,  Color.LIGHT_GRAY));
        headerPanel.setBackground(Color.WHITE);
        
        String[] headers = {"Date", "Shop", "Location", "Time", "Total", "Details"};
        for (String header : headers) {
            JLabel lbl = new JLabel(header);
            lbl.setForeground(new Color(0x730C0C));
            lbl.setHorizontalAlignment(SwingConstants.CENTER);
            lbl.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 10));
            headerPanel.add(lbl);
        }
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);

        contentPanel.add(headerPanel);
        contentPanel.add(ordersPanel);
        
        scrollPane.setViewportView(contentPanel);

        createOrdersPanel();
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBar());
        scrollPane.getHorizontalScrollBar().setUI(new CustomScrollBar());
    }

    protected void createOrdersPanel() {
        ordersPanel.removeAll();
        ordersPanel.setLayout(new GridLayout(0, 1, 0, 5));
        ordersPanel.setBackground(Color.WHITE);
      
        revalidate();
        repaint();
    }


}

class ActiveMeetUps extends MeetUpsPanel {
    protected void createOrdersPanel() {
        ordersPanel.removeAll();
        ordersPanel.setLayout(new GridLayout(0, 1, 0, 5));
        
        // Adding sample orders
        ordersPanel.add(new AddActiveOrder("01/10/25", "Cooie", "Lagoon", "10:30AM", 50.0));
        ordersPanel.add(new AddActiveOrder("01/10/25", "Cooie", "Lagoon", "10:30AM", 50.0));
        ordersPanel.add(new AddActiveOrder("01/10/25", "Cooie", "Lagoon", "10:30AM", 50.0));

        // Fill empty slots to maintain layout
        int componentCount = ordersPanel.getComponentCount();
        for (int i = componentCount; i < 15; i++) {
            ordersPanel.add(new JLabel(""));
        }
        
        revalidate();
        repaint();
    }
}

class CompletedMeetUps extends MeetUpsPanel {
    protected void createOrdersPanel() {
        ordersPanel.removeAll();
        ordersPanel.setLayout(new GridLayout(0, 1, 0, 5));
        int componentCount = ordersPanel.getComponentCount();
        for (int i = componentCount; i < 15; i++) {
            ordersPanel.add(new JLabel(""));
        }

        revalidate();
        repaint();
    }
}
