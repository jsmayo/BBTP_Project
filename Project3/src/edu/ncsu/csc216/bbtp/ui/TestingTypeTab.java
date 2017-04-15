/**
 * 
 */
package edu.ncsu.csc216.bbtp.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import edu.ncsu.csc216.bbtp.model.TestingType;
import edu.ncsu.csc216.bbtp.model.TestingTypeList;

/**
 * Represents the tab containing the list of Testing Types in the BBTP
 * application.
 * 
 * @author David R. Wright
 * @author Sarah Heckman
 * @author Jessica Young Schmidt
 */
class TestingTypeTab extends JPanel implements DocumentListener, ActionListener, ListSelectionListener {

    /** Serial version UID */
    private static final long serialVersionUID = 1077971879823499611L;

    /** TestingTypeListPane in the tab (upper half) */
    private TestingTypeListPane listPane;
    /** TestingTypePane in the tab (lower half) */
    private TestingTypePane editPane;
    /** EditButtonPanel that holds all actions for the tab */
    private EditButtonPanel editButtonPanel;
    /** Flag if in add mode */
    private boolean addMode;
    /** Flag if in edit mode */
    private boolean editMode;
    /** Reference to the BBTP TestingTypeList */
    private TestingTypeList testingTypeList;

    /**
     * Constructs the TestingTypeTab with the given TestingTypeList.
     * 
     * @param testingTypeList list of testing types to display
     */
    public TestingTypeTab(TestingTypeList testingTypeList) {
        super();
        this.testingTypeList = testingTypeList;

        // Initially there is no add/edit mode because the user hasn't selected
        // an action
        addMode = false;
        editMode = false;

        // Create the TestingTypeListPane (table)
        listPane = new TestingTypeListPane(this.testingTypeList);
        // Add a ListSelectionListener to the listPane so that TestingTypeTab
        // can respond to selection events.
        listPane.getTable().getSelectionModel().addListSelectionListener(this);

        // Creates the TestingTypePane (form)
        editPane = new TestingTypePane();
        // Adds a FieldListener to the editPane so that TestingTypeTab can
        // respond
        // to events in fields that are part of the TestingTypePane.
        editPane.addFieldListener(this);

        // Sets the layout for the tab and adds the element.
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(listPane);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(editPane);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(getButtons());
    }

    /**
     * Called when the user selects the option to add a new TestingType. Any
     * previously selected TestingType is cleared, addMode is set to true, and
     * the editPane fields are set to enabled, which allows a user to enter
     * text.
     */
    public void addNewTestingType() {
        listPane.clearSelection();
        addMode = true;
        editPane.enableAdd();
    }

    /**
     * Called when the user selects the option to delete a selected TestingType.
     * If there is no TestingType selected, a pop-up is displayed. If a
     * TestingType is selected, the TestingType is removed from the
     * TestingTypeList, and the remaining fields are reset to default
     * (non-editing) states.
     */
    public void deleteTestingType() {
        int row = listPane.getTable().getSelectedRow();
        if (row >= 0) {
            TestingTypeData d = listPane.getTestingTypeTableModel().getTestingTypeRowData(row);
            // Removing the TestingType from the model.
            testingTypeList.removeTestingType(d.getTestingTypeID());
            editPane.clearFields();
            listPane.clearSelection();
            enableAdd(false);
            enableSave(false);
        } else {
            JOptionPane.showMessageDialog(this, "Testing Type not selected.", "Testing Type List Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Returns the EditButtonPanel. If the EditButtonPanel hasn't been created
     * before, The current object is added as an ActionListener to each button.
     * 
     * @return a panel of buttons for interacting with the TestingTypeTab.
     */
    private EditButtonPanel getButtons() {
        if (null == editButtonPanel) {
            editButtonPanel = new EditButtonPanel();
            editButtonPanel.getAddButton().addActionListener(this);
            editButtonPanel.getSaveButton().addActionListener(this);
            editButtonPanel.getCancelButton().addActionListener(this);
            editButtonPanel.setVisible(true);
        }
        return editButtonPanel;
    }

    /**
     * Disables all buttons so that the user cannot select them. Prevents users
     * from completing inappropriate actions.
     */
    private void disableButtons() {
        editButtonPanel.getAddButton().setEnabled(false);
        editButtonPanel.getSaveButton().setEnabled(false);
        editButtonPanel.getCancelButton().setEnabled(false);
    }

    /**
     * Enables the TestingTypeTab for adding a new TestingType if the flag is
     * true. Otherwise, the TestingTypeTab is disabled for adding a new
     * TestingType.
     * 
     * @param flag true if enabling for add
     */
    private void enableAdd(boolean flag) {
        if (flag) {
            editButtonPanel.getAddButton().setEnabled(true);
            editButtonPanel.getSaveButton().setEnabled(false);
            editButtonPanel.getCancelButton().setEnabled(true);
            editPane.enableAdd();
            listPane.clearSelection();
        } else {
            addMode = false;
            disableButtons();
            editPane.disableAdd();
        }
    }

    /**
     * Enables the TestingTypeTab for saving an edited TestingType if the flag
     * is true. Otherwise, the TestingTypeTab is disabled for saving an edited
     * TestingType.
     * 
     * @param flag true if enabling for save
     */
    private void enableSave(boolean flag) {
        if (flag) {
            editButtonPanel.getAddButton().setEnabled(false);
            editButtonPanel.getSaveButton().setEnabled(true);
            editButtonPanel.getCancelButton().setEnabled(true);
        } else {
            editMode = false;
            disableButtons();
            editPane.disableEdit();
        }
    }

    /**
     * A DocumentEvent happens when a user starts typing in the testing type
     * name or testing type description text fields. If a DocumentEvent occurs,
     * this method will enable or disable the appropriate buttons depending on
     * the mode.
     * 
     * @param e DocuementEvent from the user typing in a field in the
     *            TestingTypeTab
     */
    private void handleDocEvent(DocumentEvent e) {
        if (editPane.fieldsNotEmpty()) {
            if (addMode) {
                enableAdd(true);
            } else if (editMode) {
                enableSave(true);
            }
        } else {
            disableButtons();
        }
    }

    /**
     * Method inherited from DocumentListener. If there's an insert,
     * handleDocEvent() is called.
     * 
     * @param e DocuementEvent from the user editing a field in TestingTypeTab
     */
    public void insertUpdate(DocumentEvent e) {
        handleDocEvent(e);
    }

    /**
     * Method inherited from DocumentListener. If there's a remove,
     * handleDocEvent() is called.
     * 
     * @param e DocuementEvent from the user editing a field in TestingTypeTab
     */
    public void removeUpdate(DocumentEvent e) {
        handleDocEvent(e);
    }

    /**
     * Method inherited from DocumentListener. If there's a change,
     * handleDocEvent() is called.
     * 
     * @param e DocuementEvent from the user editing a field in TestingTypeTab
     */
    public void changedUpdate(DocumentEvent e) {
        handleDocEvent(e);
    }

    /**
     * Method inherited from ActionListener. If there is an add, save, or cancel
     * action (which correspond to the three buttons), this method is called.
     * The model is updated (or not) depending on the action.
     * 
     * @param e ActionEvent that represents the user's interaction with the GUI.
     */
    public void actionPerformed(ActionEvent e) {
        if (addMode && e.getActionCommand().equals("add")) {
            TestingTypeData d = editPane.getFields();
            editPane.setTestingTypeData(d);
            // Updates the model by adding the new TestingType to the
            // TestingTypeList
            testingTypeList.addTestingType(d.getTestingTypeName(), d.getTestingTypeDesc());
            enableAdd(false);
            editPane.disableAdd();
        } else if (editMode && e.getActionCommand().equals("save")) {
            TestingTypeData d = editPane.getFields();
            editPane.setTestingTypeData(d);
            // Updates the model by editing the existing TestingType with the
            // new
            // information
            TestingType cat = testingTypeList.getTestingTypeAt(testingTypeList.indexOf(d.getTestingTypeID()));
            cat.setDescription(d.getTestingTypeDesc());
            cat.setName(d.getTestingTypeName());
            listPane.clearSelection();
            enableSave(false);
            editPane.disableEdit();
        } else if (e.getActionCommand().equals("cancel")) {
            editPane.clearFields();
            if (addMode) {
                enableAdd(false);
                editPane.disableAdd();
            }
            if (editMode) {
                listPane.clearSelection();
                enableSave(false);
                editPane.disableEdit();
            }
        }

    }

    /**
     * Method inherited from ListSelectionListener. Any time the user interacts
     * with the JTable that contains the TestingTypeList (as represented by the
     * TestingTypeTableModel), this method will be called. The method will
     * populate the TestingTypeEditPane fields with the TestingType information.
     * 
     * @param e ListSelectionEvent of a user selecting a row in the table
     */
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) {
            // There is not a concrete selection yet, so return.
            return;
        }
        int row = listPane.getTable().getSelectedRow();
        if (row >= 0) {
            // If there's a valid selected row, set up for editing.
            TestingTypeData d = listPane.getTestingTypeTableModel().getTestingTypeRowData(row);
            editPane.setTestingTypeData(d);
            editMode = true;
            editPane.enableEdit(d);
        } else {
            editMode = false;
        }
    }

}
