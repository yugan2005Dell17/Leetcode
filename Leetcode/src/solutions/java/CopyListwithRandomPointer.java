package solutions.java;

import java.util.HashMap;

public class CopyListwithRandomPointer {
	
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> mapOfCopy = new HashMap<>();
        RandomListNode dummyHead = new RandomListNode(0);
        dummyHead.next=head;
        RandomListNode copyDummyHead = new RandomListNode(0);
        RandomListNode curNode = dummyHead;
        RandomListNode copyCurNode = copyDummyHead;
        while (curNode.next!=null) {
        	curNode=curNode.next;
        	RandomListNode copyNode = new RandomListNode(curNode.label);
        	copyCurNode.next = copyNode;
        	copyCurNode = copyCurNode.next;
        	mapOfCopy.put(curNode, copyCurNode);
        }
        curNode = dummyHead;
        copyCurNode = copyDummyHead;
        while (curNode.next!=null) {
        	curNode=curNode.next;
        	RandomListNode randomNode = curNode.random;
        	RandomListNode copyRandomNode = mapOfCopy.get(randomNode);
        	copyCurNode = copyCurNode.next;
        	copyCurNode.random=copyRandomNode;
        }        
        
        return copyDummyHead.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
