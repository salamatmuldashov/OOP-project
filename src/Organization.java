
import java.io.Serializable;
import java.util.*;
/** 
 * Class Organization   with <b>serialVersionUID</b> <b>name</b> <b>president</b> <b>members</b>
*/
public class Organization implements Serializable{
	// serial
	private static final long serialVersionUID = 1L;
	// name
	private String name;
	// president
	private Student president;
	 // members
	private Vector<Student> members;
//	------------------Constructors-----------------------
	public Organization() {
		members = new Vector<Student>();
	}
	/** 
     * Constructor  - creating new Organization 
     * @param name - name
     */
	public Organization(String name) {
		this.name = name;
	}
	/** 
     * Constructor  - creating new Teacher 
     * @param name - name
     * @param president - president
     */
	public Organization(String name, Student president) {
		this(name);
		this.president = president;
	}

	/** 
     * Constructor  - creating new Teacher 
     * @param name - name
     * @param president - president
     * @param members - members
     */
	public Organization(String name, Student president, Vector<Student> members) {
		this(name,president);
		this.members = members;
	}
//	------------------------------------------
	
	
//	-----------------------Getters,Setters-----------------------
	/**
     * Procedure of defining the name  {@link Organization#name}
     * @param name - name
     */
	public void setName(String newName) {
		this.name = newName;
	}
	/**
     * Procedure of getting the name  
     * @param name - name 
     * @return name
     */
	public String getName() {
		return this.name;
	}
	/**
     * Procedure of defining the president {@link Organization#president}
     * @param president - president
     */
	public void setPresident(Student newPresident) {
		this.president = newPresident;
	}
	/**
     * Procedure of getting the president  
     * @param president - president
     * @return president
     */
	public Student getPresident() {
		return this.president;
	}
	/**
     * Procedure of defining the members {@link Organization#members}
     * @param members - members
     */
	public void setMembers(Vector<Student> newMembers) {
		this.members = newMembers;
	}
	/**
     * Procedure of getting the members
     * @param members - members
     * @return members
     */
	public Vector<Student> getMembers(){
		return this.members;
	}
//	-------------------------------------------------------------
	/**
     * Procedure of getting the info
     * @param members - members
     */
	public void infoMembers() {
		for(Student student : members) {
			student.printInfo();
		}
	}
	/**
     * Procedure of adding the members
     * @param members - members
     */
	public void addMember(Student s) {
		members.add(s);
	}
	/**
     * Procedure of getting the info
     * @param members - members
     * @param name - name 
     * @param president - president
     * @return members, name,president
     */
	public String toString() {
		return "Name: " + this.name + "\nPresident: " + this.president.getName() + " " + this.president.getSurname() + "\nMembers:";
	}
	public final void printInfo() {
		System.out.println(this.toString());
		this.infoMembers();
	}
	
	
//	public void announcement(BufferedReader br) {
//		String
//	}
//	
//	
	
}
