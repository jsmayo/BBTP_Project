package edu.ncsu.csc216.bbtp.ui;

import java.util.Date;

import edu.ncsu.csc216.bbtp.model.TestingType;

/**
 * Simple class for transferring data within the GUI via events.
 * 
 * @author David R. Wright
 * @author Sarah Heckman
 * @author Jessica Young Schmidt
 */
public class TestCaseData {

    /** TestCase's id */
    private String testCaseID;
    /** TestCase's description */
    private String description;
    /** TestCase's testing type */
    private TestingType testingType;
    /** TestCase's creationDateTime */
    private Date creationDateTime;
    /** TestCase's lastTestedDateTime */
    private Date lastTestedDateTime;
    /** TestCase's tested flag */
    private boolean testedStatus;
    /** TestCase's pass flag */
    private boolean pass;
    /** TestCase's expected results */
    private String expectedResults;
    /** TestCase's actual results */
    private String actualResults;

    /**
     * Creates an empty TestCaseData object.
     */
    public TestCaseData() {
        this("", "", null, null, null, false, "", "", false);
    }

    /**
     * Creates a TestCaseData object from all fields.
     * 
     * @param testCaseID test case's id
     * @param description test case's description
     * @param testingType test case's testing type
     * @param creationDateTime test case's creation date and time
     * @param lastTestedDateTime test case's last tested date and time
     * @param testedStatusPass test case's test status
     * @param expectedResults test case's expected result
     * @param actualResults test case's actual result from last testing
     * @param pass test case's pass status from last testing
     */
    public TestCaseData(String testCaseID, String description, TestingType testingType, Date creationDateTime,
            Date lastTestedDateTime, boolean testedStatusPass, String expectedResults, String actualResults,
            boolean pass) {
        this.testCaseID = testCaseID;
        this.description = description;
        this.testingType = testingType;
        this.creationDateTime = creationDateTime;
        this.lastTestedDateTime = lastTestedDateTime;
        this.testedStatus = testedStatusPass;
        this.expectedResults = expectedResults;
        this.actualResults = actualResults;
        this.pass = pass;
    }

    /**
     * Returns the test case id
     * 
     * @return the testCaseID
     */
    public String getTestCaseID() {
        return testCaseID;
    }

    /**
     * Returns the test case's description
     * 
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the test case's testing type
     * 
     * @return the testingType
     */
    public TestingType getTestingType() {
        return testingType;
    }

    /**
     * Returns the test case's creation date and time
     * 
     * @return the creationDateTime
     */
    public Date getCreationDateTime() {
        return creationDateTime;
    }

    /**
     * Returns the test case's last tested date and time
     * 
     * @return the lastTestedDateTime
     */
    public Date getLastTestedDateTime() {
        return lastTestedDateTime;
    }

    /**
     * Returns true if the test case has been tested
     * 
     * @return true if tested
     */
    public boolean tested() {
        return testedStatus;
    }

    /**
     * Returns true if the test case passed the test during the last testing
     * 
     * @return true if passed
     */
    public boolean pass() {
        return pass;
    }

    /**
     * Returns the test case's expected results
     * 
     * @return the expectedResults
     */
    public String getExpectedResults() {
        return expectedResults;
    }

    /**
     * Returns the test case's actual results
     * 
     * @return the actualResults
     */
    public String getActualResults() {
        return actualResults;
    }

    /**
     * Returns the TestCaseData as an Object array for use in the GUI.
     * 
     * @return the TestCaseData as an Object array.
     */
    public Object[] getDataArray() {
        Object[] data = new Object[9];
        data[0] = testCaseID;
        data[1] = description;
        data[2] = testingType;
        data[3] = creationDateTime;
        data[4] = lastTestedDateTime;
        data[5] = testedStatus;
        data[6] = expectedResults;
        data[7] = actualResults;
        data[8] = pass;
        return data;
    }
}
