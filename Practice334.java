/**
 * 牛牛总是睡过头，所以他定了很多闹钟，只有在闹钟响的时候他才会醒过来并且决定起不起床。从他起床算起他需要X分钟到达教室，上课时间为当天的A时B分，请问他最晚可以什么时间起床
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含一个正整数，表示闹钟的数量N(N<=100)。
 * 接下来的N行每行包含两个整数，表示这个闹钟响起的时间为Hi(0<=A<24)时Mi(0<=B<60)分。
 * 接下来的一行包含一个整数，表示从起床算起他需要
 * X(0<=X<=100)分钟到达教室。
 * 接下来的一行包含两个整数，表示上课时间为A(0<=A<24)时B(0<=B<60)分。
 * 数据保证至少有一个闹钟可以让牛牛及时到达教室。
 * 输出描述:
 * 输出两个整数表示牛牛最晚起床时间。
 *
 * 解题思路：换算成分钟再计算
 */

import java.util.*;
public class Practice334 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h=0,m=0;
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            h = sc.nextInt();
            m = sc.nextInt();
            a[i] = h*60+m;
        }
        int t = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();
        int p = h*60+m-t;
        Arrays.sort(a);
        int k = a.length-1;
        for(; k >= 0; k--){
            if(a[k] <= p){
                break;
            }
        }
        h = a[k]/60;
        m = a[k]%60;
        System.out.print(h+" "+m);
    }
}