package basic;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> pathList=new ArrayList<>();
        if(root==null){
            return pathList;
        }

        String path=""+root.val;
        if(root.left==null&&root.right==null){
            pathList.add(path);
        }else {
            path(root.left, path, pathList);
            path(root.right, path, pathList);
        }
        return pathList;
    }

    private void path(TreeNode root,String path,List<String> pathList){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            pathList.add(path+"->"+root.val);
            return;
        }
        path(root.left,path+"->"+root.val,pathList);
        path(root.right,path+"->"+root.val,pathList);

    }

}
