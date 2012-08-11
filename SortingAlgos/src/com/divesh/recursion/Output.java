package com.divesh.recursion;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Output {
	/*public static void main(String args[]) {
		Output output = new Output();
		System.out.println(output.get_power(5,5));
	}

	int get_power(int a, int b) {
		if (b == 0)
			return 1;
		if (b % 2 == 1)
			return a * get_power(a, b / 2);
		return get_power(a, b / 2);
	}

	int func(int p) {
		int sum = 0;
		for (int i = 1; i <= p; ++i) {
			sum += get_power(i, 5);
		}
		return sum;
	}*/
	// http://www.google.com/doodles/hurdles-2012
	private volatile static boolean run=true;

	public static void main(String[] args) throws InterruptedException {
	    Robot robot = null;


	    Thread th = new Thread(new Runnable(){

	        @Override
	        public void run() {
	            try {
	                Thread.sleep(10000);
 	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch   block
	                e.printStackTrace();
	            }finally {
	                run=false;
	            }

	        }

	    });
	    //th.start();

	    try {
	        robot = new Robot();
	    } catch (AWTException e) {

	        e.printStackTrace();
	    }
	    int count = 4000;
	    while(count>0){
	        robot.keyPress(KeyEvent.VK_RIGHT);
	        robot.keyRelease(KeyEvent.VK_RIGHT);
	        Thread.sleep(2);
	        robot.keyPress(KeyEvent.VK_LEFT);
	        robot.keyRelease(KeyEvent.VK_LEFT);
	        count--;
	    }
	}

}
