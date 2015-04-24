package solutions.java;

public class RemoveLinkedListElements {
	
    public ListNode removeElements(ListNode head, int val) {
        if (head==null) return null;
        ListNode preNode, curNode;
        ListNode dummyHead = new ListNode(val+1);
        dummyHead.next=head;
        preNode = dummyHead;
        curNode = head;
        while(curNode.next!=null){
            if (curNode.val==val) {
                preNode.next = curNode.next;
                curNode.next = null; // garbage collection
            }
            else {
                preNode = curNode;
            }
            curNode=preNode.next;
        }
        return dummyHead.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
