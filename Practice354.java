/**
 * 我们部门需要装饰墙，但是墙非常非常的长，有一千万米。我们会按顺序贴很多海报在上面，这些海报相互之间会重叠，请问下，最后还能看到哪些？（只看到一部分也算）
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice354 {
    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());
            int count = 0;
            int[][] a = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] str = bf.readLine().split(" ");
                a[i][0] = Integer.parseInt(str[0]);
                a[i][1] = Integer.parseInt(str[1]);
            }
            for (int j = 0; j < n; j++) {
                if (cover(a, n, a[j][0], a[j][1], j + 1)) {
                    count++;
                }
            }
            System.out.println(count);
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean cover(int[][] a, int n, int Li, int Ri, int next) {
        if (Li == Ri)
            return false;
        if (next >= n)
            return true;
        if (a[next][0] <= Li && Ri <= a[next][1])       // (x,y)被第t张海报完全覆盖
            return false;
        else if (a[next][0] >= Ri || a[next][1] <= Li)  //（x,y)和第t张海报不交叠
            return cover(a, n, Li, Ri, next + 1);
        else if (Li <= a[next][0] && a[next][1] <= Ri)
            return cover(a, n, Li, Ri, next + 1);
        else if (Li < a[next][1] && a[next][1] < Ri)
            return cover(a, n, a[next][1], Ri, next + 1); //海报前部分被覆盖
        else if (Li < a[next][0] && a[next][0] < Ri)
            return cover(a, n, Li, a[next][0], next + 1); //海报后部分被覆盖
        return false;
    }
}
