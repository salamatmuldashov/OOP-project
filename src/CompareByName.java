
import java.util.Comparator;
/** 
 * Class CompareByName that will compare the users by their names
 * @version 2.1
*/
public class CompareByName implements Comparator<User> {
	public int compare(User s, User s1) {
		return s.getName().compareTo(s1.getName());
	}
}
