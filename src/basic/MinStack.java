package basic;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    /** initialize your data structure here. */
    Deque<Integer> stack;
    Deque<Integer> min;
    public MinStack() {
        stack=new ArrayDeque<>();
        min=new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
        if(min.isEmpty()){
            min.push(x);
        }else{
            if(min.peek()>=x){
                min.push(x);
            }
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        int result= stack.pop();
        if(min.peek()==result){
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2

    }
}
