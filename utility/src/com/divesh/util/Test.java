package com.divesh.util;

public class Test {

	void funtion(int x) {
		x = x + 2;
	}

	void funtion(Integer x) {
		x = x + 2;
	}

	void funtion(CallTest x) {
		x.setTesta(x.getTesta() + 2);
	}

	public static void main(String args[]) {
		int y = 2;
		Integer yy = new Integer(2);
		CallTest callTest = new CallTest();
		
		Test test = new Test();
		test.funtion(y);
		test.funtion(yy);
		test.funtion(callTest);
		
		System.out.println("y =" + y);
		System.out.println("yy =" + yy);
		System.out.println("callTets.testa =" + callTest.getTesta());
	}
}

class CallTest {
	private int testa;

	public CallTest() {
		super();
		testa = 2;
	}

	public int getTesta() {
		return testa;
	}

	public void setTesta(int testa) {
		this.testa = testa;
	}


}
