package Hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Arrays.toString(bigSorting(new String[] {"-20", "30"})));
		//System.out.println(Arrays.toString(closestNumbers(new int[] {-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854})));
		//System.out.println(findMedian(new int[] {0,1,2,4,6,5,3}));
		//System.out.println(lilysHomework(new int[] {2,5,3,1}));
		//System.out.println(reverseString("wordsssss"));
		
//		HashSet<String> set = printAllStringPermutations("", "bob");
//		for(String s : set) {
//			System.out.println(s);
//		}
		
		//insertionSort(6, new int[] {1, 4, 3, 5, 6, 2});
		System.out.println(partition(new int[] {4, 5, 3, 7, 2}, 0, 6));
	}
	
	static int[] quickSort(int[] arr) {
        // Complete this function\
		return quickSort(arr, 0, arr.length-1);
    }
	
	static int[] quickSort(int[] arr, int low, int high) {
		if(low<high) {
			int partition = partition(arr, low, high);
			
			quickSort(arr,low,partition-1);
			quickSort(arr,partition+1,high);
		}
		
		return arr;
	}
	
	static int partition(int[] arr, int low, int high) {
		int pivot = arr[low];
		int i = low - 1;
		for(int j = low; j<= arr.length-1; j++) {
			if(arr[j]<=pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp2 = arr[i+1];
	    arr[i+1] = arr[arr.length-1];
	    arr[arr.length-1] = temp2;
	    
	    for(int j=0; j<arr.length; j++) {					
			System.out.print(arr[j] + " ");
		}
	    return i+1;
	}
	
	static void insertionSort(int n, int arr[]) {
		for(int i=1; i<n; i++) {
			int temp = arr[i];
			int index = i - 1;
			while(index>=0 && temp<arr[index] ) {				
				arr[index+1] = arr[index];
				index--;				
			}			
			arr[index+1] = temp;
			for(int j=0; j<n; j++) {					
				System.out.print(arr[j] + " ");
			}
			System.out.println("");
		}		
	}
	
	static int findMedian(int[] arr) {
		return quickSort(arr, 0, arr.length-1, 0);
	}
	
	static int sum2dNxNArray(int[][] matrix) {
		int sum=0;
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix.length;j++) {
				sum+=matrix[i][j];
			}
		}
		return sum;
	}
	
	static HashSet<String> printAllStringPermutations(String prefix, String str) {
		HashSet<String> store = new HashSet<>();
		if(str.length()==0) {
			
			store.add(prefix);	
			return store;
		}
		else {
			for(int i=0;i<str.length();i++) {
				printAllStringPermutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, str.length()));
			}
		}
		
		return store;
	}
	
	static String reverseString(String str) {
		StringBuilder sb = new StringBuilder();
		int end = str.length();
		for(int i=0;i<str.length();i++) {
			sb.append(str.charAt(end - i -1));
		}
		return sb.toString();
	}
	
	static String reverseStringInPlace(String str) {
		int length = str.length();
		for(int i=0;i<length;i++) {
			char temp = str.charAt(i);
			//str.char
		}
		return null;
	}
	
	// Come back here and do a goddamn merge sort you pansy.
	static int lilysHomework(int[] arr) {
        // Complete this function
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=1;j<arr.length;j++) {
				if(arr[i]>arr[j]&&i<j) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					count++;
				}
			}
		}
		return count;
    }
	
	static int quickSort(int[] arr, int l, int r, int k) {
        // Complete this function
		if(l==r) {
			return arr[l];
		}
		
		//int mid = arr.length/2;
		int pivot = partition(arr, l, r, k);
		if(k==pivot) {
			return arr[pivot];
		}
		else if(k<pivot) {
			return quickSort(arr, l, pivot-1, k);
		}
		else {
			return quickSort(arr, pivot+1, r, k);
		}
    }
	
	static int partition(int[] arr,int l, int r, int pivot) {
		int pivotVal = arr[l];
		arr[pivot] = arr[r];
		int left = l;
		for(int i=l;i<r;i++) {
			if(arr[i]<pivotVal) {
				int temp = arr[left];
				arr[left] = arr[i];
				arr[i] = temp;
				left++;
			}
		}
		int temp = arr[r];
		arr[r] = arr[left];
		arr[left] = temp;
		return left;
	}
	
	static int[] closestNumbers(int[] arr) {
        // Complete this function
		Arrays.sort(arr);
		List<Integer> list = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		for(int i=0;i<arr.length-1;i++) {
			if(Math.abs(arr[i]-arr[i+1])<min) {
				min = Math.abs(arr[i]-arr[i+1]);
				list = new ArrayList<>();
				list.add(arr[i]);
				list.add(arr[i+1]);
			}
			else if(Math.abs(arr[i]-arr[i+1])==min) {
				list.add(arr[i]);
				list.add(arr[i+1]);
			}
		}
		
		int[] result = list.stream().mapToInt(i->i).toArray();		
		return result;
    }
	
	static String[] bigSorting(String[] arr) {
        // Complete this function
		List<Integer> ints = new ArrayList<Integer>();
		for(String s : arr) {			
			int num = Integer.valueOf(s);
			ints.add(num);			
		}
		Collections.sort(ints);
		String[] res = new String[ints.size()];
		for(int i=0;i<res.length;i++) {
			res[i] = String.valueOf(ints.get(i));
		}
		return res;
    }
}
