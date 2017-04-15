package edu.ncsu.csc216.bbtp.ui;

/**
 * Underlying model for TestCaseTables. 
 * 
 * @author Steven Mayo
 */
public class TestCaseTableModel {

	//private static final long serialVersionUID = 5954551753060998701L;
	private String[] colNames;
	private Object[][] data;
	
	/**
	 * Constructor for TestCaseTableModel
	 * @param obj 2D Object array that holds the information of the TestCaseTable. 
	 */
	public TestCaseTableModel(Object[][] obj) {
		
	}
	
	/**
	 * Returns the number of rows of the TestCaseTable. 
	 * @return row count of the TestCaseTable. 
	 */
	public int getRowCount() {
		return -1;
	}
	
	/**
	 * Returns the number of columns for the TestCaseTable. 
	 * @return number of columns for the TestCaseTable. 
	 */
	public int getColumnCount() {
		return -1;
	}
	
	/**
	 * Returns the name assigned to the column name of the given index. 
	 * @param column Index of the name to retrieve. 
	 * @return Name of the column at the given index. 
	 */
	public String getColumnName(int column) {
		return colNames[column];
	}
	
	/**
	 * Returns the value contained within the TestCaseTable at the given row and column 
	 * number parameters. 
	 * @param row Row number.
	 * @param column Column number.
	 * @return Object stored within the given row and column numbers. 
	 */
	public Object getValueAt(int row, int column) {
		return new Object();
	}
	
	/**
	 * Sets the value to the given object at the given row and column numbers. 
	 * @param obj Object to set.
	 * @param row Row number.
	 * @param col Column number. 
	 */
	public void setValueAt(Object obj, int row, int col) {
		data[row][col] = obj;
	}
	
	/**
	 * Returns the TestCaseData object at the specified row number. 
	 * @param row Row number.
	 * @return TestCaseData object associated with the given row number.
	 */
	public TestCaseData getTestCaseRowData(int row) {
		return new TestCaseData();
	}
	
	/**
	 * Updates the Observer of TestCaseTableModel that changes were observed
	 * within the TestCaseTableModel. 
	 * @param row Row number of the TestCase that changed.
	 * @param tcd TestCaseData object of the TestCase that underwent change. 
	 */
	public void setTaskRowData(int row, TestCaseData tcd) {
	}
	
}
