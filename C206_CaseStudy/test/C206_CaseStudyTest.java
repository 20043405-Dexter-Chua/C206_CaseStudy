import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	// DEXTER
	private TimetableRegistration ttr1;
	private TimetableRegistration ttr2;
	private ArrayList<TimetableRegistration> regTimetableList;

	// Nicolette
	private StudentInfo s1;
	private ArrayList<StudentInfo> studentList;

	// ANDERS
	private ArrayList<Tuition> tuitionList = new ArrayList<Tuition>();
	private Tuition test1;
	private Tuition test2;
	private Tuition test3;

	// REVATHI
	private Timetable tt1;
	private Timetable tt2;
	private ArrayList<Timetable> ttList;
	
	// JiaJun
	private Teacher t1;
	private Teacher t2;
	private ArrayList<Teacher> teacherList;
	

	@Before
	public void setUp() throws Exception {

		// Nicolette
		s1 = new StudentInfo("Lisa", 'F', 987654321, "123@gmail.com", "1/1/2020", "Singapore");
		studentList = new ArrayList<StudentInfo>();
		
		// TuitionTimetable Test [DEXTER]
				ttr1 = new TimetableRegistration(1, "1", "dchua647@gmail.com", "Pending",
						LocalDateTime.parse("2021-08-04T19:13:39.300360200"));
				ttr2 = new TimetableRegistration(2, "2", "dtan746@gmail.com", "Withdrawed",
						LocalDateTime.parse("2021-08-04T19:13:39.300360200"));

				regTimetableList = new ArrayList<TimetableRegistration>();

		// ANDERS --- Tuition Information Test Objects
		test1 = new Tuition("ABC001", "Tuition_Test1", "TestSubject1", "This is for testing", 789,
				"Pre Requisite Test");
		test2 = new Tuition("XYZ002", "Tuition_Test2", "TestSubject2", "This is for testing", 456,
				"Pre Requisite Test");
		test2 = new Tuition("ZYX089", "Tuition_Test3", "TestSubject3", "This is for testing", 132,
				"Pre Requisite Test");

		// REVATHI TEST DATA
		ttList = new ArrayList<Timetable>();

		LocalDateTime start1 = LocalDateTime.of(2019, 3, 28, 14, 30);
		LocalDateTime end1 = LocalDateTime.of(2019, 4, 28, 17, 30);
		tt1 = new Timetable("1", 200.0, start1, end1, "FTF");

		LocalDateTime start2 = LocalDateTime.of(2019, 2, 28, 18, 00);
		LocalDateTime end2 = LocalDateTime.of(2019, 3, 28, 21, 00);
		tt2 = new Timetable("2", 120.0, start2, end2, "HBL");
		
		// JiaJun Teacher Test
		t1 = new Teacher("Alex", 'M', "Alex@rp.edu.sg", "Qualification of Sports", "Sports");
		t2 = new Teacher("Amy", 'F', "Amy@rp.edu.sg", "Qualification of Music", "Music");
		teacherList = new ArrayList<Teacher>();

	}

//--------20043405-Dexter-Chua--------------------------------------------------------------------------------------------
	
	// Timetable Test [Dexter]
	@Test
	public void testAddTimetableRegistrations() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid timetable arraylist to add to", regTimetableList);

		// Given no objects in the arraylist, after adding 1 item, the size of the list
		// is 1
		// The item just added is the same as the first item of the list
		C206_CaseStudy.addTimetableRegistration(regTimetableList, ttr1);
		assertEquals("Test if Timetable Registration arraylist size is 1?", 1, regTimetableList.size());
		assertSame("Test that Timetable Registration added same as 1st item of the list?", ttr1,
				regTimetableList.get(0));

		// Add another item. test The size of the list is 2?
		C206_CaseStudy.addTimetableRegistration(regTimetableList, ttr2);
		assertEquals("Test that arraylist size is 2?", 2, regTimetableList.size());
		assertSame("Test that Second Registration added same as 2nd item of the list?", ttr2, regTimetableList.get(1));

	}

	// View All Registrations [Dexter]
	@Test
	public void testRetrieveAllTimetableRegistrations() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Timetable arraylist to add to", regTimetableList);

		// Test if the list of Tuition Timetable retrieved from the C206_CaseStudy is
		// empty
		String allRegistrations = C206_CaseStudy.retrieveAllTimetableRegistrations(regTimetableList);
		String testOutput = "";
		assertEquals("Check that ViewAllTimetableRegistrations is Empty", testOutput, allRegistrations);

		// Given an empty list, after adding 1 items, test if the size of the list is 1
		C206_CaseStudy.addTimetableRegistration(regTimetableList, ttr1);
		assertEquals("Test if that Timetable arraylist size is 1?", 1, regTimetableList.size());

		// Test if the expected output string same as the list of Timetable
		// Registrations retrieved
		// from the C206_CaseStudy
		allRegistrations = C206_CaseStudy.retrieveAllTimetableRegistrations(regTimetableList);

		testOutput = String.format("%-10d %-15d %-30s %-20s %-30s\n", 1, 1, "dchua647@gmail.com", "Pending",
				"04-08-2021 19:13:39");
		assertEquals("Check that ViewAllTimetableRegistration list", testOutput, allRegistrations);
	}

	// Cancel Registration [Dexter]
	@Test
	public void testDeleteTimetableRegistration() {
		// Boundary Condition
		assertNotNull("Test if there is valid Timetable arraylist to delete from", regTimetableList);

		C206_CaseStudy.addTimetableRegistration(regTimetableList, ttr1);
		C206_CaseStudy.addTimetableRegistration(regTimetableList, ttr2);

		// Normal Condition
		Boolean ok = C206_CaseStudy.doDeleteTimetableRegistration(regTimetableList, 1);
		assertTrue("Test if an available item is ok to delete?", ok);

		// Error Condition
		ok = C206_CaseStudy.doDeleteTimetableRegistration(regTimetableList, 1);
		assertFalse("Test if an same item is NOT ok to delete again?", ok);

		// Error Condition
		C206_CaseStudy.doDeleteTimetableRegistration(regTimetableList, 3);
		assertFalse("Test if a non-existing item is NOT ok to delete.", ok);

	}
	
	// Withdraw Timetable Registration [Dexter]
	@Test
	public void testWithdrawTimetableRegistration() {
		// Boundary Condition
		assertNotNull("Test if there is valid Timetable arraylist to withdraw from", regTimetableList);

		C206_CaseStudy.addTimetableRegistration(regTimetableList, ttr1);
		C206_CaseStudy.addTimetableRegistration(regTimetableList, ttr2);

		// Normal Condition
		Boolean ok = C206_CaseStudy.doWithdrawTimetableRegistration(regTimetableList, 1);
		assertTrue("Test if an available item is ok to withdraw?", ok);

		// Normal Condition
		String withdrawStatus = "Withdrawed";
		ok = C206_CaseStudy.doWithdrawTimetableRegistration(regTimetableList, 1);
		assertTrue("Test if the same item status has changed to 'Withdrawed'", regTimetableList.get(0).getRegStatus().equals(withdrawStatus));

	}
	
	// Search Timetable Registration [Dexter]
	@Test
	public void testSearchTimetableRegistration() {
		// Boundary Condition
		assertNotNull("Test if there is valid Timetable arraylist to search from", regTimetableList);

		C206_CaseStudy.addTimetableRegistration(regTimetableList, ttr1);
		C206_CaseStudy.addTimetableRegistration(regTimetableList, ttr2);

		// Normal Condition
		String searchReg = "Pending";
		Boolean ok = C206_CaseStudy.doSearchTimetableRegistration(regTimetableList, searchReg);
		assertTrue("Test if there are available items to display with registration status 'Pending'", ok);

		// Normal Condition
		searchReg = "Withdrawed";
		ok = C206_CaseStudy.doSearchTimetableRegistration(regTimetableList, searchReg);
		assertTrue("Test if there are available items to display with registration status 'Withdrawed'", ok);
		
		// Error Condition
		searchReg = "Confirmed";
		ok = C206_CaseStudy.doSearchTimetableRegistration(regTimetableList, searchReg);
		assertFalse("Test if there are no available items to display with registration status 'Confirmed'", ok);

	}
	
	
//--------20043405-Dexter-Chua--------------------------------------------------------------------------------------------
	
	// Student test [Nicolette]-
	public void addStudentTest() {

		// boundary
		assertNotNull("Check if there is valid Student arraylist to add to", studentList);

		// normal
		C206_CaseStudy.addStudent(studentList, s1);
		assertEquals("Check that Student arraylist size is 1", 1, studentList.size());

		// normal
		assertSame("Check that Student is added", s1, studentList.get(0));

	} // addStudentTest

	public void viewStudentTest() {

		// boundary
		assertNotNull("Test if there is valid Student arraylist to retrieve student's information", studentList);

		// test if the list of students retrieved from the SourceCentre is empty -
		// boundary
		String allStudent = C206_CaseStudy.retrieveStudent(studentList);
		String testOutput = "";
		assertEquals("Check viewStudent", testOutput, allStudent);

		// normal
		C206_CaseStudy.addStudent(studentList, s1);
		assertEquals("Test that Student arraylist size is 1", 1, studentList.size());

		// normal
		allStudent = C206_CaseStudy.retrieveStudent(studentList);
		testOutput += String.format("\n%-10s %-10c %-10d %-15s %-15s %-10s", "Lisa", 'F', 987654321, "123@gmail.com",
				"1/1/2020", "Singapore");

		assertEquals("Test that ViewAllCamcorderlist", testOutput, allStudent);

	} // viewStudentTest

	public void deleteStudentTest() {

		// normal
		assertNotNull("Test if there is valid Student arraylist", studentList);
		C206_CaseStudy.deleteStudent(studentList);

		// normal
		Boolean ok = C206_CaseStudy.deleteStudent(studentList);
		assertTrue("Test if student's information is deleted", ok);

		// error
		ok = C206_CaseStudy.deleteStudent(studentList);
		assertFalse("Test if same information is not deleted again", ok);

	} // deleteStudentTest

//--------20006739-Revathi--------------------------------------------------------------------------------------------
	@Test // REVATHI
	public void testAddTimetable() {
		// Timetable list is not null, so that can add a new item
		assertNotNull("Test if there is valid Timetable ArrayList to add to", ttList);
 
		// Given an empty list, after adding 1 Timetable, the size of the list is 1
		C206_CaseStudy.addTimetable(ttList, tt1);
		assertEquals("Test if that Timetable arraylist size is 1?", 1, ttList.size());

		// The Timetable just added is as same as the first Timetable of the list
		assertSame("Test that Timetable added is 1st item of the list?", tt1, ttList.get(0));

		// Add another Timetable. test The size of the list is 2?
		C206_CaseStudy.addTimetable(ttList, tt2);
		assertEquals("Test that Timetable arraylist size is 2?", 2, ttList.size());
		assertSame("Test that Timetable added is 2nd item of the list?", tt2, ttList.get(1));
	}

	@Test // REVATHI
	public void testRetrieveAllTimetables() {

		// Test if Timetable list is not null but empty - boundary
		assertNotNull("Test if there is valid Timetable arraylist to retrieve item from", ttList);

		// test if the list of Timetables retrieved from the TimetableManager is empty -
		// boundary
		String timetables = C206_CaseStudy.retrieveAllTimetables(ttList);
		String testOutput = "";
		assertEquals("Check no timetables inside list", testOutput, timetables);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addTimetable(ttList, tt1);
		assertEquals("Test that timetable arraylist size is 1", 1, ttList.size());

		// test if the expected output string same as the list of timetables retrieved
		// from TimetableManager
		timetables = C206_CaseStudy.retrieveAllTimetables(ttList);

		String S1 = C206_CaseStudy.dateFormat(LocalDateTime.of(2019, 3, 28, 14, 30));
		String E1 = C206_CaseStudy.dateFormat(LocalDateTime.of(2019, 4, 28, 17, 30));
		testOutput = String.format("%-5s $%-10.2f %-25s %-25s %-5s\n", "1", 200.0, S1, E1, "FTF");

		assertEquals("Test output for RetrieveTimetables()", testOutput, timetables);
	}

	@Test // REVATHI
	public void testDeleteTimetable() {

		// Test if Timetable list is not null but empty - boundary
		assertNotNull("Test if there is valid Timetable arraylist to retrieve item from", ttList);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addTimetable(ttList, tt1);
		C206_CaseStudy.addTimetable(ttList, tt2);
		assertEquals("Test that timetable arraylist size is 2", 2, ttList.size());

		// test delete- Size must be 1 after deleting 1 item
		C206_CaseStudy.doDeleteTimetable(ttList, "1");
		assertEquals("Test that timetable arraylist size is 1", 1, ttList.size());

		// test delete- item inside Timetable ArrayList should only be tt2
		assertNotSame("Test that timetable left in ArrayList is not tt1", tt1, ttList.get(0));

	}
	@Test // REVATHI -SPRINT 2
	public void testSearchTimetableMode() {
		// Test if Timetable list is not null but empty - boundary
		assertNotNull("Test if there is valid Timetable arraylist to retrieve item from", ttList);
		
		//test the samples that the list will have"FTF" and "HBL" Timetables inside
		assertSame("Test that there is FTF Timetable in list","FTF",tt1.getMode());
		assertSame("Test that there is HBL Timetable in list","HBL",tt2.getMode());
		
		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addTimetable(ttList, tt1);
		C206_CaseStudy.addTimetable(ttList, tt2);
		assertEquals("Test that timetable arraylist size is 2", 2, ttList.size());
		
		//Test doSearchMode() to see if expected output is same as actual output
		String S1 = C206_CaseStudy.dateFormat(LocalDateTime.of(2019, 3, 28, 14, 30));
		String E1 = C206_CaseStudy.dateFormat(LocalDateTime.of(2019, 4, 28, 17, 30));
		String testOutput = String.format("%-5s %-10s %-25s %-25s %-5s\n", "ID", "PRICE", " START", " END", " MODE");
		testOutput+= String.format("%-5s $%-10.2f %-25s %-25s %-5s\n", "1", 200.0, S1, E1, "FTF");
		
		String actual = C206_CaseStudy.doSearchMode(ttList,"FTF");
		//Output from method must be same as expected testOutput
		assertEquals("Test output for doSearchMode()", testOutput, actual);
	}
	
//-----------------------------------------------------------------------------------------------------------------	

	// --------------- ANDERS --------------

	/**
	 * Only 2 main test objects are used test-wide, test1 and test2 with index 0 and
	 * 1, respectively. (Thus the static final declaration for arrayList) All other
	 * test objects will be removed after test completes. ~ Anders
	 */

	// Test for Add method
	@Test
	public void addTuitionInformationTest() { //[ANDERS]

		// #1 - Test that after adding tuitionList is not Null --- Normal
		C206_CaseStudy.doAddArrayList(tuitionList, test1);
		// after adding
		assertNotNull("Test that tuitionList is not null after a Tuition object has been added", tuitionList);

		// #2 - Test after adding tuitionList's size increases by 1 --- Normal
		// before adding (at this point arrayList has a size of 1, after the first add in #1)
		C206_CaseStudy.doAddArrayList(tuitionList, test2);
		int afterAdd = tuitionList.size();
		assertEquals("Test that the size increase by 1, this shows that the Tuition object has only been added once.",
				2, afterAdd);

		// #3 - Test that after adding, tuitionList is added to the next available index
		// (last index) --- Normal
		// assuming index of 2 is the most recently added tuition object (tuition3)
		C206_CaseStudy.doAddArrayList(tuitionList, test3);
		assertSame("Test that the newest Tuition object is added to the next available 'space', aka the last index.",
				tuitionList.get(2), test3);
	}

	@Test
	public void viewAllTuitionInformationTest() { //[ANDERS]
		C206_CaseStudy.doAddArrayList(tuitionList, test1);
		C206_CaseStudy.doAddArrayList(tuitionList, test2);
		// #1 - Test that tuitionList is not Null for information to be displayed
		assertNotNull("Test that arrayList is not null so information can be displayed", tuitionList);
//		assertNotEquals("Test that arrayList is not null so information can be displayed", tuitionList.size(), 0);

		// #2 - Test that after an object is removed, it does is not displayed.
		/**
		 * Assuming tuition object of index 1 is being removed: This test combs through
		 * the entire arrayList to look for the removed Tuition objected called,
		 * removed. If found, returns a false for boolean variable 'isRemoved'
		 */
		Tuition removed = tuitionList.get(1);
		tuitionList.remove(tuitionList.get(1));
		boolean isRemoved = true;
		for (Tuition t : tuitionList) {
			if (t == removed) {
				isRemoved = false;
			}
		}
		assertTrue("Test that Tuition oject 'removed' is not found in the arrayList thus it has been removed",
				isRemoved);
	}

	@Test
	public void deleteTuitionInformationTest() { //[ANDERS]
		C206_CaseStudy.doAddArrayList(tuitionList, test1);
		C206_CaseStudy.doAddArrayList(tuitionList, test2);
		// #1 - Test that tuitionList is not null before any objects can be removed.
		assertNotNull("Test that tuitionList is not null so that an item can be removed", tuitionList);

		// #2 - Test that when a Tuition object is removed from tuitionList, the size of
		// the arrayList decreases by 1, assuming that there are only 2 objects
		// after removing
		tuitionList.remove(test2);
		int afterRemove = tuitionList.size();
		assertEquals("Test that only 1 Tuition object has been removed", 1, afterRemove);

		// #3 - Test that after an object is removed, it does is not displayed.
		/**
		 * Assuming tuition object of index 1 is being removed: This test combs through
		 * the entire arrayList to look for the removed Tuition objected called,
		 * removed. If found, returns a false for boolean variable 'isRemoved'
		 */
		Tuition removed = tuitionList.get(0);
		tuitionList.remove(tuitionList.get(0));
		boolean isRemoved = true;
		for (Tuition t : tuitionList) {
			if (t == removed) {
				isRemoved = false;
			}
		}
		assertTrue("Test that Tuition oject 'removed' is not found in the arrayList thus it has been removed",
				isRemoved);
	}
	//----------------------------------------JiaJun--------------------------------------- Teacher Test
	@Test
	public void viewAllTeacherTest(){
		//Normal Test: Test for all teacher display
		teacherList.add(t1);
		teacherList.add(t2);
		assertNotNull("Test that all teachers can be displayed", teacherList);
		
		//Boundary Test: Test that there are no duplicates
		assertNotSame("Test that teachers are not duplicate", t1, teacherList.get(1));
		
		//Normal Test: Test that the size of the list is 2
		assertEquals("Test that teacher arraylist size is 1", 2, teacherList.size());
	}
	
	@Test
	public void addTeacherTest() {
		//Normal Test: Test that after adding a teacher, the size should be 1
		teacherList.add(t1);
		assertEquals("Test that teacher successfully added", 1, teacherList.size());
		teacherList.remove(t1);
		
		//Boundary Test: Test that the email for new teacher is not same to other teachers
		teacherList.add(t1);
		teacherList.add(t2);
		assertNotSame("Test that teachers are not duplicate", t1.getEmail(), teacherList.get(1).getEmail());
		teacherList.remove(t1);
		teacherList.remove(t2);
		
		//Normal Test: Test that information for teacher is all filled
		teacherList.add(t1);
		assertNotNull("Test that all teachers can be displayed", teacherList.get(0).getEmail());
		teacherList.remove(t1);
	}
	
	@Test
	public void deleteTeacherTest() {
		//Normal Test: Test that the teacher is deleted successfully
		teacherList.add(t1);
		teacherList.remove(t1);
		assertEquals("Test that teacher successfully deleted", 0, teacherList.size());
		
		//Boundary Test: Test that no teacher will be remove when the delete is invalid
		teacherList.add(t2);
		teacherList.remove(t1);
		assertEquals("Test that no teacher has been deleted arraysize remains the same", 1, teacherList.size());
		
		//Error Test: Test that one teacher can only be deleted once
		teacherList.add(t1);
		teacherList.remove(t1);
		teacherList.remove(t1);
		assertNotSame("Test that one teacher can only be deleted once", t1, teacherList.get(0));
	}
	

	@After
	public void tearDown() throws Exception {
		// Timetable Registration Test [Dexter]
		ttr1 = null;
		ttr2 = null;
		regTimetableList = null;

		// Student Test [Nicolette]
		s1 = null;
		studentList = null;

		// Tuition Information Test --- Anders
		test1 = null; 
		test2 = null; 
		test3 = null; 
		tuitionList = null;
		 

		// Timetable Test [Revathi]
		tt1 = null;
		tt2 = null;
		ttList = null;
		
		// Teacher Test [JiaJun]
		t1 = null;
		t2 = null;
		teacherList = null;

	}

}
