package edu.ncsu.csc216.bbtp.model;

import java.io.Serializable;

import java.util.Observable;
import java.util.Observer;

import edu.ncsu.csc216.bbtp.util.ArrayList;

//import edu.ncsu.csc216.bbtp.util.ArrayList;


/**
 * Contains an ArrayList of TestingTypes and maintains the list.
 * 
 * @author Steven
 *
 */
public class TestingTypeList extends Observable implements Tabular, Serializable, Observer {

	private static final long serialVersionUID = 984509L;
	/** Name of the TestingTypeList */
	private String name = "Testing Types";
	/** Integer for tracking the next TestingType number. */
	private int nextTestingTypeNum;
	/** List to hold TestingTypes */
	private ArrayList list;
	
	
	/**
	 * Constructor for TestingTypeList
	 */
	public TestingTypeList() {
		list = new ArrayList();
		this.nextTestingTypeNum = 1;
		
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
		String id = "TT" + this.getNextTestingTypeNum();
		TestingType tt = new TestingType(name, desc, id);
		for(int i = 0; i < list.size(); i++) {
			if(((TestingType)list.get(i)).compareTo(tt) < 0) continue;
			else {
				list.add(i - 1, tt); //insert at spot before the condition failed.
				incNextTestingTypeNumber();
				setChanged(); //set changed and notify observers
				notifyObservers(this);
				tt.addObserver(this);
				return true;
			}
		}
		return false;	
	}
	
	/**
	 * Returns the TestingType at the specified index
	 * @param index Index of the TestingType to return.
	 * @return TestingType the TestingType contained at the specified index.
	 */
	public TestingType getTestingTypeAt(int index) {
		if(index < 0 || index >= list.size()) throw new IndexOutOfBoundsException();
		else return (TestingType)list.get(index);
	}
	
	/**
	 * Returns the index of the TestingType with the specified ID.
	 * @param id ID of the TestingType to search for or -1 if not found.
	 * @return Index of the TestingType with the specified ID.
	 */
	public int indexOf(String id) {
		for(int i = 0; i < list.size(); i++) {
			String fromList = ((TestingType)list.get(i)).getTestingTypeID();
			if(fromList.equals(id)) return i;
		}
		return -1; //if no match is found
	}
	
	/** 
	 * Returns the index of the TestingType that matches the specified name.
	 * @param name Name of the TestingType to search for.
	 * @return Index of the TestingType with the specified name.
	 */
	public int indexOfName(String name) {
		for(int i = 0; i < list.size(); i++) {
			String fromList = ((TestingType)list.get(i)).getName();
			if(fromList.equals(name)) return i;
		}
		return -1; //if no match is found
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
		if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
		TestingType removed = (TestingType) list.remove(index);
		setChanged();
		notifyObservers(this);
		removed.deleteObserver(this); //remove the current list from the TestingType's observers
		return removed; //Simplify later if needed
	}
	
	
	/**
	 * Attempts to remove the TestingType matching the given parameter. 
	 * @param id ID of the TestingType to remove. 
	 * @return True if the TestingType was removed successfully. 
	 */
	public boolean removeTestingType(String id) {
		if(this.indexOf(id) != -1) {
			TestingType removed = (TestingType)list.get(this.indexOf(id));  // .deleteObserver(this); //remove the observerable frmo this list.
			list.remove(this.indexOf(id));
			setChanged();
			notifyObservers();
			removed.deleteObserver(this); //moved the delete observer call to allow notify to update the current list.
			
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the next TestingType number. 
	 * @return The next TestingType number. 	
	 */
	private int getNextTestingTypeNum() {
		return this.nextTestingTypeNum; //should return the number that will be given to the next addition of the list. 
	}
	
	/**
	 * Increments the TestingType number by 1. 
	 */
	private void incNextTestingTypeNumber() {
		nextTestingTypeNum = getNextTestingTypeNum() + 1;
	}
	
	/**
	 * Creates a 2D Object and returns an Object[][] array. Each row, i, 
	 * contains a TestingType. [i][0] is the TestingType id, [i][1] is the
	 * TestingType name, and [i][2] is the TestingType description.
	 * @return 2D Object array for the TestingType. 
	 */
	public Object[][] get2DArray() {
		Object[][] listInfo = new Object[list.size()][3]; //one row per TT, 3 columns per row.
		for(int i = 0; i < list.size(); i++){
			listInfo[i][0] = ((TestingType)list.get(i)).getTestingTypeID();
			listInfo[i][1] = ((TestingType)list.get(i)).getName();
			listInfo[i][2] = ((TestingType)list.get(i)).getDescription();
		}
		return listInfo;
	}
	
	/**
	 * Updates the Observer of TestingType that a change occurred within the
	 * Observable of TestingType.
	 * @param o The Observable monitored by TestingType. 
	 * @param arg Object that underwent change. 
	 */
	public void update(Observable o, Object arg) {
		/*
		 *  If a TestingType in the TestingTypeList changes, 
		 *  the update() method is automatically called. TestingTypeList 
		 *  should propagate the notification of the change to its Observers 
		 *  IF the Observable o is contained in the list of  TestingTypes. The arg 
		 *  parameter is passed to notifyObservers().
		 */
	 //TODO incNextTestinTypeNumber
		if(list.contains(o)) notifyObservers(arg); 
		
/*-----------------Notes on Observer and Observerable ----------------------------------------
 *		if the Observerable (testingtype) is inside of the observers 
 *		data structure, then a call from notifyObservers(), will call the 
 *		update() method. 
 *		
 *		setChanged():
 *			Marks the Observable as changed and automatically calls the update() method.
 *			
 *		update():
 *			Is passed an instance of the Observerable within the current Observers class
 *			that triggered the setChanged() call.
 *					i.e. - Observerable = TestingType within TestingTypeList
 *			as well as the object that corresponds to the current Observer.
 *					i.e - TestingTypeList
 *				
 *		notifyObservers(this):
 *			Sends a message to any of the Observers that have the argument as an Observerable.
 *					i.e. Any Observers that are monitoring TestingTypeList will be notified.
 *					
 *				Not sure about the part where if(o.contains(arg)), b/c observers wouldn't be
 *				Notified if a TestingType had been removed from the List. 
 *				
 *				However, doing so could stop the current Observer - TestingTypeList - from 
 *				notifying it's observers when a setChanged() call was triggered, but doesn't 
 *				effect the current Observer.
 *					- i.e Another object inside of this class could need to call setChanged, 
 *					which would automatically call TestingTypeList's update method, which 
 *					would automatically update all of it's observers of a change that DID NOT 
 *					actually occur. 
 *		Read Later: https://docs.oracle.com/javase/8/docs/api/java/util/Observable.html
 */		 
	}
	

}
