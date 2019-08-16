/**
 * 一个非空整数数组，选择其中的两个位置，使得两个位置之间的数和最大。
 * 如果最大的和为正数，则输出这个数；如果最大的和为负数或0，则输出0
 */

import java.util.*;
public class Practice346 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(",");
        int len = str.length;
        int[] data = new int[len];
        for(int i = 0; i < len; i++){
            data[i] = Integer.parseInt(str[i]);
        }
        int sum = 0;
        int max = 0;
        //当和小于等于0时，直接抛弃
        for(int j = 0; j < len; j++){
            if(sum <= 0){
                sum = data[j];
            }else{
                sum += data[j];
            }
            if(max < sum)
                max = sum;
        }
        System.out.println(max);
    }
}