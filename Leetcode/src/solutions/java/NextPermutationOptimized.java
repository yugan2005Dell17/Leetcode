package solutions.java;

public class NextPermutationOptimized {
	
    public void nextPermutation(int[] num) {
        if (num==null||num.length==0 || num.length==1) return;
        int swapFromIdx = 0;
        int swapToIdx = 0;
        for (int i=num.length-2; i>=0; i--){
			/*
			 * Do not need do it in O(n2) way. One time of transverse will be enough.
			 * The first for loop find the i need be swapped
			 * The second for loop find which j to be swapped with.
			 * It can be mathematically prove the correctness.
			 */
        	if (num[i]<num[i+1]) {
        		swapFromIdx = i;
        		break;
        	}
        }
        
        for (int j=num.length-1; j>swapFromIdx; j--){
        	if (num[j]>num[swapFromIdx]) {
        		swapToIdx = j;
        		break;
        	}
        }
        
        /* 
         * Note: it is the maximum permutation, the first and second for
         * loop will not find anything, therefore, both swapFromIdx = swapToIdx = 0; 
         */
        if (swapFromIdx==0 && swapToIdx==0) {
            reverseOrder(num, 0, num.length-1);
        	return;
        }
        switchPos(num, swapFromIdx, swapToIdx);
        reverseOrder(num, swapFromIdx+1, num.length-1);
        return;
    }    
 
    private void switchPos(int[] num, int i, int j){
        int temp = num[i];
        num[i]=num[j];
        num[j]=temp;
        return;
    }
    
    private void reverseOrder(int[] num, int i, int j){
    	while (i<j){
    		switchPos(num, i, j);
    		i++;
    		j--;
    	}
    	return;
    }
    


	public static void main(String[] args) {
		NextPermutationOptimized test = new NextPermutationOptimized();
//		int[] num = {1,2,3};
//		int[] num = {1,3,2};
//		int[] num = {2,3,1}; 
//		int[] num = {4,2,0,2,3,2,0};
		int[] num = {1,20,26,1,15,29,4,29,10,9,21,7,27,11,21,5,9,7,27,16,17,3,6,5,16,23,29,14,28,21,2,29,3,29,0,18,28,5,10,9,6,23,8,25,26,21,1,5,29,28,14,8,1,20,13,10};

		
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
