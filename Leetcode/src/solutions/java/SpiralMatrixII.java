package solutions.java;


public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		if (n<=0) return new int[0][0];
		int[][] result = new int[n][n];
		int counter=0;
        int[] idxes = {0, -1};
        int turnCounter = 0;
        boolean[][] visited = new boolean[n][n];
        
        while (counter!=n*n) {
        	turnCounter = next(idxes, visited, turnCounter, n, n);
        	counter++;
            visited[idxes[0]][idxes[1]]=true;
            result[idxes[0]][idxes[1]]=counter;
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
		SpiralMatrixII test = new SpiralMatrixII();
		int testInput= 9;
		String output="";
		for (int[] row:test.generateMatrix(testInput)) {
			for (int ele:row){
				output += ele+" ";
			}
			output += "\n";			
		}
		System.out.println(output);
	}

}
