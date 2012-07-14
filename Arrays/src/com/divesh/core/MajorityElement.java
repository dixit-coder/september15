package com.divesh.core;

public class MajorityElement {
	private int mid;

	public boolean isMajority(int arr[], int x) {
		int index = getIndex(arr, 0, arr.length - 1, x);
		if (index == -1) {
			return false;
		} else
			return ((index + arr.length / 2 < arr.length) && arr[index] == arr[index
					+ arr.length / 2]) ? true : false;
	}

	public int getIndex(int[] arr, int i, int j, int x) {
		if (i > j)
			return -1;
		else {
			mid = (i + j) / 2;
			if (mid == 0 || arr[mid] == x && arr[mid - 1] < x) {
				return mid;
			} else {
				if (arr[mid] > x)
					return getIndex(arr, 0, mid - 1, x);
				else
					return getIndex(arr, mid + 1, j, x);
			}
		}
	}
	public static void main(String args[])
	{
		//int arr[] = {1, 2, 3, 3, 3, 3, 10};
		int arr[] = {1, 2, 3, 3, 3, 4, 10};
		MajorityElement mElement = new MajorityElement();
		System.out.println(mElement.isMajority(arr, 3));
	}
}
