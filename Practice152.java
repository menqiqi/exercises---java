import java.util.Scanner;

/**
 * 小易去商店买苹果，只有6个一袋和8个一袋的包装。小易恰好只购买n个苹果，购买尽量少的袋数方便携带。
 * 如果不能恰好购买n个，将不会购买。
 * 输出一个整数表示恰好购买的袋数，若不能买恰好n个苹果，就输出-1.
 */

public class Practice152 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int count = n / 8;
        int tmp = n % 8;  //计算每次分配之后剩余的苹果数
        if (tmp == 0){
            System.out.println(count);
            return;
        }else {
            while (count != 0){
                count--;
                tmp = tmp + 8;
                if (tmp % 6 == 0){
                    count = count + (tmp/6);
                    System.out.println(count);
                    return;
                }
            }
            System.out.println(-1);
        }
    }
}
