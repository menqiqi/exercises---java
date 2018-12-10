/**
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 *
 * 示例 :
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 */

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[len1];
        int k = 0;
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(nums1[i] == nums2[j]){
                    //比较下一个元素
                    if(j == len2-1){
                        res[k++] = -1;
                        j = 0;
                    }else{
                        int m = 0;
                        for(m = j+1; m < len2; m++){
                            if(nums2[m] > nums1[i]){
                                res[k++] = nums2[m];
                                break;
                            }
                        }
                        if(m == len2)
                            res[k++] = -1;
                        j = 0;
                    }
                    break;
                }
            }
        }
        return res;
    }
}

public class Practice44 {
    public static void main(String[] args) {
        int[] data1 = new int[]{4,1,2};
        int[] data2 = new int[]{1,3,4,2};
        int[] res = new int[data1.length];
        Solution solution = new Solution();
        res = solution.nextGreaterElement(data1,data2);
        for(int tmp : res)
            System.out.print(tmp+"、");
    }
}
