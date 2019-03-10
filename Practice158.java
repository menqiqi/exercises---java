import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 牛牛举办了一场数字游戏，有n个玩家参加这个游戏，游戏开始每个玩家选定一个数，然后将这个数写在纸上，然后
 * 接下来对于每一个数字将其数位按照非递减顺序排列，得到新的数，新数的前缀零将被忽略。得到最大数字的玩家
 * 赢得这个游戏。
 */

public class Practice158 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] str = bf.readLine().split(" ");
        int[] num = new int[n];
        for (int i = 0; i < n; i++){
            int[] tmp = new int[str[i].length()];
            for (int j = 0; j < str[i].length(); j++){
                tmp[j] = Integer.parseInt(String.valueOf(str[i].charAt(j)));
            }
            Arrays.sort(tmp);
            String number = "";
            if (tmp[0] != 0){
                number = number+tmp[0];
            }
            for (int k = 1; k < tmp.length; k++){
                number = number + tmp[k];
            }
            num[i] = Integer.parseInt(number);
        }
        int res = 0;
        for (int i = 0; i < n; i++){
            if (num[i] > res)
                res = num[i];
        }
        System.out.println(res);
    }
}
