/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */

import java.util.*;

 class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }

/**
 *  类似于中序遍历
 */

public class Practice393{
    public TreeNode Convert(TreeNode pRootOfTree){
        if (pRootOfTree == null){
            return null;
        }
        TreeNode head = null;
        TreeNode root = pRootOfTree;
        TreeNode pre = null;  //记录遍历的上一个节点
        boolean isFirst = true;
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (isFirst){
                head = root;
                pre = head;
                isFirst = false;
            }else {
                pre.right = root;  //右孩子相当于后继结点
                root.left = pre;  //左孩子相当于前驱节点
                pre = root;
            }
            root = root.right;
        }
        return head;
    }
}