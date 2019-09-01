/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
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
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null && in == null){
            return null;
        }
        int size = pre.length;
        TreeNode root = buildTree(pre,in,0,size-1,0,size-1);
        return root;
    }

    public static TreeNode buildTree(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd){
        int rootValue = pre[preStart];
        int rootInIndex = -1;  //根节点在中序遍历中的下标
        for(int i = 0; i < in.length; i++){
            if(in[i] == rootValue){
                rootInIndex = i;
                break;
            }
        }
        //rootInIndex不仅是中序遍历的下标，还是左子树的个数
        int leftLength = rootInIndex - inStart;
        int rightLength = inEnd - rootInIndex;
        TreeNode root = new TreeNode(rootValue);
        if(leftLength > 0){
            root.left = buildTree(pre,in,preStart+1,preStart+leftLength,inStart,rootInIndex-1);
        }
        if(rightLength > 0){
            root.right = buildTree(pre,in,preStart+leftLength+1,preEnd,rootInIndex+1,inEnd);
        }
        return root;
    }
}