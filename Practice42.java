/**
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while(i < n){
            i++;
            if(i % 3 == 0 && i % 5 != 0){
                list.add("Fizz");
            }else if(i % 5 == 0 && i % 3 != 0){
                list.add("Buzz");
            }else if(i % 3 == 0 && i % 3 == 0){
                list.add("FizzBuzz");
            }else {
                list.add(i+"");
            }
        }
        return list;
    }
}

public class Practice42 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fizzBuzz(15));
    }
}
