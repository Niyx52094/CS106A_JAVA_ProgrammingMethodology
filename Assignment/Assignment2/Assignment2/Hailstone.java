/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int num= readInt("Enter a number:");
		int initial=num;
		while(true) {
		if(isNumAEven(num)) {
			
			println(num+" is even,so I take half:"+num/2);
			num=num/2;
			if(checkNum(num)) {
				println("The process took "+initial+"to reach 1");
				break;}
		} else {
			println(num+" is odd,so I make 3n+1:"+(num*3+1));
			num=num*3+1;
			if(checkNum(num)) {
				println("The process took "+initial+" to reach 1");
				break;}
		}
	}
}
	
	private boolean isNumAEven(int a) {
		return(a%2==0);
	}
	private boolean checkNum(int a) {
		return(a==1);
	}
}

