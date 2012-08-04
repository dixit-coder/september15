package com.divesh.core;

public class AllPermutaionOfString {

	void permutaion(String prefix, String str) {
		int n = str.length();
		if (n == 0)
			System.out.println(prefix);
		for (int i = 0; i < n; i++) {
			permutaion(prefix + str.charAt(i),
					str.substring(0, i) + str.substring(i + 1));

		}

	}
	public static void main(String args[])
	{
		AllPermutaionOfString permutaionOfString = new AllPermutaionOfString();
		String str = "123";
		permutaionOfString.permutaion("", str);
	}
}
