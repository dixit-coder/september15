package com.divesh.test.arrays;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.divesh.arrays.Segregate0sAnd1s;

public class Segregate0sAnd1sTest {

	private Segregate0sAnd1s testClass=null;
	@Before
	public void setup() {
		testClass = new Segregate0sAnd1s();
		
	}

	@Test
	public void testPositive() {
		int arr[]={ 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 };
		int result[]=testClass.segregate0and1(arr, arr.length);
		// test whether arr and result have same number of 1s and zeros
		Assert.assertEquals(true, arr.length == result.length);
		for (int i : testClass.segregate0and1(arr, arr.length)) {
			System.out.print(" " + i);
		}
	}
	
}
