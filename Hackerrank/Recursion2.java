package Hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Recursion2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//passwordCracker(new String[] {"gurwgrb", "maqz", "holpkhqx", "aowypvopu"}, "gurwgrb");
		
		System.out.println(hackerlandRadioTransmitters(new int[] {7, 2, 4, 6, 5, 9, 12, 11 }, 2));
	}
	
	static int hackerlandRadioTransmitters(int[] x, int k) {
        // Complete this function
		
		Arrays.sort(x);
		int count = 0;
		int result = 0;
		while(count < x.length-1){
			int diff = x[count+1] - x[count];
			if(diff>count) {
				result++;
			}
			count++;
		}
		
		return result;
    }

	static void passwordCracker(String[] pass, String attempt) {
        // Complete this function
		HashSet<Integer> set = new HashSet<>();
		ArrayList<String> result = new ArrayList<String>();

		if(passwordCracker(pass, attempt, result, set, 0)) {
			for(String s : result) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
		else {
			System.out.println("WRONG PASSWORD");
		}
    }
	
	static boolean passwordCracker(String[] pass, String attempt, ArrayList<String> arrList, HashSet<Integer> set, int index) {
		if(index == attempt.length()) {
			return true;
		}
		
		if(set.contains(index)) {
			return false;
		}
		
		//System.out.println(attempt);
		for(String s : pass) {
			if(attempt.startsWith(s, index)) {
				arrList.add(s);
				if(passwordCracker(pass, attempt, arrList, set, index + s.length())) {
					return true;
				}
				arrList.remove(arrList.size()-1);
				System.out.println();
			}
		}
		
		set.add(index);
		return false;
	}
}
