package basic;

public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null;
        ListNode temp=null;
        int c=0;

        while(l1!=null||l2!=null||c>0){
            int val=0;
            if(l1!=null){
                val=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                val+=l2.val;
                l2=l2.next;
            }
            val+=c;
            if(val>=10){
                val=val-10;
                c=1;
            }else{
                c=0;
            }

            if(head==null){
                temp=new ListNode(val);
                head=temp;
            }else{
                temp.next=new ListNode(val);
                temp=temp.next;
            }
        }

        return head;
    }
}
