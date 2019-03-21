/**
 * 求两个字符串的最长连续公共字符串长度
 */
import java.util.Scanner;

public class Practice188 {
    public static void main(String[] args) {
        //1.将输入以空格为标志分割为s[0]和s[1]两个字符串
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine().trim();
        sc.close();
        //判断输入是否至少是两个字符串，当然，如果字符串的数量大于2，只会操作前两个，后面的字符串抛弃。
        if(input.indexOf(" ")==-1){
            System.exit(0);//如果没有找到空格，那么输入有误，直接结束
        }
        String[] s=input.split(" ");
        //2,比较两个字符串的长度，保证短字符串为s[0]，长字符串为s[1]，相等则不用交换
        if(s[0].length()>s[1].length()){
            String temp=s[0];
            s[0]=s[1];
            s[1]=temp;
        }
        //3,将s[0]和s[1]转换为字符数组便于循环处理
        char[] s0_char=s[0].toCharArray();
        char[] s1_char=s[1].toCharArray();
        int[] count=new int[s[1].length()];//统计数组，用于保存每次第一层循环匹配的结果，用于最后进行最大长度筛选
        //4,以长字符串s[1]为准，建立两层循环
        for(int start=0,end=s[0].length()-1;start<s[1].length();start++){
            int[] temp=new int[s[0].length()];//新建一个临时数组来存储匹配结果，数组的长度为短字符串的长度s[0]
            int tempN=0;//临时数组内的数字下标
            for(int j=start;j<=end;j++){
                //如果匹配成功，则该数字+1，并继续匹配
                //匹配的时候，考虑了大小写，所以if中的条件有3个，这里使用了截断或||
                if((s1_char[j]==s0_char[j-start])||(s1_char[j]==s0_char[j-start]+32)||(s1_char[j]==s0_char[j-start]-32)){//忽略大小写
                    temp[tempN]+=1;
                }else{ //如果匹配失败,临时数组内的数字下标+1
                    tempN++;
                }
                //找出本次循环匹配的临时数组中最大长度
                int max_temp=temp[0];
                for(int k=1;k<temp.length;k++){   //找出每次匹配最长的个数，这是为了防止出现匹配时非连续公共串，比如110111这算3个而不是5，101101这算2个而不是4
                    if(temp[k]>max_temp){
                        max_temp=temp[k];
                    }
                }
                count[start]=max_temp;//将该次循环最大长度赋值给统计数组中对应位置的元素
            }
            //判断结束字符的位置，如果短字符的末尾已经超出长字符串末尾了，那么比较的结尾字符应该是长字符串的最后一个字符
            if(end>=s[1].length()-1){
                end=s[1].length()-1;
            }else{
                end++;
            }
        }
        //找出统计数组中最大的数字
        int max=count[0];
        for(int k=1;k<count.length;k++){
            if(count[k]>max){
                max=count[k];
            }
        }
        //输出结果
        System.out.println(max);
    }
}
