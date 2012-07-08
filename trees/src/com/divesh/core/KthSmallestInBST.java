package com.divesh.core;

import java.util.Stack;

import com.divesh.util.TreeFormation;

public class KthSmallestInBST {
	private int leftSize;

	public Node getKthSmallestElm(Node node, int k) {
		if (node == null) {
			return null;
		}
		leftSize = TreeSize.getTreeSize(node.lchild);

		if (k == leftSize + 1)
			return node;
		else {
			if (leftSize >= k)
				return getKthSmallestElm(node.lchild, k);
			else {
				k = k - leftSize - 1;
				return getKthSmallestElm(node.rchild, k);
			}
		}
	}

	public static void main(String args[]) {
		KthSmallestInBST kthSmallestInBST = new KthSmallestInBST();
		Node node = kthSmallestInBST.getKthSmallestElm(
				TreeFormation.getBinarySerchTree(), 5);
		System.out.println(node.data);
	}
}
