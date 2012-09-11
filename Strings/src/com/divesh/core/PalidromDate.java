package com.divesh.core;

/** Data format: YYYYMMDD */
public class PalidromDate {

	/** Data format: YYYYMMDD, and str is valid palindrome input */
	public String getNextPalindromDate(String str) {
		System.out.println(str);
		int date[] = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			date[i] = Integer.parseInt(str.charAt(i) + "");
		}
		if (date[3] == 1) {
			date[3] = 0;
			if (date[2] + 1 < 9)
				date[2] += 1;
			else {
				date[2] = 0;
				if (date[1] + 1 < 9)
					date[1] += 1;
				else {
					date[0] += 1;
					date[1] = 0;
				}
			}
		} else {
			if (date[2] < 3)
				date[3] = 1;
			else if (date[2] + 1 < 9)
				date[2] += 1;
			else {
				date[2] = 0;
				if (date[1] + 1 < 9) {
					date[1] += 1;
				} else {
					date[1] = 0;
					date[0] += 1;
				}
				date[3] = 1;

			}
		}

		StringBuilder YYYY = new StringBuilder("");
		for (int i = 0; i < 4; i++) {
			YYYY.append(date[i]);
		}
		String tmp = YYYY.toString();
		String YYYYMMDD = tmp + YYYY.reverse();
		return YYYYMMDD;

	}

	public static void main(String args[]) {
		PalidromDate palidromDate = new PalidromDate();
		// String str = "21211212";
		// String str = "19900906";
		// String str="20100102";
		// String str ="20111109";
		// String str="01911910";
		// String str="92811829";
		String str = "02900920";
		System.out.println(palidromDate.getNextPalindromDate(str));

	}
}
