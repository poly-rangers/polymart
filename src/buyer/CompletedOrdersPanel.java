package buyer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import misc.CustomScrollBar;
import misc.CustomTableModel;

public class CompletedOrdersPanel extends JPanel {
	private JTable tblCompletedOrders;
    private CustomTableModel tableModel;
    
	public CompletedOrdersPanel() {
		setLayout(null);
        setBackground(Color.WHITE);
        setBounds(0, -19, 414, 500);
        
        //Create JScrollPane for the content
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBar());
        scrollPane.setBounds(23, 40, 370, 439);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setBorder(null);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane);
        
        String[] columnNames = {"Date", "Shop Name",  "Item", "Qty",  "Price"};
        Object[][] data = convertToTableData(mockDatabase()); //MOCK DATABASE ONLY !! CHANGE ONCE DATABASE IS AVAILABLE
        CustomTableModel model = new CustomTableModel(data, columnNames); 
        tblCompletedOrders = new JTable(model);
        tblCompletedOrders.setShowVerticalLines(false);
        tblCompletedOrders.setShowHorizontalLines(false);
        tblCompletedOrders.setRowSelectionAllowed(false);
        tblCompletedOrders.setGridColor(new Color(255, 255, 255));
        tableModel = model;
        tblCompletedOrders.setFont(new Font("Montserrat Light", Font.PLAIN, 10));
        
        //Formatting the table header
        JTableHeader header = tblCompletedOrders.getTableHeader();
        header.setFont(new Font("Montserrat", Font.BOLD, 10));
        header.setBackground(Color.WHITE);
        header.setForeground(new Color(0x730C0C));
        header.setBorder(BorderFactory.createEmptyBorder());
        header.setPreferredSize(new Dimension(header.getWidth(), 15));
        
        //Format the table
        tblCompletedOrders.setBorder(null);
        tblCompletedOrders.setShowGrid(false);
        tblCompletedOrders.setIntercellSpacing(new Dimension(0, 4));
        tblCompletedOrders.setRowHeight(30);
        tblCompletedOrders.setBackground(new Color(255, 255, 255));
        tblCompletedOrders.setBackground(Color.WHITE);
        tblCompletedOrders.setModel(tableModel);
        scrollPane.setViewportView(tblCompletedOrders);
        
        //Resize the columns
     // "Date", "Shop Name",  "Item", "Qty",  "Price"
        TableColumnModel columnModel = tblCompletedOrders.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(70);  
        columnModel.getColumn(1).setPreferredWidth(250);  
        columnModel.getColumn(2).setPreferredWidth(120); 
        columnModel.getColumn(3).setPreferredWidth(30); 
        columnModel.getColumn(4).setPreferredWidth(80);  
        
        //Center Align the contents of the columns
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        columnModel.getColumn(0).setCellRenderer(centerRenderer); 
        columnModel.getColumn(1).setCellRenderer(centerRenderer); 
        columnModel.getColumn(2).setCellRenderer(centerRenderer); 
        columnModel.getColumn(3).setCellRenderer(centerRenderer); 
        columnModel.getColumn(4).setCellRenderer(centerRenderer); 
        
        tblCompletedOrders.getColumnModel().getColumn(0).setResizable(false);
        tblCompletedOrders.getColumnModel().getColumn(1).setResizable(false);
        tblCompletedOrders.getColumnModel().getColumn(2).setResizable(false);
        tblCompletedOrders.getColumnModel().getColumn(3).setResizable(false);
        tblCompletedOrders.getColumnModel().getColumn(4).setResizable(false);
       
        tblCompletedOrders.getTableHeader().setReorderingAllowed(false);

        
        updateCompleteOrderTable();
	}
	
	
	//MOCK DATABASE !! REPLACE IF SQLITE DATABASE IS AVAILABLE
	
	private void updateCompleteOrderTable() {
        List<OrderItem> items = mockDatabase();
        
        // Clear existing rows
        tableModel.setRowCount(0);
        
        // Add rows to the table model
        for (OrderItem item : items) {
            Object[] row = { item.date, item.shopName, item.itemName, item.quantity,  item.price };
            tableModel.addRow(row);
        }
    }
	 class OrderItem {
		 	String date;
	        String itemName;
	        String shopName;
	        int quantity;
	        double price;

	        public OrderItem(String date, String shopName, String itemName, int quantity,   int price) {
	            this.date = date;
	        	this.itemName = itemName;
	            this.quantity = quantity;
	            this.shopName = shopName;
	            this.price = price;
	        }
	    }

	    
	    private Object[][] convertToTableData(List<OrderItem> items) {
	        Object[][] data = new Object[items.size()][5]; 
	        for (int i = 0; i < items.size(); i++) {
	            OrderItem item = items.get(i);
	            data[i][0] = item.date;
	            data[i][1] = item.quantity;
	            data[i][2] = item.itemName;
	            data[i][3] = item.shopName; // Replace with actual shop name if available
	            data[i][4] = item.price;
	        }
	        return data;
	    }


	    private List<OrderItem> mockDatabase() {
	        List<OrderItem> items = new ArrayList<>();
	        items.add(new OrderItem("01/05/25", "Shop Name", "Item 1", 2, 21));
	        items.add(new OrderItem("01/05/25", "Shop Name", "Item 1", 2, 21));
	        items.add(new OrderItem("01/05/25", "Shop Name", "Item 1", 2, 21));
	        items.add(new OrderItem("01/05/25", "Shop Name", "Item 1", 2, 21));
	        items.add(new OrderItem("01/05/25", "Shop Name", "Item 1", 2, 21));
	        
	      
	        return items;
	    }
}