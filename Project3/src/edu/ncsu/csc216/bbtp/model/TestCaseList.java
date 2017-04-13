package edu.ncsu.csc216.bbtp.model;

import java.util.Date;

import edu.ncsu.csc216.bbtp.util.LinkedList;

public class TestCaseList {

	static final long servialVersionUID = 1L;
	private String name;
	private int nextTestCaseNum;
	private String testCaseListID;
	private LinkedList list;
	
	public TestCaseList(String list, String name){
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
	}
	
	public String getTestCaseListID() {
		return this.testCaseListID;
	}
	
	private void setTestCaseListID(String id) {
		this.testCaseListID = id;
	}
	
	private int getNextTestCaseNum() {
		return this.nextTestCaseNum;
	}
	
	private void incNextTestCaseNum() {
		this.nextTestCaseNum++;
	}
	
	public boolean addTestCase(String name, TestingType type, Date date, String id, boolean b) {
		return false;
	}
	
	public TestCase getTestCaseAt(int index){
		return null;
	}
	
	public int indexOf(String name) {
		return -1;
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return (list.isEmpty()); 
	}
	
	public TestCase removeTestCaseAt(int index) {
		return null;
	}
	
	public boolean removeTestCase(String name) {
		return false;
	}
	
	public Object[][] get2DArray() {
		return new Object[0][0];
	}
	
	public void update(Observabable observable, Object o) {	
	
	}
	
}
