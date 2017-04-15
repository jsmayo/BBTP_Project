package edu.ncsu.csc216.bbtp.util;

import java.io.Serializable;

/**
 * An implementation of the List interface with a data 
 * structure of linked  Nodes.
 * 
 * @author Steven Mayo 
 *
 */
public class LinkedList implements List, Serializable {

	private static final long serialVersionUID = 349987L;
	
	/**
	 * Constructor for the LinkedList container.
	 */
	public LinkedList() {
	}
	
	/**
	 * Adds an Object to the back of the LinkedList.
	 * @param o Object to add to the LinkedList.
	 * @return True if the Object was added successfully.
	 */
	public boolean add(Object o) {
		return false;
	}
	
	/**
	 * Adds an Object to the LinkedList at the given index.
	 * @param index Index to add the Object at.
	 * @param o Object to add at the given index.
	 * @throws IndexOutOfBoundsException if the given index is < 0
	 * or > size().
	 */
	public void add(int index, Object o) {
		if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
	}
	
	/**
	 * Checks the current LinkedList for a match to the given Object.
	 * @param o Object to check the LinkedList for.
	 * @return true if the given Object is found.
	 */
	public boolean contains(Object o) {
		return false;
	}
	
	/**
	 * Retrieves the Object at the given index.
	 * @param index Index to retrieve the Object from.
	 * @return Object at the given index.
	 * @throws IndexOutOfBoundsException if the given index is < 0
	 */
	public Object get(int index) {
		if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
		return new Object();
	}
	
	/**
	 * Returns the index of the given Object if found within the LinkedList, otherwise
	 * -1 is returned for a no match query.
	 * @param o Object to search the LinkedList for.
	 * @return index of the Object if found, otherwise -1.
	 */
	public int indexOf(Object o) {
		return -1;
	}
	
	/**
	 * Checks to see if the LinkedList is empty.
	 * @return True if no elements are contained within the LinkedList.
	 */
	public boolean isEmpty() {
		return false;
	}
	
	/**
	 * Retrieves the Object at the given index.
	 * @param index Index to retrieve the Object from.
	 * @return removed Object removed from the LinkedList.
	 * @throws IndexOutOfBoundsException if the given index is < 0
	 */
	public Object remove(int index) {
		if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
		Object removed = new Object();
		return removed;
	}
	
	/**
	 * Returns the number of Objects contained within the LinkedList.
	 * @return Number of elements within the LinkedList.
	 */
	public int size() {
		return this.size();
	}
	
	
	
	
	/**
	 * Node is an inner class of LinkedList that contains an 
	 * Object and a reference to the next Node in the List.
	 * @author Steven Mayo
	 *
	 */
	public class Node {
		
		//private static final long serialVersionUID = 484909840L;
		Object value;
		
		/**
		 * Constructor of the Node Object with reference to the next
		 * Node in the LinkedList.
		 * @param o Object to add into the LinkedList.
		 * @param next Node of the Next Object within the LinkedList. 
		 */
		public Node(Object o, Node next){
			this.value = o;
		}
	}
}
