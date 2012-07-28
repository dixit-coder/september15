package com.divesh.juneCookOff;

import java.io.*;
import java.util.*;

public class SampleCodeChefTemplet {
	public static void main(String args[]) throws Exception {
		// to read the input 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// to write the output instead of sysout()
		PrintWriter pw = new PrintWriter(System.out);
		// to read the  boundry condition and limits of input
		StringTokenizer st;
		String s = br.readLine();
		st = new StringTokenizer(s);
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int count = 0;
		boolean b[] = new boolean[n];
		while (k > 0) {
			k--;
			String str = br.readLine();
			// logic for processing str
			// count is the result
			pw.println(count);
		}
		pw.flush();
	}
}