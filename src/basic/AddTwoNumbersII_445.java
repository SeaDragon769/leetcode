package basic;

import com.sun.scenario.effect.impl.state.LinearConvolveKernel;

import java.util.Stack;

public class AddTwoNumbersII_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1=new Stack<Integer>();
        Stack<Integer> stack2=new Stack<Integer>();
        Stack<Integer> result=new Stack<>();
        while (l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }

        ListNode head=null;
        ListNode temp=null;
        int c=0;
        while(!stack1.isEmpty()||!stack2.isEmpty()||c>0){
            int val=0;
            if(!stack1.isEmpty()){
                val+=stack1.pop();
            }
            if(!stack2.isEmpty()){
                val+=stack2.pop();
            }
            val+=c;
            if(val>=10){
                val=val-10;
                c=1;
            }else {
                c=0;
            }
            result.push(val);

        }
        while(!result.isEmpty()){
            if(head==null){
                temp=new ListNode(result.pop());
                head=temp;
            }else{
                temp.next=new ListNode(result.pop());
                temp=temp.next;
            }
        }
        return head;
    }
}
