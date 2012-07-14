package com.divesh.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class TestClass {
	public static void main(String args[]) {
		// List<List<Integer>> table = new ArrayList<ArrayList<Integer>>();
		// Genrics should match.
		List<List<Integer>> table = new ArrayList<List<Integer>>();
		//before();
		Map<ToDos, String> m = new HashMap<ToDos, String>();
		ToDos t1 = new ToDos("Monday");
		ToDos t2 = new ToDos("Monday");
		ToDos t3 = new ToDos("Tuesday");
		m.put(t1, "doLaundry");
		m.put(t2, "payBills");
		m.put(t3, "cleanAttic");
		System.out.println(m.size());

	}

	public static void before() {
		Set set = new TreeSet();
		set.add("2");
		set.add(3);
		set.add("1");
		Iterator it = set.iterator();
		// no compilation error but ClassCastException will occurs on execution.
		while (it.hasNext())
			System.out.print(it.next() + " ");
	}

}

/*
 * class ToDos{ String day; ToDos(String d) { day = d; } public boolean
 * equals(Object o) { return ((ToDos)o).day == this.day; } // public int
 * hashCode() { return 9; } }
 */

class ToDos {
	String day;

	ToDos(String d) {
		this.day = d;
	}
   public boolean equals(Object o)
   {
	   return ((ToDos)o).day ==this.day;
   }
   /*public int hashCode()
   {
	   return 9;
   }*/
}

interface Hungry<E> { void munch(E x); }
interface Carnivore<E extends Animal> extends Hungry<E> {}
//interface Herbivore<E extends Plant> extends Hungry<E> {}
interface Herbivore<E extends Animal> extends Hungry<E> {}
abstract class Plant {}
class Grass extends Plant {}
abstract class Animal {}
class Sheep extends Animal implements Herbivore<Sheep> {
public void munch(Sheep x) {}
}
class Wolf extends Animal implements Carnivore<Sheep> {
public void munch(Sheep x) {}
}

