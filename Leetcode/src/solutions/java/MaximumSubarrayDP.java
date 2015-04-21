package solutions.java;

public class MaximumSubarrayDP {
	/*
	 * This solution using DP method with O(n) complexity. There is a picture in the note folder for explanation.
	 * Not very fast though.
	 */
    public int maxSubArray(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        
        int sum, maxSum;
        sum=nums[0];
        maxSum=nums[0];
        
        for(int i=1; i<nums.length; i++){
            if (sum<0) sum=0;
            sum += nums[i];
            if (sum>maxSum) maxSum=sum;
        }
        
        return maxSum;
    }

}
