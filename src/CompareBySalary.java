
import java.util.Comparator;
/** 
 * Class CompareBySalary  that compares to employees by their salaries
 * @version 2.1
*/
public class CompareBySalary implements Comparator<Employee>{
	public int compare(Employee t, Employee t1) {
		if(t.getSalary() > t1.getSalary())return 1;
		else if(t.getSalary() < t1.getSalary()) return -1;
		return 0;
	}
	
}
