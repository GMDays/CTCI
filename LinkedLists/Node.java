package LinkedLists;

import java.util.Stack;

public class Node {
	
	Node next = null;
	int data;
	Node prev = null;
	
	public Node(int d) {
		data = d;
	}
	
	Node SortedInsertDoubly(Node head,int data) {
	    Node n = new Node(5);
	    n.data = data;

	    if(head == null || head.data > data){
	        n.next = head;
	        head.prev = n;
	        return n;
	    }
	    
	    Node curr = head;
	    Node prev = null;
	    while(curr!=null && curr.data < data){        
	        prev = curr;
	        curr = curr.next;       
	    }
	    
	    if(curr==null){ // insert at end of list
	        prev.next = n;
	        n.prev = prev;
	    }
	    else{ // insert in the middle of the list
	        n.data = data;            
	        n.next = curr;
	        n.prev = prev;
	        prev.next = n;
	        curr.prev = n;
	    }      
	    return head;   
	}
	
	Node ReverseDoublyLinked(Node head) {
	    // if(head==null || head.next==null){
	    //     return head;
	    // }
	    
	    Node temp = head;
	    Node ret = head;
	    while(temp!=null){
	        Node tempPrev = temp.prev;
	        temp.prev = temp.next;
	        temp.next = tempPrev;
	        ret = temp;
	        temp = temp.prev;
	    }
	    return ret;
	}
	
	Node RemoveDuplicates(Node head) {
		if(head==null || head.next==null) {
			return null;
		}
		
		Node curr = head;
		
		while(head.next!=null) {
			if(head.next.data==head.data) {
				head.next = head.next.next;
			}
			else {
				head = head.next;
			}
		}
		
		return curr;
	}
	
	int GetNode(Node head,int n) {
	  	// This is a "method-only" submission. 
	  	// You only need to complete this method. 
	    int index = 0;
	    Node temp = head;
	    Node result = head;
	    while(temp!=null){
	        temp = temp.next;
	        if(index++>n){
	            result = result.next;
	        }
	    }
	    
	    return result.data;
	}
	
	Node mergeLists(Node headA, Node headB) {
	  	// This is a "method-only" submission. 
	  	// You only need to complete this method 
		if(headA==null&&headB==null) {
			return null;
		}
		
		Node res = headA.data < headB.data ? headA : headB;
		while(headA!=null || headB!=null){
			if(headA!=null && headB!=null) {
				if(headA.data<headB.data) {
					res.next = headA;
					headA = headA.next;
				}
				else {
					res.next = headB;
					headB = headB.next;
				}
				//res.next = headA.data < headB.data ? headA : headB;
				
			}
			else if(headA!=null) {
				res.next = headA;
				headA = headA.next;
			}
			else if(headB!=null) {
				res.next = headB;
				headB = headB.next;
			}	        
	    }
		
		res.next = null;
		return res;
	}
	
	int CompareLists(Node headA, Node headB) {
	    // This is a "method-only" submission. 
	    // You only need to complete this method 
		while(headA!=null && headB!=null && headA.data == headB.data){
	        headA = headA.next;
	        headB = headB.next;
	    }
		
		return headA == headB ? 1 : 0;
	}
	
	Node Reverse(Node head) {
	    Stack<Node> stack = new Stack<Node>();
	    while(head.next != null){
	        stack.push(head);
	        head=head.next;
	    }
	    Node res = head;
	    while(!stack.empty()){
	        head.next=stack.pop();
	        head=head.next;
	    }
	    head.next = null;
	    return res;
	}
	
	Node ReverseRecurse(Node head) {
	    if(head==null || head.next==null) {
	    	return head;
	    }
	    
	    Node rem = ReverseRecurse(head.next);
	    
	    //fix pointer to original next of header
	    head.next.next = head;
	    head.next = null;
	    return rem;
	}
	
	static void printReverse(Node head) {
		if(head==null) {
			return;
		}
		
		printReverse(head.next);
		System.out.println(head.data);
	}
	
	Node Delete(Node head, int position) {
		  // Complete this method
		    if(position==0){
		        return head.next;
		    }
		    
		    int index = position;
		    Node currNode = head;
		    Node prevNode = head;	
		    
			while(index - 1 > 0) {
				prevNode = currNode;
				currNode = currNode.next;
			    index--;
			}	    
			    
		    prevNode.next = currNode.next;			
			    
			return head;
		}
	
	Node DeleteRecurse(Node head, int position) {
		if(position==0) {
			return head.next;
		}
		
		head.next = DeleteRecurse(head.next, position - 1);
		return head;
	}
	
	Node InsertNth(Node head, int data, int position) {
		// This is a "method-only" submission. 
	    // You only need to complete this method.
		
		Node currHead = new Node(data);
		currHead.data = data;
		
		if(head==null) {
			return currHead;
		}
		
		if(position==0) {
			currHead.next = head;
			return currHead;
		}
		
		int index = position;
        Node header = head;
	    while(index - 1 > 0) {
	    	header = header.next;
	    	index--;
	    }	    
	    
	    currHead.next = header.next;
	    header.next = currHead;
	    
	    return head;
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
