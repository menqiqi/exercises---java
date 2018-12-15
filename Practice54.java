/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */


//一个一个的比，但效率很低
/*class Solution {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        int j = 0;
        int i = 0;
        for(i = 0; i < len; i++){
            int tmp = nums[i];
            for(j = 0; j < len; j++){
                if(nums[j] == tmp && j != i)
                    break;
            }
            if(j == len)
                return nums[i];
        }
        return 0;
    }
}*/

class Solution {
    public int singleNumber(int[] nums) {
        // 对每一位单独统计出现1的次数, 如果出现的次数不能整除3说明唯一存在的数在这一位上为1
        int ret = 0;
        for(int i = 0; i < 32; ++i) {
            int bitnums = 0;
            int bit = 1 << i;
            for(int num : nums) {
                if((num&bit) != 0)
                    bitnums++;
            }
            if(bitnums % 3 != 0)
                ret |= bit;
        }
        return ret;
    }
}
public class Practice54 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,5,7,8,5,1,8,5,8};
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(nums));
    }
}
