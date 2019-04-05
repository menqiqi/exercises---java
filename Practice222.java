import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 输入一个数n，然后输入n个数值各不相同，再输入一个值x，输出这个值在这个数组中的下标。
 * （从0开始，若不在数组中，则输出-1）
 *
 * 输入描述：
 * 输入n，接着输入n个数，然后输入x
 *
 * 输出描述：
 * 所在数组的下标
 */

public class Practice222 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] strings = bf.readLine().split(" ");
        int[] data = new int[n];
        for (int i = 0; i < n; i++){
            data[i] = Integer.parseInt(strings[i]);
        }
        int des = Integer.parseInt(bf.readLine());
            for (int j = 0; j < n; j++){
                if (data[j] == des){
                    System.out.println(j);
                    return;
                }
            }
            System.out.println(-1);
    }
}
