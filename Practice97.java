/**
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
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

/**
 * 递归实现
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }
}


/**
 * 非递归实现
 */

//在后序遍历的基础上加以修改
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        if(root.left==null && root.right==null){
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null; //记录上一个被遍历的节点
        while(cur!=null || !stack.isEmpty()){
            while(cur != null){
                //遍历左子树
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            if(top.right==null || top.right==last){
                stack.pop();
                TreeNode tmp = top.left;
                top.left = top.right;
                top.right = tmp;
                //记录刚遍历过的这个节点
                last = top;
            }else{
                //如果右子树没有被遍历过
                cur = top.right;
            }
        }
        return root;
    }
}
