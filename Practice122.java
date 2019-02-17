/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        int flag = 0; //标记位，判断是从优往左还是从坐往右
        queue.add(cur);
        while(!queue.isEmpty()){
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            int count = queue.size();
            while(count > 0){
                TreeNode top = queue.poll();
                list1.add(top.val);
                if(top.left != null)
                    queue.add(top.left);
                if(top.right != null)
                    queue.add(top.right);
                count--;
            }
            flag ++;
            if(flag%2 == 1){
                res.add(list1);
            }else{
                //从右往左
                for(int i = list1.size()-1; i >= 0; i--){
                    list2.add(list1.get(i));
                }
                res.add(list2);
            }
        }
        return res;
    }
}

public class Practice122 {
}
