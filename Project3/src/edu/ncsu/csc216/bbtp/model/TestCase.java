package edu.ncsu.csc216.bbtp.model;

import java.util.Date;

public class TestCase {

	private static final long serialVersionUID = 1L;
	private String testCaseID;
	private Date creationDateTime;
	private String description;
	private String expectedResults;
	private String actualResults;
	private Date lastTestedDateTime;
	private boolean testedStatus;
	private boolean pass;
	private TestingType testingType;
	
	public TestCase(String a, String b, TestingType c, Date d, String e, boolean f, Date g, String h, boolean i) {
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String desc) {
		this.description = desc;
	}
	
	public void setExpectedResults(String exp) {
		this.expectedResults = exp;
	}
	
	public String getExpectedResults() {
		return this.expectedResults;
	}
	
	public void setActualResults(String act) {
		this.actualResults = act;
	}
	
	public String getActualResults() {
		return this.actualResults;
	}
	
	public Date getCreationDate() {
		return this.creationDateTime;
	}
	
	public void setCreationDateTime(Date date) {
		this.creationDateTime = date;
	}
	
	public Date getLastTestedDateTime() {
		return this.lastTestedDateTime;
	}
	
	public void setLastTestedDateTime(Date date) {
		this.lastTestedDateTime = date;
	}
	
	public boolean tested() {
		return this.testedStatus;
	}
	
	public void setTestedStatus(boolean tested) {
		this.testedStatus = tested;
	}
	
	public boolean pass() {
		return this.pass;
	}
	
	public void setPass(boolean passed) {
		this.pass = passed;
	}
	
	public void setTestingType(TestingType tt) {
		this.testingType = null;
	}
	
	public TestingType getTestingType() {
		return this.testingType;
	}
	
	public String getTestCaseID() {
		return this.testCaseID;
	}
	
	private void setTestCaseID(String id) {
		this.testCaseID = id;
	}

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

	@Override
	public String toString() {
		return "TestCase [testCaseID=" + testCaseID + ", description=" + description + ", expectedResults="
				+ expectedResults + ", actualResults=" + actualResults + ", testedStatus=" + testedStatus + ", pass="
				+ pass + "]";
	}
	
	
	
	
			
}
