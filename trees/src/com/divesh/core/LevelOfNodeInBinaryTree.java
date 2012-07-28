package com.divesh.core;

import java.util.Stack;

import com.divesh.util.Tnode;
import com.divesh.util.TreeFormation;

public class LevelOfNodeInBinaryTree {
	private Stack<Integer> stack = new Stack<Integer>();
	private int level = 0;
    /** implementations using stack*/
	public void getLevelOfnode(Tnode node, int k) {
		if (node == null) {
			return;
		}
		stack.push(node.data);
		if (stack.peek() == k) {
			level = stack.size();
			return;
		}
		getLevelOfnode(node.lchild, k);
		getLevelOfnode(node.rchild, k);
		stack.pop();
	}

	public int getLevelOfnode2(Tnode node, int k, int level) {
		if (node == null) {
			return 0;
		}
		if (node.data == k)
			return level;
		else
			return Math.max(getLevelOfnode2(node.lchild, k, level + 1),
					getLevelOfnode2(node.rchild, k, level + 1));

	}

	public static void main(String args[]) {
		LevelOfNodeInBinaryTree levelOfNodeInBinaryTree = new LevelOfNodeInBinaryTree();
		levelOfNodeInBinaryTree.getLevelOfnode(TreeFormation.getBinaryTree2(),
				1);
		System.out.println("level=" + levelOfNodeInBinaryTree.level);

		System.out.println("2'level="+levelOfNodeInBinaryTree.getLevelOfnode2(TreeFormation.getBinaryTree2(),
				1, 1));
	}
}
