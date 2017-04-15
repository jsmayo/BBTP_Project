/**
 * 
 */
package edu.ncsu.csc216.bbtp.ui;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * The BBTPMenuBar bar that holds all major BBTP operations.
 * 
 * @author David R. Wright
 * @author Jessica Young Schmidt
 */
public class BBTPMenuBar extends JMenuBar {

    /** Serial version UID */
    private static final long serialVersionUID = 49171L;

    /** Names for the File menu items */
    private static final String[] FILE_MENU_NAMES = { "Open File", "Save File", "Exit" };
    /** Keyboard shortcuts for the File menu items */
    private static final int[] FILE_MENU_KEYS = { KeyEvent.VK_O, KeyEvent.VK_S, KeyEvent.VK_X };
    /** ActionCommand for File menu items */
    private static final String[] FILE_MENU_COMMANDS = { "11", "12", "13" };
    /** Names for the TestCaseList menu items */
    private static final String[] TEST_CASE_LIST_MENU_NAMES = { "Rename Test Case List", "New Test Case List",
            "Delete Test Case List" };
    /** Keyboard shortcuts for the TestCaseList menu items */
    private static final int[] TEST_CASE_LIST_MENU_KEYS = { KeyEvent.VK_R, KeyEvent.VK_N, KeyEvent.VK_D };
    /** ActionCommands for TestCaseList menu items */
    private static final String[] TEST_CASE_LIST_MENU_COMMANDS = { "21", "22", "23" };
    /** Names for the TestCase menu items */
    private static final String[] TEST_CASE_MENU_NAMES = { "Add New Test Case", "Delete Test Case" };
    /** Keyboard shortcuts for the TestCase menu items */
    private static final int[] TEST_CASE_MENU_KEYS = { KeyEvent.VK_A, KeyEvent.VK_D };
    /** ActionCommands for TestCase menu items */
    private static final String[] TEST_CASE_MENU_COMMANDS = { "31", "32" };
    /** Names for the TestingType menu items */
    private static final String[] TESTING_TYPE_MENU_NAMES = { "Add Testing Type", "Delete Testing Type" };
    /** Keyboard shortcuts for the TestingType menu items */
    private static final int[] TESTING_TYPE_MENU_KEYS = { KeyEvent.VK_A, KeyEvent.VK_D };
    /** ActionCommands for the TestingType menu items */
    private static final String[] TESTING_TYPE_MENU_COMMANDS = { "41", "42" };
    /** Reference to BBTPGUI */
    private BBTPGUI parent;

    /**
     * Creates the BBTPMenuBar for the BBTPGUI.
     * 
     * @param parent the BBTPGUI that created the BBTPMenuBar
     */
    public BBTPMenuBar(BBTPGUI parent) {
        super();
        this.parent = parent;
        initMenu();
    }

    /**
     * Initializes the Menu bar by adding each of the Menus.
     */
    private void initMenu() {
        this.add(fileMenu());
        this.add(testCaseListMenu());
        this.add(testCaseMenu());
        this.add(testingTypeMenu());
    }

    /**
     * Creates the File menu.
     * 
     * @return the File menu
     */
    private JMenu fileMenu() {
        JMenu menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        addMenuItems(menu, FILE_MENU_NAMES, FILE_MENU_KEYS, FILE_MENU_COMMANDS);
        return menu;
    }

    /**
     * Creates the TestCaseList menu
     * 
     * @return the TestCaseList menu
     */
    private JMenu testCaseListMenu() {
        JMenu menu = new JMenu("Test Case List");
        menu.setMnemonic(KeyEvent.VK_L);
        addMenuItems(menu, TEST_CASE_LIST_MENU_NAMES, TEST_CASE_LIST_MENU_KEYS, TEST_CASE_LIST_MENU_COMMANDS);
        return menu;
    }

    /**
     * Creates the TestCase menu
     * 
     * @return the TestCase menu
     */
    private JMenu testCaseMenu() {
        JMenu menu = new JMenu("Test Cases");
        menu.setMnemonic(KeyEvent.VK_T);
        addMenuItems(menu, TEST_CASE_MENU_NAMES, TEST_CASE_MENU_KEYS, TEST_CASE_MENU_COMMANDS);
        return menu;
    }

    /**
     * Creates the TestingType menu
     * 
     * @return the TestingType menu
     */
    private JMenu testingTypeMenu() {
        JMenu menu = new JMenu("Testing Types");
        menu.setMnemonic(KeyEvent.VK_C);
        addMenuItems(menu, TESTING_TYPE_MENU_NAMES, TESTING_TYPE_MENU_KEYS, TESTING_TYPE_MENU_COMMANDS);
        return menu;
    }

    /**
     * Creates MenuItems with the given names, hot keys, and command values and
     * adds them to the given Menu.
     * 
     * @param menu JMenu to add MenuItems to
     * @param itemNames name for the MenuItems
     * @param hotkeys keyboard shortcut for the MenuItems
     * @param cmds command strings for the MenuItems
     */
    private void addMenuItems(JMenu menu, String[] itemNames, int[] hotkeys, String[] cmds) {
        for (int i = 0; i < itemNames.length; i++) {
            JMenuItem item = new JMenuItem(itemNames[i], hotkeys[i]);
            item.setActionCommand(cmds[i]);
            item.addActionListener(parent);
            menu.add(item);
        }
    }
}
