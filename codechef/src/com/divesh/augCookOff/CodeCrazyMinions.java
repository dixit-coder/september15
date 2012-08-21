package com.divesh.augCookOff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Coding in Sprout (a programming language) is very intuitive. Chef is giving
 * his minions a demonstration in Sprout and wants you to help him determine if
 * they are not too difficult for them.
 * 
 * A program in Sprout is written using three kinds of instructions.
 * 
 * Load Instruction: Load a value into buffer. Increment Instruction: Increment
 * the value in buffer. Print Instruction: Print the value from buffer.
 * 
 * The buffer stores a single integer between 0 and 25, both inclusive. If the
 * value in the buffer is x, the increment instruction makes the value (x+1), if
 * x < 25. At x = 25 the increment instruction makes the value 0.
 * 
 * Load Instruction can be used to load any value between 0 and 25 (inclusive)
 * into the buffer.
 * 
 * Print from the buffer prints a lowercase English character based on the value
 * in the buffer. Precisely, it prints the (x+1)th character in the alphabet.
 * Thus, for x = 0, 'a' is printed; x = 1, 'b' is printed and so on. For x = 25,
 * 'z' is printed.
 * 
 * To keep his programs clear, he uses the load instruction only once in the
 * beginning (before printing any character). Then he proceeds instruction after
 * instruction. A program is simple, if the number of instructions is not more
 * than ELEVEN times the length of the word that it prints. Given the word Chef
 * wants his program to print and assuming he will write the shortest code (i.e.
 * use the fewest instructions) to print it, will the program be simple? Input
 * 
 * The first Line contains a single number T, the number of test cases.
 * 
 * Each test case contains 1 word on a line by itself - the word that would be
 * printed by Chef's program. Output
 * 
 * Assuming Chef writes the shortest code (with minimum instructions) to print
 * the given word, output "YES" if this code is not more than ELEVEN times the
 * length of the word being printed; "NO" otherwise Constraints
 * 
 * 1 ≤ T ≤ 100 
 * 1 ≤ length of word ≤ 1000
 * 
 * Sample Input
 * 
 * 2 
 * helloworld 
 * mississippi
 * 
 * Sample Output
 * 
 * NO 
 * YES
 * 
 * Explanation
 * 
 * The optimal program length for mississippi is 112 instructions and that is
 * smaller than 121 (length of 'mississippi' * 11)
 */
public class CodeCrazyMinions {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		String s = br.readLine();
		int T = Integer.parseInt(s);

		char input[];
		int sum = 0, len;
		while (T > 0) {
			T--;
			input = br.readLine().toCharArray();
			sum = 2; // load instruction + print first letter;
			len = input.length;
			for (int i = 1; i < len; i++) {
				if (input[i] < input[i - 1]) {
					sum += (26 - input[i - 1] + input[i] + 1);
				} else {
					sum += (input[i] - input[i - 1] + 1);
				}
			}
			if (len * 11 > sum) {
				pw.println("YES");
			} else {
				pw.println("NO");
			}
			pw.println("sum=" + sum);
		}
		pw.flush();
	}
}
