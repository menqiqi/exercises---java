//最大连续子数组和

import java.util.Arrays;
import java.util.Scanner;

public class Practice221 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int[] arr = new int[str.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        int[] res = new int[arr.length];
        int index = 0;

        for (int k = 0; k < arr.length; k++){
            int max = arr[k];
            int count = 0;

            for (int i = k; i < arr.length; i++){
                count = count + arr[i];
                if (count > max){
                    max = count;
                }
            }
            res[index++] = max;
        }

        Arrays.sort(res);
        System.out.println(res[res.length-1]);
    }
}
