package com.divesh.util;

public class HeapUtils {

	public static void buildMaxHeap(int arr[], int maxLenTobeBuild) {
		for (int j = (maxLenTobeBuild / 2)-1; j >= 0; j--) {
			maxHeapfy(arr, j,maxLenTobeBuild);
		}
		//ArrayUtils.printArray(arr, "\nmaxHeapfy:"+ length +":");

	}
    
	/**max heapify of the given array, at node i only*/
	public static void maxHeapfy(int arr[], int i,int maxLenToBeCheck) {
		// left , right, max
		int left = 2 * i + 1, right = 2 * i + 2;
		int max = i;
		if (left < maxLenToBeCheck && arr[left] > arr[max]) {
			max = left;
		}
		if (right < maxLenToBeCheck && arr[right] > arr[max]) {
			max = right;
		}
		if (max != i) {
			ArrayUtils.swap(arr, max, i);
			maxHeapfy(arr, max,maxLenToBeCheck);
		}
		
	}
}
