package edu.ncsu.csc216.bbtp.util;

import java.io.Serializable;
import java.util.Arrays;

/**
 * An implementation of the List interface with an array data structure.
 * @author Steven Mayo
 *
 */
public class ArrayList implements List, Serializable {
	/** Default serialization number */
	private static final long serialVersionUID = 28592L;
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
		this(RESIZE); // call parameterized constructor with default value
		this.size = 0;
		
	}
	
	/**
	 * Constructs the Array with a given capacity to be used as the 
	 * ArrayList container.
	 * @param capacity capacity of the Array.
	 */
	public ArrayList(int capacity) {
		list = new Object[capacity];
		this.size = 0;
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
	 * Adds an element of type Object to the internal Array of ArrayList 
	 * at the specified index value.If the size of the Array is approaching 
	 * the capacity, then the Array will double in capacity.
	 * If a null value is passed in as an argument or if an index value is 
	 * passed in that is outside of the  Array bounds, then an exception will be thrown.
	 * @param index The index value to insert the object into the ArrayList.
	 * @param e The object, of type E, to place at the specified index. 
	 * @throws IndexOutOfBoundsException if the index is outside of the array
	 * boundaries
	 * @throws IllegalArgumentException if the specified value is a duplicate already
	 * found within the list.
	 */
	@Override
	public void add(int index, Object e){
		if(e == null) throw new NullPointerException();
		if(index > this.size || index < 0 ) throw new IndexOutOfBoundsException();
		for(int i = 0; i <= this.size; i++) if(e.equals(list[i])) throw new IllegalArgumentException("Cannot add duplicate values.");
		
		//size is last place of value (NOT INDEXED).
	
		if(this.size == 0 && index == 0) {
			list[0] = e;
		}
		if(index == 0 && this.size > 0) {
			//Capacity is doubled when approaching the limit at size + 1 >= capacity
			//shift everything right
			for(int i = this.size; i >= 0; i--) list[i + 1] = list[i];
			list[0] = e;
		}
		else if (index > 0 && this.size > 0) {
				for(int i = this.size; i >= index; i--) list[i + 1] = list[i];
				list[index] =  e;
		}
		this.size++;
		//handle capacity checks
		//if the size of the array is reaching the capacity, double the capacity.	
		if((this.size + 1) / RESIZE >= 1) { //if dividing by the capacity is > 1, list is almost full
			this.list = Arrays.copyOf(this.list, this.size() * 2); //make a new array with twice the previous capacity
		}
		
	}
	
	/**
	 * Checks to see if the Array contains the given object.
	 * @param o Object to compare elements against within the current Array.
	 * @return True if the object is contained within the Array.
	 */
	public boolean contains(Object o) {
		for(int i = 0; i < list.length; i++) {
			if(list[i] == o) return true;
		}
		return false;
	}
	

	/**
	 * Returns the value, of type E, located at the specified index value.
	 * @param index Index to retrieve the Object from. 
	 * @return Object stored at the specified index value. 
	 * @throws IndexOutOfBoundsException if the specified index is out
	 * of the array boundaries.
	 */
	public Object get(int index) {
		if(index < 0 || index >= this.size) throw new IndexOutOfBoundsException();
		return list[index];
		//return arrayList.get(index);
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
		return size == 0;
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
