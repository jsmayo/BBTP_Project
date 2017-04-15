package edu.ncsu.csc216.bbtp.ui;

import java.util.Date;
import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import edu.ncsu.csc216.bbtp.model.TestingType;
import edu.ncsu.csc216.bbtp.model.TestingTypeList;

import java.io.Serializable;

/**
 * Panel to display a list of TestCases.
 * 
 * @author Steven Mayo
 */
public class TestCaseEditPane extends JPanel implements Observer, Serializable {

	private static final long serialVersionUID = 5479139338455751629L;
	private TestingTypeList testingTypes;
	private JTextField testCaseID;
	private JComboBox<TestingType> tcTestingType;
	private JTextArea expectedResults;
	private JTextArea actualResults;
	private JTextArea testCaseDescription;
	private JSpinner testCreationDate;
	private JSpinner testLastTestedDate;
	private JCheckBox tested;
	private JCheckBox pass;
	private boolean add;
	private boolean edit;
	private TestCaseData data;
	
	/**
	 * Constructor for TestCaseEditPane
	 * @param ttl TestingTypeList.
	 */
	public TestCaseEditPane(TestingTypeList ttl) {
		init();
		initView();
	
	}
	
	/**
	 * Constructor for TestCaseEditPane with values for the TestingTypeList and 
	 * TestCaseData.
	 * @param tcd TestCaseData 
	 * @param ttl TestingTypeList
	 */
	public TestCaseEditPane(TestCaseData tcd, TestingTypeList ttl) {
		if(testingTypes != null) testingTypes = ttl;
		
	}
	
	/**
	 * Initiates the JPanel to add components. NOT SURE
	 */
	private void init() {
	}
	
	/**
	 * Initiates the JPanel to show components. NOT SURE
	 */
	private void initView() {
	}
	
	/**
	 * Returns A JSpinner component for the creation date value. 
	 * @return testCreationDate Field value assigned to testCreationDate.
	 */
	protected JSpinner getTestCreationDateSpinner() {
		return testCreationDate;
	}
	
	/**
	 * Returns a JSpinner component for the last tested date value. 
	 * @return fieldValue assigned to lastTestedDate.
	 */
	protected JSpinner getLastTestedDateSpinner() {
		return testLastTestedDate;
	}
	
	/**
	 * Returns a Date object representation of the testCreationDate field.
	 * @return Date object of testCreationDate field. 
	 */
	protected Date getTestCreationDate() {
		return new Date();
	}
	
	/**
	 * Returns a Date Object that represents the lastTestedDate field value.
	 * @return value of lastTestedDate.
	 */
	protected Date getLastTestedDate() {
		return new Date();
	}
	
	/**
	 * Returns a JTextField component for the testCaseID field.
	 * @return testCaseID JTextField component for the TestCase ID field.
	 */
	protected JTextField getTestCaseID() {
		return testCaseID;
	}
	
	/**
	 * Returns the JTextArea field value of testCaseDescription.
	 * @return testCaseDescription the field value of testCaseDescription. 
	 */
	protected JTextArea getTestCaseDescription() {
		return testCaseDescription;
	}
	
	/**
	 * Returns the JComboBox component of tcTestingType. 
	 * @return JComboBox component of tcTestingType. 
	 */
	protected JComboBox<TestingType> getTestingType() {
		return tcTestingType;
	}
	
	/**
	 * Returns JTextArea component of expectedResults field.
	 * @return JTextArea component assigned to expectedResults.
	 */
	protected JTextArea getExpectedResults() {
		return expectedResults;
	}
	
	/**
	 * Returns JTextArea component of actualResults field.
	 * @return JTextArea component assigned to actualResults.
	 */
	protected JTextArea getActualResults() {
		return actualResults;
	}
	
	/**
	 * Returns the boolean value of pass.
	 * @return boolean value assigned to pass.
	 */
	protected JCheckBox pass() {
		return pass;
	}
	
	/**
	 * Returns the boolean value assigned to tested.
	 * @return tested boolean value assigned to tested. 
	 */
	protected JCheckBox tested() {
		return tested;
	}
	
	
	/**
	 * Sets the field value for testCreationDate to that of the given parameter. 
	 * @param creation Date to assign to testCreationDate.
	 */
	protected void setCreationDate(Date creation) {
		//this.testCreationDate 
	}
	
	/**
	 * Sets the Date of lastTestedDate field to that of the given parameter. 
	 * @param lastTested Date to assign to lastTested.
	 */
	protected void setLastTestedDate(Date lastTested) {
		//this.testLastTestedDate = lastTested;
	}
	
	
	/**
	 * Checks to see if the Add option is enabled. 
	 * @return True if add mode is enabled. 
	 */
	protected boolean isAddMode() {
		add = true;
		return add;
	}
	
	/**
	 * Checks to see if the Edit option is enabled. 
	 * @return True if Edit option is enabled. 
	 */
	protected boolean isEditMode() {
		return (edit);
	}
	
	/**
	 * Enables add mode. 
	 */
	protected void enableAdd() {
	}
	
	/**
	 * Disables add mode. 
	 */
	protected void disableAdd() {
	}
	
	/**
	 * Enables edit mode. 
	 * @param tcd TestCaseData to edit. 
	 */
	protected void enableEdit(TestCaseData tcd) {
	}
	
	
	/**
	 * Disables Edit mode.  
	 */
	protected void disableEdit() {
	}
	
	/**
	 * Checks to see if the fields of the TestCaseEditPane are empty. 
	 * @return true if all fields are NOT empty. 
	 */
	protected boolean fieldsNotEmpty() {
		return false;
	}
	
	/**
	 * Sets the TestCaseData to that of the given parameter. 
	 * @param tcd TestCaseData to set. 
	 */
	protected void setTestCaseData(TestCaseData tcd) {
		this.data = tcd;
	}
	
	/**
	 * Adds an EventListener to the current field.  
	 * @param e EventListener to add to the current field. 
	 */
	protected void addFieldListener(EventListener e) {
	}
	
	/**
	 * Fills all fields of TestCaseEditPane.
	 */
	protected void fillFields() {
	}
	/**
	 * Clears all fields of TestCaseEditPane.
	 */
	protected void clearFields() {
	}
	
	/**
	 * Returns a TestCaseData object that holds data contained within field values.
	 * @return TestCaseData Values of the fields. 
	 */
	protected TestCaseData getFields() {
		if(data != null) return new TestCaseData();
		return new TestCaseData();
	}
	
	/**
	 * Notifies the Observer of TestCaseEditPane that a change has occured. 
	 * @param obs The Observable Object Observed by TestCaseEditPane.
	 * @param obj Object that underwent change. 
	 */
	public void update(Observable obs, Object obj) {
	
	}
		
	
}
