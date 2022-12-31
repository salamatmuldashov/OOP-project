
import java.io.Serializable;
/** 
 * Class Request   with <b>serialVersionUID</b> <b>from</b> <b>course</b> <b>id</b><b>message</b><b>isSigned</b>
*/
public class Request implements Serializable {
	private static final long serialVersionUID = 1L;
	private User from;
	private Course course;
	private int id;
	private String message;
	private boolean isSigned = false;
	public Request() {
		
	}
	/** 
     * Constructor  - creating new request
     * @param from
     */
	public Request(User from) {
		this.from = from;
	}

	/** 
     * Constructor  - creating new request
     * @param from
     * @param course
     */
	public Request(User from, Course course) {
		this(from);
		this.course = course;
	}

	/** 
     * Constructor  - creating new request
     * @param from
     * @param course
     * @param id
     */
	public Request(User from, Course course, int id) {
		this(from,course);
		this.id = id;
	}

	/** 
     * Constructor  - creating new request
     * @param from
     * @param course
     * @param id
     * @param message
     */
	public Request(User from, Course course, int id, String message) {
		this(from,course,id);
		this.message = message;
	}
	/** 
     * Constructor  - creating new request
     * @param from
     * @param course
     * @param id
     * @param message
     */
	public Request(User from, String message) {
		this.from = from;
		this.message = message;
	}
	
	/** 
     * getting the user
     * @param from
     * @return from
     */
	public User getUser() {
		return this.from;
	}

	/** 
     * getting the course
     * @param course
     * @return course
     */
	
	public Course getCourse() {
		return this.course;
	}
	/** 
     * getting the id
     * @param id
     * @return id
     */
	public int getId() {
		return this.id;
	}

	/** 
     * setting the user
     * @param user
     */
	public void setUser(User from) {
		this.from = from;
	}

	/** 
     * setting the course
     * @param course
     */
	public void setCourse(Course course) {
		this.course = course;
	}

	/** 
     * setting the id 
     * @param id
     */
	public void setId(int id) {
		this.id = id;
	}

	/** 
     * getting the message
     * @param message
     * @return message
     */
	public String getMessage() {
		return this.message;
	}

	/** 
     * setting the message 
     * @param message
     */
	public void setMessage(String message) {
		this.message = message;
	}
	/** 
     * setting the sign
     * @param isSigned
     */
	public void Sign() {
		this.isSigned = true;
	}

	/** 
     * getting the request
     * @param s
     * @return s
     */
	public String getRequest() {
		String s = "From: " + this.from + ", Course: " + this.course + ", Id: " + this.id;
		return s;
	}
	/** 
     * viewing the request
     * @param getRequest

     */
	public final void viewRequest() {
		System.out.println(this.getRequest());
	}
	
	
}
