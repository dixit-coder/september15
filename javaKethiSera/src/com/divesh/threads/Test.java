package com.divesh.threads;

public class Test {
	public static void main(String[] args) {
		printAll(args);
	}

	public static void printAll(String[] lines) {
		lines = new String[]{"I will be in","Google by 15th-September-2012"};
		for (int i = 0; i < lines.length; i++) {
			System.out.println(lines[i]);
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
