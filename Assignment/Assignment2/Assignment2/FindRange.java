/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	private static final int ZERO=0;
	public void run() {
		println("This program finds the largest and smallest numbers");
		int digit=readInt("?");
		int s=digit;
		int b=digit;
		if(digit==ZERO) {
			println("Please input another number in the first time"
					+ " except the sentinel number!");
		} else {
			while(true) {
				if(digit==ZERO) {
					println("smallest:"+s);
					println("largest:"+b);
					break;
				}
				b=findLargest(b,digit);
				s=findSmallest(s,digit);
				digit=readInt("?");//不用重新定义（即前面不用加int），只需要重新赋值即可！！
			}
		}
	
	}
	
	private int findLargest(int a,int b) {
		if(a>=b) {
			return a;
		}else {
			return b;
		}
	}
	
	private int findSmallest(int a,int b) {
		if(a<=b) {
			return a;
		} else {
			return b;
		}
		
	}
}

