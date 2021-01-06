package practice10;
import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
public class XType extends GCompound{
	public XType(double Width, double Height) {
		GRect re=new GRect(Width,Height);
		re.setFilled(false);
		add(re,0,0);
		GLine li1=new GLine(0,0,Width,Height);
		add(li1,0,0);
		GLine li2=new GLine(0,Height,Width,0);
		add(li2,0,Height);
		}
	}
