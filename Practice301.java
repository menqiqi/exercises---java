/**
 * 找出n个数里最小的k个
 */

import java.io.*;
import java.util.*;
public class Practice301 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().trim().split(" ");
        int len = strs.length;
        int[] nums = new int[len-1];
        for(int i=0;i<len-1;i++)
            nums[i] = Integer.parseInt(strs[i]);
        int k = Integer.parseInt(strs[len-1]);
        Arrays.sort(nums);
        for(int i=0;i<k && i < len-1;i++){
            if(i == len-2 || i  == k-1)
                System.out.print(nums[i]);
            else
                System.out.print(nums[i] +" ");
        }


    }
}
