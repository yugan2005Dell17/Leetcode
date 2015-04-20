package solutions.java;

public class RemoveElement2 {
	
    public int removeElement(int[] A, int elem) {
        
        if(A==null || A.length==0) return 0;
        
        int lo=-1;
        for (int idx=0; idx<A.length; idx++){
            if (A[idx]==elem) { // find the first equal one from left
                lo=idx;
                break;
            }
        }
        
        if (lo==-1) return A.length;
        
        int hi=A.length;
        for (int idx=A.length-1; idx>=0; idx--) {
            if (A[idx]!=elem) { // find the first not equal one from right
                hi=idx;
                break;
            }
        }
        
        if (hi==A.length) return 0;
        
        while (lo<hi) {
            int temp = A[lo]; //exchange
            A[lo]=A[hi];
            A[hi]=temp;
            lo++;
            hi--;
            while (lo<A.length && A[lo]!=elem) lo++;
            while (hi>-1 && A[hi]==elem) hi--;
        }
        
        return lo;
    }

}
