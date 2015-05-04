package solutions.java;

public class InterleavingStringDPOptimal {
	
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1==null || s1.length()==0) return s3.equals(s2);
        if (s2==null || s2.length()==0) return s3.equals(s1);
        if (s3.length()!=s1.length()+s2.length()) return false;
        int s1Len=s1.length();
        int s2Len=s2.length();
        int s3Len=s3.length();
        boolean[][] canBeInterleaved = new boolean[s1Len+1][s2Len+1];
        /*
         * This matrix means whether s3.substring(0, i+j) can be interleaved by s1.substring(0, i)
         * and s2.substring(0, j); But note that the indexes all shifted by one, to cover base case canBeInterleaved[0][0]
         * which means use 0 char from s1 and 0 char from s2 to make 0 char of s3.
         */
        canBeInterleaved[0][0]=true;
        for (int i=1; i<=s1Len; i++){
        	canBeInterleaved[i][0]=(s3.charAt(i-1)==s1.charAt(i-1));
        	if (!canBeInterleaved[i][0]) break;
        }
        for (int j=1; j<=s2Len; j++){
        	canBeInterleaved[0][j]=(s3.charAt(j-1)==s2.charAt(j-1));
        	if (!canBeInterleaved[0][j]) break;
        }
        
        for (int k=1; k<=s3Len; k++){
        	boolean soFarPossible=false;
        	int iStartIdx=Math.max(0, k-s2Len);
        	int iEndIdx = Math.min(s1Len, k);
        	for (int i=iStartIdx; i<=iEndIdx; i++) {
        		/*
        		 * Improved the way of scanning and end the scanning earlier if it is false.
        		 */
        		if (i==0 || i==k) {} //canBeInterleaved[i][k-i] already derived.
        		else {
            		canBeInterleaved[i][k-i] = (canBeInterleaved[i-1][k-i] && (s3.charAt(k-1) == s1.charAt(i-1))) ||
            				(canBeInterleaved[i][k-i-1] && (s3.charAt(k-1) == s2.charAt(k-i-1)));     

        		}
        		if (canBeInterleaved[i][k-i]) soFarPossible = true;
        	}
        	
        	if (!soFarPossible) return false;
        }
        
        for (int i=1; i<=s1Len; i++){
        	for (int j=1; j<=s2Len; j++){
        		/*
        		 * Improved the way of scanning and end the scanning earlier if it is false.
        		 */
        		canBeInterleaved[i][j] = (canBeInterleaved[i-1][j] && (s3.charAt(i+j-1) == s1.charAt(i-1))) ||
        				(canBeInterleaved[i][j-1] && (s3.charAt(i+j-1) == s2.charAt(j-1)));      		
        	}
        }
        
        return canBeInterleaved[s1Len][s2Len];
    }
    


	public static void main(String[] args) {
		
		InterleavingStringDPOptimal test = new InterleavingStringDPOptimal();
//		String s1="aabcc";
//		String s2="dbbca";
//		String s3="aadbbcbcac";
//		String s3="aadbbbaccc";
		
//		String s1="db";
//		String s2="b";
//		String s3="cbb";
		
		String s1="bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
		String s2="babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
		String s3="babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
		
		
//		String s1="cbcccbabbccbbcccbbbcabbbabcababbbbbbaccaccbabbaacbaabbbc";
//		String s2="abcbbcaababccacbaaaccbabaabbaaabcbababbcccbbabbbcbbb";
//		String s3="abcbcccbacbbbbccbcbcacacbbbbacabbbabbcacbcaabcbaaacbcbbbabbbaacacbbaaaabccbcbaabbbaaabbcccbcbabababbbcbbbcbb";

		System.out.println(test.isInterleave(s1, s2, s3));


	}

}
