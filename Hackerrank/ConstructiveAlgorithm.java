package Hackerrank;

public class ConstructiveAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minimumBribes(new int[] {2,1,5,3,4});
	}
	
	
	static void minimumBribes(int[] q) {
        // Complete this function
		int min = 0;
		for(int i=0;i<q.length;i++) {
			if(Math.abs(q[i]-2)>i-1) {
				System.out.println("Too chaotic");
			}
			else {
				min++;				
			}
		}
		System.out.println(min);
    }

}
