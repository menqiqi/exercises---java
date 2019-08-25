/**
 * 小云正在参与开发一个即时聊天工具，他负责其中的会话列表部分。
 *
 * 会话列表为显示为一个从上到下的多行控件，其中每一行表示一个会话，每一个会话都可以以一个唯一正整数id表示。
 *
 * 当用户在一个会话中发送或接收信息时，如果该会话已经在会话列表中，则会从原来的位置移到列表的最上方；如果没有在会话列表中，则在会话列表最上方插入该会话。
 *
 * 小云在现在要做的工作是测试，他会先把会话列表清空等待接收信息。当接收完大量来自不同会话的信息后，就输出当前的会话列表，以检查其中是否有bug。
 */

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Practice357 {
    public static void main(String[] args)throws Exception{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(reader.readLine());
        List<String> list=new ArrayList<String>();
        for(int i=0;i<n;i++){
            int num=Integer.parseInt(reader.readLine());
            String[] s=reader.readLine().split(" ");
            List<String> set=new ArrayList<String>();
            for(int j=s.length-1;j>=0;j--){
                if(!set.contains(s[j])){
                    set.add(s[j]);
                }
            }
            StringBuilder sb=new StringBuilder();
            for(String ss:set){
                sb.append(ss+" ");
            }
            list.add(sb.toString().trim());

        }

        for(String ss:list){
            System.out.println(ss);
        }
    }

}

