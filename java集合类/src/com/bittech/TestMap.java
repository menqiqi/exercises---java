package com.bittech;

/**
 * 题目要求：
 *   将一个文件中的内容读取，然后输出【学号 姓名】，并且将学号按降序排列
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TestMap {

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
