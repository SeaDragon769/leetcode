package basic;

public class IsValidBst {
    public boolean isValidBST(TreeNode root) {

        if(root==null){
            return true;
        }
        if(root.left==null&&root.right==null){
            return true;
        }
        if(root.left!=null){
            if(root.val<=root.left.val){
                return false;
            }
        }
        if(root.right!=null){
            if(root.val>=root.right.val){
                return false;
            }
        }



        TreeNode left=root.left;
        if(left!=null){
            int leftMax=left.val;
            while(left!=null){
                leftMax=left.val;
                left=left.right;
            }
            if(root.val<=leftMax){
                return false;
            }
        }

        TreeNode right=root.right;
        if(right!=null) {
            int rightMin = right.val;
            while (right != null) {
                rightMin = right.val;
                right = right.left;
            }
            if(root.val>=rightMin){
                return false;
            }
        }
        return isValidBST(root.left)&&isValidBST(root.right);

    }
}
