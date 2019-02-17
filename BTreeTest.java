import java.util.ArrayList;
import java.util.List;

class BTree{

    /**
     * 创建树节点
     */
    class BTreeNode{
        int data;
        BTreeNode left;
        BTreeNode right;

        public BTreeNode(int data) {
            this.data = data;
        }
    }

    public void createBTree(int[] arr){
        List<BTreeNode> nodeList = new ArrayList<>();
        //将每个元素都封装为树的节点
        for (int i = 0; i < arr.length; i++)
            nodeList.add(new BTreeNode(arr[i]));

        //对前lastParentIndex-1个父节点按照和子节点的关系建立二叉树
        for (int index = 0; index < (arr.length-2)/2; index++){
            nodeList.get(index).left = nodeList.get(index*2+1);
            nodeList.get(index).right = nodeList.get(index*2+2);
        }

        //由于最后一个父节点可能没有右子树，就单独拿出来
        int lastParentIndex = (arr.length-2)/2;
        nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex*2+1);
        if (lastParentIndex*2+2 < arr.length)
            nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex*2+2);
    }

}

public class BTreeTest {
    public static void main(String[] args) {
        int[] arr = {1,2,7,3,6,8,9,4,10,5};
        BTree bTree = new BTree();
        bTree.createBTree(arr);
    }
}
