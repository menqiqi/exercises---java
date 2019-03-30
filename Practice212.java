import java.util.Scanner;

/**
 * 给定一个正整数，计算n与斐波那契数的最小差值。
 */

public class Practice212 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();  //给定的整数
            System.out.println(cal(n));
        }
        in.close();
    }

    private static int cal(int n){
        //将斐波那契数放在list中
        //List<Integer> list = new ArrayList<>();
        //list.add(1);
        //list.add(1);
        int a = 0,b = 1,c;
        while (true){
            if (n >= a && n <= b){
                //将n和a,b的差值进行比较
                int diff1 = Math.abs((n-a));
                int diff2 = Math.abs((n-b));
                return Math.min(diff1,diff2);
            }
            c = a + b;
            //list.add(c);
            a = b;
            b = c;
        }
    }
}
