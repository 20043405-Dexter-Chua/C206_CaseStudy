import java.time.LocalDateTime;
import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_ACCOUNT = 1;
	private static final int OPTION_REGISTRATION = 2;
	private static final int OPTION_INFORMATION = 3;
	private static final int OPTION_TIMETABLE = 4;
	private static final int OPTION_TEACHERS = 5;
	private static final int OPTION_QUIT = 6;
	
	private static final ArrayList<TimetableRegistration> regTimetableList = new ArrayList<TimetableRegistration>();
	private static final ArrayList<Tuition> tuitionList = new ArrayList<Tuition>();
	
	// Nicolette
	private static final int STUDENT_ADD = 1;
	private static final int STUDENT_VIEW = 2;
	private static final int STUDENT_DELETE = 3;
	private static final int STUDENT_QUIT = 4;
	
	private static final ArrayList<StudentInfo> studentList = new ArrayList<StudentInfo>();

	public static void main(String[] args) {
		// Objects for testing
		
		// Objects for student-
		studentList.add(new StudentInfo("Lisa", 'F', 987654321, "123@gmail.com", "1/1/2020", "Singapore"));
				
		// Objects for tuition registration (DEXTER)
		regTimetableList.add(new TimetableRegistration(1, 1, "20043405@myrp.edu.sg", "Pending", LocalDateTime.now()));
				
		// Objects for tuition information (ANDERS)
		Tuition t1 = new Tuition("ABC001", "Tuition_Test1", "SubjectGroup1", "This is for testing", 123, "Pre Requisite");
		Tuition t2 = new Tuition("XYZ002", "Tuition_Test2", "SubjectGroup2", "This is for testing", 456, "Pre Requisite");
		tuitionList.add(t1);
		tuitionList.add(t2);
		
		// Objects for tuition timetable
		
				
		// Objects for teacher
	
		int option = -1;

		while (option != OPTION_QUIT) {
			// Main Menu
			C206_CaseStudy.mainMenu();
			option = Helper.readInt("Enter an Option: ");

			if (option == OPTION_ACCOUNT) {
				// Manage Account				
					
					int choice = 0;
					
					while (option != STUDENT_QUIT) {
						
						C206_CaseStudy.menu();
						choice = Helper.readInt("Enter an option > ");
						
						if (choice == STUDENT_ADD) {
							// Add student
							StudentInfo sss = inputStudent();
							C206_CaseStudy.addStudent(studentList, sss);
							
						} else if (choice == STUDENT_VIEW) {
							// View student
							C206_CaseStudy.viewStudent(studentList);
							
						} else if (choice == STUDENT_DELETE) {
							// Delete student
							C206_CaseStudy.deleteStudent(studentList);
							
						} else if (choice == STUDENT_QUIT) {
							// Quit
							System.out.println("Goodbye");
							
						} else {
							System.out.println("Invalid option!");
							
						} // else
						
					} // while
					
			} else if (option == OPTION_REGISTRATION) {
				// Manage Tuition Registration [Dexter]
				C206_CaseStudy.registerTypeMenu();

				int registerType = Helper.readInt("Enter an Option: ");

				if (registerType == 1) {
					// Register for Tuition Timetable [Dexter]
					C206_CaseStudy.setHeader("REGISTER TUITION TIMETABLE");
					TimetableRegistration newReg = inputTimetable();
					C206_CaseStudy.addTimetableRegistration(regTimetableList, newReg);

				} else if (registerType == 2) {
					// View All Tuition Registrations [Dexter]
					C206_CaseStudy.setHeader("VIEW ALL REGISTRATIONS");
					C206_CaseStudy.retrieveAllTimetableRegistrations(regTimetableList);
					C206_CaseStudy.viewAllTimetableRegistrations(regTimetableList);

				} else if (registerType == 3) {
					// Delete Tuition Registration [Dexter]
					C206_CaseStudy.deleteTimetableRegistration(regTimetableList);

				} else if (registerType == 4) {
					// Invalid Option [Dexter]
					C206_CaseStudy.setHeader("LEAVING REGISTRATIONS MENU");
					System.out.println("Returning to Main Menu.");
					
				} else {
					System.out.println("Invalid Option, Please Enter a Valid Option (1-4)!");
				}

			} else if (option == OPTION_INFORMATION) {
				// Manage Tuition Information 
				tuitionMenu();
				int infoOption = Helper.readInt("Enter option to choose > ");
					switch(infoOption) {
					case 1:
						// Add Tuition Information
						addTutionInformation();						
						break;
					case 2:
						// View All Tuition Information
						viewAllTuitionInformation();
						break;
					case 3:
						// Delete Tuition Information
						deleteTuitionInformation();
						break;
					case 4:
						// Quit
						System.out.println("Leaving Tuition Information Management......");
						break;
					default:
						System.out.println("Invalid Option Entered");
						break;
					}
				

			} else if (option == OPTION_TIMETABLE) {
				// Manage Tuition Timetable Information
				

			} else if (option == OPTION_TEACHERS) {
				// Manage Tuition Teachers

			} else if (option == OPTION_QUIT) {
				// End Session || Close Application
				C206_CaseStudy.setHeader("END OF APPLICATION");
				System.out.println("Thank you & Have a Nice Day!");

			} else {
				// Invalid Input
				System.out.println("Please Enter a Valid Option from (1-6)!");

			}
		}
	}

	public static void mainMenu() {
		C206_CaseStudy.setHeader("TUITION MANAGEMENT SYSTEM");
		System.out.println("1. Manage Student Account");
		System.out.println("2. Manage Tuition Registration");
		System.out.println("3. Manage Tuition Information");
		System.out.println("4. Manage Tuition Timetable");
		System.out.println("5. Manage Teachers");
		System.out.println("6. Quit");
		Helper.line(120, "-");
	}

	public static void setHeader(String header) {
		Helper.line(120, "=");
		System.out.println(header);
		Helper.line(120, "=");
	}
	// Manage Student Account Menu (Option 1) [Nicolette]
	private static void menu() {
		
		Helper.line(50, "-");
		System.out.println("1. Add student");
		System.out.println("2. View student");
		System.out.println("3. Delete student");
		System.out.println("4. Quit");
		Helper.line(50, "-");
		
	}
	
	public static boolean deleteStudent(ArrayList<StudentInfo> studentList) {
		// TODO Auto-generated method stub
		Helper.line(50, "-");
		System.out.println("DELETE STUDENT");
		Helper.line(50, "-");
		
		String delete = Helper.readString("Enter the email of the student you want to delete > ");
		
		boolean isValid = deleteStudent(studentList, delete);
		
		if (isValid == false) {
			
			System.out.println("There is no such students");
			
		} else {
			
			System.out.println("Student is successfully deleted!");
			
		} // else		
		return isValid;
		
	} // delete student void 

	
	private static boolean deleteStudent(ArrayList<StudentInfo> studentList, String delete) {
		// TODO Auto-generated method stub
		boolean isValid = false;
		
		for (int i = 0; i < studentList.size(); i++) {
			
			String sEmail = studentList.get(i).getEmail();
			
			if (delete.equals(sEmail)) {
				
				studentList.remove(i);
				isValid = true;
				
			} // if
			
		} // for
		
		return isValid;
		
	} // delete student boolean

	public static String retrieveStudent(ArrayList<StudentInfo> studentList) {
		// TODO Auto-generated method stub
		Helper.line(50, "-");
		System.out.println("STUDENT LIST");
		Helper.line(50, "-");
		
			String output = "";

			for (int i = 0; i < studentList.size(); i++) {

				output += String.format("%-100s \n", studentList.get(i).displayOutput());
				
			} // for
			
			return output; 
	}
		public static String viewStudent(ArrayList<StudentInfo> studentList) {
		
			String output = String.format("%-10s %-10s %-10s %-15s %-15s %-10s",
										  "NAME", "GENDER", "MOBILE", "EMAIL", 
										  "DATE OF BIRTH", "COUNTRY OF RESIDENCE");
			 output += retrieveStudent(studentList);	
			System.out.println(output);
			return output;
		
	} // viewStudent

	public static StudentInfo inputStudent() {
		// TODO Auto-generated method stub
		Helper.line(50, "-");
		System.out.println("ADD NEW STUDENT");
		Helper.line(50, "-");
		
		String Name = Helper.readString("Enter your name > ");
		char Gender = Helper.readChar("Enter your gender (F/M) > ");
		int Mobile = Helper.readInt("Enter your mobile number > ");
		String Email = Helper.readString("Enter your email > ");
		String DOB = Helper.readString("Enter your date of brith > ");
		String COR = Helper.readString("Enter your country of residence > ");
		
		StudentInfo sss = new StudentInfo (Name, Gender, Mobile, Email, DOB, COR);
		return sss;
	} // input student
	
	public static void addStudent(ArrayList<StudentInfo> studentList, StudentInfo sss) {
		
		studentList.add(sss);
		System.out.println("Student successfully added! ");
		
	} // add student
	
	// Manage Tuition Registration Menu (Option 2) [Dexter]
	public static void registerTypeMenu() {
		C206_CaseStudy.setHeader("REGISTRATION MENU");
		System.out.println("1. Register for Tuition Timetable");
		System.out.println("2. View All Registrations");
		System.out.println("3. Delete Registration");
		System.out.println("4. Quit");
		Helper.line(120, "-");
	}

	// Register Tuition Timetable (Option 2: Option 1) [Dexter]
	public static TimetableRegistration inputTimetable() {
		int regNum = Helper.readInt("Enter your Registration ID: ");
		int timetableID = Helper.readInt("Enter the Tuition Timetable ID you want to Register: ");
		String studentEmail = Helper.readString("Enter your Email: ");
		String regStatus = "Pending";
		
		TimetableRegistration newReg = new TimetableRegistration(regNum, timetableID, studentEmail, regStatus, LocalDateTime.now());

//		for (int i = 0; i < regTimetableList.size(); i++) {
//			if (regTimetableList.get(i).getRegNum() != regNum) {
//				newReg = new TimetableRegistration(regNum, timetableID, studentEmail, regStatus, LocalDate.now());
//
//			} else if (regTimetableList.get(i).getRegNum() == regNum) {
//				Helper.line(100, "-");
//				System.out.println("Tuition Registration Failed! Please Enter A New Registration ID!");
//
//			}
//		}
		return newReg;
	}

	// Register Tuition Timetable Method (Option 2: Option 1) [Dexter]
	public static void addTimetableRegistration(ArrayList<TimetableRegistration> regTimetableList,
			TimetableRegistration newReg) {

		regTimetableList.add(newReg);
		System.out.println("Tuition Registration Successfully!");
	}

	// View All Timetables (Option 2: Option 2) [Dexter]
	public static String retrieveAllTimetableRegistrations(ArrayList<TimetableRegistration> regTimetableList) {
		String output = "";

		for (int i = 0; i < regTimetableList.size(); i++) {

			output += String.format("%-109s\n", regTimetableList.get(i).toString());
		}
		return output;
	}

	// View All Timetables Method (Option 2: Option 2) [Dexter]
	public static void viewAllTimetableRegistrations(ArrayList<TimetableRegistration> regTimetableList) {
		C206_CaseStudy.setHeader("TIMETABLE LIST");
		String output = String.format("%-10s %-15s %-30s %-20s %-30s\n", "REG ID", "TIMETABLE ID", "EMAIL ADDRESS",
				"REGISTRATION STATUS", "REGISTRATION DATETIME");
		output += retrieveAllTimetableRegistrations(regTimetableList);
		System.out.println(output);
	}

	// Delete Registration (Option 2: Option 3) [Dexter]
	public static void deleteTimetableRegistration(ArrayList<TimetableRegistration> timetableList) {
		C206_CaseStudy.viewAllTimetableRegistrations(timetableList);
		C206_CaseStudy.setHeader("CANCEL REGISTRATION");
		int delReg = Helper.readInt("Enter Registration ID to Delete: ");
		Boolean isFound = doDeleteTimetableRegistration(timetableList, delReg);

		if (isFound == false) {
			Helper.line(100, "-");
			System.out.println("Registration ID not found!");
		} else {
			Helper.line(100, "-");
			System.out.println("Registration ID " + delReg + " is deleted.");
		}
	}

	// Delete Registration Method [Dexter]
	public static boolean doDeleteTimetableRegistration(ArrayList<TimetableRegistration> timetableList, int delReg) {
		boolean isFound = false;

		for (int i = 0; i < timetableList.size(); i++) {
			int id = timetableList.get(i).getRegNum();

			if (delReg == id) {

				timetableList.remove(i);

				isFound = true;
			}
		}
		return isFound;
	}

	// --------------- ANDERS --------------
	// Manage Tuition Information Menu (Option 3)
	// Display Menu Options 
	public static void tuitionMenu() {
		C206_CaseStudy.setHeader("TUITION INFORMATION MANAGEMENT");
		System.out.println("1. Add Tuition Information");
		System.out.println("2. View All Tuition Information");
		System.out.println("3. Delete Tuition Information");
		System.out.println("4. Leave Tuition Information Management");
		Helper.line(80, "-");
	}
	
	// Add Tuition Information --- Option 1 
	public static void addTutionInformation() {
		String TuitionCode = Helper.readString("Enter new tuition code > ");
		String TuitionTitle = Helper.readString("Enter new tuition title > ");
		String SubjectName = Helper.readString("Enter subject name > ");
		String Description = Helper.readString("Enter tuition description > ");
		double Duration = Helper.readDouble("Enter tuition duration > ");
		String preRequisite = Helper.readString("Enter preRequisite > ");
		Tuition nTuition = new Tuition(TuitionCode, TuitionTitle, SubjectName, Description, Duration, preRequisite);
		tuitionList.add(nTuition);
	}
	
	// View All Tuition Information --- Option 2
	public static void viewAllTuitionInformation() {
		String tInfo = String.format("%-15s %-20s %-20s %-23s %-10s %-10s\n","TUITION CODE", "TUITION TITLE", "SUBJECT GROUP NAME", "DESCRIPTION","DURATION","PRE-REQUISITE");
		for (int i = 0; i < tuitionList.size(); i ++) {
			Tuition t = tuitionList.get(i);
			tInfo += String.format("%-15s %-20s %-20s %-23s %-10.2f %-10s\n",t.getTuitionCode(),t.getTuitionTitle(),t.getSubjectName(), 
					t.getTuitionDescription(),t.getDuration(),t.getPreRequisite());
		}
		System.out.println(tInfo);
	}

	// Delete Tuition Information --- Option 3
	public static void deleteTuitionInformation() {
		boolean found = false;
		String tuitionD = "";
		String delete = Helper.readString("Enter Tuition Code to delete > ");
		for (int i = 0; i < tuitionList.size(); i++) {
			if (delete.equals(tuitionList.get(i).getTuitionCode())) {
				found = true;
				tuitionD = tuitionList.get(i).getTuitionCode();
				char confirm = Helper.readChar("Are you sure you want to delete " + tuitionD + " (Y/N) ? > ");
				
				if((confirm == 'y') || (confirm == 'Y')) {
					tuitionList.remove(tuitionList.get(i));
					System.out.println(tuitionD + "has successfully been deleted!");
					
				}else if ((confirm == 'n') || (confirm == 'N')) {
					System.out.println(tuitionD + " will not be deleted.");
					
				}else {
					System.out.println("Please enter a valid option");
				}
				break;
			}
		}
		if(!found) {
			System.out.println("The tuition code you entered cannot be found. Please try again.");
		}
	}
	// ------------------------------------
	
	// Manage Tuition Timetable Menu (Option 4)

	// Manage Tuition Teachers Menu (Option 5) JJ

}
