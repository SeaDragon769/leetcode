package basic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LargestRectangleinHistogram_84 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int[] leftIndex=new int[heights.length];
        int[] rightIndex=new int[heights.length];
        stack.push(-1);
        for(int i=0;i<heights.length;i++){
            while (stack.peek()!=-1&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            leftIndex[i]=stack.peek();
            stack.push(i);
        }
        stack.clear();
        stack.push(heights.length);
        for(int i=heights.length-1;i>=0;i--){
            while(stack.peek()!=heights.length&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            rightIndex[i]=stack.peek();
            stack.push(i);
        }
        int result=0;
        for(int i=0;i<heights.length;i++){
            result=Math.max(result,heights[i]*(rightIndex[i]-leftIndex[i]-1));
        }
        return result;
    }

    public int largestRectangleArea2(int[] heights) {
        int result=0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(-1);
        for(int i=0;i<heights.length;i++){
            while (stack.peek()!=-1&&heights[stack.peek()]>=heights[i]){
                int index=stack.pop();
                result=Math.max((i-stack.peek()-1)*heights[index],result);
            }
            stack.push(i);

        }
        while(stack.peek()!=-1){
            int index=stack.pop();
            result=Math.max((heights.length-stack.peek()-1)*heights[index],result);
        }
        return result;
    }

    public static void main(String[] args) {
        LargestRectangleinHistogram_84 largestRectangleinHistogram_84=new LargestRectangleinHistogram_84();
        largestRectangleinHistogram_84.largestRectangleArea2(new int[]{5,4,1,2});
    }
}
