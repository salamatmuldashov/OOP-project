
import java.util.*;

import java.io.*;
/** 
 * Class Librarian with <b>serialVersionUID</b>
 * @version 2.1
*/
public class Librarian extends Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	public Librarian() {
		super();
	}
	/** 
     * Constructor  - creating new librarian
     * @param name - name
     */
	public Librarian(String name) {
		super(name);
	}

	/** 
     * Constructor  - creating new librarian
     * @param name - name
     * @param surname 
     */
	public Librarian(String name, String surname) {
		super(name,surname);
	}

	/** 
     * Constructor  - creating new librarian
     * @param name - name
     * @param surname 
     * @param salary
     */
	public Librarian(String name, String surname, double salary) {
		super(name,surname,salary);
	}

	/** 
     * Constructor  - creating new librarian
     * @param name - name
     * @param surname 
     * @param unreadMessages
     */
	public Librarian(String name, String surname, double salary, Vector<String> unreadMessages) {
		super(name,surname,salary,unreadMessages);
	}
	/**
     * This is about creating the new Librarian
     * @throws IOException
     * return librarian
     */
	public static Librarian createNewLibrarian(BufferedReader br)throws IOException{
		System.out.println("\nEnter librarian's name: ");
		String name = br.readLine();
		System.out.println("\nEnter librarian's surname: ");
		String surname = br.readLine();
		System.out.println("\nEnter librarian's salary: ");
		double salary = Double.parseDouble(br.readLine());
		Librarian librarian = new Librarian(name, surname, salary);
		librarian.constructMail();
		return librarian;
		
		
	}
	
	public void viewBookList() {
		University.printBookList();
	}
	public void addBook(Book b) {
		University.addBook(b);
	}

	
	
}
