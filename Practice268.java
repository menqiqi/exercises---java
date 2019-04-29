/**
 * 输入一个英文句子，把句子中的单词(不区分大小写)按出现次数按从多到少把单词和次数在屏幕上输出来，
 * 要求能识别英文句号和逗号，即是说单词由空格、句号和逗号隔开。
 */

import java.io.*;
import java.util.*;

public class Practice268 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = bf.readLine()) != null) {
            String[] arr = line.split(" ");
            Map<String,Integer> map = new TreeMap<String,Integer>();
            for(int i = 0;i < arr.length;i++) {
                char ch = arr[i].charAt(arr[i].length() - 1);
                if(ch == '.' || ch == ',') {
                    arr[i] = arr[i].substring(0,arr[i].length() - 1);
                }
                arr[i] = arr[i].toLowerCase();
                if(!map.containsKey(arr[i])) {
                    map.put(arr[i], 1);
                }else {
                    map.put(arr[i], map.get(arr[i]) + 1);
                }
            }
            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
    }
}
