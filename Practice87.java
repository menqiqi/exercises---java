import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 :
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 */

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(nums1[i] == nums2[j]){
                    set.add(nums1[i]);
                }
            }
        }
        int len = set.size();
        int[] res = new int[len];
        int k = 0;
        for(int tmp : set){
            res[k++] = tmp;
        }
        return res;
    }
}

public class Practice87 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data1 = {1,2,2,1};
        int[] data2 = {2,2};
        int[] res = solution.intersection(data1,data2);
        for(int tmp:res){
            System.out.print(tmp + "、");
        }
    }
}
