import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 项目分配
 * 某公司雇有N名员工，每名员工可以负责多个项目，但一个项目只能交由一名员工负责。
 * 现在该公司接到M个项目，令Ai,j表示第i名员工负责第j个项目所带来的收益，那么如果项目分配得当，总收益最大是多少？
 */

public class Practice360 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = bf.readLine().split(" ");
        int n = Integer.parseInt(str1[0]);  //员工个数
        int m = Integer.parseInt(str1[1]);  //项目数量
        int[][] A = new int[n][m];
        for (int i = 0; i < n; i++){
            String[] str = bf.readLine().split(" ");
            for (int j = 0; j < m; j++){
                A[i][j] = Integer.parseInt(str[j]);
            }
        }

        int sum = 0;
        //只要找到每一列的最大值加起来就可以了
        for (int j = 0; j < m; j++){
            int max = A[0][j];
            for (int i = 1; i < n; i++){
                if (A[i][j] > max)
                    max = A[i][j];
            }
            sum += max;
        }
        System.out.println(sum);
    }
}