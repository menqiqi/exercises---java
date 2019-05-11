/**
 * 牛牛想尝试一些新的料理，每个料理需要一些不同的材料，问完成所有的料理需要准备多少种不同的材料。
 * 输入描述:
 * 每个输入包含 1 个测试用例。每个测试用例的第 i 行，表示完成第 i 件料理需要哪些材料，各个材料用空格隔开，输入只包含大写英文字母和空格，输入文件不超过 50 行，每一行不超过 50 个字符。
 * 输出描述:
 * 输出一行一个数字表示完成所有料理需要多少种不同的材料。
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
public class Practice291 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<String>();
        String str = br.readLine();
        while(str!=null){
            String[] s = str.trim().split(" ");
            for(int i=0;i<s.length;i++){
                set.add(s[i]);
            }
            str = br.readLine();
        }
        System.out.println(set.size());
    }

}
