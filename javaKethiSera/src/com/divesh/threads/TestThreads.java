package com.divesh.threads;

public class TestThreads {
	public static void main(String[] args) throws InterruptedException {
		FooRunnable r = new FooRunnable();
		Thread t = new Thread(r);
		t.start();
	}
}

class FooRunnable implements Runnable {
	public void run() {
		for (int x = 1; x < 6; x++) {
			System.out.println("Runnable running");

		}
	}
}