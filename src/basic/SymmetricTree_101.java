package basic;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }

        Queue<TreeNode> left = new LinkedList<TreeNode>();
        Queue<TreeNode> right = new LinkedList<TreeNode>();
        left.offer(root.left);
        right.offer(root.right);
        boolean result=true;
        while(!left.isEmpty()&&!right.isEmpty()){
            TreeNode leftNode=left.poll();
            TreeNode rightNode=right.poll();
            if(leftNode==null&&rightNode==null){
                continue;
            }
            if(leftNode==null||rightNode==null||leftNode.val!=rightNode.val){
                result=false;
                break;
            }
            left.offer(leftNode.left);
            left.offer(leftNode.right);
            right.offer(rightNode.right);
            right.offer(rightNode.left);
        }

        return result;
    }

    public boolean isSymmetric2(TreeNode root) {
        if(root==null){
            return true;
        }
        TreeNode left=root.left;
        TreeNode right=root.right;
        return symmetric(left,right);
    }

    private boolean symmetric(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null||left.val!=right.val){
            return false;
        }
        return symmetric(left.left,right.right)
                &&symmetric(left.right,right.left);

    }

}
