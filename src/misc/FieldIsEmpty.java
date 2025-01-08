package misc;

import javax.swing.JTextField;
import javax.swing.JFrame;
import frames.EmptyFieldAlert;

public class FieldIsEmpty implements ErrorHandler {
    private JTextField field;
    private String placeholder;

    public FieldIsEmpty(JTextField field, String placeholder) {
        this.field = field;
        this.placeholder = placeholder;
    }
    
    @Override
    public boolean validate() {
        // Check if the field is not empty and doesn't contain the placeholder text
        String text = field.getText().trim();
        return !text.isEmpty() && !text.equals(placeholder);
    }

    @Override
    public void showAlert(java.awt.Component parent) {
        if (parent instanceof JFrame) {
            // Pass the parent as a JFrame to EmptyFieldAlert
            new EmptyFieldAlert((JFrame) parent);
        } else {
            // Handle the case where parent is not a JFrame (optional)
            System.err.println("Parent is not an instance of JFrame.");
        }
    }
}
