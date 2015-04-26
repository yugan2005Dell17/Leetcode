package solutions.java;

import java.util.ArrayList;

public class HappyNumber {
	public boolean isHappy(int n) {
        ArrayList<Integer> visited = new ArrayList<Integer>();
        while (true) {
            int sumSquare = 0;
            while (n!=0) {
                sumSquare+=(n%10)*(n%10);
                n/=10;
            }
            if (sumSquare==1) return true;
            else if (visited.contains(sumSquare)) return false;
            else {
                visited.add(sumSquare);
                n=sumSquare;
            }
        }
        
    }

}
