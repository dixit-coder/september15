package com.divesh.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StringReduction {
	public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        String[] input = new String[T];
        for (int i = 0; i < T; i++) {
            input[i]=br.readLine();
        }
        // input over
        MyStack stack ;
        for(String str: input)
        {   stack = new MyStack();
        	for(char x : str.toCharArray())
        	{
        		stack.push(x);
        		stack.process();
        	}
        	System.out.println(stack.size());
        }
        
         
    }
}

class MyStack extends Stack<Character> {
	private Map<String, Character> map;

	public MyStack() {
		super();
		this.map = new HashMap<String, Character>();
		map.put("ab", 'c');
		map.put("ba", 'c');
		map.put("ac", 'b');
		map.put("ca", 'b');
		map.put("bc", 'a');
		map.put("cb", 'a');
	}

	public void process() {
		Character top;
		Character secTop;
		if (this.size() > 1) {
			top = this.pop();
			secTop = this.pop();
		} else
			return;
		String key = top +""+ secTop;
		while (map.get(key) != null) {
			this.push(map.get(key));
			if (this.size() > 1) {
				top = this.pop();
				secTop = this.pop();
				key = top +""+ secTop;
			}
			else
			{
				return;
			}
		}
		this.push(secTop);
		this.push(top);
	}
}
