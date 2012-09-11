package com.divesh.amazon;

public class ValidExpression {
	boolean isValidExpression(char arr[]) {
		int prod = 1, min = 5;
		for (char x : arr) {
			if (x == '[') {
				if (5 <= min)
					prod *= 5;
				else 
					return false;
				if (min < 5)
					min = 5;
			}
			if (x == '{') {
				if (3 <= min)
					prod *= 3;
				else 
					return false;
				if (min < 3)
					min = 3;
			}
			if (x == '(') {
				if (2 <= min)
					prod *= 2;
				else 
					return false;
				if (min < 2)
					min = 2;
			}
			if (x == ')') {
				prod /= 2;
				min = getMin(prod);
			}
			if (x == '}') {
				prod /= 3;
				min = getMin(prod);
			}
			if (x == ']') {
				prod /= 5;
				min = getMin(prod);
			}
		}
		
		return prod==1?true:false;
	}

	int getMin(int prod) {
		if (prod % 2 == 0)
			return 2;
		else if (prod % 3 == 0)
			return 3;
		else if (prod % 5 == 0)
			return 5;
		else
			return 5;
	}
	
	public static void main(String args[])
	{
		ValidExpression validExpression = new ValidExpression();
	    System.out.println(validExpression.isValidExpression("{((a))[]}".toCharArray()));
	}

}
