/**
 * 一个百万富翁遇到一个陌生人，陌生人找他谈了一个还钱的计划，
 * 该计划如下：我每天给你10万元，你第一天给我1分钱，第二天给我2分钱，第三天4分钱。。。
 * 这样交换30天后，百万富翁交出了多少钱？陌生人交出了多少钱？
 * 注意：
 * 百万富翁交出的钱以万为单位，陌生人交出的钱以分为单位。
 */

public class Practice194 {
    public static void main(String[] args){
        long sum = 0;
        int people1 = 1;  // 分
        int people2 = 0;  // 万元

        for(int i = 0; i < 30; i++){
            people1 = people1 << i;
            people2 = people2 + 10;

            sum = sum + people1;
            people1 = 1;
        }
        System.out.println(people2+" "+sum);
    }
}