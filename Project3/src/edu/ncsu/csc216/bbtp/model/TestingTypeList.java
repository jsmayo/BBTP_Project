package edu.ncsu.csc216.bbtp.model;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import edu.ncsu.csc216.bbtp.util.ArrayList;


/**
 * Contains an ArrayList of TestingTypes and maintains the list.
 * 
 * @author Steven
 *
 */
public class TestingTypeList extends Observable implements Tabular, Serializable, Observer {

	private static final long serialVersionUID = 984509L;
	/** Name of the TestingTypeList */
	private String name;
	/** Integer for tracking the next TestingType number. */
	private int nextTestingTypeNum;
	/** List to hold TestingTypes */
	private ArrayList list;
	
	
	/**
	 * Constructor for TestingTypeList
	 */
	public TestingTypeList() {
	}
	
	/**
	 * Returns the name of the TestingTypeList
	 * @return Name of the list
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Adds a new TestingType to the list of current TestingTypes.
	 * @param name Name of the list.
	 * @param desc Description of the TestingType
	 * @return True if the TestingType was successfully added.
	 */
	public boolean addTestingType(String name, String desc) {
		TestingType tt = new TestingType("String", "String", "String");
		tt.addObserver(this);
		return false;
	}
	
	/**
	 * Returns the TestingType at the specified index
	 * @param index Index of the TestingType to return.
	 * @return TestingType the TestingType contained at the specified index.
	 */
	public TestingType getTestingTypeAt(int index) {
		return null;
	}
	
	/**
	 * Returns the index of the TestingType with the specified ID.
	 * @param id ID of the TestingType to search for.
	 * @return Index of the TestingType with the specified ID.
	 */
	public int indexOf(String id) {
		return -1;
	}
	
	/** 
	 * Returns the index of the TestingType that matches the specified name.
	 * @param name Name of the TestingType to search for.
	 * @return Index of the TestingType with the specified name.
	 */
	public int indexOfName(String name) {
		return -1;
	}
	
	/**
	 * Returns the size of the list.
	 * @return size of the list.
	 */
	public int size() {
		return list.size();
	}
	
	/**
	 * Checks to see if the list is empty.
	 * @return True if the size of the list is zero.
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * Removes a TestingType from the list at the specified index.
	 * @param index Index of the TestingType to remove.
	 * @return The removed TestingType.
	 */
	public TestingType removeTestingTypeAt(int index) {
		TestingType removed = (TestingType) list.remove(index);
		return removed; //Simplify later if needed
	}
	
	
	/**
	 * Attempts to remove the TestingType matching the given parameter. 
	 * @param id ID of the TestingType to remove. 
	 * @return True if the TestingType was removed successfully. 
	 */
	public boolean removeTestingType(String id) {
		return false;
	}
	
	/**
	 * Returns the next TestingType number. 
	 * @return The next TestingType number. 	
	 */
	private int getNextTestingTypeNum() {
		return this.nextTestingTypeNum;
	}
	
	/**
	 * Increments the TestingType number by 1. 
	 */
	private void incNextTestingTypeNumber() {
		this.nextTestingTypeNum = this.getNextTestingTypeNum() + 1;
	}
	
	/**
	 * Creates a 2D Object for the TestingType.
	 * @return 2D Object array for the TestingType. 
	 */
	public Object[][] get2DArray() {
		return null;
	}
	
	/**
	 * Updates the Observer of TestingType that a change occurred within the
	 * Observable of TestingType.
	 * @param o The Observable monitored by TestingType. 
	 * @param obj Object that underwent change. 
	 */
	public void update(Observable o, Object obj) {
	 this.incNextTestingTypeNumber();
	}
	

}
