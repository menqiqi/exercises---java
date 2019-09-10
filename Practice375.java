import java.util.Stack;
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

//后序遍历
public class Solution {
    public void Mirror(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode top = null;
        TreeNode cur = root;
        TreeNode last = null;  //记录上一个被遍历的节点
        while(cur!=null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            top = stack.peek();
            if(top.right == null || top.right == last){
                //说明右子树被遍历过了或者右子树为空
                top = stack.pop();
                TreeNode tmp = top.left;
                top.left = top.right;
                top.right = tmp;

                last = top;
            }else{
                cur = top.right;
            }
        }
    }
}