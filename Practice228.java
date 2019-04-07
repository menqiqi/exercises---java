import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 大整数排序
 * 对N个长度最长可达到1000的数进行排序
 * 升序
 */

public class Practice228 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] data = new String[n];
        for (int i = 0; i < n; i++){
            data[i] = bf.readLine();
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < (n-i-1); j++){
                if (compare(data[j],data[j+1])){
                    //data[i] > data[j]
                    String tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }
        for (String str : data){
            System.out.println(str);
        }
    }

    //实现两个数之间的比较
    private static boolean compare(String x, String y){
        if (x.length() > y.length()){
            return true;
        }else if (x.length() < y.length()){
            return false;
        }else {
            //从最高位开始比较
            int index = 0;
            while (index < x.length()){
                if (x.charAt(index) > y.charAt(index)){
                    return true;
                }else if (x.charAt(index) < y.charAt(index)){
                    return false;
                }
                index++;
            }
        }
        return false;
    }
}
