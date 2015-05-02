package solutions.java;

import java.util.ArrayList;

public class MaximalRectangle {
	
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int maxArea=0;
        int[][] upBound= new int[row][col];
        
        for (int j=0; j<col; j++){
            if (matrix[0][j]=='0') {
            	upBound[0][j]=0;
            }
            else {
            	upBound[0][j]= 1;
            }
        }
        
        for (int i=1; i<row; i++){
        	for (int j=0; j<col; j++){
        		if (matrix[i][j]=='0') {
        			upBound[i][j]=0;        			
        		}
        		else {
                	upBound[i][j]=(upBound[i][j-1]==0? 1: upBound[i][j-1]+1);
        		}
        	}
        }
        
        for (int j=0; j<col; j++){
        	int curColMax = findColMax(upBound);
        }
    }
 
	private int findColMax(int[] upBound) {
		/*
		 * This is finding the max rectangle in Histogram problem
		 * But remember need first transfer the upBound into the actual length
		 */
		Integer[] A = new Integer[upBound.size()];
		A=upBound.toArray(A);
		for (int i=0; i<A.length; i++){
			A[i]=curCol-A[i]+1;
		}
		//scan right
		int[] boundToLeft = new int[A.length];
		int max=0;
		boundToLeft[0]=0;
		for (int i=1; i<A.length; i++){
			if (A[i]>A[i-1]) {
				boundToLeft[i] = i;
			}
			else {
				int curBoundToLeft=boundToLeft[i-1];
				while(curBoundToLeft>0 && A[i]<=A[curBoundToLeft-1]) {
					curBoundToLeft=boundToLeft[curBoundToLeft-1];
				}
				boundToLeft[i]=curBoundToLeft;
			}
		}
		//scan left
		int[] boundToRight = new int[A.length];
		boundToRight[A.length-1]=A.length-1;
		for (int i=A.length-2; i>=0; i--){
			if (A[i]>A[i+1]) {
				boundToRight[i] = i;
			}
			else {
				int curBoundToRight=boundToRight[i+1];
				while(curBoundToRight<A.length-1 && A[i]<=A[curBoundToRight+1]) {
					curBoundToRight=boundToRight[curBoundToRight+1];
				}
				boundToRight[i]=curBoundToRight;
			}
		}
		// Combine
		for (int i=0; i<A.length; i++){
			int curArea = (boundToRight[i]-boundToLeft[i]+1)*A[i];
			max = curArea>max? curArea: max;
		}
		return max;
	}



	public static void main(String[] args) {
		MaximalRectangle test = new MaximalRectangle();
//		String[] input = {"01","01"};
//		String[] input ={"0010","1111","1111","1110","1100","1111","1110"};
//		String[] input = {"1010","1011","1011","1111"};
		String[] input = {"10100","10111","11111","10010"};
		char[][] charInput = new char[input.length][];
		int idx=0;
		for (String inputS: input){
			charInput[idx]=inputS.toCharArray();
			idx++;
		}
		System.out.println(test.maximalRectangle(charInput));
	}

}
