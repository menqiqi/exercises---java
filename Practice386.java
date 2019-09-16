import java.util.Scanner;

/**
 * 判断一个数组能否在最多改变一个元素的条件下变成非递减数组
 */

public class Practice386 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(",");
        int len = str.length;
        int[] num = new int[len];
        for (int i = 0; i < len; i++){
            num[i] = Integer.parseInt(str[i]);
        }
        int flag = 0;
        for (int i = 0; i < len-1; i++){
            if (flag == 0 && num[i] > num[i+1]){
                flag ++;
                continue;
            }
            if (flag > 0 && num[i] > num[i+1]){
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
        in.close();
    }
}
