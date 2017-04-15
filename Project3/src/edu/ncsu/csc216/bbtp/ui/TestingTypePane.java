/**
 * 
 */
package edu.ncsu.csc216.bbtp.ui;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.DocumentListener;

/**
 * Panel for editing Testing Type.
 * 
 * @author David R. Wright
 * @author Sarah Heckman
 * @author Jessica Young Schmidt
 */
class TestingTypePane extends JPanel {
    /** Serial version UID */
    private static final long serialVersionUID = -3960029015921432795L;

    /** Represents the current TestingType being edited */
    private TestingTypeData data;
    /** Text field for the TestingType id and TestingType name */
    private JTextField txtTestingTypeId, txtTestingTypeName;
    /** Text area for the TestingType description. */
    private JTextArea txtTestingTypeDescription;
    /** TestingTypeEditPane is in add mode - will add a new TestingType */
    private boolean isAddTestingTypeMode;
    /**
     * TestingTypeEditPane is in edit mode - will edit an existing TestingType
     */
    private boolean isEditTestingTypeMode;

    /**
     * Creates a new edit pane with an empty TestingTypeData.
     */
    public TestingTypePane() {
        this(new TestingTypeData("", "", ""));
    }

    /**
     * Creates a new edit pane with the given TestingTypeData.
     * 
     * @param data information to populate the pane with
     */
    public TestingTypePane(TestingTypeData data) {
        super();
        this.data = data;
        isAddTestingTypeMode = false;
        isEditTestingTypeMode = false;
        init();
    }

    /**
     * Initializes the TestingTypeData to the given value.
     * 
     * @param data new TestingTypeData
     */
    public void setTestingTypeData(TestingTypeData data) {
        this.data = data;
        fillFields();
    }

    /**
     * Initializes the GUI.
     */
    private void init() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.black));
        initView();
        fillFields();
    }

    /**
     * Initializes the view.
     */
    private void initView() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEADING));
        p.add(new JLabel("Testing Type ID: ", SwingConstants.LEFT));
        p.add(getTestingTypeID());
        this.add(p);
        p = new JPanel(new FlowLayout(FlowLayout.LEADING));
        p.add(new JLabel("Testing Type Name: ", SwingConstants.LEFT));
        p.add(getTestingTypeName());
        this.add(p);
        p = new JPanel(new FlowLayout(FlowLayout.LEADING));
        p.add(new JLabel("Testing Type Description: ", SwingConstants.LEFT));
        this.add(p);
        p = new JPanel(new FlowLayout(FlowLayout.LEADING));
        p.add(getTestingTypeDesc());
        this.add(p);
    }

    /**
     * Returns the text field for the txtTestingTypeId.
     * 
     * @return the text field for the txtTestingTypeId
     */
    private JTextField getTestingTypeID() {
        if (null == txtTestingTypeId) {
            txtTestingTypeId = new JTextField(10);
            txtTestingTypeId.setEditable(false);
            txtTestingTypeId.setVisible(true);
            txtTestingTypeId.setHorizontalAlignment(SwingConstants.LEFT);
        }
        return txtTestingTypeId;
    }

    /**
     * Returns the text field for the txtTestingTypeName.
     * 
     * @return the text field for the txtTestingTypeName
     */
    private JTextField getTestingTypeName() {
        if (null == txtTestingTypeName) {
            txtTestingTypeName = new JTextField(50);
            txtTestingTypeName.setEditable(false);
            txtTestingTypeName.setVisible(true);
            txtTestingTypeName.setHorizontalAlignment(SwingConstants.LEFT);
        }
        return txtTestingTypeName;
    }

    /**
     * Returns the text field for the txtTestingTypeDescription.
     * 
     * @return the text field for the txtTestingTypeDescription
     */
    private JTextArea getTestingTypeDesc() {
        if (null == txtTestingTypeDescription) {
            txtTestingTypeDescription = new JTextArea(5, 70);
            txtTestingTypeDescription.setEditable(false);
            txtTestingTypeDescription.setVisible(true);
            txtTestingTypeDescription.setLineWrap(true);
            txtTestingTypeDescription.setAutoscrolls(true);
        }
        return txtTestingTypeDescription;
    }

    /**
     * Adds the given DocumentListener to the txtTestingTypeName and
     * txtTestingTypeDescription text fields.
     * 
     * @param docListener DocumentListener to add to text fields
     */
    public void addFieldListener(DocumentListener docListener) {
        getTestingTypeName().getDocument().addDocumentListener(docListener);
        getTestingTypeDesc().getDocument().addDocumentListener(docListener);
    }

    /**
     * Fills the fields with the appropriate text from the TestingTypeData
     * field.
     */
    public void fillFields() {
        if (null == data) {
            txtTestingTypeId.setText("");
            txtTestingTypeName.setText("");
            txtTestingTypeDescription.setText("");
            txtTestingTypeName.setEditable(false);
            txtTestingTypeDescription.setEditable(false);
        } else {
            txtTestingTypeId.setText(data.getTestingTypeID());
            txtTestingTypeName.setText(data.getTestingTypeName());
            txtTestingTypeDescription.setText(data.getTestingTypeDesc());
        }
        if (isAddTestingTypeMode || isEditTestingTypeMode) {
            txtTestingTypeName.setEditable(true);
            txtTestingTypeDescription.setEditable(true);
        }

    }

    /**
     * Clears the fields by setting data to null.
     */
    public void clearFields() {
        data = null;
        fillFields();
    }

    /**
     * Returns the fields as a TestingTypeData object.
     * 
     * @return the fields as a TestingTypeData object
     */
    public TestingTypeData getFields() {
        return new TestingTypeData(getTestingTypeID().getText(), getTestingTypeName().getText(),
                getTestingTypeDesc().getText());
    }

    /**
     * Returns true if the in add mode.
     * 
     * @return true if the in add mode
     */
    public boolean isAddMode() {
        return isAddTestingTypeMode;
    }

    /**
     * Returns true if the in edit mode.
     * 
     * @return true if the in edit mode
     */
    public boolean isEditMode() {
        return isEditTestingTypeMode;
    }

    /**
     * Enables add mode and disables edit.
     */
    public void enableAdd() {
        if (!isAddTestingTypeMode) {
            isAddTestingTypeMode = true;
            isEditTestingTypeMode = false;
            clearFields();
        }
    }

    /**
     * Disables add mode.
     */
    public void disableAdd() {
        isAddTestingTypeMode = false;
        clearFields();
    }

    /**
     * Enables edit mode and disables add.
     * 
     * @param d TestingTypeData to populate the edit area with
     */
    public void enableEdit(TestingTypeData d) {
        if (!isEditTestingTypeMode) {
            isEditTestingTypeMode = true;
            isAddTestingTypeMode = false;
            data = d;
            fillFields();
        }
    }

    /**
     * Disables edit mode.
     */
    public void disableEdit() {
        isEditTestingTypeMode = false;
        clearFields();
    }

    /**
     * Returns true if the required fields are not empty.
     * 
     * @return true if the required fields are not empty
     */
    public boolean fieldsNotEmpty() {
        return getTestingTypeName().getDocument().getLength() != 0
                && getTestingTypeDesc().getDocument().getLength() != 0;
    }

}
