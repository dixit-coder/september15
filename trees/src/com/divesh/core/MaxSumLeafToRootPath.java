package com.divesh.core;

import java.util.Stack;

import com.divesh.util.Tnode;
import com.divesh.util.TreeFormation;

public class MaxSumLeafToRootPath {
	public int getMaxSum() {
		return maxSum;
	}

	private Stack<Tnode> stack = new Stack<Tnode>();
	private int maxSum = -1000000, sum;

	public void preOrderTraversal(Tnode node) {
		// do the inorder traversal and put all the non-leaf node in an stack

		if (node == null)
			return;
		stack.push(node);
		if (stack.peek().lchild == null && stack.peek().rchild == null) {
			// sum the stack
			sum = 0;
			for (int i = 0; i < stack.size(); i++) {
				sum += stack.get(i).data;
			}
			if (sum > maxSum)
				maxSum = sum;
			stack.pop();
			return;
		}
		preOrderTraversal(node.lchild);
		preOrderTraversal(node.rchild);
		stack.pop();

	}

	public static void main(String args[]) {
		MaxSumLeafToRootPath maxLeafToRootPath = new MaxSumLeafToRootPath();
		maxLeafToRootPath.preOrderTraversal(TreeFormation.getBinaryTree());
		System.out.println(maxLeafToRootPath.getMaxSum());
	}
}
