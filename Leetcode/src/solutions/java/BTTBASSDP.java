package solutions.java;

public class BTTBASSDP {
	// Best time to buy and sell stock using DP method
    public int maxProfit(int[] prices) {
    	if (prices==null || prices.length==0) return 0;
    	
    	int min = prices[0];
    	int maxProfit = 0;
    	for (int i=1; i<prices.length; i++){
    		if (prices[i]<min) min=prices[i];
    		if ((prices[i]-min)>maxProfit) maxProfit=prices[i]-min;
    	}
    	return maxProfit;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
