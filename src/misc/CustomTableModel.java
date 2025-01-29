package misc;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CustomTableModel extends AbstractTableModel {
    private List<Object[]> data;
    private String[] columnNames;

    public CustomTableModel(Object[][] initialData, String[] columnNames) {
        this.data = new ArrayList<>();
        for (Object[] row : initialData) {
            data.add(row);
        }
        this.columnNames = columnNames;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; // Makes all cells non-editable
    }

    public void setRowCount(int rowCount) {
        if (rowCount < data.size()) {
            // Remove excess rows
            while (data.size() > rowCount) {
                data.remove(data.size() - 1);
            }
        } else {
            // Add empty rows if necessary
            while (data.size() < rowCount) {
                Object[] emptyRow = new Object[getColumnCount()];
                data.add(emptyRow);
            }
        }
        fireTableDataChanged(); // Notify the table to refresh
    }

    public void addRow(Object[] row) {
        data.add(row);
        fireTableRowsInserted(data.size() - 1, data.size() - 1); // Notify the table to refresh the new row
    }
    
    
}