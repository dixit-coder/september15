package com.divesh.util;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtils {
	public static void swap(Object a, Object b, int end) {
		Object tmp = a;
		a = b;
		b = tmp;
	}

	public static void swap(int array[], int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}

	public static void swapWithIn(int b[], int n, int p) {
		int nEnd, nStart = n, pEnd = p, pStart;
		int i = 0;
		while (b[i] < 0) {
			i++;

		}
		pStart = i;
		nEnd = pStart - 1;
		while (nStart < nEnd) {
			ArrayUtils.swap(b, nStart, nEnd);
			nStart++;
			nEnd--;
		}
		while (pStart < pEnd) {
			ArrayUtils.swap(b, pStart, pEnd);
			pStart++;
			pEnd--;
		}

	}

	public static void printArray(int a[], String message) {
		System.out.print(message);
		for (int x : a) {
			System.out.print(" " + x);
		}
		System.out.println();
	}

	// get the Maximum element of the array.
	public static int getMaxElement(int a[]) {
		int max = Integer.MIN_VALUE;
		for (int num : a) {
			if (num > max)
				max = num;
		}
		return max;
	}

	// get the Minimum element of the array.
	public static int getMinElement(int a[]) {
		int min = Integer.MAX_VALUE;
		for (int num : a) {
			if (num < min)
				min = num;
		}
		return min;
	}

	// get the sum of the array
	public static int getSum(int a[]) {
		int sum = 0;
		for (int x : a) {
			sum += x;
		}
		return sum;
	}

	// binarySerch
	public static int binarySerch(int arr[], int low, int high, int x) {
		if (low > high)
			return -1;

		int mid = low + (high - low) / 2;
		if (arr[mid] == x)
			return mid;
		else {
			if (arr[mid] < x)
				return binarySerch(arr, mid + 1, high, x);
			else
				return binarySerch(arr, low, mid - 1, x);
		}
	}

	/**
	 * rotate the sorted array at some pivot unknown to you beforehand. So for
	 * instance, 1 2 3 4 5 might become 3 4 5 1 2
	 */
	public static int getPivotIndexInsortedRowtedArray(int arr[], int low,
			int high) {
		if (low > high)
			return -1;
		int mid = low + (high - low) / 2;
		if (arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1])
			return mid;
		else {
			if (arr[low] < arr[mid])
				return getPivotIndexInsortedRowtedArray(arr, mid, high);
			else
				return getPivotIndexInsortedRowtedArray(arr, low, mid);
		}

	}
	/**
	 * Generate a random numbers from range 0..99
	 * */
    public static int[] getRandomeNumberArray(int x)
    {
    	int arr[] = new int[x];
    	Random randomGenerator= new Random();
    	for(int i=0;i<x;i++)
    	{
    		arr[i]= randomGenerator.nextInt(100);
    	}
    	Arrays.sort(arr);
    	return arr;
    }
    
    public static void main(String args[])
    {
    	for(int num :getRandomeNumberArray(10))
    	{
    		System.out.print(num+",");
    	}
    	System.out.println();
    	int arr[]= {26,43,49,74,77,79,85,93,93,95,12,23,32,45,53,62,65,66,88,96};
    	Arrays.sort(arr);
    	for(int num :arr)
    	{
    		System.out.print(num+",");
    	}
    }
    
}
