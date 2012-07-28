package com.divesh.core;

import com.divesh.util.Tnode;

public class SubTree {

	public boolean isSubTree(Tnode T, Tnode S) {
		if (S == null)
			return true;
		if (T == null)
			return false;
		if (areEquivalent(T, S))
			return true;
		return (isSubTree(T.lchild, S) || isSubTree(T.rchild, S));
	}

	public boolean areEquivalent(Tnode t, Tnode s) {
		if (t == null && s == null)
			return true;
		if (t == null || s == null)
			return false;
		return ((t.data==s.data)&&areEquivalent(t.lchild, s.lchild) && areEquivalent(t.rchild,
				s.rchild));
	}

	public static void main(String args[])
	{
		Tnode T = new Tnode(26);
		T.lchild = new Tnode(10);
		T.rchild = new Tnode(13);
		T.rchild.rchild = new Tnode(3);
		T.lchild.lchild = new Tnode(4);
		T.lchild.rchild = new Tnode(6);
		T.lchild.lchild.rchild= new Tnode(30);
      
		Tnode S  = new Tnode(10);
	    S.rchild= new Tnode(6);
	    S.lchild= new Tnode(4);
	    S.lchild.rchild= new Tnode(30);
		
		SubTree subTree = new SubTree();
		System.out.println(subTree.isSubTree(T, S));
	}
}
