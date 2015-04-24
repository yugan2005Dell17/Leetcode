package solutions.java;

public class SingleNumberII {
	
	public int singleNumber(int[] A) {
		//binary
    	String binaryStr="";
    	int mask = 0x1;
    	int result;
    	
    	for (int bitPos = 0; bitPos<32; bitPos++){
    		int numOfZero = 0;
    		for (int idx=0; idx<A.length; idx++) {
    			if ((A[idx]&mask)==0) numOfZero++;
    		}
    		if (numOfZero % 3 == 0) binaryStr = "1"+binaryStr;
    		else binaryStr = "0"+binaryStr;
    		mask <<= 1;
    	}
    	
    	//Note: Integer.parseInt need specify negative sign for negative values
    	//Revert and Plus 1
    	if (binaryStr.charAt(0)=='1') {
    		String temp = "";
    		for (int idx=1; idx<binaryStr.length(); idx++){
    			if (binaryStr.charAt(idx)=='0') temp += "1";
    			else temp += "0";
    		}
    		result = Integer.parseInt(temp, 2);
    		result = -1*(result+1);    		
    	}
    	else {
    		result = Integer.parseInt(binaryStr, 2);
    	}
    	
    	return result;            
    }
	
    public int singleNumberThree(int[] nums) {
    	//Three based solution, not much faster
        if (nums==null || nums.length==0) return 0;
        int n = nums.length;
        String[] numInStr = new String[n];
        int maxLen = 0;
        for (int i=0; i<n; i++){
            numInStr[i] = Integer.toString(nums[i],3);
            if (numInStr[i].length()>maxLen) maxLen = numInStr[i].length();
        }
        String resultInStr="";
        for (int i=0; i<maxLen; i++){
            int countZero=0, countOne=0, countTwo=0, countNegative=0;
            for (int j=0; j<n; j++){
                if (i>=numInStr[j].length()) continue;
                switch (numInStr[j].charAt(numInStr[j].length()-1-i)){
                    case '0': countZero = (countZero+1)%3; break;
                    case '1': countOne = (countOne+1)%3; break;
                    case '2': countTwo = (countTwo+1)%3; break;
                    case '-': countNegative = (countNegative+1)%3; break;
                }
            }
            if (countZero==1) resultInStr="0"+resultInStr;
            if (countOne==1) resultInStr="1"+resultInStr;
            if (countTwo==1) resultInStr="2"+resultInStr;
            if (countNegative==1) resultInStr="-"+resultInStr; 
        }
        return Integer.parseInt(resultInStr,3);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
