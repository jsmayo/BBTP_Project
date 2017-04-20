package edu.ncsu.csc216.bbtp.util;

import java.io.Serializable;


/**
 * An implementation of the List interface with a value 
 * structure of linked  Nodes.
 * 
 * @author Steven Mayo 
 */
public class LinkedList implements List, Serializable {

	private static final long serialVersionUID = 349987L;
	/** First Node of the LinkedList */
	private Node front;
	/** Size of the LinkedList */
	@SuppressWarnings("unused")
	private int size;
	
	
	/**
	 * Constructor for the LinkedList container.
	 */
	public LinkedList() {
		this.size = 0;
		front = null;
	}
	
	/**
	 * Adds an Object to the back of the LinkedList.
	 * @param e Object to add to the LinkedList.
	 * @return True if the Object was added successfully.
	 */
	public boolean add(Object e) {
		if(contains(e)) throw new IllegalArgumentException();
		if(isEmpty() || size() == 0) { 
			front = new Node(e, front); // handles empty cases only.
			size = size(); //increase the size
			return true; //exit the call
		}
		else {
			boolean b = front.add(e); //else delegate recursive call to inner node
			size = size();
			return b;
		}
	}
	
	/**
	 * Adds an Object to the LinkedList at the given index.
	 * @param index Index to add the Object at.
	 * @param e Object to add at the given index.
	 * @throws IndexOutOfBoundsException if the given index less than 0 or
	 * greater than or equals to the size.
	 */
	public void add(int index, Object e) {
		if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
		if(e == null) throw new NullPointerException();
		if(contains(e)) throw new IllegalArgumentException();
		
		//add to front
		if(index == 0) {
			//empty list
				front = new Node(e, front);
				size = size();
				return;
			}
		else if(index == size()) {
			boolean b = front.add(e); //add to end
			if(!b) throw new IllegalArgumentException();
			size = size();
			return;
		}
		else if(index > 0 && index < size()) {
			front.add(index, e);
			size = size();
			return;
		}
		else throw new IllegalArgumentException();
			
	}
	
	/**
	 * Checks the current LinkedList for a match to the given Object.
	 * @param e Object to check the LinkedList for.
	 * @return true if the given Object is found.
	 */
	public boolean contains(Object e) {
		if(isEmpty()) return false;
		return front.contains(e); //can call this because guaranteed size != 0
	}
	
	/**
	 * Retrieves the Object at the given index.
	 * @param index Index to retrieve the Object from.
	 * @return Object at the given index.
	 * @throws IndexOutOfBoundsException if the given index less than 0 or
	 * greater than or equals to the size.
	 */
	public Object get(int index) {
		if(index < 0 || front == null  || index >= size()) throw new IndexOutOfBoundsException();	
		return front.get(index); // delegate to recursive method
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
		return (size() == 0); 
	}
	
	/**
	 * Retrieves the Object at the given index.
	 * @param index Index to retrieve the Object from.
	 * @return removed Object removed from the LinkedList.
	 * @throws IndexOutOfBoundsException if the given index less than 0 or
	 * greater than or equals to the size.
	 */
	public Object remove(int index) {
		if(index >= size() || index < 0 || front == null) throw new IndexOutOfBoundsException();
		Object e = null;
		if(index == 0) { //know front != null from first check
			e = front.value;
			front = front.next;
			size = size();
			return e;
		}
		else {
			e = front.remove(index);
			size = size();
			return e;
		}
	}
	
	/**
	 * Returns the number of Objects contained within the LinkedList.
	 * @return Number of elements within the LinkedList.
	 */
	public int size() {
		if(front == null) return 0;
		else return front.size();
	}
	
	
	
	
	/**
	 * Node is an inner class of LinkedList that contains an 
	 * Object and a reference to the next Node in the List.
	 * @author Steven Mayo
	 *
	 */
	public class Node implements Serializable {
		
		private static final long serialVersionUID = 484909840L;
		
		/** Object of the Node. */
		protected Object value;
		/** Next Node in the LinkedList */
		private Node next;
		
		/**
		 * Constructor of the Node Object with reference to the next
		 * Node in the LinkedList.
		 * @param o Object to add into the LinkedList.
		 * @param next Node of the Next Object within the LinkedList. 
		 */
		public Node(Object o, Node next){
			this.value = o;
		}
		
		/**
		 * Used by LinkedList to determine the number of Node's within
		 * the LinkedList, recursively. 
		 * @return Size of the LinkedList, corresponding to the number of
		 * Objects within the list. 
		 */
		public int size() {
			if(next == null) return 1;
			else return 1 + next.size();
		}
		
		/**
		 * Adds the given element to the end of the list. 
		 * @param e element to add to the end of the LinkedList.
		 */
		private boolean add(Object e) {
			if(next == null) { //when next == null, you want to add E, since adding to the end.
				next = new Node(e, null);
				return true;
			}
			else return next.add(e); //use next node to call recursively
		}
		
		/**
		 * Checks to see if the given element is contained within the list,
		 * recursively. 
		 * @param e element to add to the end of the LinkedList.
		 * @param index Index to add the given element at.
		 * @throws IndexOutOfBoundsException if the index is less than 0 or 
		 * greater than the size of the LinkedList.
		 */
		private void add(int index, Object e) {
			//index > 0 and index < size
			int step = 1; //constant stepsize
			if(index == 1){ //if next index is the target, add and return.
				next = new Node(e, next);
				return;
			}
			else { //if not at the target, recursive call and update an index reference.
				if(index - step != 0) {
					next.add(index - step, e);
				}
			}
		}
		
		/**
		 * Retrieves the value contained at the given index value.
		 * @param index Index value to retrieve the desired value from.
		 * @return value contained at the given index. 
		 */
		private Object get(int index) {
			//know front is not null at this point, also index < size
			if(index == 0) return value;
			else return next.get(index - 1); 		
		}
							
		
		/**
		 * Attempts to remove the given element from the LinkedList at the given index.
		 * @param index Index to remove the LinkedList element from. 
		 * @return removed Element removed or null if not contained within the list.
		 * @throws IndexOutOfBoundsException if the index is less than 0 or 
		 * greater than the size of the LinkedList.
		 */
		private Object remove(int index){
			if(index == 1) {
				Object r = next.value;
				next = next.next;
				return r;
			}
			else {
				if(next == null) return null;
				return next.remove(index - 1);
			}
		}
				
		/**
		 * Checks for an instance of the given element within the LinkedList.
		 * @param e Element to search the LinkedList for. 
		 * @return True if the given element is contained within the list.
		 */
		private boolean contains(Object e) {
			if(value.equals(e)) return true;
			else {
				if(next == null)  return false;
				else return next.contains(e); //recursive call
			}

		}
		
	}
}
