package solutions.java;

public class SearchForARange {
	
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums==null || nums.length==0) return result;
        
        int i=0;
        int j=nums.length-1;
        int m = i+(j-i)/2;
        while (i<=j) {
            if (nums[m]>target) j=m-1;
            else if (nums[m]<target) i=m+1;
            else break;
            m = i+(j-i)/2;
        }
        if (i>j) return result;
        //find the start index
        int start1 = 0;
        int start2 = m;
        int middle = start1+(start2-start1)/2;
        while (true){
            if (nums[middle]==target) {
                if (middle==0 || nums[middle-1]!=target) break;
                else start2=middle-1;
            }
            else {
                if (nums[middle+1]==target) {
                    middle ++;
                    break;
                }
                else start1=middle+1;
            }
            middle = start1+(start2-start1)/2;
        }
        result[0]=middle;
        //find the end index
        int end1 = m;
        int end2 = nums.length-1;
        middle = end1+(end2-end1)/2;
        while (true){
            if (nums[middle]==target) {
                if (middle==nums.length-1 || nums[middle+1]!=target) break;
                else end1=middle+1;
            }
            else {
                if (nums[middle-1]==target) {
                    middle--;
                    break;
                }
                else end2=middle-1;
            }
            middle = end1+(end2-end1)/2;
        }
        result[1]=middle;
        return result;
    }

	public static void main(String[] args) {
		SearchForARange test = new SearchForARange();
		int[] input = {2,2};
		int target = 3;
		String output = "[";
		for (int num:test.searchRange(input, target)) {
			output += num+", ";
		}
		output = output.substring(0, output.length()-2)+"]";
		System.out.println(output);
	}

}
