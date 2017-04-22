package edu.ncsu.csc216.bbtp.ui;

import java.awt.Color;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import edu.ncsu.csc216.bbtp.model.TestCaseList;

/**
 *TestCaseListPanel to contain the TestCaseList Objects. 
 *
 * @author Steven Mayo
 */
public class TestCaseListPane extends JScrollPane implements Observer, Serializable {

	private static final long serialVersionUID = -2210716111020406799L;
	private TestCaseList testCases;
	private JTable table;
	private int[] colWidths;
	private TestCaseTableModel tctm;
	
	/**
     * Creates the TestingTypeListPane that shows the TestingTypeData in a
     * table.
     * 
     * @param tcl TestCaseList of TestingCase objects
     */
	public TestCaseListPane(TestCaseList tcl) {
		super();
		this.testCases = tcl;
		// Register as an observer of TestingTypeList so that the pane is
		// updated of
		// any changes to the TestingTypeList.
		this.testCases.addObserver(this);
		this.tctm = new TestCaseTableModel(testCases.get2DArray());
		initView();
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
		return table;
	}
	
	/**
     * Initializes the view by creating the JTable (that is wrapped in
     * JScrollPane) and associating the JTable with the TestCaseTableModel.
     */
	private void initView() {
		// Associates the TestCaseTableModel with the JTable.
        // The TestCaseTableModel contains the data that the JTable will
        // display.
        table = new JTable(tctm);
        // Set up the column widths so the table will look nice.
        for (int i = 0; i < colWidths.length; i++) {
            TableColumn col = table.getColumnModel().getColumn(i);
            col.setPreferredWidth(colWidths[i]);
        }
        // Set the table so that only one row can be selected at a time.
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.setFillsViewportHeight(false);
        setViewportView(table);
        setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
    /**
     * Clears the selection.
     */
    public void clearSelection() {
        table.clearSelection();
    }
	
    /**
     * This method is called by the observed object, whenever the observed
     * object is changed. In this case, the observed object is the TestingTypeList.
     * Any changes to the TestingTypeList will lead to an update of the
     * TestingTypeTableModel.
     * 
     * @param o the observable object
     * @param arg any additional information needed about the change.
     */
    public void update(Observable o, Object arg) {
        if (o instanceof TestCaseList) {
            TestCaseList tcl = (TestCaseList) o;
            // If there is a different number of rows, create a new TestCaseTableModel
            if (tcl.size() != tctm.getRowCount()) {
                tctm = new TestCaseTableModel(tcl.get2DArray());
                table.setModel(tctm);
            } else {
                // Otherwise, just update the values directly.
                Object[][] obj = tcl.get2DArray();
                for (int i = 0; i < obj.length; i++) {
                    for (int j = 0; j < tctm.getColumnCount(); j++) {
                        tctm.setValueAt(obj[i][j], i, j);
                    }
                }
            }
        }
    }
	
	
}
