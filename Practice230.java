import java.util.Scanner;

/**
 * 说反话
 *
 * 给定一句英语，要求你编写程序，将句中所有的单词颠倒输出。
 */

/*
public class Practice230 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String[] strings = in.nextLine().split(" ");
            int left = 0;
            int right = strings.length-1;
            while (left < right){
                String tmp = strings[left];
                strings[left] = strings[right];
                strings[right] = tmp;
                left++;
                right--;
            }
            for (String s : strings)
                System.out.print(s+" ");
        }
        in.close();
    }


}
*/
