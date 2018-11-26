package www.bit.java;

/**
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 *
 * -1 : 我的数字比较小
 *  1 : 我的数字比较大
 *  0 : 恭喜！你猜对了！
 *
 * 示例 :
 *
 * 输入: n = 10, pick = 6
 * 输出: 6
 */

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int mid = 0;
        while(left<=right){
            mid = left + (right-left)/2;
            if(guess(mid)==0) return mid;
            else if(guess(mid)==1) left = mid+1;
            else if(guess(mid)==-1) right = mid-1;
        }
        return mid;
    }
}

public class practice17 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            line = in.readLine();
            int pick = Integer.parseInt(line);

            int ret = new Solution().guessNumber(n, pick);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

}
