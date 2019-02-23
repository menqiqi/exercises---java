/**
 * 六一儿童节，老师带了很多好吃的巧克力到幼儿园。
 * 每块巧克力j的重量为w[j]，对于每个小朋友i，当他分到的巧克力大小达到h[i] (即w[j]>=h[i])，他才会上去表演节目。
 * 老师的目标是将巧克力分发给孩子们，使得最多的小孩上台表演。
 * 可以保证每个w[i]> 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Practice136 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());  //小朋友的人数
            String[] str1 = bf.readLine().split(" ");
            int[] child = new int[n];
            for(int i = 0; i < n; i++){
                child[i] = Integer.parseInt(str1[i]);
            }
            int m = Integer.parseInt(bf.readLine());  //巧克力的个数
            String[] str2 = bf.readLine().split(" ");
            int[] cho = new int[m];
            for(int j = 0; j < m; j++){
                cho[j] = Integer.parseInt(str2[j]);
            }
            System.out.println(maxChild(n,child,m,cho));

    }

    private static int maxChild(int n, int[] h, int m, int[] w){
        if (n == 0 || m == 0)
            return 0;
        Arrays.sort(h);
        Arrays.sort(w);
        int max = 0;
        int i = 0;  //指向小朋友
        int j = 0;  //指向巧克力
        while(i < n && j < m){
            if(w[j] >= h[i]){
                max++;
                i++;
            }
            j++;
        }
        return max;
    }
}
