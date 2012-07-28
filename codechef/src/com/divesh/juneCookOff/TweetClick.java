package com.divesh.juneCookOff;

public class TweetClick {
	/**
	 * 3 6 CLICK 1 CLICK 2 CLICK 3 CLICK 2 CLOSEALL CLICK 1
	 */

	public static void main(String[] args) throws java.lang.Exception {
		java.io.BufferedReader r = new java.io.BufferedReader(
				new java.io.InputStreamReader(System.in));
		String KN[];
		KN = r.readLine().split(" ");
		int K, N, index;
		N = Integer.parseInt(KN[0]);
		K = Integer.parseInt(KN[1]);
		int tweets[] = new int[N];
		int openTwtsCount = 0;
		String input[] = new String[K];

		for (int i = 0; i < K; i++) {
			input[i] = r.readLine();
		}
		/*for (String str : input) {
			System.out.println(str);
		}*/
		for (int j = 0; j < input.length; j++) {
			try {
				index = Integer.parseInt(input[j].substring(6));
				if (tweets[index - 1] > 0) {
					tweets[index - 1] -= 1;
					openTwtsCount--;
				} else {
					tweets[index - 1] = 1;
					openTwtsCount++;
				}

			} catch (Exception e) {
				for (int i = 0; i < tweets.length; i++) {
					tweets[i] = 0;
				}
				openTwtsCount = 0;
			}
			System.out.println(openTwtsCount);
		}

	}
}