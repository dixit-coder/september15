package main.java;

public class TestDays {
    int x =3;
	public enum Days {
		MON, TUE, WED
	};

	public static void main(String args[]) {
		for (Days day : Days.values()) {
			System.out.println("day==>" + day);
		}
		System.out.println("--------");
		Days[] d2 = Days.values();
		System.out.println(d2[2]);

	}

	/*void go1() {
		int x;
		go2(++x);
	}*/

	void go2(int y) {
		int x = ++y;
		System.out.println(x);
	}

}
