/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	public void run() {
		if(frontIsBlocked()) {
			putBeeper();
		}
		while(frontIsClear()) {
			putBeeperEveryTwoSteps();
		}
		
		checkPreviousBeeper();
		while(leftIsClear()) {
			goToUpstairs();
			checkPreviousBeeper();
			checkPresentStateAndBeeper();
			if(frontIsClear()) {
				while(frontIsClear()) {
					putBeeperEveryTwoSteps();
				}
				checkPreviousBeeper();
			}

			if(rightIsBlocked()) {
				turnAround();
			} 
		}	

}
/*put a Beeper every two steps in one line
 * preconditon:None
 * postcondition:have a beeper every two steps in a line
 * */
	public void putBeeperEveryTwoSteps() {
		if(noBeepersPresent()) {
			putBeeper();
		if(frontIsClear()) {
			move();
			if(frontIsClear()) {
				move();
			}
		}
		} else {
			if(frontIsClear()) {
				move();
				if(frontIsClear()) {
					move();
				}
			}
			putBeeper();
		}	
	}
	/*
	 * check the Final Beeper£¬to check if a beeper should be
	 * put in the end of each line
	 * preconditson:None
	 * postcondition:have one or zero beeper in the end of line
	 */
	public void checkPreviousBeeper() {
		
			moveBackWard();
		if(beepersPresent()) {
			moveBackWard();
		} else {
			moveBackWard();
			putBeeper();
		}
	}
	/*
	 * to move back one step if back is noe blocked
	 * 
	 * precondition:
	 */
	public void moveBackWard() {
		turnAround();
		if(frontIsClear()) {
		move();
		}
	}
	
	public void goToUpstairs() {
		if(facingEast()) {
			turnLeft();
		} else if(facingWest()) {
			turnRight();
		}
		move();
	}
	
	public void checkPresentStateAndBeeper() {
		turnLeft();
		if(frontIsBlocked()) {
			turnAround();
		}
		
		if(beepersPresent()) {
			if(frontIsClear()) {
				move();
				if(frontIsClear()) {
					move();
				}
			}
		}else {
			if(frontIsClear()) {
				move();
				}
		}
	
}
}
