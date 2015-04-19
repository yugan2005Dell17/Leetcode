package solutions.java;

public class IntersectionOfTwoLinkedLists {
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null) return null;
        
        int lenA = 0;
        ListNode node = headA;
        while (node!=null) {
            lenA++;
            node=node.next;
        }
        
        int lenB = 0;
        node = headB;
        while (node!=null) {
            lenB++;
            node=node.next;
        }
        
        int diff = (lenA<lenB)?(lenB-lenA):(lenA-lenB);
        
        node = (lenA<lenB)?headB:headA;
        
        ListNode node2=(lenA<lenB)?headA:headB;
        
        for(int i=0; i<diff; i++) node=node.next;
        
        while (node!=null){
            if (node==node2) return node;
            else {
                node = node.next;
                node2=node2.next;
            }
        }
        return null;
    }

	public static void main(String[] args) {

	}

}
