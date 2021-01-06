/* File: MatrixMystery.java
 * ---------------------
 * A mystery program that executes the mystery
 * method with sample input and prints out the
 * arrays after mystery2D is called.
 */
import acm.program.*;
import java.util.*;

public class MatrixMystery extends ConsoleProgram {
	public void run() {
		int[][] matrix = {
				{3, 4, 5, 6},
				{4, 5, 6, 7},
				{5, 6, 7, 8}, 
		};

		mystery2D(matrix);
		println(Arrays.deepToString(matrix));
	}

	private void mystery2D(int[][] numbers) {
		for (int r = 0; r < numbers.length; r++) { 
			for (int c = 0; c < numbers[0].length - 1; c++) { 
				if (numbers[r][c + 1] > numbers[r][c]) { 
					numbers[r][c] = numbers[r][c + 1]; 
				}
			}
		}
	}
}
