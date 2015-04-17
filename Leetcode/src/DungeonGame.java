
public class DungeonGame {
	
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null||dungeon.length==0||dungeon[0].length==0) return 1;
        int[][] mostNegative = new int[dungeon.length][dungeon[0].length];
        int[][] sumOfPath = new int[dungeon.length][dungeon[0].length];
        mostNegative[0][0]=dungeon[0][0];
        sumOfPath[0][0]=dungeon[0][0];
        
        for (int idx=1; idx<dungeon.length; idx++){
            sumOfPath[idx][0]=sumOfPath[idx-1][0]+dungeon[idx][0];
            mostNegative[idx][0]=(sumOfPath[idx][0]<mostNegative[idx-1][0])?sumOfPath[idx][0]:mostNegative[idx-1][0];
        }
        
        for (int idx=1; idx<dungeon[0].length; idx++){
            sumOfPath[0][idx]=sumOfPath[0][idx-1]+dungeon[0][idx];
            mostNegative[0][idx]=(sumOfPath[0][idx]<mostNegative[0][idx-1])?sumOfPath[0][idx]:mostNegative[0][idx-1];
        }
        
        for (int idxRow=1; idxRow<dungeon.length; idxRow++){
            for (int idxCol=1; idxCol<dungeon[0].length; idxCol++){
                if (mostNegative[idxRow-1][idxCol]<mostNegative[idxRow][idxCol-1]) { //bug #1 here: need use mostNegative to choose the path, not sumOfPath!
                    sumOfPath[idxRow][idxCol]=sumOfPath[idxRow][idxCol-1]+dungeon[idxRow][idxCol];
                    mostNegative[idxRow][idxCol]=(sumOfPath[idxRow][idxCol]<mostNegative[idxRow][idxCol-1])?sumOfPath[idxRow][idxCol]:mostNegative[idxRow][idxCol-1];

                }
                else if (mostNegative[idxRow-1][idxCol]>mostNegative[idxRow][idxCol-1]) {
                    sumOfPath[idxRow][idxCol]=sumOfPath[idxRow-1][idxCol]+dungeon[idxRow][idxCol];
                    mostNegative[idxRow][idxCol]=(sumOfPath[idxRow][idxCol]<mostNegative[idxRow-1][idxCol])?sumOfPath[idxRow][idxCol]:mostNegative[idxRow-1][idxCol];
                }
                else { // bug #3 here: This bug makes the problem hard - Only use mostNegative to choose the path is not enough. case: [[0,0,0],[1,1,-1]]
                	// when mostNegative is the same, need use sumOfPath to choose path
                	// UPDATE: bug #3 fixed, but still does NOT work. Actually this is not a good DP problem. Because the previous subproblem will change
                	// with the change of the later element. NEED GIVE UP THIS METHOD AND RETHINK
                	// It looks so much like DP problem which makes it very hard.!
                	if (sumOfPath[idxRow-1][idxCol]<sumOfPath[idxRow][idxCol-1]) {
                		sumOfPath[idxRow][idxCol]=sumOfPath[idxRow][idxCol-1]+dungeon[idxRow][idxCol];
                	}
                	else {
                		sumOfPath[idxRow][idxCol]=sumOfPath[idxRow-1][idxCol]+dungeon[idxRow][idxCol];
                	}
                	mostNegative[idxRow][idxCol]=(sumOfPath[idxRow][idxCol]<mostNegative[idxRow-1][idxCol])?sumOfPath[idxRow][idxCol]:mostNegative[idxRow-1][idxCol];                	
                }
                
            }

        }
        
        int result = mostNegative[dungeon.length-1][dungeon[0].length-1];
        if (result<0) result = (-1)*result+1;
        else result =1; // bug #2 here: if it is positive, 1 will be okay.
        
        return result; 

    }

	public static void main(String[] args) {
		
		int[][] dungeon = {{0,0,0},{1,1,-1}};
		DungeonGame test = new DungeonGame();
		System.out.println(test.calculateMinimumHP(dungeon));

	}

}
