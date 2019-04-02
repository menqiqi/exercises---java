/**
 * 输入描述:
 *
 * 输入候选人的人数，第二行输入候选人的名字，第三行输入投票人的人数，第四行输入投票。
 *
 * 输出描述:
 *
 * 每行输出候选人的名字和得票数量。
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Practice218{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();  //候选人个数
            in.nextLine();
            String[] name = in.nextLine().split(" ");  //候选人姓名
            Map<String,Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++){
                map.put(name[i],0);
            }
            map.put("Invalid",0);

            int num = in.nextInt();  //投票人个数
            in.nextLine();
            String[] data = in.nextLine().split(" ");  //投票的人
            for (String str : data){
                if (map.containsKey(str)){
                    map.put(str,map.get(str)+1);
                }else {
                    map.put("Invalid",map.get("Invalid")+1);
                }
            }
            for (int i = 0; i < n; i++){
                String tmp = name[i];
                System.out.println(tmp+" : "+map.get(tmp));
            }
            System.out.println("Invalid"+" : "+map.get("Invalid"));
        }
    }
}




