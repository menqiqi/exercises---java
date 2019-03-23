
/**
 * 给定一个正整数N代表火车数量，0<N<10,接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号。
 * 要求以字典序排序输出火车出站的序列号。
 */

import java.util.*;

public class Practice193 {

    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       while (in.hasNext()){
           int n = in.nextInt();
           int[] A = new int[n];
           for (int i = 0; i < n; i++){
               A[i] = in.nextInt();
           }
           int start = 0;
           ArrayList<int[]> result = new ArrayList<>();

           Permutation(A,start,n,result);
           Set<String> set = new TreeSet<>();

           for (int[] out : result){
               if (isLegal(A,out,n)){
                   StringBuilder sb = new StringBuilder();
                   for (int i = 0; i < n-1; i++){
                       sb.append(out[i]+" ");
                   }
                   sb.append(out[n-1]);
                   set.add(sb.toString());
               }
           }
           for (String list : set){
               System.out.println(list);
           }
       }
       in.close();
    }

    /**
     * 全排列
     * @param A  原始数组
     * @param start  开始全排列的位置
     * @param n  全排列的个数
     * @param result  结果列表
     */
    private static void Permutation(int[] A, int start, int n, List<int[]> result){
        if (start == n){
            return;
        }
        if (start == n-1){
            int[] B = A.clone();
            result.add(B);
            return;
        }
        for (int i = start; i < n; i++){
            Swap(A,start,i);
            Permutation(A,start+1,n,result);
            Swap(A,start,i);
        }
    }

    private static void Swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 判断元素的出栈顺序是否合理
     * @param in  原始数组
     * @param out  需要进行判断的数组
     * @param n 数组长度
     * @return
     */
    private static boolean isLegal(int[] in, int[] out, int n){
        LinkedList<Integer> stack = new LinkedList<>();
        int i = 0;
        int j = 0;
        //只要in还有元素，就需要判断
        while (i < n){
            //相等的时候不需要入栈，直接后移
            if (in[i] == out[j]){
                i++;
                j++;
            }else {
                if (stack.isEmpty()){
                    //空栈，就入栈
                    stack.push(in[i]);
                    i++;
                }else {
                    int top = stack.peek();
                    //栈顶元素相等，进行出栈操作
                    if (top == out[j]){
                        j++;
                        stack.pop();
                    }else if (i< n){
                        stack.push(in[i]);
                        i++;
                    }
                }
            }
        }

        //in 结束后，栈中元素出栈顺序应和out剩余元素相同
        while (!stack.isEmpty() && j < n){
            int top = stack.pop();
            if (top == out[j]){
                j++;
            }else {
                return false;
            }
        }
        return true;
    }

}