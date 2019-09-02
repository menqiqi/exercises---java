/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for(int t : nums){
            if(sum > 0){
                sum += t;
            }else{
                sum = t;
            }
            max = Math.max(sum,max);
        }
        return max;
    }
}