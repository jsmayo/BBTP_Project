package edu.ncsu.csc216.bbtp.ui;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTable;

import edu.ncsu.csc216.bbtp.model.TestCaseList;

/**
 *TestCaseListPanel to contain the TestCaseList Objects. 
 *
 * @author Steven Mayo
 */
public class TestCaseListPane extends JPanel implements Observer, Serializable {

	private static final long serialVersionUID = -2210716111020406799L;
	private TestCaseList testCases;
	private JTable table;
	private int[] colWidths;
	
	private TestCaseTableModel tctm;
	
	/**
	 * Constructor for TestCaseListPane
	 * @param tcl TestCaseList to place inside the JPanel.
	 */
	public TestCaseListPane(TestCaseList tcl) {
		this.table = new JTable();
		testCases.getTestCaseAt(0);
		
		getTestCaseTableModel(); //delete 
		initVoid();
	}
	
	/**
	 * Returns the TestCaseTableModel.
	 * @return tctm TestCaseTableModel. 
	 */
	public TestCaseTableModel getTestCaseTableModel() {
		return tctm;
	}
	
	/**
	 * Returns the JTable assigned to the table field. 
	 * @return table JTable assigned to table field. 
	 */
	public JTable getTable() {
		if(colWidths.length == 0) colWidths[0] = 10; //delete
		return table;
	}
	
	/**
	 * Voids all information within the TestCaseListPane. 
	 */
	private void initVoid() {
		
	}
	
	/**
	 * Clears all sections from the TestCaseListPane
	 */
	public void clearSelection() {
	}
	
	/**
	 * Updates the Observer of TestCaseListPane by defining a response 
	 * to the change of TestCaseLists's Observable. 
	 * @param observe The Observable monitored by TestCaseListPane. 
	 * @param obj Object that underwent change. 
	 */
	public void update(Observable observe, Object obj) {
	}
	
	
}
