/* File: MutualFriends.java
 * ------------------------
 * An example program that tests the mutualFriends method for finding
 * friends in common between two maps/phonebooks.
 */ 
import acm.program.*;
import java.util.*;

public class MutualFriends extends ConsoleProgram {
	public void run() {
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("Jenny", 8675309);
		map1.put("Nick", 2124320);
		map1.put("Mehran", 4602121);
		map1.put("Alyssa", 4444444);
		map1.put("Stefanie", 8080543);

		HashMap<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("Logan", 6202121);
		map2.put("Jeff", 8888888);
		map2.put("Nick", 2124320);
		map2.put("Mehran", 4602121);
		map2.put("Alyssa", 4444444);
		map2.put("Jenny", 2128765);

		HashMap<String, Integer> mutual = mutualFriends(map1, map2);
		println(mutual);
	}

	/* Returns a new map containing the phone book entries in common
	 * between both provided maps.
	 */
	private HashMap<String, Integer> mutualFriends(
			HashMap<String, Integer> phonebook1, 
			HashMap<String, Integer> phonebook2) {

		HashMap<String, Integer> result = 
				new HashMap<String, Integer>();

		for (String name : phonebook1.keySet()) {
			int phoneNum = phonebook1.get(name);
			if (phonebook2.containsKey(name) && 
					phoneNum == phonebook2.get(name)) {

				result.put(name, phoneNum);
			}
		}
		return result;
	}
}
