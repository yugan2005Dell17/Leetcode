package solutions.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreeSum {
	
    public List<List<Integer>> threeSum(int[] num) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (num==null||num.length<=2) return result;
    	randomrize(num);
    	quickSort(num, 0, num.length-1);
    	int repeatNum=1;
    	int[] uniqueNum = new int[num.length];
    	uniqueNum[0]=num[0];
    	int counter = 1;
    	for(int i=1; i<num.length;i++){
    		if (num[i]==num[i-1]){
    			repeatNum++;
    			if (repeatNum==2) {//note this take care of two repeated AND three repeated cases!
    				if (-2*num[i]<num[i]) {
    					int j = binaryFind(num, 0, i-2, -2*num[i]);
        				if (j!=-1) {
        	    			List<Integer> curResult = new ArrayList<Integer>(3);
        	    			curResult.add(num[j]);
        	    			curResult.add(num[i-1]);
        	    			curResult.add(num[i]);
        	    			result.add(curResult);
        				}
    				} else {
    					int j = binaryFind(num, i+1, num.length-1, -2*num[i]);
        				if (j!=-1) {
        	    			List<Integer> curResult = new ArrayList<Integer>(3);
        	    			curResult.add(num[i-1]);
        	    			curResult.add(num[i]);
        	    			curResult.add(num[j]);
        	    			result.add(curResult);
        				}
    				}
    			}
    		} else {
    			repeatNum=1;
    			uniqueNum[counter]=num[i];
    			counter++;
    		}
    	}
    	
    	num=new int[counter];
    	for (int i=0; i<counter; i++) num[i]=uniqueNum[i];
    	
    	for (int i=0; i<num.length-2; i++){
    		if (num[i]+num[i+1]+num[i+2]>0) break;
    		for (int j=i+1; j<num.length-1; j++){
    			if (num[i]+num[j]+num[j+1]>0) break;
    			int k = binaryFind(num, j+1, num.length-1, -1*(num[i]+num[j]));
    			if (k==-1) continue;
    			List<Integer> curResult = new ArrayList<Integer>(3);
    			curResult.add(num[i]);
    			curResult.add(num[j]);
    			curResult.add(num[k]);
    			result.add(curResult);
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
	
	private int binaryFind(int[] num, int i, int j, int k) {
		while (i<=j){
			int mid = i+(j-i)/2;
			if (k>num[mid]) i=mid+1;
			else if (k<num[mid]) j=mid-1;
			else return mid;
		}		
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
