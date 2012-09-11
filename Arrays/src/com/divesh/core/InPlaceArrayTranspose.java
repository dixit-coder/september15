package com.divesh.core;

import com.divesh.util.ArrayUtils;

public class InPlaceArrayTranspose {
    static int count=0;
	int getNewIndex(int idx, int N) {
		return idx % 3 * N + idx / 3;
	}

	void swap(int arr[], int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}

	void transformArray2(int arr[]) {
		int len = arr.length;
		int N = len / 3;
		for (int i = 0; i < len; i++) {
            int newIndex= getNewIndex(i, N);
            count++;
            while(newIndex<i)
            {   count++;
            	newIndex = getNewIndex(newIndex, N);
            }
            swap(arr, i, newIndex);
            ArrayUtils.printArray(arr, "\n");
		}
		System.out.println("\n=======================================================");
		for (int i : arr) {
			System.out.print(i +" ");
		}
		System.out.println("count:"+count);
	}
	public static void main(String args[])
	{
		int arr[]={1,2,3,4,5,6,7,8,9,10,11,12};
		InPlaceArrayTranspose placeArrayTranspose = new InPlaceArrayTranspose();
		placeArrayTranspose.transformArray2(arr);
	}
}
