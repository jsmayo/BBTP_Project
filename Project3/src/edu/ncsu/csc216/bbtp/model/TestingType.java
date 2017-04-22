package edu.ncsu.csc216.bbtp.model;
import java.io.Serializable;
import java.util.Observable;


/**
 * TestingType represents the Type classification for TestCase objects. 
 *
 * @author Steven Mayo
 */
public class TestingType extends Observable implements Serializable {

	static final long serialVersionUID = 459188L;
	
	private String name;
	
	private String description;
	
	private String testingTypeID;
	

	
	/**
	 * Constructor for TestingType
	 * @param name Name of the TestingType.
	 * @param desc Description of the TestingType.
	 * @param id ID of the TestingType. 
	 */
	public TestingType(String name, String desc, String id) {
		if(name == null || name.isEmpty() || id == null || id.isEmpty())
			throw new IllegalArgumentException();
		setName(name);
		setDescription(desc);
		setTestingTypeID(id);
	}
	
	/**
	 * Returns the value assigned to name.
	 * @return name The field value assigned to name. 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the field value of name to that of: name.
	 * @param name the value assigned to name.
	 */
	public void setName(String name) {
		if(name == null || name.isEmpty()) throw new IllegalArgumentException();
		this.name = name;
		setChanged(); //Marks the Observable as changed
		notifyObservers(this); //Sends a message to any Observer classes that the object has changed.
	}
	
	/**
	 * Returns the value assigned to description.
	 * @return description The field value assigned to description. 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the field value of description to that of: description.
	 * @param description the value assigned to description.
	 */
	public void setDescription(String description) {
		this.description = description;
		setChanged(); //Marks the Observable as changed
		notifyObservers(this); //Sends a message to any Observer classes that the object has changed.
	
	}

	/**
	 * Returns the value assigned to testingTypeID.
	 * @return testingTypeID The field value assigned to testingTypeID. 
	 */
	public String getTestingTypeID() {
		return testingTypeID;
	}

	/**
	 * Sets the field value of testingTypeID to that of: testingTypeID.
	 * @param testingTypeID the value assigned to testingTypeID.
	 */
	public void setTestingTypeID(String testingTypeID) {
		if(testingTypeID == null || testingTypeID.isEmpty()) throw new IllegalArgumentException();
		this.testingTypeID = testingTypeID;
		setChanged(); //Marks the Observable as changed
		notifyObservers(this); //Sends a message to any Observer classes that the object has changed.
	}

	/**
	 * Compares the current TestingType to that of the given TestingType.
	 * @param tt TestingType to compare against. 
	 * @return -1 if less than, 0 if equal, 1 if greater than. 
	 */
	public int compareTo(TestingType tt) {
		String other = tt.getTestingTypeID();
		return other.compareTo(this.getTestingTypeID()); //delegating to the testing type string ID compareTo method.
	}

	/**
	 * Generates a hash code for the current TestingType. 
	 * @return result Generated hashcode for the current TestingType. 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((description == null) ? 0 : description.hashCode());
		//result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((testingTypeID == null) ? 0 : testingTypeID.hashCode());
		return result;
	}

	/**
	 * Checks to see if the current object and the given object are equal on all
	 * fields. 
	 * @param obj Object to compare the current object against.
	 * @return True if the objects are equal on all fields. 
	 */
	@Override
	public boolean equals(Object obj) {
		TestingType other = (TestingType) obj;
		if(this.getTestingTypeID().equals(other.getTestingTypeID())) 
			return true; //if two testingTypeID's are a match, then they are considered equal.
		return false;
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		TestingType other = (TestingType) obj;
//		if (description == null) {
//			if (other.description != null)
//				return false;
//		} else if (!description.equals(other.description))
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (testingTypeID == null) {
//			if (other.testingTypeID != null)
//				return false;
//		} else if (!testingTypeID.equals(other.testingTypeID))
//			return false;
//		return true;
	}

	@Override
	public String toString() {
		return "TestingType [name=" + name + ", description=" + description + ", testingTypeID=" + testingTypeID + "]";
	}


	
}
