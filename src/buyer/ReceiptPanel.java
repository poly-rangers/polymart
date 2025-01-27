package buyer;
import javax.swing.*;
import java.util.*;
import java.util.List;

import frames.SetMeetUpFrame;
import misc.AddProduct;
import misc.SearchBar;

import java.awt.*;
import java.awt.event.*;

public class ReceiptPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
    public ReceiptPanel(JPanel contentPane) {
    	this.contentPane = contentPane;
    	
        setBackground(Color.WHITE);
        setBounds(100, 100, 414, 660);
        setLayout(null);
        
        ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/polypup_buyer.icon.png"));
        Image resizedImage = originalImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        JLabel startupImage = new JLabel(resizedIcon);
        startupImage.setBounds(10, 10, 100, 100);
        add(startupImage);

        JLabel lblNewLabel = new JLabel("Your Receipt");
        lblNewLabel.setBounds(41, 133, 139, 24);
        lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 19));
        add(lblNewLabel);

       
        BuyerNavigationBar navBar = new BuyerNavigationBar();
        navBar.setBounds(0, 610, 414, 50);
        add(navBar);
        
        JTextArea textArea = new JTextArea();
        textArea.setBorder(null); 
        textArea.setBackground(new Color(255, 255, 255)); 
        textArea.setForeground(new Color(255, 255, 255)); 
        textArea.setEditable(false); 
        textArea.setBounds(16, 188, 372, 315); 
        add(textArea);

       
        }
    
    
    private List<OrderItem> mockDatabase(){
    	List<OrderItem> items = new ArrayList<>();
    	items.add(new OrderItem("Item 1", 1, 21));
    	items.add(new OrderItem("Item 2", 2, 52));
    	items.add(new OrderItem("Item 3", 3, 65));
    	return items;
    }
    
    private String generateReceiptText(List<OrderItem> items) {
    	StringBuilder receipt = new StringBuilder();
    	receipt.append("------------------------------------------------------\n");
        receipt.append("Order ID                             Date Placed\n");
        receipt.append("------------------------------------------------------\n");
        receipt.append(String.format("%-10s %-20s %-10s\n", "Qty", "Item", "Price"));
        receipt.append("------------------------------------------------------\n");

        int total = 0;

        // Loop through order items to add them to the receipt
        for (OrderItem item : items) {
            receipt.append(String.format("%-10d %-20s %-10d\n", 
                item.quantity, item.itemName, item.price));
            total += item.price;
        }

        receipt.append("------------------------------------------------------\n");
        receipt.append(String.format("%-30s %-10d\n", "Total", total));
        receipt.append("------------------------------------------------------\n");
        receipt.append("Seller/Shop Name (italic)\n");

        return receipt.toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Open the meet-up frame
        SetMeetUpFrame meetUpFrame = new SetMeetUpFrame();
        meetUpFrame.setVisible(true);
    }
}


class OrderItem{
	String itemName;
	int quantity;
	double price;
	
	public OrderItem(String itemName,int quantity, int price) {
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}
}








