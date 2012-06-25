package com.divesh.driverPrograms;

import com.divesh.core.TreeSize;
import com.divesh.core.TreeTraversal;
import com.divesh.core.TreesIdentical;
import com.divesh.util.TreeFormation;

public class Tree {
	public static void main(String args[]) {
		TreeTraversal traversal = new TreeTraversal();
		System.out.println("preorder Traversal");
		traversal.preOrderTraversal(TreeFormation.getBinaryTree());
		System.out.println("\n InOrder Traversal");
		traversal.inOrderTraversal(TreeFormation.getBinaryTree());
		System.out.println("\npostOrder Traversal");
		traversal.postOrderTraversal(TreeFormation.getBinaryTree());
		System.out.println("\nTreeSize==>"
				+ TreeSize.getTreeSize(TreeFormation.getBinaryTree()));
		System.out.println("sameTree==>"
				+ TreesIdentical.sameTree(TreeFormation.getBinaryTree2(),
						TreeFormation.getBinaryTree2()));
		System.out.println("hightOfTree==>"
				+ TreeSize.getTreeHeight(TreeFormation.getBinaryTree()));
		System.out.println("hightOfTree2==>"
				+ TreeSize.getTreeHeight(TreeFormation.getBinaryTree2()));
	}
}
