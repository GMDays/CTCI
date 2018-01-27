package StacksAndQueues;

import java.util.ArrayList;

class MultiStacks {
    int head = 0;
    int limit = 0;
    GenericStack<Integer> single;
    ArrayList<GenericStack<Integer>> plates;
    
    public static void main(String[] args){
        MultiStacks stacks = new MultiStacks(3);
        stacks.push(5);
        stacks.push(2);
        stacks.push(1);
        stacks.push(3);
        stacks.push(4);
        stacks.push(6);
        stacks.push(7);
        
        stacks.popAt(2);
        
        for(GenericStack<Integer> st : stacks.plates){
            System.out.println(st.toString());
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