package com.divesh.core;

public class SpiralPrintingOfArray {

	public void printInSpiral(int N) {
		int i = 0, j = 0, lc = 0, rc = N - 1, tr = 0, br = N - 1;
		int arr[][] = new int[N][N];
		int count = 1;
		while (!(tr > br) || !(lc > rc)) {
			i = tr;
			j = lc;
			while (j < rc) {
				arr[i][j] = count++;
				j++;
			}
			tr++;
			while (i < br) {
				arr[i][j] = count++;
				i++;
			}
			rc--;
			while (j > lc ) {
				arr[i][j] = count++;
				j--;
			}
			br--;
			while (i > tr) {
				arr[i][j] = count++;
				i--;
			}
			lc++;
			arr[i][j] = count++;
		}

		for (int p = 0; p < N; p++) {
			for (int q = 0; q < N; q++) {
				System.out.print(arr[p][q] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		SpiralPrintingOfArray arrayPrint = new SpiralPrintingOfArray();
		arrayPrint.printInSpiral(100);
	}
}
