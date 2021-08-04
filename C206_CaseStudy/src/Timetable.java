import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Revathi Selvasevaran, 20006739, 31 Jul 2021 4:09:39 pm
 */
/**
 Unless otherwise noted, passing a null argument to a constructor or method in any class
 or interface in this package will cause a NullPointerException to be thrown. 
 The Javadoc "@param" definition is used to summarise the null-behavior. 
 The "@throws NullPointerException" is not explicitly documented in each method.

All calculations should check for numeric overflow
 and throw either an ArithmeticException or a DateTimeException. 
 */

public class Timetable {
	private String timetableID;
	private double price;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String mode;
	
	public Timetable(String timetableID, double price, LocalDateTime startTime, LocalDateTime endTime, String mode) {
		this.timetableID = timetableID;
		this.price = price;
		this.startTime = startTime;
		this.endTime = endTime;
		this.mode = mode;
	}

	public String getTimetableID() {
		return timetableID;
	}

	public void setTimetableID(String timetableID) {
		this.timetableID = timetableID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	
	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
	
	
}
