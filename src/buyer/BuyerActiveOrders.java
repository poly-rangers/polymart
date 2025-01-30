package buyer;

import java.awt.GridLayout;

import misc.AddActiveOrder;
import misc.OrderListPanel;

public class BuyerActiveOrders extends OrderListPanel {
	protected void createOrdersPanel() {
        ordersPanel.removeAll();
        ordersPanel.setLayout(new GridLayout(0, 1, 0, 5));
        
        // Adding sample orders
        ordersPanel.add(new AddActiveOrder("01/10/25", "Cooie", "Lagoon", "10:30AM", 50.0));
        ordersPanel.add(new AddActiveOrder("01/10/25", "Cooie", "Lagoon", "10:30AM", 50.0));
        ordersPanel.add(new AddActiveOrder("01/10/25", "Cooie", "Lagoon", "10:30AM", 50.0));

    }
}

class BuyerCompletedOrders extends OrderListPanel {
	protected void createOrdersPanel() {
        ordersPanel.removeAll();
        ordersPanel.setLayout(new GridLayout(0, 1, 0, 5));
        
        // Adding sample orders: No orders

    }
}
