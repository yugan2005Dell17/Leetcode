package solutions.java;

public class SingleNumber {
	
    public int singleNumber(int[] nums) {
    	/*
    	 * When directly work on int's binary format, remember
    	 * there will be negative int and two's complementary form.
    	 */
        if (nums==null || nums.length==0) return 0;
        boolean isOne=false;
        int result=0;
        int bitOperator = 0x8000_0000;
        boolean isNegative=false;
        
        for (int j=0; j<nums.length; j++){ // work for the first bit
            if ((nums[j] & bitOperator) == bitOperator) isOne=!isOne;
        }
        if (isOne) {// negative integer, two's complementary
        	isNegative=true;
        }
        
        for (int i=1; i<32; i++){
        	bitOperator>>>=1;
            isOne=false;
            for (int j=0; j<nums.length; j++){
                if ((nums[j] & bitOperator) == bitOperator) isOne=!isOne;
            }
            if (isNegative) result = result*2+(isOne?0:1);
            else result = result*2+(isOne?1:0);
        }
        
        if (isNegative) result = -1*(result+1);
       return result; 
    }

	public static void main(String[] args) {
		
		int[] testInput = {1};
		SingleNumber test = new SingleNumber();
		System.out.println(test.singleNumber(testInput));

	}

}
