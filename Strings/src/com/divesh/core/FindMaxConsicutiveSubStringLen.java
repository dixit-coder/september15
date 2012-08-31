package com.divesh.core;

public class FindMaxConsicutiveSubStringLen {

	public static boolean find(String s) {
		int ptr1;
		int ptr2;
		int i = 1;
		int count;
		if (s.length() < 2)
			return false;
		while (i <= s.length() / 2) {
			ptr1 = 0;
			ptr2 = i;
			count = 0;
			while (ptr2 < s.length()) {
				if (s.charAt(ptr1) == s.charAt(ptr2))
					count++;
				else
					count = 0;
				if (count == i) {
					return true;
				}
				ptr1++;
				ptr2++;
			}
			i++;
		}
		return false;
	}

	public static void main(String[] args) {
		boolean found = find("zxcvbnmhjyuiutyrueyryettwwwqqqwedsxabcabc");
		System.out.println("Found Cons SubStrings:" + found);
	}
}
