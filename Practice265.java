import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 珐达采下个月要去鸥洲各国考察一趟，采购流通神秘石并从中搞点油水。
 *
 * 珐达采会按顺序依次经过序号分别为1, 2, 3, …, n的鸥洲国家，在第i个国家神秘石的流通价格为Ai鸥。
 * 因为行程紧张，在每个国家的停留时间有限，所以他只能花费Ai鸥买入一块神秘石，
 * 或者卖出一块手中的神秘石获得Ai鸥，或者什么都不做，而且因为神秘石的保存需要极其先进的高级材料容器，
 * 其材料稀有且制作困难，珐达采只有一份容器，故无论何时珐达采手里最多只能拥有一块神秘石。
 *
 * 珐达采想知道最终能从中获利最大多少鸥。因为交易需要手续费，
 * 所以珐达采还想知道在获利最大收益的同时，最少需要交易多少次。
 * 因为珐达采是大财阀，所以你可以认为他一开始金钱无限。
 */

public class Practice265 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());  //国家的个数
        String[] str = bf.readLine().split(" ");
        int[] A = new int[n];
        for (int i = 0; i < n; i++){
            A[i] = Integer.parseInt(str[i]);
        }

        int max = -A[0];
        int flag = 1;
        int cur = 0;
        if (A[0] < A[1]){
            flag = -flag;
            cur = A[0]*flag;
        }
        int count = 0;
        for (int j = 1; j < n; j++){
            if ((cur+A[j]*(-flag)) > max){
                flag = -flag;
                cur = cur + A[j] * flag;
                max = cur;
                count++;
            }
        }
        System.out.println(max+" "+count);
    }
}
