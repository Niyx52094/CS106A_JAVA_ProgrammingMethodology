package practice10;
import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
public class ti_Tio_TOe extends GraphicsProgram{
	private static final int ROW=3;
	private static final int COLUMN=3;
	public void init() {
		setSize(600.0,600.0);
		addRectangular();
		obj=null;
		addMouseListeners();
		println(getHeight());
		
	}
	
	private void addRectangular() {
		for(int i=0;i<ROW;i++) {
			for(int j=0;j<COLUMN;j++) {
				GRect re=new GRect(200,200);	
				int x=200*i;
				int y=j*200;
				re.setFilled(false);
				add(re,x,y);
				println(re.getX());
				println(re.getY());
				println(re.getHeight());
			}

		}
	}
	
	
	public void mouseClicked(MouseEvent e) {
		po=new GPoint(e.getPoint());
		obj=getElementAt(po);
		chooseType();
		addType();
	}
	
	private void chooseType() {
		if(obj!=xType&&obj!=oType) {	
			OB=changeXType();
		} else if (obj==xType) {
			OB=changeOType();
		}else if(obj==oType) {
			OB=changeXType();
		}
	}
	
	private void addType() {
		add(OB,obj.getX(),obj.getY());
		remove(obj);
		
	}
	
	private GObject changeXType() {
		xType=new XType(getWidth()/ROW,getHeight()/COLUMN);
		return xType;
	}
	
	private GObject changeOType() {
		oType=new OType(getWidth()/ROW,getHeight()/COLUMN);
		return oType;
	}

	private GPoint po;
	private GObject obj;
	private GObject oType;
	private GObject xType;
	private GObject OB;
	
}
