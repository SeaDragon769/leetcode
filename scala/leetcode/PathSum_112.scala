package leetcode

object PathSum_112 {
  def hasPathSum(root: TreeNode, sum: Int): Boolean = {
      if(root==null){
        return false
      }
      if(root.left==null&&root.right==null){
        return root.value==sum
      }

      hasPathSum(root.left,sum-root.value)||hasPathSum(root.right,sum-root.value)
  }
}
