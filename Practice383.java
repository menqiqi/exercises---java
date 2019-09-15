import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */

public class Practice383 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] push = {1,2,3,4,5};
        int[] pop = {4,3,5,1,2};
        System.out.println(solution.IsPopOrder(push,pop));
    }
}


class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int index1 = 0;
        int index2 = 0;
        int len = pushA.length;
        while(index2 < len){
            if(index1 < len && pushA[index1] == popA[index2]){
                index1++;
                index2++;
            }else{
                if(stack.isEmpty()){
                    stack.push(pushA[index1]);
                    index1++;
                }else{
                    int num = stack.pop();
                    stack.push(num);
                    if(num == popA[index2]){
                        stack.pop();
                        index2++;
                    }else{
                        if(index1 == len && num != popA[index2]){
                            return false;
                        }
                        stack.push(pushA[index1]);
                        index1++;
                    }
                }
            }
        }
        return true;
    }
}
