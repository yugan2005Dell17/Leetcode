package solutions.java;

public class InterleavingString {
	
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1==null || s1.length()==0) return s3.equals(s2);
        if (s2==null || s2.length()==0) return s3.equals(s1);
        if (s3.length()!=s1.length()+s2.length()) return false;
        return dfsIsInterleave(s1, s2, s3, 0, 0, 0);
    }
    
    private boolean dfsIsInterleave(String s1, String s2, String s3, int iS1, int iS2, int iS3){
        boolean result=false;
        if (iS3>=s3.length()) return true;
        if (iS1>=s1.length()) return s3.substring(iS3, s3.length()).equals(s2.substring(iS2, s2.length()));
        if (iS2>=s2.length()) return s3.substring(iS3, s3.length()).equals(s1.substring(iS1, s1.length()));
        if (s3.charAt(iS3)==s1.charAt(iS1)) {
            result = dfsIsInterleave(s1, s2, s3, iS1+1, iS2, iS3+1);
        }
        if (result==false && s3.charAt(iS3)==s2.charAt(iS2)) {
            result = dfsIsInterleave(s1, s2, s3, iS1, iS2+1, iS3+1);
        }
        return result;
    }

	public static void main(String[] args) {
		
		InterleavingString test = new InterleavingString();
//		String s1="aabcc";
//		String s2="dbbca";
//		String s3="aadbbcbcac";
//		String s3="aadbbbaccc";
		
		String s1="db";
		String s2="b";
		String s3="cbb";
		
//		String s1="bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
//		String s2="babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
//		String s3="babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
		
		
//		String s1="cbcccbabbccbbcccbbbcabbbabcababbbbbbaccaccbabbaacbaabbbc";
//		String s2="abcbbcaababccacbaaaccbabaabbaaabcbababbcccbbabbbcbbb";
//		String s3="abcbcccbacbbbbccbcbcacacbbbbacabbbabbcacbcaabcbaaacbcbbbabbbaacacbbaaaabccbcbaabbbaaabbcccbcbabababbbcbbbcbb";

		System.out.println(test.isInterleave(s1, s2, s3));


	}

}
