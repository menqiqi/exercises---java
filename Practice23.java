import java.util.Arrays;
import java.util.Collections;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 *     初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 *     你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */

class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for(int i =  m; i < nums1.length; i++){
            nums1[i] = nums2[j];
            j++;
        }
        Arrays.sort(nums1);
    }
}

public class Practice23{
    public static void main(String[] args) {
        int[] A = new int[]{1,3,4,0,0,0};
        int[] B = new int[]{0,1,2};
        Solution solution = new Solution();
        solution.merge(A,3,B,3);
        for(int x : A){
            System.out.print(x+"、");
        }
    }
}