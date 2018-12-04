/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 */

class Solution {
    public String reverseVowels(String s) {
        char[] data = s.toCharArray();
        int left = 0;
        int right = data.length-1;
        while(left < right){
            if(data[left]!='a'&&data[left]!='e'&&data[left]!='i'
                    &&data[left]!='o'&&data[left]!='u'&&data[left]!='A'
                    &&data[left]!='E'&&data[left]!='I'&&data[left]!='O'
                    &&data[left]!='U'){
                left++;
                continue;
            }
            if(data[right]!='a'&&data[right]!='e'&&data[right]!='i'
                    &&data[right]!='o'&&data[right]!='u'&&data[right]!='A'
                    &&data[right]!='E'&&data[right]!='I'&&data[right]!='O'
                    &&data[right]!='U'){
                right--;
                continue;
            }
            char tmp = data[left];
            data[left] = data[right];
            data[right] = tmp;
            left++;
            right--;
        }
        return new String(data);
    }
}

public class Practice30 {
    public static void main(String[] args) {
        String str = "aA";
        Solution solution = new Solution();
        System.out.println(solution.reverseVowels(str));
    }
}
