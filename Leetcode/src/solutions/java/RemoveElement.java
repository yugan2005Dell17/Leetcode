package solutions.java;

public class RemoveElement {
	
    public int removeElement(int[] A, int elem) {
        if (A==null||A.length==0) return 0;
        int i=A.length-1;
        int j=i;
        while (i>=0) {
            if (A[i]==elem) {
                if (i==j) {
                    j--;
                }
                else {
                    int temp = A[j];
                    A[j]=A[i];
                    A[i] = temp;
                    j--;
                }
            }
            i--;
        }
        
        return j+1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
