package LinkedLists;

public class Partition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n = new Node(5);
		n.appendToTail(5);
		n.appendToTail(6);
		n.appendToTail(2);
		n.appendToTail(2);
		n.appendToTail(3);
		//System.out.println((KthToLast(n, 2)));
		
		Node n2 = PartitionList(n,6);
		System.out.println(n.printList(n2));
	}
	
	public static Node PartitionList(Node n, int partition) {
		//Node result = null;
		Node tail = n;
		Node head = n;
		while(n!=null) {
			Node next = n.next;
			if(n.data < partition) {				
				n.next = head;
				head = n;
			}
			else {
				tail.next = n;
				tail = n;
			}
			n = next;
		}
		
		//Node greater = new Node(partition);
//		while(n.next!=null) {
//			if(n.data >= partition) {
//				less.appendToTail(n.data);
//			}
//		}
		tail.next = null;
		//n = less;
		return head;
	}
}
