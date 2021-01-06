/* File: SwitchPairs.java
 * ------------------------
 * This is a program to test the switchPairs method that
 * swaps pairs of elements in a provided string array and
 * returns the new array.
 */
import acm.program.*;
import java.util.*;

public class SwitchPairs extends ConsoleProgram {
	public void run() {
		String[] arr1 = {"four", "score", "and", "seven", "years", "ago"};
		String[] arr2 = {"one", "two", "three", "four", "five"};
		println(Arrays.toString(arr1) + " -> " + Arrays.toString(switchPairs(arr1)));
		println(Arrays.toString(arr2) + " -> " + Arrays.toString(switchPairs(arr2)));
	}

	/* This is the required method that returns a new array
	 * with the same elements as the provided array, but with each pair
	 * of elements flipped.
	 */
	private String[] switchPairs(String[] arr) {
		String[] newArr = new String[arr.length];
		for (int i = 0; i < newArr.length - 1; i += 2) {
			newArr[i+1] = arr[i];
			newArr[i] = arr[i+1];
		}

		// For an odd number of elements, the last one is unchanged
		if (newArr.length % 2 == 1) {
			newArr[newArr.length - 1] = arr[arr.length - 1];
		}

		return newArr;
	}
}
