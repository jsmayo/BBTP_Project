package edu.ncsu.csc216.bbtp.util;

/**
 * LinkedList container class.
 * 
 * @author Steven Mayo 
 *
 */
public class LinkedList implements List {

	private static final long serialVersionUID = 1L;
	
	public LinkedList() {
	}
	
	public boolean add(Object o) {
		return false;
	}
	
	public void add(int index, Object o) {
	}
	
	public boolean contains(Object o) {
		return false;
	}
	
	public Object get(int index) {
		return new Object();
	}
	
	public int indexOf(Object o) {
		return -1;
	}
	
	public boolean isEmpty() {
		return false;
	}
	
	public Object remove(int index) {
		return new Object();
	}
	
	public int size() {
		return this.size();
	}
	
	
	
	
	
	public class Node {
		
		private static final long serialVersionUID = 1L;
		Object value;
		
		public Node(Object o, Node next){
			this.value = o;
		}
	}
}
