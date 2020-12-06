package basic;

public class RemoveLinkedListElements_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            if(cur.val==val){
                ListNode temp=cur;
                if(pre==null){
                    cur=cur.next;
                    head=cur;
                }else{
                    pre.next=cur.next;
                    cur=cur.next;
                }
                temp.next=null;
            }else{
                pre=cur;
                cur=cur.next;
            }
        }
        return head;
    }
}
