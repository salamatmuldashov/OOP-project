
import java.util.*;
import java.util.Map.Entry;

import java.io.*;
/** 
 * Class Teacher   with <b>serialVersionUID</b> <b>title</b> <b>Faculty</b> <b>project</b><b>officeHours</b><b>rating</b>
*/
public class Teacher extends Employee implements ViewableCourses, Serializable, Researcher{
	// serial
	private static final long serialVersionUID = 1L;
	//title 
	private Title title;
	//faculty 
	private Faculty faculty;
	//rating 
	private Vector<Integer> rating;
	//officeHours
	private Vector<Schedule> officeHours;      // 2 - max
	//project
	private Project project;
//	--------------Constructors-----------------
	public Teacher() {
		super();
		rating  = new Vector<Integer>();
		officeHours = new Vector<Schedule>();
	}
	/** 
     * Constructor  - creating new Teacher 
     * @param name - name
     */
	public Teacher(String name) {
		super(name);
	}

	/** 
     * Constructor  - creating new Teacher 
     * @param name - name
     * @param surname - surname
     */
	public Teacher(String name, String surname) {
		super(name, surname);
	}

	/** 
     * Constructor  - creating new Teacher 
     * @param name - name
     * @param surname - surname
     * @param salary - salary
     */
	public Teacher(String name, String surname, double salary) {
		super(name, surname, salary);
	}

	/** 
     * Constructor  - creating new Teacher 
     * @param name - name
     * @param surname - surname
     * @param title - title
     * @param salary - salary
     */
	public Teacher(String name, String surname, double salary, Title title) {
		super(name, surname, salary);	
		this.title = title;
	}

	/** 
     * Constructor  - creating new Teacher 
     * @param name - name
     * @param surname - surname
     * @param title - title
     * @param salary - salary
     * @param faculty - faculty
     */
	public Teacher(String name, String surname, double salary, Title title, Faculty faculty) {
		super(name, surname, salary);
		this.title = title;
		this.faculty = faculty;
	}
	/** 
     * Constructor  - creating new Teacher 
     * @param name - name
     * @param surname - surname
     * @param title - title
     * @param salary - salary
     * @param faculty - faculty
     * @param rating - rating
     */
	public Teacher(String name, String surname, double salary, Title title, Faculty faculty, Vector<Integer> rating) {
		super(name, surname, salary);
		this.title = title;
		this.faculty = faculty;
		this.rating = rating;
	}

	/** 
     * Constructor  - creating new Teacher 
     * @param name - name
     * @param surname - surname
     * @param title - title
     * @param salary - salary
     * @param faculty - faculty
     * @param rating - rating
     * @param officeHourse - officeHours
     */
	public Teacher(String name, String surname, double salary, Title title, Faculty faculty, Vector<Integer> rating, Vector<Schedule> officeHours) {
		super(name, surname, salary);
		this.title = title;
		this.faculty = faculty;
		this.rating = rating;
		this.officeHours = officeHours;
	}
	/** 
     * Constructor  - creating new Teacher 
     * @param name - name
     * @param surname - surname
     * @param title - title
     * @param salary - salary
     * @param faculty - faculty
     * @param rating - rating
     * @param officeHours - officeHours
     * @param unreadMessages - unreadMessages
     */
	public Teacher(String name, String surname, double salary, Vector<String> unreadMessages) {
		super(name, surname, salary, unreadMessages);
	}/** 
     * Constructor  - creating new Teacher 
     * @param name - name
     * @param surname - surname
     * @param title - title
     * @param salary - salary
     * @param faculty - faculty
     * @param rating - rating
     * @param officeHours - officeHours
     * @param unreadMessages - unreadMessages
     */
	public Teacher(String name, String surname, double salary, Vector<String> unreadMessages, Title title) {
		super(name, surname, salary, unreadMessages);
		this.title = title;
	}/** 
     * Constructor  - creating new Teacher 
     * @param name - name
     * @param surname - surname
     * @param title - title
     * @param salary - salary
     * @param faculty - faculty
     * @param rating - rating
     * @param officeHours - officeHours
     * @param unreadMessages - unreadMessages
     */
	public Teacher(String name, String surname, double salary, Vector<String> unreadMessages, Title title, Faculty faculty) {
		super(name, surname, salary, unreadMessages);
		this.title = title;
	}/** 
     * Constructor  - creating new Teacher 
     * @param name - name
     * @param surname - surname
     * @param title - title
     * @param salary - salary
     * @param faculty - faculty
     * @param rating - rating
     * @param officeHours - officeHours
     * @param unreadMessages - unreadMessages
     */
	public Teacher(String name, String surname, double salary, Vector<String> unreadMessages, Title title, Faculty faculty, Vector<Schedule> officeHours) {
		super(name, surname, salary, unreadMessages);
		this.title = title;
		this.officeHours = officeHours;
	}

//	---------------------------------------------
	
//	------------Getters, Setters--------------------
	public Vector<Integer> getRating() {
		return this.rating;
	}
	public double getOverallRating() {
		double sum = 0;
		for(Integer d : rating) {
			sum+=d;
		}
		return (double)sum / rating.size();
	}
	
	public void updateRating(int rate){
		Vector<Integer> newRating = this.getRating();
		newRating.add(rate);
		this.setRating(newRating);
	}
	public void setRating(Vector<Integer> newRating) {
		this.rating = newRating;
	}
	public Title getTitle() {
		return this.title;
	}
	public void setTitle(Title newTitle) {
		this.title = newTitle;
	}
	public Vector<Schedule> getOfficeHours() {
		return this.officeHours;
	}
	public void setOfficeHours(Vector<Schedule> newOfficeHours) {
		this.officeHours = newOfficeHours;
	}
	public Faculty getFaculty() {
		return this.faculty;
	}
	public void setFaculty(Faculty newFaculty) {
		this.faculty = newFaculty;
	}
	public Project getProject() {
		return this.project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public int compareTo(Teacher t) {
		if(this.getSalary() > t.getSalary()) return 1;
		else if(this.getSalary() < t.getSalary()) return -1;
		return 0;
	}
//	------------------------------------------------
	
//	------------------------INFO------------------------
	public String getTeacherInfo(){
		String sInfo = "Teacher information:\n";
		String s1Info = super.getEmployeeInfo();
		sInfo += s1Info + " Title: " + this.title + " | " + "Faculty: " + this.faculty;
		sInfo += "\n";
		return sInfo;
	}
	
	public String toString() {
		return this.getTeacherInfo();
	}
	
	public final void printInfo() {
		System.out.println(this.toString());
	}
//	----------------------------------------------------
	
	
	
//	----------------Methods--------------------
	
//	1 - view courses
	public void viewCourses() {
		boolean ok = false;
		Vector<Course> courses = University.getCourses();
		for(Course c : courses) {
			HashSet<Teacher> t = c.getTeachersOfCourse();
			if(t.size() != 0) {
				for(Teacher teacher : t) {
					if(teacher.equals(this)){
						ok = true;
						c.printInfo();
					}
				}
			}
		}
		if(!ok) System.out.println("Teacher do not have course!");
	}
	
//	2 - Manage Course Files
	public void manageCourseFiles() {
		
	}
	
	
//	3 - view students
	public void viewStudentsInfo(Course course) {
		course.infoCourseStudents();
	}
	
	public void viewStudent(Student student) {
		Vector<Course> courses = University.getCourses();
		for(Course c : courses) {
			for(Lesson l : c.getLessons()) {
				if(l.getTeacher()!= null) {
					if(l.getTeacher().equals(this)) {
						if(c.getStudentOfCourse().contains(student)) {
							student.printInfo();
							return;
						}
						System.out.println("Student not in this course!");
						return;
					}
				}
				
			}
			System.out.println("You do not have this course!");
		}
	}
	
//	4 - put marks
	public void putMark(Student student, Course course, int attestation, double point) {
		for(Lesson l : course.getLessons()) {
			if(l.getTeacher().equals(this) && l.getStudents().contains(student)) {
				if(attestation == 1) {
					if(student.getMarkOfCourse(course).getFirstAttestation() + point > 30) {
						System.out.println("Limit! Maximum points for 1st attestation is 30!");
						return;
					}
					else student.getMarkOfCourse(course).setFirstAttestation(student.getMarkOfCourse(course).getFirstAttestation() + point);
					}
				else if(attestation == 2) {
					if(student.getMarkOfCourse(course).getSecondAttestation() + point > 30) {
						System.out.println("Limit! Maximum points for 2nd attestation is 30!");
						return;
					}
					else student.getMarkOfCourse(course).setSecondAttestation(student.getMarkOfCourse(course).getSecondAttestation() + point);
					}
				else if(attestation == 3) {
					if(student.getMarkOfCourse(course).getFinalExam() + point > 40) {
						System.out.println("Limit! Maximum points for the final is 40!");
						return;
					}
					else student.getMarkOfCourse(course).setFinalExam(student.getMarkOfCourse(course).getFinalExam() + point);
					}
					System.out.println("Marked!");
					return;
				}
			
		}
		System.out.println("You can not put mark to this student cause you do not teach him!");
	}
	
	public void viewOfficeHours() {
		for(Schedule schedule : officeHours) {
			schedule.printInfo();
		}
	}
	public void addOfficeHour(Schedule officeHour) {
		if(this.officeHours == null) {
			this.officeHours.add(officeHour);
		}else {
			if(this.officeHours.size() > 2) {
				System.out.println("You can have only 2 office hour!");
			}else {
				this.officeHours.add(officeHour);
				}
		}
		
		
	}
	/**
     * This is about creating the new teacher
     * @throws IOException
     * return teacher
     */
	public static Teacher createNewTeacher(BufferedReader br) throws IOException{
		Teacher teacher = new Teacher();
		System.out.println("\nEnter teacher's name: ");
		String name = br.readLine();
		teacher.setName(name);
		System.out.println("\nEnter teacher's surname: ");
		String surname = br.readLine();
		teacher.setSurname(surname);
		System.out.println("\nEnter teacher's salary: ");
		double salary = Double.parseDouble(br.readLine());
		teacher.setSalary(salary);
		System.out.println("Enter teacher's title: 1)TUTOR; 2)LECTOR; 3)PROFESSOR");
		String title = br.readLine();
		if(title.equalsIgnoreCase("TUTOR")){
			teacher.setTitle(Title.TUTOR);
		}
		else if(title.equalsIgnoreCase("LECTOR")) {
			teacher.setTitle(Title.LECTOR);
		}
		else if(title.equalsIgnoreCase("PROFESSOR")) {
			teacher.setTitle(Title.PROFESSOR);
		}
		
		System.out.println("Enter teacher's faculty: ");
		String faculty = br.readLine();
		if(faculty.equalsIgnoreCase("FIT")) { 
			teacher.setFaculty(Faculty.FIT);
		}
		else if(faculty.equalsIgnoreCase("BS")) {
			teacher.setFaculty(Faculty.BS);
		}
		else if(faculty.equalsIgnoreCase("FEOGI")) {
			teacher.setFaculty(Faculty.FEOGI);
		}
		else if(faculty.equalsIgnoreCase("FGE")) {
			teacher.setFaculty(Faculty.FGE);
		}
		else if(faculty.equalsIgnoreCase("SCE")) {
			teacher.setFaculty(Faculty.SCE);
		}
		else if(faculty.equalsIgnoreCase("ISE")) {
			teacher.setFaculty(Faculty.ISE);
		}
		else if(faculty.equalsIgnoreCase("KMA")) {
			teacher.setFaculty(Faculty.KMA);
		}
		else if(faculty.equalsIgnoreCase("SMC")) {
			teacher.setFaculty(Faculty.SMC);
		}
		teacher.constructMail();
		return teacher;
	}
	public void createResearch(Project project) {
		this.project = project;
		this.project.setWorker(this);
	}
	
	public void workResearch(String work) {
		this.project.update(work);
	}
	
	
	
}
