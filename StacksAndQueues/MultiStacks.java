package StacksAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;


class MultiStacks {
    int head = 0;
    int limit = 0;
    GenericStack<Integer> single;
    ArrayList<GenericStack<Integer>> plates;
    
    public static void main(String[] args){
//        MultiStacks stacks = new MultiStacks(3);
//        stacks.push(5);
//        stacks.push(2);
//        stacks.push(1);
//        stacks.push(3);
//        stacks.push(4);
//        stacks.push(6);
//        stacks.push(7);
//        
//        stacks.popAt(2);
//        
//        for(GenericStack<Integer> st : stacks.plates){
//            System.out.println(st.toString());
//        }

    	System.out.println(isBalanced("}][}}(}][))]"));
    	
//    	insert("hack");
//    	insert("hackerrank");
//    	System.out.println(find("hac"));
//    	System.out.println(find("hak"));
    	
    	System.out.println(Arrays.toString(contacts(new String[][] { {"add", "s"}, {"add", "ss"}, {"add", "sss"}, {"add","ssss"}, {"add","sssss"}, {"find","s"},{"find","ss"},{"find","sss"},{"find","ssss"},{"find","sssss"},{"find","ssssss"}})));
    }
    
    static HashMap<String, Integer> map = new HashMap<>();
    static int[] contacts(String[][] queries) {
        /*
         * Write your code here.
         */
    	System.out.println(Arrays.deepToString(queries));
    	int find = 0;
    	for(int i=0; i<queries.length; i++) {
    		if(queries[i][0]=="add") {
    			insert(queries[i][1]);
    		}
    		else if(queries[i][0]=="find") {
    			find++;
    		}
    	}
    	
    	int[] res = new int[find];
    	int index = 0;
    	for(int i=0; i<queries.length; i++) {
    		if(queries[i][0]=="find") {
    			int result = find(queries[i][1]);
    			res[index] = result;
    			index++;
    		}
    	}
    	
    	System.out.println(queries[0][0]);
    	return res;
    }
    
    static int find(String partial) {
    	if(map.containsKey(partial)) {
    		return map.get(partial);
    	}
    	else {
    		return 0;
    	}
    }
    
    
    static void insert(String word) {
    	String[] split = word.split("\\s+");
    	//System.out.println(Arrays.toString(split));
    	for(String w : split) {
    		for(int j=0; j<w.length(); j++) {
        		String s = w.substring(0, j+1);
        		if(!map.containsKey(s)) {
        			map.put(s, 0);
        		}
        		map.put(s, map.get(s) + 1);
        	}        	        
    	}    	
    	//System.out.println(map);
    }
    
    static String isBalanced(String s) {
        // Complete this function
    	
    	Stack<Character> st = new Stack<>();
    	if(s.length()%2!=0) {    		
    		return "NO";
    	}
    	
    	for(int i=0; i<s.length(); i++) {
    		if(!st.empty()) {
    			if(s.charAt(i)==')' && st.peek()=='(') {
        			st.pop();
        		}
        		else if(s.charAt(i)=='}' && st.peek()=='{') {
        			st.pop();
        		}
        		else if(s.charAt(i)==']' && st.peek()=='[') {
        			st.pop();
        		}
        		else {
        			st.push(s.charAt(i));
        		}
    		}    		
    		else {
    			st.push(s.charAt(i));
    		}    		
    	}
    	
    	if(st.empty()) {
    		return "YES";
    	}
    	else {
    		return "NO";
    	}    	
    }
    
    public MultiStacks(int threshold){
        limit = threshold;
        plates = new ArrayList<>();
        single = new GenericStack<Integer>();
        plates.add(single);
        //head = -1;
    }
    
    public void push(int val){
        //int count = 0;
        if(head>=limit){
            single = new GenericStack<Integer>();
            single.push(val);
            plates.add(single);
            head = 0;
        }
        else{
            single.push(val);
        }

        head++;
    }       
    
    public void popAt(int index){
        //int count = 0;
    	GenericStack<Integer> st = plates.get(index);
        if(st!=null){
            st.pop();
        }
        else{
            System.out.println("This stack does not exist.");
        }
    }
      
}