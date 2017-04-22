package edu.ncsu.csc216.bbtp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Observable;


/**
 * A representation of a TestCase in the BBTP application. A TestCase has a  TestingType.
 * 
 * @author Steven Mayo
 *
 */
public class TestCase extends Observable implements Serializable {

	private static final long serialVersionUID = 7459L;
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
		//if(description == null || description.isEmpty() || description.length() == 0) throw new IllegalArgumentException();
		setDescription(description);
		setExpectedResults(expectedResults);
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
	 * @throws IllegalArgumentException  If the 
	 * expectedResults parameter is  null, the empty string,
	 *  or whitespace only
	 */
	public void setDescription(String desc) {
		if(desc == null || desc.isEmpty()) throw new IllegalArgumentException();
		for(int i = 0; i < description.length(); i++) {
			if(!Character.isWhitespace(desc.charAt(i))) {
				this.description = desc; //exit loop at first instance of non WS char.
				setChanged();
				notifyObservers(this);
				return;
			}
		}
		throw new IllegalArgumentException(); //if exiting the loop -> nothing but whitespace	
	}
	
	/**
	 * Sets the expectedResults field value to the given String.
	 * @param exp Expected results of the TestCase.
	 */
	public void setExpectedResults(String exp) {
		if(exp == null || exp.isEmpty()) throw new IllegalArgumentException();
		for(int i = 0; i < exp.length(); i++) {
			if(!Character.isWhitespace(exp.charAt(i))) {
				this.expectedResults = exp; //exit loop at first instance of non WS char.
				setChanged();
				notifyObservers(this);
				return; 
			}
		}
		throw new IllegalArgumentException(); //if exiting the loop -> nothing but whitespace
	}
	
	/**
	 * Returns the value assigned to the expectedResults field.
	 * @return expectedResults The expected results of the test case.
	 */
	public String getExpectedResults() {
		return this.expectedResults;
	}
	
	/**
	 * Sets the value of the actualResults field
	 * @param act Actual results of the TestCase.
	 */
	public void setActualResults(String act) {
		if(!testedStatus) { //if not tested, set to param and notify.
			actualResults = act;
			setChanged();
			notifyObservers(this);
		}
		else { //if tested
			if(act == null || act.isEmpty()) throw new IllegalArgumentException();
			for(char c: act.toCharArray()) {
				if(!Character.isWhitespace(c)) {
				this.actualResults = act; //if here, not null or empty, not all WS chars. Set and notify.  
				setChanged(); 
				notifyObservers(this);
				}
			}		
		}
	}
	
	/**
	 * Returns the actualResults field value of the current TestCase.
	 * @return actualResults Actual results of the current TestCase.
	 */
	public String getActualResults() {
		return this.actualResults;
	}
	
	/**
	 * Sets the field value of creationDateTime to that of: creationDateTime.
	 * @param creationDateTime the value assigned to creationDateTime.
	 * @throws IllegalArgumentException if the creationDateTime is null.
	 */
	public void setCreationDateTime(Date creationDateTime) {
		if(creationDateTime == null) throw new IllegalArgumentException();
		this.creationDateTime = creationDateTime;
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
		if(testCaseID == null || testCaseID.isEmpty()) throw new IllegalArgumentException();
		this.testCaseID = testCaseID;
		setChanged();
		notifyObservers();
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
	 * The given date can only be null if the TestCase has not previously been tested.
	 * @param lastTestedDateTime the value assigned to lastTestedDateTime.
	 * @throws IllegalArgumentException if a null date is provided for a TestCase that's
	 * been marked as tested. 
	 */
	public void setLastTestedDateTime(Date lastTestedDateTime) {
		if(testedStatus && lastTestedDateTime == null) throw new IllegalArgumentException();
		this.lastTestedDateTime = lastTestedDateTime;
		setChanged();
		notifyObservers(this);
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
		setChanged();
		notifyObservers(this);
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
		setChanged();
		notifyObservers(this);
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
	private void setTestingType(TestingType testingType) {
		if(testingType == null) throw new IllegalArgumentException();
		this.testingType = testingType;
		setChanged();
		notifyObservers();
		//CHANGE BACK TO PRIVATE. COULD NOT PASS JENKINS
	}

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
		TestCase tc = (TestCase) obj;
		if(this.getTestCaseID().equals(tc.getTestCaseID())) return true;
		return false; 
		
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		TestCase other = (TestCase) obj;
//		if (actualResults == null) {
//			if (other.actualResults != null)
//				return false;
//		} else if (!actualResults.equals(other.actualResults))
//			return false;
//		if (description == null) {
//			if (other.description != null)
//				return false;
//		} else if (!description.equals(other.description))
//			return false;
//		if (expectedResults == null) {
//			if (other.expectedResults != null)
//				return false;
//		} else if (!expectedResults.equals(other.expectedResults))
//			return false;
//		if (pass != other.pass)
//			return false;
//		if (testCaseID == null) {
//			if (other.testCaseID != null)
//				return false;
//		} else if (!testCaseID.equals(other.testCaseID))
//			return false;
//		if (testedStatus != other.testedStatus)
//			return false;
//		return true;
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


	/**
	 * Compares the given TestCase against that of the current TestCase. The
	 * Comparison is made between the Date object representing the lastTestedDateTime
	 * field of both TestCases. 
	 * @param tc TestCase to compare the current TestCase against. 
	 * @return 0 if the value of both TestCase's lastTestDateTime are equal, -1 if
	 * the current is less than the given, or 1 if the current is greater than the given. 
	 */
	public int compareTo(TestCase tc) {
		return this.getLastTestedDateTime().compareTo(tc.getLastTestedDateTime());
	}

	
	
	
	
	
			
}
