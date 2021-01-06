/*
 * File: DrawCenteredRect.java
 * Name: 
 * Section Leader: 
 * ----------------------
 * This file is the starter file for the DrawCenteredRect problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class DrawCenteredRect extends GraphicsProgram {
	
	/** Size of the centered rect */
	private static final int WIDTH = 350;
	private static final int HEIGHT = 270;

	public void run() {
		//setSize(2*WIDTH,2*HEIGHT);
		GRect rect= new GRect(WIDTH,HEIGHT);
		rect.setFilled(true);
		rect.setColor(Color.BLUE);
		add(rect,(getWidth()-WIDTH)/2,(getHeight()-HEIGHT)/2);
		
	}
}

