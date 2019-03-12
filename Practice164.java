/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 *
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean res = false;
        if(s != null && t != null){
            if(s.val == t.val){
                res = isSameTree(s,t);
            }
            if(!res){
                res = isSubtree(s.left,t) || isSubtree(s.right,t);
            }
        }
        return res;
    }

    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        }else{
            if(p.val != q.val)
                return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
