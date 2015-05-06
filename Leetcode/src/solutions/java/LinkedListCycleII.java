package solutions.java;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next=head;
        boolean hasCycle = false;
        
        ListNode oneStep = dummyHead;
        ListNode twoStep = dummyHead;
        
        // the 1st time meet
        while(oneStep!=null && twoStep!=null && twoStep.next!=null){
            oneStep=oneStep.next;
            twoStep=twoStep.next.next;
            if (oneStep==twoStep) {
                hasCycle=true;
                break;
            }
        }
        if (!hasCycle) return null;
        
        // the 2nd time meet
        ListNode oneStepNumTwo = dummyHead;
        
        while(true){
            oneStep=oneStep.next;
            oneStepNumTwo=oneStepNumTwo.next;
            if (oneStep==oneStepNumTwo) break;
        }
        return oneStepNumTwo;
    }
}
