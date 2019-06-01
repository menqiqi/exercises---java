import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * 给定一个k位整数N = dk-1*10k-1 + ... + d1*101 + d0 (0<=di<=9, i=0,...,k-1, dk-1>0)，
 * 请编写程序统计每种不同的个位数字出现的次数。例如：给定N = 100311，则有2个0，3个1，和1个3
 */

public class Practice307 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            HashMap<Integer, Integer> map = new HashMap<>();
            String num = in.next();
            for (int i = 0; i < num.length(); i++){
                int n = Integer.parseInt(String.valueOf(num.charAt(i)));
                if (map.keySet().contains(n)){
                    //当map中包含这个数的时候，直接给个数加一
                    int count = map.get(n)+1;
                    map.put(n,count);
                }else {
                    map.put(n,1);
                }
            }
            int[] key = new int[map.size()];
            int index = 0;
            for (int t : map.keySet()){
                key[index++] = t;
            }
            Arrays.sort(key);

            for (int i = 0; i < key.length; i++){
                int value = map.get(key[i]);
                System.out.println(key[i]+":"+value);
            }

        }
    }
}
