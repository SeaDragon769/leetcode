package basic;

public class MergeList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node=new ListNode(0);
        ListNode pre=node;
        while(l1!=null||l2!=null){
            if(l1==null){
                node.next=l2;
                l2=l2.next;
            }else if(l2==null){
                node.next=l1;
                l1=l1.next;
            }else{
                if(l1.val<l2.val){
                    node.next=l1;
                    l1=l1.next;
                }else{
                    node.next=l2;
                    l2=l2.next;
                }
            }
            node=node.next;
        }
        return pre.next;

    }
}
