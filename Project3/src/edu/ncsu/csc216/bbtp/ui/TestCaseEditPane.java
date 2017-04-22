package edu.ncsu.csc216.bbtp.ui;

import java.util.Date;
import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import edu.ncsu.csc216.bbtp.model.TestingType;
import edu.ncsu.csc216.bbtp.model.TestingTypeList;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
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
	 * Constructor for creating an TestCaseEditPane
	 * 
	 * @param ttl An empty TestingTypeList.
	 */
	public TestCaseEditPane(TestingTypeList ttl) {
	// test case data is a member of testcase edit pane
		this(new TestCaseData(), ttl);
					
	}
	
	/**
	 * Constructor for TestCaseEditPane with values for the TestingTypeList and 
	 * TestCaseData.
	 * @param tcd TestCaseData 
	 * @param ttl TestingTypeList
	 */
	public TestCaseEditPane(TestCaseData tcd, TestingTypeList ttl) {
		super();
		this.testingTypes =  ttl;
		this.data = tcd;
		// Initially there is no mode selected
		add = false;
        edit = false;
		this.testingTypes.addObserver(this);
		init();
			
	}
	
    /**
     * Initializes the GUI.
     */
	private void init() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBorder(BorderFactory.createLineBorder(Color.black));
		initView();
		fillFields();
	}
	
	/**
     * Initializes the view.
     */
	private void initView() {
		//Create 1st panel under TestCaseListPane for TestCaseEditPane
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEADING));
        p.add(new JLabel("Testing Case ID: ", SwingConstants.LEFT));
        p.add(getTestCaseID());
        p.add(new JLabel("Testing Type: ", SwingConstants.LEFT));
        p.add(getTestingType());
        p.add(new JLabel("TestCreation Date & Time", SwingConstants.LEFT));
        p.add(getTestCreationDateSpinner());
        this.add(p);
        //Description label
        p = new JPanel(new FlowLayout(FlowLayout.LEADING));
        p.add(new JLabel("Description: ", SwingConstants.LEFT));
        this.add(p);
        
        //description JTextArea
        p = new JPanel(new FlowLayout(FlowLayout.LEADING));
        p.add(getTestCaseDescription());
        this.add(p);
        
        //tested checkbox and late test date row
        p = new JPanel(new FlowLayout(FlowLayout.LEADING));
        p.add(new JLabel("Tested? ", SwingConstants.LEFT));
        p.add(tested);
        p.add(new JLabel("Last Tested Date & Time", FlowLayout.LEADING));
        p.add(getLastTestedDateSpinner());
        this.add(p);
        
        //Expected Label
        p = new JPanel(new FlowLayout(FlowLayout.LEADING));
        p.add(new JLabel("Expected Results: ", SwingConstants.LEFT));
        this.add(p);
        
        //Expected JTextArea
        p = new JPanel(new FlowLayout(FlowLayout.LEADING));
        p.add(getExpectedResults());
        this.add(p);
        
        //Actual Label
        p = new JPanel(new FlowLayout(FlowLayout.LEADING));
        p.add(new JLabel("Actual Results: ", SwingConstants.LEFT));
        this.add(p);
        
        //Actual JTextArea
        p = new JPanel(new FlowLayout(FlowLayout.LEADING));
        p.add(getActualResults());
        this.add(p);
        
        //Passed label and checkbox
        p = new JPanel(new FlowLayout(FlowLayout.LEADING));
        p.add(new JLabel("Pass?: ", SwingConstants.LEFT));
        p.add(pass);
        this.add(p);
	}
        
  	/**
	 * Returns A JSpinner component for the creation date value. 
	 * @return testCreationDate Field value assigned to testCreationDate.
	 */
	protected JSpinner getTestCreationDateSpinner() {
			if(testCreationDate == null) {
				SpinnerDateModel sdm = new SpinnerDateModel();
				sdm.setValue(data.getLastTestedDateTime());
				testCreationDate = new JSpinner(sdm);
				testCreationDate.setEnabled(false);
				testCreationDate.setVisible(true);
			}
			return testCreationDate;	
	}
	
	/**
	 * Returns a JSpinner component for the last tested date value. 
	 * @return fieldValue assigned to lastTestedDate.
	 */
	protected JSpinner getLastTestedDateSpinner() {
		if(testLastTestedDate == null) {
			SpinnerDateModel sdm = new SpinnerDateModel();
			sdm.setValue(data.getLastTestedDateTime());
			testLastTestedDate = new JSpinner(sdm);
			testLastTestedDate.setEnabled(false);
			testLastTestedDate.setVisible(true);
		}
		return testLastTestedDate;	

	}
	
	/**
	 * Returns a Date object representation of the testCreationDate field.
	 * @return Date object of testCreationDate field. 
	 */
	protected Date getTestCreationDate() {
		return data.getCreationDateTime();
	}
	
	/**
	 * Returns a Date Object that represents the lastTestedDate field value.
	 * @return value of lastTestedDate.
	 */
	protected Date getLastTestedDate() {
		return data.getLastTestedDateTime();
			
	}
	
	/**
	 * Returns a JTextField component for the testCaseID field.
	 * @return testCaseID JTextField component for the TestCase ID field.
	 */
	protected JTextField getTestCaseID() {
		if (null == testCaseID) {
			testCaseID = new JTextField(50);
			testCaseID.setEditable(false);
			testCaseID.setVisible(true);
			testCaseID.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return testCaseID;
	}

	
	/**
	 * Returns the JTextArea field value of testCaseDescription.
	 * @return testCaseDescription the field value of testCaseDescription. 
	 */
	protected JTextArea getTestCaseDescription() {
		if (testCaseDescription == null) {
			testCaseDescription = new JTextArea(5, 70);
			testCaseDescription.setEditable(false);
			testCaseDescription.setVisible(true);
			testCaseDescription.setLineWrap(true);
			testCaseDescription.setAutoscrolls(true);
		}
		return testCaseDescription;
	}
	
	
	/**
	 * Returns the JComboBox component of tcTestingType. 
	 * @return JComboBox component of tcTestingType. 
	 */
	protected JComboBox<TestingType> getTestingType() {
		if(tcTestingType == null) {
			tcTestingType = new JComboBox<>();
			tcTestingType.setEditable(false);
			tcTestingType.setVisible(true);
		}
		else {
			TestingType[] tt = new TestingType[testingTypes.size()];
					for(int i = 0; i < this.testingTypes.size(); i++) 
						tt[i] = testingTypes.getTestingTypeAt(i);
					tcTestingType = new JComboBox<>(tt);
					tcTestingType.setEnabled(false);
					tcTestingType.setVisible(true);
		}
		return tcTestingType;
		
	}		
	
	
	/**
	 * Returns JTextArea component of expectedResults field.
	 * @return JTextArea component assigned to expectedResults.
	 */
	protected JTextArea getExpectedResults() {
		if(expectedResults == null) {
			expectedResults = new JTextArea(5, 70);
			expectedResults.setEditable(false);
			expectedResults.setVisible(true);
			expectedResults.setLineWrap(true);
			expectedResults.setAutoscrolls(true);
		}
		return expectedResults;
	}
	
	/**
	 * Returns JTextArea component of actualResults field.
	 * @return JTextArea component assigned to actualResults.
	 */
	protected JTextArea getActualResults() {
		if(actualResults == null) {
			actualResults = new JTextArea(5, 70);
			actualResults.setEditable(false);
			actualResults.setVisible(true);
			actualResults.setLineWrap(true);
			actualResults.setAutoscrolls(true);
		}
		return actualResults;
	}
	
	/**
	 * Returns the boolean value of pass.
	 * @return boolean value assigned to pass.
	 */
	protected JCheckBox pass() {
		if(pass == null) {
			pass = new JCheckBox();
			if(getLastTestedDate() != null) {
				pass.setSelected(true); //check if there is a date
				pass.setEnabled(false); //do not allow interaction
				pass.setVisible(true);
			}
		}
		return pass;
	}

	/**
	 * Returns the boolean value assigned to tested.
	 * @return tested boolean value assigned to tested. 
	 */
	protected JCheckBox tested() {
		if(tested == null) {
			tested = new JCheckBox();
			if(getLastTestedDate() != null) {
				tested.setSelected(true); //check if there is a date
				tested.setEnabled(false); //do not allow interaction
				tested.setVisible(true);
			}
		}
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
		if(lastTested == null) testLastTestedDate.setModel(new SpinnerDateModel()); // if null, create a new JSpinner
		else {
			SpinnerDateModel sdm = new SpinnerDateModel();
			sdm.setValue(lastTested);
			testLastTestedDate.setModel(sdm);
			//TODO notify observer here
		}
	}
	
	
	/**
	 * Checks to see if the Add option is enabled. 
	 * @return True if add mode is enabled. 
	 */
	protected boolean isAddMode() {
		return add;
	}
	
	/**
	 * Checks to see if the Edit option is enabled. 
	 * @return True if Edit option is enabled. 
	 */
	protected boolean isEditMode() {
		return edit;
	}
	
    /**
     * Enables add mode and disables edit.
     */
    public void enableAdd() {
        if (!add) {
            add = true;
            edit = false;
            clearFields();
        }
    }
	
	/**
	 * Disables add mode. 
	 */
    public void disableAdd() {
        add = false;
        clearFields();
    }
	
	/**
	 * Enables edit mode. 
	 * @param tcd TestCaseData to edit. 
	 */
	protected void enableEdit(TestCaseData tcd) {
		if (!edit) {
			edit = true;
			add = false;
			data = tcd;
			fillFields();
		}
	}
	
	
	/**
	 * Disables Edit mode.  
	 */
	protected void disableEdit() {
		edit = false;
		clearFields();
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
		fillFields();
	}
	

	    
    /**
     * Adds the given DocumentListener to the txtTestingTypeName and
     * txtTestingTypeDescription text fields.
     * 
     * @param e EventListener to attach to data obtained from the TestCase.
     */
    public void addFieldListener(EventListener e) {
    	
        getTestCreationDateSpinner().addChangeListener((ChangeListener) e);
        getLastTestedDateSpinner().addChangeListener((ChangeListener) e);
        getTestCaseID().addActionListener((ActionListener) e);
        getTestCaseDescription().addKeyListener((KeyListener) e);
        getTestingType().addActionListener((ActionListener) e);
        getExpectedResults().addKeyListener((KeyListener) e);
        getActualResults().addKeyListener((KeyListener) e);
        pass().addActionListener((ActionListener) e);
        tested().addActionListener((ActionListener) e);
    
    }
	
	/**
	 * Fills all fields of TestCaseEditPane.
	 */
	protected void fillFields() {
		if (data == null) { //TODO go back and make sure the ones that are accessible as a new panel are enabled
			testCaseID.setText("");
			testCaseID.setEnabled(false);
			tcTestingType = null;
			tcTestingType.setEnabled(false);
			expectedResults.setText("");
			actualResults.setText("");
			testCaseDescription.setText("");
			testCreationDate.setEnabled(false);
			testLastTestedDate.setEnabled(false);
			tested.setSelected(false);
			tested.setEnabled(false);
			pass.setSelected(false);
			pass.setEnabled(false);
		} else { 
			testCaseID.setText(data.getTestCaseID());
			tcTestingType.setSelectedItem(data.getTestingType());
			expectedResults.setText(data.getExpectedResults());
			actualResults.setText(data.getActualResults());
			testCaseDescription.setText(data.getDescription());
			this.setCreationDate(data.getCreationDateTime());
			this.setLastTestedDate(data.getLastTestedDateTime());
			tested.setSelected(data.tested());
			pass.setSelected(data.pass());
			
		}
		if (add || edit) { //these are the  minimum requirements for the ADD button to become enabled
			testCaseDescription.setEditable(true);
			expectedResults.setEditable(true);
			tcTestingType.setEditable(true);
			testCreationDate.setEnabled(true);
		}

	}

	 /**
     * Clears the fields by setting data to null.
     */
    public void clearFields() {
        data = null;
        fillFields();
    }
	
	/**
	 * Returns a TestCaseData object that holds data contained within field values.
	 * @return TestCaseData Values of the fields. 
	 */
	protected TestCaseData getFields() {
		if(data != null) return new TestCaseData();
		return new TestCaseData(); //do not return data, you need to update it to reflect the current fields
	}
	
	/**
	 * Notifies the Observer of TestCaseEditPane that a change has occured. 
	 * @param obs The Observable Object Observed by TestCaseEditPane.
	 * @param obj Object that underwent change. 
	 */
	public void update(Observable obs, Object obj) {
	
	}
		
	
}
