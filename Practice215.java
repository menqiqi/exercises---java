/**
 * 北京大学对本科生的成绩施行平均学分绩点制（GPA）。
 * 既将学生的实际考分根据不同的学科的不同学分按一定的公式进行计算。
 * 公式如下： 实际成绩 绩点 90——100 4.0 85——89 3.7 82——84 3.3 78——81 3.0 75——77 2.7 72——74 2.3 68——71 2.0 64——67 1.5 60——63 1.0 60以下 0
 * 1．一门课程的学分绩点=该课绩点*该课学分
 * 2．总评绩点=所有学科绩点之和/所有课程学分之和 现要求你编写程序求出某人A的总评绩点（GPA）。
 *
 * 输入描述：
 * 第一行 总的课程数n（n<10）；
 * 第二行 相应课程的学分（两个学分间用空格隔开）；
 * 第三行 对应课程的实际得分；
 * 此处输入的所有数字均为整数。
 *
 * 输出描述：
 * 输出有一行，总评绩点，精确到小数点后2位小数。（printf("%.2f",GPA);）
 *
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Practice215{
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());  //总的课程数
        String[] str1 = bf.readLine().split(" ");
        int[] data = new int[n];  //每门课程的学分
        String[] str2 = bf.readLine().split(" ");
        int[] score = new int[n];  //每门课程的成绩
        int addData = 0;  //记录所有课程学分之和
        for(int i = 0; i < n; i++){
            data[i] = Integer.parseInt(str1[i]);
            score[i] = Integer.parseInt(str2[i]);
            addData = addData + data[i];
        }
        double count = 0;  //记录所有课程绩点之和
        for(int i = 0; i < n; i++){
            if(score[i] <= 100 && score[i] >= 90){
                count = count + 4*data[i];
            }else if(score[i] <= 89 && score[i] >= 85){
                count = count + 3.7*data[i];
            }else if(score[i] <= 84 && score[i] >= 82){
                count = count + 3.3*data[i];
            }else if(score[i] <= 81 && score[i] >= 78){
                count = count + 3*data[i];
            }else if(score[i] <= 77 && score[i] >= 75){
                count = count + 2.7*data[i];
            }else if(score[i] <= 74 && score[i] >= 72){
                count = count + 2.3*data[i];
            }else if(score[i] <= 71 && score[i] >= 68){
                count = count + 2*data[i];
            }else if(score[i] <= 67 && score[i] >= 64){
                count = count + 1.5*data[i];
            }else if(score[i] <= 63 && score[i] >= 60){
                count = count + 1*data[i];
            }else{
                count = count + 0;
            }
        }

        double res = count/addData;
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(res));
    }
}
