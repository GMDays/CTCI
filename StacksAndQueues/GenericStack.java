package StacksAndQueues;

import java.util.EmptyStackException;

public class GenericStack<T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericStack<Integer> stack = new GenericStack<Integer>();
		stack.push(5);
		stack.push(2);
		stack.push(3);
		stack.push(1);
		System.out.println(stack.getMin());
		System.out.println(stack.toString());
	}
	
	public static class StackNode<T>{
		private T data;
		private StackNode<T> prev;
		
		public StackNode(T data) {
			this.data = data;
		}
	}
	
	private StackNode<T> top;
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
			}
		}
		else {
			min = newNode;
		}
		newNode.prev = top;
		top = newNode;		
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
