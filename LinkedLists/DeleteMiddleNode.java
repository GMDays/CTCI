package LinkedLists;

public class DeleteMiddleNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n = new Node(5);
		n.appendToTail(5);
		n.appendToTail(6);
		n.appendToTail(7);
		n.appendToTail(8);
		n.appendToTail(7);
		//System.out.println((KthToLast(n, 2)));
		deleteMiddle(n,6);
		System.out.println(n.printList(n));
	}
	
	public static void deleteMiddle(Node n, int num) {
		Node previous = null;
		while(n.next!=null) {
			if(n.data == num) {
				previous.next = n.next;
			}
			else {
				previous = n;
			}
			n = n.next;
		}
	}

}
