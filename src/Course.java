
import java.util.*;

import java.io.*;
/** 
 * Class Course with <b>serialVersionUID</b> <b>name</b> <b>code</b> <b>numOfCredits</b> <b>yearOfStusy</b><b>faculty</b><b>lessons</b>
 * @version 2.1
*/
public class Course implements Serializable{
	// serialVersion 
	private static final long serialVersionUID = 1L;
	// name
	private String name;
	// code 
	private String code;
	// numOfCredits
	private int numOfCredits;
	// yearOfStudy
	private int yearOfStudy;
	// faculty
	private Faculty faculty;
	// lessons
	private Vector<Lesson> lessons;
//	---------------------------Constructors-------------------------------------
	
	public Course() {
		lessons = new Vector<Lesson>();
	}
	/** 
     * Constructor  - creating new course
     * @param name - name
     */
	public Course(String name) {
		this.name = name;
	}

	/** 
     * Constructor  - creating new course
     * @param name - name
     * @param code - code 
     */
	public Course(String name, String code) {
		this(name);
		this.code = code;
	}

	/** 
     * Constructor  - creating new course
     * @param name - name
     * @param code - code 
     * @param numOfCredits
     */
	public Course(String name, String code, int numOfCredits) {
		this(name,code);
		this.numOfCredits = numOfCredits;
	}
	/** 
     * Constructor  - creating new course
     * @param name - name
     * @param code - code 
     * @param numOfCredits - yearOfStudy
     * @param yearOfStudy - yearOfStudy
     */
	public Course(String name, String code, int numOfCredits, int yearOfStudy, Vector<Lesson> lessons) {
		this(name,code,numOfCredits);
		this.yearOfStudy = yearOfStudy;
		this.lessons = lessons;
	}
	/** 
     * Constructor  - creating new course
     * @param name - name
     * @param code - code 
     * @param numOfCredits - numOfCredits
     * @param yearOfStudy - yearOfStudy
     * @param faculty - faculty
     */
	public Course(String name, String code, int numOfCredits, int yearOfStudy,Vector<Lesson> lessons, Faculty faculty) {
		this(name, code, numOfCredits, yearOfStudy, lessons);
		this.faculty = faculty;
	}
	/** 
     * Constructor  - creating new course
     * @param name - name
     * @param code - code 
     * @param numOfCredits - numOfCredits
     * @param yearOfStudy - yearOfStudy
     * @param faculty - faculty 
     * @param lessons - lessons
     */
	/** 
     * Constructor  - creating new course
     * @param name - name
     * @param code - code 
     * @param numOfCredits - numOfCredits
     * @param yearOfStudy - yearOfStudy
     * @param faculty - faculty 
     * @param lessons -lessons
     */
	public Course(String name, String code, int numOfCredits, Vector<Lesson> lessons) {
		this(name, code, numOfCredits);
		this.lessons = lessons;
	}
	/** 
     * Constructor  - creating new course
     * @param name - name
     * @param code - code 
     * @param numOfCredits -numOfCredits
     * @param yearOfStudy - yearOfStudy
     * @param faculty - faculty
     * @param lessons - lessons
     */
	public Course(String name, String code, int numOfCredits, Vector<Lesson> lessons, Faculty faculty) {
		this(name, code, numOfCredits, lessons);
		this.faculty = faculty;
	}
	
	
//	--------------------------------------------------------------------------------
	
//	-------------------------------Getters, Setters------------------------------------
	/**
     * Procedure of defining the name  {@link Course#name}
     * @param name - name
     */
	public void setName(String newName) {
		this.name = newName;
	}
	/**
     * Procedure of defining the numOfCredits {@link Course#numOfCredits}
     * @param numOfCredits
     */
	public void setNumOfCredits(int num) {
		this.numOfCredits = num;
	}
	/**
     * Procedure of defining the lessons {@link Course#lessons}
     * @param lessons - lessons
     */
	public void setLessons(Vector<Lesson> newLessons) {
		this.lessons = newLessons;
	}
	/**
     * Procedure of defining the faculty  {@link Course#faculty}
     * @param faculty - faculty
     */
	public void setFaculty(Faculty newFaculty) {
		this.faculty = newFaculty;
	}
	/**
     * Getting the name 
     * @param name - name 
	 * @return name 
     */
	public String getName() {
		return this.name;
	}
	/**
     * Getting the numOfCredits
     * @param numOfCredits - numOfCredits
	 * @return numOfCredits 
     */
	public int getNumOfCredits() {
		return this.numOfCredits;
	}
	/**
     * Getting the lessons
     * @param lessons - lessons
	 * @return lessons
     */
	public Vector<Lesson> getLessons() {
		return this.lessons;
	}
	/**
     * Getting the faculty
     * @param faculty - faculty
	 * @return faculty
     */
	public Faculty getFaculty() {
		return this.faculty;
	}
	public Lesson getLesson(int id) {
		for(Lesson lesson : lessons) {
			if(lesson.getId() == id) {
				return lesson;
			}
		}
		return null;
	}
	/**
     * Procedure of defining the code  {@link Course#code}
     * @param code - code 
     */
	public void setCode(String newCode) {
		this.code = newCode;
	}
	/**
     * getting the code
     * @param code - code 
     * @return code
     */
	public String getCode() {
		return this.code;
	}
	/**
     * getting the yearOfStudy
     * @param yearOfStudy - code 
     */
	public int getYearOfStudy() {
		return this.yearOfStudy;
	}
	/**
     * Procedure of defining the yearOfStusy {@link Course#yearOfStudy}
     * @param yearOfStudy - code 
     */
	public void setYearOfStudy(int year) {
		this.yearOfStudy = year;
	}
//	-----------------------------------------------------------------------------------
	
//	--------------------INFO-------------------------
	String getCourseInfo() {
		String cInfo = "Course information:\n";
		cInfo = cInfo + "Name of course: " + this.name + ",\t";
		cInfo = cInfo + "Code of course: " + this.code + ",\t";
		cInfo = cInfo + "Number of credits: " + this.numOfCredits + ",\t";
		cInfo = cInfo + "Faculty: " + this.faculty + ",\t";
		return cInfo;
	}
	public String toString() {
		return this.getCourseInfo();
	}
	public final void printInfo() {
		System.out.println(this.toString());
	}
//	-------------------------------------------------
	
	public void addLesson(Lesson l){
		if(this.lessons == null) {
			lessons.add(l);
		}else {
			lessons.add(l);
		}
		
	}
	
	public void lessonsInfo() {
		for(Lesson lesson : lessons) {
			lesson.printInfo();
		}
	}
	/**
     * This is about creating the new course
     * @throws IOException
     * return course
     */
	public static Course createNewCourse(BufferedReader br) throws IOException {
		Course course = new Course();
		System.out.println("Enter course name: ");
		String name = br.readLine();
		course.setName(name);
		System.out.println("Enter course code: ");
		String code = br.readLine();
		course.setCode(code);
		System.out.println("Number of credits: ");
		int numOfCredits = Integer.parseInt(br.readLine());
		course.setNumOfCredits(numOfCredits);
		System.out.println("Which year of study the course is intended?");
		int yearOfStudy = Integer.parseInt(br.readLine());
		course.setYearOfStudy(yearOfStudy);
		
		System.out.println("Enter faculty of course: ");
		String faculty = br.readLine();
		if(faculty.equalsIgnoreCase("FIT")) { 
			course.setFaculty(Faculty.FIT);
		}
		else if(faculty.equalsIgnoreCase("BS")) {
			course.setFaculty(Faculty.BS);
		}
		else if(faculty.equalsIgnoreCase("FEOGI")) {
			course.setFaculty(Faculty.FEOGI);
		}
		else if(faculty.equalsIgnoreCase("FGE")) {
			course.setFaculty(Faculty.FGE);
		}
		else if(faculty.equalsIgnoreCase("SCE")) {
			course.setFaculty(Faculty.SCE);
		}
		else if(faculty.equalsIgnoreCase("ISE")) {
			course.setFaculty(Faculty.ISE);
		}
		else if(faculty.equalsIgnoreCase("KMA")) {
			course.setFaculty(Faculty.KMA);
		}
		else if(faculty.equalsIgnoreCase("SMC")) {
			course.setFaculty(Faculty.SMC);
		}
		else if(faculty.equalsIgnoreCase("ELECTIVE")) {
			course.setFaculty(Faculty.ELECTIVE);
		}
		else if(faculty.equalsIgnoreCase("BASIC")) {
			course.setFaculty(Faculty.BASIC);
		}
		
		
		
				
		return course;
	}
	
	public void infoCourseStudents() {
		HashSet<Student> listOfStudents = new HashSet<Student>();
		for(Lesson l : lessons) {
			for(Student s : l.getStudents()) {
				listOfStudents.add(s);
			}
			
		}
		for(Student s : listOfStudents) {
			s.printInfo();
		}
	}
	
	public void infoCourseTeachers() {
		HashSet<Teacher> listOfTeachers = new HashSet<Teacher>();
		for(Lesson l : lessons) {
			if(l.getTeacher()!=null) {
				listOfTeachers.add(l.getTeacher());
			}
			
		}
		
		for(Teacher t : listOfTeachers) {
			t.printInfo();
		}
	}
	public HashSet<Teacher> getTeachersOfCourse(){
		HashSet<Teacher> teachers = new HashSet<Teacher>();
		for(Lesson l : lessons) {
			if(l.getTeacher() != null) {
				teachers.add(l.getTeacher());
			}
			
		}
		return teachers;
	}
	public HashSet<Student> getStudentOfCourse(){
		HashSet<Student> students = new HashSet<Student>();
		for(Lesson l : lessons) {
			for(Student s : l.getStudents()) {
				students.add(s);
			}
		}
		return students;
	}
		
		
	
	
}
	
	
