package solutions.java;


public class CopyListwithRandomPointerII {
	
    public RandomListNode copyRandomList(RandomListNode head) {
    	RandomListNode dummyHead = new RandomListNode(0);
    	dummyHead.next = head;
    	
    	RandomListNode curNode = dummyHead;
    	while (curNode!=null) {
    		/*
    		 * insert a copy of the note, and only handling the next link at this stage.
    		 * Specially note that after this, both the original and copied linkedList are linked together
    		 * with the next link all taken care of (jump by 2)
    		 * the original list's random link is preserved, but the copied list's random link has not been handled yet.
    		 */
    		RandomListNode copyCurNode = new RandomListNode(curNode.label);
    		copyCurNode.next = curNode.next;
    		curNode.next=copyCurNode;
    		curNode = copyCurNode.next;    			
    		}
    	
    	curNode = dummyHead;
    	while (curNode!=null) {// handling the random link at this stage
    		if (curNode.random!=null) {
    			curNode.next.random=curNode.random.next;
    		}
   			curNode=curNode.next.next;
    	}
    	
    	curNode = dummyHead;
    	RandomListNode copyDummyHead = curNode.next;
    	while (curNode!=null){// now separate the original and the copied list
    		RandomListNode copyCurNode = curNode.next;
    		curNode.next = copyCurNode.next;
    		if (curNode.next!=null) { // here is a little bit tricky, be careful about the ending
        		copyCurNode.next = curNode.next.next;
    		}
    		curNode = curNode.next;	
    	}
    	return copyDummyHead.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
