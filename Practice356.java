import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 */

public class Practice356 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1};
        nextPermutation(nums);
        for (int t: nums)
            System.out.print(t+",");
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 1 || n == 0)
            return;
        int i = n-1;
        for (i = n-2; i >= 0; i--){
            if (nums[i] < nums[i+1]){
                int j = i;
                for (j = n-1; j > i; j--){
                    if (nums[j] > nums[i])
                        break;
                }
                //交换nums[i]和nums[j]
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                //对i后面的数字重新排序
                Arrays.sort(nums,i+1,n);
                return;
            }
        }
        //数组为降序排列
        Arrays.sort(nums);
    }
}
