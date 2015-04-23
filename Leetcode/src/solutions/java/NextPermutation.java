package solutions.java;

public class NextPermutation {
	
    public void nextPermutation(int[] num) {
        if (num==null||num.length==0 || num.length==1) return;
        for (int i=num.length-2; i>=0; i--){
        	for (int j=num.length-1; j>i; j--){
        		if (num[j]>num[i]) {
        			/*
        			 * Up to this point, the first insertion point has been found
        			 * The next permutation should be num[i] at the jth position
        			 * but it is not done yet: I have a bug here.
        			 * for the subArray [i+1,...end] it has to reverse the order
        			 */
        			switchPos(num, i, j);
        			reverseOrder(num, i+1, num.length-1);        			
        			return;
        		}
        	}
        }
        reverseOrder(num, 0, num.length-1);
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
		NextPermutation test = new NextPermutation();
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
