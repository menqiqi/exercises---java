/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if(num == null || num.length == 0)
            return null;
        return bst(num ,0, num.length - 1);

    }
    public TreeNode bst(int[] num, int left, int right){
        if(left > right)
            return null;
        if(left == right)
            return new TreeNode(num[left]);

        int mid = left + (right - left + 1) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = bst(num, left ,mid-1);
        root.right = bst(num, mid+1, right);

        return root;
    }
}
