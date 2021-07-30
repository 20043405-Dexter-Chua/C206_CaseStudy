public class C206_CaseStudy {
	private static final int OPTION_ACCOUNT = 1;
	private static final int OPTION_REGISTRATION = 2;
	private static final int OPTION_INFORMATION = 3;
	private static final int OPTION_TIMETABLE = 4;
	private static final int OPTION_TEACHERS = 5;
	private static final int OPTION_QUIT = 6;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int option = -1;
		
		while (option != OPTION_QUIT) {
			C206_CaseStudy.mainMenu();
			option = Helper.readInt("Enter an Option: ");
			
			if (option == OPTION_ACCOUNT) {
				// Manage Account
				
			} else if (option == OPTION_REGISTRATION) {
				// Manage Tuition Registration
				C206_CaseStudy.registerTypeMenu();
				
				int registerType = Helper.readInt("Enter an Option: ");
				
				if (registerType == 1) {
					// Register for Tuition Timetable
					
					
				} else if (registerType == 2) {
					// View All Tuition Registrations
					
					
				} else if (registerType == 3) {
					// Delete Tuition Registration
					
					
				} else {
					// Invalid Option
					System.out.println("Invalid Option, Please Enter a Valid Option (1-3)!");
				
				}
				
			} else if (option == OPTION_INFORMATION) {
				// Manage Tuition Information
				
				
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
		Helper.line(80, "-");
	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}	
	
	
	// Manage Tuition Registration (Option 2)
	public static void registerTypeMenu() {
		C206_CaseStudy.setHeader("REGISTRATION MENU");
		System.out.println("1. Register for Tuition Timetable");
		System.out.println("2. View All Registrations");
		System.out.println("3. Delete Registration");
		Helper.line(80, "-");
	}
	
}
