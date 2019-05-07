/**
 * 读入任务调度序列，输出n个任务适合的一种调度方式。
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Practice284 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            int n=Integer.parseInt(sc.nextLine());
            ArrayList<Task> list = new ArrayList<Task>();
            for(int i=0;i<n;i++)
            {
                String line = sc.nextLine();
                line=line.substring(0, line.length()-1);
                line=line.replace('(', ',');
                String[] sp = line.split(",");
                Task t = new Task(sp[0], 0);
                if(list.contains(t))
                {
                    Task task = list.get(list.indexOf(t));
                    for(int j=1;j<sp.length;j++)
                    {
                        Task task2 = new Task(sp[j], 0);
                        if(list.contains(task2))
                        {
                            continue;
                        }
                        else
                        {
                            task2.priority=task.priority+1;
                            list.add(task2);
                        }

                    }
                }
                else
                {
                    list.add(t);
                }



            }
            Collections.sort(list);
            String res="";
            for(int i=0;i<list.size();i++)
            {
                Task t = list.get(i);
                res+=t.name+" ";
            }
            System.out.println(res.trim());
        }
    }

}
class Task implements Comparable<Task>
{
    String name;
    int priority;//优先级越小越高级
    public Task(String name, int priority)
    {
        super();
        this.name = name;
        this.priority = priority;
    }
    @Override
    public int compareTo(Task o)
    {
        if(this.priority!=o.priority)
        {
            return this.priority-o.priority;
        }
        else
        {
            return this.name.compareTo(o.name);
        }
    }
    @Override
    public boolean equals(Object obj)
    {

        if(obj instanceof Task)
        {
            Task t=(Task) obj;
            return this.name.equals(t.name);
        }
        return false;
    }

}

