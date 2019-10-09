/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */

import java.util.ArrayList;

public class Practice395 {
    public static void main(String[] args) {
        int[] input = new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = GetLeastNumbers_Solution(input,4);
        for (int t : list){
            System.out.print(t+" ");
        }
    }

    /**
     * 堆排序，建小堆
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k){
        ArrayList<Integer> list = new ArrayList<>();
        int len = input.length;
        if (k > len){
            return list;
        }
        int root = (len-2)/2;  //最后一个非叶子节点
        for (; root >= 0; root--){
            buildHeap(input,len,root);
        }
        int end = len-1;
        //只需要找出最后的k个数就可以了
        while (end >= len-k){
            list.add(input[0]);

            int t = input[0];
            input[0] = input[end];
            input[end] = input[0];

            buildHeap(input,end,0);
            end--;
        }
        return list;
    }

    public static void buildHeap(int[] arr, int len, int parent){
        int child = parent*2+1;  //左孩子
        while (child < len){
            if ((child+1)<len && arr[child+1]<arr[child]){
                child+=1;
            }
            if (arr[child] < arr[parent]){
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
            }
            parent = child;
            child = parent*2+1;
        }
    }
}
