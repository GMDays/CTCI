package LinkedLists;

public class ReturnKthToLast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node n = new Node(5);
		n.appendToTail(5);
		n.appendToTail(6);
		n.appendToTail(7);
		n.appendToTail(8);
		n.appendToTail(7);
		//System.out.println((KthToLast(n, 2)));
		System.out.println(KthToLastRecursive(n,2));
	}
	
	public static int KthToLast(Node n, int k) {
		Node temp = n;		
		int count = 0;
		while(n.next!=null) {
			count++;
			n = n.next;
		}		
		
		int check = 0;
		while(temp.next!=null) {
			if(count-k<check) {
				System.out.println("We are here");
				return temp.data;
			}
			check++;
			temp = temp.next;			
		}
		
		return n.data;
	}
	
	public static int KthToLastRecursive(Node n, int k) {
		if(n==null) {
			System.out.println("how many times did we get here?");
			return 0;
		}
		
		int count = KthToLastRecursive(n.next, k) + 1;
		System.out.println("Value of count: " + count);
		if(count==k) {
			System.out.println("We found it: " +  n.data);
			//return n.data;
		}
		//System.out.println("How many times did we get here: " + count);
		return count;
	}
}
