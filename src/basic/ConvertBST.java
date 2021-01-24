package basic;

import sun.reflect.generics.tree.Tree;

public class ConvertBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums,0,nums.length-1);
    }


    private TreeNode toBST(int[] nums,int start,int end){
        if(start>end){
            return null;
        }
        if(start==end){
            return new TreeNode(nums[start]);
        }
        int middle=(start+end)/2;
        TreeNode midNode=new TreeNode(nums[middle]);
        midNode.left=toBST(nums,start,middle-1);
        midNode.right=toBST(nums,middle+1,end);
        return midNode;
    }


}
