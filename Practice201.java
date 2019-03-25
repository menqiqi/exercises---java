import java.util.*;

/**
 * 小明春节收到了很多红包，他发现有一个红包的金额超过了红包总数的一半，请帮他找出这个红包。
 * 如果不存在这样的金额，输出0。
 */

class Gift {
    public int getValue(int[] gifts, int n) {
        // write code here
        Arrays.sort(gifts);
        int mid = n/2;
        int count = 0;
        for (int i = 0; i < n; i++){
            if (gifts[i] == gifts[mid])
                count++;
        }
        if (count > mid){
            return gifts[mid];
        }
        return 0;
    }
}

public class Practice201 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = Integer.parseInt(in.nextLine());
            String[] strings = in.nextLine().split(" ");
            int[] gifts = new int[n];
            for (int i = 0; i < n; i++){
                gifts[i] = Integer.parseInt(strings[i]);
            }
            Gift gift = new Gift();
            System.out.println(gift.getValue(gifts,n));
        }
    }
}
