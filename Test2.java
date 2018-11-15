package www.like.java;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] result = new int[2];
        for(int i = 0; i < len; i++){
            for(int j = i+1; j < len; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}

public class Test2 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        Solution solution = new Solution();
        int[] res = solution.twoSum(nums,target);
        for(int x:res){
            System.out.print(x+"、");
        }
    }
}
