package misc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class AddProduct extends JPanel{
	private static final long serialVersionUID = 6429731752501671820L;
	public AddProduct(String strProductName, String strProductPrice) {
		
		// Panel properties
        setPreferredSize(new Dimension(173, 198));
        setMinimumSize(new Dimension(173, 198));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
        setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
       

        
        // Product picture 
        JPanel pnlPicture = new JPanel();
        pnlPicture.setBorder(new EmptyBorder(5, 10, 5, 10)); 
        pnlPicture.setBackground(Color.WHITE);
        ImageIcon productPic = new ImageIcon(this.getClass().getResource("/pastil.png"));
        JLabel pic = new JLabel(productPic);
        pnlPicture.add(pic);
        add(pnlPicture);

        // Product Information
        JPanel pnlProductInfo = new JPanel(new BorderLayout());
        pnlProductInfo.setPreferredSize(new Dimension(173, 30));
        pnlProductInfo.setBorder(new EmptyBorder(0, 10, 0, 10)); 
        pnlProductInfo.setBackground(Color.WHITE);
        
        JLabel lblProductName = new JLabel(strProductName);
        lblProductName.setFont(new Font("Montserrat", Font.BOLD, 15));

        JLabel lblProductPrice = new JLabel(strProductPrice);
        lblProductPrice.setForeground(new Color(102, 0, 0));
        lblProductPrice.setFont(new Font("Montserrat", Font.BOLD, 15));
        
        JPanel pnlRating = new JPanel();
        pnlRating.setBackground(Color.WHITE);
        
        JLabel lblRating = new JLabel("4.5");
        pnlRating.setLayout(new BorderLayout());
        lblRating.setForeground(Color.WHITE);
        lblRating.setFont(new Font("Montserrat", Font.BOLD, 10));
        lblRating.setOpaque(true);
        lblRating.setBackground(new Color(102, 0, 0));
        lblRating.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        pnlRating.add(lblRating, BorderLayout.WEST);
            
        pnlProductInfo.add(lblProductName, BorderLayout.WEST);
        pnlProductInfo.add(lblProductPrice, BorderLayout.EAST);
        pnlProductInfo.add(pnlRating, BorderLayout.SOUTH);
        
        add(pnlProductInfo);
        
        
        
    }




}