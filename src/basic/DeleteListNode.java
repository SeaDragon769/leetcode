package basic;

public class DeleteListNode {
    public void deleteNode(ListNode node) {
        ListNode next=node.next;
        ListNode nextNext=node.next.next;
        node.val=next.val;
        node.next=nextNext;

    }
}
