/**
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 * 举个例子，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
 *
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 *
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 *
 *
 * 提示：
 *
 *     给定的两颗树可能会有 1 到 100 个结点。
 */

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null)
            return false;
        List<Integer> list1 = leafTree(root1);
        List<Integer> list2 = leafTree(root2);
        if(list1.size() != list2.size()){
            return false;
        }else{
            for(int i = 0; i < list1.size(); i++){
                if(list1.get(i) != list2.get(i))
                    return false;
            }
        }
        return true;
    }

    private List<Integer> leafTree(TreeNode root){
        //将数的叶子节点保存在list中
        List<Integer> res = new ArrayList<>();
        dfs(root,res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        if(root.left==null && root.right==null){
            res.add(root.val);
        }
        dfs(root.left,res);
        dfs(root.right,res);
    }
}


