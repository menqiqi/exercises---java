/**
 * 一个数组由若干个整数组成，现要求：将偶数放到前面，奇数放到后面，并输出其中的k个数。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Practice366 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] src = in.nextLine().split(";");
        int n = Integer.parseInt(src[1]);
        String[] data = src[0].split(",");
        List<Integer> list1 = new ArrayList<>();  //存放偶数
        List<Integer> list2 = new ArrayList<>();  //存放奇数
        for (int i = 0; i < data.length; i++){
            int num = Integer.parseInt(data[i]);
            if (num % 2 == 0){
                list1.add(num);
            }else {
                list2.add(num);
            }
        }
        int[] num1 = new int[list1.size()];  //存放偶数
        int[] num2 = new int[list2.size()];  //存放奇数
        for (int j = 0; j < list1.size(); j++){
            num1[j] = list1.get(j);
        }
        Arrays.sort(num1);

        for (int k = 0; k < list2.size(); k++){
            num2[k] = list2.get(k);
        }
        Arrays.sort(num2);
        int[] res = new int[n];
        if (num1.length >= n){
            //结果数组中全部存放偶数
            for (int i = 0; i < n; i++){
                res[i] = num1[num1.length-1-i];
            }
        }else{
            for (int i = 0; i < num1.length; i++){
                res[i] = num1[num1.length-1-i];
            }
            int k = num2.length-1;
            for (int j = num1.length; j < n; j++){
                res[j] = num2[k];
                k--;
            }
        }

        for (int k = 0; k < n-1; k++){
            System.out.print(res[k]+",");
        }
        System.out.print(res[n-1]);
    }
}
