package SignUp_Page;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class userSignUp {

    private JFrame frmPolymart;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField txtEmailOrPhone;
    private JPasswordField password;
    private JLabel chooseFile;
    private JLabel questionLink;
    private JTextField userName;
    private JButton signUp;
    private JButton btnNewButton;
    private JButton btnNewButton_1;


    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        EventQueue.invokeLater(() -> {
            try {
                userSignUp window = new userSignUp();
                window.frmPolymart.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public userSignUp() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
    	frmPolymart = new JFrame();
    	frmPolymart.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Hanna\\Desktop\\University\\2nd Year\\Object Oriented Programming\\Mini Hackaton\\Prototype1\\PolyPup.png"));
    	frmPolymart.setTitle("PolyMart");
    	frmPolymart.setBounds(100, 100, 430, 757);
    	frmPolymart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frmPolymart.setResizable(false);
    	frmPolymart.getContentPane().setBackground(Color.WHITE);
    	SpringLayout springLayout = new SpringLayout();
    	frmPolymart.getContentPane().setLayout(springLayout);

    	// Header Panel
    	JPanel headerPanel = new JPanel();
    	headerPanel.setBackground(Color.WHITE);
    	headerPanel.setLayout(new SpringLayout());

    	frmPolymart.getContentPane().add(headerPanel, BorderLayout.NORTH);

    	// Content Panel
    	JPanel contentPanel = new JPanel();
    	contentPanel.setBackground(Color.WHITE);
    	contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
    	contentPanel.setFont(new Font("Montserrat", Font.BOLD, 50));

    	// Add the content panel to the CENTER
    	frmPolymart.getContentPane().add(contentPanel, BorderLayout.CENTER);
    	JLabel label = new JLabel("Sign Up");
    	springLayout.putConstraint(SpringLayout.WEST, label, 50, SpringLayout.WEST, frmPolymart.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, label, -572, SpringLayout.SOUTH, frmPolymart.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, label, 181, SpringLayout.WEST, frmPolymart.getContentPane());
    	frmPolymart.getContentPane().add(label);
    	label.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 24));
    	
    	JLabel headerTitle = new JLabel("POLYMART");
    	springLayout.putConstraint(SpringLayout.NORTH, headerTitle, 35, SpringLayout.NORTH, frmPolymart.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, headerTitle, 10, SpringLayout.WEST, frmPolymart.getContentPane());
    	springLayout.putConstraint(SpringLayout.NORTH, label, 36, SpringLayout.SOUTH, headerTitle);
    	headerTitle.setIcon(new ImageIcon("C:\\Users\\Hanna\\Desktop\\University\\2nd Year\\Object Oriented Programming\\Mini Hackaton\\Prototype1\\PolyPupMini.png"));
    	headerTitle.setForeground(new Color(0x730C0C));
    	headerTitle.setFont(new Font("Montserrat ExtraBold", Font.PLAIN, 15));
    	frmPolymart.getContentPane().add(headerTitle);
    	
    	firstName = new JTextField();
    	springLayout.putConstraint(SpringLayout.NORTH, firstName, 45, SpringLayout.SOUTH, label);
    	springLayout.putConstraint(SpringLayout.WEST, firstName, 85, SpringLayout.WEST, frmPolymart.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, firstName, -94, SpringLayout.EAST, frmPolymart.getContentPane());
    	firstName.setText("First Name");
    	firstName.setColumns(10);
    	firstName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
    	frmPolymart.getContentPane().add(firstName);
    	
    	lastName = new JTextField();
    	springLayout.putConstraint(SpringLayout.WEST, lastName, 85, SpringLayout.WEST, frmPolymart.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, lastName, -94, SpringLayout.EAST, frmPolymart.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, firstName, -14, SpringLayout.NORTH, lastName);
    	springLayout.putConstraint(SpringLayout.NORTH, lastName, 240, SpringLayout.NORTH, frmPolymart.getContentPane());
    	lastName.setText("Last Name");
    	lastName.setColumns(10);
    	lastName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
    	frmPolymart.getContentPane().add(lastName);
    	
    	txtEmailOrPhone = new JTextField();
    	springLayout.putConstraint(SpringLayout.WEST, txtEmailOrPhone, 85, SpringLayout.WEST, frmPolymart.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, txtEmailOrPhone, -94, SpringLayout.EAST, frmPolymart.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, lastName, -14, SpringLayout.NORTH, txtEmailOrPhone);
    	springLayout.putConstraint(SpringLayout.NORTH, txtEmailOrPhone, 275, SpringLayout.NORTH, frmPolymart.getContentPane());
    	txtEmailOrPhone.setText("Email or Phone");
    	txtEmailOrPhone.setColumns(10);
    	txtEmailOrPhone.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
    	frmPolymart.getContentPane().add(txtEmailOrPhone);
    	
    	password = new JPasswordField();
    	springLayout.putConstraint(SpringLayout.WEST, password, 85, SpringLayout.WEST, frmPolymart.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, password, -94, SpringLayout.EAST, frmPolymart.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, txtEmailOrPhone, -10, SpringLayout.NORTH, password);
    	springLayout.putConstraint(SpringLayout.NORTH, password, 313, SpringLayout.NORTH, frmPolymart.getContentPane());
    	password.setText("Password");
    	password.setColumns(10);
    	password.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
    	frmPolymart.getContentPane().add(password);
    	
    	JLabel lblNewLabel = new JLabel("Upload your Certificate of Registration (COR)");
    	springLayout.putConstraint(SpringLayout.SOUTH, password, -23, SpringLayout.NORTH, lblNewLabel);
    	springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 369, SpringLayout.NORTH, frmPolymart.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 62, SpringLayout.WEST, frmPolymart.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -63, SpringLayout.EAST, frmPolymart.getContentPane());
    	lblNewLabel.setForeground(new Color(0x730C0C));
    	lblNewLabel.setFont(new Font("Montserrat Medium", Font.ITALIC, 12));
    	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	frmPolymart.getContentPane().add(lblNewLabel);
    	
    	chooseFile = new JLabel("Choose file or drop here");
    	springLayout.putConstraint(SpringLayout.NORTH, chooseFile, 6, SpringLayout.SOUTH, lblNewLabel);
    	springLayout.putConstraint(SpringLayout.WEST, chooseFile, 82, SpringLayout.WEST, frmPolymart.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, chooseFile, -242, SpringLayout.SOUTH, frmPolymart.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, chooseFile, -75, SpringLayout.EAST, frmPolymart.getContentPane());
    	chooseFile.setForeground(UIManager.getColor("Button.darkShadow"));
    	chooseFile.setHorizontalAlignment(SwingConstants.CENTER);
    	chooseFile.setFont(new Font("Montserrat Medium", Font.ITALIC, 14)); // Default font
    	chooseFile.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.LIGHT_GRAY));
    	
    	
    	frmPolymart.getContentPane().add(chooseFile);
    	
    	questionLink = new JLabel("Why do I need this?");
    	springLayout.putConstraint(SpringLayout.NORTH, questionLink, 6, SpringLayout.SOUTH, chooseFile);
    	springLayout.putConstraint(SpringLayout.WEST, questionLink, 151, SpringLayout.WEST, frmPolymart.getContentPane());
    	questionLink.setHorizontalAlignment(SwingConstants.CENTER);
    	questionLink.setForeground(UIManager.getColor("Button.darkShadow"));
    	questionLink.setFont(new Font("Montserrat Medium", Font.ITALIC, 10));
    	questionLink.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
    	frmPolymart.getContentPane().add(questionLink);
    	
    	JCheckBox chckbxNewCheckBox = new JCheckBox("Agree to our Terms & Conditions and Privacy Policy");
    	springLayout.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox, 16, SpringLayout.SOUTH, questionLink);
    	springLayout.putConstraint(SpringLayout.WEST, chckbxNewCheckBox, 0, SpringLayout.WEST, lblNewLabel);
    	springLayout.putConstraint(SpringLayout.EAST, chckbxNewCheckBox, -55, SpringLayout.EAST, frmPolymart.getContentPane());
    	chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
    	chckbxNewCheckBox.setFont(new Font("Montserrat Medium", Font.PLAIN, 10));
    	frmPolymart.getContentPane().add(chckbxNewCheckBox);
    	
    	userName = new JTextField();
    	springLayout.putConstraint(SpringLayout.NORTH, userName, 19, SpringLayout.SOUTH, label);
    	springLayout.putConstraint(SpringLayout.WEST, userName, 85, SpringLayout.WEST, frmPolymart.getContentPane());
    	springLayout.putConstraint(SpringLayout.SOUTH, userName, -5, SpringLayout.NORTH, firstName);
    	springLayout.putConstraint(SpringLayout.EAST, userName, -94, SpringLayout.EAST, frmPolymart.getContentPane());
    	userName.setText("Username");
    	userName.setColumns(10);
    	userName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
    	frmPolymart.getContentPane().add(userName);
    
    	
    	JButton signUpButton = new JButton("Sign Up");
    	springLayout.putConstraint(SpringLayout.NORTH, signUpButton, 21, SpringLayout.SOUTH, chckbxNewCheckBox);
    	springLayout.putConstraint(SpringLayout.WEST, signUpButton, 10, SpringLayout.WEST, lblNewLabel);
    	springLayout.putConstraint(SpringLayout.SOUTH, signUpButton, 65, SpringLayout.SOUTH, chckbxNewCheckBox);
    	springLayout.putConstraint(SpringLayout.EAST, signUpButton, 0, SpringLayout.EAST, lblNewLabel);
    	signUpButton.setBackground(new Color(128, 0, 0));
    	signUpButton.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 16));
    	signUpButton.setForeground(Color.WHITE); // White text
    	signUpButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
    	signUpButton.setFocusable(true);
    	frmPolymart.getContentPane().add(signUpButton);
    	
    	JLabel haveAccount = new JLabel("Already have an account?");
    	springLayout.putConstraint(SpringLayout.NORTH, haveAccount, 6, SpringLayout.SOUTH, signUpButton);
    	springLayout.putConstraint(SpringLayout.WEST, haveAccount, 135, SpringLayout.WEST, frmPolymart.getContentPane());
    	haveAccount.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
    	frmPolymart.getContentPane().add(haveAccount);
    	
    	JButton signIn = new JButton("Sign in here");
    	springLayout.putConstraint(SpringLayout.NORTH, signIn, 6, SpringLayout.SOUTH, haveAccount);
    	springLayout.putConstraint(SpringLayout.WEST, signIn, 174, SpringLayout.WEST, frmPolymart.getContentPane());
    	signIn.setForeground(new Color(0x730C0C));
    	signIn.setFont(new Font("Montserrat SemiBold", Font.ITALIC, 10));
    	signIn.setFocusable(false);
    	signIn.setOpaque(false);
    	signIn.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0x730C0C)));
    	frmPolymart.getContentPane().add(signIn);
    	
    	
    	
    	frmPolymart.setVisible(true);

    }
}
