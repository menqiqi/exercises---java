/**
 * 玛雅人有一种密码，如果字符串中出现连续的2012四个数字就能解开密码。
 * 给一个长度为N的字符串（2=<N<=13），该字符串中只含有0,1,2三种数字，
 * 问这个字符串要移位几次才能解开密码，每次只能移动相邻的两个数字。
 * 例如02120经过一次移位，可以得到20120,01220,02210,02102，其中20120符合要求，因此输出为1.
 * 如果无论移位多少次都解不开密码，输出-1。
 */

import java.util.*;
public class Practice267
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            int n=sc.nextInt();
            System.out.println(BFS(sc.next()));
        }
    }

    private static int BFS(String line)
    {
        int n=line.length();
        if(n<4)
        {
            return -1;
        }
        if(line.equals("2012"))
        {
            return 0;
        }
        HashMap<String, Byte> visit = new HashMap<String,Byte>();
        ArrayList<Item> list = new ArrayList<Item>();
        visit.put(line, (byte) 0);
        list.add(new Item(line, 0));
        while(!list.isEmpty())
        {
            Item item = list.remove(0);
            if(item.str.contains("2012"))
            {
                return item.ct;
            }
            for(int i=0;i<n-1;i++)
            {

                char[] cs = item.str.toCharArray();
                char temp=cs[i];
                cs[i]=cs[i+1];
                cs[i+1]=temp;
                String s=String.valueOf(cs);
                if(!visit.containsKey(s))
                {

                    visit.put(s, (byte) 0);
                    list.add(new Item(s, item.ct+1));

                }
            }
        }
        return -1;
    }

}
class Item
{
    String str;
    int ct;
    public Item(String str, int ct)
    {
        super();
        this.str = str;
        this.ct = ct;
    }

}