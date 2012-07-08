package com.divesh.util;

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
	}
}
