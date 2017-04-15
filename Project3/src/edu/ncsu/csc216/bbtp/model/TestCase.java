package edu.ncsu.csc216.bbtp.model;

import java.util.Date;
import java.util.Observable;

/**
 * A representation of a TestCase in the BBTP application. A TestCase has a  TestingType.
 * 
 * @author Steven Mayo
 *
 */
public class TestCase extends Observable {

	//private static final long serialVersionUID = 7459L;
	private String testCaseID;
	private Date creationDateTime;
	private String description;
	private String expectedResults;
	private String actualResults;
	private Date lastTestedDateTime;
	private boolean testedStatus;
	private boolean pass;
	private TestingType testingType;
	
	/**
	 * Constructor for a TestCase.
	 * @param id ID of the TestCase.
	 * @param description Description of the TestCase.
	 * @param testingType Type of the TestCase.
	 * @param creationDateTime Date that the TestCase was created.
	 * @param expectedResults Expected results of the Test case.
	 * @param tested Boolean to represent if the TestCase has been tested.
	 * @param lastTestedDate Date the TestCase was last tested.
	 * @param actualResults Results after the TestCase was tested.
	 * @param pass Boolean to represent if the TestCase passed or failed.
	 */
	public TestCase(String id, String description, TestingType testingType, Date creationDateTime, String expectedResults, 
			boolean tested, Date lastTestedDate, String actualResults, boolean pass) {
		this.setCreationDateTime(creationDateTime);
		this.setTestingType(testingType);
		
	}
	
	/**
	 * Returns the description of the TestCase.
	 * @return Description of the TestCase.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the Description of the TestCase.
	 * @param desc Description of the TestCase.
	 */
	public void setDescription(String desc) {
		this.description = desc;
	}
	
	/**
	 * Sets the expectedResults field value to the given String.
	 * @param exp Expected results of the TestCase.
	 */
	public void setExpectedResults(String exp) {
		this.expectedResults = exp;
	}
	
	/**
	 * Returns the value assigned to the expectedResults field.
	 * @return expectedResults The expected results of the test case.
	 */
	public String getExpectedResults() {
		return this.expectedResults;
	}
	
	/**
	 * Sets the value of the actualResults field.
	 * @param act Actual results of the TestCase.
	 */
	public void setActualResults(String act) {
		this.actualResults = act;
	}
	
	/**
	 * Returns the actualResults field value of the current TestCase.
	 * @return actualResults Actual results of the current TestCase.
	 */
	public String getActualResults() {
		return this.actualResults;
	}
	
	/**
	 * Returns the Date of the TestCase creation.
	 * @return creationDate Creation date of the TestCase.
	 */
	public Date getCreationDate() {
		return this.creationDateTime;
	}
	
	/**
	 * Returns the value assigned to creationDateTime.
	 * @return creationDateTime Value assigned to the creationDateTime of TestCase. 
	 */
	public Date getCreationDateTime() {
		return creationDateTime;
	}
	
	

	/**
	 * Returns the value assigned to testCaseID.
	 * @return testCaseID The field value assigned to testCaseID. 
	 */
	public String getTestCaseID() {
		return testCaseID;
	}

	/**
	 * Sets the field value of testCaseID to that of: testCaseID.
	 * @param testCaseID the value assigned to testCaseID.
	 */
	public void setTestCaseID(String testCaseID) {
		this.testCaseID = testCaseID;
	}

	/**
	 * Returns the value assigned to lastTestedDateTime.
	 * @return lastTestedDateTime The field value assigned to lastTestedDateTime. 
	 */
	public Date getLastTestedDateTime() {
		return lastTestedDateTime;
	}

	/**
	 * Sets the field value of lastTestedDateTime to that of: lastTestedDateTime.
	 * @param lastTestedDateTime the value assigned to lastTestedDateTime.
	 */
	public void setLastTestedDateTime(Date lastTestedDateTime) {
		this.lastTestedDateTime = lastTestedDateTime;
	}

	/**
	 * Returns the value assigned to testedStatus.
	 * @return testedStatus The field value assigned to testedStatus. 
	 */
	public boolean tested() {
		return testedStatus;
	}

	/**
	 * Sets the field value of testedStatus to that of: testedStatus.
	 * @param testedStatus the value assigned to testedStatus.
	 */
	public void setTestedStatus(boolean testedStatus) {
		this.testedStatus = testedStatus;
	}

	/**
	 * Returns the value assigned to pass.
	 * @return pass The field value assigned to pass. 
	 */
	public boolean pass() {
		return pass;
	}

	/**
	 * Sets the field value of pass to that of: pass.
	 * @param pass the value assigned to pass.
	 */
	public void setPass(boolean pass) {
		this.pass = pass;
	}

	/**
	 * Returns the value assigned to testingType.
	 * @return testingType The field value assigned to testingType. 
	 */
	public TestingType getTestingType() {
		return testingType;
	}

	/**
	 * Sets the field value of testingType to that of: testingType.
	 * @param testingType the value assigned to testingType.
	 */
	protected void setTestingType(TestingType testingType) {
		this.testingType = testingType;
	}


	/**
	 * Sets the field value of creationDateTime to that of: creationDateTime.
	 * @param creationDateTime the value assigned to creationDateTime.
	 */
	public void setCreationDateTime(Date creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	
//	
//	public void setCreationDateTime(Date creationDT) {
//		this.creationDateTime = creationDateTime;
//	}
//
//	public void setLastTestedDateTime(Date date) {
//		this.lastTestedDateTime = date;
//	}
//	
//	public boolean tested() {
//		return this.testedStatus;
//	}
//	
//	public void setTestedStatus(boolean tested) {
//		this.testedStatus = tested;
//	}
//	
//	public boolean pass() {
//		return this.pass;
//	}
//	
//	public void setPass(boolean passed) {
//		this.pass = passed;
//	}
//	
//	public void setTestingType(TestingType tt) {
//		this.testingType = null;
//	}
//	
//	public TestingType getTestingType() {
//		return this.testingType;
//	}
//	
//	public String getTestCaseID() {
//		return this.testCaseID;
//	}
//	
//	private void setTestCaseID(String id) {
//		this.testCaseID = id;
//	}

	/**
	 * Generates the hashcode for the current TestCase.
	 * @return hashcode of the TestCase.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actualResults == null) ? 0 : actualResults.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((expectedResults == null) ? 0 : expectedResults.hashCode());
		result = prime * result + (pass ? 1231 : 1237);
		result = prime * result + ((testCaseID == null) ? 0 : testCaseID.hashCode());
		result = prime * result + (testedStatus ? 1231 : 1237);
		return result;
	}

	/**
	 * Compares the current object to that of the given. 
	 * @return true if the objects are equal on all fields. 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestCase other = (TestCase) obj;
		if (actualResults == null) {
			if (other.actualResults != null)
				return false;
		} else if (!actualResults.equals(other.actualResults))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (expectedResults == null) {
			if (other.expectedResults != null)
				return false;
		} else if (!expectedResults.equals(other.expectedResults))
			return false;
		if (pass != other.pass)
			return false;
		if (testCaseID == null) {
			if (other.testCaseID != null)
				return false;
		} else if (!testCaseID.equals(other.testCaseID))
			return false;
		if (testedStatus != other.testedStatus)
			return false;
		return true;
	}

	/**
	 * Returns a String with all field values separated by a comma. 
	 * @return String of all TestCase fields separated by a comma. 
	 */
	@Override
	public String toString() {
		return "TestCase [testCaseID=" + testCaseID + ", description=" + description + ", expectedResults="
				+ expectedResults + ", actualResults=" + actualResults + ", testedStatus=" + testedStatus + ", pass="
				+ pass + "]";
	}
	
	
	
	
			
}
