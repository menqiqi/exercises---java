import java.util.Stack;

/**
 * 你现在是棒球比赛记录员。
 * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
 * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
 *
 * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
 * 你需要返回你在所有回合中得分的总和。
 *
 * 示例 :
 *
 * 输入: ["5","2","C","D","+"]
 * 输出: 30
 * 解释:
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到2分。总和是：7。
 * 操作1：第2轮的数据无效。总和是：5。
 * 第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
 * 第4轮：你可以得到5 + 10 = 15分。总数是：30。
 */

class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < ops.length; i++){
            if(ops[i].equals("+")){
                //移除栈顶元素并记录值
                int pre = stack.pop();
                //记录当前栈顶元素的值
                int prepre = stack.peek();
                //将移除的元素入栈
                stack.push(pre);
                //将前两轮之和入栈
                stack.push(pre+prepre);
            }else if(ops[i].equals("D")){
                //本轮的分时前一轮的两倍
                stack.push(stack.peek() * 2);
            }else if(ops[i].equals("C")){
                //前一轮无效得分，直接出栈
                stack.pop();
            }else{
                stack.push(Integer.parseInt(ops[i]));
            }
        }
        //记录栈内数据的数量，计算出总和
        int len = stack.size();
        for(int i = 0; i < len; i++)
            sum = sum + stack.pop();
        return sum;
    }
}

//注：stack.Pop与stack.Peek的区别
//两者都返回栈顶的值，但是Pop会删除栈顶的值，Peek不会删除

public class Practice62 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] data = new String[]{"5","2","C","D","+"};
        System.out.println(solution.calPoints(data));
    }
}