/**
 * 牛牛参加了一场考试,考试包括n道判断题,每做对一道题获得1分,牛牛考试前完全没有准备,
 * 所以考试只能看缘分了,牛牛在考试中一共猜测了t道题目的答案是"正确",其他的牛牛猜为"错误"。
 * 考试结束后牛牛知道实际上n道题中有a个题目的答案应该是"正确",但是牛牛不知道具体是哪些题目,
 * 牛牛希望你能帮助他计算可能获得的最高的考试分数是多少。
 */

import java.util.Scanner;

public class Practice134{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = Integer.parseInt(str.split(" ")[0]);  //总共的题目
        int t = Integer.parseInt(str.split(" ")[1]);  //猜测是正确的题目
        int a = Integer.parseInt(str.split(" ")[2]); //正确的题目
        System.out.println(maxScore(n,t,a));
    }

    private static int maxScore(int n, int t, int a){
        int max = 0;
        if(t == a){
            //全部做对
            return n;
        }else if(t > a){
            //正确的题目全都猜对，t-a个题目猜错
                max = n - (t - a);
        }else{
            //t个正确的题目猜对，a-t个题目猜错
            max = n - (a - t);
        }
        return max;
    }
}