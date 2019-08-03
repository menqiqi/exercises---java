import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 小易在学校学习了有关字符串的理论，所以他基于此完成了一个字典的项目。
 * 小易的这个字典很奇特，字典内的每个单词都包含n个‘a'和m个'z'，并且所有单词按照字典序排列。
 * 小易现在希望你能帮他找出第k个单词是什么。
 *
 * 输入：
 * n m k
 * 输出：
 * 第k个单词，若没有，则返回-1
 */


public class Practice325 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();  //a的个数
        int m = in.nextInt();  //z的个数
        int k = in.nextInt();
        List<String> list = new ArrayList<>();
        String str = "";
        des(n,m,k,list,str);
        if (list.size() < k){
            System.out.println(-1);
        }else {
            System.out.println(list.get(k-1));
        }
    }

    public static void des(int n, int m, int k, List<String> list, String str){
        if (m == 0 && n == 0){
            list.add(str);
            if (list.size() == k){
                return;
            }
        }
        if (n > 0){
            des(n-1, m, k, list, str+'a');
        }
        if (m > 0){
            des(n, m-1, k, list, str+'z');
        }
    }
}
