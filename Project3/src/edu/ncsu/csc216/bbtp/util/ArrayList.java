package edu.ncsu.csc216.bbtp.util;

public class ArrayList implements List{
	/** Default serialization number */
	private static final long serialVersionUID = 1L;
	/** Integer used for resizing */
	private static final int RESIZE = 10;
	/** Array to implement ArrayList behaivors */
	private Object[] list;
	/** Size of the array. */
	private int size;
	
	public ArrayList() {
	}
	
	public ArrayList(int capacity) {
	}
	
	public boolean add(Object add) {
		return false;
	}
	
	public void add(int index, Object add) {
	}
	
	public boolean contains(Object o) {
		return false;
	}
	
	public Object get(int index) {
		return new Object();
	}
	
	public int indexOf(Object element) {
		return -1;
	}
	
	public boolean isEmpty() {
		return(size == 0);
	}
	
	public Object remove(int index) {
		return new Object();
	}
	
	public int size() {
		return this.size;
	}
	

}
