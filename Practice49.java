/**
 * 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
 *
 * （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
 */

class Solution {
    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        while(L <= R){
            int num = L;
            int count = 0;
            while(num != 0){
                //找到计算置位的个数
                if((num & 1) == 1)
                    count++;
                num = num >> 1;
            }
            //判断计算置位是否为质数
            //质数只能被1和本身除
            int i = 0;
            for(i = 2; i <= Math.sqrt(count); i++){
                if(count % i == 0)
                    break;
            }
            //2是最小的质数
            //1不是质数
            if(count == 0 || count == 1){
                ;
            }else  if(count % i != 0  || count == 2){
                res++;
            }
            L++;
        }
        return res;
    }
}

public class Practice49 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimeSetBits(990,1048));
    }
}


