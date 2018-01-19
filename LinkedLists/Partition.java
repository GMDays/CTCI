package LinkedLists;

public class Partition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n = new Node(5);
		n.appendToTail(5);
		n.appendToTail(6);
		n.appendToTail(7);
		n.appendToTail(8);
		n.appendToTail(7);
		//System.out.println((KthToLast(n, 2)));
		
		System.out.println(n.printList(PartitionList(n,10)));
	}
	
	public static Node PartitionList(Node n, int partition) {
		//Node result = null;
		Node less = new Node(0);
		while(n.next!=null) {
			if(n.data < partition) {				
				less.appendToTail(n.data);
			}
		}
		
		//Node greater = new Node(partition);
		while(n.next!=null) {
			if(n.data >= partition) {
				less.appendToTail(n.data);
			}
		}
		
		return less;
	}
}
