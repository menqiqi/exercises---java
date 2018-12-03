/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 */

class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }
            else if(i == 0 && nums[i] > target){
                //插入第一个位置
                return 0;
            }
            else if(i == nums.length-1 && nums[i] < target){
                //插入最后一个位置
                return nums.length;
            }else if(nums[i]<target && nums[i+1]>target){
                return i+1;
            }
        }
        return -1;
    }
}

public class Practice26 {
    public static void main(String[] args) {
        int[] A = new int[]{1,3,5,6};
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(A,2));
    }
}
