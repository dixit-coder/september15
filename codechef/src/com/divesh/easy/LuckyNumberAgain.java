package com.divesh.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * A lucky number N is defined as a number which has only two factors, both of
 * them prime and the absolute difference between the two factors is not more
 * than 50. Given two integers, a and b, find the total lucky numbers in the
 * range a to b (inclusive).
 */
public class LuckyNumberAgain {
	public static Map<Integer, ArrayList<Integer>> factorsMap = new HashMap<Integer, ArrayList<Integer>>();

	private static void getAllFactorsMap() {
		for (int i = 1; i <= 100000; i++) {

			ArrayList<Integer> factors = new ArrayList<Integer>();
			int max = i/2; // round down
			for (int factor = 2; factor <= max; ++factor) {
				if (i % factor == 0) {
					factors.add(factor);
				}
			}
			if(factors.size()==0)
				factors.add(i);
			factorsMap.put(i, factors);
		}
		for (int i = 1; i <= 10; i++) {
            if(factorsMap.get(i).size() == 2)
            {
            	if(factorsMap.get(factorsMap.get(i).get(0)).size()==1 && factorsMap.get(factorsMap.get(i).get(1)).size()==1)
            	{
            		System.out.println(i);
            	}
            }
			//System.out.println(i+"::" +factorsMap.get(i));
		}

	}

	public static void main(String args[]) throws Exception {
		
		getAllFactorsMap();
		/*// to read the input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// to write the output instead of sysout()
		PrintWriter pw = new PrintWriter(System.out);
		// to read the boundry condition and limits of input
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
		pw.flush();*/
	}
}
