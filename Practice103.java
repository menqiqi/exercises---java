/**
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 *
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
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
    public boolean isUnivalTree(TreeNode root) {
        return is(root,root.val);
    }

    public boolean is(TreeNode node,int value){
        if(node==null){
            return true;
        }else{
            if(node.val != value){
                return false;
            }else{
                return is(node.left,node.val)
                        &&is(node.right,node.val);
            }
        }
    }
}


