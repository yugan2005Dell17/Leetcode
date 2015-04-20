package solutions.java;

public class InsertionSortList {
	
    public ListNode insertionSortList(ListNode head) {
        if (head==null) return head;
        ListNode sortedHead= new ListNode(0);//dummy head
        sortedHead.next= new ListNode(head.val);
        ListNode node = head.next;
        
        while (node!=null){
            ListNode sortedNode= new ListNode(node.val);
            ListNode preNode = sortedHead;
            while (preNode.next!=null) {
                if (sortedNode.val<preNode.next.val){
                    ListNode tempNode = preNode.next;
                    preNode.next = sortedNode;
                    sortedNode.next=tempNode;
                    break;
                }
                else preNode=preNode.next;
                
            }
            if (preNode.next==null) preNode.next=sortedNode;
            node = node.next;
        }
        
        head=sortedHead.next;        
        return head;
    }

	public static void main(String[] args) {
		InsertionSortList test = new InsertionSortList();
		ListNode head= new ListNode(1);
		ListNode result = test.insertionSortList(head);
		String printout="";
		while (result!=null) {
			printout+=result.val+", ";
			result=result.next;
		}
		System.out.println(printout);

	}

}
