

import java.util.HashMap;

import java.util.HashSet;
import java.util.Vector;
import java.io.*;
import java.text.DecimalFormat;
/** 
 * Class UniversitySystemTest with 
 * @version 2.1
*/
public class UniversitySystemTest {
	/**
     * This is about realizing and testing
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws NullPointerException
     */
	public static void main(String[] args) throws IOException, ClassNotFoundException, NullPointerException{
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		System.out.println("Welcome to uninet system of " + University.getNameOfUniversity());
		UniversitySystem uninet = new UniversitySystem();
		University.loadData();
		System.out.println("News");
		University.printNews();
		int command = uninet.menu(br);
		while(true) {
			if(command == 0)
				System.exit(0);
			else if(command == 1) {
				Student student = University.findStudent(User.loginSystem());
				if(student != null) {
					command = uninet.StudentMenu(br);
					while(true) {
						if(command == 0)
							break;
						else if(command == 1) {
							student.resetPassword(br);
						}
						else if(command == 2) {
							student.viewCourses();
						}
						else if(command == 3) {
							University.printCourseList();
							System.out.println("\nWhich course you want to register? Please enter code:");
							String code = br.readLine();
							Course course = University.findCourse(code);
							if(course != null) {
								if(student.getStudentFee() >= 2500) {
									University.viewLessonsOfCourse(course);
									System.out.println("Enter id of lesson:");
									int id = Integer.parseInt(br.readLine());
									student.registerCourse(course, id);
								}else {
									System.out.println("Pay the student fee to get access to this option");
								}
								
								
							}else {
								System.out.println("Course does not have exist in the system!");
							}
							
						}
						else if(command == 4) {
							System.out.println("Enter code of course:");
							String code = br.readLine();
							Course course = University.findCourse(code);
							if(course != null) {
								student.infoAboutTeacherOfSpecificCourse(course);
							}else System.out.println("Course does not exist in the system!");
						}
						else if(command == 5) {
							student.viewMarks();
						}
						else if(command == 6) {
							student.viewTranscript();
						}
						else if(command == 7) {
							System.out.println("Enter the email of the teacher you want to rate:");
							String mail = br.readLine();
							Teacher teacher = University.findTeacher(mail);
							if(teacher!=null) {
								System.out.println("Rate the teacher from 0 to 10:");
								int rate = Integer.parseInt(br.readLine());
								student.rateTeacher(teacher,rate); 
								
							}else {
								System.out.println("Teacher does not exist!");
							}
							        
						}
						else if(command == 8){
							Organization o = student.createNewOrganization(br);
							University.addOrganization(o);
							student.setOrganization(o);
						}else if(command == 9) {
							System.out.println("Enter name of organization:");
							String name = br.readLine();
							student.joinOrganization(name);
						}else if(command == 10) {
							student.printInfoAboutOrg();
						}
						else if(command == 11) {
							student.viewSchedule();
						}
						else if(command == 12) {
							System.out.println("How much do you want to pay?");
							double newFee = Double.parseDouble(br.readLine());
							student.setStudentFee(newFee);
						}
						else if(command == 13) {
							student.calculateGpa();
							System.out.println(student.getGpa());

						}
						else if(command == 14) {
							boolean ok = false;
							System.out.println("Enter mail of teacher:");
							String mail = br.readLine();
							Teacher teacher = University.findTeacher(mail);
							Vector<Course> courses = University.getCourses();
							for(Course course : courses) {
								for(Lesson lesson : course.getLessons()) {
									if(lesson.getStudents().contains(student)) {
										if(lesson.getTeacher().equals(teacher)) {
											ok = true;
											student.viewOfficeHoursTeacher(teacher);
											break;
										}
									}
								}
							}
							if(!ok)System.out.println("You do not have access to view office hours of this teacher!");
							
						}
						else if(command == 15) {
							student.printInfo();
						}
						else if(command == 16) {
							if(student.getDegree().equals(Degree.PHD) || student.getYearOfStudy() == 4) {
								Project project = Project.createNewProject(br);
								student.createResearch(project);
							}else {
								System.out.println("You do not have access!");
							}
						}
						else if(command == 17) {
							if(student.getProject() != null) {
								System.out.println("What you would like to add to your project:");
								String work = br.readLine();
								student.workResearch(work);
							}else {
								System.out.println("You do not have project!");
							}
							
						}
						else if(command == 18) {
							student.getProject().printInfo();
						}
						else if(command == 19) {
							System.out.println(student.getProject().getPaper());
						}
						else {
							System.out.println("Error! Unknown command!");
						}
						
						University.saveData();
						command = uninet.StudentMenu(br);
						
					}	
				}
			}
			else if(command == 2) {
				Teacher teacher = University.findTeacher(User.loginSystem());
				if(teacher != null) {
					command = uninet.TeacherMenu(br);
					while(true) {
						if(command == 0) {
							break;
						}
						else if(command == 1) {
							teacher.viewCourses();
							
						}
						else if(command == 2) {
							System.out.println("Enter code of course which students you want to see:");
							String code = br.readLine();
							Course course = University.findCourse(code);
							if(course != null) {
								teacher.viewStudentsInfo(course);
							}
							else System.out.println("Course does not exist!");
						}
						else if(command == 3) {
							System.out.println("Enter mail of student whose info you want to see:");
							String mail = br.readLine();
							Student student = University.findStudent(mail);
							if(student != null) {
								teacher.viewStudent(student);
							}
							else System.out.println("Student does not exist!");
						}
						else if(command == 4) {
							System.out.println("Enter mail of student to put mark:");
							String mail = br.readLine();
							Student student = University.findStudent(mail);
							System.out.println("Enter code of course:");
							String code = br.readLine();
							Course course = University.findCourse(code);
							if(student != null && course != null) {
								if(course.getStudentOfCourse().contains(student)) {
									if(course.getTeachersOfCourse().contains(teacher)) {
										if(Mark.getInfoAboutAttestation() == false) {
											System.out.println("Which attestation do you want to add points?");
											int attestation = Integer.parseInt(br.readLine());
											System.out.println("How many points?");
											double point = Double.parseDouble(br.readLine());
											teacher.putMark(student, course, attestation, point);
										}else {
											System.out.println("Attestation is closed! You can not put mark!");
										}
									}
									else System.out.println("There is no such teacher in this course!");
								}
								else System.out.println("There is no such student in this course!");
							}
							else System.out.println("Error! Student or course does not exist in the system!");
									
						}
						else if(command == 5) {
							teacher.sendMessages(br);
						}
						else if(command == 6) {
							teacher.readMessages();
						}
						else if(command == 7) {
							teacher.resetPassword(br);
						}
						else if(command == 8) {
							System.out.println(teacher.getOverallRating());
						}
						else if(command == 9) {
							System.out.println("Message:");
							String message = br.readLine();
							teacher.sendRequest(message);
						}
						else if(command == 10) {
							Schedule officeHours = Schedule.createNewSchedule(br);
							teacher.addOfficeHour(officeHours);
						}
						else if(command == 11) {
							teacher.viewOfficeHours();
						}
						else if(command == 12) {
							teacher.printInfo();
						}
						else if(command == 13) {
							if(teacher.getTitle().equals(Title.PROFESSOR)) {
								Project project = Project.createNewProject(br);
								teacher.createResearch(project);
							}else {
								System.out.println("You do not have access!");
							}
						}
						else if(command == 14) {
							if(teacher.getProject() != null) {
								System.out.println("What you would like to add to your project:");
								String work = br.readLine();
								teacher.workResearch(work);
							}else {
								System.out.println("You do not have project!");
							}
						}
						else if(command == 15) {
							teacher.getProject().printInfo();
						}
						else if(command == 16) {
							System.out.println(teacher.getProject().getPaper());
						}
						
						else {
							System.out.println("Error! Unknown command!");
						}
						University.saveData();
						command = uninet.TeacherMenu(br);
						
					}
				}
				
			}
//				
			else if(command == 3) {
				Manager manager = University.findManager(User.loginSystem());
				if(manager != null) {
					command = uninet.ManagerMenu(br);
					while(true) {
						if(command == 0) {
							break;
						}
						else if(command == 1) {
							if(manager.getType().equals(Type.OR)) {
								System.out.println("Enter mail of student:");
								String mail = br.readLine();
								Student student = University.findStudent(mail);
								manager.approveRegistration(student);
							}else {
								System.out.println("You do not have access!");
							}
							
						}
						else if(command == 2) {
							manager.viewStudentRequests();
							
						}
						else if(command == 3) {
							Course course = Course.createNewCourse(br);
							manager.addCoursesForRegistration(course);
						}
						else if(command == 4) {
							System.out.println("For which course you want to add lesson?");
							String code = br.readLine();
							Course course = University.findCourse(code);
							if(course != null) {
								Lesson lesson = Lesson.createNewLesson(br);
								manager.addLessonForCourse(course, lesson);
							}else System.out.println("Course does not exist in the system!");
							
						}
						else if(command == 5) {
							System.out.println("Which course you want to assign?");
							String code = br.readLine();
							System.out.println("To whom?");
							String mail = br.readLine();
							Course course = University.findCourse(code);
							Teacher teacher = University.findTeacher(mail);
							University.viewLessonsOfCourse(course);
							System.out.println("Enter id of lesson:");
							int id = Integer.parseInt(br.readLine());
							if(course != null && teacher != null) {
								manager.assignCourse(course,teacher, id);
							}else {
								System.out.println("Error! Course or teacher does not exist!");
							}
							
						}
						else if(command == 6) {
							System.out.println("Enter message for all:");
							String info = br.readLine();
							Manager.manageNews(info);
						}
						else if(command == 7) {
							System.out.println("1)Student; 2)Teachers");
							int order = Integer.parseInt(br.readLine());
							System.out.println("In what way you want to view list of student? 1)Sorted by gpa; 2)Alphabetically; 3)Salary");
							int way = Integer.parseInt(br.readLine());
							manager.viewInfoAboutStudents(order, way);
						}
						else if(command == 8) {
							if(manager.getType().equals(Type.DEPARTAMENT)) {
								if(Manager.getEmployeeRequests()!= null) {
									manager.viewEmployeeRequests();
									Manager.getRequests().clear();
									System.out.println("Signed!");
								}else {
									System.out.println("No requests from employees!");
								}
		
							}
							else {
								System.out.println("Only department can have access to this option!");
							}
							
						}
						else if(command == 9) {
							manager.statisticalReport();
						}
						else if(command == 10) {
							University.viewCoursesList();
						}
						else if(command == 11) {
							Mark.closeAttestation();
							System.out.println("Attestation closed!");
							Vector<Student> students = University.getStudents();
							for(Student student : students) {
								for(Mark mark : student.getMarks().values()) {
									mark.updateGrade();
								}
							}
						}
						else if(command == 12) {
							manager.resetPassword(br);
						}
						
						else {
							System.out.println("Error! Unknown command!");
						}
						University.saveData();
						command = uninet.ManagerMenu(br);
					}
				}
			}
			else if(command == 4) {
				User user = Admin.getInstance();
				Admin admin = (Admin)user;
				command = uninet.AdminMenu(br);
				while(true) {
					if(command == 0) {
						break;
					}
					else if(command == 1) {
						admin.addUser(br);
					}
					else if(command == 2) {
						admin.removeUser(br);
					}
					else if(command == 3) {
						admin.updateUser(br);
					}
					else if(command == 4) {
						University.printUserList();
					}
					else if(command == 5) {
						University.printCourseList();
					}
					else {
						System.out.println("Error! Unknown command!");
					}
					University.saveData();
					command = uninet.AdminMenu(br);
				}
			}
			else if(command == 5) {
				Librarian librarian = University.findLibrarian(User.loginSystem());
				if(librarian!=null) {
					command = uninet.LibrarianMenu(br);
					while(true) {
						if(command == 0) {
							break;
						}
						else if(command == 1) {
							librarian.resetPassword(br);
						}
						else if(command == 2) {
							librarian.viewBookList();
						}
						else if(command == 3) {
							System.out.println("Message:");
							String message = br.readLine();
							librarian.sendRequest(message);
						}
						else if(command == 4) {
							Book book = Book.createNewBook(br);
							librarian.addBook(book);
						}
						else {
							System.out.println("Error! Unknown command!");
						}
						University.saveData();
						
						command = uninet.LibrarianMenu(br);
					}
					
				}
			}
			
				University.saveData();
				command = uninet.menu(br);
		}
		


		
		
	}

}