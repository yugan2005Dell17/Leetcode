package solutions.java;

public class LinkedListCycle {
	
	public class Solution {
	    public boolean hasCycle(ListNode head) {
	        ListNode dummyHead = new ListNode(0);
	        dummyHead.next = head;
	        
	        ListNode oneStep = dummyHead;
	        ListNode twoStep = dummyHead;
	        
	        boolean result = false;
	        
	        while (oneStep!=null && twoStep!=null && twoStep.next!=null) {
	            oneStep = oneStep.next;
	            twoStep = twoStep.next.next;
	            if (oneStep==twoStep) return true;
	        }
	        
	        return false;
	    }
	}

}
