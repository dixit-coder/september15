package com.divesh.core;

import com.divesh.util.Tnode;
import com.divesh.util.TreeFormation;

public class KthNodeFromRoot {
	public void getKthNode(Tnode node, int k) {
		if(node == null)
			return;
		if ( k == 0 ) {
			System.out.print(" "+node.data);
			return;
		}
		getKthNode(node.lchild, k - 1);
		getKthNode(node.rchild, k - 1);
	}
	public static void main(String args[])
	{
		KthNodeFromRoot kthNodeFromRoot = new KthNodeFromRoot();
		kthNodeFromRoot.getKthNode(TreeFormation.getBinarySerchTree(), 2);
	}
}
