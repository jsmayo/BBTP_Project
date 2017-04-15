package edu.ncsu.csc216.bbtp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import edu.ncsu.csc216.bbtp.util.LinkedList;

/**
 * TestCaseList uses behaivor defined by LinkedList to house and maintain a list
 * of TestCases. 
 * 
 * @author Steven Mayo
 */
public class TestCaseList extends Observable implements Tabular, Serializable, Observer {

	private static final long serialVersionUID = 98734509L;
	private String name;
	private int nextTestCaseNum;
	private String testCaseListID;
	private LinkedList list;
	
	/**
	 * Constructor for TestCaseList
	 * @param list name of the TestCaseList
	 * @param id ID of the TestCaseList
	 */
	public TestCaseList(String list, String id){
		setTestCaseListID(id);
	}
	
	/**
	 * Returns the name of the TestCaseList.
	 * @return name Name of the TestCaseList.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Sets the value for the TestCaseList name.  
	 * @param name Name to assign the TestCaseList.
	 */
	public void setName(String name) {
	}
	
	/**
	 * Returns the TestCaseList ID number. 
	 * @return testCaseListID ID of the TestCaseList.
	 */
	public String getTestCaseListID() {
		return this.testCaseListID;
	}
	
	/**
	 * Sets the ID of the TestCaseList to that of the given parameter. 
	 * @param id ID to assign as the TestCaseList ID.
	 */
	private void setTestCaseListID(String id) {
		this.testCaseListID = id;
	}
	
	/**
	 * Returns the integer value of the next TestCase number.
	 * @return Value of the next TestCase number.
	 */
	private int getNextTestCaseNum() {
		return this.nextTestCaseNum;
	}
	
	/**
	 * Increments the TestCase number by 1.
	 */
	private void incNextTestCaseNum() {
		this.nextTestCaseNum = this.getNextTestCaseNum() + 1;
	}
	
	/**
	 * Adds a TestCase to the current TestCaseList. 
	 * @param name Name of the TestCase.
	 * @param type Type of the TestCase.
	 * @param creation Date of creation for the TestCase.
	 * @param er Expected results of the TestCase.
	 * @param tested Boolean value assigned to tell if a TestCase was Tested. 
	 * @param lastTested Date that the TestCase was last tested.
	 * @param ar Actual results of the TestCase 
	 * @param passed Boolean value assigned to tell if a TestCase passed or failed. 
	 * @return True if the TestCase was added to the TestCaseList. 
	 */
	public boolean addTestCase(String name, TestingType type, Date creation, String er, boolean tested,
			Date lastTested, String ar, boolean passed ) {
		this.incNextTestCaseNum();
		return false;
	}
	
	/**
	 * Returns the TestCase at the given index.  
	 * @param index Index to retrieve the TestCase from.
	 * @return TestCase at the given Index or null if not found.
	 * @throws IndexOutOfBoundsException if the index is less than 0
	 * or greater than or equals to the size.
	 */
	public TestCase getTestCaseAt(int index){
		if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
		return null;
	}
	
	/**
	 * Returns the index of the TestCase representing the given TestCase name.
	 * @param name Name of the TestCase.
	 * @return index of the TestCase if found, -1 if not. 
	 */
	public int indexOf(String name) {
		return -1;
	}
	
	/**
	 * Returns the number of elements within the TestCaseList.  
	 * @return Number of elements within the TestCaseList. 
	 */
	public int size() {
		return list.size();
	}
	
	/**
	 * Checks to see if the TestCaseList is empty. 
	 * @return True if the TestCaseList has no elements. 
	 */
	public boolean isEmpty() {
		return (list.isEmpty()); 
	}
	
	/**
	 * Removes a TestCase at the given index. 
	 * @param index Index to remove the TestCase from.
	 * @return removed The TestCase removed from the TestCaseList. 
	 */
	public TestCase removeTestCaseAt(int index) {
		TestCase removed = null;
		return removed;
	}
	
	/**
	 * Removes a TestCase that matches the given TestCase name. 
	 * @param name Name of the TestCase to remove. 
	 * @return True if the TestCase was removed. 
	 */
	public boolean removeTestCase(String name) {
		return false;
	}
	
	/**
	 * Returns a 2D Object array of the TestCaseList. 
	 * @return 2D Object array of the TestCaseList TestCase's name and id's.
	 */
	public Object[][] get2DArray() {
		return new Object[0][0];
	}
	
	/**
	 * Updates the Observer of TestCaseList that changes were observed within
	 * TestCaseList.
	 * @param obs Object being observed by TestCaseList.
	 * @param o Object that underwent change. 
	 */
	public void update(Observable obs, Object o) {	
	
	}
	
}
