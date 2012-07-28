package com.divesh.util;

public class BitsUtil {

	public static void printBits(String msg, int x) {
		StringBuilder str = new StringBuilder();
		while (x > 0) {
			str.append(x & 1);
			x >>= 1;
		}
		System.out.println(msg + str.reverse());
		System.out.println();
	}

	/**
	 * IP 5 OP 8
	 * 
	 * IP 17 OP 32
	 */
	public static int  nextPowerOf2(int n)
	{
		if((n&(n-1))==0)
		{
			return n;
		}
		else
		{
			int p=1;
			while (p<n)
			{
				p<<=1;
			}
			return p;
		}
	}
	
	public static void main(String args[]) {
		//getBitsPrint("msg", 128);
		System.out.println(nextPowerOf2(17));
		
	}
	 
	
}
