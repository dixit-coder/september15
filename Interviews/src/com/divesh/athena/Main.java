package com.divesh.athena;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws Exception {
		
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			char str[]= br.readLine().toCharArray();
			int max = Integer.MIN_VALUE;
			for(int i =0;i<str.length;i++)
			{
				int end = str.length-1;
				while(i<=end)
				{
					int r = end;
					int l = i;
					boolean flag = true;
					 while(l<r)
					 {
						 if(str[l]==str[r])
						 {
							 l++;r--;
						 }
						 else 
						 {
							 flag = false;
							 break;
						 }
					 }
					 if(flag)
					 {
						 int x = (end-i)+1;
						 if(max<x)
						 {
							 max = x;
						 }
						 //System.out.println("max= "+max);
					 }
					 end--;
				}
			}
			
			System.out.println(2*str.length -max);
			

	}	
}
