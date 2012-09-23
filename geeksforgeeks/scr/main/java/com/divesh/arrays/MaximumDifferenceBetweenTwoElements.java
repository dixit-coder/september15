package com.divesh.arrays;

public class MaximumDifferenceBetweenTwoElements {
	/**
	 * Given an array arr[] of integers, find out the difference between any two
	 * elements such that larger element appears after the smaller number in
	 * arr[].
	 * 
	 * Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should
	 * be 8 (Diff between 10 and 2). If array is [ 7, 9, 5, 6, 3, 2 ] then
	 * returned value should be 2 (Diff between 7 and 9)
	 * */
	public int getMaxDiff(int arr[], int size) {
		int max_diff = Integer.MIN_VALUE;
		int min_so_far = arr[0];
		for (int i = 1; i < size; i++) {
			if (min_so_far > arr[i]) {
				min_so_far = arr[i];
				continue;
			} else if (arr[i] - min_so_far > max_diff) {
				max_diff = arr[i] - min_so_far;
			}

		}
		return max_diff;
	}

	public static void main(String args[]) {
		MaximumDifferenceBetweenTwoElements twoElements = new MaximumDifferenceBetweenTwoElements();
		// int[] arr = { 1, 2, 90, 10, 110 };
		// int[] arr = { 2, 3, 10, 6, 4, 8, 1};
		int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println(twoElements.getMaxDiff(arr, arr.length));
	}
}
