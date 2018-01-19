package LinkedLists;

public class Node {
	
	Node next = null;
	int data;
	
	public Node(int d) {
		data = d;
	}
	
	public String printList(Node n) {
		String result = "";
		while(n != null){            
            result += n.data + " ";
            n = n.next;
        }
        return "List: " + result;
	}
	
	public void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		
		while(n.next!=null) {
			n = n.next;
		}
		n.next = end;
	}
	
	public Node deleteNode(Node head, int d) {
		Node n = head;
		
		if(n.data == d) {
			return head.next;
		}
		
		while(n.next != null) {
			if(n.next != null) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		
		return head;
	}
}
