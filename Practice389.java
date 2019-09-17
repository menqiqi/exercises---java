/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */

import java.util.ArrayList;
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}


public class Practice389 {
    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(12);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(3);
        t1.right = t2;
        t1.left = t3;
        t2.left = t4;
        t2.right = t5;
        t4.left = t6;
        ArrayList<ArrayList<Integer>> res = FindPath(t1, 22);
        for (ArrayList<Integer> path : res)
            System.out.println(path);
    }


    private static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private static ArrayList<Integer> list = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null){
            return res;
        }
        list.add(root.val);
        target -= root.val;
        if(root.left==null && root.right==null && target==0){
            res.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right, target);
        list.remove(list.size()-1);
        return res;

    }

}
