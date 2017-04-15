package edu.ncsu.csc216.bbtp.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;

import edu.ncsu.csc216.bbtp.model.TestingTypeList;
import edu.ncsu.csc216.bbtp.model.TestCase;
import edu.ncsu.csc216.bbtp.model.TestCaseList;

/**
 * Represents the tab containing the list of Test Case for a given TestCaseList
 * in the BBTP application
 * 
 * @author David R. Wright
 * @author Sarah Heckman
 * @author Jessica Young Schmidt
 */
class TestCaseTab extends JPanel implements ActionListener, ListSelectionListener, DocumentListener, ChangeListener {

    /** Serial version UID */
    private static final long serialVersionUID = 1077971879823499611L;

    /** TestCaseListPane in the tab (upper half) */
    private TestCaseListPane listPane;
    /** TestCaseEditPane in the tab (lower half) */
    private TestCaseEditPane editPane;
    /** EditButtonPanel that holds all actions for the tab */
    private EditButtonPanel buttonP;
    /** Flag if in add mode */
    private boolean addMode;
    /** Flag is in edit mode */
    private boolean editMode;
    /** TestCaseList associated with the tab */
    private TestCaseList testCaseList;

    /**
     * Constructs the TestCaseTab with the given TestCaseList and
     * TestingTypeList.
     * 
     * @param testCaseList TestCaseList for the current tab
     * @param testingTypeList TestingTypeList that will go in the EditPane
     */
    public TestCaseTab(TestCaseList testCaseList, TestingTypeList testingTypeList) {
        super();
        this.testCaseList = testCaseList;

        // Initially there is no add/edit mode because the user hasn't selected
        // an action
        addMode = false;
        editMode = false;

        // Create the TestCaseList Pane (table)
        listPane = new TestCaseListPane(testCaseList);
        // Add a ListSelectionListener to the listPane so that TestCaseTab
        // can respond to selection events.
        listPane.getTable().getSelectionModel().addListSelectionListener(this);

        // Adds the listPane to the TestCaseList as an observer. That means
        // that the listPane will be notified if the TestCaseList changes.
        this.testCaseList.addObserver(listPane);

        // Create the TestCaseEditPane (form
        editPane = new TestCaseEditPane(testingTypeList);
        // Adds a FieldListener to the editPage so that TestCaseTab can respond
        // to events in fields that are part of the TestCaseEditPane.
        editPane.addFieldListener(this);

        // Sets the layout for the tab and adds the element.
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(listPane);
        add(Box.createRigidArea(new Dimension(0, 5)), BorderLayout.CENTER);
        add(editPane);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(getButtons());
    }

    /**
     * Called when the user selects the option to add a new TestCase. Any
     * previously selected TestCase is cleared, addMode is set to true, and the
     * editPane fields are set to enabled, which allows a user to enter text.
     */
    public void addNewTestCase() {
        listPane.clearSelection();
        addMode = true;
        editPane.enableAdd();
    }

    /**
     * Called when the user selects the option to delete a selected TestCase. If
     * there is no TestCase selected, a pop-up is displayed. If a TestCase is
     * selected, the TestCase is removed from the TestCaseList, and the
     * remaining fields are reset to default (non-editing) states.
     */
    public void deleteTestCase() {
        int row = listPane.getTable().getSelectedRow();
        if (row >= 0) {
            TestCaseData d = listPane.getTestCaseTableModel().getTestCaseRowData(row);
            testCaseList.removeTestCase(d.getTestCaseID());
            editPane.clearFields();
            listPane.clearSelection();
            enableAdd(false);
            enableSave(false);
        } else {
            JOptionPane.showMessageDialog(this, "Test Case not selected.", "Test Case List Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Returns the EditButtonPanel. If the EditButtonPanel hasn't been created
     * before, The current object is added as an ActionListener to each button.
     * 
     * @return a panel of buttons for interacting with the TestCaseTab.
     */
    private EditButtonPanel getButtons() {
        if (null == buttonP) {
            buttonP = new EditButtonPanel();
            buttonP.getAddButton().addActionListener(this);
            buttonP.getSaveButton().addActionListener(this);
            buttonP.getCancelButton().addActionListener(this);
            buttonP.setVisible(true);
        }
        return buttonP;
    }

    /**
     * Disables all buttons so that the user cannot select them. Prevents users
     * from completing inappropriate actions.
     */
    private void disableButtons() {
        buttonP.getAddButton().setEnabled(false);
        buttonP.getSaveButton().setEnabled(false);
        buttonP.getCancelButton().setEnabled(false);
    }

    /**
     * Enables the TestCaseTab for adding a new TestingType if the flag is true.
     * Otherwise, the TestCaseTab is disabled for adding a new TestingType.
     * 
     * @param flag true if enabling for add
     */
    private void enableAdd(boolean flag) {
        if (flag) {
            buttonP.getAddButton().setEnabled(true);
            buttonP.getSaveButton().setEnabled(false);
            buttonP.getCancelButton().setEnabled(true);
            editPane.enableAdd();
            listPane.clearSelection();
        } else {
            addMode = false;
            disableButtons();
            editPane.disableAdd();
        }
    }

    /**
     * Enables the TestCaseTab for saving an edited TestCase if the flag is
     * true. Otherwise, the TestCaseTab is disabled for saving an edited
     * TestCase.
     * 
     * @param flag true if enabling for save
     */
    private void enableSave(boolean flag) {
        if (flag) {
            buttonP.getAddButton().setEnabled(false);
            buttonP.getSaveButton().setEnabled(true);
            buttonP.getCancelButton().setEnabled(true);
        } else {
            editMode = false;
            disableButtons();
            editPane.disableEdit();
        }
    }

    /**
     * A DocumentEvent happens when a user starts typing in the text fields. If
     * a DocumentEvent occurs, this method will enable or disable the
     * appropriate buttons depending on the mode.
     * 
     * @param e DocuementEvent from the user typing in a field in the
     *            TestCaseTab
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
     * @param e DocuementEvent from the user editing a field in TestCaseTab
     */
    public void insertUpdate(DocumentEvent e) {
        handleDocEvent(e);
    }

    /**
     * Method inherited from DocumentListener. If there's a remove,
     * handleDocEvent() is called.
     * 
     * @param e DocuementEvent from the user editing a field in TestCaseTab
     */
    public void removeUpdate(DocumentEvent e) {
        handleDocEvent(e);
    }

    /**
     * Method inherited from DocumentListener. If there's a change,
     * handleDocEvent() is called.
     * 
     * @param e DocuementEvent from the user editing a field in TestCaseTab
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
            TestCaseData d = editPane.getFields();
            if (d.tested() && !d.getCreationDateTime().before(d.getLastTestedDateTime())) {
                JOptionPane.showMessageDialog(this, "Creation date must be before last tested date.",
                        "Test Case Date Error", JOptionPane.ERROR_MESSAGE);
            } else if (d.getTestingType() == null) {
                JOptionPane.showMessageDialog(this, "Select a testing type.", "Testing Type Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                editPane.setTestCaseData(d);
                if (d.tested()) {
                    testCaseList.addTestCase(d.getDescription(), d.getTestingType(), d.getCreationDateTime(),
                            d.getExpectedResults(), d.tested(), d.getLastTestedDateTime(), d.getActualResults(),
                            d.pass());
                } else {
                    testCaseList.addTestCase(d.getDescription(), d.getTestingType(), d.getCreationDateTime(),
                            d.getExpectedResults(), d.tested(), null, d.getActualResults(), d.pass());
                }
                enableAdd(false);
                editPane.disableAdd();
            }
        } else if (editMode && e.getActionCommand().equals("save")) {
            TestCaseData d = editPane.getFields();
            if (d.tested() && !d.getCreationDateTime().before(d.getLastTestedDateTime())) {
                JOptionPane.showMessageDialog(this, "Creation date must be before last tested date.",
                        "Test Case Date Error", JOptionPane.ERROR_MESSAGE);
            } else if (d.getTestingType() == null) {
                JOptionPane.showMessageDialog(this, "Select a testing type.", "Testing Type Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                editPane.setTestCaseData(d);
                TestCase testCase = testCaseList.getTestCaseAt(testCaseList.indexOf(d.getTestCaseID()));
                testCase.setDescription(d.getDescription());
               // testCase.setTestingType(d.getTestingType());
                testCase.setCreationDateTime(d.getCreationDateTime());
                testCase.setTestedStatus(d.tested());
                testCase.setPass(d.pass());
                testCase.setLastTestedDateTime(d.getLastTestedDateTime());
                testCase.setExpectedResults(d.getExpectedResults());
                testCase.setActualResults(d.getActualResults());
                listPane.clearSelection();
                enableSave(false);
                editPane.disableEdit();
            }
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
     * Method inherited from ListSelectionListener. Anytime the user interacts
     * with the JTable that contains the TestCaseList (as represented by the
     * TestCaseTableModel), this method will be called. The method will populate
     * the TestCaseEditPane fields with the TestCase information.
     * 
     * @param e ListSelectionEvent of a user selecting a row in the table
     */
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) {
            return;
        }
        int row = listPane.getTable().getSelectedRow();
        if (row >= 0) {
            TestCaseData d = listPane.getTestCaseTableModel().getTestCaseRowData(row);
            editPane.setTestCaseData(d);
            editMode = true;
            editPane.enableEdit(d);
        } else {
            editMode = false;
        }
    }

    /**
     * Sets the state as changed for the ChangeListener.
     * 
     * @param e ChangeEvent
     */
    public void stateChanged(ChangeEvent e) {
        // Not used
    }
}