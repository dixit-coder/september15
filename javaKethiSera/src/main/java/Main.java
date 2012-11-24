package main.java;

public class Main {
	public static void main(String args[]) {
		String s1 = new String("abc");
		String s2 = new String("abc");
		if (s1.equals(s2)) {
			System.out.println("true");
		}
		else 
			System.out.println("false");
	}
}
