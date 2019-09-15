/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */

//二叉搜索树的左子树都比根节点小，右子树都比根节点大
public class Practice384 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int len = sequence.length;
        if(len == 0){
            return false;
        }
        if(len == 1){
            return true;
        }
        return DFS(sequence,0,len-1);
    }

    //序列分为两部分，一部分是左子树，都比根节点小，剩下的是右子树，都比根节点大，递归
    public static boolean DFS(int[] num, int start, int root){
        if(start > root){
            return true;
        }
        //从前往后找，先找左子树，找到第一个比根节点大的数字
        int i = start;
        while(i < root && num[i] < num[root]){
            i++;
        }
        //找右子树
        for(int j = i; j < root; j++){
            if(num[j] < num[root]){
                return false;
            }
        }
        //i就是第一个比根节点大的数字
        return DFS(num,start,i-1)&&DFS(num,i,root-1);
    }
}