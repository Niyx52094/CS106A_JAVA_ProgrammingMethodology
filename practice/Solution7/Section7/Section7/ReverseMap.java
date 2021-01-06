import acm.program.*;
import java.util.*;

public class ReverseMap extends ConsoleProgram {


	public void run() {
		HashMap<String, String> animalMap = new HashMap<String, String>();
		animalMap.put("Chris", "Mantis Shrimp");
		animalMap.put("Brahm", "Mantis Shrimp");
		animalMap.put("Elena", "Dog");
		animalMap.put("Laikh", "Parrot");
		animalMap.put("Laura", "Cat");
		reverseHashMap(animalMap);
	}

	private void reverseHashMap(HashMap<String, String> animalMap) {
		HashMap<String, ArrayList<String>> reversedMap =
				new HashMap<String, ArrayList<String>>();
		for (String person: animalMap.keySet()) {
			String animal = animalMap.get(person);
			if (!reversedMap.containsKey(animal)) {
				reversedMap.put(animal, new ArrayList<String>());
			}
			reversedMap.get(animal).add(person);
		}


		for (String pet: reversedMap.keySet()) {
			ArrayList<String> people = reversedMap.get(pet);
			String line = pet + " : " + people.get(0);
			for (int i = 1; i < people.size(); i++) {
				line += ", " + people.get(i);	
			}
			println(line);

		}

	}
}

