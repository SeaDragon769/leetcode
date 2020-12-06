package basic;

public class MiddleoftheLinkedList_876 {

    public ListNode middleNode(ListNode head) {
        ListNode s=head;
        ListNode f=head;

        while(f!=null){

            f=f.next;
            if(f==null){
                break;
            }
            f=f.next;
            s=s.next;
        }

        return s;

    }

}
