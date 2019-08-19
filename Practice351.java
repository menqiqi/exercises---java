/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 */

public class Practice351 {
    public static void main(String[] args) {
        int res1 = divide(10,3);
        int res2 = divide(7,-3);
        int res3 = divide(100,10);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == 0)
            return  0;
        long ldividend = 0, ldivisor = 0;
        ldividend = Math.abs(dividend);
        ldivisor = Math.abs(divisor);
        long cur_bit = 1,result = 0;

        while (ldividend >= ldivisor<<1){
            ldivisor<<=1;
            cur_bit<<=1;
        }

        while (cur_bit>0 && ldividend>0){
            if (ldividend >= ldivisor){
                ldividend -= ldivisor;
                result += cur_bit;
            }
            cur_bit>>=1;
            ldivisor>>=1;
        }
        result = (dividend<0 && divisor>0) || (dividend>0 && divisor<0) ? -result : result;
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int)result;
    }
}
