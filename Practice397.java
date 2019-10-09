/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */

public class Practice397 {
    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(1));
    }

    public static int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0){
            return 0;
        }
        int count = 0;
        for(int i = 1; i <= n; i*=10){
            //(n / (i * 10)) * i + (if(k > i * 2 - 1) i else if(k < i) 0 else k - i + 1)
            int a = n/(i*10) * i;
            int k = n%(i*10);
            if(k < i){
                a += 0;
            }else if(k > (i*2-1)){
                a += i;
            }else{
                a += (k-i+1);
            }
            count += a;
        }
        return count;
    }
}
