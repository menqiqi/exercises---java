/**
 * 月神拿到一个新的数据集，其中每个样本都是一个字符串（长度小于100），样本的的后六位是纯数字，月神需要将所有样本的后六位数字提出来，转换成数字，并排序输出。
 *
 * 月神要实现这样一个很简单的功能确没有时间，作为好朋友的你，一定能解决月神的烦恼，对吧。
 */

import java.util.*;
public class Practice345{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int M = Integer.parseInt(in.nextLine());
        int[] data = new int[M];
        int i = 0;
        while(i < M){
            String str = in.nextLine();
            String s = str.substring(str.length()-6,str.length());
            int a = Integer.parseInt(s);
            data[i] = a;
            i++;
        }
        Arrays.sort(data);
        for(int t:data)
            System.out.println(t);
    }
}