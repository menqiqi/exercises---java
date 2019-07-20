import java.util.Scanner;

/**
 * 有一组数，对于其中任意两个数组，若前面一个大于后面一个数字，则这两个数字组成一个逆序对。请设计一个高效的算法，计算给定数组总的逆序对个数。
 */

//思路一：暴力破解法
/*
import java.util.Scanner;

public class Practice323 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] data = in.next().split(",");
        int[] A = new int[n];
        for (int i = 0; i < n; i++){
            A[i] = Integer.parseInt(data[i]);
        }

        int count = 0;
        for (int i = 0; i < n-1; i++){
            for (int j = i+1; j < n; j++){
                if (A[i] > A[j]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
*/


//分治算法
public class Practice323{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] data = in.next().split(",");
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(data[i]);
        }
        System.out.println(count(A,n));
    }

        public static int count ( int[] A, int n){
            if (A == null || n == 0) {
                return 0;
            }
            return mergeSortRescursion(A, 0, n - 1);
        }

        public static int mergeSortRescursion ( int[] arr, int l, int r){
            if (l == r) {
                return 0;
            }
            int mid = (r + l) / 2;
            //逆序对的总数=左边数组中逆序对的数量+右边数组中逆序对的数量+左右结合成新的顺序数组时中出现的逆序对的数量
            return mergeSortRescursion(arr, l, mid) + mergeSortRescursion(arr, mid + 1, r) + merge(arr, l, mid, r);
        }

        public static int merge ( int[] arr, int left, int mid, int right){
            int[] tmp = new int[right - left + 1];
            int index = 0;
            int i = left;
            int j = mid + 1;
            int inverseNum = 0;
            while (i <= mid && j <= right) {
                if (arr[i] <= arr[j]) {
                    tmp[index++] = arr[i++];
                } else {
                    //当前一个数组元素大于后一个数组元素时，累加逆序对
                    //s[i] > s[j] 推导出 s[i] ... s[mid] > s[j]
                    inverseNum += (mid - i + 1);
                    tmp[index++] = arr[j++];
                }
            }
            while (i <= mid) {
                tmp[index++] = arr[i++];
            }
            while (j <= right) {
                tmp[index++] = arr[j++];
            }
            for (int k = 0; k < tmp.length; k++) {
                arr[left++] = tmp[k];
            }
            return inverseNum;
        }
    }