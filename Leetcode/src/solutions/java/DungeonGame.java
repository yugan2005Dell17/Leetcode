package solutions.java;

public class DungeonGame {
	
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null||dungeon.length==0||dungeon[0].length==0) return 1;
        int rowNum = dungeon.length;
        int colNum = dungeon[0].length;
        int[][] req = new int[rowNum][colNum];
        int reqMinForPrev=0;
        /*
         * The logic is like this:
         * Look from the princess towards to the hero. The number at each grid need satisfy two requirement
         * 1: The number must make the current gird positive
         * 2: After the operation of the current gird, it must meet the previous grid's requirement.
         * So, instead the original wrong way of finding the path, we just find the required numbers for each grid
         * in the reverse order.
         */
        req[rowNum-1][colNum-1]= (dungeon[rowNum-1][colNum-1]>0)?1:(-1*dungeon[rowNum-1][colNum-1]+1);
        
        for (int iRow=rowNum-2; iRow>=0; iRow--){
        	req[iRow][colNum-1]=(dungeon[iRow][colNum-1]>0)?1:(-1*dungeon[iRow][colNum-1]+1);
        	if (req[iRow][colNum-1]<req[iRow+1][colNum-1]-dungeon[iRow][colNum-1]) {
        		// this is equivalent to req[iRow][colNum-1]+dungeon[iRow][colNum-1]<req[iRow+1][colNum-1]
        		req[iRow][colNum-1]=req[iRow+1][colNum-1]-dungeon[iRow][colNum-1];
        	}
        }
        for (int iCol=colNum-2; iCol>=0; iCol--){
        	req[rowNum-1][iCol]=(dungeon[rowNum-1][iCol]>0)?1:(-1*dungeon[rowNum-1][iCol]+1);
        	if (req[rowNum-1][iCol]<req[rowNum-1][iCol+1]-dungeon[rowNum-1][iCol]) {
        		req[rowNum-1][iCol]=req[rowNum-1][iCol+1]-dungeon[rowNum-1][iCol];
        	}
        }
        
        for (int iRow=rowNum-2; iRow>=0; iRow--){
        	for (int iCol=colNum-2; iCol>=0; iCol--){
        		req[iRow][iCol]=(dungeon[iRow][iCol]>0)?1:(-1*dungeon[iRow][iCol]+1);
        		reqMinForPrev = req[iRow][iCol+1]-dungeon[iRow][iCol];
        		if (reqMinForPrev>req[iRow+1][iCol]-dungeon[iRow][iCol]) {
        			reqMinForPrev=req[iRow+1][iCol]-dungeon[iRow][iCol];
        		}
        		if (req[iRow][iCol]<reqMinForPrev) req[iRow][iCol]=reqMinForPrev;
        	}
        }
        
        return req[0][0]; 
    }

	public static void main(String[] args) {
		
		int[][] dungeon = {{0,0,0},{1,1,-1}};
		DungeonGame test = new DungeonGame();
		System.out.println(test.calculateMinimumHP(dungeon));

	}

}
