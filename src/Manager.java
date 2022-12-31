
import java.util.*;
import java.io.*;
/** 
 * Class Manager with <b>serialVersionUID</b> <b>type</b> <b>requests</b> 
 * @version 2.1
*/
public class Manager extends Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	private Type type;
	private static Vector<Request> requests;

//	------------------Constructors------------------
	static {
		requests = new Vector<Request>();
	}
	public Manager() {
		super();
	}
	public Manager(String name) {
		super(name);
	}
	public Manager(String name, String surname) {
		super(name,surname);
	}
	public Manager(String name,String surname, double salary, Vector<Request> requests) {
		super(name,surname,salary);
		Manager.requests = requests;
	}
	public Manager(String name,String surname, double salary, Type type) {
		super(name,surname,salary);
		this.type = type;
	}

	public Manager(String name,String surname, double salary, Type type, Vector<Request> requests) {
		super(name,surname,salary);
		this.type = type;
		Manager.requests = requests;
	}
//	-------------------------------------------------
	public Type getType() {
		return this.type;
	}
	public void setType(Type newType) {
		this.type = newType;
	}
	public static Vector<Request> getRequests(){
		return requests;
	}
	public static void setRequests(Vector<Request> newRequests) {
		requests = newRequests;
	}
	public static void addRequests(Request request) throws NullPointerException {
		requests.add(request);
		
	}
	public static Vector<Request> getStudentsRequests(){
		Vector<Request> studentRequests = null;
		for(Request request : requests) {
			if(request.getUser() instanceof Student) {
				studentRequests.add(request);
			}
		}
		return studentRequests;
	}
	@SuppressWarnings("null")
	public static Vector<Request> getEmployeeRequests(){
		Vector<Request> employeeRequests = null;
		for(Request request : requests) {
			if(request.getUser() instanceof Employee) {
				employeeRequests.add(request);
			}
		}
		return employeeRequests;
	}

	public void viewStudentRequests() {
		for(Request request : requests) {
			if(request.getUser() instanceof Student) {
				request.viewRequest();
			}
		}
	}
	public void viewEmployeeRequests() {
		for(Request request : requests) {
			if(request.getUser() instanceof Employee) {
				System.out.println(request.getUser() + "\n" + request.getMessage());
				request.Sign();
			}
		}
	}
	public static Manager createNewManager(BufferedReader br) throws IOException{
		Manager manager = new Manager();
		System.out.println("\nEnter manager's name: ");
		String name = br.readLine();
		manager.setName(name);
		System.out.println("\nEnter manager's surname: ");
		String surname = br.readLine();
		manager.setSurname(surname);
		System.out.println("\nEnter manager's salary: ");
		double salary = Double.parseDouble(br.readLine());
		manager.setSalary(salary);		
		System.out.println("\nEnter type of manager:1)OR; 2)DEPARTMENT");
		String type = br.readLine();
		if(type.equalsIgnoreCase("OR")) {
			manager.setType(Type.OR);
		}else if(type.equalsIgnoreCase("DEPARTMENT")) {
			manager.setType(Type.DEPARTAMENT);
		}
		manager.constructMail();
		return manager;
	}
//	--------------------INFO--------------------
	public String getManagerInfo() {
		String sInfo = "Manager information:\n";
		String s1Info = super.getEmployeeInfo();
		sInfo = sInfo + s1Info;
		sInfo = sInfo + "\nType: " + this.type + "\t";
		sInfo = sInfo + "\n";
		return sInfo;
	}
	public String toString() {
		return this.getManagerInfo();
	}
	public final void printInfo() {
		System.out.println(this.toString());
	}
//	-------------------------------------------
	
//	---------Methods---------
	
//	1 - approve student registration
	
	public void approveRegistration(Student s) throws NullPointerException{
		boolean ok = false;
		for(Request request : requests) {
			if(request.getUser().equals(s)) {
				ok = true;
				Student student = (Student)request.getUser();
				Course course = request.getCourse();
				int id = request.getId();
				if(course.getFaculty().equals(student.getFaculty())) {
					if(course.getYearOfStudy() == student.getYearOfStudy()) {
						if(student.getTotalCredits() + course.getNumOfCredits() < 21) {
							course.getLesson(id).addStudent(student);
							student.addCourseMark(course, new Mark());
							student.setTotalCredits(student.getTotalCredits() + course.getNumOfCredits());
							requests.remove(request);
							System.out.println("Approved!");
							return;
						}else {
							System.out.println("Student can not have more than 21 credits!");
							requests.remove(request);
							return;
						}
						
					}
					System.out.println("Rejected! The year of the course and student does not match!");
					requests.remove(request);
					return;
				}
				else if(course.getFaculty().equals(Faculty.BASIC) || course.getFaculty().equals(Faculty.ELECTIVE)) {
					if(student.getTotalCredits() + course.getNumOfCredits() < 21) {
						student.addCourseMark(course, new Mark());
						course.getLesson(id).addStudent(student);
						student.setTotalCredits(student.getTotalCredits() + course.getNumOfCredits());
						requests.remove(request);
						System.out.println("Approved!");
						return;
					}else {
						System.out.println("Student can not have more than 21 credits!");
						requests.remove(request);
						return;
					}
					
				}
				System.out.println("Rejected! Student can not register to course from other faculty!");
				requests.remove(request);
				return;
			}
		}
		if(!ok) System.out.println("There is no request from this student!");
	}
	
//	2 - add courses for registration
	public void addCoursesForRegistration(Course c){
		University.addCourse(c);
	}
	
	public void addLessonForCourse(Course course, Lesson lesson) {
		course.addLesson(lesson);
	}
	
//	3 - assign course to teacher
	public void assignCourse(Course course, Teacher teacher, int id) {
		if(course.getLessons().size() > 0) {
			for(Lesson lesson : course.getLessons()) {
				if(lesson.getTeacher() == null) {
					if(lesson.getId() == id) {
						if(course.getFaculty().equals(teacher.getFaculty())) {
							if(teacher.getTitle().equals(Title.PROFESSOR) || teacher.getTitle().equals(Title.LECTOR)) {
								lesson.setTeacher(teacher);
								return;
							}
							else if(teacher.getTitle().equals(Title.TUTOR)) {
								if(lesson.getType().equalsIgnoreCase("Practice") || lesson.getType().equalsIgnoreCase("Lab")) {
									lesson.setTeacher(teacher);
									return;
								}
								System.out.println("Tutor can not take a lecture!");
								return;
							}
							System.out.println("There are no free slots!");
							return;
						}
						System.out.println("Teacher can not take course from other faculty!");
					}
				}
				
			}
		}else {
			System.out.println("Course does not have lessons! Please, ask manager to add new lessons for this course!");
		}
		
	}
	
	public void viewInfoAboutStudents(int order,int way) {
		if(order == 1) {
			Vector<Student> st = University.getStudents();
			if(way == 1) {
				Collections.sort(st, Collections.reverseOrder());
				for(Student s : st) {
					System.out.println(s.getName() + " " + s.getSurname() + " " + s.getMail() + " " + s.getGpa());
				}
			}else if(way == 2) {
				CompareByName cbn = new CompareByName();
				Collections.sort(st, cbn);
				for(Student s : st) {
					System.out.println(s.getName() + " " + s.getSurname() + " " + s.getMail());
				}
			}
		}else if(order == 2) {
			Vector<Teacher> tt = University.getTeachers();
			if(way == 2) {
				CompareByName cbn = new CompareByName();
				Collections.sort(tt, cbn);
				for(Teacher t : tt) {
					System.out.println(t.getName() + " " + t.getSurname() + " " + t.getMail());
				}
			}else if(way == 3) {
				Collections.sort(tt, Collections.reverseOrder(new CompareBySalary()));
				for(Teacher t : tt) {
					System.out.println(t.getName()+ " " + t.getSurname() + " " + t.getMail() + " " + t.getSalary());
				}
			}
		}
		
	}
	public void statisticalReport() {
		System.out.println(University.getUsers().size() + " users in the system");
		System.out.println(University.getStudents().size() + " of them students");
		System.out.println(University.getTeachers().size() + " of them teachers");
		System.out.println(University.getUsers().size() - (University.getStudents().size() + University.getTeachers().size()) + " of them other employees");
		System.out.println(University.getCourses().size() + " courses");
		System.out.println(University.getOrganizations().size() + " organizations");
		System.out.println(University.getBooks().size() + " books");
		
		Vector<Student> students = University.getStudents();
		double gpa = 0.0;
		int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
		for(Student student : students) {
			double gpaOfStudent = student.getGpa();
			if(gpaOfStudent >= 3.0) {
				count1++;
			}else if(gpaOfStudent >= 2.0 && gpaOfStudent < 3.0) {
				count2++;
			}
			else if(gpaOfStudent >= 1.0 && gpaOfStudent < 2.0) {
				count3++;
			}
			else {
				count4++;
			}
			gpa+=student.getGpa();
		}
		System.out.println("Average gpa: " + gpa/students.size());
		System.out.println("Count of student whose gpa more than 3: " + count1);
		System.out.println("Count of student whose gpa between 2 and 3: " + count2);
		System.out.println("Count of student whose gpa between 1 and 2: " + count3);
		System.out.println("Count of student whose gpa less than 1: " + count4);
	}
	
	public static void manageNews(String info) {
		University.addNews(info);
	}

	
	
}
