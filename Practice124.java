/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length || inorder.length == 0)
            return null;
        int rootValue = postorder[postorder.length-1];
        int index = -1;  //初始化根节点下标在中序遍历中的位置
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootValue){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootValue);
        int[] inleft = Arrays.copyOfRange(inorder, 0, index);
        int[] postleft = Arrays.copyOfRange(postorder, 0, index);
        int[] inright = Arrays.copyOfRange(inorder, index+1, inorder.length);
        int[] postright = Arrays.copyOfRange(postorder, index, postorder.length-1);
        root.left = buildTree(inleft, postleft);
        root.right = buildTree(inright, postright);
        return root;
    }
}


