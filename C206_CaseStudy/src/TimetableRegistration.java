import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimetableRegistration {
	private int regNum;
	private int timetableID;
	private String studentEmail;
	private String regStatus;
	private LocalDateTime regDate;
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	public TimetableRegistration(int regNum, int timetableID, String studentEmail, String regStatus, LocalDateTime regDate) {
		this.regNum = regNum;
		this.timetableID = timetableID;
		this.studentEmail = studentEmail;
		this.regStatus = regStatus;
		this.regDate = regDate;
	}
	
	public String toString() {
		String tuitionReg = String.format("%-10d %-15d %-30s %-20s %-30s", regNum, timetableID, studentEmail, regStatus, formatter.format(regDate));
		return tuitionReg;
	}
	
	public int getRegNum() {
		return regNum;
	}
	
	public void setRegNum(int regNum) {
		this.regNum = regNum;
	}
	
	public int getTimetableID() {
		return timetableID;
	}
	
	public void setTimetableID(int timetableID) {
		this.timetableID = timetableID;
	}
	
	public String getStudentEmail() {
		return studentEmail;
	}
	
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	
	public String getRegStatus() {
		return regStatus;
	}
	
	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}
	
	public LocalDateTime getRegDate() {
		return regDate;
	}
	
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}	

}


