import java.util.Scanner;

/**
 * 输入一个字符串，然后对每个字符进行奇校验，最后输出校验后的二进制数。
 * （如‘3’，输出：10110011）
 */

public class Practice227 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            int i = 0;
            while (i < str.length()){
                char c = str.charAt(i);
                String bin = Integer.toBinaryString(c);
                int len = bin.length();
                //计算二进制中1的个数
                int count = 0;
                for (int j = 0; j < len; j++){
                    if (bin.charAt(j) == '1')
                        count++;
                }
                //如果count是奇数，不用再加1，否在，加1
                int diff = 8 - len;  //前面还要加的位数
                if (diff != 0){
                    if (count % 2 == 0){
                        String tmp = "1";
                        int t = diff-2;
                        while (t >= 0){
                            tmp = tmp + "0";
                            t--;
                        }
                        bin = tmp + bin;
                    }else {
                        String tmp = "0";
                        int t = diff-2;
                        while (t >= 0){
                            tmp = tmp + "0";
                            t--;
                        }
                        bin = tmp + bin;
                    }
                }
                System.out.println(bin);
                i++;
            }
        }
    }
}
