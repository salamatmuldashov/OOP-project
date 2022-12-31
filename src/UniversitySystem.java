
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
/** 
 * Class UniversitySystem with <b>serialVersionUID</b>
 * @version 2.1
*/
public class UniversitySystem {
	private static final long serialVersionUID = 1L;
	/**
     * This is about creating the menu
     * @throws IOException
     * return command
     */
	public int menu(BufferedReader br) throws IOException {
		System.out.println("Please, enter your command:\n");
		System.out.println("To log in as a student enter 1\n");
		System.out.println("To log in as a teacher enter 2\n");
		System.out.println("To log in as a manager enter 3\n");
		System.out.println("To log in as a admin enter 4\n");
		System.out.println("To log in as a librarian enter 5\n");
		System.out.println("To exit enter 0\n");
		int command = Integer.parseInt(br.readLine());
		return command;
	}
	
	
	/**
     * This is about creating the student menu
     * @throws IOException
     * return command
     */
	public int StudentMenu(BufferedReader br) throws IOException {
		System.out.println("\nEnter 0 to log out from account");
		System.out.println("\nEnter 1 to reset password");
		System.out.println("\nEnter 2 to view courses");
		System.out.println("\nEnter 3 to register for course");
		System.out.println("\nEnter 4 to view info about teacher of a specific course");
		System.out.println("\nEnter 5 to view marks");
		System.out.println("\nEnter 6 to view transcript");
		System.out.println("\nEnter 7 to rate teacher");
		System.out.println("\nEnter 8 to create organization");
		System.out.println("\nEnter 9 to join organization");
		System.out.println("\nEnter 10 to see info about organization");
		System.out.println("\nEnter 11 to see schedule");
		System.out.println("\nEnter 12 to pay fee");
		System.out.println("\nEnter 13 to get gpa");
		System.out.println("\nEnter 14 to view office hours of teacher");
		System.out.println("\nEnter 15 to view info about yourself");
		System.out.println("\nEnter 16 to create research project");
		System.out.println("\nEnter 17 to work with research");
		System.out.println("\nEnter 18 to view research project");
		System.out.println("\nEnter 19 to view research paper");
		int command = Integer.parseInt(br.readLine());
		return command;
	}
	/**
     * This is about creating the teacher menu
     * @throws IOException
     * return command
     */
	public int TeacherMenu(BufferedReader br) throws IOException{
		System.out.println("\nEnter 0 to log out from account");
		System.out.println("\nEnter 1 to view courses");
		System.out.println("\nEnter 2 to view info about students");
		System.out.println("\nEnter 3 to view info about specific student");
		System.out.println("\nEnter 4 to put marks ");
		System.out.println("\nEnter 5 to send messages");
		System.out.println("\nEnter 6 to read messages");
		System.out.println("\nEnter 7 to reset password");
		System.out.println("\nEnter 8 to view rating");
		System.out.println("\nEnter 9 to send request to manager");
		System.out.println("\nEnter 10 to create office hours");
		System.out.println("\nEnter 11 to view office hours");
		System.out.println("\nEnter 12 to view info about yourself");
		System.out.println("\nEnter 13 to create research project");
		System.out.println("\nEnter 14 to work with research");
		System.out.println("\nEnter 15 to view research project");
		System.out.println("\nEnter 16 to view research paper");
		int command = Integer.parseInt(br.readLine());
		return command;
	}
	/**
     * This is about creating the manager menu
     * @throws IOException
     * return command
     */
	public int ManagerMenu(BufferedReader br) throws IOException{
		System.out.println("\nEnter 0 to log out from account");
		System.out.println("\nEnter 1 to approve registrations");
		System.out.println("\nEnter 2 to view requests from students");
		System.out.println("\nEnter 3 to add courses for registration");
		System.out.println("\nEnter 4 to add lesson for course");
		System.out.println("\nEnter 5 to assign courses to teachers");
		System.out.println("\nEnter 6 to manage news");
		System.out.println("\nEnter 7 to view info about students or teachers");
		System.out.println("\nEnter 8 to view requests from employees");
		System.out.println("\nEnter 9 to create statistical reports on academic performance");
		System.out.println("\nEnter 10 to view course list");
		System.out.println("\nEnter 11 to close attestation");
		System.out.println("\nEnter 12 to reset password");
		int command = Integer.parseInt(br.readLine());
		return command;
	}
	/**
     * This is about creating the admin menu
     * @throws IOException
     * return command
     */
	public int AdminMenu(BufferedReader br) throws IOException{
		System.out.println("\nEnter 0 to log out from account");
		System.out.println("\nEnter 1 to add user");
		System.out.println("\nEnter 2 to remove user");
		System.out.println("\nEnter 3 to update user");
		int command = Integer.parseInt(br.readLine());
		return command;
		
	}
	/**
     * This is about creating the librarian menu
     * @throws IOException
     * return command
     */
	public int LibrarianMenu(BufferedReader br)throws IOException{
		System.out.println("\nEnter 0 to log out from account");
		System.out.println("\nEnter 1 to reset password");
		System.out.println("\nEnter 2 to view list of book");
		System.out.println("\nEnter 3 to send request to manager");
		System.out.println("\nEnter 4 to add book to the system");
		int command = Integer.parseInt(br.readLine());
		return command;
	}
	
	
	
	
	
}
