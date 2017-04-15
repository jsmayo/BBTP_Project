/**
 * 
 */
package edu.ncsu.csc216.bbtp.ui;

import java.awt.Color;

import javax.swing.*;
import javax.swing.table.*;

import edu.ncsu.csc216.bbtp.model.TestingTypeList;

import java.util.*;

/**
 * Maintains the list of TestingTypes.
 * 
 * @author David R. Wright
 * @author Sarah Heckman
 * @author Jessica Young Schmidt
 */
class TestingTypeListPane extends JScrollPane implements Observer {

    /** Serial version UID */
    private static final long serialVersionUID = 9036210048399941619L;

    /** List of TestingTypes to display */
    private TestingTypeList testingTypeList;
    /** TestingTypeTableModel which displays the list of TestingTypes */
    private TestingTypeTableModel testingTypeTableModel;
    /** Table for the TestingTypes */
    private JTable table;
    /** Widths of columns */
    private int[] colWidths = { 50, 250, 750 };

    /**
     * Creates the TestingTypeListPane that shows the TestingTypeData in a
     * table.
     * 
     * @param testingTypeList TestingTypeList of TestingType objects
     */
    public TestingTypeListPane(TestingTypeList testingTypeList) {
        super();
        this.testingTypeList = testingTypeList;
        // Register as an observer of TestingTypeList so that the pane is
        // updated of
        // any changes to the TestingTypeList.
        this.testingTypeList.addObserver(this);
        testingTypeTableModel = new TestingTypeTableModel(testingTypeList.get2DArray());
        initView();
    }

    /**
     * Clears the selection.
     */
    public void clearSelection() {
        table.clearSelection();
    }

    /**
     * Returns the TestingTypeTableModel.
     * 
     * @return the TestingTypeTableModel
     */
    public TestingTypeTableModel getTestingTypeTableModel() {
        return testingTypeTableModel;
    }

    /**
     * Returns the JTable.
     * 
     * @return the JTable
     */
    public JTable getTable() {
        return table;
    }

    /**
     * Initializes the view by creating the JTable (that is wrapped in
     * JScrollPane) and associating the JTable with the TestingTypeTableModel.
     */
    private void initView() {
        // Associates the TestingTypeTableModel with the JTable.
        // The TestingTypeTableModel contains the data that the JTable will
        // display.
        table = new JTable(testingTypeTableModel);
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
     * This method is called by the observed object, whenever the observed
     * object is changed. In this case, the observed object is the TestingTypeList.
     * Any changes to the TestingTypeList will lead to an update of the
     * TestingTypeTableModel.
     * 
     * @param o the observable object
     * @param arg any additional information needed about the change.
     */
    public void update(Observable o, Object arg) {
        if (o instanceof TestingTypeList) {
            TestingTypeList ttl = (TestingTypeList) o;
            // If there is a different number of rows, create a show new
            // TestingTypeTableModel.
            if (ttl.size() != testingTypeTableModel.getRowCount()) {
                testingTypeTableModel = new TestingTypeTableModel(ttl.get2DArray());
                table.setModel(testingTypeTableModel);
            } else {
                // Otherwise, just update the values directly.
                Object[][] arr = ttl.get2DArray();
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < testingTypeTableModel.getColumnCount(); j++) {
                        testingTypeTableModel.setValueAt(arr[i][j], i, j);
                    }
                }
            }
        }
    }

}
