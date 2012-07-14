package com.divesh.core;

import com.divesh.util.ArrayUtils;

public class LongestIncreasingSubSequence {
	private int tmp[], max;

	public int getLIS(int arr[]) {
		tmp = new int[arr.length];
		tmp[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			max = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					if (max < tmp[j] + 1) {
						max = tmp[j] + 1;
					}
				}
			}
			tmp[i] = max;
		}

		// get max of tmp[]

		return ArrayUtils.getMaxElement(tmp);
	}

	public static void main(String args[]) {
		LongestIncreasingSubSequence LIS = new LongestIncreasingSubSequence();
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		//int arr[] = { 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 14, 11, 7 };
		System.out.println("LIS==>" + LIS.getLIS(arr));
	}
}
