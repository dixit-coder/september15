package com.divesh.amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

public class Solution1 {
	public static void main1(String args[]) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String s = br.readLine();
			
			
			double number = Double.parseDouble(s);
			System.out.println("Number is:" + number);
			
			
			
		} catch (Exception e) {
			System.err.println("Error:" + e.getMessage());
		}
	}
	
	public static void main(String args[]) {
		System.out.println(searchString("cdec","abcdef"));
	}
	static int searchString(String a, String b) {

		 for (int i=0;i<b.length();i++)
		 {    int tmp = i; boolean flag = true;
		     for(int j = 0 ;j<a.length();j++)
		     {
		    	 if(b.charAt(tmp)== a.charAt(j))
		    	 {
		    		 tmp++;
		    	 }
		    	 else
		    	 {
		    		 flag = false;
		    		 break;
		    	 }
		     }
		     
		     if(flag)
		     return i;
		 }
		 return -1;
		}

	private static int doesRectOverlap(rect ra, rect rb) {

		if ((lieInbetween(ra.topx, rb.topx, ra.botx) && lieInbetween(ra.topy,
				rb.topy, ra.boty))
				|| (lieInbetween(ra.topx, rb.botx, ra.botx) && lieInbetween(
						ra.topy, rb.topy, ra.boty)))
			return 1;
		else if ((lieInbetween(rb.topx, ra.topx, rb.botx) && lieInbetween(
				rb.topy, ra.topy, rb.boty))
				|| (lieInbetween(rb.topx, ra.botx, rb.botx) && lieInbetween(
						rb.topy, ra.topy, rb.boty)))
			return 1;
		else
			return 0;

	}
	private static boolean lieInbetween(int p,int q,int r)
	{
		return (p<q  && q<r)||(p>q && q>r);
	}
	
	
static int minCoins(Vector <Integer>a , int S) {
	
	int arr[] = new int[S+1];
	for(int x =0;x<arr.length;x++)
	{
		arr[x]=-1;// 
	}
	arr[0]=0;
	for(int j =1;j<=S;j++)
	{    int min = 10000;
		 for(int i =0;i<a.size();i++)
		 {
			 
			 if(a.get(i)<=i)
			 {  if(min > arr[i-a.get(i)]+1)
				 min = arr[i-a.get(i)]+1;
			 }
			 if (min!=10000)
			 {
				 arr[i]=min;
			 }
		 }
	
	}
	return arr[S];
	/*Set Min[i] equal to Infinity for all of i
      Min[0]=0

For i = 1 to S
For j = 0 to N - 1
   If (Vj<=i AND Min[i-Vj]+1<Min[i])
Then Min[i]=Min[i-Vj]+1

Output Min[S]
	 * */
	}
}


  class rect{
	int topx, topy, botx, boty;
	rect(int x1, int y1, int x2, int y2){
		topx = x1;
		topy = y1;
		botx = x2;
		boty = y2;
	} 
  }
