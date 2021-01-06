/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	private static final double RADICAL_OUTERCIRCLE=72;
	private static final double RADICAL_MIDCIRCLE=46.8;
	private static final double RADICAL_INNERCIRCLE=21.6;
	
	public void run() {
		setCircle(RADICAL_OUTERCIRCLE,Color.RED);
		setCircle(RADICAL_MIDCIRCLE,Color.WHITE);
		setCircle(RADICAL_INNERCIRCLE,Color.RED);
	}
	private void setCircle(double a,Color b) {
		double x=getWidth()/2-a;
		double y=getHeight()/2-a;
		GOval cir=new GOval(2*a,2*a);
		cir.setFilled(true);
		cir.setColor(b);
		add(cir,x,y);
	}
}
