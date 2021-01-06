/*
 * File: CS106ATiles.java
 * Name: 
 * Section Leader: 
 * ----------------------
 * This file is the starter file for the CS106ATiles problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class CS106ATiles extends GraphicsProgram {
	
	/** Amount of space (in pixels) between tiles */
	private static final int TILE_SPACE = 20;
	/**The width of each label*/
	private static final double TILE_WIDTH=150;
	private static final double TILE_HEIGHT=60;
	private static final int NUM_RECT_EACH_LINE=2;
	public void run() {
		for(int i=0;i<NUM_RECT_EACH_LINE;i++) {
			for(int j=0;j<NUM_RECT_EACH_LINE;j++) {
				GRect re=new GRect(TILE_WIDTH,TILE_HEIGHT);
				setRect(i,j,re);
				GLabel la=new GLabel("CS106A");
				setLabel(i,j,la);
		}
		}
	}
	
	private void setRect(int c,int d,GRect la) {
		double x=(getWidth()-TILE_WIDTH)/2-(TILE_WIDTH+TILE_SPACE)/2+d*(TILE_WIDTH+TILE_SPACE);
		double y=(getHeight()-TILE_HEIGHT)/2-(TILE_HEIGHT+TILE_SPACE)/2+c*(TILE_HEIGHT+TILE_SPACE);
		la.setFilled(false);
		add(la,x,y);
	}
	
	private void setLabel(int c, int d,GLabel la) {
		double x=(getWidth()-TILE_WIDTH)/2-(TILE_WIDTH+TILE_SPACE)/2+d*(TILE_WIDTH+TILE_SPACE)+TILE_WIDTH/2-la.getWidth()/2;
		double y=(getHeight()-TILE_HEIGHT)/2-(TILE_HEIGHT+TILE_SPACE)/2+c*(TILE_HEIGHT+TILE_SPACE)+TILE_HEIGHT/2+la.getAscent()/2;
		add(la,x,y);
	}
	
}

