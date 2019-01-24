/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 *根据搜索二叉树的特性
 *
 * 解题思路：
 * ①两个节点在左右子树，那么根节点就是最近公共祖先
 * ②两个节点在一侧，那么就用子问题求解
 */
class Solution {
    public TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root,p,q);
        return res;
    }

    private void lca(TreeNode root, TreeNode p, TreeNode q){
        if((root.val-p.val)*(root.val-q.val) <= 0){
            //说明p和q都在root的子树中或者本身就是root
            res = root;
        }else if((root.val>p.val) && (root.val>q.val)){
            //说明p和q都在root的左子树中
            lca(root.left,p,q);
        }else{
            lca(root.right,p,q);
        }
    }
}
