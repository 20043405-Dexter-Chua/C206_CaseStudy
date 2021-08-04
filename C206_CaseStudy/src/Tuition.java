/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20017547, Aug 4, 2021 7:47:36 PM
 */

public class Tuition {
	
	private String tuitionCode;
	private String tuitionTitle;
	private String subjectName;
	private String tDescription;
	private double duration;
	private String preRequisite;
	
	public Tuition(String tC, String tT, String sN, String tD, double duration, String pR) {
		this.tuitionCode = tC;
		this.tuitionTitle = tT;
		this.subjectName = sN;
		this.tDescription = tD;
		this.duration = duration;
		this.preRequisite = pR;
	}
	
	public String getTuitionCode() {
		return this.tuitionCode;
	}
	
	public void setTuitionCode(String nCode) {
		this.tuitionCode = nCode;
	}
	
	public String getTuitionTitle() {
		return this.tuitionTitle;
	}
	
	public void setTuitionTitle(String tuitionT) {
		this.tuitionTitle = tuitionT;
	}
	
	public String getSubjectName() {
		return this.subjectName;
	}
	
	public void setSubjectName(String sName) {
		this.subjectName = sName;
	}
	
	public String getTuitionDescription() {
		return this.tDescription;
	}
	
	public void setTuitionDescription(String tuitionD) {
		this.tDescription = tuitionD;
	}
	
	public double getDuration() {
		return this.duration;
	}
	
	public void setDuration(double nDuration) {
		this.duration = nDuration;
	}
	
	public String getPreRequisite() {
		return this.preRequisite;
	}
	
	public void setPreRequisite(String nPR) {
		this.preRequisite = nPR;
	}

}
