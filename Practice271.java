/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，
 * 因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class Practice271 {
    private static boolean mm(int i){
        while(i%2==0)
            i=i/2;
        while(i%3==0)
            i=i/3;
        while(i%5==0)
            i=i/5;
        if(i==1)
            return true;
        else
            return false;
    }
    public static void main(String[]args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        br.close();
        if(n==1){
            System.out.println(1);
            return ;
        }
        int i=2;
        int j=1;
        while(true){
            if(mm(i)){
                j++;
                if(n==j){
                    System.out.println(i);
                    return;
                }
            }
            i++;
        }
    }
}