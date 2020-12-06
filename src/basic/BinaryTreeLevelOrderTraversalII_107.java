package basic;

import com.sun.org.apache.xml.internal.utils.ObjectStack;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<Object[]> levelOrder=new ArrayList<>();
        if(root==null){
            return new ArrayList<>();
        }
        Queue<Object[]> queue=new ArrayDeque<>();
        queue.offer(new Object[]{1,root});
        while(!queue.isEmpty()){
            Object[] o=queue.poll();
            levelOrder.add(o);
            int level=(int)o[0];
            TreeNode node=(TreeNode) o[1];
            if(node.right!=null){
                queue.offer(new Object[]{level+1,node.right});
            }
            if(node.left!=null){
                queue.offer(new Object[]{level+1,node.left});
            }
        }
        int currentLevel=-1;
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> layer=new ArrayList<>();
        for(int i=levelOrder.size()-1;i>=0;i--){
            int lvl=(int)(levelOrder.get(i)[0]);
            TreeNode node=(TreeNode)levelOrder.get(i)[1];
            if(lvl==currentLevel){
                layer.add(node.val);
            }else{
                if(i!=levelOrder.size()-1) {
                    result.add(layer);
                }
                layer=new ArrayList<>();
                currentLevel=lvl;
                layer.add(node.val);
            }
            if(i==0){
                result.add(layer);
            }
        }
        return result;
    }
}
