import java.util.Scanner;

/**
 * 守望者的逃离
 *
 * 法师住在喜马拉雅上脚下的一个村庄，突然一天，发生大雪崩，很快村庄就要被掩埋，所有人将会遇难。
 *
 * 法师的跑步的速度为13m/s,以这样的速度，是无法逃离雪崩的。但是，法师有闪跳技能，可在1s内移动50m,每次使用技能后，会消耗10点魔法值。魔法值的恢复速度为4点/s,只有在原地休息状态时才能够恢复。
 *
 * 现已知法师初始值为M,所在位置与安全区域的距离为S,雪崩到达村庄的时间为T。
 *
 * 编写一个程序，计算法师如何在最短的时间内到达安全区域，如不能够逃脱，输出法师在时间内走的最远距离。
 */

public class Practice372 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] data = in.nextLine().split(" ");
        int m = Integer.parseInt(data[0]);  //法师魔法的初始值
        int s = Integer.parseInt(data[1]);  //距离
        int t = Integer.parseInt(data[2]);  //雪崩到村庄的时间
        int[] num = new int[t+1];  //索引对应的秒数中跑的距离
        num[0] = 0;
        for (int i = 1; i <= t; i++){
            if (m >= 10){
                num[i] = num[i-1]+50;
                m -= 10;
            }else {
                num[i] = num[i-1];
                m += 4;
            }
        }

        for (int j = 1; j <= t; j++){
            if (num[j] < (num[j-1]+13)){
                num[j] = num[j-1]+13;
            }
            if (num[j] >= s) {
                System.out.println("Yes" + " " + j);
                return;
            }
        }
        System.out.println("No"+" "+num[t]);

    }
}
