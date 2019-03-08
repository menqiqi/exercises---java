import java.util.Scanner;

public class Practice154 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       while (in.hasNext()){
           String input = in.nextLine();
           try {
               System.out.println(sum(Integer.parseInt(input)));
           }catch (Exception e){
               System.out.println("-1");
           }
       }
    }

    private static int sum(int n){
        return (3*n+1) * n / 2;
    }


}
