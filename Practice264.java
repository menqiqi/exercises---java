import java.util.ArrayList;
import java.util.Scanner;

/**
 * 有一天，小A和小B玩了一个神奇的游戏，游戏开始时，桌面上有a0个不同盒子和b0个不同的物品，
 * 每个回合，两个人可以选择增加一个新的盒子或者一个新的物品(所有物品和盒子都不同)，
 * 记当前桌子上的盒子数量为a，物品数量为b，当把b个物品放入a个盒子的方案数不小于n时，
 * 游戏结束，此时最后一位操作者判负。
 *
 * 给出a0，b0，n，如果小A先手，两个人都采用最优策略，谁能获胜，如果A获胜输出“A”，
 * 如果B获胜，输出“B”，如果是平局，输出“A&B”。
 */

public class Practice264 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());  //组数
        while (list.size() < T){
            String[] str = in.nextLine().split(" ");
            int a0 = Integer.parseInt(str[0]);  //盒子数
            int b0 = Integer.parseInt(str[1]);  //物品数
            int n = Integer.parseInt(str[2]);  //方案数
            list.add(solution(a0,b0,n));
        }

        for (String s : list){
            System.out.println(s);
        }
    }

    public static String solution(int a0,int b0,int n){
        int flag1 = 0;  //A的标志，若为0，代表数量没有超过n
        int flag2 = 0;  //B的标志，若为0，代表数量没有超过n
        while (flag1 == 0 && flag2 == 0){
            b0++;
           if (Math.pow((double)a0,(double)b0) >= n){
               flag1 = 1;
           }
           else {
               a0++;
               if (Math.pow((double)a0,(double)b0) >= n){
                   flag2 = 1;
               }
           }
        }
        if (flag1 == 1 && flag2 == 1){
            return "A&B";
        }else if (flag1 == 1){
            return "A";
        }else {
            return "B";
        }
    }
}
