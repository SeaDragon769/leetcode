package basic;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle_85 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int[][] num=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(j==0&&matrix[i][j]=='1'){
                    num[i][j]=1;
                }else if(matrix[i][j]=='1'){
                    num[i][j]=num[i][j-1]+1;
                }
            }
        }
        int result=0;
        for(int j=0;j<matrix[0].length;j++){
            result=Math.max(largestRectangleArea2(num,j),result);
        }
        return result;
    }
    private int largestRectangleArea2(int[][] heights,int j) {
        int result=0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(-1);
        for(int i=0;i<heights.length;i++){
            while (stack.peek()!=-1&&heights[stack.peek()][j]>=heights[i][j]){
                int index=stack.pop();
                result=Math.max((i-stack.peek()-1)*heights[index][j],result);
            }
            stack.push(i);

        }
        while(stack.peek()!=-1){
            int index=stack.pop();
            result=Math.max((heights.length-stack.peek()-1)*heights[index][j],result);
        }
        return result;
    }
}
