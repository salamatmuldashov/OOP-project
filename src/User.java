
import java.io.*;
import java.util.*;
/** 
 * Class User with <b>serialVersionUID</b> <b>name</b> <b>surname</b> <b>mail</b> <b>password</b>
 * @version 2.1
*/
public abstract class User implements Serializable{
	//serial
	private static final long serialVersionUID = 1L;
	//name
	private String name;
	//surname
	private String surname;
	//mail
	private String mail;
	//password 
	private String password = "KbtuOneLove";
	
//	--------Constructors------
	
	public User() {
		
	}
	/** 
     * Constructor  - creating new object with parameter
     * @param name - name
     * 
     * @see User#User()
     */
	public User(String name) {
		this.name = name;
	}
	/** 
     * Constructor  - creating new object with parameters
     * @param name - name
     * @param surname - surname 
     * @see User#User()
     */
	public User(String name, String surname) {
		this(name);
		this.surname = surname;
	}
	
	
//	---------------------
	
	
	
//	-------Getters, Setters--------
	public void constructMail() {
		String firstCharOfName = this.getName().substring(0, 1).toLowerCase();
		String surname = this.getSurname().toLowerCase();
		String newMail = firstCharOfName + "_" + surname + "@kbtu.kz"; 
		this.setMail(newMail);
	}
	
	public void resetPassword(BufferedReader br) throws IOException{
		int numberOfTry = 0;
		while(true) {
			numberOfTry++;
			System.out.println("\nPlease enter old password to reset:");
			String curPassword = br.readLine();
			if(numberOfTry == 5) {
				System.out.println("You have no more attempts! Please, try again later. ");
				break;
			}
			if(curPassword.equals(password)) {
				System.out.println("\nPlease enter new password:");
				String newPassword = br.readLine();
//				setPassword(newPassword);
				setPassword(newPassword);
				System.out.println("Password is successfully changed!");
				break;
			}else {
				System.out.println("Password is not correct! You have " + (5-numberOfTry) + " tries to reset password!");
				}
			
		}

	}
	/**
     * Function that will get the name of User {@link User#name}
     * @return will return the name
     */
	public String getName() {
		return this.name;
	}

	/**
     * Function that will get the mail of User {@link User#mail}
     * @return will return the mail
     */
	public String getMail() {
		return this.mail;
	}

	/**
     * Function that will get the surname of User {@link User#surname}
     * @return will return the surname
     */
	public String getSurname() {
		return this.surname;
	}
	

	/**
     * Procedure of defining the name  {@link User#name}
     * @param name - name
     */
	public void setName(String newName) {
		this.name = newName;
	}

	/**
     * Procedure of defining the mail  {@link User#mail}
     * @param mail - mail
     */
	public void setMail(String newMail) {
		this.mail = newMail;
	}

	/**
     * Procedure of defining the surname  {@link User#surname}
     * @param surname - surname
     */
	public void setSurname(String newSurname) {
		this.surname = newSurname;
	}

	/**
     * Procedure of defining the password  {@link User#password}
     * @param password - password
     */
	public void setPassword(String newPassword) {
		password = newPassword;
	}

	/**
     * Procedure of getting the password  {@link User#password}
     * @param password - password
     * @return password
     */
	public String getPassword() {
		return password;
	}
//	-------------------------
	
//	---------------------------------
	/**
     * Procedure of comparing  the two users  
     * @param object - object 
     * @return result
     */
	public boolean equals(Object o) {
		if(o == this)return true;
		if(o == null) return false;
		if(this.getClass() != o.getClass()) return false;
		
		User u = (User)o;
		return this.name.equals(u.name) && this.surname.equals(u.surname) && this.mail.equals(u.mail) && this.password.equals(u.password);
	}
	
	public int hashCode() {

		return Objects.hash(this.name, this.mail);
	}
	
//	----------------------------------
	
//	---------------------INFO-------------------------

	/**
     * Procedure of getting the full information about the user  {@link Product#name}
     * @param name - name
     * return User
     */
	public String getUserInfo() {
		String uInfo = "Name:" + this.name + " | " + "Surname:" + this.surname + " | " + "Mail:" + this.mail;
		return uInfo;
	}
	/**
     * Procedure of getting the full information about the user  {@link Product#name}
     * @param name - name
     * return User
     */
	public String toString() {
		return this.getUserInfo();
	}
	/**
     * Procedure of getting the full information about the user  {@link Product#name}
     * @param name - name
     * return User
     */
	public void printInfo() {
		System.out.println(this.toString());
	}
//	-----------------------------------------------------
	
	/**
     * This is about loginSystem
     * @throws IOException
     * return login
     */
	public static String loginSystem() throws IOException {
		Vector<User> users = University.getUsers();
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		System.out.println("Enter login: ");
		String login = br.readLine();
		for(User u : users) {
			if (u.getMail().equals(login)) {
				System.out.println("Enter password: ");
				String password = br.readLine();
				if(u.getPassword().equals(password)) {
					System.out.println("\nWelcome " + u.getName() + " " + u.getSurname());
					return login;
				}else {
					System.out.println("Password is not correct!");
					return null;
				}
			}
		}
		System.out.println("You are not in the system! Please, ask the admin to add you\n");
		return null;
	}
	
}
