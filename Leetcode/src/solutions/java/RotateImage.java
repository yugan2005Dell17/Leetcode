package solutions.java;

public class RotateImage {
	
	//Note: solved on whiteboard.
	
//    public void rotate(int[][] matrix) { //note: Not optimal
//        if (matrix==null || matrix.length==0 || matrix[0].length==0) return;
//        int n = matrix.length;
//        boolean[][] processed = new boolean[n][n];
//        
//        for (int i=0; i<n; i++){
//            for (int j=0; j<n; j++){
//                if (!processed[i][j]) {
//                    int temp = matrix[i][j];
//                    matrix[i][j] = matrix[n-1-j][i];
//                    processed[i][j]=true;
//                    matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
//                    processed[n-1-j][i]=true;
//                    matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
//                    processed[n-1-i][n-1-j]=true;
//                    matrix[j][n-1-i]=temp;
//                    processed[j][n-1-i]=true;
//                }
//            }
//        }
//        
//        return;
//    }
    
    public void rotate(int[][] matrix) { // optimal
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return;
        int n = matrix.length;

        for (int i=0; i<=(n/2); i++){
            for (int j=i; j<=(n-i-2); j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
                matrix[j][n-1-i]=temp;
            }
        }
        
        return;
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
