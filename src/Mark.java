
import java.io.*;
/** 
 * Class  Mark with <b>serialVersionUID</b> <b>firstAttestation</b> <b>secondAttestation</b> <b>finalExam</b> <b>letterGrade</b><b>GPA</b><b>attestationClosed</b>
 * @version 2.1
*/
public class Mark implements Serializable{
	
	// serial
	private static final long serialVersionUID = 1L;
	// firstAttestation 
	private double firstAttestation;
	// secondAttestation
	private double secondAttestation;
	 // finalExam
	private double finalExam;
	// letterGrade 
	private String letterGrade;
	//GPA
	private double gpa;
	//attestationClosed
	private static boolean attestationClosed;
	/** 
     * Constructor  - creating the mark  
     * @param firstAttestation - firstAttestation
     * @param secondAttestation - secondAttestation
     * @param finalExam - finalExam
     * @param letterGrade - letterGrade 
     * @param GPA - GPA
     * @param attestationClosed -attestationClosed
     */
	public Mark() {
		this.firstAttestation = 0.0;
		this.secondAttestation = 0.0;
		this.finalExam = 0.0;
		this.letterGrade = "";
		this.gpa = 0.0;
		attestationClosed = false;
	}
	
//	---------------Getters, Setters-----------
	/**
     * Procedure of defining the firstAttestation {@link Mark#firstAttestation}
     * @param firstAttestation - firstAttestation
     */
	public void setFirstAttestation(double score) {
		this.firstAttestation = score;
	}
	/**
     * Procedure of defining the secondAttestation {@link Mark#secondAttestation}
     * @param secondAttestation - secondAttestation
     */
	public void setSecondAttestation(double score) {
		this.secondAttestation = score;
	}
	/**
     * Procedure of defining the finalExam {@link Mark#finalExam}
     * @param finalExam - finalExam
     */
	public void setFinalExam(double score) {
		this.finalExam = score;
	}/**
     * Procedure of defining the letterGrade {@link Mark#letterGrade}
     * @param letterGrade - letterGrade 
     */
	public void setLetterGrade(String newLetterGrade) {
		this.letterGrade = newLetterGrade;
	}
	/**
     * Procedure of defining the GPA {@link Mark#GPA}
     * @param GPA - GPA
     */
	public void setGpa(double newGpa) {
		this.gpa = newGpa;
	}
	/**
     * Get firstAttestation
     * @param firstAttestation - firstAttestation 
     * @return firstAttestation 
     */
	public double getFirstAttestation() {
		return this.firstAttestation;
	}/**
     * Get secondAttestation
     * @param secondAttestation - secondAttestation
     * @return secondAttestation
     */
	public double getSecondAttestation() {
		return this.secondAttestation;
	}
	/**
     * Get finalExam
     * @param finalExam - finalExam
     * @return finalExam
     */
	public double getFinalExam() {
		return this.finalExam;
	}
	/**
     * Get letterGrade
     * @param letterGrade -letterGrade 
     * @return letterGrade
     */
	public String getLetterGrade() {
		return this.letterGrade;
	}
	/**
     * Get GPA
     * @param GPA - GPA
     * @return GPA
     */
	public double getGpa() {
		return this.gpa;
	}
	/**
     * Get overall
     * @param firstAttestation - firstAttestation
     * @param secondAttestation - secondAttestation
     * @param finalExam - finalExam
     * @return firstAttestation + secondAttestation + finalExam
     */
	public double getOverall() {
		return this.firstAttestation + this.secondAttestation + this.finalExam;
	}
	/**
     * Get infoAboutAttestation
     * @param attestationClosed - attestationClosed
     * @return attestationClosed
     */
	public static boolean getInfoAboutAttestation() {
		return attestationClosed;
	}
	
	public void updateGrade() {
		double grade = this.getOverall();
		if(grade >= 95 && grade <= 100) {
			this.setLetterGrade("A");
			this.setGpa(4.00);
		}
		else if(grade >= 90 && grade < 95) {
			this.setLetterGrade("A-");
			this.setGpa(3.67);
		}
		else if(grade >= 85 && grade < 90) {
			this.setLetterGrade("B+");
			this.setGpa(3.33);
		}
		else if(grade >= 80 && grade < 85) {
			this.setLetterGrade("B");
			this.setGpa(3.00);
		}
		else if(grade >= 75 && grade < 80) {
			this.setLetterGrade("B-");
			this.setGpa(2.67);
		}
		else if(grade >= 70 && grade < 75) {
			this.setLetterGrade("C+");
			this.setGpa(2.33);
		}
		else if(grade >= 65 && grade < 70) {
			this.setLetterGrade("C");
			this.setGpa(2.00);
		}
		else if(grade >= 60 && grade < 65) {
			this.setLetterGrade("C-");
			this.setGpa(1.67);
		}
		else {
			this.setLetterGrade("F");
			this.setGpa(0.00);
		}
	}
	
//	------------------------------------------
	
	public String toString() {
		return "First att: " + this.firstAttestation + " Second att: " + this.secondAttestation + " Final exam: " + this.finalExam +  "\tLetter grade: " + this.letterGrade + "\t gpa: " + this.gpa; 
	}
	public void printInfo() {
		System.out.println(this.toString());
	}
	
	public static void closeAttestation() {
		attestationClosed = true;
	}
	
	
}
