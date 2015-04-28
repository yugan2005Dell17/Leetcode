package solutions.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class ThreeSumIV {
	
    public List<List<Integer>> threeSum(int[] num) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	HashSet<String> storedResult = new HashSet<>();
    	
    	if (num==null||num.length<=2) return result;
    	randomrize(num);
    	quickSort(num, 0, num.length-1);
    	
    	for (int i=0; i<num.length-2;i++){
    		for (List<Integer> twoSumResult: twoSum(num, i+1, num.length-1, -1*num[i])){
    			twoSumResult.add(0, num[i]);
    			String hashSetString = "";
    			for (int resultInt:twoSumResult){
    				hashSetString += resultInt;
    			}
    			if (!storedResult.contains(hashSetString))	{
    				result.add(twoSumResult);
    				storedResult.add(hashSetString);
    			}
    		}
    	}
    	
    	return result;
    }
    	

	private List<List<Integer>> twoSum(int[] num, int i, int j, int target) {
		List<List<Integer>> result = new ArrayList<>();
    	HashSet<String> storedResult = new HashSet<>();
		while (i<j) {
			if (num[i]+num[j]>target) {
				j--;
			}
			else if (num[i]+num[j]<target) {
				i++;
			}
			else {
				List<Integer> curResult = new ArrayList<>();
				curResult.add(num[i]);
				curResult.add(num[j]);
				String hashSetString = "";
    			for (int resultInt:curResult){
    				hashSetString += resultInt;
    			}
    			if (!storedResult.contains(hashSetString))	{
    				result.add(curResult);
    				storedResult.add(hashSetString);
    			}
				j--;
				i++;
			}
		}
		
		return result;
	}

	private void randomrize(int[] num){
    	/*
    	 * This is Fisher-Yates random shuffle implementation
    	 * http://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
    	 * O(n) complexity
    	 * To shuffle an array a of n elements (indices 0..n-1):
    	 * for i from 0 to n-1 do
    	 *        j ¡û random integer such that i ¡Ü j < n
    	 *        exchange a[j] and a[i] 
    	 */
    	Random random=new Random();
    	for (int i=1; i<num.length; i++){
    		int j = random.nextInt(num.length-i)+i; // 0<=random.nextInt(num.length-i)<num.length-i, so j is a random number i<=j<num.length
    		swap(num, i, j);
    	}
    }
	
    private void quickSort(int[] num, int lo, int hi) {
    	if (lo>=hi) return;
    	
    	int p = partition(num, lo, hi);
    	quickSort(num, lo, p-1);
    	quickSort(num, p+1, hi);
    	
	}
    
    private int partition(int[] num, int lo, int hi) {
    	int head, tail;
    	head = lo+1;
    	tail = hi;
    	while (true){
    		while (num[head]<=num[lo]) { // find the first head with num[head]>num[lo]
    			head++;
    			if (head>hi){// all elements are <= num[lo]
    				swap(num, lo, hi);
    				return hi;    				
    			}
    		}
    		while (num[tail]>num[lo]) { // find the first tail with num[tail] <= num[lo]
    			tail--; // tail will not be less than lo, because num[lo]==num[lo]
    		}
    		if (head<tail) { // 
    			swap(num, head, tail); // now [i+1,...head] <= lo < [tail,...hi]    			
    		}
    		else {
    			break; //the first time head>=tail, means it crosses
    			// and at this time num[tail] <= num[lo]
    		}
    	}
    	swap(num, lo, tail);
    	return tail;
	}

	private void swap(int[] num, int i, int j){
    	int temp = num[i];
    	num[i]=num[j];
    	num[j]=temp;
    }


	public static void main(String[] args) {
		
		ThreeSumIV test = new ThreeSumIV();
//		int[] input = {0,0,0};
//		int[] input = {-2,0,0,2,2};
		int[] input = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};

		List<List<Integer>> result = test.threeSum(input);
		String output= "[ ";
		for (List<Integer> eachResult:result){
			output+="[";
			for (int eachNumber:eachResult){
				output += eachNumber+",";
			}
			output = output.substring(0, output.length()-1);
			output+="]";
		}
		output +=" ]";
		System.out.println(output);

	}

}
