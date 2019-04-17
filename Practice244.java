import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，
 * 求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，
 * 0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
 */

public class Practice244 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = Integer.parseInt(in.nextLine());
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                list.add(i);
            }

            int i = 0;
            int size = list.size();
            while (size > 1){
                i = (i+2)%size;
                list.remove(i);
                size = list.size();
            }
            System.out.println(list.get(0));
        }
        in.close();
    }
}
