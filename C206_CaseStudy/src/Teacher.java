/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20013886, 9 Aug 2021 1:27:52 pm
 */

/**
 * @author 20013886
 *
 */
public class Teacher {

	private String name;
	private char gender;
	private String email;
	private String qualification;
	private String subject_group;
	public Teacher(String name, char gender, String email, String qualification, String subject_group) {
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.qualification = qualification;
		this.subject_group = subject_group;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getName() {
		return name;
	}
	public char getGender() {
		return gender;
	}
	public String getEmail() {
		return email;
	}
	public String getSubject_group() {
		return subject_group;
	}
	
	

}
