package com.divesh.threads.syncronization;

public class Customer {
	private double balance;

	// withdraw method
	// deposite method

	public Customer(double balance) {
		super();
		this.balance = balance;
	}

	public synchronized void withdraw(int amt) {
		if (balance < amt) {
			System.out.println(Thread.currentThread().getName()
					+ " Insufficent Balance waiting for deposit...");
		  try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		} 	
		balance -= amt;
		System.out.println(Thread.currentThread().getName()
				+ " Withdraw completed for :" + amt + " availBalance: "
				+ balance);
	}

	public synchronized void deposite(int amt) {
		if (amt > 0)
			balance += amt;
		System.out
				.println(Thread.currentThread().getName()
						+ " deposite completed for :" + amt + " availBalance: "
						+ balance);
		try {
			Thread.sleep(1000);
			//notifyAll();
			notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
