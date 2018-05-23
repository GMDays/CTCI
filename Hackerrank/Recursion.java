package Hackerrank;

import java.awt.Point;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Recursion {
	public static void main(String[] args) {
		//System.out.println(powerSum(10,2));
		
		//System.out.println(getWordsByLengthDesc("AGRA;NORWAY;ENGLAND;GWALIOR;HELLOWORLD"));
		//System.out.println(digitSum("123",2));
		
		//System.out.println(permutationString("aaaaaaaaaaaa"));
		//System.out.println(permutationStringWithoutDupes("bob"));
		
		//System.out.println(generateParens(3));
		
//		Color[][] screen = new Color[][] {{Color.Red, Color.Red, Color.Red, Color.Black}, {Color.Red, Color.Red, Color.Red, Color.Black}, {Color.Red, Color.Red, Color.Red, Color.Black}, {Color.Red, Color.Red, Color.Red, Color.Black}};
//		paintFillBFS(screen, 1, 1, Color.Blue);
//		System.out.println(Arrays.deepToString(screen));
		
		//System.out.println(Coins(10));
		
//		ArrayList<Integer[]> res = new ArrayList<Integer[]>();
//		placeQueens(0, new Integer[GRID_SIZE], res);
//		
//		for(int i=0; i< res.size(); i++) {
//			System.out.println(Arrays.toString(res.get(i)));
//		}
		
		Box b1 = new Box(2,2,2);
		Box b2 = new Box(3,3,3);
		Box b3 = new Box(4,2,2);
		Box b4 = new Box(6,1,2);
		ArrayList<Box> boxes = new ArrayList<>();
		boxes.add(b1);
		boxes.add(b2);
		boxes.add(b3);
		boxes.add(b4);
		
		System.out.println(getLargestStack(boxes));
	}
	
	static int shortPalindrome(String s) {
        // Complete this function
        			
		return shortPalindrome(s.toCharArray(), 0, s.length()-1);
    }
	
	static int shortPalindrome(char[] letters, int i, int j) {
		
		return 0;
	}
	
	
	static class Box{
		int height, width, length;
		public Box(int height, int width, int length) {
			this.height = height;
			this.width = width;
			this.length = length;
		}
	}
	
	static class BoxComparator implements Comparator<Box>{
		@Override
		public int compare(Box x, Box y) {
			return y.height - x.height;
		}
	}
	
	static int getLargestStack(ArrayList<Box> boxes) {
		int[] map = new int[boxes.size()];
		Collections.sort(boxes, new BoxComparator());
		int max = 0;
		for(int i=0;i<boxes.size();i++) {
			int height = getLargestStack(boxes, i, map);
			max = Math.max(height, max);
		}
		
		return max;
	}
	
	static int getLargestStack(ArrayList<Box> boxes, int bottom, int[] stackMap) {
		if(bottom < boxes.size() && stackMap[bottom] > 0) {
			return stackMap[bottom];
		}
		
		int result = 0;
		Box bottomBox = boxes.get(bottom);
		for(int i=bottom + 1; i < boxes.size(); i++) {
			int height = getLargestStack(boxes, bottom + 1, stackMap);
			result = Math.max(height, result);
		}
		
		result += bottomBox.height;
		stackMap[bottom] = result;
		
		return result;
	}
	
	static int GRID_SIZE = 8;
	static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> result) {
		if(row==GRID_SIZE) {
			result.add(columns.clone());
			//return;
		}
		else {
			for(int i=0;i<GRID_SIZE;i++) {
				if(checkPlacement(row, i, columns)) { // check if it's valid placement for column and diagonal					
					columns[row] = i; // here we are actually placing the queen at row = row and column = i
					placeQueens(row + 1, columns, result);
				}
			}
		}
	}
	
	static boolean checkPlacement(int row, int col, Integer[] columns) {
		for(int i=0; i < row; i++) {
			if(columns[i]==col) { // check if the same column in any of the other rows invalidates this particular col
				return false;
			}
			
			if(row - i == Math.abs(columns[i] - col)) { // check if distance of rows equals distance of columns. this means that there is a queen already in the same diagonal.
				return false;
			}					
		}
		
		return true;
	}
	
	static long getWays(long n, long[] c){
        // Complete this function
        long[][] dp = new long[(int)n+1][c.length];
        //reverse(c);
        return getWays(n, c, dp, 0);
    }
	
	static void reverse(long[] arr) {
		int mid = arr.length / 2;
		for(int i=0;i<mid;i++) {
			long temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
	}
    
    static long getWays(long n, long[] c, long[][] dp, int index){
    	if(n==0 ) {
    		return 1;
    	}
    	else if(n<0) {
    		return 0;
    	}
    	else if(index >= c.length - 1) {
    		return 0;
    	}
    	else if(dp[(int)n][index]>0) {
    		return dp[(int)n][index];
    	}
    	else {
    		dp[(int)n][index] = getWays(n, c, dp, index + 1) + getWays(n - c[index], c, dp, index);
    		return dp[(int)n][index];
    	}    	
    }
	
	static int Coins(int cents) {		
		int[] denoms = {2,5,3,6};
		Arrays.sort(denoms);
		//reverse(denoms);
		System.out.println(Arrays.toString(denoms));
		int[][] arr = new int[cents+1][denoms.length];
		return Coins(cents, arr, 0, denoms);
	}
	
	static int Coins(int cents, int[][] dp, int index, int[] denoms) {
		if(dp[cents][index]>0) {
			return dp[cents][index]; // we have already computed this value, no need to go any further.
		}
		
		if(index >= denoms.length - 1) return 1; // fully reduced form. 
		
		int ways = 0;
		int denom = denoms[index];
		for(int i=0; i * denom <= cents; i++) {
			int remainder = cents - (i * denom);
			ways += Coins(remainder, dp, index + 1, denoms);
		}
		
		dp[cents][index] = ways;
		return dp[cents][index];
	}
	
	static enum Color { Green, Black, Purple, Red, Orange, Blue, White};
	
	static boolean paintFill(Color[][] screen, int row, int column, Color newColor) {
		if(screen[row][column]==newColor) return false; // this pixel is already the new color, return false;
		
		return paintFill(screen, row, column, screen[row][column], newColor);
	}
	
	static void paintFillBFS(Color[][] screen, int row, int column, Color newColor) {
		paintFillBFS(screen, row, column, screen[row][column], newColor);
	}
	
	static void paintFillBFS(Color[][] screen, int row, int column, Color original, Color newColor) {
		LinkedList<Point> queue = new LinkedList<>();
		queue.add(new Point(row,column));
		boolean[][] marked = new boolean[screen.length][screen[0].length];
		marked[row][column] = true;
		
		while(!queue.isEmpty()) {
			Point check = queue.removeFirst();
			screen[check.x][check.y] = newColor;
			marked[check.x][check.y] = true;
			
			addIfValid(screen, check.x + 1, check.y + 1, original, newColor, queue); 
			addIfValid(screen, check.x + 1, check.y, original, newColor, queue); 
			addIfValid(screen, check.x + 1, check.y - 1, original, newColor, queue); 
			addIfValid(screen, check.x - 1, check.y - 1, original, newColor, queue); 	
			addIfValid(screen, check.x - 1, check.y, original, newColor, queue); 
			addIfValid(screen, check.x - 1, check.y + 1, original, newColor, queue); 
			addIfValid(screen, check.x, check.y + 1, original, newColor, queue); 
			addIfValid(screen, check.x, check.y - 1, original, newColor, queue); 			
		}
	}
	
	static void addIfValid(Color[][] screen, int row, int column, Color original, Color newColor, LinkedList<Point> queue) {
		if(row >= 0 && column >= 0 && row < screen.length && column < screen[0].length && screen[row][column] == original) {
			queue.add(new Point(row, column));
		}				
	}
	
	static boolean paintFill(Color[][] screen, int row, int column, Color originalColor, Color newColor) {
		if(row < 0 || column < 0 || row >= screen.length || column >= screen[0].length) return false; // base case validation
		
		if(screen[row][column]==originalColor) {
			screen[row][column] = newColor;
			paintFill(screen, row + 1, column, originalColor, newColor);
			paintFill(screen, row - 1, column, originalColor, newColor);
			paintFill(screen, row, column + 1, originalColor, newColor);
			paintFill(screen, row, column - 1, originalColor, newColor);
		}
		
		return true;
	}
	
	static ArrayList<String> generateParens(int n){
		char[] str = new char[n*2];
		ArrayList<String> result = new ArrayList<>();
		parens(0, n, n, result, str);
		return result;
	}
	
	static void parens(int index, int right, int left, ArrayList<String> parens, char[] str) {
		if(left<0 || right<left) return; // there are either no more left parens remaining or there are more right parens than there are left ones.
		
		if(left==0 && right==0) { // out of all parenthesis
			parens.add(String.copyValueOf(str));			
		}
		else {
			str[index] = ')';
			parens(index + 1, right - 1, left, parens, str);
			
			str[index] = '(';
			parens(index + 1, right, left - 1, parens, str);
		}
	}
	
	static ArrayList<String> permutationStringWithoutDupes(String str){
		ArrayList<String> result = new ArrayList<>();
		HashMap<Character, Integer> map = buildFreqTable(str);
		permutationStringWithoutDupes(str, map, result, "", str.length());
		return result;
	}
	
	static HashMap<Character,Integer> buildFreqTable(String s){
		HashMap<Character, Integer> freq = new HashMap<>();
		for(char c : s.toCharArray()) {
			if(!freq.containsKey(c)) {
				freq.put(c, 0);
			}
			freq.put(c, freq.get(c) + 1);
		}
		return freq;
	}
	
	static void permutationStringWithoutDupes(String str, HashMap<Character, Integer> map, ArrayList<String> result, String prefix, int rem){
		if(rem==0) {
			result.add(prefix);			
			return;
		}
		
		for(Character c : map.keySet()) {
			int count = map.get(c);
			if(count>0) {
				map.put(c, map.get(c) - 1);
				permutationStringWithoutDupes(str, map, result, prefix + c, rem - 1);
				map.put(c, count);
			}
		}
				
	}
	
	
	
	static ArrayList<String> permutationString(String str){
		if(str==null) {
			return null;
		}
		
		ArrayList<String> list = new ArrayList<String>();		
		if(str.length()==0) {
			list.add("");
			return list;
		}
		
		for(int i=0;i<str.length();i++) {
			// remove character i from string
			String before = str.substring(0, i);
			
			// add the remaining characters
			String after = str.substring(i+1, str.length());
			
			ArrayList<String> words = permutationString(before + after);
			
			for(String s : words) {
				list.add(str.charAt(i) + s);
			}
		}
		
		return list;
	}
	
	static int digitSum(String n, int k) {
        int sum=0;
		for(int i=0;i<n.length();i++) {
        	sum += n.charAt(i)-'0';
        }
		sum *= k;
		if(sum<10) {
			return sum;
		}
		else {
			return digitSum(""+sum, 1);
		}		
    }
	

	
	static ArrayList<ArrayList<Integer>> powerSet(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> pSet;
		if(set.size()==index) {
			pSet = new ArrayList<ArrayList<Integer>>();
			pSet.add(new ArrayList<Integer>());
		}
		else {
			pSet = powerSet(set, index + 1);
			int current = set.get(index);
			for(ArrayList<Integer> subset : pSet) {
				ArrayList<Integer> nList = new ArrayList<Integer>();
				
			}
		}
		
		return null;
	}
	
	static int magicIndexNonDistinct(int[] arr) {
		return magicIndexNonDistinct(arr, 0, arr.length-1);
	}
	
	static int magicIndexNonDistinct(int[] arr, int low, int high) {
		if(high < low) return -1;
		
		int midIndex = (high + low) / 2;
		int midVal = arr[midIndex];
		
		if(midVal == midIndex) return midIndex;
		
		int leftIndex = Math.min(midIndex - 1, midVal);
		int left = magicIndexNonDistinct(arr, low, leftIndex);
		if(left>=0) return left;
		
		int rightIndex = Math.max(midIndex + 1, midVal);
		int right = magicIndexNonDistinct(arr, rightIndex, high);
		
		return right;
	}
	
	static int magicIndexDistinct(int[] arr) {
		return magicIndexDistinct(arr, 0, arr.length-1);
	}
	
	static int magicIndexDistinct(int[] arr, int low, int high) {
		if(high<low) {
			return -1;
		}
		
		int mid = (high + low) / 2;
		if(arr[mid]==mid) {
			return mid;
		}
		else if(arr[mid] > mid) {
			return magicIndexDistinct(arr, low, mid - 1);
		}
		else {
			return magicIndexDistinct(arr, mid + 1, high); 
		}
	}
	
	
	// Haven't solved this one yet.
	static String[] crosswordPuzzle(String[] crossword, String hints) {
        // Complete this function
		char[][] grid = createGrid(crossword);
		List<String> words = getWordsByLengthDesc(hints);	
		
		for(String word : words) {
			
		}
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]=='-') {
					
				}
			}
		}
		
		
		return null;
    }
	
	static char[][] insertWord(char[][]grid, String word){
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]=='-') {
					
				}
			}
		}
		
		return grid;
	}
	
	static boolean canPlaceWord(String word, char[][] grid) {
		for(int i=0;i<grid.length;i++) {
			int currentRow = i;
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]=='-' || word.contains(String.valueOf(grid[i][j]))) {
					
				}
			}
		}
		
		return false;
	}
	
	static List<String> getWordsByLengthDesc(String hints){
		List<String> words = Arrays.asList(hints.split(";"));		
		words.sort( (b,a) -> Integer.compare(a.length(), b.length()));
		return words;		
	}
	
	static char[][] createGrid(String[] crossword){
		int rows = crossword.length;
		int cols = crossword[0].length();
		char[][] result = new char[rows][rows];
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				result[i][j] = crossword[i].charAt(j);
			}
		}
		
		return result;
	}
	
	static int powerSum(int X, int N) {
		return powerSum(X, N, 1);
	}
	
	static int powerSum(int X, int N, int count) {
		int num = (int)Math.pow(count, N);
		if(X-num<0) {
			return 0;
		}
		else if(X-num==0) {
			return 1;
		}

		return powerSum(X-num, N, count+1) + powerSum(X, N, count+1);
	}
}


