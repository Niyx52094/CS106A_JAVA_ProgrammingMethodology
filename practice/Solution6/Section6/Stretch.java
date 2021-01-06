/* File: Stretch.java
 * ------------------------
 * A sample program that uses the stretch method
 * to display a normal image and the same image
 * stretched 2x and 3x.
 */
import acm.program.*;
import acm.graphics.*;

public class Stretch extends GraphicsProgram {
	public void run() {
		GImage image = new GImage("karel.png");
		GImage stretched2x = stretch(image, 2);
		GImage stretched3x = stretch(image, 3);
		add(image);
		add(stretched2x, 0, image.getY() + image.getHeight());
		add(stretched3x, 0, stretched2x.getY() + stretched2x.getHeight());
	}

	/* A method that takes an image and returns a new image
	 * that is stretched horizontally by the given factor.
	 */
	private GImage stretch(GImage image, int factor) {
		int[][] pixels = image.getPixelArray();
		int[][] result = new int[pixels.length][pixels[0].length * factor];
		for (int row = 0; row < result.length; row++) {
			for (int col = 0; col < result[0].length; col++) {
				result[row][col] = pixels[row][col / factor]; 
			}
		}
		return new GImage(result); 
	}
}
