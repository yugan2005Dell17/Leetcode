package solutions.java;

public class MaximumSubarray2 {
	public int maxSubArray(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        return dac(nums, 0, nums.length-1);
	}

	private int dac(int[] nums, int i, int j) {
		// dac means divide and conquer
		if (i>=j) return nums[i];
        int maxLeft, maxRight, maxMiddle, max;
        int m=i+(j-i)/2;
        maxLeft=dac(nums, i, m-1);
        maxRight=dac(nums,m+1, j);
        maxMiddle=nums[m];
        int sumMiddle=nums[m];
        for(int k=m+1; k<=j; k++){
        	sumMiddle+=nums[k];
        	if (sumMiddle>maxMiddle) maxMiddle=sumMiddle;
        }
        sumMiddle=maxMiddle; // bug here !
        for (int k=m-1; k>=i; k--){
        	sumMiddle+=nums[k];
        	if (sumMiddle>maxMiddle) maxMiddle=sumMiddle;
        }
        if (maxMiddle>maxLeft) max=maxMiddle;
        else max = maxLeft;
        if (max<maxRight) max = maxRight;
		return max;
	}



	public static void main(String[] args) {
		MaximumSubarray2 test = new MaximumSubarray2();
//		int[] nums={8,-19,5,-4,20};
//		int[] nums={-2,1};
		int[] nums={1,2,-1,-2,2,1,-2,1};

		System.out.println(test.maxSubArray(nums));

	}

}
