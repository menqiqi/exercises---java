package com.bittech;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TestMap {

    static void code1(){
        //HashMap
        Map<Integer,String> map = new HashMap<>();

        map.put(1,"Java");
        map.put(2,"C++");
        map.put(3,"PHP");
        map.put(null,"C");
        map.put(1,"JavaScript");
        map.put(4,null);

        Set<Map.Entry<Integer,String>> entrySet = map.entrySet();
        for(Map.Entry<Integer,String> entry : entrySet)
            System.out.println(entry.getKey() + "=" + entry.getValue());

        /*for(Integer key : map.keySet()){
            System.out.println(key + "=" + map.get(key));
        }*/
    }
    static void code2(){
        Map<Integer,String> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o1) * (-1);
            }
        });

        map.put(2,"C");
        map.put(0,"A");
        map.put(1,"B");

        System.out.println(map);
    }

    public static void main(String[] args) {

        File file = new File("E:" + File.separator + "课件" + File.separator+
                "java课件" + File.separator + "code" + File.separator + "班级.txt");
        if (file.exists() && file.isFile()){
            Map<Integer,String> map = new TreeMap<>((o1, o2) -> o1.compareTo(o2) * (-1));
            try(BufferedReader reader = new BufferedReader(
                    new FileReader(file)
            )){
                String line;
                while((line = reader.readLine()) != null){
                    String[] values = line.split("\t");
                    if (values.length >= 2){
                        //只取学号和姓名
                        int no = Integer.parseInt(values[0]); //将String类型的学号转换为int类型
                        map.put(no,values[1]);
                    }else {
                        System.out.println(line + " 无效数据");
                    }
                }
            }catch (IOException e){
                System.out.println("发生错误" + e.getMessage());
            }
            for (Map.Entry<Integer,String> entry : map.entrySet()){
                System.out.println(entry.getKey() + "  " + entry.getValue());
            }

        }else{
            System.out.println("文件不存在或者不是文件");
        }
    }
}
