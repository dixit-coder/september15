package com.divesh.test.enumPractise;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.divesh.enumPractise.Evaluate;

public class EvaluateTest {

	Evaluate eval = null;

	@Before
	public void setup() {
		eval = new Evaluate();
	}

	@Test
	public void testPositiveIsBalanced() {
		boolean result = eval
				.isBalanced("pulbic static void main(String args[]) {}");
		Assert.assertTrue("", result);
	}

	@Test
	public void testNegativeIsBalanced() {
		boolean result = eval
				.isBalanced("pulbic static void main(String args[]) {");
		Assert.assertFalse("", result);
		
		result = eval.isBalanced("9090()(([]");
		Assert.assertFalse("", result);
		result = eval.isBalanced("[]{}{)(}");
		Assert.assertFalse("", result);

	}

}
