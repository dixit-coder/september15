package com.divesh.core;

import java.util.Stack;

public class BSTwithNonLeafNodeSingleChild {
	private Stack<Integer> stack = new Stack<Integer>();
	private int tmp;
	public  boolean isNonLeafNodeSingleChile(int[] preOrderBST)
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
	
	public static void main(String args[])
	{
		BSTwithNonLeafNodeSingleChild BSTsingleChild = new BSTwithNonLeafNodeSingleChild();
		//int a[]={4,3,1,2,5};
		int a[]={6,4,2,5,10,9};
		System.out.println(BSTsingleChild.isNonLeafNodeSingleChile(a));
	}
}
