/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * For example, given s ="aab",
 * Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.
 */


public class Practice279 {
    public int minCut(String s) {
        char[] chs = s.toCharArray();
        int[] dp = new int[chs.length + 1];
        for(int i = 0; i < dp.length; ++i) dp[i] = i - 1;
        for(int i = 0; i < chs.length; ++i) {
            expand(chs, i, i, dp);
            expand(chs, i, i + 1, dp);
        }
        return dp[chs.length];
    }

    private void expand(char[] chs, int i, int j, int[] dp) {
        while(i >= 0 && j < chs.length && chs[i] == chs[j]) {
            dp[j + 1] = Math.min(dp[j + 1], dp[i] + 1);
            --i;
            ++j;
        }
        return;
    }
}
