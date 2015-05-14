package solutions.java;

public class ScrambleStringBrutalForce {
	
    public boolean isScramble(String s1, String s2) {
    	if (s1==null || s2==null) return false;
        if (s1.length()!=s2.length()) return false;
        if (s1.length()==0) return true;
        if (s1.length()==1) return s1.equals(s2);
        boolean result = false;
        
        for (int i=1; i<s1.length(); i++){
        	boolean firstHalfResult, secondHalfResult;
        	firstHalfResult = isScramble(s1.substring(0, i), s2.substring(0, i)) &&
        			isScramble(s1.substring(i, s1.length()), s2.substring(i, s2.length()));
        	secondHalfResult = isScramble(s1.substring(0, i), s2.substring(s2.length()-i, s2.length())) &&
        			isScramble(s1.substring(i, s1.length()), s2.substring(0,s2.length()-i));
        	result = firstHalfResult || secondHalfResult;
        	if (result) return result;
        }
        
        return result;
    }

	public static void main(String[] args) {
		
		ScrambleStringBrutalForce test = new ScrambleStringBrutalForce();
//		String s1="great";
		String s1="abcdefghijklmnopq";
		
		
//		String s2="rgtae";
//		String s2="rgeat";
		String s2="efghijklmnopqcadb";

		System.out.println(test.isScramble(s1,s2));
	}

}
