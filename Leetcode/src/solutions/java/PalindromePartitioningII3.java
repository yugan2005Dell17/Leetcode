package solutions.java;

import java.util.ArrayList;

public class PalindromePartitioningII3 {
	
	public int minCut(String s) {
        
        if(s==null||s.length()==0||s.length()==1) return 0;
        
        /*
         * Try to improve the algorithm by comparing from the min prev cut numbers to larger prev cut numbers
         * But still not good.
         * The hint says it is DP problem, how to get the correct sub-problem?
         * I almost gave up the DP method, but the hint makes me dig deeper.
         */
        
        @SuppressWarnings("unchecked")
		ArrayList<Integer>[] minCutList =(ArrayList<Integer>[]) new ArrayList[s.length()];
        int[][] palindromeMatrix = new int[s.length()][s.length()];
        
        for (int i=0; i<minCutList.length; i++){
        	minCutList[i]=new ArrayList<Integer>();
        }
        
        int[] result = new int[s.length()];

        
        for(int i=0; i<s.length(); i++){
            if(isPalindrome(s, 0, i, palindromeMatrix)) {
            	minCutList[0].add(i);
            	result[i]=0;
            }
            else {
            	FindMinCut: for(int j=0; j<s.length()-1; j++){
        			for (int k=0; k<minCutList[j].size(); k++){
        				if (isPalindrome(s, minCutList[j].get(k)+1, i, palindromeMatrix)) {
        					/*
        					 * No need to check ((minCutList[j].get(k)+1)<=i), because based on the logic
        					 * All the indexes saved in the minCutList[] are definitely less than i
        					 */
        					minCutList[j+1].add(i);
        					result[i]=j+1;
        					break FindMinCut;
        				}
        			}
            	}
            }
        }
        
        return result[s.length()-1];
    }
    
    private boolean isPalindrome(String s, int i, int j, int[][] palindromeMatrix){
    	if (palindromeMatrix[i][j]!=0) {
    		if (palindromeMatrix[i][j]==1) return true;
    		else return false;
    	}
    	boolean result=true;
    	if (s.charAt(i)!=s.charAt(j)) result=false;
    	else {
        	if ((j-i)>2) {
        		result = result && isPalindrome(s,i+1,j-1,palindromeMatrix);
        	}
        	/*
        	 * if i-j==2, not need go further i, i+1, i+2 && i==i+2
        	 * if i-j==1, not need go further i, i+1 && i==i+1
        	 * if i-j==0, (this is possible when we call this function with i==j) no need go further
        	 */
    	}
    	if (result) palindromeMatrix[i][j]=1;
    	else palindromeMatrix[i][j]=2;
    	return result;
    }
    
	public static void main(String[] args) {
		PalindromePartitioningII3 test = new PalindromePartitioningII3();
//		String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//		String input = "aab";
		String input = "cabababcbc";
		System.out.println(test.minCut(input));

	}

}
