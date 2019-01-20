/**
 * 给定一个二叉树，返回它的 后序 遍历。
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null; //记录上一个被遍历的节点
        TreeNode top = null; //记录栈顶元素
        while(cur!=null || !(stack.isEmpty())){
            //遍历左子树
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //top的左子树已经遍历过了
            top = stack.peek();
            if(top.right==null || top.right==last){
                //top的右子树被遍历过了
                stack.pop();
                list.add(top.val);
                //记录这个被遍历的节点
                last = top;
            }else{
                //top的右子树没有被遍历过
                cur = top.right;
            }
        }
        return list;
    }
}


