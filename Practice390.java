import java.util.Scanner;

/**
 * 约瑟夫环问题
 */

public class Practice390 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        System.out.println(Circle(n,m)+1);
        in.close();
    }

    public static int Circle(int n, int m){
        if (n == 1){
            return 0;
        }
        return (Circle(n-1,m)+m)%n;
    }
}
