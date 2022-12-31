
import java.io.*;
/** 
 * Class Student  with <b>serialVersionUID</b> <b>yearOfStudy</b> <b>id</b> <b>degree</b><b>totalCredits</b><b>studentFee</b>
*/
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;
public class Student extends User implements Comparable<Student>,ViewableCourses, Serializable, Researcher {
	// serial
	private static final long serialVersionUID = 1L;
	//yearOfStudy
	private int yearOfStudy;
	//id
	private String id;
	// degree
	private Degree degree;
	// marks
	private HashMap<Course, Mark> marks;
	// totalCredits
	private int totalCredits = 0;
	// faculty 
	private Faculty faculty;
	// studentFee
	private double studentFee = 0.0;
	// GPA
	private double gpa = 0.0;
	// organization
	private Organization organization;
	// project
	private Project project; 

// ------Constructors----------
	public Student() {
		super();
		marks = new HashMap<Course,Mark>();
		organization = null;
		project = null;
	}
	/** 
     * Constructor  - creating new Student 
     * @param name - name
     */
	public Student(String name) {
		super(name);
	}

	/** 
     * Constructor  - creating new Student 
     * @param name - name
     * @param surname - surname
     */
	public Student(String name, String surname) {
		super(name,surname);
	}

	/** 
     * Constructor  - creating new Student 
     * @param name - name
     * @param surname - surname
     * @param yearOfStudy - yearOfStudy
     */
	public Student(String name, String surname, int yearOfStudy) {
		super(name,surname);
		this.yearOfStudy = yearOfStudy;	
	}
	/** 
     * Constructor  - creating new Student 
     * @param name - name
     * @param surname - surname
     * @param yearOfStudy - yearOfStudy
     * @param id - id 
     */
	public Student(String name, String surname, int yearOfStudy,String id) {
		super(name,surname);
		this.yearOfStudy = yearOfStudy;
		this.id = id;
	}
	/** 
     * Constructor  - creating new Student 
     * @param name - name
     * @param surname - surname
     * @param yearOfStudy - yearOfStudy
     * @param id - id 
     * @param degree - degree
     */
	public Student(String name, String surname, int yearOfStudy,String id, Degree degree) {
		super(name,surname);
		this.yearOfStudy = yearOfStudy;
		this.id = id;
		this.degree = degree;
	}
	/** 
     * Constructor  - creating new Student 
     * @param name - name
     * @param surname - surname
     * @param yearOfStudy - yearOfStudy
     * @param id - id 
     * @param degree - degree
     * @param faculty - faculty
     */
	public Student(String name, String surname, int yearOfStudy,String id, Degree degree, Faculty faculty) {
		super(name,surname);
		this.yearOfStudy = yearOfStudy;
		this.id = id;
		this.degree = degree;
		this.faculty = faculty;
	}
	/** 
     * Constructor  - creating new Student 
     * @param name - name
     * @param surname - surname
     * @param yearOfStudy - yearOfStudy
     * @param id - id 
     * @param degree - degree
     * @param faculty - faculty
     * @param organization - organization
     */
	public Student(String name, String surname,int yearOfStudy, String id, Faculty faculty, Organization organization) {
		super(name,surname);
		this.yearOfStudy = yearOfStudy;
		this.id = id;
		this.faculty = faculty;
		this.organization = organization;
	}
	/** 
     * Constructor  - creating new Student 
     * @param name - name
     * @param surname - surname
     * @param yearOfStudy - yearOfStudy
     * @param id - id 
     * @param degree - degree
     * @param faculty - faculty
     * @param marks - marks
     */
	public Student(String name,String surname, String id, HashMap<Course,Mark> marks) {
		super(name,surname);
		this.id = id;
		this.marks = marks;
	}
	
//	--------------------------
	
//	-------Getters,Setters----------
	
	public void constructId() {
		String newId = Integer.toString(23-yearOfStudy);
		if(this.getDegree().equals(Degree.BACHELOR)) {
			newId+="B" + this.getId();
		}
		else if(this.getDegree().equals(Degree.MASTER)) {
			newId+="M" + this.getId();
		}
		else if(this.getDegree().equals(Degree.PHD)) {
			newId+="P" + this.getId();
		}
		this.setId(newId);
	}
	/**
     * Procedure of defining the id  {@link Student#id}
     * @param id - id
     */
	public void setId(String newId) {
		this.id = newId;
	}
	/**
     * Procedure of getting id
     * @param id - id
     * @return id
     */
	public String getId() {
		return this.id;
	}

	/**
     * Procedure of getting yearOfStudy
     * @param yearOfStudy - yearOfStudy
     * @return yearOfStudy
     */
	public int getYearOfStudy() {
		return this.yearOfStudy;
	}
	/**
     * Procedure of defining the yearOfStudy  {@link Student#yearOfStudy}
     * @param yearOfStudy - yearOfStudy
     */
	public void setYearOfStudy(int year) {
		this.yearOfStudy = year;
	}
	/**
     * Procedure of getting degree
     * @param degree - degree 
     * @return degree
     */
	public Degree getDegree() {
		return this.degree;
	}
	/**
     * Procedure of defining the degree {@link Student#degree}
     * @param degree - degree
     */
	public void setDegree(Degree newDegree) {
		this.degree = newDegree;
	}
	/**
     * Procedure of defining the totalCredits  {@link Student#totalCredits}
     * @param totalCredits - totalCredits
     */
	public void setTotalCredits(int newCredits) {
		this.totalCredits = newCredits;
	}
	/**
     * Procedure of getting totalCredits
     * @param totalCredits - totalCredits
     * @return totalCredits
     */
	public int getTotalCredits() {
		return this.totalCredits;
	}
	/**
     * Procedure of defining the newFaculty  {@link Student#newFaculty}
     * @param newFaculty - newFaculty
     */
	public void setFaculty(Faculty newFaculty) {
		this.faculty = newFaculty;
	}
	/**
     * Procedure of getting faculty
     * @param faculty - faculty 
     * @return faculty
     */
	public Faculty getFaculty() {
		return this.faculty;
	}
	/**
     * Procedure of defining the newMark {@link Student#newMark}
     * @param newMark - newMark
     */
	public void setMarks(HashMap<Course,Mark> newMark) {
		this.marks = newMark;
	}
	/**
     * Procedure of getting marks {@link Student#marks}
     * @param marks - marks
     * @return marks
     */
	public HashMap<Course,Mark> getMarks(){
		return marks;
	}
	/**
     * Procedure of defining the studentFee {@link Student#studentFee}
     * @param studentFee - studentFee
     */
	public void setStudentFee(double newFee) {
		this.studentFee = newFee;
	}
	/**
     * Procedure of getting marks {@link Student#marks}
     * @param marks - marks
     * @return marks
     */
	public double getStudentFee() {
		return this.studentFee;
	}
	public void setGpa(double newGpa) {
		this.gpa = newGpa;
	}
	public double getGpa() {
		return this.gpa;
	}
	public Mark getMarkOfCourse(Course course) {
		return marks.get(course);
	}
	public void setMarkOfCourse(Course course, Mark mark) {
		for(Entry<Course,Mark> m : marks.entrySet()) {
			if(m.getKey().equals(course)) {
				m.setValue(mark);
			}
		}
	}
	/**
     * Procedure of adding the mark
     * @param mark - mark 
     */
	public void addCourseMark(Course course, Mark mark) {
		marks.put(course, mark);
	}
	/**
     * Procedure of setting  the organization
     * @param organization - organization
     */
	public void setOrganization(Organization newOrganization) {
		this.organization = newOrganization;
	}
	
	/**
     * Procedure of getting organization
     * @param organization - organization
     * @return organization
     */
	public Organization getOrganization() {
		return this.organization;
	}
	/**
     * Procedure of getting project
     * @param project - project 
     * @return project
     */
	public Project getProject() {
		return this.project;
	}

	/**
     * Procedure of setting  the project
     * @param project - project 
     */
	public void setProject(Project project) {
		this.project = project;
	}
	/**
     * Procedure of determining the GPA
     * @param GPA - GPA
     */
	public void calculateGpa() {
		double gpa = 0.0;
		double credits = 0.0;
		for(Course course : marks.keySet()) {
			gpa +=(marks.get(course).getGpa() * course.getNumOfCredits());
			credits+=course.getNumOfCredits();
		}

		this.setGpa(gpa/credits);
	}

	
//	---------------------------------
	
	
//	--------INFO OF STUDENT----------
	/**
     * Procedure of getting the student info
     * @param sInfo - sInfo
     * @return sInfo
     */
	public String getStudentInfo() {
		String sInfo = "Student information:\n";
		String s1Info = super.getUserInfo();
		sInfo = sInfo + s1Info;
		sInfo+="\n";
		sInfo = sInfo + "Id: " + this.id + "\t";
		sInfo = sInfo + "Degree: " + this.degree + "\t";
		sInfo = sInfo + "Faculty: " + this.faculty + "\t";
		sInfo = sInfo + "Student Fee: " + this.studentFee + "\t";
		sInfo = sInfo + "Total credits: " + this.totalCredits + "\t";
		sInfo = sInfo + "Gpa: " + this.gpa + "\t";
		sInfo = sInfo + "\n";
		return sInfo;
	}
	/**
     * Procedure of getting the string format of student info 
     * @return sInfo
     */
	public String toString() {
		return this.getStudentInfo();
	}

	/**
     * Procedure of printing  the string format of student info 
     */
	public final void printInfo() {
		System.out.println(this.toString());
	}

	/**
     * Procedure of printing  the string format of organization info  
     */
	public void printInfoAboutOrg() {
		if(this.organization != null)
		this.organization.printInfo();
		else 
			System.out.println("Null");
	}
	/**
     * Procedure of creating the Research
     * @param project  - project
     */
	public void createResearch(Project project) {
		this.project = project;
		this.project.setWorker(this);
	}
	public void workResearch(String work) {
		this.project.update(work);
	}
//	----------------------------------
	/**
     * This is about creating the new student
     * @throws IOException
     * return student
     */
	public static Student createNewStudent(BufferedReader br) throws IOException {
		Student student = new Student();
		System.out.println("\nEnter student's name: ");
		String name = br.readLine();
		student.setName(name);
		System.out.println("\nEnter student's surname: ");
		String surname = br.readLine();
		student.setSurname(surname);
		System.out.println("\nEnter year of study: ");
		int year = Integer.parseInt(br.readLine());
		student.setYearOfStudy(year);
		System.out.println("\nEnter student's id: ");
		String id = br.readLine();
		student.setId(id);
		
		System.out.println("\nEnter student's degree: 1)BACHELOR,   2)MASTER,   3)PHD ");
		String degree = br.readLine();
		if(degree.equalsIgnoreCase("BACHELOR")) {
			student.setDegree(Degree.BACHELOR);
		}
		else if(degree.equalsIgnoreCase("MASTER")) {
			student.setDegree(Degree.MASTER);
		}
		else {
			student.setDegree(Degree.PHD);
		}
		
		System.out.println("\nEnter student's faculty: ");
		String faculty = br.readLine();
		if(faculty.equalsIgnoreCase("FIT")) { 
			student.setFaculty(Faculty.FIT);
		}
		else if(faculty.equalsIgnoreCase("BS")) {
			student.setFaculty(Faculty.BS);
		}
		else if(faculty.equalsIgnoreCase("FEOGI")) {
			student.setFaculty(Faculty.FEOGI);
		}
		else if(faculty.equalsIgnoreCase("FGE")) {
			student.setFaculty(Faculty.FGE);
		}
		else if(faculty.equalsIgnoreCase("SCE")) {
			student.setFaculty(Faculty.SCE);
		}
		else if(faculty.equalsIgnoreCase("ISE")) {
			student.setFaculty(Faculty.ISE);
		}
		else if(faculty.equalsIgnoreCase("KMA")) {
			student.setFaculty(Faculty.KMA);
		}
		else if(faculty.equalsIgnoreCase("SMC")) {
			student.setFaculty(Faculty.SMC);
		}
		student.constructId();
		student.constructMail();
		return student;
	}
	/**
     * This is about creating the new organization
     * @throws IOException
     * return o
     */
	public Organization createNewOrganization(BufferedReader br) throws IOException{
		System.out.println("\nEnter organization's name:");
		String name = br.readLine();
		Vector<Student> members = new Vector<Student>();
		members.add(this);
		Organization o = new Organization(name,this,members);
		return o;
	}
	
	public void joinOrganization(String nameOfOrganization) {
		Organization o = University.findOrganization(nameOfOrganization);
		if(o!= null) {
			o.addMember(this);
			this.setOrganization(o);
		}
		else {
			System.out.println("Organization does not exist!");
		}
	}
	
	
//	---------------------------------
	public int compareTo(Student o) {
		if(this.gpa > o.gpa) return 1;
		else if(this.gpa < o.gpa) return -1;
		return 0;
	}
	public boolean equals(Object o) {
		if(!super.equals(o)) return false;
		
		Student s = (Student)o;
		return this.id.equals(s.id) && this.degree == s.degree && this.faculty == s.faculty;
	}
	public int hashCode() {
		return Objects.hash(super.hashCode(), id, degree, faculty);
	}
	
//	---------------------------------
	
	
//	Methods
	
//	1.View courses
	public void viewCourses() {
		if(marks != null) {
			for(Course c : marks.keySet()) {
				c.printInfo();
			}
		}else {
			System.out.println("Student does not have course!");
		}
		
	}
//	2.Register for course
	public void registerCourse(Course c, int id) {
		Request request = new Request(this, c, id);
		Manager.addRequests(request);
	}
	
//	3.View info about teacher of a specific course
	public void infoAboutTeacherOfSpecificCourse(Course c){
		if(marks != null) {
			if(marks.containsKey(c)) {
				for(Course course : marks.keySet()) {
					if(course.equals(c)) {
						course.infoCourseTeachers();
					}
				}
			}else {
				System.out.println("You do not have this course!\n");
			}
		}else {
			System.out.println("You have no courses! Register for any of them!");
		}
		
		
	}
	
//	4.View Marks
	/**
     * Procedure of printing out the marks
     * @param marks  - marks
     */
	public void viewMarks() {
		for(Course c : marks.keySet()) {
			System.out.println(c.getName() + ":  " + marks.get(c).getOverall());
		}
	}
	
//	5.View transcript
	/**
     * Procedure of viewing the Transcript 
     */
	public void viewTranscript() {
		System.out.println("Code" + "\t\t" + "Name" + "\t\t" + "Credit" + "\t\t" + "Digit grade" + "\t" + "Letter grade" + "\t" + "GPA");
		for(Course c : marks.keySet()) {
			System.out.println(c.getCode() + "\t\t" + c.getName() + "\t\t" + c.getNumOfCredits() + "\t\t" + marks.get(c).getOverall() + "\t\t" + marks.get(c).getLetterGrade() + "\t\t" + marks.get(c).getGpa() + "\n");
		}
		
	}
	
//	6.Rate teachers
	/**
     * Procedure of rating the teacher
     */
	public void rateTeacher(Teacher teacher, int rate) {
		teacher.updateRating(rate);
	}
	
	public void viewSchedule() {
//		System.out.println("|Monday|\t\t\t\t|Tuesday|\t\t\t\t|Wednesday|\t\t\t\t|Thursday|\t\t\t\t|Friday|\t\t\t\t|Saturday|");
		for(Course course : marks.keySet()) {
			for(Lesson lesson : course.getLessons()) {
				if(lesson.getStudents().contains(this)) {
					String day = lesson.getSchedule().getDay();
						System.out.print(course.getName());
						System.out.print(" " + lesson.getTeacher().getSurname() + " " + lesson.getTeacher().getName().charAt(0));
						System.out.println("("+lesson.getSchedule().getTime() + ":00-" + (lesson.getSchedule().getTime() + lesson.getSchedule().getDuration()) + ":00)" + lesson.getType().charAt(0));
					
					
				}
			}
		}
	}
	
	public void viewOfficeHoursTeacher(Teacher teacher) {
		Vector<Schedule> officeHours = teacher.getOfficeHours();
		if(officeHours != null) {
			for(Schedule schedule : officeHours) {
				schedule.printInfo();
			}
		}else {
			System.out.println("Teacher does not have office hours!");
		}
		
	}
	
	
	

	
	
}
