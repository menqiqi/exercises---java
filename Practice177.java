/**
 * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同，则称这种编码为格雷码，请编写一种函数，使用
 * 递归的方式生成n为的格雷码。
 * 给定一个整数n，返回n位的格雷码，顺序从0开始。
 */

class GrayCode {
    public String[] getGray(int n) {
        // write code here
        String[] str = new String[2<<(n-1)];
        createGrayCode(str,n);
        return str;
    }

    private static void createGrayCode(String[] codes, int n){
        if (n == 1){
            codes[0] = "0";
            codes[1] = "1";
        }else {
            createGrayCode(codes,n-1);
            int len = 2<<(n-1);
            int mid = len>>1;
            //新数组是倒着存放的，后半部分是上一个数组前面加1，前半部分是上一个数组前面加0
            for (int i = len-1,j = 0; i >= 0; i--){
                if (i < mid){
                    codes[i] = "0"+codes[--j];
                }else {
                    codes[i] = "1"+codes[j++];
                }
            }
        }
    }
}


public class Practice177 {
    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        String[] str = grayCode.getGray(3);
        for (String t : str)
            System.out.print(t+" ");
    }
}
