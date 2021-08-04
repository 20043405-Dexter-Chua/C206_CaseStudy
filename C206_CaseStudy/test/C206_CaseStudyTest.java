import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private TimetableRegistration tt1;
	private TimetableRegistration tt2;
	private ArrayList<TimetableRegistration> regTimetableList;
	
	//Nicolette
	private StudentInfo s1;
	private ArrayList<StudentInfo> studentList;
	
	@Before
	public void setUp() throws Exception {
			
		// TuitionTimetable Test [Dexter]
		tt1 = new TimetableRegistration(1, 1, "dchua647@gmail.com", "Pending", LocalDateTime.parse("2021-08-04T19:13:39.300360200"));
		tt2 = new TimetableRegistration(2, 1, "dtan746@gmail.com", "Pending", LocalDateTime.parse("2021-08-04T19:13:39.300360200"));
		
		regTimetableList = new ArrayList<TimetableRegistration>();	
		
		// Nicolette
		s1 = new StudentInfo("Lisa", 'F', 987654321, "123@gmail.com", "1/1/2020", "Singapore");
		studentList = new ArrayList<StudentInfo>();
	}

	// Timetable Test [Dexter]
	@Test 
	public void testAddTimetableRegistrations() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid timetable arraylist to add to", regTimetableList);

		// Given no objects in the arraylist, after adding 1 item, the size of the list is 1
		// The item just added is the same as the first item of the list
		C206_CaseStudy.addTimetableRegistration(regTimetableList, tt1);
		assertEquals("Test if Timetable Registration arraylist size is 1?", 1, regTimetableList.size());	
		assertSame("Test that Camcorder is added same as 1st item of the list?", tt1, regTimetableList.get(0));

		// Add another item. test The size of the list is 2?
		C206_CaseStudy.addTimetableRegistration(regTimetableList, tt2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, regTimetableList.size());
		assertSame("Test that Camcorder is added same as 2nd item of the list?", tt2, regTimetableList.get(1));
	}
	
	// View All Registrations
	@Test
	public void testRetrieveAllTimetableRegistrations() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Timetable arraylist to add to", regTimetableList);

		// Test if the list of Tuition Timetable retrieved from the C206_CaseStudy is empty
		String allRegistrations = C206_CaseStudy.retrieveAllTimetableRegistrations(regTimetableList);
		String testOutput = "";
		assertEquals("Check that ViewAllTimetableRegistrations is Empty", testOutput, allRegistrations);

		// Given an empty list, after adding 1 items, test if the size of the list is 1
		C206_CaseStudy.addTimetableRegistration(regTimetableList, tt1);
		assertEquals("Test if that Timetable arraylist size is 1?", 1, regTimetableList.size());

		// Test if the expected output string same as the list of Timetable Registrations retrieved
		// from the C206_CaseStudy
		allRegistrations = C206_CaseStudy.retrieveAllTimetableRegistrations(regTimetableList);

		testOutput = String.format("%-10d %-15d %-30s %-20s %-30s\n", 1, 1, "dchua647@gmail.com", "Pending", "04-08-2021 19:13:39");
		assertEquals("Check that ViewAllTimetableRegistration list", testOutput, allRegistrations);
	}

	@Test
	public void doDeleteTimetableRegistrationTest() {
		// Boundary Condition
		assertNotNull("Test if there is valid Timetable arraylist to loan from", regTimetableList);
		
		C206_CaseStudy.addTimetableRegistration(regTimetableList, tt1);
		C206_CaseStudy.addTimetableRegistration(regTimetableList, tt2);
		
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
	
	//Student test [Nicolette]-
	public void addStudentTest() {
		
		// boundary
		assertNotNull("Check if there is valid Camcorder arraylist to add to", studentList);
		
		// normal
		C206_CaseStudy.addStudent(studentList, s1);
		assertEquals("Check that Student arraylist size is 1", 1, studentList.size());
		assertSame("Check that Student is added", s1, studentList.get(0));
				
	} // addStudentTest
	
	public void viewStudentTest() {
		
		// boundary
		assertNotNull("Test if there is valid Student arraylist to retrieve student's information", studentList);
				
		//test if the list of students retrieved from the SourceCentre is empty - boundary
		String allStudent = C206_CaseStudy.retrieveStudent(studentList);
		String testOutput = "";
		assertEquals("Check viewStudent", testOutput, allStudent);
				
		// normal
		C206_CaseStudy.addStudent(studentList, s1);
		assertEquals("Test that Student arraylist size is 1", 1, studentList.size());
				
		// normal	
		allStudent = C206_CaseStudy.retrieveStudent(studentList);
		testOutput += String.format("\n%-10s %-10c %-10d %-15s %-15s %-10s", "Lisa", 'F', 987654321, "123@gmail.com", "1/1/2020", "Singapore");
			
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
	
	
	@After
	public void tearDown() throws Exception {
		// Timetable Test [Dexter]
		tt1 = null;
		tt2 = null;
		regTimetableList = null;
		
		//Student Test [Nicolette]
		s1 = null;
		studentList = null;
	}

}
