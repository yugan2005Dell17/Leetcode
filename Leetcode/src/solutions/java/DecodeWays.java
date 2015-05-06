package solutions.java;

public class DecodeWays {
	/*
	 * The challenge point of this problem is handling 0!
	 */

    public int numDecodings(String s) {
        if (s==null || s.length()==0) return 0;
        int[] numDecoSoFar = new int[s.length()];
        if (s.charAt(0)=='0') return 0;
        numDecoSoFar[0]=1;
        if (s.length()==1) return 1;
        
        if (s.charAt(1)=='0'){
        	if (Integer.parseInt(s.substring(0, 2))>=30) return 0;
        	else numDecoSoFar[1]=1;
        }
    	else if (Integer.parseInt(s.substring(0, 2))<=26) numDecoSoFar[1]=2;
    	else numDecoSoFar[1]=1;        
        if (s.length()==2) return numDecoSoFar[1];
           
        for (int i=2; i<s.length(); i++){
        	if (s.charAt(i)=='0') {
        		if (Integer.parseInt(s.substring(i-1, i+1))>=30 ||
        				Integer.parseInt(s.substring(i-1, i+1)) ==0) return 0;
        		else numDecoSoFar[i]=numDecoSoFar[i-2];
        	}
    		else if (Integer.parseInt(s.substring(i-1, i+1))<=26 &&
    				Integer.parseInt(s.substring(i-1, i+1)) >10) 
    			numDecoSoFar[i]=numDecoSoFar[i-1]+numDecoSoFar[i-2];
            else numDecoSoFar[i]=numDecoSoFar[i-1];
        }
        return numDecoSoFar[s.length()-1];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
