import java.util.Scanner;

/**
 * 我们都算过从1加到100的总和为5050，现要求编写一个程序：100以内数字相加（即1+2+3.....+100），求解出最后一个加到总和为n的数字是哪个。
 */

public class Practice378 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = Integer.parseInt(in.nextLine());
            if (n > 5050){
                System.out.println("No");
                break;
            }
            if (n < 1){
                System.out.println("No");
                return;
            }
            int sum = 0;
            for (int i = 1; i <= 101; i++){
                if (sum > n){
                    System.out.println("No");
                    break;
                }else if(sum == n){
                    System.out.println(i-1);
                    break;
                }else {
                    sum += i;
                }
            }
        }
        in.close();
    }
}
