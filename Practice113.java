/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 :
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 */


/*//暴力破解法
class Solution {
    public int maxProfit(int[] prices) {
        return cal(prices,0);
    }

    private int cal(int[] prices, int k){
        if(k >= prices.length)
            return 0;
        int max = 0;
        for(int start = k; start < prices.length; start++){
            int maxProfit = 0;
            for(int i = start+1; i < prices.length; i++){
                if(prices[start] < prices[i]){
                    int profit = cal(prices,i+1)+prices[i]-prices[start];
                    if(profit > maxProfit)
                        maxProfit = profit;
                }
            }
            if(maxProfit > max)
                max = maxProfit;
        }
        return max;
    }
}*/

/*class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        int i = 0;
        int valley = prices[0];  //谷
        int peak = prices[0];  //峰
        int maxProfit = 0;
        while(i < prices.length-1){
            if(i < prices.length-1 && prices[i] >= prices[i+1])
                i++;
            valley = prices[i];
            if(i < prices.length-1 && prices[i] <= prices[i+1])
                i++;
            peak = prices[i];
            maxProfit += peak - valley;
        }
        return maxProfit;
    }
}*/

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
}

public class Practice113 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
