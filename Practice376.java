/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */

/**
 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
 */
public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean res = false;
        if(root1 != null && root2 != null){
            if(root1.val == root2.val){
                //比较根节点
                res = IsSample(root1,root2);
            }
            if(!res){
                res = HasSubtree(root1.left,root2);
            }
            if(!res){
                res = HasSubtree(root1.right,root2);
            }
        }
        return res;
    }

    public boolean IsSample(TreeNode node1, TreeNode node2){
        if(node2 == null){
            //遍历结束
            return true;
        }
        if(node1 == null){
            //node1遍历结束，node2还没有结束
            return false;
        }
        if(node1.val != node2.val){
            return false;
        }
        return IsSample(node1.left,node2.left)&&IsSample(node1.right,node2.right);
    }
}