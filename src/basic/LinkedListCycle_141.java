package basic;

public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head.next;

        while(fast!=null){
            if(fast.val==slow.val){
                return true;
            }
            fast=fast.next;
            if(fast==null){
                return false;
            }
            if(fast.val==slow.val){
                return true;
            }
            fast=fast.next;
            slow=slow.next;
        }
        return false;
    }
}
