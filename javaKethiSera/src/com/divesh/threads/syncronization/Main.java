package com.divesh.threads.syncronization;

public class Main {

	public static void main(String args[]) {
		final Customer c = new Customer(0);

		Thread t1 = new Thread() {
			public void run() {
				c.withdraw(100);
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				c.deposite(900);
			}
		};
		t1.setName("Withdraw");
		t2.setName("Deposite");
		t1.start();
		t1.interrupt();
		System.out.println(t1.isAlive());
		System.out.println(t1.isInterrupted());
		System.out.println(Thread.interrupted());
		t2.start();

	}
}
