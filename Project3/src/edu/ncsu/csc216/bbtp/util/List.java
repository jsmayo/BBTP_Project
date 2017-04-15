/**
 * 
 */
package edu.ncsu.csc216.bbtp.util;

/**
 * This interface is a subset of the java.util.List interface and does not
 * require implementation of generic parameterization.
 * 
 * This interface is adapted from java.util.List.
 * 
 * @author David R. Wright
 *
 *
 *         An ordered collection (also known as a sequence). The user of this
 *         interface has precise control over where in the list each element is
 *         inserted. The user can access elements by their integer index
 *         (position in the list), and search for elements in the list.
 *
 *         The List interface provides four methods for positional (indexed)
 *         access to list elements. Lists (like Java arrays) are zero based.
 *         Note that these operations may execute in time proportional to the
 *         index value for some implementations (the LinkedList class, for
 *         example). Thus, iterating over the elements in a list is typically
 *         preferable to indexing through it if the caller does not know the
 *         implementation.
 *
 *         Note: While it is permissible for lists to contain themselves as
 *         elements, extreme caution is advised: the equals and hashCode methods
 *         are no longer well defined on such a list.
 *
 *         Some list implementations have restrictions on the elements that they
 *         may contain. For example, some implementations prohibit null
 *         elements, and some have restrictions on the types of their elements.
 *         Attempting to add an ineligible element throws an unchecked
 *         exception, typically NullPointerException or ClassCastException.
 *         Attempting to query the presence of an ineligible element may throw
 *         an exception, or it may simply return false; some implementations
 *         will exhibit the former behavior and some will exhibit the latter.
 *         More generally, attempting an operation on an ineligible element
 *         whose completion would not result in the insertion of an ineligible
 *         element into the list may throw an exception or it may succeed, at
 *         the option of the implementation. Such exceptions are marked as
 *         "optional" in the specification for this interface.
 *
 * Removed References to SEE tag due to errors. 
 * @author Josh Bloch
 * @author Neal Gafter
 * @since 1.2
 */

public interface List {
    // Query Operations

    /**
     * Returns the number of elements in this list. If this list contains more
     * than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     *
     * @return the number of elements in this list
     */
    int size();

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    boolean isEmpty();

    /**
     * Returns true if this list contains the specified element. More formally,
     * returns true if and only if this list contains at least one element e
     * such that (o==null ? e==null : o.equals(e)).
     *
     * @param o element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    boolean contains(Object o);

    // Modification Operations

    /**
     * Appends the specified element to the end of this list (optional
     * operation).
     *
     * Lists that support this operation may place limitations on what elements
     * may be added to this list. In particular, some lists will refuse to add
     * null elements, and others will impose restrictions on the type of
     * elements that may be added. List classes should clearly specify in their
     * documentation any restrictions on what elements may be added.
     *
     * @param o element to be appended to this list
     * @return true as specified by Collection API
     */
    boolean add(Object o);

    // Positional Access Operations

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException if the given index less than 0 or
	 * greater than or equals to the size.
     */
    Object get(int index);

    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation). Shifts the element currently at that position (if
     * any) and any subsequent elements to the right (adds one to their
     * indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws NullPointerException if the specified element is null and this
     *             list does not permit null elements
     * @throws IllegalArgumentException if some property of the specified
     *             element prevents it from being added to this list
	 * @throws IndexOutOfBoundsException if the given index less than 0 or
	 * greater than or equals to the size.
     */
    void add(int index, Object element);

    /**
     * Removes the element at the specified position in this list (optional
     * operation). Shifts any subsequent elements to the left (subtracts one
     * from their indices). Returns the element that was removed from the list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException if the given index less than 0 or
	 * greater than or equals to the size.
     */
    Object remove(int index);

    // Search Operations

    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element. More
     * formally, returns the lowest index i such that (o==null ? get(i)==null :
     * o.equals(get(i))), or -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
    int indexOf(Object o);

}