/**
 * pre-post
 *
 * 给出前序遍历和后序遍历，求可能组成多少个不同的n叉树。
 *
 * 输入描述：
 * 输入几叉树，前序遍历和后序遍历，以空格隔开
 *
 * 输出描述：
 * 可能组成的树的个数
 *
 *
 *  总结：已知n叉树的先序和后序遍历，求符合条件的n叉树的个数，解题策略为：
 *         1、设符合条件的n叉树的个数为sum，初值为1;
 *         2、根据n叉树的先序遍历求出根结点，根结点的子树数为k（初值为0），n叉树结点个数为m；
 *         3、找出先序遍历中根结点后一个结点和后序遍历中根结点前一个结点，如果这两个结点相同，则n叉树只有一个子树(k=1)，
 *            从树的形态上讲，这个子树可以是根结点的第1个子树或第2个子树……或第n个子树，因此共有种；
 *         4、如果这两个结点不相同，则说明根结点存在多个子树；从后序遍历的第一个结点开始找与先序遍历中根结点后一个结点相同的结点，
 *            并记下位置t1，则后序遍历1~ t1之间的结点和先序遍历2~ t1+1之间的结点构成了根结点的第一个子树(k=1)；
 *            接着从后序遍历的第t1+1个结点开始找与先序遍历中第t1+2结点相同的结点，并记下位置t2，
 *            则后序遍历t1+1~ t2之间的结点和先序遍历t1+2~ t2+1之间的结点构成了根结点的第二个子树（k=2）；若t2+1<m，
 *            则根结点还有其它子树，按上述方法重复查找，直到t2+1=m。则根结点的k个子树全部确定，其形状排列方式共有种；
 *         5、若根结点的k个子树只有一个结点，则结束求解，否则对根结点的k个子树按本解题策略分别进行递归求解，
 *            求解其符合条件的子树的个数sum1、sum2、sum3……、sumk；则。
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Practice229 {
    /*
     * 1044
     */
    private static long num = 1;
    private static long numArr[];

    public static void main(String[] args) throws Exception {
        initArr();
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(
                new InputStreamReader(System.in)));
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int) st.nval;
            st.nextToken();
            String preOrder = st.sval;
            st.nextToken();
            String postOrder = st.sval;
            num = 1;
            CaculateTree(n, preOrder, postOrder);
            System.out.println(num);
        }
    }
    private static void CaculateTree(int n, String preOrder, String postOrder) {
        int len = preOrder.length();
        if (len == 1) {
            return;
        }
        int count = 0;
        preOrder = preOrder.substring(1);
        postOrder = postOrder.substring(0,len-1);
        while (!"".equals(preOrder)) {
            int index = postOrder.indexOf(preOrder.charAt(0))+1;
            String newPre = preOrder.substring(0,index);
            String newPost = postOrder.substring(0,index);
            preOrder = preOrder.substring(index);
            postOrder = postOrder.substring(index);
            count++;
            CaculateTree(n, newPre, newPost);
        }
        num *= CaculateCom(count, n);
    }
    private static void initArr() {
        numArr = new long[21];
        numArr[0] = 1;
        for (int i = 1; i < 21; i++) {
            numArr[i] = numArr[i - 1] * i;
        }
    }
    private static long CaculateCom(int subNum, int n) {
        return numArr[n] / (numArr[n - subNum] * numArr[subNum]);
    }
}

