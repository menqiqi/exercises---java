import java.util.Scanner;

/**
 * 最长区间
 *
 * 拉齐有一个01序列，他可以对这个序列进行任意多次变换，每次变换都是把序列的最后若干个元素放到最前面，
 * 例如：010011，将最后3个元素011放到最前面，序列变为011010。
 * 所有变换结束后，拉齐需要挑出一个全为1的连续区间，要求最大化区间长度。
 */

public class Practice238 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            if (str == ""){
                System.out.println(0);
                return;
            }

            //先遍历一遍str，找到最大长度
            int count = 0;
            int max = 0;
            for (int i = 0; i < str.length(); i++){
                if (str.charAt(i) == '1'){
                    count++;
                }else {
                    if (count > max){
                        max = count;
                    }
                    count = 0;
                }
            }
            if (count == str.length()){
                System.out.println(str.length());
                return;
            }

            int first = 0, last = str.length()-1;  //分别为字符串首部和尾部的下标
            if (str.charAt(first) == '0' && str.charAt(last) == '0'){
                System.out.println(0);
                return;
            }else if (str.charAt(first) == '1' && str.charAt(last) == '1'){
                //开头和结尾都需要查看
                int tmp = checkHead(str)+checkTail(str);
                if (tmp > max)
                    max = tmp;
            }else if (str.charAt(first) == '1' && str.charAt(last) == '0'){
                //只需要查看开头
                int tmp = checkHead(str);
                if (tmp > max)
                    max = tmp;
            }else {
                //只需要查看结尾
                int tmp = checkTail(str);
                if (tmp > max)
                    max = tmp;
            }
            System.out.println(max);
        }
    }

    private static int checkHead(String str){
        int i = 0;
        int count = 0;
        while (i < str.length()){
            if (str.charAt(i) == '1'){
                count++;
            }else {
                break;
            }
            i++;
        }
        return count;
    }

    private static int checkTail(String str){
        int j = str.length()-1;
        int count = 0;
        while (j >= 0){
            if (str.charAt(j) == '1'){
                count++;
            }else {
                break;
            }
            j--;
        }
        return count;
    }
}
