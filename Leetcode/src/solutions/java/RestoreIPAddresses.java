package solutions.java;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s==null || s.length()<4 || s.length()>12) return result;
        
        dfsIpAddress(result, s, 0, "");
        return result;
    }
    
    private void dfsIpAddress(List<String> result, String s, int depth, String ipAddress) {
        
        int curStrLen=s.length()-ipAddress.length()+depth; // Note: +depth because the added '.' in the ipAddress
        int startIdx = ipAddress.length()-depth; // Note: -depth because the added '.' in the ipAddress


        if (depth==3) {
            if (curStrLen>0 && curStrLen<=3 && Integer.parseInt(s.substring(startIdx, s.length()))<=255) {
                String newIpAddress=ipAddress+s.substring(startIdx, s.length());
                result.add(newIpAddress);
            }
            else return;
        }
        int curSegNum=4-depth;
        int minLen = Math.max(curStrLen-3*(curSegNum-1),1);
        int maxLen = Math.min(curStrLen-curSegNum+1,3);
        for (int i=minLen; i<=maxLen; i++){
            if (Integer.parseInt(s.substring(startIdx, startIdx+i))<=255) {
                String newIpAddress=ipAddress+s.substring(startIdx, startIdx+i)+".";
                dfsIpAddress(result, s, depth+1, newIpAddress);
            }
        }
    }

	public static void main(String[] args) {
		
		RestoreIPAddresses test = new RestoreIPAddresses();
//		String s = "0000";
//		String s = "25525511135";
		String s = "010010";

		List<String> result = test.restoreIpAddresses(s);
		
		for (String eachIp:result){
			System.out.println(eachIp);
		}

	}

}
