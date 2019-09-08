/**
 * 被看到最多次的机器人
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice373 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());  //机器人的个数
        if (n == 0 || n == 1){
            System.out.println(0);
            return;
        }

        String[] str = bf.readLine().split(" ");
        int[] heigh = new int[n];
        for (int i = 0; i < str.length; i++){
            heigh[i] = Integer.parseInt(str[i]);
        }
        int[] num = new int[n-1];  //记录每个机器人被看到的次数
        for (int i = 0; i < n-1; i++){
            if (heigh[i+1] > heigh[i]){
                //说明没有机器人会看到
                num[i] = 0;
            }else{
                num[i]++;
                for (int j = i+2; j < n; j++){
                    if (isSmall(heigh,i+1,j)){
                        if (heigh[j] < heigh[i])
                            num[i]++;
                    }
                }
            }
        }

        //找到num中最大值的下标
        int max = 0;
        for (int k = 1; k < n-1; k++){
            if (num[k] > num[max])
                max = k;
        }
        System.out.println(heigh[max]);

    }

    /**
     * 判断index到i之间的数字是否全部小于index
     * @param num
     * @param end
     * @return
     */
    public static boolean isSmall(int[] num, int start, int end){
        int key = num[end];
        for (int i = start; i < end; i++){
            if (num[i] > key)
                return false;
        }
        return true;
    }
}
