package com.divesh.core;

import java.util.Arrays;
import java.util.Collections;

import com.divesh.util.ArrayUtils;

public class FindNumberOfTriangles {
	public int findNumberOfTringles(Number arr1[]) {
		Arrays.sort(arr1,Collections.reverseOrder());
		int[] arr = new int[arr1.length];
		for(int i =0;i<arr1.length;i++)
		{
			arr[i]=(Integer)arr1[i];
		}
		ArrayUtils.printArray(arr, "arr==>");
		int count = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			int k = i + 1;
			int j = arr.length - 1;
			while (k < j) {
				while (k < j && (arr[i] < arr[k] + arr[j])) {
					System.out.println(arr[i] + " " + arr[k] + " " + arr[j]);
					count++;
					k++;
				}
				k = i + 1;
				j--;
			}
		}
		return count;
	}

	public static void main(String args[]) {
		Number arr[] = { 10, 21, 22, 100, 101, 200, 300};
		FindNumberOfTriangles numberOfTriangles = new FindNumberOfTriangles();
		System.out.println(numberOfTriangles.findNumberOfTringles(arr));
	}
}
