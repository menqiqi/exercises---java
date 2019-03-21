/**
 * 不使用算数运算符，计算两数之和。
 *
 */

import java.util.Scanner;

class UnusualAdd {
    public int addAB(int A, int B) {
        // write code here
        StringBuilder sb = new StringBuilder();
        int flag = 0;  //进位
        while (A > 0 && B > 0) {
            if ((A & 1) == 1 && (B & 1) == 1) {
                //A和B的二进制的那一位数均为1
                if (flag == 0) {
                    //进一位
                    sb.append("0");
                    flag = 1;
                } else {
                    //进两位
                    sb.append("1");
                    flag = 1;
                }
            } else if ((A & 1) == 0 && (B & 1) == 0) {
                //A和B的二进制的那一位数均为0
                if (flag == 0) {
                    sb.append("0");
                } else {
                    sb.append("1");
                    flag = flag - 1;
                }

            } else {
                if (flag == 0){
                    sb.append("1");
                }else {
                    sb.append("0");
                    flag = 1;
                }
            }
            A = A >> 1;
            B = B >> 1;
        }
        if (A == 0 && B != 0) {
            while (B > 0) {
                if ((B & 1) == 1) {
                    //这一位的数为1
                    if (flag == 0) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                        flag = 1;
                    }
                } else {
                    if (flag == 0) {
                        sb.append("0");
                    } else {
                        sb.append("1");
                    }
                }
                B = B >> 1;
            }
        } else {
            while (A > 0) {
                if ((A & 1) == 1) {
                    //这一位的数为1
                    if (flag == 0) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                        flag = 1;
                    }
                } else {
                    if (flag == 0) {
                        sb.append("0");
                    } else {
                        sb.append("1");
                    }
                }
                A = A >> 1;
            }
        }
        if (flag != 0){
            sb.append(String.valueOf(flag));
        }
        sb = sb.reverse();
        int res = Integer.parseInt(String.valueOf(sb), 2);
        return res;
    }
}

public class Practice187 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        UnusualAdd un = new UnusualAdd();
        System.out.println(un.addAB(a,b));
    }
}
