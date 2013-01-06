package com.divesh.threads;

public class Multi extends Thread {

	public void run(){
		System.out.println(Thread.currentThread().getName());
		for(int i =1;i<=5;i++)
		{
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
       
	   Multi multi1 = new Multi();
       multi1.run();
       System.out.println(Thread.currentThread().getName());
       System.out.println("mains Ends");
	}

}
