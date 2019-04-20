import java.util.Scanner;

/**
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 */

public class Practice251 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String[] data = in.nextLine().split(" ");
            int left = 0, right = data.length-1;
            while (left < right){
                String tmp = data[left];
                data[left] = data[right];
                data[right] = tmp;

                left++;
                right--;
            }
            for (String str : data){
                System.out.print(str+" ");
            }
        }
        in.close();
    }
}
