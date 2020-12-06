package basic;

public class RemoveNthNodeFromEndofList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left=head;
        ListNode right=head;
        ListNode pre=null;
        for(int i=1;i<n;i++){
            right=right.next;
        }

        while(right.next!=null){
            pre=left;
            left=left.next;
            right=right.next;
        }
        if(pre!=null){
            pre.next=left.next;
        }else{
            head=left.next;
        }
        return head;



    }
}
