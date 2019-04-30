import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 有n只小熊，他们有着各不相同的战斗力。每次他们吃糖时，会按照战斗力来排，战斗力高的小熊拥有优先选择权。
 * 前面的小熊吃饱了，后面的小熊才能吃。每只小熊有一个饥饿值，每次进食的时候，
 * 小熊们会选择最大的能填饱自己当前饥饿值的那颗糖来吃，可能吃完没饱会重复上述过程，但不会选择吃撑。
 * 现在给出n只小熊的战斗力和饥饿值，并且给出m颗糖能填饱的饥饿值。
 * 求所有小熊进食完之后，每只小熊剩余的饥饿值。
 * <p>
 * 输入描述:
 * 第一行两个正整数n和m，分别表示小熊数量和糖的数量。（n <= 10, m <= 100）
 * 第二行m个正整数，每个表示着颗糖能填充的饥饿值。
 * 接下来的n行，每行2个正整数，分别代表每只小熊的战斗力和当前饥饿值。
 * 题目中所有输入的数值小于等于100。
 * 输出描述:
 * 输出n行，每行一个整数，代表每只小熊剩余的饥饿值。
 * <p>
 * 示例1
 * 输入
 * 2 5
 * 5 6 10 20 30
 * 4 34
 * 3 35
 * <p>
 * 输出
 * 4
 * 0
 * <p>
 * 说明
 * 第一只小熊吃了第5颗糖
 * 第二只小熊吃了第4颗糖
 * 第二只小熊吃了第3颗糖
 * 第二只小熊吃了第1颗糖
 */
public class Practice270 {
    static class Bear {
        int power, hungry;

        Bear(int power, int hungry) {
            this.power = power;
            this.hungry = hungry;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int n = Integer.parseInt(String.valueOf(input[0]));
        int m = Integer.parseInt(String.valueOf(input[1]));
        String[] candies = bf.readLine().split(" ");
        int[] candy = new int[candies.length];
        for (int i = 0; i < candy.length; i++) {
            candy[i] = Integer.parseInt(String.valueOf(candies[i]));
        }
        Bear[] bear = new Bear[n];
        for (int i = 0; i < n; i++) {
            String[] arg = bf.readLine().split(" ");
            bear[i] = new Bear(Integer.parseInt(String.valueOf(arg[0])), Integer.parseInt(String.valueOf(arg[1])));
        }
        getCount(n, m, candy, bear);
    }

    private static void getCount(int n, int m, int[] candy, Bear[] bear) {
        Arrays.sort(candy);
        int max = 0;
        int count = 0;
        int k = 0;
        int[] result = new int[n];
        while (true) {
            for (int i = 0; i < n; i++) {
                if (bear[i].power > max) {
                    k = i;
                    max = bear[i].power;
                }
            }
            count++;
            bear[k].power = Integer.MIN_VALUE;
            max = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (bear[k].hungry >= candy[j]) {
                    bear[k].hungry = bear[k].hungry - candy[j];
                    candy[j] = 0;
                }
            }
            result[k] = bear[k].hungry;
            if (count == n) {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
    }
}