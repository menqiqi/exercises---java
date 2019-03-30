/**
 *
 * 老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩.
 * 输入描述:
 *
 * 输入包括多组测试数据。
 * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 * 学生ID编号从1编到N。
 * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 *
 *
 *
 * 输出描述:
 *
 * 对于每一次询问操作，在一行里面输出最高成绩.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Practice210{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = bf.readLine().split(" ");
        int N = Integer.parseInt(str1[0]);  //学生的数目
        int M = Integer.parseInt(str1[1]);  //操作的数目
        String[] str2 = bf.readLine().split(" ");
        int[] score = new int[N];  //学生的成绩
        for(int i = 0; i < N; i++){
            score[i] = Integer.parseInt(str2[i]);
        }
        List<Integer> res = new ArrayList<>();
        int count = 0;
        while(count < M){
            count++;
            String[] str = bf.readLine().split(" ");
            int A = Integer.parseInt(str[1]);
            int B = Integer.parseInt(str[2]);
            if(str[0].equals("Q")){
                //询问操作
                int max = score[A-1];
                for(int i = A; i < B; i++){
                    if(max < score[i])
                        max = score[i];
                }
                res.add(max);
            }
            if(str[0].equals("U")){
                //更新操作
                score[A-1] = B;
            }
        }
        for(int t : res){
            System.out.println(t);
        }
    }
}





