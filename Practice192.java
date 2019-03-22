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
//递归算法
/**
 public class Solution {
 public void Mirror(TreeNode root) {
 if(root == null){
 return;
 }
 Mirror(root.left);
 Mirror(root.right);
 TreeNode tmp = root.left;
 root.left = root.right;
 root.right = tmp;
 }
 }*/

import java.util.Stack;
//非递归算法
public class Solution{
    public void Mirror(TreeNode root){
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;  //记录上一个被遍历过的节点
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            //左子树已经遍历过了，查看右子树
            if(top.right == null || top.right == last){
                //右子树已经被遍历过了
                stack.pop();
                TreeNode tmp = top.left;
                top.left = top.right;
                top.right = tmp;

                last = top;
            }
            cur = top.right;
        }
    }
}