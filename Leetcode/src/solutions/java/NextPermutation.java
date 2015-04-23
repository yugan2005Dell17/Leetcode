package solutions.java;

public class NextPermutation {
	
    public void nextPermutation(int[] num) {
        if (num==null||num.length==0 || num.length==1) return;
        for (int i=num.length-1; i>0; i--){
        	for (int j=i-1; j>=0; j--){
        		if (isFirstLarger(num[i], num[j])) {
        			/*
        			 * Up to this point, the first insertion point has been found
        			 * The next permutation should be num[i] at the jth position
        			 * but it is not done yet: I have a bug here.
        			 * the next step is
        			 * 1: switch num[i] and num[j]
        			 * 2: Note that sub-array [i+1,...end] (# of element is (end-i) )has already in the maximum permutation order
        			 * 3: Also note that the order between [j+1, ... i] (# of element is (i-j) ) is unknown (after switch)
        			 * 4: Switch the sub-array [j+1,... (end-(i+1))+(j+1)] with [i+1,...end] in reverse order
        			 * 5: this Swith has two cases:
        			 * 	a: (end-i)<=(i-j) -> complete reverse switch
        			 * 	b: (end-i)>(i-j) -> Still complete reverse switch doesn't matter.
        			 * 6: sort the sub-array [(end-(i+1))+(j+1)+1, ... end] for the smallest permutation.
        			 */
        			// step 1
        			switchPos(num, i, j);
        			// step 2,3,4,5
        			for (int k=num.length-1, l=1; k>i; k--, l++){
        				switchPos(num, k, (j+l));
        			}
        			// step 6 sort [(end-i+j+1,...end)]
        			// for no extra memory, we cannot use mergesort, only quicksort is appropriate
        			quickSort(num, num.length-i+j, num.length-1);
        			
        			return;
        		}
        	}
        }
        for (int i=0, j=num.length-1; i<j; i++,j--){
        	switchPos(num, i, j);
        }
        return;
    }
    
    private boolean isFirstLarger(int i, int j){
        String temp = String.valueOf(i)+String.valueOf(j);
        int firstFront = Integer.parseInt(temp);
        temp = String.valueOf(j)+String.valueOf(i);
        int secondFront = Integer.parseInt(temp);
        return (firstFront>secondFront);
    }
    
    private void switchPos(int[] num, int i, int j){
        int temp = num[i];
        num[i]=num[j];
        num[j]=temp;
        return;
    }
    
    private void quickSort(int[] num, int i, int j){
    	// quick sort between i and j (i<=j)
    	if (i>=j) return;
    	if ((j-i)==1) {
    		if (isFirstLarger(num[i], num[i+1])) switchPos(num, i, j);
    		return;
    	}
    	
    	int pivot = num[i];
    	int startIdx=i;
    	int endIdx=j;
    	// j-i>=2 will be guaranteed.->endIdx-startIdx>=1
    	while (true){
    		while (isFirstLarger(pivot, num[startIdx])) {
    			startIdx++;
//    			if (startIdx>j) break; // do not need this, because num[i] will guard against this case.
    		} // all element less than startIdx < pivot, num[startIdx]>=pivot
    		while(!isFirstLarger(pivot, num[endIdx])) {
    			endIdx--;
    			if (endIdx==i) break;
    		} //all element later than endIdx >= pivot, num[endIdx]< pivot or (all element >= pivot and endIdx=i)
    		if (startIdx<endIdx) {
    			switchPos(num, startIdx, endIdx);
    			// [i,...,startIdx] < pivot <= [endIdx, ...j]
    		}
    		else break;
    	}
    	quickSort(num, i, endIdx-1);
    	quickSort(num, endIdx+1, j);
    }


	public static void main(String[] args) {
		NextPermutation test = new NextPermutation();
//		int[] num = {1,2,3};
//		int[] num = {1,3,2};
//		int[] num = {2,3,1}; 
		int[] num = {4,2,0,2,3,2,0};
		
		String output="";
		for (int eachNum:num){
			output+=eachNum+",";
		}
		System.out.println(output);


		test.nextPermutation(num);
		output="";
		for (int eachNum:num){
			output+=eachNum+",";
		}
		System.out.println(output);

	}

}
