package solutions.java;

public class ReverseInteger {
	
    public int reverse(int x) {
        int sign = (x<0)? -1: 1;
        x = x*sign;
        /*
         * Do not need worry the negative overflow problem
         * Integer.MIN_VALUE*(-1)==Integer.MIN_VALUE
         * Read here: http://stackoverflow.com/questions/12535095/java-integers-min-value-negative-then-compare
         * And it is actually "while (x>0)" catches the Integer.MIN_VALUE bug
         */
        int result=0;
        while (x>0){
        	if ((Integer.MAX_VALUE-x%10)/10<result) return 0; //bug, check overflow
            result = result*10+x%10;
            x = x/10;
        }
        
        result = result*sign;
        return result;
    }

	public static void main(String[] args) {
		int testVal = -2147483648;
		ReverseInteger test = new ReverseInteger();
		System.out.println(test.reverse(testVal));
	}

}
