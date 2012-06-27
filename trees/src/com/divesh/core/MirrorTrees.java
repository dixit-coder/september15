package com.divesh.core;

import com.divesh.util.TreeFormation;

public class MirrorTrees {
	private static Node temp = null;
	private static Node root = null;
	public void setroot(Node node)
	{
		this.root= node;
	}
	public Node getroot()
	{
		return this.root;
	}

	public static void getMirrorImage(Node root) {
		if (root == null)
			return;
		else {
			temp = root.lchild;
			root.lchild = root.rchild;
			root.rchild = temp;
			getMirrorImage(root.lchild);
			getMirrorImage(root.rchild);
		}
	}

	public static void main(String args[]) {
		System.out.println("preorder Traversal before calling");
		MirrorTrees mirrorTrees = new MirrorTrees();
		mirrorTrees.setroot(TreeFormation.getBinaryTree2());
		
		TreeTraversal traversal = new TreeTraversal();
		traversal.preOrderTraversal(mirrorTrees.getroot());
		MirrorTrees.getMirrorImage(mirrorTrees.getroot());
		System.out.println("\n preorder Traversal after calling");
		traversal.preOrderTraversal(mirrorTrees.getroot());
		
	}
}
