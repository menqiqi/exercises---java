import java.util.Scanner;

/**
 * 输入n个整数，输出出现次数大于等于数组长度一半的数。
 *
 * 例：
 * 输入：
 * 3 9 3 2 5 6 7 3 2 3 3 3
 *
 * 输出：
 * 3
 */

public class Practice157 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int[] num = new int[str.length];
        for (int i = 0; i < str.length; i++){
            num[i] = Integer.parseInt(str[i]);
        }
        sort(num,num.length);
        System.out.println(num[num.length/2-1]);
    }

    private static void sort(int[] num,int size){
        //使用堆排序
        //建堆
        int root = (size - 2)/2;  //最后一个非叶子节点
        for (; root >= 0; root--){
            adjustHeap(num,size,root);
        }
        //排序
        int end = size - 1;
        while (end > 0){
            int tmp = num[0];
            num[0] = num[end];
            num[end] = tmp;
            adjustHeap(num, end, 0);
            end--;
        }
    }

    private static void adjustHeap(int[] num, int size, int parent){
        int children = (parent * 2) + 1;
        while (children < size){
            if (children+1 < size && num[children + 1] > num[children])
                children = children + 1;
            if (num[children] > num[parent]){
                //交换
                int tmp = num[children];
                num[children] = num[parent];
                num[parent] = tmp;
            }
            parent = children;
            children = parent * 2 + 1;
        }
    }
}
