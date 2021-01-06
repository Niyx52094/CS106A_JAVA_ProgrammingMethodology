import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ss {
	/* Instance variable for the square to be tracked */
	private GRect square = null;

	public void run() { 
		square = makeSquare();
		addSquareToCenter();
		addMouseListeners();
	}

}
