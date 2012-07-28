package com.divesh.juneCookOff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
	public static void main(String args[]) throws Exception {
		// to read the input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// to write the output instead of sysout()
		PrintWriter pw = new PrintWriter(System.out);
		// to read the boundry condition and limits of input

		int T = Integer.parseInt(br.readLine());
		int number, answer, rem, count;

		while (T > 0) {
			T--;
			answer = 0;
			rem = 0;
			count = 0;
			number = Integer.parseInt(br.readLine());
			answer += (number / 2048);
			rem = number % 2048;
			while (rem > 0) {
				if ((rem & 1) > 0) {
					count++;
				}
				rem >>= 1;
			}

			pw.println(answer + count);
		}
		pw.flush();
	}
}
