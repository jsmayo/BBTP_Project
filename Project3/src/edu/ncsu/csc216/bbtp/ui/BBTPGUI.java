package edu.ncsu.csc216.bbtp.ui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import edu.ncsu.csc216.bbtp.*;
import edu.ncsu.csc216.bbtp.model.TestCaseList;

/**
 * BBTPGUI is the GUI for the BBTP application.
 * 
 * @author David Wright
 * @author Jessica Young Schmidt
 */
public class BBTPGUI extends JFrame implements ActionListener, WindowListener {

    /** Serial version UID */
    private static final long serialVersionUID = 48371L;

    /** Reference to the BBTP model */
    private BBTP bbtp;
    /**
     * Reference to the TabbedPane that holds the TestingTypeTab and
     * TestCaseTabs
     */
    private JTabbedPane tabbedPane;

    /** Boolean that tracks if we are opening a BBTP file */
    private boolean openFile;

    /**
     * Constructs the BBTPGUI.
     * 
     * @param b the BBTP model shown by the GUI.
     */
    public BBTPGUI(BBTP b) {
        super("BBTP");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        bbtp = b;
        openFile = false;
        initGUI();
        this.addWindowListener(this);
    }

    /**
     * Returns the BBTP instance associated with the BBTP GUI.
     * 
     * @return the BBTP instance associated with the GUI.
     */
    public BBTP getBBTP() {
        return bbtp;
    }

    /**
     * Initializes the GUI.
     */
    private void initGUI() {
        setPreferredSize(new Dimension(1000, 650));
        setJMenuBar(new BBTPMenuBar(this));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        initTabbedPane();
    }

    /**
     * Initializes the TabbedPane that contains the TestingTypeTab and a
     * TestCaseTab for each TestCaseList in the BBTP system.
     */
    private void initTabbedPane() {
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Testing Type", new TestingTypeTab(bbtp.getTestingTypeList()));
        for (int i = 0; i < bbtp.getNumTestCaseLists(); i++) {
            TestCaseList t = bbtp.getTestCaseList(i);
            tabbedPane.addTab(t.getName(), new TestCaseTab(t, bbtp.getTestingTypeList()));
        }
        tabbedPane.setSelectedIndex(1);
        if (openFile) {
            getContentPane().removeAll();
            openFile = false;
        }
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
        getContentPane().validate();
    }

    /**
     * Each command in the JMenuItem is given a number. The number determines
     * which action is taken for the given command passed in through the
     * ActionEvent.
     * 
     * @param e ActionEvent representing user's interaction with the GUI.
     */
    public void actionPerformed(ActionEvent e) {
        if (null != e.getSource() && e.getSource() instanceof JMenuItem) {
            JMenuItem source = (JMenuItem) (e.getSource());
            String cmd = source.getActionCommand();
            switch (getInt(cmd)) {
            case 11:
                doOpenFile();
                break;
            case 12:
                doSaveFile();
                break;
            case 13:
                doExit();
                break;
            case 21:
                doRenameTestCaseList();
                break;
            case 22:
                doNewTestCaseList();
                break;
            case 23:
                doDeleteTestCaseList();
                break;
            case 31:
                doAddTestCase();
                break;
            case 32:
                doDeleteTestCase();
                break;
            case 41:
                doAddTestingType();
                break;
            case 42:
                doDeleteTestingType();
                break;
            default:
                break;
            }
        }
    }

    /**
     * Provides a JFileChooser so a user can load a previous BBTP file into the
     * system.
     */
    private void doOpenFile() {
        JFileChooser chooser = new JFileChooser("./");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("BBTP files", "bbtp");
        chooser.setFileFilter(filter);
        chooser.setMultiSelectionEnabled(false);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            boolean open = bbtp.openDataFile(chooser.getSelectedFile().getName());
            if (!open) {
                JOptionPane.showMessageDialog(this, "Error opening file.", "Opening Error", JOptionPane.ERROR_MESSAGE);
            } else {
                openFile = true;
                initTabbedPane();
            }
        }
    }

    /**
     * Provides a JFileChooser so a user can select where to save their file.
     */
    private void doSaveFile() {
        JFileChooser chooser = new JFileChooser("./");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("BBTP files", "bbtp");
        chooser.setFileFilter(filter);
        chooser.setMultiSelectionEnabled(false);
        if (bbtp.getFilename() != null) {
            chooser.setSelectedFile(new File(bbtp.getFilename()));
        }
        int returnVal = chooser.showSaveDialog(this);
        boolean saved = true;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String filename = chooser.getSelectedFile().getName();
            bbtp.setFilename(filename);
            saved = bbtp.saveDataFile(filename);
        } else {
            System.out.println("CANCEL SAVE");
            saved = false;
        }
        if (!saved) {
            JOptionPane.showMessageDialog(this, "File not saved.", "Saving Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * If the BBTP has changed since the last save, the user is prompted to save
     * the BBTP.
     */
    private void doExit() {
        if (bbtp.isChanged()) {
            doSaveFile();
        }
        // BBTP either has not changed or the file was saved properly in the
        // previous if block
        if (!bbtp.isChanged()) {
            System.exit(NORMAL);
        } else { // Did NOT save when prompted to save
            JOptionPane.showMessageDialog(this,
                    "BBTP changes have not been saved. " + "You will not be able to exit until changes are saved.",
                    "Saving Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Adds a new TestCaseList to the system.
     */
    private void doNewTestCaseList() {
        int newList = bbtp.addTestCaseList();
        TestCaseList t = bbtp.getTestCaseList(newList);
        tabbedPane.addTab(t.getName(), new TestCaseTab(t, bbtp.getTestingTypeList()));
    }

    /**
     * Renames the selected TestCaseList. An error is displayed if the user
     * attempts to rename the TestingTypeList.
     */
    private void doRenameTestCaseList() {
        int tab = tabbedPane.getSelectedIndex();
        if (tabbedPane.getComponentAt(tab) instanceof TestCaseTab) {
            String newName = null; 
            boolean loop = true;
            while (loop) {
                newName = (String) JOptionPane.showInputDialog(this, "Edit the name of this Test Case List",
                        tabbedPane.getTitleAt(tab), JOptionPane.PLAIN_MESSAGE, null, null, tabbedPane.getTitleAt(tab));
                newName = newName.trim();
                if (null == newName || newName.length() == 0) {
                    JOptionPane.showMessageDialog(this, "Test Case List name cannot be empty or all whitespace.",
                            "Test Case List Error", JOptionPane.ERROR_MESSAGE);
                    newName = null;
                }
                System.out.println("newName:" + newName + ":");
                if (null != newName) {
                    bbtp.getTestCaseList(tab - 1).setName(newName);
                    tabbedPane.setTitleAt(tab, newName);
                    loop = false;
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Testing Type List cannot be renamed.", "Test Case List Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Deletes the selected TestCaseList if it is not the last TestCaseList in
     * the system. If the delete is possible, there's a confirmation of the
     * delete. If there's a problem with the delete an error message is
     * displayed.
     */
    private void doDeleteTestCaseList() {
        int tab = tabbedPane.getSelectedIndex();
        if (0 == tab) {
            JOptionPane.showMessageDialog(this, "Test Case List not selected.", "Test Case List Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (1 == bbtp.getNumTestCaseLists()) {
            JOptionPane.showMessageDialog(this, "Cannot delete last Test Case List.", "Test Case List Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            int optRes = JOptionPane.showConfirmDialog(this, "Confirm Test Case List Delete", null,
                    JOptionPane.YES_NO_OPTION);
            if (tab > 0 && JOptionPane.YES_OPTION == optRes) {
                bbtp.removeTestCaseList(tab - 1);
                tabbedPane.remove(tab);
            }
        }
    }

    /**
     * Handles adding a test case to the given TestCaseTab. If there is no
     * TestCaseList selected, an error message is displayed.
     */
    private void doAddTestCase() {
        int index = tabbedPane.getSelectedIndex();
        if (tabbedPane.getComponentAt(index) instanceof TestCaseTab) {
            ((TestCaseTab) tabbedPane.getSelectedComponent()).addNewTestCase();
        } else {
            JOptionPane.showMessageDialog(this, "Test Case List not selected.", "Test Case List Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    /**
     * Handles deleting the selected test case in the given TestCaseTab. If
     * there is no TestCaseList selected, an error message is displayed.
     */
    private void doDeleteTestCase() {
        int index = tabbedPane.getSelectedIndex();
        System.out.println(index);
        if (0 != index) {
            System.out.println("in if: " + index);
            int optRes = JOptionPane.showConfirmDialog(this, "Confirm Test Case Delete", null,
                    JOptionPane.YES_NO_OPTION);
            if (index > 0 && JOptionPane.YES_OPTION == optRes) {
                ((TestCaseTab) tabbedPane.getSelectedComponent()).deleteTestCase();
            }
        } else {
            System.out.println("in else: " + index);
            JOptionPane.showMessageDialog(this, "Test Case not selected.", "Test Case Error",
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    /**
     * Handles the add command for a TestingType.
     */
    private void doAddTestingType() {
        // Updates the tab to the TestingType tab (index 0)
        tabbedPane.setSelectedIndex(0);
        ((TestingTypeTab) tabbedPane.getSelectedComponent()).addNewTestingType();
    }

    /**
     * Handles the delete command for a TestingType. If there's no TestingType
     * selected, an error message is displayed.
     */
    private void doDeleteTestingType() {
        int index = tabbedPane.getSelectedIndex();
        if (0 != index) {
            JOptionPane.showMessageDialog(this, "Testing Type List not selected.", "Testing Type List Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            int optRes = JOptionPane.showConfirmDialog(this, "Confirm Testing Type Delete", null,
                    JOptionPane.YES_NO_OPTION);
            if (JOptionPane.YES_OPTION == optRes) {
                ((TestingTypeTab) tabbedPane.getSelectedComponent()).deleteTestingType();
            }
        }
    }

    /**
     * Helper method for converting a string to an int. Since all ints in
     * program should be positive, the method returns -1 on error.
     * 
     * @param s String to convert
     * @return integer value
     */
    private int getInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Method inherited from WindowListener. Not used in this implementation.
     * 
     * @param e WindowEvent
     */
    public void windowOpened(WindowEvent e) {
        // not interested in this event
    }

    /**
     * Method inherited from WindowListener. When the window is closing, the
     * doExit() method will be called to handle the option for saving on exit.
     * If the cancel button is pressed in the FileChooser, the program will exit
     * without saving.
     * 
     * @param e WindowEvent
     */
    public void windowClosing(WindowEvent e) {
        doExit();
    }

    /**
     * Method inherited from WindowListener. Not used in this implementation.
     * 
     * @param e WindowEvent
     */
    public void windowClosed(WindowEvent e) {
        // not interested in this event
    }

    /**
     * Method inherited from WindowListener. Not used in this implementation.
     * 
     * @param e WindowEvent
     */
    public void windowIconified(WindowEvent e) {
        // not interested in this event
    }

    /**
     * Method inherited from WindowListener. Not used in this implementation.
     * 
     * @param e WindowEvent
     */
    public void windowDeiconified(WindowEvent e) {
        // not interested in this event
    }

    /**
     * Method inherited from WindowListener. Not used in this implementation.
     * 
     * @param e WindowEvent
     */
    public void windowActivated(WindowEvent e) {
        // not interested in this event
    }

    /**
     * Method inherited from WindowListener. Not used in this implementation.
     * 
     * @param e WindowEvent
     */
    public void windowDeactivated(WindowEvent e) {
        // not interested in this event
    }

    /**
     * Starts the application.
     * 
     * @param args command line arguments.
     */
    public static void main(String[] args) {

        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        BBTP bbtp = new BBTP();
        BBTPGUI frame = new BBTPGUI(bbtp);
        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
