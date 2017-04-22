package edu.ncsu.csc216.bbtp.ui;

import java.util.Date;

import javax.swing.table.AbstractTableModel;

import edu.ncsu.csc216.bbtp.model.TestingType;

/**
 * Underlying model for TestCaseTables. 
 * 
 * @author Steven Mayo
 */
public class TestCaseTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 5954551753060998701L;
	private String[] colNames;
	private Object[][] data;
	
	/**
	 * Creates the model from the given data.
	 * 
	 * @param obj 2D Object array that holds the information of the TestCaseTable. 
	 */
	public TestCaseTableModel(Object[][] obj) {
		super();
		this.data = obj;
		
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
	 * Returns the TestCaseData object at the specified row number. 
	 * @param row Row number.
	 * @return TestCaseData object associated with the given row number.
	 */
	public TestCaseData getTestCaseRowData(int row) {
		return new TestCaseData((String)data[row][0], (String)data[row][1], (TestingType)data[row][2], 
				(Date)data[row][3], (Date)data[row][4], (boolean)data[row][5], (String)data[row][6],
				(String)data[row][7], (boolean)data[row][8]);
	}
	
	/**
	 * Sets the TaskRow of the given row number, with data extracted  
	 * from the TestCaseData parameter.
	 * @param row Row number of the TestCase that changed.
	 * @param tcd TestCaseData object of the TestCase that underwent change. 
	 */
	public void setTaskRowData(int row, TestCaseData tcd) {
		 	setValueAt(tcd.getTestCaseID(), row, 0);
		 	setValueAt(tcd.getDescription() , row, 1);
		 	setValueAt(tcd.getTestingType() , row, 2);
		 	setValueAt(tcd.getCreationDateTime() , row, 3);
		 	setValueAt(tcd.getLastTestedDateTime() , row, 4);
		 	setValueAt(tcd.tested() , row, 5);
		 	setValueAt(tcd.getExpectedResults() , row, 6);
		 	setValueAt(tcd.getActualResults() , row, 7);
		 	setValueAt(tcd.pass() , row, 8);
	}
	
}
