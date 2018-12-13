/**
 * 给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。
 *
 * 如果没有两个连续的 1，返回 0 。
 *
 * 示例 ：
 *
 * 输入：22
 * 输出：2
 * 解释：
 * 22 的二进制是 0b10110 。
 * 在 22 的二进制表示中，有三个 1，组成两对连续的 1 。
 * 第一对连续的 1 中，两个 1 之间的距离为 2 。
 * 第二对连续的 1 中，两个 1 之间的距离为 1 。
 * 答案取两个距离之中最大的，也就是 2 。
 */

class Solution {
    public int binaryGap(int N) {
        int max = 0;
        int count = 0;
        int num = N;
        while(num != 0){
            if((num & 1) == 0 && count > 0){
                //已经出现了1，最大连续1的距离中间都是0
                count++;
            }else if((num & 1) == 1){
                //如果是出现第一次1，count记为1，若是后面多次出现，就是另外的两个连续的1，重新计数
                if(count > max)
                    max = count;
                count = 1;
            }
            num = num >> 1;
        }
        return max;
    }
}

/*利用数组存储1出现的下标
class Solution {
    public int binaryGap(int N) {
        int[] data = new int[32];  //最多就32位
        int k = 0;
        for(int i = 0; i < 32; i++){
            if(((N >> i) & 1) == 1)
                data[k++] = i;
        }
        int res = 0;
        for(int i = 0; i < k-1; i++){
            res = Math.max(res,data[i+1]-data[i]);
        }
        return res;
    }
}*/

public class Practice51 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.binaryGap(5));
    }
}
