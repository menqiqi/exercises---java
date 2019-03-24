import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  数据分页,对于指定的页数和每页的元素个数，返回该页应该显示的数据。
 * 输入描述:
 *
 * 第一行输入数据个数，第二行全部数据，第三行输入页数，第四行输入每页最大数据个数
 *
 * 输出描述:
 *
 * 输出该页应该显示的数据，超出范围请输出'超过分页范围'
 */

public class Practice198 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());  //数据个数
        String[] str = bf.readLine().split(" ");
        int[] data = new int[n];
        for (int i = 0; i < n; i++){
            data[i] = Integer.parseInt(str[i]);
        }
        int ye = Integer.parseInt(bf.readLine());  //页数
        int max = Integer.parseInt(bf.readLine());  //每页最大的数据个数

        int cur = (n-1)/max + 1;
        if (ye > cur-1){
            System.out.println("超出分页范围");
        }else {
            int start = ye * max, end = start + max > n ? n : start + max;
            for (int i = start; i < end; i++)
                System.out.println(data[i]);
        }


    }
}