import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Revathi Selvasevaran, 20006739, 3 Aug 2021 5:36:50 pm
 */

public class TimetableMain {
	
	private static final int QUIT = 4;
	private static final int DELETE_TIMETABLE = 3;
	private static final int ADD_TIMETABLE = 2;
	private static final int VIEW_TIMETABLES = 1;

	public static void main(String[] args) {
		ArrayList<Timetable> ttList = new ArrayList<Timetable>(); 
		
		//DEMO
		LocalDateTime start1 = LocalDateTime.of(2019, 3, 28, 14, 30);
		LocalDateTime end1 = LocalDateTime.of(2019, 4, 28, 17, 30);
		Timetable tt1 = new Timetable("1",200.0, start1, end1,"FTF");
		
		LocalDateTime start2 = LocalDateTime.of(2019, 2, 28, 18, 00);
		LocalDateTime end2 = LocalDateTime.of(2019, 3, 28, 21, 00);
		Timetable tt2 = new Timetable("2",120.0, start2, end2,"HBL");
		
		ttList.add(tt1);
		ttList.add(tt2);
		//DEMO
		
		int option = 0;
		while(option!= QUIT)
		{
			TimetableMain.menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == VIEW_TIMETABLES)
			{
				TimetableMain.viewTimetables(ttList);
			}
			else if (option == ADD_TIMETABLE)
			{
				Timetable tt = TimetableMain.createTimetable();
				TimetableMain.addTimetable(ttList, tt);
			}
			else if (option == DELETE_TIMETABLE)
			{
				TimetableMain.deleteTimetable(ttList);
			}
			else if (option == QUIT)
			{
				TimetableMain.terminate();
			}
			else
			{
				System.out.println("Invalid option!");
			}
		}	
	}
	private static void terminate() {
		setHeader("END OF PROGRAM");
	}

	public static void menu() {
		TimetableMain.setHeader("TIMETABLE MANAGER");
		System.out.println("1. Display Timetables");
		System.out.println("2. Add Timetable");
		System.out.println("3. Delete Timetable");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	private static Timetable createTimetable() {

		String id = Helper.readString("Enter Timetable ID > ");
		double price = Helper.readDouble("Enter price of tuition run > $");
		
	
		System.out.println("< Enter Start Date Details > ");
		LocalDateTime startDateTime = inputDateTime();

		System.out.println("< Enter End Date Details > ");
		LocalDateTime endDateTime = inputDateTime();

		
		String mode = Helper.readString("Enter mode (HBL/FTF) > ");
		Timetable tt = new Timetable(id,price,startDateTime,endDateTime,mode.toUpperCase());
		return tt;
	}
	
	public static void addTimetable(ArrayList<Timetable> ttList, Timetable tt) {
		
		TimetableMain.setHeader("ADD TIMETABLE");
		ttList.add(tt);
		System.out.println("Timetable added.");
	}

	public static void deleteTimetable(ArrayList<Timetable> ttList) {
		TimetableMain.setHeader("DELETE TIMETABLE");
		TimetableMain.viewTimetables(ttList);
		
		String id = Helper.readString("Enter Timetable ID to be deleted > ");
		boolean matchID = doDeleteTimetable(ttList, id);

		if (matchID == false) 
		{
			System.out.println("Invalid ID");
		} 
		else 
		{
			System.out.println("Timetable deleted.");
		}
	}

	public static boolean doDeleteTimetable(ArrayList<Timetable> ttList, String id) {
		boolean matchID = false;

		for (int i = 0; i < ttList.size(); i++) 
		{
			String timetableID = ttList.get(i).getTimetableID();

			if (timetableID.equalsIgnoreCase(id)) 
			{
				ttList.remove(i);

				matchID = true;
			}
		}
		return matchID;
	}
	
	public static String retrieveAllTimetables(ArrayList<Timetable> ttList) {
		String output = "";
		
		for (int i = 0; i < ttList.size(); i++) {
		
			Timetable tt = ttList.get(i);
			String id = tt.getTimetableID();
			double price = tt.getPrice();
			LocalDateTime start = tt.getStartTime();
			LocalDateTime end = tt.getEndTime();
			String mode = tt.getMode();
			
			output += String.format("%-5s $%-10.2f %-25s %-25s %-5s\n", id,
					price, dateFormat(start), dateFormat(end),mode);
		}
		return output;
	}
	
	public static void viewTimetables(ArrayList<Timetable> ttList) {
		TimetableMain.setHeader("SHOWING ALL TIMETABLES");
		String output = String.format("%-5s %-10s %-25s %-25s %-5s\n", "ID", "PRICE", " START", " END", " MODE");
		output += retrieveAllTimetables(ttList);
		System.out.println(output);
	}
				
	public static String dateFormat(LocalDateTime dateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EE dd-MM-yyyy HHmm");
		String date = dateTime.format(formatter);
		return date;
	}
	
	private static LocalDateTime inputDateTime() {
		int year = Helper.readInt("Enter year (YYYY) > ");
		int mth = Helper.readInt("Enter month (MM) > ");
		int day = Helper.readInt("Enter day (DD) > ");
		int hr = Helper.readInt("Enter hour (hh) > ");
		int mins = Helper.readInt("Enter minute (mm) > ");
		LocalDateTime dateTime = LocalDateTime.of(year, mth, day, hr, mins); //year,month,day,hour,minute
		return dateTime;
	}
				
	
}	
///////////////////////////////////////////////////////////////////////	
/*	public static void deleteTimetable(ArrayList<Timetable> ttList) {
TimetableMain.setHeader("DELETE TIMETABLE");
TimetableMain.viewTimetables(ttList);

String id = Helper.readString("Enter Timetable ID to be deleted > ");
boolean matchID = false;

for (int i = 0; i<ttList.size(); i++)
{
Timetable tt = ttList.get(i);
String timetableID = tt.getTimetableID();

if (timetableID.equalsIgnoreCase(id))
{
ttList.remove(tt);
matchID = true;
System.out.println("Timetable Deleted.");
}
}
if (!matchID) {
System.out.println("Invalid ID");
}
}
*/	///////////////////////////////////////////////////	