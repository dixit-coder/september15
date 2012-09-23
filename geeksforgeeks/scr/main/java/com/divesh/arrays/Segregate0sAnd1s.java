package com.divesh.arrays;

import com.divesh.util.ArrayUtils;

public class Segregate0sAnd1s {
	public int[] segregate0and1(int arr[], int size) {
		int j = size, i = 0;
		while (i != j) {
			if (arr[i] == 0)
				i++;
			else {
				ArrayUtils.swap(arr, i, j - 1);
				j--;
			}
		}
		return arr;
	}

	public static void main(String args[]) {
		Segregate0sAnd1s zerosAnd1s = new Segregate0sAnd1s();
		int arr[] = { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 };
		for (int i : zerosAnd1s.segregate0and1(arr, arr.length)) {
			System.out.print(" " + i);
		}
	}
}
