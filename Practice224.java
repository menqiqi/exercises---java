
import java.text.NumberFormat;
import java.util.Scanner;


/**
 *
 * 今年公司年会的奖品特别给力，但获奖的规矩却很奇葩：
 * 1. 首先，所有人员都将一张写有自己名字的字条放入抽奖箱中；
 * 2. 待所有字条加入完毕，每人从箱中取一个字条；
 * 3. 如果抽到的字条上写的就是自己的名字，那么“恭喜你，中奖了！”
 * 现在告诉你参加晚会的人数，请你计算有多少概率会出现无人获奖？
 *
 *
 * 解析：
 * 把姓名与抽到奖各不对应的方法数用D(n)表示
 * ① 拿到第n个元素，共有n-1种放法
 * ② 把n放在位置k上，那么k有两种可能
 *      1）k放在位置n上，那么其余的数字就有D(n-2)种方法
 *      2）k不放在位置n上，对于剩余的n-1个数字，就有D(n-1)种方法
 *
 * 特殊情况：
 * D(0) = 0 D(1) = 0 D(2) = 1
 *
 *
 */


public class Practice224 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = Integer.parseInt(in.nextLine());
            double err = method(n);
            double num = add(n);
            NumberFormat nf = NumberFormat.getPercentInstance();
            //设置百分数保留两位小数
            nf.setMinimumFractionDigits(2);
            System.out.println(nf.format( err/num));
        }
    }

    private static double method(int n){
        if (n == 0 || n == 1){
            return 0;
        }
        if (n == 2){
            return 1;
        }
        return (n-1)*(method(n-2)+method(n-1));
    }

    private static double add(int n){
        if (n == 1){
            return 1;
        }
        return n*(add(n-1));
    }
}


