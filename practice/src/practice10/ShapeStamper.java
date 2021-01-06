package practice10;
import java.awt.*;
import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;

public class ShapeStamper extends GraphicsProgram{
	public void init() {
		setSize(400,300);
		fillrect=new GRect(50,50);
		fillrect.setFilled(true);
		add(fillrect);
		filloval=new GOval(50,50);
		filloval.setFilled(true);
		add(filloval,getWidth()-filloval.getWidth(),0);
		obj=null;
		obj2=null;
		obj3=null;
		addMouseListeners();
	}
	public void mouseClicked(MouseEvent e) {
		po=new GPoint(e.getPoint());
		switchButton();
		addOrMoveShape(e);
		
	}
	
	private GObject switchToOvalStamping() {
		GOval cir=new GOval(50,50);
		cir.setFilled(false);
		return cir;
	}
	
	private GObject switchToRectStamping() {
		GRect rec=new GRect(50,50);
		rec.setFilled(false);
		return rec;
	}
	
	
	private void switchButton() {
	if(obj==null) {
		obj=getElementAt(po);
		OB=switchToRectStamping();
	} else if(obj==filloval ) {
			obj2=getElementAt(po);
			if(obj2==null) {
				OB=switchToOvalStamping();
			}else if(obj2==fillrect) {
				obj=obj2;
				OB=switchToRectStamping();
			}
	} else if (obj==fillrect) {
		obj3=getElementAt(po);
		if(obj3==null) {
			OB=switchToRectStamping();
		}else if(obj3==filloval) {
			obj=obj3;
			OB=switchToOvalStamping();
		}
	}
	
}
	
	private void addOrMoveShape(MouseEvent e) {
		if(getElementAt(po)!=filloval&&getElementAt(po)!=fillrect&&getElementAt(po)==null) {
			double x=e.getX()-OB.getWidth()/2.0;
			double y=e.getY()-OB.getHeight()/2.0;
			add(OB,x,y);
			} else if(getElementAt(po)!=filloval&&getElementAt(po)!=fillrect
					&&getElementAt(po)!=null) {
				remove(getElementAt(po));
			}
	}
	
	private GObject obj;
	private GObject OB;
	private GObject obj2;
	private GObject obj3;
	private GPoint po;
	private GRect fillrect;
	private GOval filloval;
}
