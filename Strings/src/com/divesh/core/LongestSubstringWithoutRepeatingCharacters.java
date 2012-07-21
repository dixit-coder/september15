package com.divesh.core;

import com.divesh.util.ArrayUtils;

public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * Given a string, find the length of the longest substring without
	 * repeating characters. For example, the longest substrings without
	 * repeating characters for “ABDEFGABEF” are “BDEFGA” and “DEFGAB”, with
	 * length 6. For “BBBB” the longest substring is “B”, with length 1. For
	 * “GEEKSFORGEEKS”, there are two longest substrings shown in the below
	 * diagrams, with length 7.
	 */

	private int maxLen;// = Integer.MIN_VALUE;

	public int getLongestsubStr(char[] str) {
		int tmp[] = new int[str.length];
		int[] hashmap = new int[256];
		for (int i = 0; i < 256; i++) {
			hashmap[i] = -1;
		}
		
		maxLen = 0;
		int start=0;
		for (int i = 0; i < str.length; i++) {
			if (hashmap[str[i]] == -1) {
				maxLen++;
			} else {
				if(start > hashmap[str[i]])
				{
					maxLen++;
				}
				else
				{
					maxLen = i - hashmap[str[i]];
					start = hashmap[str[i]] + 1;
				}
			}
			tmp[i] = maxLen;
			hashmap[str[i]] = i;

		}

		return ArrayUtils.getMaxElement(tmp);
	}
	
	public static void main(String args[])
	{   //String input = "GEEKSFORGEEKS";
		//String input = "ABCDECQWERTYU";
		String input = "AAAAAAAAAAAAA";
		LongestSubstringWithoutRepeatingCharacters substringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
		int output = substringWithoutRepeatingCharacters.getLongestsubStr(input.toCharArray());
		System.out.println("===>"+output);
	}
}
