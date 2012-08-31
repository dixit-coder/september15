package com.divesh.core;

import java.util.ArrayList;
import java.util.List;

public class InterLeavingStrings {
	public void printAllInterLeaving1(char str1[], char str2[], int m, int n,
			String str) {
		if (m == 0 && n == 0)
			System.out.println(str);
		if (m != 0) {
			str = str + str1[m];
			printAllInterLeaving1(str1, str2, m - 1, n, str);
		}
		if (n != 0) {
			str = str + str1[n];
			printAllInterLeaving1(str1, str2, m, n - 1, str);
		}

	}

	public List<String> interLeaving(String s, String t) {
		List<String> result = new ArrayList<String>();

		if (t.isEmpty())
			result.add(s);
		else if (s.isEmpty())
			result.add(t);
		else {
			for (int i = 0; i <=s.length(); i++) {
				char c = t.charAt(0);
				String left = s.substring(0, i);
				String right = s.substring(i);
				for (String u : interLeaving(right, t.substring(1))) {
					result.add(left + c + u);
				}
			}
		}
		return result;

	}

	public static void main(String args[])
  {
	  InterLeavingStrings iLeavingStrings  = new InterLeavingStrings();
      System.out.println(iLeavingStrings.interLeaving("CD", "AB"));
  }
}
