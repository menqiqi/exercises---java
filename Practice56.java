import java.util.Arrays;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 :
 *
 * 输入: [1,2,3,1]
 * 输出: true
 */

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1])
                return true;
        }
        return false;
    }
}

public class Practice56 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,6,5,5,3,4,1};
        Solution solution = new Solution();
        System.out.println(solution.containsDuplicate(nums));
    }
}
