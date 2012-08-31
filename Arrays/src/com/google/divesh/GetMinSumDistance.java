package com.google.divesh;

import java.util.HashMap;
import java.util.Map;

public class GetMinSumDistance {

	
	public Map<Character, Integer> charMap = new HashMap<Character, Integer>();
	char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
			'y', 'z' };

	public GetMinSumDistance() {
		for (int i = 0; i < 26; i++) {
			charMap.put(charArray[i], i );
		}
		System.out.println(charMap);
	}

	public int getMinDistaceSum(int w, String str, int i, int x, int y) {
		if (i == str.length())
			return 0;
		else {
			char $ = str.charAt(i);
			int X = getXCordinate($, w);
			int Y = getYCordinate($, w);
			int dist = Math.abs(x - X) + Math.abs(y - Y);
			return dist + getMinDistaceSum(w, str, ++i, X, Y);

		}

	}

	private int getYCordinate(char $, int w) {
		return charMap.get($) / w ;
	}

	private int getXCordinate(char $, int w) {
		// TODO Auto-generated method stub
		return charMap.get($) % w ;
	}

	public static void main(String args[]) {
		/*
		 * for(char x='a';x<='z';x++) { System.out.print("'"+x+"',"); }
		 */
		GetMinSumDistance sumDistance = new GetMinSumDistance();
		System.out.println(sumDistance.getMinDistaceSum(5, "cat", 0, 0, 0));
	}
}
