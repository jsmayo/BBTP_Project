package edu.ncsu.csc216.bbtp.ui;

import java.awt.*;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 * A JPanel of buttons for the TestingTypeTab and TestCaseTab objects.
 * 
 * @author David R. Wright
 * @author Sarah Heckman
 */
public class EditButtonPanel extends JPanel {
    /** Serial version UID */
    private static final long serialVersionUID = 2424320044323956092L;

    /** Add button */
    private JButton btnAdd;
    /** Save button */
    private JButton btnSave;
    /** Cancel button */
    private JButton btnCancel;

    /**
     * Creates the panel of buttons using a BoxLayout.
     */
    public EditButtonPanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        add(Box.createHorizontalGlue());
        add(getAddButton());
        add(Box.createRigidArea(new Dimension(10, 0)));
        add(getSaveButton());
        add(Box.createRigidArea(new Dimension(10, 0)));
        add(getCancelButton());
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    }

    /**
     * Returns the add button
     * 
     * @return the add button
     */
    public JButton getAddButton() {
        if (null == btnAdd) {
            btnAdd = new JButton("Add");
            btnAdd.setVerticalTextPosition(AbstractButton.CENTER);
            btnAdd.setHorizontalTextPosition(AbstractButton.CENTER);
            // Sets the action command to add - this is used in
            // TestingTypeTab.actionPerformed.
            btnAdd.setActionCommand("add");
            btnAdd.setEnabled(false);
        }
        return btnAdd;
    }

    /**
     * Returns the save button
     * 
     * @return the save button
     */
    public JButton getSaveButton() {
        if (null == btnSave) {
            btnSave = new JButton("Save");
            btnSave.setVerticalTextPosition(AbstractButton.CENTER);
            btnSave.setHorizontalTextPosition(AbstractButton.CENTER);
            // Sets the action command to save - this is used in
            // TestingTypeTab.actionPerformed.
            btnSave.setActionCommand("save");
            btnSave.setEnabled(false);
        }
        return btnSave;
    }

    /**
     * Returns the cancel button
     * 
     * @return the cancel button
     */
    public JButton getCancelButton() {
        if (null == btnCancel) {
            btnCancel = new JButton("Cancel");
            btnCancel.setVerticalTextPosition(AbstractButton.CENTER);
            btnCancel.setHorizontalTextPosition(AbstractButton.CENTER);
            // Sets the action command to cancel - this is used in
            // TestingTypeTab.actionPerformed.
            btnCancel.setActionCommand("cancel");
            btnCancel.setEnabled(false);
        }
        return btnCancel;
    }
}
