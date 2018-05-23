package Hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Stack;

public class Stacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(equalStacks(new int[] {1,1,1}, new int[] {4,3,2}, new int[] {1,1,4,1}));
		
		//union(new int[] {2,10,14,19,51,71}, new int[] {2,9,19,40,51});
		
		//System.out.println(twoStacks(10,new int[] {4,2,4,6,1}, new int[] {2,1,8,5}));
		
		//System.out.println(largestRectangle(new int[] {1,2,3,4,5}));
		
		//System.out.println(largestRectangle(new int[] {8979, 4570, 6436, 5083, 7780, 3269, 5400, 7579, 2324, 2116}));  // 26152
		
		
		//print(3, "abc");
		
//		enqueue(42);
//		dequeue();
//		enqueue(14);
//		print();
//		enqueue(28);
//		print();
		
		System.out.println(solve(new int[] {3,2,1,2,3,3}));
	}
	
	static class Entry {
		int count;	
		int value;
		public Entry(int val) {
			value = val;
			count = 1;
		}
	}
	
	static int solve(int[] arr) {
		Stack<Entry> stack = new Stack<>();
		int res = 0;
		int[] vals = new int[arr.length+1];
		for(int i=0; i<arr.length; i++) {
			while(!stack.isEmpty() && stack.peek().value<arr[i]) {
				stack.pop();
			}
			
			if(stack.isEmpty() || stack.peek().value>arr[i]) {
				Entry ent = new Entry(arr[i]);
				stack.push(ent);
			}
			else {
				res += stack.peek().count;
				stack.peek().count+=1;
			}
			
			//System.out.println(res);
		}
		return res * 2;
    }
	
	static Stack<Integer> tail = new Stack<>();
    static Stack<Integer> head = new Stack<>();
    static void enqueue(int val){
        tail.push(val);      
    }
    
    static void dequeue() {
    	if(head.isEmpty()) {
    		while(!tail.isEmpty()) {
        		head.push(tail.pop());
        	}
        	
        	head.pop();        
    	}
    	else {
    		head.pop();
    	}
    }
    
    static void print() {
    	if(head.isEmpty()) {
    		while(!tail.isEmpty()) {
        		head.push(tail.pop());
        	}
        	
    		System.out.println(head.peek());    		
    	}
    	else {
    		System.out.println(head.peek());
    	}
    }
	
	static HashMap<Integer, String> map = new HashMap<>();
    static int order = 0;
    
    static String undo(String s){
        //System.out.println("undo called");
        order--;
        if(map.get(order)!=null){
            s = map.get(order);
        }
        return s;
    }
    static void print(int k, String s) {
		System.out.println(s.charAt(k-1));
	}
    
    static String append(String w, String s){
        order++;
        s += w;
        map.put(order,s);        
        return s;
    }
    
    static String delete(int w, String s){
        order++;
        s = s.substring(0, s.length()- w);        
        map.put(order, s);
        return s;
    }
	
	static long largestRectangle(int[] h) {
		Stack<Integer> heights = new Stack<>();
		Stack<Integer> positions = new Stack<>();
		
		int max = 0;

		int tempH = 0, tempPos = 0;
		for(int i=0; i<h.length; i++) {
			if(heights.isEmpty() || heights.peek()<h[i]) {
				heights.push(h[i]);
				positions.push(i);
			}
			else if(heights.peek() > h[i]){
				//int tempSize = 0;
				while(!heights.empty() && h[i] < heights.peek()) {
					//System.out.println("hello");
					tempH = heights.pop();
					tempPos = positions.pop();	
					int currMax = tempH * (i - tempPos);
					if(currMax>max)
						max = currMax;
				}				
				
				heights.push(h[i]);
				positions.push(tempPos);							
			}					
		}
		
		while(!heights.empty()) {
			tempH = heights.pop();
			tempPos = positions.pop();	
			int currMax = tempH * ((h.length) - tempPos);
			if(currMax>max)
				max = currMax;
		}
		
		return max;
    }
	
	static int twoStacks(int x, int[] a, int[] b) {
        /*
         * Write your code here.
         */

		int currSum = 0;
		int a1 = 0, b1 = 0;
		while(a1<a.length && currSum+a[a1]<=x) {
			currSum+=a[a1];
			a1++;
		}
				
		int res1 = a1;
		while(b1<b.length && a1>=0) {
			currSum+=b[b1];
			b1++;
			while(currSum>x && a1>0) {
				currSum -= a[a1];
				a1--;		
			}
			if(currSum<=x && b1 + a1 > res1) {
				res1 = b1 + a1;
			}
		}
		
		
		return res1; //Math.max(res1, res);
    }
	
	static int[] union(int[] a, int[] b) {
		
		LinkedHashSet<Integer> set = new LinkedHashSet<>();
		
		int i1 = 0, i2 = 0;
		while(i1<a.length && i2<b.length) {
			if(a[i1]<b[i2]) {
				set.add(a[i1]);
				i1++;
			}
			else if(a[i1]>b[i2]) {
				set.add(b[i2]);
				i2++;			
			}
			else {
				set.add(b[i2]);
				i1++;
				i2++;
			}
		}
		
		System.out.println(set.toString());
		return null;
	}
	
	static int equalStacks(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */        
        
        int sum1 = 0;
        for(int i=h1.length-1;i>=0;i--) {
        	sum1 += h1[i];
        	h1[i] = sum1;
        }
        
        int sum2 = 0;
        for(int i=h2.length-1;i>=0;i--) {
        	sum2 += h2[i];
        	h2[i] = sum2;
        }
        
        int sum3 = 0;
        for(int i=h3.length-1;i>=0;i--) {
        	sum3 += h3[i];
        	h3[i] = sum3;
        }
        
        int indexh1 = 0;
        int indexh2 = 0;
        int indexh3 = 0;
        while(h1[indexh1]!= h2[indexh2] || h2[indexh2] != h3[indexh3]) {
        	if((h1[indexh1]>h2[indexh2] || h1[indexh1]>h3[indexh3]) && indexh1 < h1.length-1) {
        		indexh1++;
        	}
        	else if((h2[indexh2]>h1[indexh1] || h2[indexh2]>h3[indexh3]) && indexh2 < h2.length-1) {
        		indexh2++;
        	}
        	else if((h3[indexh3]>h1[indexh1] || h3[indexh3]>h2[indexh2]) && indexh3 < h3.length-1){
        		indexh3++;
        	}
        	else {
        		h1[indexh1] = 0;
        		break;
        	}
        }
        
        return h1[indexh1];
    }

}
