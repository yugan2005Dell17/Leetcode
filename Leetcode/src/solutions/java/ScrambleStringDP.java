package solutions.java;

public class ScrambleStringDP {
	
    public boolean isScramble(String s1, String s2) {
    	if (s1==null || s2==null) return false;
        if (s1.length()!=s2.length()) return false;
        int l=s1.length();
        if (l==0) return true;
    	boolean[][][] result = new boolean[l][l][l];
    	
    	// k+1 is the length, here dealing with k=0, i.e. length=1 case
    	for (int i=0; i<l; i++) {//i is the start index for s1
    		for (int j=0; j<l; j++) { //j is the start index for s2
    			if (s1.charAt(i)==s2.charAt(j)) result[0][i][j]=true;
    		}
    	}
    	
    	for (int k=1; k<l; k++) {// k+1 is the length
    		for(int i=0; i<l-k; i++) {// i is the start index of string s1
    			for (int j=0; j<l-k; j++) { //j is the start index for s2
    				for (int preK=0; preK<k; preK++){ // previous recorded results for length < (k+1)
    					/*
    					 * This divides s1(i, i+k+1), s2(j,j+k+1) but two parts -->
    					 * one is of length preK+1, and the rest is of length (k+1)-(preK+1)=k-preK
    					 * Note: length of k-preK in this code will represented by k-preK-1
    					 * such as: s1(i,i+preK+1), s2(j,j+preK+1) AND s1(i+preK+1, i+k+1) , s2(j+preK+1, j+k+1),  -> head vs head
    					 * or as: s1(i+k-preK,i+k+1), s2(j,j+preK+1) AND s1(i,i+k-preK) , s2(j+preK+1, j+k+1), -> tail vs head
    					 * or as: s1(i,i+preK+1), s2(j+k-preK,j+k+1) AND s1(i+preK+1, i+k+1) , s2(j,j+k-preK), -> head vs tail
    					 * or as: s1(i+k-preK,i+k+1), s2(j+k-preK,j+k+1) AND s1(i,i+k-preK) , s2(j,j+k-preK), -> tail vs tail
    					 */
    					boolean curResult=false;
    					if (result[preK][i][j]&&result[k-preK-1][i+preK+1][j+preK+1]) curResult=true;
    					else if (result[preK][i+k-preK][j]&&result[k-preK-1][i][j+preK+1]) curResult=true;
    					else if (result[preK][i][j+k-preK]&&result[k-preK-1][i+preK+1][j]) curResult=true;
    					else if (result[preK][i+k-preK][j+k-preK]&&result[k-preK-1][i][j]) curResult=true;
    					
    					if (curResult) {
    						result[k][i][j]=true;
    						break;
    					}
    				}
    			}
    		}
    	}
    	
    	return result[l-1][0][0];
    	
 
    }

	public static void main(String[] args) {
		
		ScrambleStringDP test = new ScrambleStringDP();
		String s1="great";
//		String s1="abcdefghijklmnopq";
		
		
//		String s2="rgtae";
		String s2="rgeat";
//		String s2="efghijklmnopqcadb";

		System.out.println(test.isScramble(s1,s2));
	}

}
