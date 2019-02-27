import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice143{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] num1 = bf.readLine().split(" ");
        int n = Integer.parseInt(num1[0]);  //计划飞行的次数
        int s = Integer.parseInt(num1[1]);  //初始状态下的燃油量
        String[] num2 = bf.readLine().split(" ");
        int[] f = new int[n];
        for(int i = 0; i < n; i++){
            f[i] = Integer.parseInt(num2[i]);
        }
        System.out.println(flyNum(n,s,f));
    }

    public static int flyNum(int n, int s, int[] f){
        int count = 0;
        int cur = s;
        int i = 0;
        while(i < n){
            if(cur >= f[i]){
                cur = cur - f[i];
                count++;
                i++;
            }else{
                break;
            }
        }
        return count;
    }
}