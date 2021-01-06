package practice10;
import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.*;
public class Frogger extends GraphicsProgram {
	public void run() {
	im=new GImage("frog.jpg");
	im.scale(0.5);
	height=im.getHeight();
	add(im,getWidth()/2.0-im.getWidth()/2.0,getHeight()-height);
	addMouseListeners();
	
}
	

	
	public void mouseClicked(MouseEvent e) {
		if(e.getY()<im.getY()) {
			if(checkState(e)) {
			im.move(0, -height);}
			
		}else if (e.getY()>im.getY()+height) {
			if(checkState(e)) {
			im.move(0, height);
			}
		}
	}
	
	private boolean checkState(MouseEvent e) {
		if(e.getY()<im.getY()) {
		return(im.getY()-height>=0);
	} else if (e.getY()>im.getY()+height) {
		return(im.getY()+height*2.0<=getHeight());
	} else {
		return true;
	}
}
	
	private double height;
	private GImage im;
	

}