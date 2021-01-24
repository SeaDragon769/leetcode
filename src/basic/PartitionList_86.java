package basic;

public class PartitionList_86 {
    public ListNode partition(ListNode head, int x) {
        ListNode start=new ListNode(0);
        start.next=head;
        ListNode left=start;
        while(left.next!=null){
            if(left.next.val<x){
                left=left.next;
            }else{
                ListNode right=left;
                while(right.next!=null){
                    if(right.next.val>=x){
                        right=right.next;
                    }else{
                        break;
                    }
                }
                if(right.next!=null){
                    ListNode less=right.next;
                    right.next=less.next;
                    less.next=left.next;
                    left.next=less;
                    left=left.next;
                }else{
                    break;
                }
            }
        }
        return start.next;

    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(1);
//        ListNode node3=new ListNode(3);
//        ListNode node4=new ListNode(2);
//        ListNode node5=new ListNode(5);
//        ListNode node6=new ListNode(2);
        node1.next=node2;
//        node2.next=node3;
//        node3.next=node4;
//        node4.next=node5;
//        node5.next=node6;
        PartitionList_86 partitionList_86=new PartitionList_86();
        partitionList_86.partition(node1,2);
    }
}
