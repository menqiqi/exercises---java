import java.util.Scanner;

//中心扩展算法
class Palindrome {
    public int getLongestPalindrome(String A, int n) {
        if(n == 0){
            return 0;
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            int len1 = maxLength(A,n,i,i);  //回文子串的长度为奇数
            int len2 = maxLength(A,n,i,i+1);  //回文子串的长度为偶数
            int len = Math.max(len1,len2);
            if(len > max){
                max = len;
            }
        }
        return max;
    }

    //返回最大长度
    public static int maxLength(String A, int n, int left, int right){
        while(left>=0 && right<n && A.charAt(left)==A.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}

public class Practice392 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.getLongestPalindrome(str,str.length()));
    }


}


