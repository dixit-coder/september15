package com.divesh.core;

public class SubTree {

	public boolean isSubTree(Node T, Node S) {
		if (S == null)
			return true;
		if (T == null)
			return false;
		if (areEquivalent(T, S))
			return true;
		return (isSubTree(T.lchild, S) || isSubTree(T.rchild, S));
	}

	public boolean areEquivalent(Node t, Node s) {
		if (t == null && s == null)
			return true;
		if (t == null || s == null)
			return false;
		return ((t.data==s.data)&&areEquivalent(t.lchild, s.lchild) && areEquivalent(t.rchild,
				s.rchild));
	}

	public static void main(String args[])
	{
		Node T = new Node(26);
		T.lchild = new Node(10);
		T.rchild = new Node(13);
		T.rchild.rchild = new Node(3);
		T.lchild.lchild = new Node(4);
		T.lchild.rchild = new Node(6);
		T.lchild.lchild.rchild= new Node(30);
      
		Node S  = new Node(10);
	    S.rchild= new Node(6);
	    S.lchild= new Node(4);
	    S.lchild.rchild= new Node(30);
		
		SubTree subTree = new SubTree();
		System.out.println(subTree.isSubTree(T, S));
	}
}
