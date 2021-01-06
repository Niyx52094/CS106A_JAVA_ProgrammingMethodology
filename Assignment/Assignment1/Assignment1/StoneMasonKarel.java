/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	public void run() {
		
		while(frontIsClear()) {	
			putStone();
			pass4Street();
		}
		putStone();
	}

	/*let Karel use stones to restructure the columns and go back*/
	private void putStone() {
		turnLeft();
		while(frontIsClear()) {
		if(beepersPresent()) {
			move();
		} else {
			putBeeper();
			move();
		}
			
		
	}
		if(beepersPresent()) {
			turnAround();
		} else {
			putBeeper();
			turnAround();
		}
		while(frontIsClear()) {
			move();
		}
		turnLeft();
		
}
	/*make sure Karel can be marked by the right wall*/
	private void pass4Street() {
		for(int i =1;i<5;i++) {
			if(frontIsClear()) {
			move();
		}
		}
		
	}
}