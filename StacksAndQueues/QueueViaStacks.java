package StacksAndQueues;

import StacksAndQueues.GenericStack.StackNode;

public class QueueViaStacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueViaStacks q = new QueueViaStacks();
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(6);
		q.enqueue(7);
		System.out.println(q.peek());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
	
	private GenericStack<Integer> head = new GenericStack<Integer>();
	private GenericStack<Integer> tail = new GenericStack<Integer>();

	public void enqueue(int item) {
		//StackNode<Integer> node = new StackNode<Integer>(item);		
		tail.push(item);
	}
	
	public int dequeue() {
		if(head.IsEmpty()) {
			while(!tail.IsEmpty()) {
				int temp = tail.pop();
				head.push(temp);
			}
		}		
		
		return head.pop();
	}
	
	public int peek() {
		if(head.IsEmpty()) {
			while(!tail.IsEmpty()) {
				int temp = tail.pop();
				head.push(temp);
			}
		}
		
		return head.peek();
	}
	
}
