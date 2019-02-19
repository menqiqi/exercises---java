class Solution {
public int[] twoSum(int[] numbers, int target) {
        int left=0,right=numbers.length-1;
        int sum;
        while(left<right){
        sum=numbers[left]+numbers[right];
        if(sum<target)
        left++;
        else if(sum>target)
        right--;
        else
        {
        int[] res = {left+1,right+1};
        return res;
        }
        }
        return null;
        }
        }

public class Practice128 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num = {2,7,11,15};
        int[] res = solution.twoSum(num,9);
        for (int tmp : res)
            System.out.print(tmp + "、");
    }
}
