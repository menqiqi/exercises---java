/**
 * 有两个32位整数m,n，请编写算法将m的二进制数位插入到n的二进制的第j到第i位，其中二进制的位数从低位到高位
 * 且以0开始。
 * 给定两个整数int n，int m，同时给定int j，int i，意义如题所述，请返回操作后的数，保证n的第j到第i位
 * 均为零，且m的二进制位数小于等于i-j+1.
 */

class BinInsert {
    public int binInsert(int n, int m, int j, int i) {
        // write code here
        String newn = cal(n).toString();
        String newm = cal(m).toString();
        String res = "";
            String tmp1 = newn.substring(0,j);
            String tmp2 = newn.substring(i+1,newn.length());
            int num = (i-j)+1 - newm.length();
            String tmp3 = "";
            for(int k = 0; k < num; k++){
                tmp3 = tmp3 + "0";
            }
            res = tmp1+newm+tmp3+tmp2;
            StringBuilder bu = new StringBuilder(res);
        return Integer.valueOf(bu.reverse().toString(),2);
    }

    //计算该数的二进制数
    private static StringBuilder cal(int x){
        StringBuilder res = new StringBuilder();
        while(x > 0){
            res = res.append(new String(String.valueOf(x%2)));
            x = x/2;
        }
        return res;
    }
}

public class Practice168 {
    public static void main(String[] args) {
        BinInsert bin = new BinInsert();
        System.out.println(bin.binInsert(1024,19,2,6));
    }
}
