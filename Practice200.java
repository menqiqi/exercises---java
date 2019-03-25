import java.util.*;
import java.util.Map.Entry;

/**
 * 输入按成绩进行排序。
 *
 * 输入描述：
 * 第一行输入学生个数，第二行输入规则，例如0代表降序输出，后面输入每个学生的姓名和成绩
 *
 * 输出描述：
 * 按照一定规则输出学生的姓名和成绩
 */
public class Practice200 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();                  //接收学生数量
            Map<Integer,Integer> map = new TreeMap<>();   //创建treemap存储数据
            for(int i=0;i<n;i++){                         //接收学生学号及成绩并存入treemap
                map.put(sc.nextInt(),sc.nextInt());
            }                                           //将treemap转成list存储
            List<Map.Entry<Integer,Integer>> list = new ArrayList(map.entrySet());
            //将list进行排序，用了一个匿名内部类定义比较器
            Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>(){
                public int compare(Entry<Integer,Integer> cp1,Entry<Integer,Integer> cp2){
                    if(cp2.getValue() > cp1.getValue()){
                        return -1;
                    }else if(cp2.getValue().equals(cp1.getValue())){  //此else可以其实可以不写的
                        return cp2.getKey() > cp1.getKey() ? -1: 1;   //因为treemap默认是键升序排列
                    }
                    return 1;
                }
            });
            for(Map.Entry<Integer, Integer> mapping : list){
                System.out.println(mapping.getKey()+" "+mapping.getValue());
            }
        }
    }
}