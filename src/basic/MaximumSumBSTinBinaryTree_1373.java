package basic;

public class MaximumSumBSTinBinaryTree_1373 {
    private int maxSum=Integer.MIN_VALUE;

    public int maxSumBST(TreeNode root) {
        bstSum(root);
        if(maxSum<0){
            return 0;
        }
        return maxSum;
    }

    private int bstSum(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            maxSum=Math.max(maxSum,root.val);
            return root.val;
        }
        int leftSum=bstSum(root.left);
        int rightSum=bstSum(root.right);
        if(root.left!=null&&root.val<=root.left.val){
            return Integer.MIN_VALUE;
        }
        if(root.right!=null&&root.val>=root.right.val){
            return Integer.MIN_VALUE;
        }
        if((root.left==null||leftSum!=Integer.MIN_VALUE)&&(root.right==null||rightSum!=Integer.MIN_VALUE)){
            maxSum=Math.max(maxSum,root.val+leftSum+rightSum);
            return root.val+leftSum+rightSum;
        }else {
            return Integer.MIN_VALUE;
        }
    }

}
