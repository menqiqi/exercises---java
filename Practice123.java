/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length || preorder.length <= 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int rootValue = preorder[0];  //根节点的元素
        //找到根节点在中序遍历的下标，也就是根节点的左子树个数
        int index = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootValue){
                index = i;
                break;
            }
        }
        int[] inleft = Arrays.copyOfRange(inorder,0,index);
        int[] preleft = Arrays.copyOfRange(preorder,1,1+index);
        int[] inright = Arrays.copyOfRange(inorder,index+1,inorder.length);
        int[] preright = Arrays.copyOfRange(preorder,index+1,inorder.length);
        root.left = buildTree(preleft,inleft);
        root.right = buildTree(preright,inright);
        return root;
    }
}


