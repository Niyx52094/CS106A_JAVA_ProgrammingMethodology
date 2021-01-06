/* File: FlipVertical.java
 * ---------------------
 * A sample program that uses the flipVertical method
 * to display a normal image and the same image
 * flipped vertically.
 */
import acm.program.*;
import acm.graphics.*;

public class FlipVertical extends GraphicsProgram {
	public void run() {
		GImage image = new GImage("milkmaid.png");
		GImage flipped = flipVertical(image);
		add(image);
		add(flipped, image.getWidth(), 0);
	}

	/* A method that takes an image and returns a new image
	 * that is the original image flipped vertically.
	 */
	private GImage flipVertical(GImage image) {
		int[][] pixels = image.getPixelArray(); 
		int width = pixels[0].length;
		int height = pixels.length;
		for (int col = 0; col < width; col++) {
			for (int p1 = 0; p1 < height / 2; p1++) {
				int p2 = height - p1 - 1;
				int temp = pixels[p1][col]; 
				pixels[p1][col] = pixels[p2][col]; 
				pixels[p2][col] = temp;
			} 
		}
		return new GImage(pixels);
	}
}
