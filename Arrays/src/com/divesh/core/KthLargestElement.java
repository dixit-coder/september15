package com.divesh.core;

public class KthLargestElement {

	public int getKthLargestElement(int arr[], int low, int high, int k) {
		if (low > high)
			return -1;
		int left = low;
		int pivote = high;
		int right = high;
		while (left < right) {
			while (arr[left] < arr[pivote])
				left++;
			while (arr[right] >= arr[pivote])
				right--;
			if (left < right) {
				swap(arr, left, right);
				left++;right--;
			}
		}
		int tmp = arr[pivote];
		arr[pivote]=arr[left];
		arr[left]=tmp;
		pivote = left;
		if(pivote==k-1)
			 return arr[pivote];
		else
		{
			if(pivote > k-1)
				return(getKthLargestElement(arr, low, pivote-1, k));
			else 
				return(getKthLargestElement(arr, pivote, high , k));
		}
       
	}
	
	public static void main(String args[])
	{
		KthLargestElement kthLargestElement = new KthLargestElement();
		int arr[]={1,3,5,2,4,7,6};
		System.out.println(kthLargestElement.getKthLargestElement(arr, 0, arr.length-1, 6));
		System.out.println(kthLargestElement.getKthLargestElement(arr, 0, arr.length-1, 2));
		System.out.println(kthLargestElement.getKthLargestElement(arr, 0, arr.length-1, 7));
		System.out.println(kthLargestElement.getKthLargestElement(arr, 0, arr.length-1, 1));
		System.out.println(kthLargestElement.getKthLargestElement(arr, 0, arr.length-1, 5));
	}

	private void swap(int[] arr, int left, int right) {
		int tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;

	}
}