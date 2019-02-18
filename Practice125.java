/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 *     一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 *
 * 返回 false 。
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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        //先判断左子树是否平衡
        if(isBalanced(root.left) == false)
            return false;
        //再判断右子树是否平衡
        if(isBalanced(root.right) == false)
            return false;
        //计算左右子树的高度差
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int dif = leftHeight - rightHeight;
        if((dif>=0 && dif<=1) || (dif<=0 && dif>=-1))
            return true;
        else
            return false;
    }

    //计算树的高度
    public int height(TreeNode root){
        if(root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return leftHeight>rightHeight ? leftHeight+1 : rightHeight+1;
    }
}


