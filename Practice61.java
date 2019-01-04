import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。
 *
 * 示例：
 *
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 *
 *
 *
 * 注意：
 *
 *     你可以重复使用键盘上同一字符。
 *     你可以假设输入的字符串将只包含字母。
 */

class Solution {
    public String[] findWords(String[] words) {
        String[] keyboard = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keyboard.length; i++) {
            for (char c : keyboard[i].toCharArray()) {
                map.put(c, i);
            }
        }
        int index;
        for (String word :
                words) {
            index = map.get(word.toUpperCase().toCharArray()[0]);
            for (char c :
                    word.toUpperCase().toCharArray()) {
                if (map.get(c) != index) {
                    index = -1;
                    break;
                }
            }
            if (index != -1) {
                res.add(word);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}

public class Practice61 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = new String[]{"Hello","Alaska","Dad","Peace"};
        String[] res = solution.findWords(words);
        for(String tmp : res)
            System.out.print(tmp+" ");
    }
}
