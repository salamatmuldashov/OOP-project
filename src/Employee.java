
import java.io.*;
import java.util.*;
/** 
 * Class Employee with <b>serialVersionUID</b> <b>salary</b> <b>unreadMessages</b> 
 * @version 2.1
*/
public abstract class Employee extends User implements Serializable{
	// serial
	private static final long serialVersionUID = 1L;
	// salary 
	private double salary;
	// unreadMessages
	private Vector<String> unreadMessages;
	
	
//	------Constructors-------
	public Employee() {
		super();
		unreadMessages = new Vector<String>();
	}
	/** 
     * Constructor  - creating new employee
     * @param name - name
     */
	public Employee(String name) {
		super(name);
	}

	/** 
     * Constructor  - creating new employee
     * @param name - name
     * @param surname - surname 
     */
	public Employee(String name, String surname) {
		super(name,surname);
	}
	/** 
     * Constructor  - creating new employee
     * @param name - name
     * @param surname - surname 
     * @param salary - salary 
     */
	public Employee(String name, String surname, double salary) {
		super(name,surname);
		this.salary = salary;
	}
	/** 
     * Constructor  - creating new employee
     * @param name - name
     * @param surname - surname 
     * @param salary - salary
     * @param unreadMessages - unreadMessages
     */
	public Employee(String name, String surname, double salary, Vector<String> unreadMessages) {
		super(name,surname);
		this.salary = salary;
		this.unreadMessages = unreadMessages;
	}
//	--------------------------
	
//	------Getters, Setters---------
	/**
     * Function that will get the salary of Employee {@link Employee#salary}
     * @param salary 
     * @return will return the salary
     */
	public double getSalary() {
		return this.salary;
	}
	/**
     * Function that will get the set salary 
     * @param salary 
     */
	public void setSalary(double newSalary) {
		this.salary = newSalary;
	}
	/**
     * Function that will get  unreadMessages
     * @param unreadMessages - unreadMessages
     * @return unreadMessages
     */
	public Vector<String> getUnreadMessages() {
		return this.unreadMessages;
	}
	/**
     * Function that will set unreadMessages 
     * @param unreadMessages - unreadMessages
     */
	public void setUnreadMessages(Vector<String> newUnreadMessages) {
		this.unreadMessages = newUnreadMessages;
	}

//	-------------------------------
	
//	--------------------INFO-------------------
	public String getEmployeeInfo() {
		String eInfo = super.getUserInfo();
		return eInfo;
		
	}
	
	public String toString() {
		return this.getEmployeeInfo();
	}
	
	public void printInfo() {
		System.out.println(this.toString());
	}
//	---------------------------------------------
	public int compareTo(Employee o) {
		if(this.salary > o.salary) return 1;
		else if(this.salary < o.salary) return -1;
		return 0;
	}
	
	public void sendMessages(BufferedReader br) throws IOException {
		System.out.println("Who do you want to send a message to?(Write the receiver's email)\n");
		String mail = br.readLine();	
		if(University.findEmployee(mail) == null) {
			System.out.println("Oops! Employee does not exist!");
		}
		else {
			System.out.println("Heading:");
			String heading = br.readLine();	
			System.out.println("Write a message: ");
			String message = br.readLine();
			Employee receiver = University.findEmployee(mail);
			String sender = "From: " + this.getMail();
			sender += "\nHeading: " + heading + "\n" + message + "\n";
			receiver.unreadMessages.add(sender);
		}
		
	}
	
	public void readMessages() {
		if(unreadMessages.size() != 0) {
			for(String message : unreadMessages) 
				System.out.println(message);
			
			unreadMessages.clear();
		}
		else {
			System.out.println("You have no message!\n");
		}
		
	}
	
	public void sendRequest(String message) {
		Request request = new Request(this, message);
		Manager.addRequests(request);
	}
	
	
	
	
	
	
	
}
