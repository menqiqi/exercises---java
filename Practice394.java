import javax.crypto.spec.DESedeKeySpec;
import java.util.*;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */

public class Practice394 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        ArrayList<String> res = Permutation(str);
        for (String s : res){
            System.out.print(s+" ");
        }
    }

    public static ArrayList<String> Permutation(String str){
        ArrayList<String> list = new ArrayList<>();
        if (str!=null && str.length()>0){
            DFS(str.toCharArray(),0,list);
            Collections.sort(list);
        }
        return list;
    }

    public static void DFS(char[] chars, int i, ArrayList<String> list){
        if (i == chars.length-1){
            list.add(String.valueOf(chars));
        }else {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < chars.length; j++){
                if (j==i || !set.contains(chars[j])){
                    set.add(chars[j]);
                    Swap(chars,i,j);
                    DFS(chars,i+1,list);
                    Swap(chars,j,i);
                }
            }
        }
    }

    public static void Swap(char[] t, int i, int j){
        char tmp = t[i];
        t[i] = t[j];
        t[j] = tmp;
    }
}
