/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

//递归算法
/*class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        preOrderTarversal(list,root);
        return list;
    }

    public void preOrderTarversal(List<Integer> list,Node root){
        if(root == null)
            return;
        list.add(root.val);
        if(root.children!=null && root.children.size()>0){
            preOrderTarversal(list,root.children.get(0));
        }
        for(int i = 1; i < root.children.size(); i++){
            preOrderTarversal(list,root.children.get(i));
        }
    }
}*/


//非递归算法
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            list.add(node.val);
            if(null!=node.children && node.children.size()>0){
                for(int i=node.children.size()-1; i>=0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return list;
    }
}