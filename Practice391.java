import java.util.Scanner;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 */

public class Practice391 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cols = in.nextInt();
        int rows = in.nextInt();
        System.out.println(differentPath(cols,rows));
        in.close();
    }

    public static int differentPath(int cols, int rows){
        if (cols <= 0 || rows <= 0){
            return 0;
        }
        int[] res = new int[cols];
        res[0] = 1;
        for (int i = 0; i < rows; i++){
            for (int j = 1; j < cols; j++){
                res[j] = res[j] + res[j-1];
            }
        }
        return res[cols-1];
    }
}
