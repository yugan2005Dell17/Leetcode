package solutions.java;

public class MaximalRectangle {
	
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int globalMax = 0;
        int[][][] upLeftCorner = new int[row][col][2]; 
        /* 
         * This is for the rectangular area - the crossing of horizontal and vertical
         * This should take the max number between the horizontal and vertical
         * Therefore set the broken locations as col/row. So that if the max number equals to col/row,
         * it means no crossing exist.
         */
        int[][] upCorner = new int[row][col]; // 
        int[][] leftCorner = new int[row][col]; // this is for the horizontal strip area
        /*
         * This is for the vertical and horizontal stripe areas.
         * This should take the min number that is reachable.
         * Therefore set the broken locations as col / row.
         */
        int[][] localMax = new int[row][col];
        if (matrix[0][0]=='1') {
            localMax[0][0]=1;
            globalMax=1;            
        }
        else {
            upCorner[0][0]=row;
            leftCorner[0][0]=col;
            upLeftCorner[0][0][0]=row; // up corner
            upLeftCorner[0][0][1]=col; // left corner
        }
        for (int i=1; i<col; i++){
            if (matrix[0][i]=='0'){
                upCorner[0][i]=row;
                leftCorner[0][i]=col;
                upLeftCorner[0][i][0]=row; // up corner
                upLeftCorner[0][i][1]=col; // left corner
            }
            else {
                leftCorner[0][i]=Math.min(leftCorner[0][i-1], i);
                upLeftCorner[0][i][1]=leftCorner[0][i]; // left corner
                localMax[0][i]=localMax[0][i-1]+1;
                globalMax=Math.max(localMax[0][i], globalMax);
            }
        }
        for (int i=1; i<row; i++){
            if (matrix[i][0]=='0'){
                upCorner[i][0]=row;
                leftCorner[i][0]=col;
                upLeftCorner[i][0][0]=row; // up corner
                upLeftCorner[i][0][1]=col; // left corner
            }
            else {
                upCorner[i][0]=Math.min(upCorner[i-1][0], i);
                upLeftCorner[i][0][0]=upCorner[i][0];  // up corner
                localMax[i][0]=localMax[i-1][0]+1;
                globalMax=Math.max(localMax[i][0], globalMax);
            }
        }
        
        for (int i=1; i<row; i++){
            for (int j=1; j<col; j++){
                if (matrix[i][j]=='0'){
                    upCorner[i][j]=row;
                    leftCorner[i][j]=col;
                    upLeftCorner[i][j][0]=row; // up corner
                    upLeftCorner[i][j][1]=col; // left corner
                }
                else {
                	// Rectangular area
                	int[] upLeft = new int[2];
                	upLeft[0]= Math.max(upLeftCorner[i-1][j-1][0], upCorner[i-1][j]);// up corner
                	upLeft[1]= Math.max(upLeftCorner[i-1][j-1][1], leftCorner[i][j-1]);// left corner
                	if (upLeft[0]==row || upLeft[1]==col){
                        upLeftCorner[i][j][0]=i; // up corner
                        upLeftCorner[i][j][1]=j; // left corner
                	}
                	else {
                        upLeftCorner[i][j][0]=upLeft[0]; // up corner
                        upLeftCorner[i][j][1]=upLeft[1]; // left corner
                	}                	
                	localMax[i][j]=(i-upLeftCorner[i][j][0]+1)*(j-upLeftCorner[i][j][1]+1);
                	
                	// horizontal stripe area
                    leftCorner[i][j]= Math.min(leftCorner[i][j-1], j);
                    localMax[i][j] = Math.max(j-leftCorner[i][j]+1, localMax[i][j]);
                    
                    // vertical stripe area
                    upCorner[i][j]= Math.min(upCorner[i-1][j], i);
                    localMax[i][j] = Math.max(i-upCorner[i][j]+1, localMax[i][j]);
                    
                    globalMax=Math.max(localMax[i][j], globalMax);
                } 
            }
        }
        
        return globalMax;
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
