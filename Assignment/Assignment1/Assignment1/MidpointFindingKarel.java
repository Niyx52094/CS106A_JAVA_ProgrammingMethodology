/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {
	public void run() {
	putBeeper();
	while(frontIsClear()) {
		move();
	}
	putBeeper();
	turnAround();
	if(frontIsClear()) {
	move();
	}
	while(noBeepersPresent()) {
		keepMovingIfNoBeeper();
		moveBackTwoSteps();
		if(beepersPresent()) {
			moveBackWard();
			while(frontIsClear()) {
				move();
			}
			turnAround();
			reverseBeepers();
			turnAround();
			goToMidPoint();
		} else {
			moveBackWard();
			putBeeper();
			moveBackWard();
		}
	}
	pickAllBeepers();
	
}
	public void moveBackWard() {
		turnAround();
		move();
	}
	public void keepMovingIfNoBeeper() {
		while(noBeepersPresent()) {
			move();
		}
	}
	public void moveBackTwoSteps() {
		moveBackWard();
		move();
	}

	public void pickAllBeepers() {
		while(beepersPresent()) {
			pickBeeper();
		}
	}
	public void reverseBeepers() {
		while(frontIsClear()) {
			if(beepersPresent()) {
				pickBeeper();
				move();
			} else {
				putBeeper();
				move();
			}	
		}
		pickBeeper();
	}
	public void goToMidPoint() {
		while(noBeepersPresent()) {
			move();
		}
	}

}

