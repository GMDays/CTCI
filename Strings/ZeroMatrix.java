package Strings;

import java.util.Arrays;

public class ZeroMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[4][4];
		for(int i=0;i<matrix[0].length;i++) {
			for(int j=0;j<matrix.length;j++) {
				if(j%2==0) {
					matrix[i][j] = 1;
				}
				else matrix[i][j] = 0;				
			}
		}
		
		
		//getZeroMatrix(new int[3][4]);
		
		System.out.println(Arrays.deepToString(matrix));
		System.out.println(Arrays.deepToString(getZeroMatrix(matrix)));
	}
	
	public static int[][] getZeroMatrix(int[][] input){
		int cols = input[0].length;
		int rows = input.length;
		
		int[] rowsArr = new int[rows];
		int[] colsArr = new int[cols];
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(input[i][j] == 0) {
					rowsArr[i] = 1;
					colsArr[j] = 1;
				}
			}
		}
		
		for(int i=0;i<rows;i++) {			
			for(int j=0;j<cols;j++) {
				if(rowsArr[i] == 1) {
					input[i][j] = 0;
				}
			}
		}
		
		for(int i=0;i<cols;i++) {			
			for(int j=0;j<rows;j++) {
				if(colsArr[i] == 1) {
					input[j][i] = 0;
				}
			}
		}
		return input;
	}
}
