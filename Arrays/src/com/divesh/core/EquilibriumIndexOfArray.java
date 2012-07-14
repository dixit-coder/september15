package com.divesh.core;

import com.divesh.util.ArrayUtils;

public class EquilibriumIndexOfArray {
	public void getEquilibriumIndex(int arr[]) {
		int tsum = ArrayUtils.getSum(arr);
		int lsum = 0, rsum = tsum;
		for (int i = 0; i < arr.length; i++) {
			rsum = tsum - lsum - arr[i];
			if (lsum == rsum)
				System.out.println("index==>" + i);
			lsum += arr[i];
		}

	}
	
	public static void main(String args[]) {
		EquilibriumIndexOfArray equilibriumIndexOfArray = new EquilibriumIndexOfArray();
		int arr[] = {-7, 1, 5, 2, -4, 3, 0};
		equilibriumIndexOfArray.getEquilibriumIndex(arr);
	}

}
