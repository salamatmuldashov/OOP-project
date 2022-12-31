
import java.io.*;

import java.util.*;
/** 
 * Class Schedule   with <b>serialVersionUID</b> <b>day</b> <b>time</b> <b>duration</b>
*/
public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;
	private String day;
	private int time;
	private int duration;
	
	public Schedule() {
		
	}
	/** 
     * Constructor  - creating new schedule
     * @param day - day 
     */
	public Schedule(String day) {
		this.day = day;
	}

	/** 
     * Constructor  - creating new schedule
     * @param day -day
     * @param time - time 
     */
	public Schedule(String day, int time) {
		this(day);
		this.time = time;
	}

	/** 
     * Constructor  - creating new schedule
     * @param day - day 
     * @param time - time 
     * @param duration - duration 
     */
	public Schedule(String day, int time, int duration) {
		this(day,time);
		this.duration = duration;
	}
	
//	----------------Getters, Setters-------------------
	/** 
     * getting the day
     * @param day - day 
     * @return day 
     */
	public String getDay(){
		return this.day;
	}
	/** 
     * setting the day {@link Schedule#day}
     * @param day - day 

     */
	public void setDay(String newDay) {
		this.day = newDay;
	}
	/** 
     * getting the time
     * @param time -time 
     * @return time
     */
	public int getTime(){
		return this.time;
	}
	/** 
     * setting the time {@link Schedule#time}
     * @param time - time 

     */
	public void setTime(int newTime) {
		this.time = newTime;
	}
	/** 
     * getting the duration
     * @param duration - duration 
     * @return duration
     */
	public int getDuration(){
		return this.duration;
	}
	/** 
     * setting the duration {@link Schedule#duration}
     * @param duration - duration 

     */
	public void setDuration(int newDuration) {
		this.duration = newDuration;
	}
//	---------------------------------------------------
	
//	------------------------INFO----------------------------
	public String getScheduleInfo() {
		String schedule = "";
		schedule += day + ": " + time + ":00-" + (time+duration) + ":00";
		return schedule;
	}
	public String toString() {
		return this.getScheduleInfo();
	}
	
	public final void printInfo() {
		System.out.println(this.toString());
	}
//	------------------------------------------------------
	/**
     * This is about creating the new schedule
     * @throws IOException
     * return schedule
     */
	public static Schedule createNewSchedule(BufferedReader br) throws IOException{
		System.out.println("Enter day: ");
		String day = br.readLine();
		System.out.println("Enter time: ");
		int time = Integer.parseInt(br.readLine());
		System.out.println("Enter duration: ");
		int duration = Integer.parseInt(br.readLine());
		
		Schedule schedule = new Schedule(day,time,duration);
		
		return schedule;

	}
}
