package solutions.java;

public class SearchInRotatedSortedArray {
	
    public int search(int[] A, int target) {
        if (A==null || A.length==0) return 0;
        int[] oriIdx = new int[A.length];
        int rotIdx = A.length-1;
        for(int i=0; i<A.length-1; i++){
            if (A[i]>A[i+1]) {
                rotIdx=i;
                break;
            }
        }
        if (rotIdx!=A.length-1){
            A = rotateBack(A, oriIdx, rotIdx);
        }
        else {
            for(int i=0; i<A.length; i++) oriIdx[i]=i;
        }
        int resultInNew = binarySearch(A, target);
        if (resultInNew ==-1) return -1;
        
        return oriIdx[resultInNew];
    }
    
    private int[] rotateBack(int[] A, int[] oriIdx, int rotIdx){
        int[] temp = new int[A.length];
        for (int i=rotIdx+1; i<A.length;i++) {
            temp[i-rotIdx-1]=A[i];
            oriIdx[i-rotIdx-1]=i;
        }
        for (int i=0; i<=rotIdx; i++) {
            temp[A.length-rotIdx-1+i]=A[i];
            oriIdx[A.length-rotIdx-1+i]=i;
        }
//        A = temp; // this is a big bug, I passed the reference to A will not be transferred outside!
        return temp;
    }
    
    private int binarySearch(int[] A, int target){
        int lo = 0;
        int hi = A.length-1;
        int mid = lo + (hi-lo)/2;
        while (lo<=hi) {
            if (A[mid]==target) return mid;
            if (A[mid]>target) hi=mid-1;
            else lo=mid+1;
            mid = lo + (hi-lo)/2;
        }
        return -1;
    }

	public static void main(String[] args) {
		
		SearchInRotatedSortedArray test = new SearchInRotatedSortedArray();
		int[] A = {3,1};
		int target = 1;
		System.out.println(test.search(A, target));
	}

}
