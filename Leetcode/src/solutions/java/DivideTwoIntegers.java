package solutions.java;

import java.util.ArrayList;
import java.util.List;

public class DivideTwoIntegers {
	
    public int divide(int dividend, int divisor) {
    	//overflow 
        if (divisor==0) return Integer.MAX_VALUE;
        if (dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE; //This will overflow!
        
        // bug here, forget handling the negative cases
        boolean isPositive = (dividend>=0 && divisor>0) || (dividend<=0 && divisor<0);

        // bug here, because I am going to use Math.abs which does NOT work for the Integer.MIN_VALUE
        // Easy way of handling it is to cast it to long
        long lDividend = (long) dividend;
        long lDivisor = (long) divisor;
        
        lDividend = Math.abs(lDividend);
        lDivisor = Math.abs(lDivisor);
        List<Long> times = new ArrayList<>();
        
        long temp = lDivisor;
        
        while (temp<=lDividend) {
            times.add(temp);
            temp += temp;
        }
        
        long result=0;
        long sum = 0;
        
        for (int i=times.size()-1; i>=0; i--) {
            if (sum+times.get(i)<=lDividend) {
                sum += times.get(i);
                result = (result<<1)+1; // bug here, << precedence bug
            }
            else {
                result = result<<1;
            }
        }
        
        return isPositive ? (int) result : (int) (0-result);
    }

	public static void main(String[] args) {
		 DivideTwoIntegers test = new DivideTwoIntegers();
//		 int dividend = -1010369383;
//		 int divisor = -2147483648;
		 
//		 int dividend = 1;
//		 int divisor = 1;
		 
		 int dividend = -2147483648;
		 int divisor = 1;
		 
		 System.out.println(test.divide(dividend, divisor));

	}

}
