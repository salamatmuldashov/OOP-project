
import java.io.*;

import java.util.*;
/** 
 * Class Book with Class with <b>serialVersionUID</b> <b>sNo</b> <b>bookName</b> <b>authorName</b> 
*/
public class Book implements Serializable {
	// seriAl
	private static final long serialVersionUID = 1L;
	// sNo
	private int sNo;
	// bookName
	private String bookName;
	// authorName
	private String authorName;
	
	public Book() {
		
	}
	/** 
     * Constructor  - creating new Book with parameter
     * @param sNo - sNo
     * 
     */
	public Book(int sNo) {
		this.sNo = sNo;
	}

	/** 
     * Constructor  - creating new Book with parameter
     * @param sNo - sNo
  	 * @param bookName - bookName
     */
	public Book(int sNo, String bookName) {
		this(sNo);
		this.bookName = bookName;
	}
	/** 
     * Constructor  - creating new Book with parameter
     * @param sNo - sNo
  	 * @param bookName - bookName
  	 * @param authorName - authorName
     */
	public Book(int sNo, String bookName, String authorName) {
		this(sNo,bookName);
		this.authorName = authorName;
	}
	/**
     * Function that will get the id of Book {@link Book#sNo}
     * @return will return the id
     */
	public int getId() {
		return this.sNo;
	}
	/**
     * Procedure of defining the id  {@link User#sNo}
     * @param sNo - sNo
     */
	public void setId(int id) {
		this.sNo = id;
	}
	/**
     * Function that will get the name of Book {@link Book#bookName}
     * @return will return the name of the book
     */
	public String getName() {
		return this.bookName;
	}

	/**
     * Procedure of defining the name  {@link User#bookName}
     * @param bookName - bookName
     */
	public void setName(String name) {
		this.bookName = name;
	}
	/**
     * Function that will get the name of Author {@link Book#authorName}
     * @return will return the author of the book
     */
	public String getAuthor() {
		return this.authorName;
	}

	/**
     * Procedure of defining the author  {@link User#authorName}
     * @param authorName - authorName
     */
	public void setAuthor(String author) {
		this.authorName = author;
	}
	/**
     * Function that will get the full info  of book
     * @return will return the full info about the book
     */
	public String toString() {
		return "\nId: " + this.sNo + "\nName: " + this.bookName + "\nAuthor: " + this.authorName;
	}

	/**
     * Function that will print the full info  of book
     */
	public final void printInfo() {
		System.out.println(this.toString());
	}
	/**
     * This is about creating the new book with checking the error
     * @throws IOException
     * return book
     */
	public static Book createNewBook(BufferedReader br) throws IOException{
		System.out.println("Enter id of book:");
		int id = Integer.parseInt(br.readLine());
		System.out.println("Enter book name:");
		String name = br.readLine();
		System.out.println("Enter author:");
		String author = br.readLine();
		Book book = new Book(id,name,author);
		return book;
	}
	
	
	
}
