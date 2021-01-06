package practice10;
import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;
import java.awt.*;
public class PicturePanel extends GraphicsProgram{
	private static final int NUMBER_BLOCK=16;
	private static final double NUMBER_HORIZONTAL=4;
	public void run() {
		im=new GImage("frog.jpg");
		setSize(im.getWidth(),im.getHeight());
		add(im);
		addShadow();
		addMouseListeners();
	}
	
	private void addShadow() {
		for(int i=0;i<NUMBER_BLOCK/NUMBER_HORIZONTAL;i++) {
			for(int j=0;j<NUMBER_HORIZONTAL;j++) {
				GRect block=new GRect(im.getWidth()/NUMBER_HORIZONTAL,
						im.getHeight()/(NUMBER_BLOCK/NUMBER_HORIZONTAL));
				double x=j*(im.getWidth()/NUMBER_HORIZONTAL);
				double y=i*(im.getHeight()/(NUMBER_BLOCK/NUMBER_HORIZONTAL));
				block.setFilled(true);
				block.setColor(Color.WHITE);
				block.setFillColor(Color.GRAY);
				add(block,x,y);
			}
			
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		po=new GPoint(e.getPoint());
		obj=getElementAt(po);
		remove(obj);
	}
	
	private GImage im;
	private GRect obj;
	private GPoint po;
	
}
