package Hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Greedy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(luckBalance(6, 3, new int[][] {{5,1},{2,1},{1,1}, {8,1},{10,0},{5,0}}));
		
		//System.out.println(largestPermutationHelp(2, new int[] {3,4,2,5,1}));
		
		//System.out.println(maximumToys(new int[] {5,5,10}, 5));
		//System.out.println(Arrays.toString(missingNumbers(new int[] {203, 204, 205, 206, 207, 208, 203, 204, 205, 206}, new int[] {203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204})));
		//System.out.println(pairs(2, new int[] {1, 5, 3, 4, 2  }));
		
		//System.out.println(sherlockAndArray(new int[] {1,2,3,3}));
		
		//System.out.println(minimumAbsoluteDifference(3, new int[] {3, -7, 0}));
		
		//System.out.println(getMinimumCost(3,2,new int[] {2,5,6}));
		//System.out.println(flippingMatrix(new int[][] {{112,42,83,119}, {56,125,56,49}, {15,78,101,43}, {62,98,114,108}}));
		
		//System.out.println(winner(new int[] {5,2,6,3,4}));
		//System.out.println(angryChildren(3, new int[] {10,100,300,200,1000,1005,20,30,1010}));
		
		//System.out.println(Arrays.toString(jimOrders(new int[][] {{8,1}, {4,2},{5,6},{3,1},{4,3}, {6,3}})));
		
		//miniMaxSum(new long[] {1,2,3,4,5});
		
		//System.out.println(beautifulQuadruples(new int[] {1,2,3,4}));
		
		//leftRotate(new int[] {1,2,3,4,5},4);
		
		//dynamicArray(2, new int[][] {{1,0,5},{1,1,7},{1,0,3},{2,1,0},{2,1,1}});
		
		System.out.println(pylons(2, new int[] {0,1,1,1,1,0}));
	}
	
	static int pylons(int k, int[] arr) {
        // Complete this function
		//k = k-1;
		int result = 0;
		int i = 0;
		while(i<arr.length) {
			result++;
			int covered = k + i-1;
			
			if(covered>=arr.length) {
				covered = arr.length-1;
			}
			
			while(covered>=0 && (covered+k) >i && arr[covered]!=1) {
				covered--;
			}
			
			if(covered<0 || covered + k <= i) {
				return -1;
			}
			
			i = k + covered;
		}
		
		return result;
    }
	
	static int beautifulQuadruples(int[] arr) {
		int count = 0;
		
//		while(countA<=a && countB<=b && countC<=c && countD<=d) {
//			
//		}
		int totalPerms = getPermutations(arr, 0);
		int equalPerms = getEqualPermutations(arr, 0);
		
		//System.out.println(totalPerms);
		System.out.println(equalPerms);
		//count = totalPerms - equalPerms;
		
		return count;
	}
	
	static int[] dynamicArray(int n, int[][] queries) {
        /*
         * Write your code here.
         */
		int lastAnswer = 0;
		ArrayList<Integer[]> seqList = new ArrayList<>();
		for(int i=0; i<n; i++) {
			seqList.add(new Integer[n]);
		}
		int[] size = new int[n];
		int result[] = new int[n];
		int q2Index = 0;
		for(int i=0; i<queries.length; i++) {
			int query = queries[i][0];
			int x = queries[i][1];
			int y = queries[i][2];
			
			if(query==1){
				int index = (x^lastAnswer) % n;
				Integer[] arr = seqList.get(index);
				arr[size[index]] = y;
				//result[index] = y;
				size[index]+=1;
			}
			else if(query==2) {
				int index = (x^lastAnswer) % n;
				Integer[] arr = seqList.get(index);				
				int val = y % size[index];				
				lastAnswer = arr[val];
				//result[index] = lastAnswer;
				result[q2Index] = lastAnswer;
				q2Index++;
				//System.out.println(lastAnswer);
			}
			
		}
		
		return result;
    }
	
	static void leftRotate(int[] arr, int n) {
		int[] res = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			int rotate = (i+n)%arr.length;
			System.out.println(rotate);
			res[i] = arr[rotate];
		}
		
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
	
	static int eqCounter=0;
	static int getEqualPermutations(int[] arr, int index) {
		
		for(int i=index; i<arr.length;i++) {
			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
			getEqualPermutations(arr, index + 1);
			arr[i] = arr[index];
			arr[index] = temp;
		}
		
		if(index == arr.length-1) {
			//System.out.println(Arrays.toString(arr) + " ");
			//eqCounter++;
		}
		
		return eqCounter;
	}
	
	static int counter = 0;
	static int getPermutations(int[] arr, int index) {					
		for(int i=index; i<arr.length;i++) {
			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
			getPermutations(arr, index + 1);
			arr[i] = arr[index];
			arr[index] = temp;
		}	
		
		if(index == arr.length-1) {
			System.out.println(Arrays.toString(arr) + " ");
			counter++;
		}
		
		return counter;
	}
	
	static String timeConversion(String s) {
        /*
         * Write your code here.
         */
		String result = "";
		String amPM = s.substring(s.length()-2);
		int hour = Integer.parseInt(s.substring(0, 2));
		
		if(hour<=12 && amPM.equals("AM") || (hour==12 && amPM.equals("PM"))) {
			result = String.valueOf(hour);
			if(hour==12 && amPM.equals("AM")) {
				result = String.valueOf(hour - 12);
			}
		}
		else {
			result = String.valueOf(hour+12);
		}
		
		return result + s.substring(2, s.length()-2);
    }
	
	static void miniMaxSum(long[] arr) {
        /*
         * Write your code here.
         */
		long min = 0;
		long max = 0;
		
		long minElem = getMin(arr);
		long maxElem = getMax(arr);
		
		long sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}

		System.out.println((sum - maxElem) + " " + (sum - minElem));
    }
	
	static long getMin(long[] arr) {
		long min = Integer.MAX_VALUE;
		for(int i=0; i<arr.length; i++) {
			if(min>arr[i]) {
				min = arr[i];
			}
		}
		
		return min;
	}
	
	static long getMax(long[] arr) {
		long max = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			if(max<arr[i]) {
				max = arr[i];
			}
		}
		
		return max;
	}
	
	static int[] jimOrders(int[][] orders) {
        // Complete this function
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<orders.length; i++) {
			map.put(orders[i][0]+orders[i][1], i+1);
		}
		sortbyColumn(orders, 1, 0);
		
		System.out.println(Arrays.deepToString(orders));
		
		int[] res = new int[orders.length];
		res[0]=map.get(orders[0][0]+orders[0][1]);
		for(int i=1; i<orders.length; i++) {
			if(res[i-1]==map.get(orders[i][0]+orders[i][1])){
				res[i] = res[i-1] - i - 1;
			}
			else {
				res[i] = map.get(orders[i][0]+orders[i][1]);
			}			
		}
		
		return res;
    }
	
	public static void sortbyColumn(int arr[][], int col, int col2)
    {
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(final int[] a, final int[] b) {
				if(a[col] + a[col2]>b[col] + b[col2])
					return 1;
				else
					return -1;
			}
		});
    }
	
	static int angryChildren(int k, int[] arr) {
        // Complete this function
		
		Arrays.sort(arr);
		int result = Integer.MAX_VALUE;
		for(int i=0; i<arr.length && i+k-1<arr.length; i++) {
			if(result>arr[i+k-1] - arr[i]) {
				result = arr[i+k-1] - arr[i];
			}
		}
		
		return result;
    }
	
	static String winner(int[] arr){
        String winner = "";      
        
        int elements = arr.length;
        int turn = 0;
        while(elements>0) {        	
        	int maxIndex = 0;
        	for(int i=1;i<elements;i++) {
        		if(arr[i]>arr[maxIndex]) {
        			maxIndex = i;
        		}
        	}
        	elements = maxIndex;        
        	turn++;
        	if(elements==0 && turn%2==0) {
        		return "ANDY";
        	}
        	else if(elements==0) {
        		return "BOB";
        	}
        }
		
		return winner;
    }
	
	static int flippingMatrix(int[][] matrix) {
        // Complete this function
        int rows = matrix.length;
        int cols = matrix[0].length;  
        int length = matrix.length;
        
        int result = 0;
        for(int i=0;i<matrix.length/2;i++) {
        	for(int j=0;j<matrix.length/2;j++) {
        		result += Math.max(Math.max(Math.max(matrix[i][j], matrix[length-i-1][j]), matrix[i][length-j-1]), matrix[length-i-1][length-j-1]);
        	}
        }

        //System.out.println(Arrays.deepToString(matrix));
        return result;
    }

    static int[][] flipRow(int row, int[][] matrix){
        int rows = matrix.length;
        int end = matrix.length;
        for(int i=0;i<rows/2;i++){
            int temp = matrix[row][i];
            matrix[row][i] = matrix[row][end - i - 1];
            matrix[row][end - i - 1] = temp;
        }

        return matrix;
    }

    static int[][] flipColumn(int column, int[][]matrix){
        int rows = matrix.length;
        int end = matrix.length;
        for(int i=0;i<rows/2;i++){
            int temp = matrix[i][column];
            matrix[i][column] = matrix[end - i - 1][column];
            matrix[end - i - 1][column] = temp;
        }

        return matrix;
    }
    
    static boolean getBetterRows(int column, int[][] matrix) {
    	int start = column < matrix.length/2 ? 0 : matrix.length;
    	for(int i=0;i<matrix.length/2;i++) {
    		int leftSum = 0;
            int newRightSum = 0;
            for(int j=i;j<matrix.length;j++) {
            	if (i < matrix.length /2) {
                    leftSum += matrix[i][column];
                }
                else{
                	newRightSum += matrix[i][column];
                }
            }
    		
    	}
    	
    	return false;
    }

    static boolean topLesserColumn(int column, int[][]matrix){
        int topsum = 0;
        int botsum = 0;
        for (int i = 0;  i < matrix.length; i++ ){
            if (i < matrix.length /2) {
                topsum += matrix[i][column];
            }
            else{
                botsum += matrix[i][column];
            }
        }
        return topsum > botsum ? false : true;
    }

    static boolean leftLesserRow(int row, int[][] matrix){
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0;  i < matrix.length; i++ ){
            if (i < matrix.length /2) {
                leftSum += matrix[row][i];
            }
            else{
                rightSum += matrix[row][i];
            }
        }
        return leftSum > rightSum ? false : true;
    }
	
	static int getMinimumCost(int n, int k, int[] c){
        // Complete this function
		Arrays.sort(c);
		reverse(c);
		int sum=0;

		for(int i=0;i<c.length;i++) {
			sum+= ((i / k) + 1) * c[i];			
		}
		
		return sum;
    }
	
	static int minimumAbsoluteDifference(int n, int[] arr) {
        // Complete this function
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		for(int i=1;i<n;i++) {			
			if(Math.abs(arr[i] - arr[i-1])<min) {
				min = Math.abs(arr[i]-arr[i-1]);
			}
		}
		
		return min;
    }
	
	static String sherlockAndArray(int[] a){
        // Complete this function
		int totalSum = 0;
		for(int i=0;i<a.length;i++) {
			totalSum+=a[i];
		}
		int rightSum=totalSum;
		int leftSum=0;
		for(int i=0;i<a.length;i++) {
			rightSum -= a[i];
			if(leftSum==rightSum) {
				return "YES";
			}			
			leftSum += a[i];
		}
		
		return "NO";
    }
	
	static int pairs(int k, int[] arr) {
        // Complete this function
		int count=0;
		Arrays.sort(arr);
		int i = 0;
		int j = 0;
		
		while(j<arr.length) {
			int diff = arr[j] - arr[i];
			if(diff==k) {
				count++;
				j++;
			}
			else if(diff>k) {
				i++;
			}
			else if(diff<k) {
				j++;
			}
		}
		return count;
    }
	
	static int[] missingNumbers(int[] arr, int[] brr) {
		HashMap<Integer,Integer> mapA = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			int count = mapA.containsKey(arr[i]) ? mapA.get(arr[i]) : 0;
			mapA.put(arr[i], count + 1);
		}
		
		for(int i=0;i<brr.length;i++) {
			int count = mapA.containsKey(brr[i]) ? mapA.get(brr[i]) : 0;
			mapA.put(brr[i], count - 1);
		}
		
		List<Integer> temp = new ArrayList<>();
		for(int key : mapA.keySet()){
			if(mapA.get(key)!=0) {
				temp.add(key);
			}
		}
		
		int[] intArray = new int[temp.size()];
		for (int i = 0; i < intArray.length; i++) {
		    intArray[i] = temp.get(i);
		}
		Arrays.sort(intArray);
		return intArray;
	}
	
	static int maximumToys(int[] prices, int k) {
		Arrays.sort(prices);
		int res = 0;
	    int sum = 0;
		for(int i=0;i<prices.length;i++) {
			if(k-prices[i]>=0) {
				k-=prices[i];
				res++;
			}
		}
		
		return res;
	}
	
	static int luckBalance(int n, int k, int[][] contests) {
        int rows = contests.length;
        Arrays.sort(contests, (b,a) -> Integer.compare(a[0], b[0]));
        Arrays.sort(contests, (b,a) -> Integer.compare(b[1], a[1]));
        System.out.println(Arrays.deepToString(contests));
        int luck = 0;
        int count = 0;
        for(int i=0; i<rows;i++) {
        	if(contests[i][1] == 1 && count < k) {
        		luck += contests[i][0];
        		count++;
        	}
        	else if(contests[i][1]==0) {
        		luck += contests[i][0];
        	}
        	else {
        		luck -= contests[i][0];
        	}
        }
        
        return luck;
    }
	
	// come back and revisit this code, you need help in the for loop part
	static int[] largestPermutationHelp(int k, int[] arr) {
		int n = arr.length;
		int[] index = new int[n+1];
	    for (int i = 0; i < n; i++) {
	        //a[i] = input.nextInt();
	        index[arr[i]] = i;
	    }
	    System.out.println(Arrays.toString(index));
	    
	    for (int i = 0; i < n && k > 0; i++) {
	        if (arr[i] == n - i) {
	            continue;
	        }
	        arr[index[n - i]] = arr[i];
	        index[arr[i]] = index[n - i];
	        arr[i] = n - i;
	        index[n - i] = i;
	        k--; 
	    }
	    for (int i = 0; i < n; i++) {
	        System.out.print(arr[i] + " ");
	    }
	    
	    return arr;
	}
	
	static int[] largestPermutation(int k, int[] arr) {
        // Complete this function
		int count = 0;
		int length = arr.length;
		int max = 0;
		int tempJ = 0;

		for(int i=0;i<length;i++) {	
			max = arr[count];
			for(int j=count;j<length;j++) {				
				if(arr[j]>max) {
					max=arr[j];				
					tempJ = j;
				}
			}
			//System.out.println(max);
			if(count<k && arr[i]<max && i<tempJ) {
				//System.out.println(arr[i]);
				int temp = arr[i];
				arr[i] = arr[tempJ];
				arr[tempJ] = temp;
				count++;
			}			
		}
		
		return arr;
    }
	
	public static void reverse(int[] arr) {
		int mid = arr.length / 2;
		for(int i=0;i<mid;i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp; 
		}
	}
}
