package misc;

import javax.swing.JTextField;
import javax.swing.JFrame;

import frames.CustomDialog;

public class FieldIsEmpty implements ErrorHandler {
    private JTextField txtField;
    private String strPlaceholder;

    public FieldIsEmpty(JTextField txtField, String strPlaceholder) {
        this.txtField = txtField;
        this.strPlaceholder = strPlaceholder;
    }
    
    @Override
    public boolean validateField() {
        // Check if the txtField is not empty and doesn't contain the strPlaceholder 
        String validText = txtField.getText().trim();
        return !validText.isEmpty() && !validText.equals(strPlaceholder);
    }

    @Override
    public void showAlert(java.awt.Component parentFrame) {
        if (parentFrame instanceof JFrame) {
            // Pass the parent as a JFrame to EmptyFieldAlert
        	new CustomDialog((JFrame) parentFrame, "kulang teh!", "nagmamadali ka ba baks? lagyan mo muna ng laman jusko PO", "sigi nhay'ed"); 
        } else {
            // Handle the case where parent is not a JFrame (optional)
            System.err.println("Parent is not an instance of JFrame.");
        }
    }
}
