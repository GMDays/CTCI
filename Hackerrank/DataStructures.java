package Hackerrank;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DataStructures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//medianTracker(new int[] {12,4,5,3,8,7});
		//leftRotate(new int[] {1,2,3,4,5},4);
		
		//System.out.println(jumpingOnClouds(new int[] {0, 0, 1, 0, 0, 1, 1, 0}, 2));
		
		
		//System.out.println(biggerIsGreater("hegf"));
		
				
		//System.out.println(Arrays.toString(breakingRecords(new int[] {10,5,20,20,4,5,2,25,1})));
		
		//cutTheSticks(new int[] {5, 4, 4, 2, 2, 8});
		
		//System.out.println(appendAndDelete("hackerhappy", "hackerrank", 7));		
		
		System.out.println(minimumDistances(new int[] {7, 1, 3, 4, 1, 7}));
	}
	
	static int minimumDistances(int[] a) {
		int minDist = Integer.MAX_VALUE;
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<a.length; i++) {
			map.put(a[i], i);
		}
		
		for(int i=a.length-1; i>=0; i--) {
			if(map.containsKey(a[i]) && map.get(a[i])!=i) {				
				minDist = Math.min(minDist, map.get(a[i])-i);
				map.put(a[i], i);
			}
		}
		
		return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
	
	static String appendAndDelete(String s, String t, int k) {		
		int diff = Math.abs(s.length()-t.length());
		int min = Math.min(s.length(), t.length());
		int count = diff;
		for(int i=0; i<min; i++) {
			if(s.charAt(i)!=t.charAt(i)) {
				count++;
				if(count>k) {
					return "No";
				}
			}
		}
		
		return count > k ? "No" : "Yes";
    }
	
	static void cutTheSticks(int[] arr) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	
		for(int i=0; i<arr.length; i++) {
			minHeap.add(arr[i]);
		}
		
		int minCut = 0;
		while(!minHeap.isEmpty()) {			
			if(minHeap.peek()-minCut==0) {
				System.out.println(minHeap.size());
				while(!minHeap.isEmpty() && minHeap.peek()-minCut==0) {
					minHeap.remove();
				}
			}
			else {
				minCut = minHeap.peek();
			}			
		}
    }
	
	static int[] breakingRecords(int[] score) {
		int max=score[0], min=score[0], countMax=0, countMin=0;
		for(int i=1; i<score.length; i++) {
			if(score[i]>max) {
				max = score[i];
				countMax++;
			}
			if(score[i]<min) {
				min = score[i];
				countMin++;
			}
		}
		int[] res = new int[2];
		res[0] = countMax;
		res[1] = countMin;
		return res;
    }
	
	static String biggerIsGreater(String w) {

        int i = w.length() - 1;
		while(i>0 && w.charAt(i) <= w.charAt(i-1)) {
			i--;
		}
		
		if(i==0 || w.length()==1) {
			return "no answer";
		}
		
		int j = w.length() - 1;		
		
		while(w.charAt(j)<=w.charAt(i-1)) {
			j--;
		}
		
		StringBuilder sb = new StringBuilder(w);
		char temp = w.charAt(i-1);
		sb.setCharAt(i-1, w.charAt(j));
		sb.setCharAt(j, temp);

		
		j = w.length() - 1;	
		while(i<j) {
			char temp2 = w.charAt(i);
			sb.setCharAt(i, w.charAt(j));
			sb.setCharAt(j, temp2);
			i++;
			j--;
		}
//		String res = sb.substring(0, i);
//		res += new StringBuilder(w.substring(i, w.length())).reverse().toString();
		
		return sb.toString();
    }
	
	static int jumpingOnClouds(int[] c, int k) {
		int energy = 100;		
		for(int i=0; i<c.length; i+=k) {
			if(c[(i% c.length)]==1) {
				System.out.println((i+k)%c.length);
				energy-=3;
			}
			else {
				energy--;
			}
		}
		return energy;
    }
	
	static void leftRotate(int[] a, int k) {
		int[] res = new int[a.length];
		for(int i=0; i<a.length; i++) {
			int rotate = (i+k) % a.length;
			res[i] = a[rotate];
		}
		
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
	
	static int cookies(int k, int[] A) {
        /*
         * Write your code here.
         */
		PriorityQueue<Integer> minH = new PriorityQueue<>();   
		int count=0;
		if(A.length==0) {
			return 0;
		}
		else {
			for(int i=0; i<A.length; i++) {
				minH.add(A[i]);
			}
		}
		
		while(minH.size() > 1 && minH.peek()<k) {
			int first = minH.remove();
			int second = minH.remove();
			minH.add((1 * first) + (2 * second));
			count++;
		}
		
		if(minH.peek()>=k) {
			return count;
		}
		else {
			return -1;
		}		
    }
	
	private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // keeps track of the SMALL numbers
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();                           // keeps track of the LARGE numbers
    
    public static void medianTracker(int [] array) {
        for (int i = 0; i < array.length; i++) {
            addNumber(array[i]);
            System.out.println(getMedian());
        }
    }
    
    private static void addNumber(int n) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(n);
        } else if (maxHeap.size() == minHeap.size()) {
            if (n < minHeap.peek()) {
                maxHeap.add(n);
            } else {
                minHeap.add(n);
                maxHeap.add(minHeap.remove());
            }
        } else if (maxHeap.size() > minHeap.size()) {
            if (n > maxHeap.peek()) {
                minHeap.add(n);
            } else {
                maxHeap.add(n);
                minHeap.add(maxHeap.remove());
            }
        }
        // maxHeap will never have fewer elements than minHeap
    }
    
    private static double getMedian() {
        if (maxHeap.isEmpty()) {
            return 0;
        } else if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else { // maxHeap must have more elements than minHeap
            return maxHeap.peek();
        }
    }
	
	static double[] runningMedian(int[] a) {
        /*
         * Write your code here.
         */
		double[] res = new double[a.length];
		DecimalFormat df = new DecimalFormat("#.#");
		df.setRoundingMode(RoundingMode.CEILING);

		res[0] = Double.valueOf(df.format(a[0]));
		
		ArrayList<Integer> list = new ArrayList<>();
		
		int index = 1;
		while(index<a.length) {
			int j = index;
			while(j>0 && a[j-1]>a[j]) {
				
			}
		}
		
		
		list.add(a[0]);
		int count = 1;
		for(int i=1; i<a.length; i++) {
			list.add(a[i]);
			count++;			
			if(count%2==0) {
				int med1 = list.size() / 2;
				int med2 = med1 + 1;
				System.out.println(a[med1]);
				System.out.println(a[med2]);
				res[i] = Double.valueOf(df.format( (a[med1] + a[med2]) / 2 ));
			}
			else {
				int med1 = (list.size()/2) + 1;
				//System.out.println(a[med1]);
				res[i] = Double.valueOf(df.format(a[med1]));
			}
		}
		
		return res;
    }

}
