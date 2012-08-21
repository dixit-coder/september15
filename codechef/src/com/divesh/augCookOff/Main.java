package com.divesh.augCookOff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;



public class Main {
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
			sum = 2;  // load instruction + print first letter; 
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
			pw.println("sum="+sum);
		}
		pw.flush();
	}
}