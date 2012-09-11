package com.divesh.sort;

import com.divesh.util.ArrayUtils;
import com.divesh.util.HeapUtils;

public class HeapSort {
	public void heapSort(int arr[]) {
		HeapUtils.buildMaxHeap(arr, arr.length - 1);
		for (int i = arr.length - 1; i > 0; i--) {
			ArrayUtils.swap(arr, 0, i);
			System.out.println(arr[i]);
			HeapUtils.maxHeapfy(arr, 0, i);
		}
	}

	public static void main(String args[]) {
		HeapSort sort = new HeapSort();
		int arr[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		sort.heapSort(arr);
	}

}
