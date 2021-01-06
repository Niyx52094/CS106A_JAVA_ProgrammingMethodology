/*
 * File: BlankClass.java
 * ---------------------
 * This class is a blank one that you can change at will. Remember, if you change
 * the class name, you'll need to change the filename so that it matches.
 * Then you can extend GraphicsProgram, ConsoleProgram, or DialogProgram as you like.
 */

import java.util.*;

import acm.program.*;

public class BlankClass extends ConsoleProgram {
	public void run() {
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		HashMap<String,Integer> map2=new HashMap<String,Integer>();
		Map<String,Integer> mutual=new HashMap<String,Integer>();
		map.put("Jenny",8675309);
		map.put("Julia",2124320);
		map.put("Chris",4602121);
		map.put("Annie",4444444);
		map.put("Brahm",8080543);
		
		
		map2.put("Logan",6202121);
		map2.put("Jeff",8888888);
		map2.put("Brahm",8080543);
		map2.put("Chris",4602121);
		map2.put("Annie",4444444);
		map2.put("Jenny",2128765);
		mutual=mutualFriend(map,map2);
		println(mutual);
}
	
	private HashMap<String,Integer> mutualFriend(HashMap<String,Integer> m1,HashMap<String,Integer> m2){
		HashMap<String,Integer> mutual=new HashMap<String,Integer>();
		for(String k:m1.keySet()) {
			int i=m1.get(k);
			if(m2.containsKey(k)&&i==m2.get(k)) {
				mutual.put(k, i);
				
			}
			
		}
		return mutual;
		
	}
	
}

