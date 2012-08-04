package com.divesh.sort;

import com.divesh.util.ArrayUtils;

public class QuickSort {

	private int numbers[];
	private int number;

	public void sort(int values[]) {
		if (values == null || values.length == 0) {
			return;
		}
		this.numbers = values;
		number = values.length;
		quickSort(0, number - 1);
	}

	private void quickSort(int start, int end) {
		int i = start, j = end;
		int pivote = numbers[start + (end - start) / 2];
		while (i <= j) {
			while (numbers[i] < pivote)
				i++;
			while (numbers[j] > pivote)
				j--;
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}

		}
		if (start < j) {
			quickSort(start, j);
		}
		if (i < end) {
			quickSort(i, end);

		}
	}

	private void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	public static void main(String args[]) {
		QuickSort qicksort = new QuickSort();
		int arr[] = { 2, 1, 8, 5, 3, 6, 4, 7 };
		 qicksort.sort(arr);
		ArrayUtils.printArray(arr, "\nAfterSort");

	}
}
