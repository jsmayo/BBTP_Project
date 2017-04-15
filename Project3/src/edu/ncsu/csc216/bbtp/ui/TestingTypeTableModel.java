package edu.ncsu.csc216.bbtp.ui;

import javax.swing.table.AbstractTableModel;

/**
 * TestingTypeTableModel is a wrapper for the information in TestingTypeList
 * that can be used by a JTable.
 * 
 * @author David R. Wright
 * @author Sarah Heckman
 * @author Jessica Young Schmidt
 */
class TestingTypeTableModel extends AbstractTableModel {
    /** Serial version UID */
    private static final long serialVersionUID = 5954551753060998701L;

    /** Names for each of the columns in the TableModel */
    private String[] colNames = { "ID", "Testing Type Name", "Testing Type Description" };
    /** Array of TestingTypeList information */
    private Object[][] data;

    /**
     * Creates the model from the given data.
     * 
     * @param data the data to populate the TableModel
     */
    public TestingTypeTableModel(Object[][] data) {
        super();
        this.data = data;
    }

    /**
     * Returns the number of rows in the data.
     * 
     * @return the number of rows in the data
     */
    public int getRowCount() {
        return data.length;
    }

    /**
     * Returns the number of columns in the data.
     * 
     * @return the number of columns in the data
     */
    public int getColumnCount() {
        return colNames.length;
    }

    /**
     * Returns the column name at the given index.
     * 
     * @param col the index for finding the column name
     * @return the column name at the given index
     */
    public String getColumnName(int col) {
        return colNames[col];
    }

    /**
     * Returns the value at the given cell in the TableModel.
     * 
     * @param row the index for the row
     * @param col the index for the column
     * @return the value in the data at the given row and col
     */
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    /**
     * Sets the value to the given cell in the TableModel.
     * 
     * @param value the value to set
     * @param row the index for the row
     * @param col the index for the column
     */
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }

    /**
     * Returns the TestingTypeData object associated with the given row in the
     * TableModel.
     * 
     * @param row the TestingTypeData to return
     * @return the TestingTypeData for the given row
     */
    public TestingTypeData getTestingTypeRowData(int row) {
        return new TestingTypeData((String) data[row][0], (String) data[row][1], (String) data[row][2]);
    }

    /**
     * Sets the given row with the provided TestingTypeData.
     * 
     * @param d TestingTypeData to set in the row
     * @param row the row to set
     */
    public void setTestingTypeData(TestingTypeData d, int row) {
        setValueAt(d.getTestingTypeID(), row, 0);
        setValueAt(d.getTestingTypeName(), row, 1);
        setValueAt(d.getTestingTypeDesc(), row, 2);
    }

}
