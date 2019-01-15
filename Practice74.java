import java.util.Arrays;

/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 */

class Solution {
    public int maximumProduct(int[] nums) {
        if(nums==null || nums.length==0){
            return -1;
        }
        Arrays.sort(nums);
        int a = nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        int b = nums[0]*nums[1]*nums[nums.length-1];
        return a>=b?a:b;

    }
}

public class Practice74 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num = new int[]{-2,-5,8,10,0,34,-10};
        System.out.println(solution.maximumProduct(num));
    }
}
