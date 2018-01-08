package Strings;

public class PalindromePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(IsPalindromeParmutation("ecarcar"));
		System.out.println(IsPalindromePermutationCaseInsensitive("Tact Coa"));
	}
	
	public static boolean IsPalindromeParmutation(String s) {
		int maxLen = s.length();
		boolean res = true;
		
		int[] letters = new int[128];
		int count = 0;
		
		for(int i=0; i<s.length(); i++) {
			letters[s.charAt(i)]++;
			if(letters[i] % 2 != 0) {
				count++;
			}
			else {
				count--;
			}
		}
				
		if(count>1) {
			res = false;
		}
		
		return res;				
	}
	
	public static boolean IsPalindromePermutationCaseInsensitive(String s) {
		int[] freq = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		int count = 0;
		
		for(int i=0; i<s.length(); i++) {
			int x = getCharNum(s.charAt(i));
			if(x!=-1) {
				freq[x]++;
				if(freq[x]%2==0) {
					count--;
				}
				else {
					count++;
				}
			}
		}
		
		if(count>1) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static int getCharNum(char c) {
		int z = Character.getNumericValue('z');
		int a = Character.getNumericValue('a');
		int val = Character.getNumericValue(c);
		
		if(a<=val && val<=z) {
			return val - a;
		}
		return -1;		
	}

}
