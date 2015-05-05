package solutions.java;

public class IsomorphicStrings {
	
    public boolean isIsomorphic(String s, String t) {
        if (s==null || s.length()==0) return true;
        
        char[] charArrayS = new char[0X7F];
        boolean[] boolArrayT = new boolean[0X7F];

        for (int i=0; i<s.length();i++){
            if (charArrayS[(int) (s.charAt(i))]=='\u0000') { // new encountered char in s
            	if (!boolArrayT[(int) (t.charAt(i))]) { // new encountered char in t
	            	charArrayS[(int) (s.charAt(i))]=t.charAt(i);
	            	boolArrayT[(int) (t.charAt(i))]=true;
            	}
            	else { // already encountered char in t
            		return false;
            	}
            }
            else if (charArrayS[(int) (s.charAt(i))]!=t.charAt(i)) return false; // already encountered char in s
        }
        return true;
    }

	public static void main(String[] args) {
		
		IsomorphicStrings test = new IsomorphicStrings();
		String s="ab";
		String t="ca";
		
		System.out.println(test.isIsomorphic(s,t));
		

	}

}
