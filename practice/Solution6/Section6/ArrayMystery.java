/* File: ArrayMystery.java
 * ---------------------
 * A mystery program that executes the mystery
 * method with sample inputs and prints out the
 * arrays after mystery is called.
 */
import acm.program.*;
import java.util.*;

public class ArrayMystery extends ConsoleProgram {
	public void run() {
		int[] arr1 = {10, 8, 9, 5, 5};
		mystery(arr1);
		println("Array 1: " + Arrays.toString(arr1));

		int[] arr2 = {12, 11, 10, 10, 8, 7};
		mystery(arr2);
		println("Array 2: " + Arrays.toString(arr2));
	}

	private void mystery(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) { 
			if (nums[i] > nums[i + 1]) {
				nums[i + 1]++;
			}    
		}
	} 
}
