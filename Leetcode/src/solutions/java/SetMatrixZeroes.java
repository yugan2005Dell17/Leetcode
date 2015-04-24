package solutions.java;

public class SetMatrixZeroes {
	
	public void setZeroes(int[][] matrix) {
		
		if(matrix==null||matrix.length==0||matrix[0].length==0) return;
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		boolean[] col = new boolean[n+1];
		boolean[] row = new boolean[m+1];
		
		for (int i=0; i<m; i++){
			for (int j=0; j<n; j++){
				if (matrix[i][j]==0) {
					row[i+1]=true;
					col[j+1]=true;
				}
			}
		}
		
		for (int i=0; i<m; i++){
	        for (int j=0; j<n; j++){
	            if (row[i+1] || col[j+1]) matrix[i][j]=0;
	        }
		}
		return;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
