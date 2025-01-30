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

public class AddProduct extends JPanel {
	private static final long serialVersionUID = 6429731752501671820L;
	JPanel pnlPicture, pnlProductInfo, pnlRating;
	
	public AddProduct(String strProductName, String strProductPrice, String strImagePath, String rating) {
		
		// Panel properties
        setPreferredSize(new Dimension(173, 198));
        setMinimumSize(new Dimension(173, 198));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
        setBorder(new LineBorder(new Color(211, 211, 211), 1, true));
       
       
        // Product picture 
        JPanel pnlPicture = new JPanel();
        pnlPicture.setBorder(new EmptyBorder(5, 10, 5, 10)); 
        pnlPicture.setPreferredSize(new Dimension(173, 140)); 
        pnlPicture.setMaximumSize(new Dimension(173, 140));
        pnlPicture.setBackground(Color.WHITE);
        
        ImageIcon productPic = new ImageIcon(this.getClass().getResource(strImagePath));
        JLabel pic = new JLabel(productPic);
        pnlPicture.add(pic);
        add(pnlPicture);

        // Product Information
        JPanel pnlProductInfo = new JPanel();
        pnlProductInfo.setPreferredSize(new Dimension(173, 30));
        pnlProductInfo.setBorder(new EmptyBorder(0, 10, 0, 10)); 
        pnlProductInfo.setBackground(Color.WHITE);
        
        JLabel lblProductName = new JLabel(strProductName);
        lblProductName.setBounds(21, 0, 102, 27);
        lblProductName.setFont(new Font("Montserrat", Font.BOLD, 15));

        JLabel lblProductPrice = new JLabel(strProductPrice);
        lblProductPrice.setBounds(119, 0, 86, 27);
        lblProductPrice.setForeground(new Color(102, 0, 0));
        lblProductPrice.setFont(new Font("Montserrat", Font.BOLD, 15));
        
        JPanel pnlRating = new JPanel();
        pnlRating.setBounds(10, 30, 151, 20);
        pnlRating.setBackground(Color.WHITE);
        pnlRating.setLayout(null);
        
        JLabel lblRating = new JLabel(rating);
        lblRating.setHorizontalAlignment(JLabel.CENTER);
        lblRating.setBounds(10, 0, 34, 20);
        lblRating.setForeground(Color.WHITE);
        lblRating.setFont(new Font("Montserrat", Font.BOLD, 10));
        lblRating.setOpaque(true);
        lblRating.setBackground(new Color(102, 0, 0));
        lblRating.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        pnlRating.add(lblRating);
        pnlProductInfo.setLayout(null);
            
        pnlProductInfo.add(lblProductName);
        pnlProductInfo.add(lblProductPrice);
        pnlProductInfo.add(pnlRating);
        
        add(pnlProductInfo);
        
    }
}