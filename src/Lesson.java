
import java.io.*;
import java.util.*;
/** 
 * Class Lesson with <b>serialVersionUID</b> <b>type</b> <b>id</b> <b>teacher</b> <b>schedule</b>
 * @version 2.1
*/
public class Lesson implements Serializable{
	// serial
	private static final long serialVersionUID = 1L;
	// type 
	private String type;
	// id 
	private int id;
	 // students
	private Vector<Student> students;
	// teacher
	private Teacher teacher;
	// schedule 
	private Schedule schedule;
	public Lesson() {
		students = new Vector<Student>();
		teacher = null;
		schedule = null;
	}
	/** 
     * Constructor  - creating new lesson
     * @param type - type 
     */
	public Lesson(String type) {
		this.type = type;
	}

	/** 
     * Constructor  - creating new lesson
     * @param type -type 
     * @param id - id 
     */
	public Lesson(String type, int id) {
		this(type);
		this.id = id;
	}

	/** 
     * Constructor  - creating new lesson
     * @param type - type 
     * @param id - id 
     * @param students - students
     */
	public Lesson(String type, int id, Vector<Student> students) {
		this(type,id);
		this.students = students;
	}

	/** 
     * Constructor  - creating new lesson
     * @param type - type 
     * @param id - id 
     * @param students - students
     * @param teacher - teacher
     */
	public Lesson(String type, int id, Vector<Student> students, Teacher teacher) {
		this(type,id);
		this.teacher = teacher;
	}
	/** 
     * Constructor  - creating new lesson
     * @param type - type 
     * @param id - id 
     * @param students - students 
     * @param teacher - teacher 
     * @param schedule - schedule 
     */
	public Lesson(String type, int id, Vector<Student> students, Teacher teacher, Schedule schedule) {
		this(type,id,students,teacher);
		this.schedule = schedule;
	}
	
	/**
     * Getting the type
     * @param type - type 
	 * @return type
     */
	
	public String getType() {
		return this.type;
	}
	/**
     * Setting the type {@link Lesson#type}
     * @param type - type 
     */
	public void setType(String newType) {
		this.type = newType;
	}
	/**
     * Getting the id
     * @param id - id 
	 * @return id
     */
	
	public int getId() {
		return this.id;
	}
	/**
     * Setting the id {@link Lesson#id}
     * @param id - id 
     */
	public void setId(int newId) {
		this.id = newId;
	}
	/**
     * Setting the students {@link Lesson#students}
     * @param students - students 
     */
	public void setStudents(Vector<Student> newStudents) {
		this.students = newStudents;
	}
	/**
     * Getting the students
     * @param students - students 
	 * @return students
     */
	public Vector<Student> getStudents(){
		return this.students;
	}
	/**
     * Getting the teacher
     * @param teacher - teacher 
	 * @return teacher
     */
	public Teacher getTeacher() {
		return this.teacher;
	}
	/**
     * Setting the teacher {@link Lesson#teacher}
     * @param teacher - teacher 
     */
	public void setTeacher(Teacher newTeacher) {
		this.teacher = newTeacher;
	}
	/**
     * Setting the schedule {@link Lesson#schedule}
     * @param schedule  - schedule 
     */
	public Schedule getSchedule() {
		return this.schedule;
	}
	public void setSchedule(Schedule newSchedule) {
		this.schedule = newSchedule;
	}
	
	public void teacherInfo() {
		this.teacher.printInfo();
	}
	public void studentsInfo() {
		if(students.size() != 0) {
			for(Student s : students) {
				s.printInfo();
			}
		}else {
			System.out.println("There is no students in this lesson!");
		}
		
	}
	public void addStudent(Student s) {
		students.add(s);
	}
	
	public String getLessonInfo() {
		String s = "Id:" + this.id + "| Type: " + this.type + " | " + (this.teacher != null ? this.teacher.getTeacherInfo() : "NULL");
		s = s + "\n" + this.schedule.getScheduleInfo() + "\n";
		return s;
	}
	
	public String toString() {
		return this.getLessonInfo();
	}
	public final void printInfo() {
		System.out.print(this.toString());
		for(int i = 0; i < 25; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	/**
     * This is about creating the new lesson
     * @throws IOException
     * return lesson
     */
	public static Lesson createNewLesson(BufferedReader br) throws IOException{
		Lesson lesson = new Lesson();
		System.out.println("Enter type of lesson: 1)Lecture; 2)Practice; 3)Lab;");
		String type = br.readLine();
		lesson.setType(type);
		System.out.println("Enter id of lesson:");
		int id = Integer.parseInt(br.readLine());
		lesson.setId(id);
		System.out.println("Set schedule: ");
		Schedule schedule = Schedule.createNewSchedule(br);
		lesson.setSchedule(schedule);		
		return lesson;
	}
	
}
