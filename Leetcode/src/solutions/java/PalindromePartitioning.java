package solutions.java;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	
    public List<List<String>> partition(String s) {
        if (s==null||s.length()==0) return new ArrayList<List<String>>();
        
        ArrayList<List<String>>[] result =(ArrayList<List<String>>[]) new ArrayList[s.length()];
        result[0]=new ArrayList<List<String>>();
        List<String> curList = new ArrayList<String>();
        curList.add(s.substring(0,1));
        result[0].add(curList);

        for (int i=1; i<s.length(); i++){
            result[i] = new ArrayList<List<String>>();
            if (isPalindrome(s.substring(0,i+1))) {
            	curList=new ArrayList<String>(1);
            	curList.add(s.substring(0, i+1));            	
            	result[i].add(curList);
            }
            for (int j=i-1; j>=0; j--){
                if (isPalindrome(s.substring(j+1,i+1))) {
                    for (List<String> prevList:result[j]){
                    	curList =(ArrayList<String>) ((ArrayList<String>) prevList).clone(); //shallow clone will be enough
                    	curList.add(s.substring(j+1,i+1));
                        result[i].add(curList);
                    }
                }
            }

            
        }
        
        return result[s.length()-1];
        
    }
    
    private boolean isPalindrome(String s){
        for (int i=0, j=s.length()-1; i<=j; i++, j--) if (s.charAt(i)!=s.charAt(j)) return false;
        return true;
    }

	public static void main(String[] args) {
		PalindromePartitioning test = new PalindromePartitioning();
		String s="aab";
		List<List<String>> result = test.partition(s);
		System.out.println("[");
		for (List<String> eachList:result){
			String printStr = "  [";
			for (String eachStr:eachList) printStr+="\""+eachStr+"\", ";
			printStr=printStr.substring(0, printStr.length()-2)+"],";
			System.out.println(printStr);
		}
		System.out.println("]");
	}
}
