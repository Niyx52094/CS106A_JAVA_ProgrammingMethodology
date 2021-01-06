package practice10;
import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
public class OType extends GCompound {
	public OType(double Width, double Height) {
		GRect re=new GRect(Width,Height);
		re.setFilled(false);
		add(re,0,0);
		GOval ov=new GOval(Width,Height);
		ov.setFilled(false);
		add(ov,0,0);
	}
}
