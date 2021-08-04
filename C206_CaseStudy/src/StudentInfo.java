import java.util.ArrayList;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * CJYN1, 4 Aug 2021 9:44:21 pm
 */

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * CJYN1, 4 Aug 2021 9:44:21 pm
 */

public class StudentInfo {
	
	private String name;
	private char gender; 
	private int mobile;
	private String email;
	private String dob;
	private String cor;

	public StudentInfo(String name, char gender, int mobile, String email, String dob, String cor) {
		this.name = name;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.dob = dob;
		this.cor = cor;
	}

	public String displayOutput() {
		String output = String.format("\n%-10s %-10c %-10d %-15s %-15s %-10s", 
										name, gender, mobile, email, dob, cor);
		return output;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
}
