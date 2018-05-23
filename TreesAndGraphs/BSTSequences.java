package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class BSTSequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node2 = new TreeNode(2);
		node2.SetLeftChild(new TreeNode(1));
		node2.SetRightChild(new TreeNode(3));
		
		BSTSequences bst = new BSTSequences();
		System.out.println(bst.sequences(node2));
	}
	
	public ArrayList<LinkedList<Integer>> sequences(TreeNode root){
		ArrayList<LinkedList<Integer>> res = new ArrayList<LinkedList<Integer>>();		
		if(root==null) {
			res.add(new LinkedList<Integer>());
			return res;
		}
		
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(root.data);
		
		ArrayList<LinkedList<Integer>> leftSeq = sequences(root.left);
		ArrayList<LinkedList<Integer>> rightSeq = sequences(root.right);
		
		for(LinkedList<Integer> iter: leftSeq) {
			for(LinkedList<Integer> iter2: rightSeq) {
				ArrayList<LinkedList<Integer>> weave = new ArrayList<LinkedList<Integer>>();		
				WeaveLists(iter, iter2, weave, prefix);
				res.addAll(weave);
			}
		}
		
		return res;
	}
	
	public void WeaveLists(LinkedList<Integer> list1, LinkedList<Integer> list2, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {		
		if(list1.isEmpty() || list2.isEmpty()) {
			//results.add(remainder);
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(list1);
			result.addAll(list2);
			results.add(result);
			return;
		}
		
		// remove head from 1st list and add to prefix. recurse, then repair.
		int head1 = list1.removeFirst();
		prefix.addLast(head1);
		WeaveLists(list1, list2, results, prefix);
		prefix.removeLast();
		list1.addFirst(head1);
		
		// remove head from 2nd list and add to prefix. recurse, then repair.
		int head2 = list2.removeFirst();
		prefix.addLast(head2);
		WeaveLists(list1, list2, results, prefix);
		prefix.removeLast();
		list2.addFirst(head2);		
	}
}
