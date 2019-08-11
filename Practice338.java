/**
 * 又到了丰收的季节，恰逢小易去牛牛的果园里游玩。
 * 牛牛常说他对整个果园的每个地方都了如指掌，小易不太相信，所以他想考考牛牛。
 * 在果园里有N堆苹果，每堆苹果的数量为ai，小易希望知道从左往右数第x个苹果是属于哪一堆的。
 * 牛牛觉得这个问题太简单，所以希望你来替他回答。
 * 输入描述:
 * 第一行一个数n(1 <= n <= 105)。
 * 第二行n个数ai(1 <= ai <= 1000)，表示从左往右数第i堆有多少苹果
 * 第三行一个数m(1 <= m <= 105)，表示有m次询问。
 * 第四行m个数qi，表示小易希望知道第qi个苹果属于哪一堆。
 * 输出描述:
 * m行，第i行输出第qi个苹果属于哪一堆。
 */

import java.util.*;
public class Practice338 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        a[0] = sc.nextInt();
        for(int i=1;i<n;i++){
            a[i] = a[i-1]+sc.nextInt();
        }
        int m = sc.nextInt();
        int[] q = new int[m];
        for(int i=0;i<m;i++){
            q[i] = sc.nextInt();
        }
        for(int i=0;i<m;i++){
            int left=0,right=n-1;
            while(left+1!=right){
                int mid = (left+right)>>1;
                if(q[i]<=a[mid])right=mid;
                else left=mid;
            }
            System.out.println(q[i]>a[left]?right+1:left+1);
        }
    }
}