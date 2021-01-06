package practice10;
import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.*;
public class GoogleyEyes extends GraphicsProgram{
	private static final int EYE_X=150;
	private static final int EYE_Y=65;
	private static final int SIZE=100;
	private static final int PUPIL=20;
	public void init() {
		Color back=new Color(80,230,235);
		setSize(500,700);
		setBackground(back);
		eye1=giveMeAnEye(EYE_X,EYE_Y);
		pupil1=giveMeAPupil(EYE_X,EYE_Y);
		eye2=giveMeAnEye(EYE_X+SIZE,EYE_Y);
		pupil2=giveMeAPupil(EYE_X+SIZE,EYE_Y);
		addMouseListeners();

	}
	private GOval giveMeAnEye(int x, int y) {
		GOval eye=new GOval(SIZE,SIZE);
		eye.setFilled(true);
		eye.setFillColor(Color.WHITE);
		add(eye,x,y);
		return eye;
	}
	
	private GOval giveMeAPupil(int x, int y) {
	GOval pupil=new GOval(PUPIL,PUPIL);
	pupil.setFilled(true);
	add(pupil,x+SIZE/2.0-PUPIL/2.0,y);
	return(pupil);
	
	}
	
	public void mouseMoved(MouseEvent e) {
		if(e.getY()<=EYE_Y) {
			pupil1.move(0,EYE_Y-pupil1.getY());
			pupil2.move(0,EYE_Y-pupil2.getY());
		} else if(e.getY()>EYE_Y&&e.getY()<EYE_Y+SIZE) {
			pupil1.move(0,EYE_Y+SIZE/2.0-PUPIL/2.0-pupil1.getY());
			pupil2.move(0,EYE_Y+SIZE/2.0-PUPIL/2.0-pupil2.getY());
		}else {
			pupil1.move(0,EYE_Y+SIZE-PUPIL-pupil1.getY());
			pupil2.move(0,EYE_Y+SIZE-PUPIL-pupil2.getY());
		}
		pause(50);
	}
	
	public void mouseClicked(MouseEvent e) {
		po=new GPoint(e.getPoint());
		obj=getElementAt(po);
		if(obj==eye1) {
			toggle(pupil1);
		} else if(obj==eye2) {
			toggle(pupil2);
		}
	}
	
	private void toggle(GOval pup) {
		if(pup.getFillColor()==Color.RED) {
			pup.setFillColor(Color.BLACK);
		}else if(pup.getFillColor()==Color.BLACK) {
			pup.setFillColor(Color.RED);
		}
	}
	private GOval pupil1;
	private GOval pupil2;
	private GOval invisPupil;
	private GOval eye1;
	private GOval eye2;
	private GObject obj;
	private GPoint po;


}
