package edu.ncsu.csc216.bbtp.model;

public class TestingType {

	static final long serialVersionUID = 1L;
	
	private String name;
	
	private String description;
	
	private String testingTypeID;
	
	public TestingType(String name, String desc, String id) {
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String desc) {
		this.description = desc;
	}
	
	public String getTestingTypeID() {
		return this.testingTypeID;
	}
	
	private void setTestingTypeID(String id) {
		this.testingTypeID = id;
	}
	
	

	public int compareTo(TestingType tt) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((testingTypeID == null) ? 0 : testingTypeID.hashCode());
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
		TestingType other = (TestingType) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (testingTypeID == null) {
			if (other.testingTypeID != null)
				return false;
		} else if (!testingTypeID.equals(other.testingTypeID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TestingType [name=" + name + ", description=" + description + ", testingTypeID=" + testingTypeID + "]";
	}
	
	
}
