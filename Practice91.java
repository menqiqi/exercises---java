/**
 * 一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。
 * 作为顶级域名，常用的有"com"，下一级则有"leetcode.com"，最低的一级为"discuss.leetcode.com"。
 * 当我们访问域名"discuss.leetcode.com"时，也同时访问了其父域名"leetcode.com"以及顶级域名 "com"。
 *
 * 给定一个带访问次数和域名的组合，要求分别计算每个域名被访问的次数。其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com"。
 *
 * 接下来会给出一组访问次数和域名组合的列表cpdomains 。
 * 要求解析出所有域名的访问次数，输出格式和输入格式相同，不限定先后顺序。
 *
 * 示例 :
 * 输入:
 * ["9001 discuss.leetcode.com"]
 * 输出:
 * ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
 * 说明:
 * 例子中仅包含一个网站域名："discuss.leetcode.com"。
 * 按照前文假设，子域名"leetcode.com"和"com"都会被访问，所以它们都被访问了9001次。
 */

import java.util.*;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(String data : cpdomains){
            String[] arr = data.split(" ");
            //arr[0]是个数，arr[1]是域名的地址
            int count = Integer.parseInt(arr[0]);
            if (map.get(arr[1]) == null){
                map.put(arr[1],count);
            }else{
                map.put(arr[1],map.get(arr[1])+count);
            }
            while(arr[1].indexOf(".") != -1){
                //判断是否域名地址是否包含. 如果包含，就可以拆分为多个域名地址
                int mm = arr[1].indexOf(".");  //返回"."所在的下标
                String str = arr[1].substring(mm+1);
                if (map.get(str) == null){
                    map.put(str,count);
                }else{
                    map.put(str,map.get(str)+count);
                }
                arr[1] = str;
            }
        }
        for(Map.Entry<String, Integer> set : map.entrySet()){
            //Map.Entry返回map中包含的set映射
            String con = set.getKey();
            int num = set.getValue();
            list.add(num + " " + con);
        }
        return list;
    }
}

public class Practice91 {
    public static void main(String[] args) {
        String[] data = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        Solution solution = new Solution();
        List<String> list = solution.subdomainVisits(data);
        for(String tmp : list){
            System.out.println(tmp);
        }
    }
}
