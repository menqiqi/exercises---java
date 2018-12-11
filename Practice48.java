import java.util.ArrayList;
import java.util.List;

/**
 * 自除数 是指可以被它包含的每一位数除尽的数。
 *
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 *
 * 还有，自除数不允许包含 0 。
 *
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数
 */

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        int num = left;
        while(num <= right){
            int cur = num;
            int tmp = -1;
            while(cur != 0){
                tmp = cur % 10;
                if(tmp == 0)
                    //自除数不允许包含0
                    break;
                cur = cur / 10;
                if( num % tmp != 0) {
                    break;
                }else if(cur == 0)
                    list.add(num);
            }
            num++;
        }
        return list;
    }
}

public class Practice48 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.selfDividingNumbers(1,22));
    }
}
