
import java.util.*;

import java.io.*;
/** 
 * Class University with <b>serialVersionUID</b><b>nameOfUniversity</b><b>users</b><b>courses</b><b>organizations</b><b>books</b><b>news</b>
 * @version 2.1
*/
public class University implements Serializable {
		private static final long serialVersionUID = 1L;
		private final static String nameOfUniversity = "Kazakh-British Technical University!";
		private static Vector<User> users;
		private static Vector<Course> courses;
		private static Vector<Organization> organizations;
		private static Vector<Book> books;
		private static Vector<String> news;
		static FileInputStream fis;
		static FileOutputStream fos;
		static ObjectOutputStream oos;
		static ObjectInputStream ois;
		/**
	     * This is about saving data 
	     * @throws IOException
	     */
		public static void saveData() throws IOException{
			University.serUsers();
			University.serCourses();
			University.serOrganizations();
			University.serBooks();
			University.serNews();
		}
		/**
	     * This is about serializing the users
	     * @throws IOException
	     */
		public static void serUsers() throws IOException {
			try {
				fos = new FileOutputStream("users.txt");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(users);
				oos.close();
			} catch(IOException i) {
				i.printStackTrace();
			}
			
		}
		/**
	     * This is about serializing the courses
	     * @throws IOException
	     */
		public static void serCourses()throws IOException {
			try {
				fos = new FileOutputStream("courses.txt");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(courses);
				oos.close();
			} catch(IOException i) {
				i.printStackTrace();
			}
		}
		/**
	     * This is about serializing the organizations
	     * @throws IOException
	     */
		public static void serOrganizations()throws IOException {
			try {
				fos = new FileOutputStream("organizations.txt");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(organizations);
				oos.close();
			} catch(IOException i) {
				i.printStackTrace();
			}
		}
		/**
	     * This is about serializing the books
	     * @throws IOException
	     */
		public static void serBooks()throws IOException{
			try {
				fos = new FileOutputStream("books.txt");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(books);
				oos.close();
			}catch(IOException i) {
				i.printStackTrace();
			}
		}
		/**
	     * This is about serializing the news
	     * @throws IOException
	     */
		public static void serNews()throws IOException{
			try {
				fos = new FileOutputStream("news.txt");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(news);
				oos.close();
			}catch(IOException i) {
				i.printStackTrace();
			}
		}
		/**
	     * This is about loading the data
	     * @throws IOException
	     */
		public static void loadData() throws ClassNotFoundException, IOException {
			University.deserUsers();
			University.deserCourses();
			University.deserOrganizations();
			University.deserBooks();
			University.deserNews();
		}
		
		@SuppressWarnings("unchecked")
		public static void deserUsers() throws IOException, ClassNotFoundException{
			File file = new File("users.txt");
			if(file.exists()) {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				users = (Vector<User>)ois.readObject();
			}else {
				file.createNewFile();
			}
		}
		
		@SuppressWarnings("unchecked")
		public static void deserCourses() throws IOException, ClassNotFoundException{
			File file = new File("courses.txt");
			if(file.exists()) {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				courses = (Vector<Course>)ois.readObject();
			}else {
				file.createNewFile();
			}
			
		}
		@SuppressWarnings("unchecked")
		public static void deserOrganizations() throws IOException, ClassNotFoundException{
			File file = new File("organizations.txt");
			if(file.exists()) {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				organizations = (Vector<Organization>)ois.readObject();
			}else {
				file.createNewFile();
			}
			
		}
		@SuppressWarnings("unchecked")
		public static void deserBooks()throws IOException, ClassNotFoundException{
			File file = new File("books.txt");
			if(file.exists()) {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				books = (Vector<Book>)ois.readObject();
			}else {
				file.createNewFile();
			}
		}
		@SuppressWarnings("unchecked")
		public static void deserNews() throws IOException, ClassNotFoundException{
			File file = new File("news.txt");
			if(file.exists()) {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				news = (Vector<String>)ois.readObject();
			}else {
				file.createNewFile();
			}
		}

//		-----------------Constructors---------------------
		
		static {
			users = new Vector<User>();
			courses = new Vector<Course>();
			books = new Vector<Book>();
			news = new Vector<String>();
			organizations = new Vector<Organization>();
		}
		
		public University() {
			
		}
		/** 
	     * Constructor  - creating new University
	     * @param users
	     */
		public University(Vector<User> users) {
			University.users = users;
		}

		/** 
	     * Constructor  - creating new University
	     * @param users
	     * @param courses
	     */
		public University(Vector<User> users, Vector<Course> courses) {
			this(users);
			University.courses = courses;
		}

		/** 
	     * Constructor  - creating new University
	     * @param users
	     * @param courses
	     * @param organzations
	     */
		public University(Vector<User> users, Vector<Course> courses, Vector<Organization> organizations) {
			this(users,courses);
			University.organizations = organizations;
		}

		/** 
	     * Constructor  - creating new University
	     * @param users
	     * @param courses
	     * @param organzations
	     * @param books
	     */
		public University(Vector<User> users, Vector<Course> courses, Vector<Organization> organizations, Vector<Book> books) {
			this(users,courses, organizations);
			University.books = books;
		}
		/** 
	     * Constructor  - creating new University
	     * @param users
	     * @param courses
	     * @param organzations
	     * @param books
	     * @param news
	     */
		public University(Vector<User> users, Vector<Course> courses, Vector<Organization> organizations, Vector<Book> books, Vector<String> news) {
			this(users,courses, organizations,books);
			University.news = news;
		}
	
//		----------------------------------------------------
		
//		------------------Getters, Setters--------------------
		/**
	     * Procedure of getting name of university
	     * @param nameOfUnivesity
	     * @return nameOfUniversity
	     */
		public static String getNameOfUniversity() {
			return nameOfUniversity;
		}
		/**
	     * Procedure of defining the users  {@link University#users}
	     * @param users
	     */
		public static void setUsers( Vector<User> newUsers) {
			users = newUsers;
		}
		/**
	     * Procedure of getting users
	     * @param users
	     * @return users
	     */
		public static  Vector<User> getUsers(){
			return users;
		}
		/**
	     * Procedure of defining the courses  {@link University#Courses}
	     * @param courses
	     */
		public static void setCourses(Vector<Course> newListCourses) {
			courses = newListCourses;
		}
		/**
	     * Procedure of getting courses
	     * @param courses
	     * @return courses
	     */
		public static Vector<Course> getCourses(){
			return courses;
		}
		/**
	     * Procedure of defining the organizations  {@link University#organizations}
	     * @param organizations
	     */
		public static void setOrganizations(Vector<Organization> newListOrganizations) {
			organizations = newListOrganizations;
		}
		/**
	     * Procedure of getting organizations
	     * @param organizations
	     * @return organizations
	     */
		public static Vector<Organization> getOrganizations(){
			return organizations;
		}
		/**
	     * Procedure of defining the books  {@link University#books}
	     * @param books
	     */
		public static void setBooks(Vector<Book> newBooks) {
			books = newBooks;
		}
		/**
	     * Procedure of getting books
	     * @param books
	     * @return books
	     */
		public static Vector<Book> getBooks(){
			return books;
		}
		/**
	     * Procedure of defining the news  {@link University#news}
	     * @param news
	     */
		public static void setNews(Vector<String> newNews) {
			news = newNews;
		}
//		------------------------------------------------------
		/**
	     * Procedure of getting students
	     * @param students
	     * @return students
	     */
		public static Vector<Student> getStudents() {
			Vector<Student> students = new Vector<Student>();
			for(User u : users) {
				if(u instanceof Student) {
					students.add((Student)u);
				}
			}
			return students;
		}
		/**
	     * Procedure of getting teachers
	     * @param teachers
	     * @return teachers
	     */
		public static Vector<Teacher> getTeachers(){
			Vector<Teacher> teachers = new Vector<Teacher>();
			for(User u : users) {
				if(u instanceof Teacher) {
					teachers.add((Teacher)u);
				}
			}
			return teachers;
		}
		
		public static void addUser(User u) {
			users.add(u);
		}
		public static void addCourse(Course c) {
			courses.add(c);
		}
		public static void addOrganization(Organization o) {
			organizations.add(o);
		}
		public static void addBook(Book b) {
			books.add(b);
		}
		public static void addNews(String info) {
			news.add(info);
		}
		public static void printUserList() {
			for(User u : users) {
				u.printInfo();
			}
		}
		public static void printCourseList() {
			for(Course c : courses) {
				c.printInfo();
			}
		}
		public static void printOrganizationList() {
			for(Organization o : organizations) {
				 o.printInfo();
			}
		}
		public static void printBookList() {
			for(Book b : books) {
				b.printInfo();
			}
		}
		public static void printNews() {
			for(String s : news) {
				System.out.println(s + "\n");
			}
		}
		public static Employee findEmployee(String mail) {
			Employee employee = null;
			for(User u : users) {
				if(u instanceof Employee) {
					Employee e = (Employee)u;
					String curMail = e.getMail();
					if(curMail.equalsIgnoreCase(mail)) {
						employee = (Employee)u;
					}
				}
			}
			return employee;
		}
		public static Student findStudent(String mail) {
			Student student = null;
			for(User u : users) {
				if(u instanceof Student) {
					Student s = (Student)u;
					String curMail = s.getMail();
					if(curMail.equalsIgnoreCase(mail)) {
						student = (Student) u;
					}
				}
			}
			return student;
		}
		
		public static Teacher findTeacher(String mail) {
			Teacher teacher = null;
			for(User u : users) {
				if(u instanceof Teacher) {
					Teacher t = (Teacher)u;
					String curMail = t.getMail();
					if(curMail.equalsIgnoreCase(mail)) {
						teacher = (Teacher)u;
					}
				}
			}
			return teacher;
		}
		
		public static Manager findManager(String mail) {
			Manager manager = null;
			for(User u : users) {
				if(u instanceof Manager) {
					Manager m = (Manager)u;
					String curMail = m.getMail();
					if(curMail.equalsIgnoreCase(mail)) {
						manager = (Manager)u;
					}
				}
			}
			return manager;
		}
		public static Librarian findLibrarian(String mail) {
			Librarian librarian = null;
			for(User u : users) {
				if(u instanceof Librarian) {
					Librarian l = (Librarian)u;
					String curMail = l.getMail();
					if(curMail.equalsIgnoreCase(mail)) {
						librarian = (Librarian)u;
					}
				}
			}
			return librarian;
		}
		public static Course findCourse(String code) {
			Course course = null;
			for(Course c : courses) {
				String curCode = c.getCode();
				if(curCode.equalsIgnoreCase(code)) {
					course = c;
				}
			}
			
			return course;
		}
		
		public static Organization findOrganization(String name) {
			Organization organization = null;
			for(Organization o : organizations) {
				String curName = o.getName();
				if(curName.equalsIgnoreCase(name)) {
					organization = o;
				}
			}
			return organization;
		}
		public static Book findBook(int id) {
			Book book = null;
			for(Book b : books) {
				int n = b.getId();
				if(id == n) {
					book = b;
				}
			}
			return book;
		}
		public static void viewCoursesList() {
			for(Course course : courses) {
				course.printInfo();
				System.out.println("Lessons");
				for(int i = 0; i < 25; i++) {
					System.out.print("-");
				}
				System.out.println();
				for(Lesson lesson : course.getLessons()) {
					lesson.printInfo();
				}
			}
		}
		
		public static void viewLessonsOfCourse(Course course) {
			for(Course c : courses) {
				if(c.equals(course)) {
					for(Lesson lesson : course.getLessons()) {
						lesson.printInfo();
					}
				}
			}
		}
		
		
		
		
		
		
}
