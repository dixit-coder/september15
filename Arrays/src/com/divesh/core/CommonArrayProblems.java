package com.divesh.core;

import com.divesh.util.ArrayUtils;

public class CommonArrayProblems {

	public static void main(String arsg[]) {
		int arr[] = { 16, 17, 4, 3, 5, 2 };
		CommonArrayProblems arrayProblems = new CommonArrayProblems();
		// arrayProblems.getAllLeaders(arr);

		int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 },
				{ 13, 14, 15, 16, 17, 18 } };
		// arrayProblems.spiralArrayPrint(a, 3, 6);
		// arrayProblems.spiralArrayPrint(a, 0, 0, 2, 5);
		int oddNumbertimes[] = { 1, 2, 3, 2, 3, 1, 3 };
		// System.out.println(arrayProblems.getNumbeOccurringOddNumberTimes(oddNumbertimes));
		int pivotedSorted[] = { 3, 4, 5, 6, 7, 8, 9, 1, 2 };
		System.out.println(arrayProblems.getElementInSortedPivotedArr(pivotedSorted, 9));
	}

	/**
	 * print all the LEADERS in the array. An element is leader if it is greater
	 * than all the elements to its right side. And the rightmost element is
	 * always a leader. For example int the array {16, 17, 4, 3, 5, 2}, leaders
	 * are 17, 5 and 2.
	 */
	@SuppressWarnings("unused")
	private void getAllLeaders(int[] arr) {
		int leader = arr[arr.length - 1];
		System.out.print(" " + leader);
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > leader) {
				leader = arr[i];
				System.out.print(" " + leader);

			}

		}
	}

	/** Iterative approach Not working :( */
	@SuppressWarnings("unused")
	private void spiralArrayPrint(int arr[][], int ROW, int COL) {
		int rMax = ROW - 1, rMin = 0, cMax = COL - 1, cMin = 0;
		int i = 0, j = 0;
		while (rMin <= rMax && cMin <= cMax) {
			while (j <= cMax) {
				System.out.print(" " + arr[i][j++]);
				if (j > cMax) {
					j = cMax;
					break;
				}
			}
			i = ++rMin;
			while (i <= rMax) {
				System.out.print(" " + arr[i++][j]);
				if (i > rMax) {
					i = rMax;
					break;
				}
			}
			// if(j!=cMax) j = --cMax;
			while (j >= cMin) {
				System.out.print(" " + arr[i][j--]);
				if (j < cMin) {
					j = cMin;
					break;
				}
			}
			i = --rMax;
			while (i >= rMin) {
				System.out.print(" " + arr[i--][j]);
				if (i < rMin) {
					i = rMin;
					break;
				}
			}
			j = ++cMin;

		}

	}

	/** Recusive approch Total time taken to develop this 4h 36m 43s */
	@SuppressWarnings("unused")
	private void spiralArrayPrint(int arr[][], int row, int col, int ROW,
			int COL) {

		int i = row, j = col;
		if (ROW < row || COL < col)
			return;

		while (j < COL) {
			System.out.print(" " + arr[i][j++]);
		}
		while (i < ROW) {
			System.out.print(" " + arr[i++][j]);
		}

		row++;
		COL--;
		if (row < ROW && col < COL) {
			while (j > col) {
				System.out.print(" " + arr[i][j--]);
			}
			while (i > row) {
				System.out.print(" " + arr[i--][j]);
			}
		} else
			System.out.print(" " + arr[i][j]);
		spiralArrayPrint(arr, row, col + 1, ROW - 1, COL);
	}

	/**
	 * Given an array of positive integers. All numbers occur even number of
	 * times except one number which occurs odd number of times
	 */
	public int getNumbeOccurringOddNumberTimes(int arr[]) {
		int xor = 0;
		for (int i = 0; i < arr.length; i++) {
			xor ^= arr[i];
		}
		return xor;
	}

	public int getElementInSortedPivotedArr(int arr[], int x) {

		int pivote = ArrayUtils.getPivotIndexInsortedRowtedArray(arr, 0,
				arr.length);

		return ArrayUtils.binarySerch(arr, 0, pivote-1, x) != -1 ? ArrayUtils
				.binarySerch(arr, 0, pivote-1, x) : ArrayUtils.binarySerch(arr,
				pivote, arr.length-1, x);
	}
}
