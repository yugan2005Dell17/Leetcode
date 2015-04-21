package solutions.java;

public class MaximumSubarray3 {
	public int maxSubArray(int[] nums) {
		// this is Lao Lu taught in class
        if (nums==null || nums.length==0) return 0;
        int[] prefixSum = new int[nums.length+1];
        /*
         * This is different than the stock problem, we need one extra longer for the prefixSum
         * because the first element need be included, but in stock problem it is going to 0 profit.
         */
        prefixSum[0]=0;
        for (int i=0; i<nums.length;i++){
        	prefixSum[i+1]=nums[i]+prefixSum[i];
        }
        
        /*
         * Cannot directly use BTTBASSDP, because in stock trading the profit >=0
         * Also the starting element is not included yet.
         * But the same logic can be used
         */
//        BTTBASSDP buyAndSellStock = new BTTBASSDP();
//        return buyAndSellStock.maxProfit(prefixSum);
        int min=prefixSum[0];
        int max=prefixSum[1];
        /*
         * Be very careful about the two different index. A really hard to find bug
         */
        for (int i=1; i<prefixSum.length; i++){
        	/*
        	 * the sequence of these two if clause in this problem is important
        	 * in stock problem it is not, because profit always > 0
        	 */
            if (prefixSum[i]-min>max) max = prefixSum[i]-min;
            if (prefixSum[i]<min) min = prefixSum[i];
        }
        
        return max;
	}
	
	public static void main(String args[]){
		MaximumSubarray3 test = new MaximumSubarray3();
//		int[] nums={8,-19,5,-4,20};
//		int[] nums={-2,1};
//		int[] nums={1,2,-1,-2,2,1,-2,1};
//		int[] nums={-1};
		int[] nums={-2,-1};


		System.out.println(test.maxSubArray(nums));
	}

}
