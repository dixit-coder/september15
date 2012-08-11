package com.divesh.core;

import java.util.Arrays;

public class checkForPairWithSum {
	/**
	 * iterative way
	 * */
	public int[] getPairWithSum1(int arr[], int x) {
		Arrays.sort(arr);
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			if (arr[low] + arr[high] == x)
				return new int[] { arr[low], arr[high] };

			else {
				if (arr[low] + arr[high] > x)
					high--;
				else
					low++;
			}
		}

		return null;
	}

	/**
	 * Recursive way
	 * */
	public int[] getPairWithSum(int arr[], int x, int low, int high) {
		if (low <= high) {
			if (arr[low] + arr[high] == x)
				return new int[] { arr[low], arr[high] };

			else {
				if (arr[low] + arr[high] > x)
					return getPairWithSum(arr, x, low, high--);
				else
					return getPairWithSum(arr, x, low++, high);
			}
		}

		return null;
	}

	public static void main(String args[]) {
		checkForPairWithSum sum = new checkForPairWithSum();
		int A[] = { 1, 4, 45, 6, 10, 8 };
		int n = 16;
		int result[] = sum.getPairWithSum1(A, n);
		if (result != null)
			System.out.println(result[0] + "," + result[1]);
		else
			System.out.println("No such Pairs");
	}
}
