/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 *     I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 *     X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 *     C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 *
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: "III"
 *
 * 示例 2:
 *
 * 输入: 4
 * 输出: "IV"
 */

class Solution {
    public String intToRoman(int num) {
        int cur = num;
        String res = "";
        while(cur > 0){
            if(cur/1000 != 0){
                res = res+"M";
                cur = cur - 1000;
            }
            else if(cur/900 != 0){
                res = res+"CM";
                cur = cur - 900;
            }
            else if(cur/500 != 0){
                res = res+"D";
                cur = cur - 500;
            }
            else if(cur/400 != 0){
                res = res+"CD";
                cur = cur - 400;
            }
            else if(cur/100 != 0){
                res = res+"C";
                cur = cur - 100;
            }
            else if(cur/90 != 0){
                res = res+"XC";
                cur = cur - 90;
            }
            else if(cur/50 != 0){
                res = res+"L";
                cur = cur - 50;
            }
            else if(cur/40 != 0){
                res = res+"XL";
                cur = cur - 40;
            }
            else if(cur/10 != 0){
                res = res+"X";
                cur = cur - 10;
            }
            else if(cur/9 != 0){
                res = res+"IX";
                cur = cur - 90;
            }
            else if(cur/5 != 0){
                res = res+"V";
                cur = cur - 5;
            }
            else if(cur/4 != 0){
                res = res+"IV";
                cur = cur - 4;
            }
            else if(cur/1 != 0){
                res = res+"I";
                cur = cur - 1;
            }
        }
        return res;
    }
}

public class Practice118 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(4));
        System.out.println(solution.intToRoman(200));
        System.out.println(solution.intToRoman(2999));

    }
}
