import java.util.Scanner;
public class Practice310{
    public static void main(String[] args){
        //首项是num*num+1-num
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int num = Integer.parseInt(in.next());
            int i = num*num+1-num;
            String str = ""+i;
            for (int j = 0; j < num-1; j++){
                i = i+2;
                str = str+"+"+i;
            }
            System.out.println(str);
        }
    }
}