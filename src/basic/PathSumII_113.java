package basic;

import java.util.ArrayList;
import java.util.List;

public class PathSumII_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> solution=new ArrayList<>();
        dfs(root,result,solution,sum);
        return result;

    }


    private void dfs(TreeNode root,List<List<Integer>> result,List<Integer> solution,int target){
        if(root==null){
            return;
        }
        if(root.val==target&&root.left==null&&root.right==null){
            List<Integer> temp=new ArrayList<>(solution);
            temp.add(root.val);
            result.add(temp);
        }else{
            solution.add(root.val);
            dfs(root.left,result,solution,target-root.val);
            dfs(root.right,result,solution,target-root.val);
            solution.remove(solution.size()-1);
        }

    }
}
