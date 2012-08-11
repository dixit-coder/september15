package com.divesh.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * find all the subset of the given set. input: {1,2,3,4,5,6} output:
 * {{},{1},{2},{3},{4},{5},{6},{1,2},{1,3},{1,4},{1,5},.................}
 */
public class PowerSet {
	public List<List<Integer>> getPowerSet(List<Integer> inputSet) {
		// powerSet list
		List<List<Integer>> ps = new ArrayList<List<Integer>>();

		ps.add(new ArrayList<Integer>()); // adding the null set
		for (int X : inputSet) {
			List<List<Integer>> new_ps = new ArrayList<List<Integer>>();
			for (List list : ps) { // convert list in set;
				new_ps.add(list);
				Set<Integer> tmpSet = new HashSet<Integer>(list);
				tmpSet.add(X);
				List<Integer> newList = new ArrayList<Integer>(tmpSet);
				 new_ps.add(newList); 
			}
			ps = new_ps;
		}
		return ps;
	}
   public static void main(String args[])
   {
	   PowerSet powerSet = new PowerSet();
	   List<Integer> inputSet = new ArrayList<Integer>();
		for (int i = 1; i < 1000; i++) {
			inputSet.add(i);
		}
	   
	   System.out.println("input Set==>" + inputSet);
	   for(List list: powerSet.getPowerSet(inputSet))
	   {
		   System.out.println(list);
	   }
   }
   
}
