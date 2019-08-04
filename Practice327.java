/**
 * 小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。
 *
 * 并且小Q对于能否被3整除这个性质很感兴趣。
 *
 * 小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。
 */

import java.util.*;

public class Practice327 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] data = in.nextLine().split(" ");
        int left = Integer.parseInt(data[0]);
        int right = Integer.parseInt(data[1]);
        int count = 0;
        for(int i = left; i <= right; i++){
            if(i%3 == 0 || i%3 == 2)
                count++;
        }
        System.out.println(count);
    }
}