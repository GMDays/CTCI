package LinkedLists;

import java.util.HashSet;
import java.util.LinkedList;

public class RemoveDups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n = new Node(5);
		n.appendToTail(5);
		n.appendToTail(6);
		n.appendToTail(7);
		n.appendToTail(8);
		n.appendToTail(7);
		deleteDup(n);
		System.out.println(n.printList(n));
	}
	
	public static void deleteDup(Node n) {
		HashSet<Integer> checkInts = new HashSet<Integer>();
		Node previous = null;
		while(n!=null) {
			if(checkInts.contains(n.data)) {
				previous.next = n.next;				
			}
			else {
				checkInts.add(n.data);
				previous = n;
			}
			n = n.next;
		}				
	}
}
