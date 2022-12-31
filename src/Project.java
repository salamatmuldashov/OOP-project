
import java.io.*;
/** 
 * Class Project with <b>serialVersionUID</b><b>title</b><b>worker</b><b>researchPaper</b><b>hindex</b>
 * @version 2.1
*/
public class Project implements Serializable {
	// serial
	private static final long serialVersionUID = 1L;
	// title 
	private String title;
	//worker
	private User worker;
	//researchPaper
	private String researchPaper;
	//index 
	private int hindex;
	public Project() {
		researchPaper = null;
	}
	/** 
     * Constructor  - creating new project
     * @param title - title 
     * @param worker - worker
     * @param researchPaper - researchPaper
     * @param hindex - hindex
     */
	public Project(String title, User worker, String researchPaper, int hindex) {
		this.title = title;
		this.worker = worker;
		this.researchPaper = researchPaper;
		this.hindex = hindex;
	}
	/**
     * Setting the worker {@link Project#worker}
     * @param worker - worker 
     */
	public void setWorker(User worker) {
		this.worker = worker;
	}
	/**
     * Getting the worker 
     * @param worker - worker
     * @return worker - worker 
     */
	public User getWorker() {
		return this.worker;
	}
	/**
     * Getting the researchPaper 
     * @param researchPaper - researchPaper 
     * @return researchPaper
     */
	public String getPaper() {
		return this.researchPaper;
	}
	/**
     * Setting the researchPaper {@link Project#researchPaper}
     * @param researchPaper - researchPaper 
     */
	public void setPaper(String paper) {
		this.researchPaper = paper;
	}
	/**
     * Getting the h_index 
     * @param hindex - h_index
     * @return h_index
     */
	public int getHIndex() {
		return this.hindex;
	}
	/**
     * Setting the index {@link Project#index}
     * @param index - index 
     */
	public void setHIndex(int index) {
		this.hindex = index;
	}
	
	public String toString() {
		return "\nTitle: " +this.title + "\nStudent: " + this.worker.getName() + " " + this.worker.getSurname() + "\nH-Index: " + this.hindex;
	}
	public final void printInfo() {
		System.out.println(this.toString());
	}
	/**
     * This is about creating the new project
     * @throws IOException
     * return project
     */
	public static Project createNewProject(BufferedReader br)throws IOException{
		System.out.println("Enter your project title");
		String title = br.readLine();
		System.out.println("Enter h-index:");
		int n = Integer.parseInt(br.readLine());
		Project project = new Project(title, null, null, n);
		return project;
	}
	
	public void update(String work) {
		this.researchPaper += work + "\n";
	}
	

	
	
}
