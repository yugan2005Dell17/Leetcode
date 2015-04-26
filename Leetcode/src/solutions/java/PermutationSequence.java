package solutions.java;

import java.util.ArrayList;

public class PermutationSequence {
	
    public String getPermutation(int n, int k) {
        if (n==0) return "";
        if (k<=0) return "";
        k--; // now it is based on 0
        int[] factorial=new int[n];
        factorial[0]=1;
        int startIdx=1;
        for (startIdx=1; startIdx<n; startIdx++){
            factorial[startIdx]=startIdx*factorial[startIdx-1];
            if (factorial[startIdx]>k) {
            	startIdx++; //because if it break out the loop, the startIdx will not add one at the end
                break;
            } 
        }
        String result = "";
        ArrayList<String> availNum = new ArrayList<>(n);
        for (int i=0; i<n; i++) availNum.add((i+1)+"");
        
        for (int i=n; i>startIdx; i--){
            result+=availNum.get(0);
            availNum.remove(0);
        }
        
        for (int i=startIdx; i>0; i--){
            result+=availNum.get(k/factorial[i-1]);
            availNum.remove(k/factorial[i-1]);
            k = k%factorial[i-1];
        }
        
        return result;
    }

	public static void main(String[] args) {
		PermutationSequence test = new PermutationSequence();
		int n = 3;
		int k = 2;
		System.out.println(test.getPermutation(n, k));

	}

}
