package com.divesh.core;

import java.util.Arrays;

public class CandiesProblem {

	public int getMinCandies(int rating[]) {
		Arrays.sort(rating);
		int students = rating.length;
		int i = 0, j = students - 1;
		int candy[] = new int[students];
		int highLow[] = new int[students];
		// int LowHigh[] = new int[students];
		int count = 0;
		while (i <= j) {
			do {
				highLow[count++] = rating[i++];
			} while (rating[i] == rating[i + 1]);

			do {
				highLow[count++] = rating[j--];
			} while (rating[j] == rating[j - 1]);

		}

		candy[0] = 2;
		for (int k = 1; k < candy.length; k++) {
			if (highLow[i] > highLow[i - 1])
				candy[i] = 1;
			else if (highLow[i] < highLow[i - 1]) {
				candy[i] = 2;
			} else {
				candy[i] = candy[i - 1];
			}
		}

		int sum = 0;
		for (int x : candy)
			sum += x;
		return sum;
	}

	public static void main(String args[]) {
		int arr[] = new int[] { 1, 2, 2 };
		CandiesProblem candProblem = new CandiesProblem();
		System.out.println(candProblem.getMinCandies(arr));
	}

}
