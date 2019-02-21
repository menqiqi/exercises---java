/**
 *
 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
 输入描述:

 无序整数数组A[n]

 输出描述:

 满足条件的最大乘积

 示例1
 输入

 3 4 1 2

 输出

 24


 */
import java.util.Scanner;

public class Practice131 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] tmp = str.split(" ");
        int len = tmp.length;
        long[] nums = new long[len];
        for (int i = 0; i < len; i++){
            nums[i] = Long.parseLong(tmp[i]);
        }
        maxMul(nums);
    }

    private static void maxMul(long[] nums){
        //定义最大的三个数和最小的两个数，最大值，只能从这三个数中得出
        long max1 = 0, max2 = 0, max3 = 0,
                min1 = 0, min2 = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                if (nums[i] > max1){
                    max3 = max2;
                    max2 = max1;
                    max1 = nums[i];
                }
                else if (nums[i] > max2){
                    max3 = max2;
                    max2 = nums[i];
                }
                else if (nums[i] > max3){
                    max3 = nums[i];
                }
                else if (nums[i] < min1){
                    min2 = min1;
                    min1 = nums[i];
                }else if (nums[i] < min2){
                    min2 = nums[i];
                }
            }else continue;
        }
        long max = Math.max(max1*max2*max3,max1*min1*min2);
        System.out.println(max);
    }
}

