package com.divesh.threads;

public class SynchornizDemo {
	
	public static void main(String args[]) {
		String str1 = "one";
		String str2 = str1;
		System.out.println("str1==str2 --->" + (str1 == str2));
		System.out.println("str1.equals(str2) --->" + str1.equals(str2));		
	}
}

class ResouceObject {
	public synchronized void set(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public synchronized int read() {
		return (a + b);
	}

	private int a, b;
}
