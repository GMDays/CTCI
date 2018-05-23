package Hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(minimumLoss(new long[] {20, 7, 8, 2, 5}));
		//System.out.println(connectedCell(new int[][] { {1, 1, 0, 0}, {0,1,1,0}, {0,0,1,0}, {1,0,0,0} }));
		
		//System.out.println(hackerlandRadioTransmitters(new int[] {9, 5, 4, 2, 6, 15, 12}, 2));
		
		//System.out.println(gridlandMetro(Long.valueOf(5),(long)5,7, new int[][] {{1,1,2},{1,4,4},{2,1,1},{2,2,3},{2,4,5},{4,1,2},{4,4,5}}) );
		
		List<String> s = new ArrayList<>();
		s.add("and");
		s.add("he");
		s.add("the");
		s.add("to");
		s.add("is");
		retrieveMostFrequentlyUsedWords("jack and jill went to the market to buy bread and cheese cheese is jack favorite food", s);
	}
	
	
	public List<String> reorderLines(int logFileSize, List<String> logLines) 
	{
		// WRITE YOUR CODE HERE
		//List<String> identifiers = new ArrayList<>();
		List<String> letterVals = new ArrayList<>();
		List<String> numVals = new ArrayList<>();
		
		HashMap<String, String> map = new HashMap<>();
		
		for(String s : logLines){
		    String[] split = s.split(" ");
		    
		    
		    if(split[1].matches("[a-z]*")){
		    	String noID = s.split(" ", 2)[0];
		        letterVals.add(noID);
		    }
		    else{
		        numVals.add(s);
		    }
		}
		
		Collections.sort(letterVals, new Comparator<String>() {
				@Override
				public int compare(String s1, String s2) {
					return s1.compareTo(s2);
				}
			});
			
		List<String> res = new ArrayList<String>();
		for(String s : letterVals){
		    res.add(s);
		}
		
		for(String s : numVals){
		    res.add(s);
		}
		
		return res;
	}

	static List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude)
		{
			// WRITE YOUR CODE HERE
			
			// Clean the input text by seperating words by spaces
			String[] cleanText = literatureText.split(" ");
			
			// Iterate through the literature text and add up the frequency of each word in a hashmap.
			HashMap<String, Integer> map = new HashMap<>();
	        for(String s : cleanText){
	            // only add new words that are to not be excluded, otherwise we assume they can be included.
	            if(!map.containsKey(s) && !wordsToExclude.contains(s)){
	                map.put(s, 0);
	            }
	            if(map.containsKey(s)){
	                map.put(s, map.get(s) + 1);
	            }
	        }
			
			List<String> result = getMostFrequentWords(map);
			
			return result;
		}
		// METHOD SIGNATURE ENDS
		
		static List<String> getMostFrequentWords(HashMap<String,Integer> map){
			List<String> res = new ArrayList<>();
			Collections.sort(res, new Comparator<String>() {
				@Override
				public int compare(String s1, String s2) {
					return s1.compareTo(s2);
				}
			});
			
	        int maxInMap = 0;
	        for(String s : map.keySet()){
	            if(map.get(s)>maxInMap){
	                maxInMap = map.get(s);
	            }
	        }
	        
	        for(String s : map.keySet()){
	            if(map.get(s)==maxInMap){
	                res.add(s);
	            }
	        }


			for(String s : res) {
				System.out.println(s);
			}
			return res;
		}

	
	static long gridlandMetro(long n, long m, int k, int[][] track) {
        // Complete this function
		long count = n * m;
		List<boolean[]> tracks = new ArrayList<>();
		for(int i=0;i<n;i++) {
			tracks.add(new boolean[(int)m]);
		}
		
		int rows = track.length;
		for(int i=0;i<rows;i++) {
			boolean[] currTrack = tracks.get(track[i][0]-1);
			//System.out.println(Arrays.toString(currTrack));
			int c1 = track[i][1]-1;
			int c2 = track[i][2];
			for(int j=c1;j<c2;j++) {
				System.out.println(j);
				if(!currTrack[j]) {
					count--;
				}
				currTrack[j]=true;
			}
		}
		
		return count;
    }
	
	static int hackerlandRadioTransmitters(int[] x, int k) {
		Arrays.sort(x);
		System.out.println(Arrays.toString(x));	
		
		int result = 0;
		int i = 0;
		while(i<x.length) {
			result++;
			int covered = x[i] + k;
			while(i<x.length && x[i] <= covered) {
				i++;
			}
			
			i--; // place transmitter here index
			covered = x[i] + k;
			
			while(i<x.length && x[i] <= covered) { // find index of first uncovered to the right
				i++;
			}
			
		}
		

		return result;
    }
	
	static int mod = 1000 * 1000 * 1000 + 7;
	
	static long countArray(int n, int k, int x) {
        // Return the number of ways to fill in the array.
		int[][] dp = new int[n][n];
		for(int i=0;i<dp.length;i++) {
			if(i==1) {
				dp[1][i]=1;
			}
			else {
				dp[1][i]=0;
			}
		}
		
		return 0;
    }
	
	
	
	static int shortPalindrome(String s) {
        // Complete this function
		
		int length = s.length();
		for(int i=0;i<length;i++) {
			for(int j=3;j<length;j++) {
				
			}
		}
		return 0;
    }
	
	static int minimumLoss(long[] price) {
        // Complete this function
		HashMap<Long, Integer> store = new HashMap<>();
		
		for(int i=0;i<price.length;i++) {
			store.put(price[i], i);
		}
		
		Arrays.sort(price);
		int min = (int) (price[1] - price[0]);
		for(int i=0;i<price.length-1;i++) {
			if(price[i+1]-price[i]<min) {
				int index1 = store.get(price[i]);
				int index2 = store.get(price[i+1]);
				if(index1>index2) {
					min = (int) (price[i+1]-price[i]);
				}
			} 
			
		}
		return min;
    }
	
	static int connectedCell(int[][] matrix) {
        // Complete this function
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int sum = 0;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(matrix[i][j]==1) {
					int recur = dfs(matrix,i,j);
					if(recur>sum) {
						sum = recur;
					}
				}				
			}
		}
		
		return sum;
    }
	
	static int dfs(int[][] matrix, int i, int j) {
		int n = matrix.length;
		int m = matrix[0].length;
		
		// boundary checking
		if(i<0 || j<0 || j>=m || i>=n) {
			return 0;
		}
		// 0 case, return quickly
		if(matrix[i][j]==0) {
			return 0;
		}
		//int sum=0;
		if(matrix[i][j]==1) {
			matrix[i][j]=0;
			return 1 + dfs(matrix, i,j-1) + dfs(matrix, i,j+1) + dfs(matrix, i-1,j) + dfs(matrix, i-1,j-1) + dfs(matrix, i+1,j+1) + dfs(matrix, i+1,j-1) + dfs(matrix, i+1,j) + dfs(matrix, i-1,j+1);
		}
		
		return 0;
	}
	
}
