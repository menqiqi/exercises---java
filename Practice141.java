import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice141{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] str = bf.readLine().split(" ");
        int[] x = new int[n];
        for(int i = 0; i < n; i++)
            x[i] = Integer.parseInt(str[i]);
        if(numLine(n,x)){
            System.out.println("Possible");
        }else{
            System.out.println("Impossible");
        }
    }

    public static boolean numLine(int n, int[] x){
        //先排序（插排）
        for(int i = 1; i < n; i++){
            int key = x[i];
            int end = i - 1;
            while(end >= 0 && x[end] > key){
                x[end+1] = x[end];
                end--;
            }
            x[end+1] = key;
        }
        //查看是否每两个元素之间的差值都相同
        int tmp = x[1] - x[0];
        for(int j = 1; j < n-1; j++){
            if(tmp != x[j+1] - x[j])
                return false;
        }
        return true;
    }
}