/**
 * 牛牛又从生物科研工作者那里获得一个任务,这次牛牛需要帮助科研工作者从DNA序列s中找出最短没有出现在DNA序列s中的DNA片段的长度。
 * 例如:s = AGGTCTA
 * 序列中包含了所有长度为1的('A','C','G','T')片段,但是长度为2的没有全部包含,
 * 例如序列中不包含"AA",所以输出2。
 *
 * 输入描述:
 *
 * 输入包括一个字符串s,字符串长度length(1 ≤ length ≤ 2000),其中只包含'A','C','G','T'这四种字符。
 *
 * 输出描述:
 *
 * 输出一个正整数,即最短没有出现在DNA序列s中的DNA片段的长度。
 */


import java.util.*;

public class Practice178 {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        int j,i,n=str.length();
        //一个数字一个数字的比较，从1到n-1
        for(i=1;i<=n;i++){
            //set集合不会出现重复元素
            HashSet<String> set = new HashSet<String>();
            for(j=0;j<=n-i;j++){
                set.add(str.substring(j,j+i));
            }
            //每个位置只能放4个字符，所以每个位置最多有4种可能
            //如果set的大小小于可能出现的次数，就输出
            if(set.size()<Math.pow(4,i)){
                System.out.println(i);
                break;
            }
        }
    }
}