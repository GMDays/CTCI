package Hackerrank;

import java.util.HashMap;
import java.util.HashSet;

public class Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(twoCharaters("beabeefeab"));
		//separateNumbers("1234");
		
		//System.out.println(camelcase("saveChangesInTheEditor"));
		//System.out.println(super_reduced_string("aaabccddd"));
		
		//System.out.println(palindromeIndex("abcba"));
		
		//System.out.println(anagram("xaxbbbxx"));
		
		System.out.println(gameOfThrones("cdcdcdcdeeeef"));
	}
	
	static String gameOfThrones(String s){
        // Complete this function
		HashMap<Character, Integer> map = new HashMap<>();
		for(char c : s.toCharArray()) {
			if(!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c)+1);
		}
		
		int count=0;
		for(Character key : map.keySet()) {
			if(map.get(key)%2!=0) {
				if(s.length()%2==0 || count>1) {
					return "NO";
				}
				count++;
			}			
		}
		
		return "YES";
    }
	
	static int anagram(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		if(s.length()%2!=0) {
			return -1;
		}
		char[] chars = s.toCharArray();
		for(int i=0;i<s.length()/2;i++) {
			if(!map.containsKey(chars[i])) {
				map.put(chars[i], 0);
			}
			map.put(chars[i], map.get(chars[i])+1);
		}			
		
		int count=0;
		for(int i=s.length()/2;i<s.length();i++) {
			if(!map2.containsKey(chars[i])) {
				map2.put(chars[i], 0);
			}
			map2.put(chars[i], map2.get(chars[i])+1);
		}
			
		for(int i=s.length()/2;i<s.length();i++) {
			if(map.containsKey(chars[i])) {
				map.put(chars[i], map.get(chars[i])-1);
			}
		}
		
		for(Character key : map.keySet()) {
			if(map.get(key)>0) {
				count+=map.get(key);
			}
		}		
		
		return count;
	}
	
	static int palindromeIndex(String s){
        // Complete this function
		if(s.length()==1) {
			return -1;
		}
		
		int low = 0;
		int high = s.length()-1;
		char[] chars = s.toCharArray();
		while(high>=low) {
			if(chars[low]!=chars[high]) {
				if(chars[low+1]==chars[high] && chars[low+2]==chars[high-1]) {
					return low;
				}
				else {
					return high;
				}
			}			
			high--;
			low++;
		}
		
		return -1;
    }
	
	static boolean isPalindrome(String s) {
		System.out.println(s);
		if(s.length()==1) {
			return true;
		}
		
		int low = 0;
		int high = s.length()-1;
		char[] chars = s.toCharArray();
		while(high>=low) {
			if(chars[low]!=chars[high]) {
				return false;
			}
			high--;
			low++;
		}
		
		return true;
	}
	
	static String super_reduced_string(String s){
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		for(int i=1;i<sb.length();i++) {
			if(sb.charAt(i)==sb.charAt(i-1)) {
				sb.delete(i-1, i+1);
				i=0;
			}
		}
		//if(s.length()%2!=0) sb.append(s.substring(s.length()-1));
		return sb.toString().equals("") ? "Empty String" : sb.toString();
	}
	
	static int camelcase(String s) {
        // Complete this function
		int count=0;
		for(char c : s.toCharArray()) {
			if(Character.isUpperCase(c)) {
				count++;
			}
		}
		return count+1;
    }
	
	static void separateNumbers(String s) {
        // Complete this function
		if(s.length()<=1) {
			System.out.println("NO");
		}
		
		int count = 0;
		for(int i=0;i<s.length();i++) {
			count++;
			boolean no = false;
			for(int j=i+1;j<s.length()-1;j++) {
				//System.out.println("this count: " + j);
				int num1 = Integer.valueOf(s.substring(i, j));
				int num2 = Integer.valueOf(s.substring(j, j+1));
				System.out.println(num2);
				if(num1%10==9) {
					num2 = Integer.valueOf(s.substring(j, j+2));
				}
				if(num2-num1!=1) {
					no = true;					
				}
			}
			if(!no) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
    }
	
	static int twoCharaters(String s) {
        // Complete this function		
		HashSet<Character> set = new HashSet<Character>();
		for(int i=0;i<s.length();i++) {
			set.add(s.charAt(i));
		}
		
		int max = 0;
		for(char c: set) {
			for(char c2 : set) {
				if(c==c2) continue;
				int n = countAlternate(c, c2, s);
				if(n>max) {
					max=n;
				}
			}
		}
		
		return max;
    }

	static int countAlternate(char c1, char c2, String s) {
		boolean last_c1 = false;
		boolean last_c2 = false;
		int localMax = 0;
		for(char c : s.toCharArray()) {
			if(c==c1) {
				if(last_c1) return 0;
				localMax++;
				last_c1=true;
				last_c2=false;
			}
			if(c==c2) {
				if(last_c2) return 0;
				localMax++;
				last_c1=false;
				last_c2=true;
			}
		}
		return localMax;
	}

}
