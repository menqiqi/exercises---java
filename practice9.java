package www.bit.java;

class Solution {
    public int numJewelsInStones(String J, String S) {
        char[] data1 = J.toCharArray();
        char[] data2 = S.toCharArray();
        int len1 = data1.length;
        int len2 = data2.length;
        int count = 0;
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(data1[i] == data2[j]){
                    count++;
                }
            }
        }
        return count;
    }
}

public class practice9 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numJewelsInStones("aA","aAAbbbbb"));
    }
}
