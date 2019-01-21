import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 :
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 *
 * 说明：
 *
 *     输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 *     我们可以不考虑输出结果的顺序。
 *
 * 进阶:
 *
 *     如果给定的数组已经排好序呢？你将如何优化你的算法？
 *     如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 *     如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0,j = 0;
        while(i < len1 && j < len2){
            if(nums1[i] > nums2[j]){
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int len = list.size();
        int[] res = new int[len];
        int k = 0;
        for(int tmp : list){
            res[k++] = tmp;
        }
        return res;
    }
}

public class Practice88 {
    public static void main(String[] args) {
        int[] data1 = {4,9,5};
        int[] data2 = {9,4,9,8,4};
        Solution solution = new Solution();
        int[] res = solution.intersect(data1,data2);
        for(int tmp : res){
            System.out.print(tmp+"、");
        }
    }
}
