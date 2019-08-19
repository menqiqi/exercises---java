

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 二分查找
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 */

public class Practice352 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] res = searchRange(nums,target);
        for (int t : res)
            System.out.print(t+" ");
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0,right = nums.length;
        //找最左侧的坐标
        while (left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                right = mid;//向左侧逼近 [0,len)->[0,mid) [mid+1,len),mid已经比较过了
            }else if (nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid;
            }
        }
        if (left >= nums.length)
            res[0] = -1;
        else
            res[0] = nums[left] == target ? left : -1;
        left = 0;
        right = nums.length;
        //找最右侧的坐标
        while (left < right){
            int mid = left + (right-left)/2;
            if (nums[mid] == target){
                left = mid+1;
            }else if (nums[mid] < target){
                left = mid+1;
            }else if (nums[mid] > target){
                right = mid;
            }
        }
        if (left == 0)
            res[1] = -1;
        else
            res[1] = nums[right-1] == target ? right-1 : -1;

        return res;
    }
}
