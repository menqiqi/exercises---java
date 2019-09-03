/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 */

import java.util.ArrayList;
import java.util.List;

public class Practice369 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        int total = 1<<nums.length;
        for(int i = 0; i < total; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < nums.length; j++){
                int a = (i >> j)&1;
                if(a == 1){
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }
}
