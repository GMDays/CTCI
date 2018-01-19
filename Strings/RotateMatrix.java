package Strings;

import java.util.Arrays;

public class RotateMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[4][4];
		for(int i=0;i<matrix[0].length;i++) {
			for(int j=0;j<matrix.length;j++) {
				if(i%2==0) {
					matrix[i][j] = 1;
				}
				else matrix[i][j] = 0;
			}
		}
		
		System.out.println(Arrays.deepToString(matrix));
		System.out.println(Arrays.deepToString(getRotateMatrix(matrix)));
	}
	
	public static int[][] getRotateMatrix(int[][] input){
		int rows = input[0].length;
		int cols = input.length;
		
		int layers = cols/2;
		for(int i=0;i<layers;i++) {
			int first = i;
			int last = cols - i - 1;
			for(int j=first;j<last;j++) {
				int offset = j-first;
				
				//save top
				int top = input[first][j];				
				//set top -> left
				input[first][j] = input[last-offset][first];
				//set left -> bottom
				input[last-offset][first] = input[last][last-offset];
				//set bottom -> right
				input[last][last-offset] = input[j][last];				
				//set right -> top
				input[j][last] = top;								
			}
			//int[] topRow = input[i][]
		}
		return input;		
	}

}
