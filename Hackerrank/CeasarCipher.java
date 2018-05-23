package Hackerrank;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class CeasarCipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CeasarCipher cipher = new CeasarCipher();
		//System.out.println(cipher.GetCeasarCipher(5, "zabc", 2));
		//System.out.println(cipher.changed("TOSSOSSOSTOT"));
		//System.out.println(cipher.hackerRank("hackerworldrankkkkk"));
		//System.out.println(cipher.IsItPangram("a"));
		//System.out.println(cipher.maxPalindrome("abab", 1, 4));
		//System.out.println(cipher.UniformString("abccddde", 12));
		//System.out.println(Arrays.toString(cipher.IceCreamParlor(new int[] {2,2,4,3} , 4)));
		//System.out.println(counting(new int[] {1,2,3,1}));
		//System.out.println(cakeWalk(new int[] {1,3,2}));
		
		System.out.println(cipher.gridChallenge(new String[] { "uxf", "vof", "hmp" }));
	}
	
	public String gridChallenge(String[] grid) {
		int rows = grid.length;
		int cols = grid[0].length();
		char[][] dp = new char[rows][rows];
        for(int i=0;i<rows;i++){
            char[] letters = grid[i].toCharArray();
            Arrays.sort(letters);            
            for(int j=0;j<cols;j++) {            	
            	dp[i][j] = letters[j];            	
            }
        }
        System.out.println(Arrays.deepToString(dp));
        for(int i=0;i<rows;i++) {
        	for(int j=0;j<cols-1;j++) {
        		if(dp[j][i]>dp[j+1][i]) {
            		return "NO";
            	}
        	}
        }
        
        System.out.println(Arrays.deepToString(dp));
        return "YES";
	}
	
	public static long cakeWalk(int[] calorie) {
		Arrays.sort(calorie);
		calorie = reverse(calorie);
		int length = calorie.length;
		long sum = 0L;
		for(int i=0;i<length;i++) {
			sum += Math.pow(2, i) * calorie[i];
			System.out.println(sum);
		}
		
		return sum;
	}
	
	public static int[] reverse(int[] arr) {
		for(int i =0; i < arr.length / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - i -1];
			arr[arr.length - i - 1] = temp;
		}
		
		return arr;
	}
	
	public static int[] counting(int[] arr) {
		int length = arr.length;		
		
		int count[] = new int[99];
		for(int i=0; i<length; i++) {
			count[arr[i]]++;
		}
		System.out.println(Arrays.toString(count));
	    return count;
	}
	
	public int[] IceCreamParlor(int[] arr, int m) {
		int[] backup = Arrays.copyOf(arr,arr.length);
		Arrays.sort(backup);
		int[] res = new int[2];
		int num1 = -1;
		int num2 = -1;
		for(int i=0;i<arr.length;i++) {
			num2 = m - arr[i];
			if(binarySearch(backup, num2)!= -1) {			
				//System.out.println(num1);
				res[0] = i+1;	
				break;
			}
		}
		//System.out.println(num1);
		//System.out.println(num2);
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==num2) {
				res[1] = i+1;
			}
		}
		//res[1] = num2;
		Arrays.sort(res);
		return res;
	}
	
	public int binarySearch(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;
		while(low<=high) {
			int mid = low + (high - low) / 2;
			if(arr[mid]>target) {
				high = mid - 1;
			}
			else if(arr[mid]<target) {
				low = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
	
	public String GetCeasarCipher(int length, String encoded, int rotate) {
		char[] letters = new char[26];
		StringBuilder result = new StringBuilder();
		int z = (int)'z';
		int a = (int)'a';
		
		for(char c : encoded.toCharArray()) {
			if(Character.isLetter(c)) {
				if(Character.isUpperCase(c)) {
					result.append((char) ('A' + (c - 'A' + rotate) % 26));
				}
				else {
					result.append((char) ('a' + (c - 'a' + rotate) % 26));
				}
			}
			else {
				result.append(c);
			}
		}
		
		return result.toString();
	}
	
	public static int changed(String s) {
		int result = 0;
		int length = s.length();
		char[] letters = s.toCharArray();
		for(int i = 0; i<length;i+=3) {			
			if(i%3==0) {
				if(letters[i]!='S') {
					result++;
				}
				if(letters[i+1]!='O') {
					result++;
				}
				if(letters[i+2]!='S') {
					result++;
				}
			}
		}
		return result;
	}
	
	public String hackerRank(String s) {
		String h = "hackerrank";
		LinkedList<Character> q = new LinkedList<>();
		for(char c : h.toCharArray()) {
			q.add(c);
		}
		
		for(char c : s.toCharArray()) {
			if(q.isEmpty()) {
				return "YES";
			}
			else if(c==q.peek()) {
				q.removeFirst();
			}
		}
		if(q.isEmpty()) {
			return "YES";
		}
		else {
			return "NO";
		}
	}
	
	public String IsItPangram(String s) {
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		for(char c : s.toCharArray()) {
			if(c != ' ') {
				if(!map.containsKey(String.valueOf(c).toLowerCase())) {
					map.put(String.valueOf(c).toLowerCase(), true);
				}
			}		
		}
		if(map.size()==26) {
			return "pangram";
		}
		else {
			return "not pangram";
		}
	}
	
	public int maxPalindrome(String s, int l, int r) {
		String res = s.substring(l,r);
		int length = s.length();
		int[][] dp = new int[r][r];
		
		for(int i=0;i<length;i++) {
			dp[i][i] = 1;
		}
		
		for(int len=2;len<=length;len++) {
			for(int i=0;i<length-len+1;i++) {
				int j = i+len-1;
				if(s.charAt(i)!=s.charAt(j)) {
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
				}
				else if(len==2 && s.charAt(i)==s.charAt(j)) {
					dp[i][j] = 2;
				}
				else {
					dp[i][j] = dp[i+1][j-1] + 2;
				}
			}
		}
		//System.out.println(Array.dp);
		int maxVal = 0;
		HashMap<Integer,Integer> storeMax = new HashMap<Integer,Integer>();
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				if(dp[i][j]>maxVal) {
					maxVal=dp[i][j];
					int lastVal = storeMax.get(maxVal)==null ? 0 : storeMax.get(maxVal);
					lastVal++;
					storeMax.put(maxVal, lastVal);
				}
			}
		}
		System.out.println(storeMax);
		return storeMax.get(maxVal);
	}
	
	public static String UniformString(String s, int n) {
		int length = s.length();
		char prev = ' ';
		Set<Integer> numList = new HashSet<Integer>();
		int mult = 0;
		for(int i=0; i<length; i++) {	
			int temp = s.charAt(i) - 'a' + 1;			
			if(s.charAt(i)==prev) {
				mult++;
			}
			else {
				mult=1;
				prev = s.charAt(i);
			}	
			numList.add(mult*temp);
		}
		
		if(numList.contains(n)) {
			return "Yes";
		}
		return "No";
	}
}
