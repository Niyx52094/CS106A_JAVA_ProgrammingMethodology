import java.util.*;
import acm.program.*;

public class Section7_reverseHashMap extends ConsoleProgram {
	public void run() {
	animalMap.put("Chris","Mantis Shrimp");
	animalMap.put("Brahm","Mantis Shrimp");
	animalMap.put("Elena","Dog");
	animalMap.put("Laikh","Parrot");
	animalMap.put("Laura","Cat");
	reverseHashMap(animalMap);
	}
	
	private void reverseHashMap(HashMap<String, String> Map){
		HashMap<String,ArrayList<String>> result=new HashMap<String,ArrayList<String>>();
		for(String person:Map.keySet()) {
			String animal=Map.get(person);
			if(!result.containsKey(animal)) {
				result.put(animal,new ArrayList<String>());	
			//	String name=result.get(Map.get(k));//”√ArrayList£°£°£°
			//	name=name+","+k;
			//	result.put(Map.get(k), name);
			}
			result.get(animal).add(person);
		}
		for(String pet:result.keySet()) {
			String line=pet+": "+result.get(pet).get(0);
			for(int i=1;i<result.get(pet).size();i++) {
				line=line+","+result.get(pet).get(i);
			}
			println(line);
		}

	}
	
	private HashMap<String,String> animalMap=new HashMap<String,String>();
}
