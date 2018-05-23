package Hackerrank;

import java.util.Arrays;
import java.util.HashMap;

public class Implementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(pickingNumbers(new int[] {1, 2, 2, 3, 1, 2}));
		System.out.println(pickingNumbers(new int[] {1,1,2,2,4,4,5,5,5}));
	}
	
	static int equalizeArray(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], 0);
			}
			map.put(arr[i], map.get(arr[i]) + 1);
		}
		
		int max = 0;
		for(Integer i : map.keySet()) {
			if(map.get(i)>max) {
				max = map.get(i);
			}
		}
		
		return arr.length - max;
    }
	
	static int pickingNumbers(int[] a) {
		Arrays.sort(a);
		int track = a[0];
		int currMax = 1;
		int res = 0;
		for(int i=1; i<a.length; i++) {
			if(a[i]-track<=1) {
				currMax+=1;
				res = Math.max(currMax, res);
				//System.out.println("currMax : " + currMax + " a[i]: " + a[i]);
			}
			else {
				track = a[i];
				//System.out.println(track);
				currMax = 1;				
			}
		}
		return res;
    }
}
