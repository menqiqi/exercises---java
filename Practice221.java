//最大连续子数组和

import java.util.Scanner;

public class Practice221 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int[] arr = new int[str.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(MaxSubsequenceSum1(arr,arr.length));
    }

    //解法一：暴力破解法，时间复杂度O(N^3)
    public static int MaxSubsequenceSum1(int[] arr, int n){
        int thisSum = 0, maxSum = 0;
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                thisSum = 0;
                for (int k = i; k < n; k++){
                    thisSum += arr[k];
                }
                if (thisSum > maxSum)
                    maxSum = thisSum;
            }
        }
        return maxSum;
    }

    //解法二：对于解法一的优化，时间复杂度O(N^2)
    public static int MaxSubsequenceSum2(int[] arr, int n){
        int thisSum = 0, maxSum = 0;
        for (int i = 0; i < n; i++){
            thisSum = 0;
            for (int j = i; j < n; j++){
                thisSum += arr[j];
                if (thisSum > maxSum)
                    maxSum = thisSum;
            }
        }
        return maxSum;
    }

    //解法三：分治法，时间复杂度O(N*logN)
    //最大子序列可能在三处出现，整个出现在数组的左边，整个出现在数组的右边，或者出现在数组的中间
    //递归左右数组，分别分成两个数组，直到子数组中只含有1个元素，退出每层递归前，返回上面三种情况的最大值
    public static int MaxSubsequenceSum3(int[] arr, int left, int right){
        int maxLeftSum = 0, maxRightSum = 0;  //左右两边子数组的最大值
        int maxLeftBroundSum = 0, maxRightBroundSum = 0;  //从中间分别到左右两侧的最大子序列
        int leftBroundSum = 0,rightBroundSum = 0;
        int center = 0;
        if (left == right){
            if (arr[left] > 0)
                return arr[left];
            else
                return 0;
        }
        center = (left+right)/2;

        maxLeftSum = MaxSubsequenceSum3(arr,left,center);
        maxRightSum = MaxSubsequenceSum3(arr,center+1,right);

        maxLeftBroundSum = 0;
        rightBroundSum = 0;
        for (int i = center+1; i < right; i++){
            rightBroundSum += arr[i];
            if (rightBroundSum > maxRightBroundSum)
                maxRightBroundSum = rightBroundSum;
        }

        //比较各种情况，求出最大值
        int max1 = maxLeftSum > maxRightSum ? maxLeftSum : maxRightSum;
        int max2 = maxLeftBroundSum + maxRightBroundSum;
        return max1>max2 ? max1 : max2;
    }

    //解法四：动态规划
    //这个题动态规划的递推公式是：d[i] = Max(d[i-1]+arr[i],arr[i])
    public static int MaxSubsequenceSum4(int[] arr, int n){
        int thisSum = 0, maxSum = 0;
        for (int i = 0; i < n; i++){
            thisSum += arr[i];
            if (thisSum > maxSum)
                maxSum = thisSum;
            else if (thisSum < 0)
                thisSum = 0;
        }
        return maxSum;
    }
}
