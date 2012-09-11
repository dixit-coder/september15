package com.divesh.core;

import java.util.Stack;

public class BSTwithNonLeafNodeSingleChild {
	private Stack<Integer> stack = new Stack<Integer>();
	/**Not working, attempted first time*/
	public  boolean isNonLeafNodeSingleChile2(int[] preOrderBST)
	{
		if(preOrderBST.length==1)
		{
			return true;
		}
		
		for(int i=0;i<preOrderBST.length-2;i++)
		{   
			
			if(stack.size()>0)
			{   
				if (preOrderBST[i] > stack.peek())
					{
					  stack.pop();
					} 
				
			}
			// check for the leaf node
			if (i == 0) {
				stack.push(preOrderBST[i]);
				continue;
			}
			if (preOrderBST[i] < preOrderBST[i - 1]
					&& preOrderBST[i] < preOrderBST[i + 1]) {
				continue;
			}
			
			/**check for  nonLeaf Node Ex.==> 2  
			 *           2
			 *         1   3
			 * preorder==>  213
			 */    
           if(preOrderBST[i]<preOrderBST[i+2] && preOrderBST[i]>preOrderBST[i+1])
           {
        	   continue;
           }
           
           stack.push(preOrderBST[i]);
           System.out.println("Stack==>"+stack);
		}
		System.out.println("Nodes :"+stack);
		return stack.size()>0?false:true;
	}
	/** working, attempted secound time*/
	public  boolean isNonLeafNodeSingleChile(int[] preOrderBST)
	{
		int size = preOrderBST.length;
		int min = preOrderBST[size - 1], max = preOrderBST[size - 1];
		for(int i =size-2;i>=0;i--)
		{
			if (preOrderBST[i] > preOrderBST[i + 1]) {
				if (!(preOrderBST[i] > max))
					return false;
				max = preOrderBST[i];
			} else {
				if (!(preOrderBST[i] < min))
					return false;
				min = preOrderBST[i];
			}
		}
		return true;
	}
	/** working, attempted third time*/
	public boolean isNonLeafNodeSingleChile1(int[] preOrderBST) {
		int size = preOrderBST.length;
		for (int i = 0; i < size - 1; i++) {
			int x = preOrderBST[i] - preOrderBST[i + 1];
			int y = preOrderBST[i] - preOrderBST[size - 1];
			if ((x * y) < 0)
				return false;
		}
		return true;
	}
	
	public static void main(String args[])
	{
		BSTwithNonLeafNodeSingleChild BSTsingleChild = new BSTwithNonLeafNodeSingleChild();
		//int a[]={20,10,11,13,12};
		//int a[]={6,4,2,5,10,9};
		int a[]={8,7,9};
		System.out.println(BSTsingleChild.isNonLeafNodeSingleChile1(a));
	}
}
