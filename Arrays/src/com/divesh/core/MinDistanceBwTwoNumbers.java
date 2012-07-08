package com.divesh.core;

public class MinDistanceBwTwoNumbers {
	public int getMinDis(int a[], int x, int y) {
		int minDist = -1000, holdposition = -10000, holdvariable = -1000, serchvariable = -1000;
		boolean flage = true;
		for (int k = 0; k < a.length; k++) {
			if (flage) {
				if (a[k] == x || a[k] == y) {
					holdposition = k;
					holdvariable = a[k];
					serchvariable = (a[k] == x) ? y : x;
					flage = false;
					continue;
				}
			}
			if (a[k] == serchvariable) {
				minDist = k - holdposition;
				flage = true;
			}
			if (a[k] == holdvariable) {
				holdposition = k;
			}
		}
		return minDist;
	}
	public static void main(String args[])
	{
		MinDistanceBwTwoNumbers distanceBwTwoNumbers = new MinDistanceBwTwoNumbers();
		//int arr[]={1, 2};
		//int arr[]={3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
		int arr[]={2, 5, 3, 5, 4, 4, 2, 3};
		System.out.println(distanceBwTwoNumbers.getMinDis(arr, 2, 3));
	}
}
