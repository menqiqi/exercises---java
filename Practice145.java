import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 小易老师是非常严厉的,它会要求所有学生在进入教室前都排成一列,并且他要求学生按照身高不递减的顺序排列。有一次,n个学生在列队的时候,小易老师正好去卫生间了。学生们终于有机会反击了,于是学生们决定来一次疯狂的队列,他们定义一个队列的疯狂值为每对相邻排列学生身高差的绝对值总和。由于按照身高顺序排列的队列的疯狂值是最小的,他们当然决定按照疯狂值最大的顺序来进行列队。现在给出n个学生的身高,请计算出这些学生列队的最大可能的疯狂值。小易老师回来一定会气得半死。
 * 输入描述:
 *
 * 输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),表示学生的人数
 * 第二行为n个整数h[i](1 ≤ h[i] ≤ 1000),表示每个学生的身高
 *
 * 输出描述:
 *
 * 输出一个整数,表示n个学生列队可以获得的最大的疯狂值。
 *
 * 如样例所示:
 * 当队列排列顺序是: 25-10-40-5-25, 身高差绝对值的总和为15+30+35+20=100。
 * 这是最大的疯狂值了。
 *
 * 示例1
 * 输入
 *
 * 5
 * 5 10 25 40 25
 *
 *
 *输出
 *
 * 100
 *
 */

public class Practice145 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());  //学生的人数
        String[] num = bf.readLine().split(" ");
        int[] h = new int[n];  //学生的身高
        for (int i = 0; i < n; i++){
            h[i] = Integer.parseInt(num[i]);
        }
        System.out.println(maxValue(n,h));
    }

    /**
     * 找到最大值和最小值，求出他们的差，在剩下的数中找最大值和最小值，将大的和之前的小的减，小的和之前的大的减
     * @param n  数组的个数
     * @param h  数组
     * @return
     */
    private static int maxValue(int n,int[] h){
        Arrays.sort(h);
        int min = h[0];
        int max = h[n-1];
        int minIndex = 1;
        int maxIndex = n-2;
        int count = max - min;
        while (minIndex < maxIndex){
            count = count + (max - h[minIndex]);
            count = count + (h[maxIndex] - min);
            max = h[maxIndex];
            min = h[minIndex];
            minIndex++;
            maxIndex--;
        }
        //当maxIndex==mainIndex时，将它放在合适的位置
        count = count + Math.max((max - h[minIndex]), (h[maxIndex] - min));
        return count;
    }
}
