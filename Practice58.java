/**
 * 你和你的朋友，两个人一起玩 Nim游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
 *
 * 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: false
 * 解释: 如果堆中有 4 块石头，那么你永远不会赢得比赛；
 *      因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
 */

/**
 * 解题思路：
 *   如果最后剩四个石子，你作为先手，无论怎么拿都会输。
 *   如果想要赢，就要保证最后剩余石子的个数不为4的倍数。
 *   例如：不论剩1个2个还是3个石子，先手都可以赢，如果剩余4个，就是对手赢，依次类推。
 */

class Solution {
    public boolean canWinNim(int n) {
        if(n % 4 == 0){
            return false;
        }else{
            return true;
        }
    }
}

public class Practice58 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canWinNim(5));
        System.out.println(solution.canWinNim(16));
    }
}
