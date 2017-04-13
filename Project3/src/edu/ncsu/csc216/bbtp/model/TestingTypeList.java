package edu.ncsu.csc216.bbtp.model;

import edu.ncsu.csc216.bbtp.util.ArrayList;

public class TestingTypeList {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private int nextTestingTypeNum;
	
	private ArrayList list;
	
	
	
	public TestingTypeList() {
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean addTestingType(String name, String desc) {
		return false;
	}
	
	public TestingType getTestingTypeAt(int index) {
		return null;
	}
	
	public int indexOf(String id) {
		return -1;
	}
	
	public int indexOfName(String name) {
		return -1;
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public TestingType removeTestingTypeAt(int index) {
		TestingType removed = (TestingType) list.remove(index);
		return removed; //Simplify later if needed
	}
	
	public boolean removeTestingType(String id) {
		return false;
	}
	
	private int getNextTestingTypeNum() {
		return -1;
	}
	
	private void incNextTestingTypeNumber() {
		nextTestingTypeNum++;
	}
	
	public Object[][] get2DArray() {
		return null;
	}
	
	public void update(Observable o, Object obj) {
	}
	

}
