package edu.ncsu.csc216.bbtp.util;

/**
 * An implementation of the List interface with an array data structure.
 * @author Steven Mayo
 *
 */
public class ArrayList implements List{
	/** Default serialization number */
//	private static final long serialVersionUID = 28592L;
	/** Integer used for resizing */
	private static final int RESIZE = 10;
	/** Array to implement ArrayList behaviors */
	private Object[] list;
	/** Size of the array. */
	private int size;
	
	/**
	 * Constructs the Array with a default capacity to be used
	 * as an ArrayList.
	 */
	public ArrayList() {
		this.list = new Object[RESIZE];
	}
	
	/**
	 * Constructs the Array with a given capacity to be used as the 
	 * ArrayList container.
	 * @param capacity capacity of the Array.
	 */
	public ArrayList(int capacity) {
	}
	
	/**
	 * Adds an element to the Array.
	 * @param add Object to add into the Array.
	 * @return True if the element was successfully added.
	 */
	public boolean add(Object add) {
		return false;
	}
	
	/**
	 * Adds an element to the Array at the given index.
	 * @param index Index to add the Object within the Array.
	 * @param add Object to add into the Array at the given index.
	 */
	public void add(int index, Object add) {
	}
	
	/**
	 * Checks to see if the Array contains the given object.
	 * @param o Object to compare elements against within the current Array.
	 * @return True if the object is contained within the Array.
	 */
	public boolean contains(Object o) {
		return false;
	}
	
	/**
	 * Returns the Object located in the Array at the given index.
	 * @param index Index to retrieve the given index from.
	 * @return Object at the given index.
	 */
	public Object get(int index) {
		return list[index];
		
	}
	
	/**
	 * Returns the index of the given element. 
	 * @param element Object to retreive the index value of.
	 * @return Index of the given element or -1 if no match is found.
	 */
	public int indexOf(Object element) {
		return -1;
	}
	
	/**
	 * Checks to see if the current Array is empty.
	 * @return True if there are no elements within the Array.
	 */
	public boolean isEmpty() {
		return(size == 0);
	}
	
	/**
	 * Removes an Object from from the array at the given index value.
	 * @param index Index to remove the object from.
	 * @throws IndexOutOfBoundsException if the given index less than 0 or
	 * greater than or equals to the size.
	 * @return removed The object removed from the Array.
	 */
	public Object remove(int index) {
		if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
		Object removed = new Object();
		return removed;
	}
	
	/**
	 * Returns the number of elements within the Array. Any iterators that use size should
	 * not allow greater than size(), since doing so will throw an IOOBE.
	 * @return Number of elements within the Array.
	 */
	public int size() {
		return this.size;
	}
	

}
