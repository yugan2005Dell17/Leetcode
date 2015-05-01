package solutions.java;

import java.util.ArrayList;

public class MaximalRectangle {
	
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] upBound= new int[row][col];
        @SuppressWarnings("unchecked")
		ArrayList<Integer>[][] leftBound =(ArrayList<Integer>[][]) new ArrayList[row][col];
        if (matrix[0][0]=='0') {
        	upBound[0][0]=notAva
        }
        
    }
 


	public static void main(String[] args) {
		MaximalRectangle test = new MaximalRectangle();
//		String[] input = {"01","01"};
//		String[] input ={"0010","1111","1111","1110","1100","1111","1110"};
		String[] input = {"1010","1011","1011","1111"};
		char[][] charInput = new char[input.length][];
		int idx=0;
		for (String inputS: input){
			charInput[idx]=inputS.toCharArray();
			idx++;
		}
		System.out.println(test.maximalRectangle(charInput));
	}

}
