/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        //堆排(降序建小堆)
        int size = nums.length;
        //1.建堆
        int root = (size-2)/2;
        for(; root >= 0; root--){
            heapAdjust(nums, size, root);
        }
        //2.堆排序
        int end = size-1;
        while(end >= 0){
            int tmp = nums[0];
            nums[0] = nums[end];
            nums[end] = tmp;
            heapAdjust(nums, end, 0);
            end--;
        }

        return nums[k-1];
    }

    public void heapAdjust(int[] arr, int size, int parent){
        int child = parent*2+1;
        while(child < size){
            if(child+1 < size && arr[child+1] < arr[child])
                child = child + 1;
            if(arr[child] < arr[parent]){
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
            }
            parent = child;
            child = parent*2+1;
        }
    }
}

public class Practice120 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(solution.findKthLargest(nums,2));
    }
}
