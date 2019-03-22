/**
 * 读入n名学生的成绩，将获得某一给定分数的学生人数输出。
 *
 * 输入描述：
 * 第一行输入学生的个数，第二行输入学生的成绩，第三行输入给定的成绩
 *
 * 输出描述：
 * 与给定成绩相同的学生的个数
 */

import java.util.Scanner;
public class Practice189 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int num = Integer.parseInt(in.nextLine());
            String[] score = in.nextLine().split(" ");
            int des = Integer.parseInt(in.nextLine());
            int res = 0;
            for(int i = 0; i < num; i++){
                if(des == Integer.parseInt(score[i]))
                    res++;
            }
            System.out.println(res);
        }
    }
}