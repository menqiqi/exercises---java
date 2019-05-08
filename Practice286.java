/**
 * N只小白鼠(1 <= N <= 100)，每只鼠头上戴着一顶有颜色的帽子。
 * 现在称出每只白鼠的重量，要求按照白鼠重量从大到小的顺序输出它们头上帽子的颜色。
 * 帽子的颜色用“red”，“blue”等字符串来表示。不同的小白鼠可以戴相同颜色的帽子。
 * 白鼠的重量用整数表示。
 */

import java.io.*;
import java.util.*;
class mouse implements Comparable<mouse>{
    public int weight;
    public String color;
    @Override
    public int compareTo(mouse o) {
        if(this.weight>o.weight)return 1;
        else if(this.weight<o.weight) return -1;
        else return 0;
    }
}
public class Practice286 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String s="";
        List <mouse> list =new ArrayList<mouse>();
        while((s=bf.readLine())!=null){
            int n=Integer.parseInt(s);
            for (int i = 0; i < n; i++) {
                String ss[]=bf.readLine().split(" ");
                int weight=Integer.parseInt(ss[0]);  //这个是体重
                String color=ss[1];                 //这个是颜色
                mouse m=new mouse();
                m.weight=weight;
                m.color=color;
                list.add(m);
            }
            Collections.sort(list);
            for (int i = list.size()-1; i>=0; i--) {
                System.out.println(list.get(i).color);
            }

        }
    }
}
