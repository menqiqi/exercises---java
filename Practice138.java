/**
 * 小易为了向他的父母表现他已经长大独立了,他决定搬出去自己居住一段时间。
 * 一个人生活增加了许多花费: 小易每天必须吃一个水果并且需要每天支付x元的房屋租金。
 * 当前小易手中已经有f个水果和d元钱,小易也能去商店购买一些水果,商店每个水果售卖p元。
 * 小易为了表现他独立生活的能力,希望能独立生活的时间越长越好,小易希望你来帮他计算一下他最多能独立生活多少天。
 */

/*
import java.util.Scanner;

public class Practice138{
public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] num = in.nextLine().split(" ");
        int x = Integer.parseInt(num[0]);  //每天的租金
        int f = Integer.parseInt(num[1]);  //现有的水果数
        int d = Integer.parseInt(num[2]);  //现有的钱
        int p = Integer.parseInt(num[3]);  //每个水果的售价
        System.out.println(maxDay(x,f,d,p));
        }

public static int maxDay(int x,int f,int d,int p){
        int a = d/x;  //现在的钱全部交租，可以生活的天数
        if(a <= f){
        return a;
        }else{
        int b = d - f*x;  //生活f天后，剩余的钱
        int cost = x + p;  //每天的花销
        int day = b / cost;  //f天后，还可以生活的天数
        return day+f;
        }
        }
        }*/
