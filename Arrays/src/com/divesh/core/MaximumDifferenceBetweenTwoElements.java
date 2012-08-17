package com.divesh.core;

public class MaximumDifferenceBetweenTwoElements {
	/**
	 * Given an array arr[] of integers, find out the difference between any two
	 * elements such that larger element appears after the smaller number in
	 * arr[]
	 */
	int maxDiff(int arr[]) {
		int max = arr[0], min = arr[0], diff = Integer.MIN_VALUE;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				diff = max - min;
			}
			if (arr[i] < min)
				min = arr[i];
		}
		return diff;
	}

	public static void main(String args[]) {
		int arr[] = { 7, 6, 5, 4, 3, 2 };//{ 2, 3, 10, 6, 4, 8, 1 };// {1, 2, 6, 80, 100};
		MaximumDifferenceBetweenTwoElements twoElements = new MaximumDifferenceBetweenTwoElements();
		System.out.println(twoElements.maxDiff(arr));
	}
}
