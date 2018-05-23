package Hackerrank;

import java.math.BigInteger;
import java.util.Arrays;

public class DynamicProgramming {
	public static void main(String[] args) {
		//System.out.println(cost(new int[] {10,1,10,1,10}));
		//System.out.println(fibonacciModified(BigInteger.valueOf(0),BigInteger.valueOf(1),5));
		
		//System.out.println(Arrays.toString(maxSubarray(new int[] {1,2,3,4})));
		
		System.out.println(candies(10, new int[] {1,2,2}));
		
		System.out.println(candies(10, new int[] {2,4,2,6,1,7,8,9,2,1}));
		
		//System.out.println(candies(10, new int[] { 9,8,7,7,6,6,5,4,3}));
	}
	
	static int candies(int n, int[] arr) {
		int res = 0;
		int[] dp = new int[arr.length];
		dp[0] = 1;
		for(int i=1; i<arr.length; i++) {					
			if(arr[i]>arr[i-1]) {
				dp[i] = dp[i-1] + 1;
			}
			else {
				dp[i] = 1;
			}
		}
		
		//[1, 2, 1, 2, 1, 2, 3, 3, 2, 1]
		//&& (arr[i+1] + 1) > arr[i]
		for(int i=arr.length-2; i>=0; i--) {
			if(arr[i+1]<arr[i] && (arr[i+1] + 1) >= arr[i]) {
				dp[i] = dp[i+1]+1;
			}
			else {
				dp[i]=dp[i];
			}
		}
		
		for(int i=0; i<dp.length; i++) {
			res+=dp[i];
		}
		
		System.out.println(Arrays.toString(dp));
		
		return res;
    }
	
	static int[] maxSubarray(int[] arr) {
        // Complete this function
		int[] result = new int[2];
		int nonContSum = arr[0];
		int currMax = arr[0];
		int maxEnd = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			currMax = Math.max(arr[i], currMax + arr[i]);
			maxEnd = Math.max(currMax, maxEnd);
			
			nonContSum = Math.max(arr[i], nonContSum + (arr[i]>0 ? arr[i] : 0));			
		}
		
		//System.out.println(Arrays.toString(dp));
		
		result[0] = maxEnd;
		result[1] = nonContSum;
		return result;
    }
	
	static int equal(int[] arr) {
        // Complete this function
		int n = arr.length;
		int count = 0;
		int result = 0;
		
		for(int i=0; i<n; i++) {
			int count1 = 0;
			int count3 = 0;
			int count5 = 0;
			for(int j=0; j<n; j++) {
				if(i!=j) {
					
				}
			}
			
			
		}
		
		return 0;
    }
	
	static int cost(int[] arr) {
        // Complete this function
		int[] dp = new int[arr.length-1];
		dp[0] = 0;
		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=1;j<arr[i+1];j++) {
				if(dp[i] < Math.abs(arr[i+1] - j)) {
					dp[i] = Math.abs(arr[i+1] - j);
				}
			}
		}

		int sum = 0;
		for(int i=0;i<dp.length;i++) {
			sum+=dp[i];
		}
		return sum;
    }
	
	static BigInteger fibonacciModified(BigInteger t1, BigInteger t2, int n) {
        // Complete this function
		n--;
		if(n==1) {
			return t2;
		}
		//n--;
		
		return fibonacciModified(t2, t2.multiply(t2).add(t1), n);
    }
}
