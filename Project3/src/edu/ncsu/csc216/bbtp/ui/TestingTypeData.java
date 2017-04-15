package edu.ncsu.csc216.bbtp.ui;

/**
 * Simple class for transferring data within the GUI via events.
 * 
 * @author David R. Wright
 * @author Sarah Heckman
 * @author Jessica Young Schmidt
 */
public class TestingTypeData {

    /** TestingType's id */
    private String testingTypeID;
    /** TestingType's name */
    private String testingTypeName;
    /** TestingType's description */
    private String testingTypeDesc;

    /**
     * An object that holds a TestingType's data for use in the GUI.
     * 
     * @param id TestingType's id
     * @param name TestingType's name
     * @param desc TestingType's description
     */
    public TestingTypeData(String id, String name, String desc) {
        testingTypeID = id;
        testingTypeName = name;
        testingTypeDesc = desc;
    }

    /**
     * Returns the TestingType's id.
     * 
     * @return the TestingType's id
     */
    public String getTestingTypeID() {
        return testingTypeID;
    }

    /**
     * Returns the TestingType's name.
     * 
     * @return the TestingType's name
     */
    public String getTestingTypeName() {
        return testingTypeName;
    }

    /**
     * Returns the TestingType's description.
     * 
     * @return the TestingType's description
     */
    public String getTestingTypeDesc() {
        return testingTypeDesc;
    }

    /**
     * Returns a string representation of the TestingType's data.
     * 
     * @return string representation of the TestingType's data.
     */
    public String toString() {
        return "ID: " + testingTypeID + "  Name: " + testingTypeName + "  Desc: " + testingTypeDesc;
    }

}