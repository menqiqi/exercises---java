package www.bit.java;

/**
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int max = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] == 1){
                sum++;
                if(i == len-2 && nums[len-1] == 0){
                    return sum;
                }
            }else{
                if(max > sum){
                    max = max;
                }else{
                    max = sum;
                }
                sum = 0;
            }
        }
        return max > sum ? max : sum;
    }
}

public class Practice20 {
    public static void main(String[] args) {
        int[] A = new int[]{1,1,0,1,1,1};
        Solution solution = new Solution();
        System.out.println(solution.findMaxConsecutiveOnes(A));
    }
}
