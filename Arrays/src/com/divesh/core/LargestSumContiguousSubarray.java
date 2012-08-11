package com.divesh.core;

import com.divesh.util.ArrayUtils;

public class LargestSumContiguousSubarray {
	/** iterative approach */
	public int getLargetSumContiguousSubarry(int arr[]) {
		int[] tmp = new int[arr.length];
		tmp[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			tmp[i] = Math.max(tmp[i - 1] + arr[i], arr[i]);
		}
		return ArrayUtils.getMaxElement(tmp);
	}
	/** recursive approach */
	public int getLargetSumContiguousSubarry1(int arr[], int max_so_far,
			int sum, int i) {
		if (i < arr.length) {
			int tmp = Math.max(arr[i] + sum, arr[i]);
			sum = tmp;
			if (max_so_far < tmp)
				max_so_far = tmp;
			return getLargetSumContiguousSubarry1(arr, max_so_far, sum, ++i);
		} else
			return max_so_far;

	}

	public static void main(String args[]) {
		int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		LargestSumContiguousSubarray sumContiguousSubarray = new LargestSumContiguousSubarray();
		System.out.println(sumContiguousSubarray
				.getLargetSumContiguousSubarry1(arr, arr[0], arr[0], 1));
	}
}
