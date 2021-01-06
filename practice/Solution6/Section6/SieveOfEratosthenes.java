/* File: SieveOfEratosthenes.java
 * ------------------------
 * This program prints out prime numbers in the range
 * up to and including UPPER_LIMIT.
 */
import acm.program.*;

public class SieveOfEratosthenes extends ConsoleProgram {
	private static final int UPPER_LIMIT = 1000;

	public void run() {
		// resolved[i] represents the number i + 2;
		boolean[] resolved = new boolean[UPPER_LIMIT - 1];
		for (int i = 0; i < resolved.length; i++) {
			resolved[i] = false;
		}
		for (int n = 0; n < resolved.length; n++) {
			if (!resolved[n]) {
				int number = n + 2;
				println(number);
				// Cross off all the multiples of n
				for (int k = n; k < resolved.length; k += number) {
					resolved[k] = true;
				}
			}
		}
	}
}
