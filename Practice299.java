/**
 * 小B乘火车和朋友们一起在N市到M市之间旅行。她在路途中时睡时醒。当她醒来观看窗外的风景时，注意到每个火车站都有一种特别颜色的旗帜，但是她看到的旗帜仅仅是经过的一小部分。小B在乘车过程中有两次清醒的时间，她到达旅程终点时处于睡梦中。出站时，她和朋友们谈论着一路的见闻，朋友们觉得很有意思，他们把N到和M之间经过车站的旗帜颜色依次列出来，然后告诉你小B记得的旗帜颜色序列，让你判断小B究竟是从N和M之间哪些方向才能看到所说颜色的旗帜，还是根本就不可能看到？颜色用字母代表，相同的字母代表相同的颜色，不同的字母则表示不同的颜色。
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice299 {

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = bf.readLine())!= null){
            String nm = line.trim();
            line = bf.readLine();
            String one = line.trim();
            line = bf.readLine();
            String two = line.trim();

            boolean left = true;
            boolean right = true;

            int pos1 = nm.indexOf(one);
            if(pos1==-1){
                left = false;
            }else{
                int pos2 = nm.indexOf(two,pos1+one.length());
                if(pos2 == -1){
                    left = false;
                }
            }
            nm = new StringBuffer(nm).reverse().toString();
            pos1 = nm.indexOf(one);
            if(pos1==-1){
                right = false;
            }else{
                int pos2 = nm.indexOf(two,pos1+one.length());
                if(pos2 == -1){
                    right = false;
                }
            }

            if(!left && !right){
                System.out.println("invalid");
            }else if(left && right){
                System.out.println("both");
            }else if(left){
                System.out.println("forward");
            }else{
                System.out.println("backward");
            }
        }
    }
}
