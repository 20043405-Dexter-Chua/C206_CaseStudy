import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Revathi Selvasevaran, 20006739, 2 Aug 2021 5:05:41 pm
 */

public class TimetableTest {
	private Timetable tt1;
	private Timetable tt2;
	private ArrayList<Timetable> ttList;
	
	
	public TimetableTest() {
		super();
	}
	@Before
	public void setUp() throws Exception {
		// prepare test data
		ttList = new ArrayList<Timetable>();
		LocalDateTime localDateTimeSTA = LocalDateTime.of(2019, 3, 28, 14, 30);
		LocalDateTime localDateTimeEND = LocalDateTime.of(2019, 4, 28, 17, 30);
		Timetable tt1 = new Timetable("1",200.0, localDateTimeSTA, localDateTimeEND,"FTF");
		
		LocalDateTime localDateTimeSTA2 = LocalDateTime.of(2019, 2, 28, 18, 00);
		LocalDateTime localDateTimeEND2 = LocalDateTime.of(2019, 3, 28, 21, 00);
		Timetable tt2 = new Timetable("2",120.0, localDateTimeSTA2, localDateTimeEND2,"HBL");
		
	}

	@Test
	public void testAddTimetable() {
		// Timetable list is not null, so that can add a new item
		assertNotNull("Test if there is valid Timetable ArrayList to add to", ttList);

		// Given an empty list, after adding 1 Timetable, the size of the list is 1
		TimetableMain.addTimetable(ttList, tt1);
		assertEquals("Test if that Timetable arraylist size is 1?", 1, ttList.size());
		
		// The Timetable just added is as same as the first Timetable of the list
		assertSame("Test that Timetable added is 1st item of the list?", tt1, ttList.get(0));

		// Add another Timetable. test The size of the list is 2?
		TimetableMain.addTimetable(ttList, tt2);
		assertEquals("Test that Timetable arraylist size is 2?", 2, ttList.size());
		assertSame("Test that Timetable added is 2nd item of the list?", tt2, ttList.get(1));
	}
	
	@Test
	public void testRetrieveTimetables() {
		
		// Test if Timetable list is not null but empty - boundary
		assertNotNull("Test if there is valid Timetable arraylist to retrieve item from", ttList);
				
		//test if the list of Timetables retrieved from the TimetableManager is empty - boundary
		String timetables= TimetableMain.retrieveAllTimetables(ttList);
		String testOutput = "";
		assertEquals("Check no timetables inside list", testOutput, timetables);

		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		TimetableMain.addTimetable(ttList, tt1);
		TimetableMain.addTimetable(ttList, tt2);
		assertEquals("Test that timetable arraylist size is 2", 2, ttList.size());

		//test if the expected output string same as the list of timetables retrieved from TimetableManager
		timetables = TimetableMain.retrieveAllTimetables(ttList);
		
		String S1 = TimetableMain.dateFormat(LocalDateTime.of(2019, 3, 28, 14, 30));
		String E1 = TimetableMain.dateFormat(LocalDateTime.of(2019, 4, 28, 17, 30));
		testOutput = String.format("%-5s %-10.2f %-25s %-25s %-5s\n","1",200.0, S1, E1,"FTF");
		
		assertEquals("Test output for RetrieveTimetables()", testOutput, timetables);
	}

	@Test
	public void testDeleteTimetable() {
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		TimetableMain.addTimetable(ttList, tt1);
		TimetableMain.addTimetable(ttList, tt2);
		assertEquals("Test that timetable arraylist size is 2", 2, ttList.size());

		// test delete- Size must be 1 after deleting 1 item
		TimetableMain.deleteTimetable(ttList);
		assertEquals("Test that timetable arraylist size is 1", 1, ttList.size());
		
		//test delete- item inside Timetable ArrayList should only be tt2
		assertEquals("Test that timetable left in ArrayList is not tt1",tt2,ttList.get(0));
		
	}
	
	@After
	public void tearDown() throws Exception {
		tt1 = null;
		tt2 = null;

		ttList = null;
	}

}