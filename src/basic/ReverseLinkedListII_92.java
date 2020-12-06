package basic;

public class ReverseLinkedListII_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode current=head;
        ListNode pre=null;

        int i=1;
        while(i<m){
            pre=current;
            current=current.next;
            i++;
        }
        ListNode partHead=pre;
        ListNode tail=current;
        while(i<=n){
            ListNode next=current.next;
            current.next=pre;
            pre=current;
            current=next;
            i++;
        }
        if(partHead!=null){
            partHead.next=pre;
        }else{
            head=pre;
        }
        tail.next=current;

        return head;
    }
}
