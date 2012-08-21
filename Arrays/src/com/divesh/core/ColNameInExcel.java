package com.divesh.core;

public class ColNameInExcel {

	public String getColName(int id) {
		char ch[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z' };
		int i = 0;
		int arr[] = new int[256];
		while (id > 0) {
			arr[i++] = (id-1) % 26;
			id = (id-1) / 26;
		}
		String result = "";
		for (int x = i - 1; x >= 0; x--)
			result = result + ch[arr[x]];
		return result;
	}

	public static void main(String args[]) {
		/*
		 * for(char a ='a' ;a <='z';a++) System.out.print(",'"+a+"'");
		 */
		ColNameInExcel cNameInExcel = new ColNameInExcel();
		System.out.println(cNameInExcel.getColName(27));
	}

}
