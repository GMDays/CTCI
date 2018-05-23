package LeetCode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;

public class RandomProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Arrays.toString(twoSum(new int[] {3,3}, 6)));
		//System.out.println(reverse(1534236469));
		
		//System.out.println(myAtoi(" "));
		
		//System.out.println(romanToInt("MCMXCIV"));
		
		//System.out.println(kangaroo(0, 3, 4, 2));
		
		//System.out.println(beautifulPairs(new int[] {1,1,1}, new int[] {1,1,1}));
		
		//leftRotation(new int[] {1,2,3,4,5}, 4);
		
		//System.out.println(countingValleys(8, "UDDDUDUU"));
		
		//System.out.println(formingMagicSquare(new int[][] {{5,3,4},{1,5,8},{6,4,2}}));
		
		//System.out.println(pickingNumbers(new int[] {4, 6, 5, 3, 3, 1}));
		
		//System.out.println(Arrays.toString(climbLeaderBoard(new int[] {5,25,50,120}, new int[] {100,100,50,40,40,20,10})));
		
		//System.out.println(hurdleRace(7, new int[] {2,5,4,5,2}));
		
		//System.out.println(utopianTree(1));
		
		//encryption("chillout");
		
		//System.out.println(organizingContainers(new int[][] {{1,1},{1,1}}));
		
//		System.out.println(gridSearch(new String[] {"400453592126560",
//				"114213133098692",
//				"474386082879648",
//				"522356951189169",
//				"887109450487496",
//				"252802633388782",
//				"502771484966748",
//				"075975207693780",
//				"511799789562806",
//				"404007454272504",
//				"549043809916080",
//				"962410809534811",
//				"445893523733475",
//				"768705303214174",
//				"650629270887160"}, 
//				new String[] {"99",
//						"99"}));
		
		//System.out.println(happyLadybugs("B_RRBR"));
		
		
		//System.out.println(strangeCounter(21));
		
		//countApplesAndOranges(7,11,5,15, new int[] {-2,2,1}, new int[] {5,-6});
		
		//System.out.println(findDigits(12));
		
		
		//extraLongFactorials(25);
		
		//System.out.println(solve(1918));
		
		//System.out.print(Arrays.toString(absolutePermutation(3,0)));
		
		//System.out.println(Arrays.toString(bomberMan(3, new String[] {".......", "...O...", "....O..", ".......", "OO.....", "OO....."})));
		
		
		//System.out.println(angryProfessor(1, new int[] {0,-1,2,1}));
		
		//reverse(1,3,new int[] {1,6,5,4,9});
		//almostSorted(new int[] {1, 5, 4, 3, 2, 6});
		
		//System.out.println(Arrays.toString(icecreamParlor(100, new int[] {230, 863, 916, 585, 981, 404, 31})));
		
		//System.out.println(toys(new int[] {1, 2, 3, 21, 7, 12, 14, 21}));
		
		System.out.println(twoArrays(10, new int[] {1, 2, 2, 1}, new int[] {3,3,3,4}));
	}
	
	static String twoArrays(int k, int[] A, int[] B) {
        // Complete this function
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		for(int i=0; i<A.length; i++) {
			if(A[i] + B[B.length - i - 1] < k) {
				return "NO";
			}
		}
		
		return "YES";
    }
	
	static int getMinElem(int[] arr) {
		int min = Integer.MAX_VALUE;
		for(int i=0 ; i<arr.length; i++) {
			if(arr[i]<min) {
				min = arr[i];
			}
		}
		return min;
	}
	
	static int toys(int[] w) {
        // Complete this function
		
		Arrays.sort(w);
		
		int currBucket = w[0];
		int count = 1;
		for(int i=1; i<w.length; i++) {
			if(w[i]>currBucket+4) {
				count++;
				currBucket = w[i];
			}
		}
		
		return count;
    }
	
	 static int[] icecreamParlor(int m, int[] arr) {
	        // Complete this function
	        HashMap<Integer,Integer> map = new HashMap<>();
	        
	        int target = -1;
	        int findex = 0;
	        int sindex = 0;
	        for(int i=0; i<arr.length; i++) {
	        	if(arr[i]<m) {
	        		target = m - arr[i];
		        	if(map.containsKey(target)){
		        		findex = i;
		        		sindex = map.get(target);
		        		break;
		        	}
		        	else {
		        		map.put(arr[i], i);
		        	}
	        	}	        	
	        }	      
	        
	        int[] result = new int[2];
	        result[0] = sindex>findex ? findex+1 : sindex+1;
	        result[1] = sindex>findex ? sindex+1 : findex+1;
	        
	        return result;
	    }
	
	static void almostSorted(int[] arr) {
        // Complete this function
		if(isSorted(arr)) {
			System.out.println("yes");
			return;
		}

		int i=0;
		int j=arr.length-1;
		while(i<arr.length && arr[i] < arr[i+1]) {
			i++;
		}
		while(j>=0 && arr[j] > arr[j-1]) {
			j--;
		}
		
		swap(i,j,arr);
		if(isSorted(arr)) {
			System.out.println("yes");
			i++;
			j++;
			System.out.println("swap " + i + " " + j);
			return;
		}
		
		reverse(i+1,j-1,arr);
		if(isSorted(arr)) {
			System.out.println("yes");
			i++;
			j++;
			System.out.println("reverse " + i + " " + j);
			return;
		}
		
		
		System.out.println("no");		
    }
	
	static void reverse(int ind1, int ind2, int arr[]) {
		System.out.println("reverse");
		if(ind1>ind2) {
			return;
		}
		
		while(ind1<ind2) {
			int temp = arr[ind1];
			arr[ind1] = arr[ind2];
			arr[ind2] = temp;
			
			ind1++;
			ind2--;
		}
		
		System.out.println(Arrays.toString(arr));
		return;
	}
	
	static void swap(int ind1, int ind2, int arr[]) {
		int temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}
	
	static boolean isSorted(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i+1]<arr[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	static String angryProfessor(int k, int[] a) {
        // Complete this function
		
		int result = 0;
		for(int i=0; i<a.length; i++) {
			if(a[i]<=0) {
				result++;
			}
		}
		
		if(result>=k) {
			return "NO";
		}
		
		return "YES";
    }
	
	static String[] bomberMan(int n, String[] grid) {
        // Complete this function

		if(n<=1) {
			return grid;
		}
		
		if(n%2==0) {
			for(int i=0; i<grid.length; i++) {
				String s = grid[i];
				s = s.replaceAll(".", "O");
				grid[i] = s;
			}
			return grid;
		}
						
		if(n%4==1) {
			return grid;
		}	
		
		String[] result = new String[grid.length];
		for(int i=0; i<grid.length; i++) {
			result[i] = new String(grid[i]);
		}
		
		for(int i=0; i<result.length; i++) {
			char[] row = grid[i].toCharArray();
			if(grid[i].charAt(0)=='O') {
				row[0] = '.';
			}
			for(int j=1; j<result[i].length(); j++) {
				if(i==0) {
					if(grid[i].charAt(j)=='O') {
						row[j] = '.';
					}
				}
				else if(i>0) {
					if(grid[i-1].charAt(j)=='O') {
						row[j] = '.';
					}
				}
				if(grid[i].charAt(j-1)=='O') {
					row[j] = '.';
				}
			}
			result[i] = Arrays.toString(row);
		}
			
		for(int i=0; i<grid.length; i++) {
			//result[i] = new String(grid[i]);
			char[] arr = grid[i].toCharArray();
			char[] check = grid[i].toCharArray();
			for(int j=0; j<arr.length; j++) {
				if(i>0 && j>0 && i<grid.length-1 && j<arr.length-1) {
					if(check[j]=='O') {
						arr[j] = '.';
						arr[j-1] = '.';
						arr[j+1] = '.';
						char[] plusOne = result[i+1].toCharArray();
						char[] minusOne = result[i-1].toCharArray();
						plusOne[j] = '.';
						minusOne[j] = '.';
						result[i-1] = Arrays.toString(minusOne);
						continue;
					}					
				}
				
				if(i==0) {
					if(check[j]=='O') {
						arr[j] = '.';
						char[] plusOne = result[i+1].toCharArray();
						plusOne[j] = '.';
					}	
				}
				if(i==grid.length-1) {
					if(check[j]=='O') {
						arr[j] = '.';
						char[] minusOne = result[i-1].toCharArray();
						minusOne[j] = '.';
					}	
				}
				if(j==0) {
					arr[j] = '.';
					arr[j+1] = '.';
					continue;
				}
				if(j==arr.length-1) {
					arr[j] = '.';
					arr[j-1] = '.';
					continue;
				}
			}
			result[i] = Arrays.toString(arr);
//			System.out.println(Arrays.toString(arr));
//			System.out.println(Arrays.toString(grid));
		}
		
		for(String s : result) {
			System.out.println(s);
		}
		//System.out.println(Arrays.toString(result));
		return result;
    }
	
	static int[] absolutePermutation(int n, int k) {
	        /*
	         * Write your code here.
	         */
		HashMap<Integer,Integer> map = new HashMap<>();
		int i = 1;
		int temp = k;
		
		if(k==0) {
			int[] result = new int[n];
			for(int x=0; x<n; x++) {
				result[x] = x+1;
			}
			return result;
		}
		
		if(n % (2*k)!=0) {
			int[] res = new int[1];
			res[0] = -1;
			return res;
		}			
		
		while(i<=n) {
			map.put(i,i+temp);
			if(i%k==0) {
				temp *= -1;
			}
			i++;
		}
		
		int[] result = new int[n];
		for(int j=1; j<=n; j++) {
			result[j-1] = map.get(j);
		}	

		return result;
	}
	
	static String solve(int year){
        // Complete this function
		if(year==1918) {
			return  "26.09." + year;
		}
		
		String day = "";
		if(year<=1917) {
			if(year%4==0) {
				day = "12";
			}
			else {
				day = "13";
			}
		}
		else {
			if( (year%400==0) || (year%4==0 && year%100!=0) ) {
				day = "12";
			}
			else {
				day = "13";
			}
		}
				
		
		return day + ".09." + year;
    }
	
	static void extraLongFactorials(int n) {
		BigInteger nn = new BigInteger(String.valueOf(n));
		System.out.println(extraLongFactorials(nn));
	}
	
	static BigInteger extraLongFactorials(BigInteger n) {
        // Complete this function
		BigInteger one = new BigInteger("1");
		if(n.compareTo(one)<1) {
			return one;
		}
		else {
			return n.multiply(extraLongFactorials(n.subtract(one)));
		}
		
    }
	
	static int findDigits(int n) {
        // Complete this function
		int res = 0;
		int divisor = n;
		while(divisor>0) {
			if(divisor%10==0) {
				divisor /= 10;
				continue;
			}
			if(n % (divisor%10) ==0) {
				res++;
			}
			divisor /= 10;
		}
		return res;
    }
	
	static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        /*
         * Write your code here.
         */
		int countApples = 0;
		int countOranges = 0;
		
		for(int i=0; i<apples.length; i++) {
			if( (a+apples[i])>=s && (a+apples[i])<=t) {
				countApples++;
			}
		}
		
		System.out.println(countApples);
		
		for(int i=0; i<oranges.length; i++) {
			if( (b+oranges[i])>=s && (b+oranges[i])<=t) {
				countOranges++;
			}
		}
		
		System.out.println(countOranges);
    }
	
	static long strangeCounter(long t) {
        /*
         * Write your code here.
         */
		int k = (int) (Math.log((t+2/3)) / Math.log(2));
		long cycle = 3 * (long) Math.pow(2, k);
		
		System.out.println(k);
		System.out.println(cycle);
		long res =  cycle - t - 2;
		return res;
    }
	
	static String happyLadybugs(String b) {
        /*
         * Write your code here.
         */
		char[] letters = b.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<letters.length; i++) {
			if(Character.isAlphabetic(letters[i])) {
				if(!map.containsKey(letters[i])) {
					map.put(letters[i], 0);
				}
				map.put(letters[i], map.get(letters[i]) + 1);
			}			
		}
		
		for(Character key : map.keySet()) {
			if(map.get(key)==1) {
				return "NO";
			}
		}
		
		if(!b.contains("_")) {
			for(int i=1; i<letters.length-1; i++) {
				if(letters[i]!=letters[i-1] && letters[i]!=letters[i+1]) {
					return "NO";
				}
			}
		}
		
		return "YES";
    }
	
	static String gridSearch(String[] G, String[] P) {
        // Complete this function
		for(int i=0; i<G.length; i++) {			
			int start = 0;
			while(start>-1) {
				start = G[i].indexOf(P[0], start);
				if(start>-1) {
					int count = 1;
					for(int j=1; j<P.length; j++) {
						if(P[j].equals(G[i+j].substring(start, start + P[j].length()))) {
							count++;
						}
						else {
							break;
						}
					}
					
					if(count==P.length) {
						return "YES";
					}
					start++;
				}
			}
		}
		
		
		return "NO";
    }
	
	static String organizingContainers(int[][] container) {
        // Complete this function
		int[] containers = new int[container.length];
		int[] types = new int[container.length];
		
		for(int i=0; i<containers.length; i++) {
			int containerSum = 0;
			int typeSum = 0;
			for(int j=0; j<containers.length; j++) {
				containerSum+=container[i][j];
				typeSum+=container[j][i];
			}
			types[i] = typeSum;
			containers[i] = containerSum;
		}
		
		for(int i=0; i< types.length; i++) {
			for(int j=0; j<containers.length; j++) {
				if(containers[i]==types[j]) {
					break; 
				}
				
				if(j==containers.length-1) {
					return "Impossible";							
				}
			}
		}
		
		
		return "Possible";
    }
	
	static String encryption(String s) {
        // Complete this function
		String trim = s.replaceAll("\\s","");
		int length = trim.length();
		int rows = (int) Math.floor(Math.sqrt(length));
		int cols = (int) Math.ceil(Math.sqrt(length));
		
		if((rows*cols)<1){
			rows++;
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<cols; i++) {
			for(int j=i; j<trim.length(); j+=cols) {
				sb.append(s.charAt(j));
			}
			sb.append(" ");
		}
		
		return sb.toString();
    }
	
	static int utopianTree(int n) {
        // Complete this function
		int res = 1;
		for(int i=1; i<n+1; i++) {
			if(i%2==0) {
				res++;
			}
			else {
				res *= 2;
			}
		}
		
		return res;
    }
	
	static int designerPdfViewer(int[] h, String word) {
        // Complete this function
		int max = 0;
		int i = 0;
			while(i<word.length() && word.charAt(i)!='\0') {
				int temp = h[(int)word.charAt(i)-97];
				max = (temp > max) ? temp : max;
				i++;
			}
			return max * i;
    }
	
	static int hurdleRace(int k, int[] height) {
        // Complete this function
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<height.length; i++) {
			if(max<height[i]) {
				max = height[i];
			}
		}
		
		if(max>k) {
			return max - k;
		}
		else {
			return 0;
		}
    }
	
	static int[] climbLeaderBoard(int[] alice, int[] scores) {
		ArrayList<Integer> map = new ArrayList<>();
		int prev = scores[0];
		map.add(prev);
		for(int i=1; i<scores.length; i++) {
			if(scores[i]<prev) {
				map.add(scores[i]);
				prev = scores[i];
			}
		}
			
		int[] res = new int[alice.length];
		int rank = map.size()-1;
		System.out.println(map.toString());
		for(int i=0; i<alice.length; i++) {						
			while(rank > 0 && map.get(rank) < alice[i]) {
				rank--;
			}			
			res[i] = alice[i] >= map.get(rank) ? rank + 1 : rank + 2;		
		}
		
		return res;
	}
	
	static int pickingNumbers(int[] a) {
        // Complete this function
		int[] map = new int[100+1];
		for(int i=0; i<a.length; i++) {
			++map[a[i]];
		}
		
		int maxLength=Integer.MIN_VALUE;
		for(int i=0; i<a.length; i++) {			
			int bestDiff = Math.max(map[a[i]+1], map[a[i]-1]);
			maxLength = Math.max(maxLength, bestDiff + map[a[i]]);
		}
					
		return maxLength;
    }
	
	static Integer[][] rotate(Integer[][] matrix){
		int rows = matrix.length;
		int cols = matrix[0].length;
		Integer[][] ret = new Integer[rows][cols];
		for(int r=0; r<rows; r++) {
			for(int c=0; c<cols; c++) {
				ret[c][rows-1-r] = matrix[r][c];
			}
		}
		
		return ret;
	}
	
	static int[][] generateValidMagicSquares(){
		return new int[][] {
			{8,1,6,3,5,7,4,9,2},
			{8,3,4,1,5,9,6,7,2},
			{6,1,8,7,5,3,2,9,4},
			{4,9,2,3,5,7,8,1,6},
			{2,9,4,7,5,3,6,1,8},
			{4,3,8,9,5,1,2,7,6},
			{6,7,2,1,5,9,8,3,4},
			{2,7,6,9,5,1,4,3,8}
		};
	}
	
	static int formingMagicSquare(int[][] s) {
        // Complete this function
		int minCost = Integer.MAX_VALUE;
		int[][] allSquares = generateValidMagicSquares();
		int currCost = 0;
		
		int[] orig = new int[9];
		for(int i=0; i<s.length; i++) {
			int[] row = s[i];
			for(int j=0; j<row.length; j++) {
				int number = s[i][j];
				orig[i * row.length + j] = number;
			}
		}
		System.out.println(Arrays.toString(orig));
		for(int[] row : allSquares) {
			for(int j=0; j<orig.length; j++) {
				currCost += Math.abs(orig[j]-row[j]);				
			}
			minCost = Math.min(currCost, minCost);			
			currCost = 0;
		}
		
		return minCost;
    }
	
	static int countingValleys(int n, String s) {
        // Complete this function
		char[] steps = s.toCharArray();
		int seaLevel = 0;
		boolean underSeaLvl = false;
		
		int valleys = 0;
		for(int i=0; i<steps.length; i++) {
			if(steps[i]=='D') {
				seaLevel--;
			}
			else if(steps[i]=='U') {
				seaLevel++;
			}
			
			if(seaLevel<0) {
				if(!underSeaLvl) {
					valleys++;
				}
				underSeaLvl = true;				
			}
			else {
				underSeaLvl = false;
			}
		}
		
		return valleys;
    }
	
	static void leftRotation(int[] arr, int n) {
		int[] result = new int[arr.length];
		
		for(int i=0;i<arr.length;i++) {
			int newIndex = (i + n) % arr.length;
			result[i] = arr[newIndex];
		}
		
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i] + " ");
		}
	}
	
	static int beautifulPairs(int[] A, int[] B) {
        // Complete this function
		int count = 0;
		int[] buckets = new int[1000+1];
		for(int i=0;i<A.length;i++) {
			buckets[A[i]] = buckets[A[i]] + 1; 
		}
		
		for(int i=0;i<B.length;i++) {
			if(buckets[B[i]]>0) {
				buckets[B[i]] = buckets[B[i]] - 1;
				count++;
			}
		}
		
		if(count==A.length) { // we have already found the maximal pair
			count--;
		}
		else {
			count++;
		}
		return count;
    }
	
	static long gcd(long a, long b) {
		while(b>0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
	
	static String kangaroo(int x1, int v1, int x2, int v2) {
        // Complete this function
		boolean v1MaxJumper = v1 > v2 ? true : false;
		int jumps = 1;
		while(true) {
			if(v1MaxJumper) {
				if(x1+ (v1 * jumps) > x2 + (v2 * jumps)) {
					break;
				}
			}
			else {
				if(x1+ (v1 * jumps) < x2 + (v2 * jumps)) {
					break;
				}
			}
			
			if(x1+ (v1 * jumps) == x2 + (v2 * jumps)) {
				return "YES";
			}
			jumps++;
		}
		
		return "NO";
    }
	
	public static int romanToInt(String s) {
        char[] romans = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int sum = map.get(romans[s.length()-1]);
        for(int i=s.length()-2; i>=0; i--) {
        	int next = map.get(romans[i+1]);
        	int curr = map.get(romans[i]);
        	
        	if(next>curr) {        		
        		sum-=curr;;     
        	}
        	else {
        		sum+=curr;
        	}        	
        }
        
        return sum;
    }
	
	public static int myAtoi(String str) {	
		if (str == null || str.length() < 1)
			return 0;
		
        str = str.trim();
        if(str.length()==0) {
        	return 0;
        }
        
        //int res = 0;
        char[] cleanChars = str.toCharArray();
        
        if(Character.isAlphabetic(cleanChars[0])) {
        	return 0;
        }
        
        char sign = '+';
        int i=0;
        if(str.charAt(0)== '-') {
        	sign = '-';
        	i++;
        }
        else if(str.charAt(0)=='+') {
        	i++;
        }
        
        double res = 0;
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
    		res = res * 10 + (str.charAt(i) - '0');
    		i++;
    	}
                
        if (sign == '-')
    		res = -res;
        
        if(res>Integer.MAX_VALUE) {
    		return Integer.MAX_VALUE;
    	}
    	if(res<Integer.MIN_VALUE) {
    		return Integer.MIN_VALUE;
    	}
        
        return (int)res;
    }
	
	static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(nums[0],0);
		
		int[] result = new int[2];

		for(int i=1; i<nums.length; i++) {
			if(map.containsKey(target-nums[i])) {
				result[0] = map.get(target-nums[i]);
				result[1] = i;
				break;
			}
			else {
				map.put(nums[i], i);
			}
		}
		
		return result;
	}
	
	public static int reverse(int x) {
        try {
        	int res = 0;
        	while(x!=0) {
        		res = Math.multiplyExact(res, 10) + x%10;
        		x = x / 10;
        	}
        	return res;
        }
        catch (ArithmeticException  ex){
        
        	return 0;
        }
    }

}
