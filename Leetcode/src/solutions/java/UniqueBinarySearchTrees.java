package solutions.java;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n<1) return 0;
        int[] numUniqueTree = new int[n+1];
        numUniqueTree[0]=1; // This is required at Line 19
        numUniqueTree[1]=1; // when n = 1, only one unique tree, and it use 1 as the root;
        /*
         * for numUniqueTree[i]:
         * 1-	it can use 1...j...i-1 as the root, when j is the root, there are
         * 		[1...j-1] in its left sub-tree: (j-1) elements -> unique shape is numUniqueTree[j-1]
         * 		[j+1...i] in its right sub-tree: (i-j) elements -> unique shape is numUniqueTree[i-j]
         * 		times together.
         * 2-	it can use i as the root, then [1...i-1] as its left sub-tree -> unique shape is numUniqueTree[i-1]
         */
        for (int i=2; i<=n; i++){// using i as the root for the unique tree
        	for (int j=1; j<i; j++){ //solution for case 1-
            	numUniqueTree[i]+=numUniqueTree[j-1]*numUniqueTree[i-j];
        	}
        	numUniqueTree[i]+=numUniqueTree[i-1]; //solution for case 2-
        }
        return numUniqueTree[n];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
