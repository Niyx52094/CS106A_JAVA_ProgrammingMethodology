/* File: CountNames.java
 * ---------------------
 * This program shows an example of using a HashMap.  It reads a 
 * list of names from the user and list out how many times each name 
 * appeared in the list.
 */
import acm.program.*;
import java.util.*;

public class CountNames extends ConsoleProgram {
	public void run() {
		HashMap<String,Integer> nameMap = new HashMap<String,Integer>();
		readNames(nameMap);
		printMap(nameMap);
	}

	/*
	 * Reads a list of names from the user, storing names and how many
	 * times each appeared in the map that is passed in as a parameter.
	 */
	private void readNames(HashMap<String,Integer> map) {
		while (true) {
			String name = readLine("Enter name: ");
			if (name.equals("")) {
				break;
			}

			/* See if that name previously appeared in the map.  Update
			 * count if it did, or create a new count if it didn't. 
			 */
			if (map.containsKey(name)) {
				// auto-unboxing: gets an int instead of Integer
				int oldCount = map.get(name);
				// auto-boxing: convert int to Integer automatically
				map.put(name, oldCount + 1);
			} else {
				// auto-boxing: convert int to Integer automatically
				map.put(name, 1);
			}
		}
	}

	/*
	 * Prints out list of entries (and associated counts) from the map
	 * that is passed in as a parameter.
	 */
	private void printMap(HashMap<String,Integer> map) {
		for (String key : map.keySet()) {
			int count = map.get(key);  // auto-unboxing
			println("Entry [" + key + "] has count " + count);
		}
	}
}  
