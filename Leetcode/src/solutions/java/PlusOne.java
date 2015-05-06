package solutions.java;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
//        int[] result = {1};
        if (digits==null || digits.length==0) return new int[]{1};
        int[] result = new int[digits.length+1];
        int overFlow = (digits[digits.length-1]+1)/10;;
        result[digits.length]=(digits[digits.length-1]+1)%10;
        for (int i=digits.length-2; i>=0; i--) {
            result[i+1] = (digits[i]+overFlow)%10;
            overFlow = (digits[i]+overFlow)/10;
        }
        if (overFlow>0) {
            result[0]=1;
            return result;
        }
        
        return Arrays.copyOfRange(result, 1, result.length);
    }
}
