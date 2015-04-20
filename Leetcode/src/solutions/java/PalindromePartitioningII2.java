package solutions.java;

import java.util.ArrayList;

public class PalindromePartitioningII2 {
	
	public int minCut(String s) {
        
        if(s==null||s.length()==0||s.length()==1) return 0;
        
        /*
         * Try to improve the algorithm by comparing from the min prev cut numbers to larger prev cut numbers
         * But still not good.
         * The hint says it is DP problem, how to get the correct sub-problem?
         * I almost gave up the DP method, but the hint makes me dig deeper.
         */
        
        ArrayList<Integer>[] minCutList =(ArrayList<Integer>[]) new ArrayList[s.length()];
        
        for (int i=0; i<minCutList.length; i++){
        	minCutList[i]=new ArrayList<Integer>();
        }
        
        int[] result = new int[s.length()];

        
        for(int i=0; i<s.length(); i++){
            if(isPalindrome(s.substring(0,i+1))) {
            	minCutList[0].add(i);
            	result[i]=0;
            }
            else {
            	FindMinCut: for(int j=0; j<s.length()-1; j++){
        			for (int k=0; k<minCutList[j].size(); k++){
        				if (isPalindrome(s.substring(minCutList[j].get(k)+1, i+1))) {
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
    
    private boolean isPalindrome(String s){
        for (int i=0, j=s.length()-1; i<=j; i++, j--){
            if (s.charAt(i)!=s.charAt(j)) return false;
        }
        return true;
    }

	public static void main(String[] args) {
		PalindromePartitioningII2 test = new PalindromePartitioningII2();
		String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		System.out.println(test.minCut(input));

	}

}
