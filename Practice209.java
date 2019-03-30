/**
 * 小易经常沉迷于网络游戏.有一次,他在玩一个打怪升级的游戏,他的角色的初始能力值为 a.在接下来的一段时间内,他将会依次遇见n个怪物,每个怪物的防御力为b1,b2,b3...bn. 如果遇到的怪物防御力bi小于等于小易的当前能力值c,那么他就能轻松打败怪物,并 且使得自己的能力值增加bi;如果bi大于c,那他也能打败怪物,但他的能力值只能增加bi 与c的最大公约数.那么问题来了,在一系列的锻炼后,小易的最终能力值为多少?
 *
 * 输入描述:
 *
 * 对于每组数据,第一行是两个整数n(1≤n<100000)表示怪物的数量和a表示小易的初始能力值.
 * 第二行n个整数,b1,b2...bn(1≤bi≤n)表示每个怪物的防御力
 *
 *
 *
 * 输出描述:
 *
 * 对于每组数据,输出一行.每行仅包含一个整数,表示小易的最终能力值
 */

import java.util.Scanner;

public class Practice209 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){

            int n = in.nextInt();  //怪物的数量
            int a = in.nextInt();  //初始能量
            int[] b = new int[n];  //每个怪兽的能量
            int c = a;  //代表现有的能量
            for(int i = 0; i < n; i++){
                b[i] = in.nextInt();
                if(c >= b[i]){
                    c = c + b[i];
                }else{
                    int max = c > b[i] ? c : b[i];
                    int min = c < b[i] ? c : b[i];
                    int tmp = max(max,min);
                    c = c + tmp;
                }
            }
            System.out.println(c);

        }

        in.close();
    }

    //求最大公约数
    private static int max(int max, int min){
        if(max % min == 0){
            return min;
        }
        return max(min,max%min);
    }
}


