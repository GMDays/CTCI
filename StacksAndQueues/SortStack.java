package StacksAndQueues;

import java.util.EmptyStackException;

public class SortStack<T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortStack<Integer> stack = new SortStack<Integer>();
		stack.push(2);
		//System.out.println(stack.peek());
		stack.push(5);
		System.out.println(stack.peek());
		stack.push(3);
		stack.push(1);
		//System.out.println(stack.getMin());
		System.out.println(stack.peek());
	}
	
	public static class StackNode<T>{
		public T data;
		public StackNode<T> prev;
		
		public StackNode(T data) {
			this.data = data;
		}
	}
	
	private StackNode<T> top;
	private StackNode<T> temp;
	private StackNode<T> min;
	
	public T pop() {
		if(top==null) {
			throw new EmptyStackException();
		}
		
		if(min!=null) {
			if(((Comparable)min.data).compareTo((Comparable)top.data)>0) {
				min = top;
			}
		}
		T item = top.data;
		top = top.prev;
		return item;
	}
	
	public void push(T item) {
		StackNode<T> newNode = new StackNode<T>(item);
		if(min!=null) {
			if(((Comparable)min.data).compareTo((Comparable)newNode.data)>0) {				
				min = newNode;
				newNode.prev = top;
				top = newNode;					
			}
			else {			
				while(top!=null) {	
					if(((Comparable)newNode.data).compareTo((Comparable)top.data)>0) {
						T tempItem = pop();
						StackNode<T> tempNode = new StackNode<T>(tempItem);
						tempNode.prev = temp;
						temp = tempNode;
					}
					else {
						break;
					}
				}
				min = newNode;
				newNode.prev = top;
				top = newNode;	
				fixStack();
			}
		}
		else {
			min = newNode;
			newNode.prev = top;
			top = newNode;	
		}
		//newNode.prev = top;
		//top = newNode;		
	}
	
	public void fixStack() {
		//System.out.println("How many times");
		while(temp!=null) {
			T item = temp.data;
			temp = temp.prev;
			push(item);
		}
	}
	
	public boolean IsEmpty() {
		return top==null;
	}
	
	public T peek() {
		if(top==null) {
			throw new EmptyStackException();
		}
		return top.data;
	}
	
	public T getMin() {
		if(min==null) {
			throw new EmptyStackException();
		}
		return min.data;
	}
}
