/**
 *给定一个二叉树，返回它的 前序 遍历。
 */

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || !(stack.isEmpty())){
            while(cur != null){
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            //栈顶的左子树和根节点已经被遍历过了
            //pop栈顶元素，并且把栈顶元素的右子树赋给cur
            cur = stack.pop().right;
        }
        return list;
    }
}


