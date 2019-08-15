//最接近的三数之和

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 */

public class Practice342 {
    public static void main(String[] args) {
        int res = isMin(new int[]{-3,-2,-5,3,-4},-1);
        System.out.println(res);
    }

    public static int isMin(int[] nums,int target){
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;
        int min = nums[0]+nums[1]+nums[n-1];
        for(int i = 0; i < n; i++){
            int start = i+1,end = n-1;
            while (start < end){
                sum = nums[i]+nums[start]+nums[end];
                if (Math.abs(sum-target) < Math.abs(min-target))
                    min  = sum;
                if (sum > target){
                    end--;
                }else if (sum < target){
                    start++;
                }else {
                    return sum;
                }
            }
        }
        return min;
    }
}
