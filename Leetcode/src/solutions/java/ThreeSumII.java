package solutions.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreeSumII {
	
    public List<List<Integer>> threeSum(int[] num) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (num==null||num.length<=2) return result;
    	randomrize(num);
    	quickSort(num, 0, num.length-1);
    	
    	for (int i=0; i<num.length-2;i++){
    		if (i!=0 && num[i]==num[i-1]) continue;
    		for (List<Integer> twoSumResult: twoSum(num, i+1, num.length-1, -1*num[i])){
    			twoSumResult.add(0, num[i]);
    			result.add(twoSumResult);
    		}
    	}
    	
    	return result;
    }
    	

	private List<List<Integer>> twoSum(int[] num, int i, int j, int target) {
		List<List<Integer>> result = new ArrayList<>();
		while (i<j) {
			if (num[i]+num[j]>target) {
				while (j>i && num[j-1]==num[j]) j--;
				j--;
			}
			else if (num[i]+num[j]<target) {
				while (j>i && num[i+1]==num[i]) i++;
				i++;
			}
			else {
				List<Integer> curResult = new ArrayList<>();
				curResult.add(num[i]);
				curResult.add(num[j]);
				result.add(curResult);
				while (j>i && num[i+1]==num[i]) i++;
				while (j>i && num[j-1]==num[j]) j--;
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
		
		ThreeSumII test = new ThreeSumII();
		int[] input = {0,0,0};
//		int[] input = {-2,0,0,2,2};

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
