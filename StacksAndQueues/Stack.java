/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StacksAndQueues;

import java.util.EmptyStackException;

/**
 *
 * @author salla010
 */
public class Stack {
    public static void main(String[] args){
    	Stack st = new Stack(3);
        st.push(5);
        st.push(6);
        st.push(2);
        
        st.pop();
        st.pop();
        st.pop();
        
        //System.out.println(st.Peek());
        System.out.println(st.IsEmpty());        
        //System.out.println(st.toString());
        System.out.println(st.min(st));
    }
    
    public int[] stack;
    int origSize = 0;
    private int count;
    
    public Stack(int size){
        origSize = size;
        stack = new int[size];        
        count = -1;
    }
    
    public void push(int newVal){        //
        if(count+1>=origSize){
            System.out.println("Array is full");
            //return;
        }
        else{
            count++;
            stack[count] = newVal;       
        }                 
    }
    
    public void pop(){
        if(count==-1){
            System.out.println("Array is empty");
        }
        else{
            count--;   
        }                           
    }
    
    public int min(Stack st){
        int result = Integer.MAX_VALUE;
        for(int i = 0; i<origSize;i++){
            if(st.stack[i]<result){
                result = st.stack[i];
            }
        }        
        return result;
    }
    
    public boolean IsEmpty() {
    	return count == -1;
    }
    
    public int Peek() {
    	if(count<0) {
    		throw new EmptyStackException();
    	}
    	return stack[count];
    }
    
    @Override
    public String toString(){
        String res = "";
        for(int i=0; i<=count;i++){
            res += stack[i] + " ";
        }
        return res;
    }       
}



