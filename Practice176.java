/**
 * 请编写一个函数，函数内不使用任何临时变量，直接交换两个数的值。
 * 给定一个int数组AB，其第零个元素和第一个元素为带交换的值，返回交换后的数组。
 */

import java.util.*;
import java.util.concurrent.Exchanger;

class Exchange {
    public int[] exchangeAB(int[] AB) {
        // write code here
       AB[0] = AB[0] ^ AB[1];
       AB[1] = AB[0] ^ AB[1];
       AB[0] = AB[0] ^ AB[1];
       return AB;
    }
}

public class Practice176 {
    public static void main(String[] args) {
        Exchange exchange = new Exchange();
        int[] num = exchange.exchangeAB(new int[]{1,2});
        for (int t : num){
            System.out.print(t + " ");
        }
    }
}
