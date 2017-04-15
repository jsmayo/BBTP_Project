package edu.ncsu.csc216.bbtp;

import edu.ncsu.csc216.bbtp.model.TestingTypeList;
import edu.ncsu.csc216.bbtp.util.ArrayList;   

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import edu.ncsu.csc216.bbtp.model.TestCaseList;

/**
 * The main class for the BBTP tools. Holds references to the top-level data
 * structures that contain TestCase and TestingType objects and acts as the
 * controller between the model and the GUI presentation view.
 * 
 * @author Your Name Here
 */
public class BBTP extends Observable implements Serializable, Observer {

    /** Serial version UID. */
    private static final long serialVersionUID = 34992L;

    /**
     * Increment for increasing the capacity of the array of TestCaseLists
     */
    private static final int RESIZE = 3;
    /** A collection of TestCaseList */
    private TestCaseList testCases[];
    /** Number of TestCaseList */
    private int numLists;
    /** A collection of TestingTypes */
    private TestingTypeList testingTypes;
    /** Filename for saving the bbtp information */
    private String filename;
    /** True if bbtp has changed since last save */
    private boolean changed;
    /** The next number for a task list id */
    private int nextTestCaseListNum;

    /**
     * Constructor for the BBTP object. 
     */
    public BBTP() {
    	testCases = new TestCaseList[RESIZE];
    	
    }
    
    /**
     * Returns the value stored in changed.
     * @return True if the boolean stored in changed is True.
     */
    public boolean isChanged() {
    	return false;
    }
    
    /**
     * Sets the changed field to the given value.
     * @param b Boolean to set the changed field.
     */
    public void setChanged(boolean b) {
    	changed = b;
    }
    
    /**
     * Returns the filename.
     * @return The value given to the filename field.
     */
    public String getFilename() {
    	return filename;
    }
    
    /**
     * If the filename parameter is null or the empty string,
     * an  IllegalArgumentException is thrown. Otherwise, the filename 
     * field is set.
     * @param fn Name to set the filename as.
     * @throws IllegalArgumentException if the filename parameter is null or empty.
     */
    public void setFilename(String fn) {
    	if(fn == null || fn.isEmpty()) throw new IllegalArgumentException();
    	filename = fn;
    }
    
    /**
     * Returns the next TestCaseList number.
     * @return Number of the next TestCaseList.
     */
    private int getNextTestCaseListNum() {
    	return this.nextTestCaseListNum++;
    }
    
    /**
     * Increases the number for the NextTestCaseList by 1.
     */
    private void incNextTestCaseListNum() {
    	this.nextTestCaseListNum = getNextTestCaseListNum() + 1;
    }
    
    /**
     * Returns the number assigned to the current TestCaseList.
     * @return Number of the current TestCaseList.
     */
    public int getNumTestCaseLists() {
    	return numLists;
    }
    
    /**
     * Returns the TestCaseList at the given index. If the index is less than 0 
     * or the index or greater than size(), an IndexOutOfBoundsException will be thrown.
     * @param index Index to retrieve the TestCaseList from.
     * @return TestCaseList at the given index.
     * @throws IndexOutOfBoundsException if the index less than 0 or greater or equals to size()
     */
    public TestCaseList getTestCaseList(int index){
    	if(index < 0 || index >= testCases.length) throw new IndexOutOfBoundsException(); 
    	return new TestCaseList("string", "string");
    }
    
    /**
     * Returns the current TestingTypeList
     * @return testingTypes The current TestingTypeList.
     */
    public TestingTypeList getTestingTypeList() {
    	return testingTypes;
    }
    
    /**
     * Increases the number of current TestCaseLists by 1.
     * @return numLists the Current number of TestCaseLists (after increased).
     */
    public int addTestCaseList() {
    	this.incNextTestCaseListNum();
    	return numLists++;
    }
    
    /**
     * Removes a TestCaseList at the given index value.
     * @param index Index value to remove the TestCaseList from.
     * @throws IndexOutOfBoundsException if the index less than 0 or greater or equals 
     * the number of TestCaseLists available.
     */
    public void removeTestCaseList(int index) {
    	if(index < 0 || index >= testCases.length) throw new IndexOutOfBoundsException();
    }
    
    	
    /**
     * Saves the TestingTypeList and the array of TestCaseLists to the given
     * file using object serialization.
     * 
     * @param fname filename to save BBTP information to.
     * @return true is saved successfully
     */
    public boolean saveDataFile(String fname) {
        if (fname == null || fname.trim().equals("")) {
            System.err.println("Invalid filename" + fname);
            return false;
        } else {
            try {
                FileOutputStream fileOut = new FileOutputStream(fname);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                for (int i = 0; i < numLists; i++) {
                    out.writeObject(testCases[i]);
                }
                out.writeObject(testingTypes);
                out.writeObject(filename);
                out.writeInt(nextTestCaseListNum);
                changed = false;
                out.close();
                fileOut.close();
                return true;
            } catch (IOException e) {
                System.err.println("An error occurred while saving file " + fname);
                e.printStackTrace(System.err);
                return false;
            }
        }
    }

    /**
     * Opens a data file with the given name and creates the data structures
     * from the serialized objects in the file.
     * 
     * @param fname filename to create BBTP information from.
     * @return true is opened successfully
     */
    public boolean openDataFile(String fname) {
        if (changed) {
            saveDataFile(filename);
        }
        try {
            FileInputStream fileIn = new FileInputStream(fname);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList temp = new ArrayList();
            Object tl = in.readObject();
            while (tl instanceof TestCaseList) {
                TestCaseList l = (TestCaseList) tl;
                l.addObserver(this);
                temp.add(l);
                tl = in.readObject();
            }
            testCases = new TestCaseList[temp.size()];
            for (int i = 0; i < temp.size(); i++) {
                testCases[i] = (TestCaseList) temp.get(i);
            }
            numLists = temp.size();
            testingTypes = (TestingTypeList) tl;
            testingTypes.addObserver(this);
            filename = (String) in.readObject();
            nextTestCaseListNum = (int) in.readInt();
            for (int i = 0; i < numLists; i++) {
                TestCaseList list = testCases[i];
                for (int j = 0; j < list.size(); j++) {
                    list.getTestCaseAt(j).addObserver(list);
                }
            }
            for (int i = 0; i < testingTypes.size(); i++) {
                testingTypes.getTestingTypeAt(i).addObserver(testingTypes);
            }
            changed = false;
            in.close();
            fileIn.close();
            return true;
        } catch (IOException e) {
            System.err.println("An error occurred while reading file " + fname);
            e.printStackTrace(System.err);
            return false;
        } catch (ClassNotFoundException c) {
            System.err.println("Error reconstructing BBTP from file " + fname);
            c.printStackTrace(System.err);
            return false;
        }
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}