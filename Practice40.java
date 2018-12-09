/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。
 * 如果不存在，则返回 -1。
 */

class Solution {
    public int firstUniqChar(String s) {
        char[] data = s.toCharArray();
        if(data.length == 1){
            return 0;
        }
        int flag = 0; //标记位
        for(int i = 0; i < data.length ; i++){
            flag = 0;
            if(data[i] != '0'){
                for(int j = i+1; j < data.length; j++){
                    if(data[i] == data[j]){
                        flag = 1;
                        int tmp = data[i];
                        for(int k = i; k < data.length; k++){
                            if(data[k] == tmp)
                                data[k] = '0';
                        }
                        break;
                    }
                }
            }
            if(flag == 0 && data[i] != '0')
                return i;
        }
        return -1;
    }
}

public class Practice40 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("dddccdbba"));
    }
}
