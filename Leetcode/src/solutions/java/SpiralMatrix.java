package solutions.java;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return new ArrayList<Integer>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[] idxes = {0, -1};
        int turnCounter = 0;
        boolean[][] visited = new boolean[m][n];
        List<Integer> result = new ArrayList<Integer>(m*n);
        
        while (result.size()!=m*n) {
        	turnCounter = next(idxes, visited, turnCounter, m, n);
            visited[idxes[0]][idxes[1]]=true;
            result.add(matrix[idxes[0]][idxes[1]]);
        }
        
        return result;
    }
    
    private int next(int[] idxes, boolean[][] visited, int turnCounter, int m, int n){
    	int i = idxes[0];
    	int j = idxes[1];
    	switch (turnCounter%4) {
            case 0: j++; break;
            case 1: i++; break;
            case 2: j--; break;
            case 3: i--; break;
        }
        if (i<0 || j <0 || i >= m || j>=n || visited[i][j]) {
            switch (turnCounter%4) {
                case 0: j--; break;
                case 1: i--; break;
                case 2: j++; break;
                case 3: i++; break;
            }
            turnCounter++;
            switch (turnCounter%4) {
                case 0: j++; break;
                case 1: i++; break;
                case 2: j--; break;
                case 3: i--; break;
            }
        }

        idxes[0]=i;
        idxes[1]=j;
        return turnCounter;
    }

	public static void main(String[] args) {
		SpiralMatrix test = new SpiralMatrix();
		int[][] testInput= {{1,2},{3,4}};
		String output="";
		for (int ele:test.spiralOrder(testInput)) {
			output += ele+", ";
		}
		System.out.println(output);
	}

}
