package basic;

public class SumRoottoLeafNumbers_129 {
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        return sum(root,0);

    }
    private int sum(TreeNode root,int sum){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return root.val+sum*10;
        }
        return sum(root.left,root.val+sum*10)+sum(root.right,root.val+sum*10);
    }

}
