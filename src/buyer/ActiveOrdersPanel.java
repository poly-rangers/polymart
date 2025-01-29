package buyer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import misc.CustomScrollBar;
import misc.CustomTableModel;


public class ActiveOrdersPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable tblActiveOrders;
    private CustomTableModel tableModel;
    private List<OrderItem> orders;
    private JLabel lblNoOrders;

    public ActiveOrdersPanel() {
    	setLayout(null);
        setBackground(Color.WHITE);
        setBounds(0, -19, 414, 500);
        
        lblNoOrders = new JLabel("No Active Orders");
        lblNoOrders.setBounds(131, 217, 150, 20);
        lblNoOrders.setVerticalAlignment(JLabel.CENTER);
        lblNoOrders.setHorizontalAlignment(JLabel.CENTER);
        lblNoOrders.setFont(new Font("Montserrat", Font.PLAIN, 16));
        lblNoOrders.setVisible(false); // Initially hidden
        add(lblNoOrders);
        
        //Create JScrollPane for the content
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setFont(new Font("Montserrat Light", Font.PLAIN, 10));
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBar());
        scrollPane.setBounds(10, 40, 394, 439);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setBorder(null);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);
        
        String[] columnNames = {"Date", "Location", "Time", "Shop", "Item", "Price"};
        Object[][] data = convertToTableData(mockDatabase()); //MOCK DATABASE ONLY !! CHANGE ONCE DATABASE IS AVAILABLE
        CustomTableModel model = new CustomTableModel(data, columnNames); 
        tblActiveOrders = new JTable(model);
        tblActiveOrders.setShowVerticalLines(false);
        tblActiveOrders.setShowHorizontalLines(false);
        tblActiveOrders.setRowSelectionAllowed(false);
        tblActiveOrders.setGridColor(new Color(255, 255, 255));
        tableModel = model;
        tblActiveOrders.setFont(new Font("Montserrat Light", Font.PLAIN, 10));
        
        //Formatting the table header
        JTableHeader header = tblActiveOrders.getTableHeader();
        header.setFont(new Font("Montserrat", Font.BOLD, 10));
        header.setBackground(Color.WHITE);
        header.setForeground(new Color(0x730C0C));
        header.setBorder(BorderFactory.createEmptyBorder());
        header.setPreferredSize(new Dimension(header.getWidth(), 15));
        
        //Format the table
        tblActiveOrders.setBorder(null);
        tblActiveOrders.setShowGrid(false);
        tblActiveOrders.setIntercellSpacing(new Dimension(0, 4));
        tblActiveOrders.setRowHeight(30);
        tblActiveOrders.setBackground(new Color(255, 255, 255));
        tblActiveOrders.setBackground(Color.WHITE);
        tblActiveOrders.setModel(tableModel);
        
        
        //Resize the columns
        TableColumnModel columnModel = tblActiveOrders.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(80);  
        columnModel.getColumn(1).setPreferredWidth(150); 
        columnModel.getColumn(2).setPreferredWidth(80); 
        columnModel.getColumn(3).setPreferredWidth(150);  
        columnModel.getColumn(4).setPreferredWidth(150); 
        columnModel.getColumn(5).setPreferredWidth(70); 
        

        
        //Center Align the contents of the columns
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        columnModel.getColumn(0).setCellRenderer(centerRenderer); 
        columnModel.getColumn(1).setCellRenderer(centerRenderer); 
        columnModel.getColumn(2).setCellRenderer(centerRenderer); 
        columnModel.getColumn(3).setCellRenderer(centerRenderer); 
        columnModel.getColumn(4).setCellRenderer(centerRenderer); 
        columnModel.getColumn(5).setCellRenderer(centerRenderer); 

        
        tblActiveOrders.getColumnModel().getColumn(0).setResizable(false);
        tblActiveOrders.getColumnModel().getColumn(1).setResizable(false);
        tblActiveOrders.getColumnModel().getColumn(2).setResizable(false);
        tblActiveOrders.getColumnModel().getColumn(3).setResizable(true);
        tblActiveOrders.getColumnModel().getColumn(4).setResizable(true);
        tblActiveOrders.getColumnModel().getColumn(5).setResizable(true);
        
        tblActiveOrders.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(tblActiveOrders);
        
        updateCompleteOrderTable();
        
    }
	
	//MOCK DATABASE !! REPLACE IF SQLITE DATABASE IS AVAILABLE
	
	private void updateCompleteOrderTable() {
        List<OrderItem> items = mockDatabase();
        
        // Clear existing rows
        tableModel.setRowCount(0);
        
        if (items.isEmpty()) {
        	lblNoOrders.setVisible(true);
        } else {
        	lblNoOrders.setVisible(false); 
        }
        
        
        // Add rows to the table model
        for (OrderItem item : items) {
            Object[] row = { item.date, item.location, item.time, item.shopName, item.itemName, item.price };
            tableModel.addRow(row);
        }
        
        
    }
	 class OrderItem {
		 	String date;
		 	String location;
		 	String time;
	        String itemName;
	        String shopName;
	        double price;

	        public OrderItem(String date, String location, String time, String shopName, String itemName, double price) {
	            this.date = date;
	            this.location = location;
	            this.time = time;
	            this.shopName = shopName;
	        	this.itemName = itemName;
	            this.price = price;
	        }
	    }

	 //"Date", "Location", "Time", "Shop", "Item", "Price"
	 
	    private Object[][] convertToTableData(List<OrderItem> items) {
	        Object[][] data = new Object[items.size()][6]; 
	        for (int i = 0; i < items.size(); i++) {
	            OrderItem item = items.get(i);
	            data[i][0] = item.date;
	            data[i][1] = item.location;  
	            data[i][2] = item.time;      
	            data[i][3] = item.shopName;    
	            data[i][4] = item.itemName;
	            data[i][5] = item.price;
	        }
	        return data;
	    }


	    private List<OrderItem> mockDatabase() {
	        List<OrderItem> items = new ArrayList<>();
	        items.add(new OrderItem("01/05/25", "Lagoon", "10:00AM", "Shop", "Cookie", 50.00));
	        items.add(new OrderItem("01/05/25", "Lagoon", "10:00AM", "Shop", "Cookie", 50.00));
	        items.add(new OrderItem("01/05/25", "Lagoon", "10:00AM", "A", "Cookie", 50.00));
	        items.add(new OrderItem("01/05/25", "Lagoon", "10:00AM", "Cooie", "Cookie", 50.00));
	        items.add(new OrderItem("01/05/25", "Lagoon", "10:00AM", "Cooie", "Cookie", 50.00));
	        items.add(new OrderItem("01/05/25", "Lagoon", "10:00AM", "Cooie", "Cookie", 50.00));
	        
	        return items;
	    }
}