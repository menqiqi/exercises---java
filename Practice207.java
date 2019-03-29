/**
 * 检查二叉树是否平衡。
 * 平衡的定义如下：
 *   左右子树的高度不超过1.
 */


import java.util.*;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/

//解题思路：分别计算左右子树的高度，然后判断左右子树的高度是否超过1
public class Balance {
    public boolean isBalance(TreeNode root) {
        // write code here
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        int piff = left - right;
        if(piff <= 1 && piff >= -1)
            return true;
        return false;
    }

    private static int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getHeight(root.left)+1;
        int right = getHeight(root.right)+1;
        return Math.max(left,right);
    }
}