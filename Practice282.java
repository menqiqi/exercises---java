/**
 *
 已知石头重量数组。将石头分为质量最接近的两组
 */

import java.io.*;
import java.util.Arrays;
public class Practice282 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(",");
        int[] arr = new int[strs.length];
        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(strs[i]);
        Arrays.sort(arr);
        int left = 0, right = 0;
        for(int i = arr.length-1; i >= 0; i--){
            if(left > right) right += arr[i];
            else left += arr[i];
        }
        if(left > right) System.out.println(left+","+right);
        else System.out.println(right+","+left);
    }
}
