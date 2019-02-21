/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            int a = i;
            int b = nums[i]-1;
            if(nums[a] != nums[b]){
                int tmp = nums[a];
                nums[a] = nums[b];
                nums[b] = tmp;
                //交换之后，新换到i位置上的数字没有比较过
                i--;
            }
        }
        for(int j = 0; j < len; j++){
            if(nums[j] != (j+1))
                list.add(j+1);
        }
        return list;
    }
}
public class Practice132 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        Solution solution = new Solution();
       List<Integer> list = solution.findDisappearedNumbers(nums);
       for (int tmp : list)
           System.out.print(tmp + "、");
    }
}
